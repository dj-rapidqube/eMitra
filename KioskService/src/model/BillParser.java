package model;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import utils.Constants;

public class BillParser {

    private static final Logger logger = Logger.getLogger(BillParser.class);

    public static String objToStr(Bill bill) {
        try {
            StringBuilder builder = new StringBuilder();

            builder.append(bill.getBackToBackTransactionID()).append(Constants.PIPE);
            builder.append(bill.getTransactionId()).append(Constants.PIPE);
            builder.append(bill.getServiceProviderID()).append(Constants.PIPE);
            builder.append(bill.getBillAmount()).append(Constants.PIPE);
            builder.append(bill.getLocalLogStatus()).append(Constants.PIPE);
            builder.append(bill.getSsoID()).append(Constants.PIPE);
            builder.append(bill.getrECEIPTNO()).append(Constants.PIPE);
            builder.append(bill.geteMITRATIMESTAMP()).append(Constants.PIPE);
            builder.append(bill.gettRANSACTIONSTATUS()).append(Constants.PIPE);
            builder.append(bill.getvERIFYSTATUSCODE()).append(Constants.PIPE);
            builder.append(bill.getmSG());

            return builder.toString();
        } catch (Exception ex) {
            logger.error("Caught an exception while creating string from object", ex);
        }

        return null;
    }

    public static Bill strToObj(String transactionDetailStr) throws Exception {
        try {
            Bill billDetails = new Bill();
            String[] transactionDetailArr = transactionDetailStr.split(Pattern.quote(Constants.PIPE));

            billDetails.setBackToBackTransactionID(transactionDetailArr[0]);
            billDetails.setTransactionId(transactionDetailArr[1]);
            if (StringUtils.isBlank(transactionDetailArr[2])) {
                billDetails.setServiceProviderID(0);
            } else {
                billDetails.setServiceProviderID(Integer.valueOf(transactionDetailArr[2]));
            }
            billDetails.setBillAmount(transactionDetailArr[3]);

            if (transactionDetailArr.length >= 5) {
                billDetails.setLocalLogStatus(transactionDetailArr[4]);
            }

            if (transactionDetailArr.length >= 6) {
                billDetails.setSsoID(transactionDetailArr[5]);
            }

            if (transactionDetailArr.length >= 7) {
                billDetails.setrECEIPTNO(transactionDetailArr[6]);
            }

            if (transactionDetailArr.length >= 8) {
                billDetails.seteMITRATIMESTAMP(transactionDetailArr[7]);
            }

            if (transactionDetailArr.length >= 9) {
                billDetails.settRANSACTIONSTATUS(transactionDetailArr[8]);
            }

            if (transactionDetailArr.length >= 10) {
                billDetails.setvERIFYSTATUSCODE(transactionDetailArr[9]);
            }

            if (transactionDetailArr.length >= 11) {
                billDetails.setmSG(transactionDetailArr[10]);
            }

            return billDetails;
        } catch (Exception ex) {
            logger.error("Caught an exception while parsing transactionStr: " + transactionDetailStr, ex);
        }

        return null;
    }
}
