package locallogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import model.Bill;
import model.BillParser;
import model.HTTPServiceResponse;
import model.Login;
import service.BillService;
import utils.Constants;
import utils.HttpClientUtils;
import utils.TimeUtils;

@Component
public class LocalLogSyncer {

    @Value("${local.log.file.prefix}")
    private String logFilePrefix;

    @Value("${local.log.file.location}")
    private String logFileLocation;

    @Value("${local.log.cancellation.endpoint}")
    private String cancellationEndpoint;

    @Autowired
    BillService billService;

    @Autowired
    HttpClientUtils httpClientUtils;

    private static final String EMITRA_PLUS_DB_INSERTED = "EmitraPlusDBInserted";
    private static final String TRANSACTION_CANCELED_ON_EMITRA = "TransactionCanceledOnEmitra";
    private static final String EMITRA_PLUS_DB_UPDATED = "EmitraPlusDBUpdated";

    private static final Logger logger = Logger.getLogger(LocalLogSyncer.class);

    @PostConstruct
    public void init() throws Exception {
        if (!StringUtils.endsWith(logFileLocation, Constants.FORWARD_SLASH)) {
            logFileLocation += (Constants.FORWARD_SLASH);
        }

        if (!StringUtils.endsWith(cancellationEndpoint, Constants.FORWARD_SLASH)) {
            cancellationEndpoint += (Constants.FORWARD_SLASH);
        }
    }

    private String getLogFileAbsoluteName(long currentHour) {
        StringBuilder fileNameBuilder = new StringBuilder(logFileLocation);
        fileNameBuilder.append(logFilePrefix).append(Constants.HYPHEN).append(currentHour);
        fileNameBuilder.append(Constants.EXTENSION_TXT);
        return fileNameBuilder.toString();
    }

    private boolean fileExistForThisHour(String logFileAbsoluteName) {
        File localLogFile = new File(logFileAbsoluteName);
        if (localLogFile.exists()) {
            return true;
        }

        try {
            // creating all the required dirs if not already created
            localLogFile.getParentFile().mkdirs();
            return localLogFile.createNewFile();
        } catch (Exception ex) {
            logger.error("Caught an exception while creating file: " + logFileAbsoluteName, ex);
        }

        return false;
    }

    private boolean deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (File file : children) {
                if (!deleteDirectory(file)) {
                    return false;
                }
            }
        }

        logger.error("Deleting invalid directory[" + dir.getPath() + "]");
        return dir.delete();
    }

    private Bill getTransactionDetails(String transactionDetail) {

        try {
            Bill billDetails = new Bill();
            String[] transactionDetailArr = transactionDetail.split(Pattern.quote(Constants.PIPE));
            billDetails.setBackToBackTransactionID(transactionDetailArr[0]);
            billDetails.setTransactionId(transactionDetailArr[1]);
            if (StringUtils.isBlank(transactionDetailArr[2])) {
                billDetails.setServiceProviderID(0);
            } else {
                billDetails.setServiceProviderID(Integer.valueOf(transactionDetailArr[2]));
            }
            billDetails.setBillAmount(transactionDetailArr[3]);

            return billDetails;
        } catch (Exception ex) {
            logger.error("Caught an excpetion while parsing the transactionDetail: " + transactionDetail, ex);
        }

        return null;
    }

    private String getCancellationUrl(Bill billDetails) {
        StringBuilder builder = new StringBuilder(cancellationEndpoint);

        builder.append(billDetails.getBackToBackTransactionID()).append(Constants.FORWARD_SLASH);
        builder.append(billDetails.getTransactionId());

        return builder.toString();
    }

    private boolean transactionCancelledOnEmitra(Bill billDetails) {
        String cancellationUrl = getCancellationUrl(billDetails);
        HttpPost method = new HttpPost(cancellationUrl);
        try {
            HTTPServiceResponse postResponse = httpClientUtils.getServiceResponse(method);
            if (HttpStatus.SC_OK == postResponse.getStatus()) {
                String dencryptedCTResponse = postResponse.getBody();
                org.json.JSONObject jsonObj = new org.json.JSONObject(dencryptedCTResponse);

                // billDetails.setLocalLogStatus(TRANSACTION_CANCELED_ON_EMITRA);
                billDetails.setrECEIPTNO(jsonObj.optString("RECEIPTNO"));
                billDetails.seteMITRATIMESTAMP(jsonObj.optString("EMITRATIMESTAMP"));
                billDetails.settRANSACTIONSTATUS(jsonObj.optString("CANCELSTATUS"));
                billDetails.setvERIFYSTATUSCODE(jsonObj.optString("CANCELSTATUSCODE"));
                billDetails.setmSG(jsonObj.optString("MSG"));

                return true;
            }
        } catch (Exception ex) {
            logger.error("Caught an exception while cancelling transaction on emitra", ex);
        }

        return false;
    }

    public void writeToLocalLogs(String emitraTransactionId, String requestId, String serviceId, String amount) throws Exception {
        logger.info("transactionId: " + emitraTransactionId + ", requestId: " + requestId + ", serviceId: " + serviceId + ", amount: " + amount);
        if (StringUtils.isBlank(emitraTransactionId) || StringUtils.isBlank(requestId)) {
            throw new Exception("Either transactionId OR requestId IS NULL !!");
        }

        long currentHour = TimeUtils.getCurrentHour();
        String logFileAbsoluteName = getLogFileAbsoluteName(currentHour);
        if (!fileExistForThisHour(logFileAbsoluteName)) {
            throw new Exception("File[" + logFileAbsoluteName + "] NOT Found !!");
        }

        StringBuilder transDetailsBuilder = new StringBuilder(emitraTransactionId);
        transDetailsBuilder.append(Constants.PIPE).append(requestId);
        transDetailsBuilder.append(Constants.PIPE).append(serviceId);
        transDetailsBuilder.append(Constants.PIPE).append(amount);
        transDetailsBuilder.append(Constants.NEW_LINE);

        // let the caller know if there is some exception while writing to the logs, so that it can be handled properly
        Files.write(Paths.get(logFileAbsoluteName), transDetailsBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    @Scheduled(fixedRate = 2 * TimeUtils.MS_PER_HOUR, initialDelay = 1 * TimeUtils.MS_PER_HOUR)
    public void scheduleSyncLocalLogs() {
        // Its a fkn bug in spring container
        // @Scheduled and any bean annotation initializes the bean twice
        // TODO - a better alternative, maybe a bit of code-refactoring
        synchronized (Constants.LOCK_OBJ) {
            File localLogDir = new File(logFileLocation);
            if (!localLogDir.exists() || !localLogDir.isDirectory()) {
                logger.error("LocalLogDirectory[" + logFileLocation + "] does not exist !!");
                return;
            }

            File[] files = localLogDir.listFiles();
            for (File file : files) {
                logger.info("processing file[" + file.getName() + "]");
                if (file.isDirectory() && deleteDirectory(file)) {
                    continue;
                }

                String fileName = file.getName();
                if (!fileName.contains(Constants.HYPHEN) || !fileName.contains(Constants.DOT)) {
                    logger.error("Invalid file[" + file.getName() + "] found, deleting it !!");
                    file.delete();
                    continue;
                }

                int indexOfLastHyphen = fileName.lastIndexOf(Constants.HYPHEN);
                int indexOfLastDot = fileName.lastIndexOf(Constants.DOT);
                if (indexOfLastHyphen > indexOfLastDot) {
                    logger.error("Invalid file[" + file.getName() + "] found, deleting it !!");
                    file.delete();
                    continue;
                }

                String hourStr = fileName.substring(indexOfLastHyphen + 1, indexOfLastDot);
                long hour = Long.valueOf(hourStr);
                if (hour >= TimeUtils.getCurrentHour()) {
                    continue;
                }

                // deleting files older than 2 days
                if (hour < (TimeUtils.getCurrentHour() - 48)) {
                    logger.error("file[" + file.getName() + "] older than 2 days, deleting it !!");
                    file.delete();
                    continue;
                }

                try {
                    String line = null;
                    List<String> transactionDetails = new ArrayList<>();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while ((line = bufferedReader.readLine()) != null) {
                        transactionDetails.add(line);
                    }
                    bufferedReader.close();

                    // try to cancel each transaction, if status == 200 & inserted into DB remove it from the list
                    ListIterator<String> listIter = transactionDetails.listIterator();
                    while (listIter.hasNext()) {
                        String transactionStr = listIter.next();
                        Bill billDetails = BillParser.strToObj(transactionStr);

                        if (null == billDetails) {
                            logger.error("Invalid transaction found in the file: " + fileName + ", transactionStr: " + transactionStr);
                            listIter.remove();
                            continue;
                        }

                        logger.info("Reverting transaction[" + transactionStr + "] on emitra");
                        if (StringUtils.isBlank(billDetails.getLocalLogStatus())) {
                            if (null == Login.SSOID) {
                                billDetails.setSsoID("0");
                            } else {
                                billDetails.setSsoID(Login.SSOID);
                            }
                            listIter.set(BillParser.objToStr(billDetails));

                            // updating the log file if DBInsert succeeded
                            if (billService.insertUntrackedEmitraTransaction(billDetails)) {
                                billDetails.setLocalLogStatus(EMITRA_PLUS_DB_INSERTED);
                                listIter.set(BillParser.objToStr(billDetails));

                                // updating the log file if transaction canceled successfully
                                if (transactionCancelledOnEmitra(billDetails)) {
                                    billDetails.setLocalLogStatus(TRANSACTION_CANCELED_ON_EMITRA);
                                    listIter.set(BillParser.objToStr(billDetails));

                                    // updating the log file if DBUpdate succeeded
                                    if (billService.updateUntrackedEmitraTransaction(billDetails)) {
                                        billDetails.setLocalLogStatus(EMITRA_PLUS_DB_UPDATED);
                                        listIter.set(BillParser.objToStr(billDetails));
                                        listIter.remove();
                                    }
                                }
                            }
                        } else if (EMITRA_PLUS_DB_INSERTED.equalsIgnoreCase(billDetails.getLocalLogStatus())) {
                            // updating the log file if transaction canceled successfully
                            if (transactionCancelledOnEmitra(billDetails)) {
                                billDetails.setLocalLogStatus(TRANSACTION_CANCELED_ON_EMITRA);
                                listIter.set(BillParser.objToStr(billDetails));

                                // updating the log file if DBUpdate succeeded
                                if (billService.updateUntrackedEmitraTransaction(billDetails)) {
                                    billDetails.setLocalLogStatus(EMITRA_PLUS_DB_UPDATED);
                                    listIter.set(BillParser.objToStr(billDetails));
                                    listIter.remove();
                                }
                            }
                        } else if (TRANSACTION_CANCELED_ON_EMITRA.equalsIgnoreCase(billDetails.getLocalLogStatus())) {
                            // updating the log file if DBUpdate succeeded
                            if (billService.updateUntrackedEmitraTransaction(billDetails)) {
                                billDetails.setLocalLogStatus(EMITRA_PLUS_DB_UPDATED);
                                listIter.set(BillParser.objToStr(billDetails));
                                listIter.remove();
                            }
                        } else {
                            listIter.remove();
                        }
                    }

                    // All the transactions were cancelled successfully
                    if (transactionDetails.isEmpty()) {
                        file.delete();
                    } else {
                        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
                        for (String transactionDetail : transactionDetails) {
                            printWriter.write(transactionDetail + Constants.NEW_LINE);
                        }

                        printWriter.flush();
                        printWriter.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
