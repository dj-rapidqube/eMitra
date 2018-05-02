package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.EncryptDecryptDAO;
import model.Bill;
import model.Discom;
import model.Phed;
import webServicesRepository.utility.EncrptDesryptDataService;

@Service("encryptDecryptService")
public class EncryptDecryptServiceImpl implements EncryptDecryptService{
	
//	private final String decryptURL = "http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/emitraAESDecryption";
	private final String decryptURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/emitraAESDecryption";
//	private final String USER_AGENT = "Mozilla/5.0";
	
	@Autowired
	private EncryptDecryptDAO encryptDecryptDAO;
	
	static final Logger logger = Logger.getLogger(EncryptDecryptServiceImpl.class);
	
	/*@Override
	@Transactional
	public List<Bill> sendPostForDecryptDetail(String encryptDetails,Bill bill) {
		
		StringBuffer response = new StringBuffer();
		List<Bill> details=new ArrayList<Bill>();
		try {
			URL obj = new URL(decryptURL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	
			String urlParameters = "toBeDecrypt=" + encryptDetails;
	
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
	
			int responseCode = con.getResponseCode();
			logger.info("sendPostForDecryptDetail, responseCode : "+responseCode);
			//System.out.println("\nSending 'POST' request to URL : " + decryptURL);
			//System.out.println("Post parameters : " + urlParameters);
			//System.out.println("Response Code : " + responseCode);
	
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
		//	System.out.println("Result "+response.toString());
			logger.info("sendPostForDecryptDetail, SERVICE PROVIDER ID :"+bill.getServiceProviderID());
			
			String apiResult=response.toString();
			logger.info("sendPostForDecryptDetail, API Result:"+apiResult);
			
			if(bill.getServiceProviderID()==1214) {
				//details=airtelDetails(apiResult,bill);
				logger.info("sendPostForDecryptDetail, AIRTEL BACKTOBACK API Result:"+  response.toString());
				details = encryptDecryptDAO.getAirtelDetails(apiResult,bill);
			}
			else if(bill.getServiceProviderID()==1220) {
				logger.info("sendPostForDecryptDetail, IDEA BACKTOBACK API Result:"+  response.toString());
			//	details=ideaDetails(apiResult,bill);
				details = encryptDecryptDAO.getIdeaDetails(apiResult,bill);
			}else if(bill.getServiceProviderID()==1219) {
			//	details = vodafoneDetails(apiResult,bill);
				logger.info("sendPostForDecryptDetail, Vodaphone BACKTOBACK API Result:"+  response.toString());
				details = encryptDecryptDAO.getVodafoneDetails(apiResult,bill);
			}else if(bill.getServiceProviderID()==2575) {
				//	details = vodafoneDetails(apiResult,bill);
				logger.info("sendPostForDecryptDetail, BSNL BACKTOBACK API Result:"+  response.toString());
				details = encryptDecryptDAO.getBsnlDetails(apiResult,bill);
			}
		}
		catch (Exception e) {
			logger.error("Exception in sendPostForDecryptDetail :"+e.getMessage());
			e.printStackTrace();
		}
	    
		return details;
		
	}*/
	
	
	//Optimized code
	
	@Override
	@Transactional
	public List<Bill> sendPostForDecryptDetail(String encryptDetails,Bill bill) {
		
		EncrptDesryptDataService service = new EncrptDesryptDataService();
		String methodName = "sendPostForDecryptDetail";
		String decryptResponse =  service.getPOSTResponse(methodName, encryptDetails, "toBeDecrypt", decryptURL);
		List<Bill> details=new ArrayList<Bill>();
		logger.info(methodName+", SERVICE PROVIDER ID :"+bill.getServiceProviderID());
		logger.info(methodName+", API Result:"+decryptResponse);
		
		switch(bill.getServiceProviderID()) {
			case 1214:
				logger.info(methodName+", AIRTEL BACKTOBACK API Result:"+  decryptResponse);
				details = encryptDecryptDAO.getAirtelDetails(decryptResponse,bill);
				break;
			case 1220:
				logger.info(methodName+", IDEA BACKTOBACK API Result:"+  decryptResponse);
				details = encryptDecryptDAO.getIdeaDetails(decryptResponse,bill);
				break;
			case 1219:
				logger.info(methodName+", Vodaphone BACKTOBACK API Result:"+  decryptResponse);
				details = encryptDecryptDAO.getVodafoneDetails(decryptResponse,bill);
				break;
			case 2575:
				logger.info(methodName+", BSNL BACKTOBACK API Result:"+  decryptResponse);
				details = encryptDecryptDAO.getBsnlDetails(decryptResponse,bill);
				break;
		}
		
		return details;
		
	}
	
	
	/*@Override
	@Transactional
	public List<Discom> sendPostForDiscomDecryptData(String encryptDetails, Bill bill, Discom discom){
		StringBuffer response = new StringBuffer();
		List<Discom> discomdetail = new ArrayList<Discom>();
		try {
			URL obj = new URL(decryptURL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "toBeDecrypt=" + encryptDetails;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			// System.out.println("\nSending 'POST' request to URL : " + decryptURL);
			// System.out.println("Post parameters : " + urlParameters);
			// System.out.println("Response Code : " + responseCode);
			logger.info("sendPostForDiscomDecryptData, Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//logger.info("sendPostForDiscomDecryptData, response :: " + response.toString());
			logger.info("sendPostForDecryptDetail, Discom BACKTOBACK API Result:"+  response.toString());
			logger.info("sendPostForDiscomDecryptData, SERVICE PROVIDER ID :" + bill.getServiceProviderID());
			discomdetail =  encryptDecryptDAO.getDiscomDetails(response.toString(), bill, discom);
			
		} catch (Exception e) {
			logger.error("Exception in sendPostForDiscomDecryptData :"+e.getMessage());
			e.printStackTrace();
		}

		return discomdetail;

	}*/
	
	
	//Optimized code
	@Override
	@Transactional
	public List<Discom> sendPostForDiscomDecryptData(String encryptDetails, Bill bill, Discom discom){
		
		EncrptDesryptDataService service = new EncrptDesryptDataService();
		String methodName = "sendPostForDiscomDecryptData";
		String discomDecryptResponse =  service.getPOSTResponse(methodName, encryptDetails, "toBeDecrypt", decryptURL);
		
		List<Discom> discomdetail = new ArrayList<Discom>();
		logger.info(methodName+", Discom BACKTOBACK API Result:"+  discomDecryptResponse);
		logger.info(methodName+", SERVICE PROVIDER ID :" + bill.getServiceProviderID());
		discomdetail =  encryptDecryptDAO.getDiscomDetails(discomDecryptResponse, bill, discom);

		return discomdetail;

	}
	
	
	/*@Override
	@Transactional
	public List<Phed> sendPostForPhedDecryptData(String encryptDetails, Bill bill, Phed ph) {
		StringBuffer response = new StringBuffer();
		List<Phed> pheddetail=new ArrayList<Phed>();
		try {
			URL obj = new URL(decryptURL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
			String urlParameters = "toBeDecrypt=" + encryptDetails;
		
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
		
			int responseCode = con.getResponseCode();
			logger.info("sendPostForPhedDecryptData, Response Code :" + responseCode);
			//System.out.println("\nSending 'POST' request to URL : " + decryptURL);
			//System.out.println("Post parameters : " + urlParameters);
			//System.out.println("Response Code : " + responseCode);
		
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
		
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			logger.info("sendPostForPhedDecryptData, PHED BACKTOBACK API Details : "+response.toString());
			
			logger.info("sendPostForPhedDecryptData, SERVICE PROVIDER ID :"+bill.getServiceProviderID());
			String y=response.toString();
			pheddetail = encryptDecryptDAO.getPhedDetails(y, bill, ph);
		}
		catch (Exception e) {
			logger.error("Exception in sendPostForPhedDecryptData : " + e.getMessage());
			e.printStackTrace();
		}
		
		return pheddetail;
		
	}*/
	
	
	//Optimized code
	@Override
	@Transactional
	public List<Phed> sendPostForPhedDecryptData(String encryptDetails, Bill bill, Phed ph) {
		
		List<Phed> pheddetail = new ArrayList<Phed>();
		EncrptDesryptDataService service = new EncrptDesryptDataService();
		String methodName = "sendPostForPhedDecryptData";
		String phedDecryptResponse =  service.getPOSTResponse(methodName, encryptDetails, "toBeDecrypt", decryptURL);
		logger.info("sendPostForPhedDecryptData, PHED BACKTOBACK API Details : "+phedDecryptResponse.toString());
		logger.info("sendPostForPhedDecryptData, SERVICE PROVIDER ID :"+bill.getServiceProviderID());
		pheddetail = encryptDecryptDAO.getPhedDetails(phedDecryptResponse, bill, ph);
		return pheddetail;
		
	}
	
	
	@Override
	@Transactional
	public String getGovtServiceDetail(String encryptURL) {

		EncrptDesryptDataService service = new EncrptDesryptDataService();
		String methodName = "getGovtServiceDetail";
		return service.getGETResponse(methodName, encryptURL);
	}


	@Override
	@Transactional
	public String getPDFPrinted(String encryptURL) {

		EncrptDesryptDataService service = new EncrptDesryptDataService();
		String methodName = "getPDFPrinted";
		return service.getGETResponse(methodName, encryptURL);
		
	}
	
	/*@Override
	@Transactional
	public Bill tokenVerficationDetails(String tokenVerfiyURl,String transId) {
		Bill tr = new Bill();
		try {

			URL obj = new URL(tokenVerfiyURl);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			// con.setRequestProperty("Accept","");
			con.setDoOutput(true);
			// con.setRequestProperty("Accept","");
		//	String param = "{\"TRANSACTIONID\":\"" +transId + "\",\"MERCHANTCODE\":\"BHAM0616\"}";
			String param = "{\"TRANSACTIONID\":\"" +transId + "\",\"MERCHANTCODE\":\"EMITRAPLUS\"}";
			String urlParameters = "data=" + param;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			// System.out.println("\nSending 'POST' request to URL : " + encryptURL);
			logger.info("tokenVerficationDetails, Post parameters : " + urlParameters);
			logger.info("tokenVerficationDetails, Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			String trans = response.toString();
		//	System.out.println("Complete String:::" + trans);
			JSONParser parser = new JSONParser();

			JSONObject json = (JSONObject) parser.parse(trans);
			String transactionDate = (String) json.get("TRANSACTIONDATE");
			String RECEIPTNO = (String) json.get("RECEIPTNO");
			String TRANSACTIONID = (String) json.get("TRANSACTIONID");
			String AMT = (String) json.get("AMT");
			String EMITRATIMESTAMP = (String) json.get("EMITRATIMESTAMP");
			String TRANSACTIONSTATUS = (String) json.get("TRANSACTIONSTATUS");
			String VERIFYSTATUSCODE = (String) json.get("VERIFYSTATUSCODE");
			String MSG = (String) json.get("MSG");
			String DEPTNAME = (String) json.get("DEPTNAME");
			String SRVNAME = (String) json.get("SRVNAME");
			
			tr.setTransactionDate(transactionDate);
			tr.setrECEIPTNO(RECEIPTNO);
			tr.setTransactionId(TRANSACTIONID);
			tr.setaMT(AMT);
			tr.seteMITRATIMESTAMP(EMITRATIMESTAMP);
			tr.settRANSACTIONSTATUS(TRANSACTIONSTATUS);
			tr.setvERIFYSTATUSCODE(VERIFYSTATUSCODE);
			tr.setmSG(MSG);
			tr.setdEPTNAME(DEPTNAME);
			tr.setsRVNAME(SRVNAME);
		}
		catch(Exception e) {
			logger.error("Exception in tokenVerficationDetails :"+e.getMessage());
			e.printStackTrace();
		}
		return tr;
	}*/
	
	//Optimized code
	@Override
	@Transactional
	public Bill tokenVerficationDetails(String tokenVerfiyURl,String transId) {
		
		EncrptDesryptDataService service = new EncrptDesryptDataService();
		String methodName = "tokenVerficationDetails";
		//String param = "{\"TRANSACTIONID\":\"" +transId + "\",\"MERCHANTCODE\":\"BHAM0616\"}";
		String param = "{\"TRANSACTIONID\":\"" +transId + "\",\"MERCHANTCODE\":\"EMITRAPLUS\"}";
		String tokenVerficationResponse =  service.getPOSTResponse(methodName, param, "data", tokenVerfiyURl);
		Bill bill = null;
		
		try {
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(tokenVerficationResponse);
			String transactionDate = (String) json.get("TRANSACTIONDATE");
			String RECEIPTNO = (String) json.get("RECEIPTNO");
			String TRANSACTIONID = (String) json.get("TRANSACTIONID");
			String AMT = (String) json.get("AMT");
			String EMITRATIMESTAMP = (String) json.get("EMITRATIMESTAMP");
			String TRANSACTIONSTATUS = (String) json.get("TRANSACTIONSTATUS");
			String VERIFYSTATUSCODE = (String) json.get("VERIFYSTATUSCODE");
			String MSG = (String) json.get("MSG");
			String DEPTNAME = (String) json.get("DEPTNAME");
			String SRVNAME = (String) json.get("SRVNAME");
			
			bill = new Bill();
			bill.setTransactionDate(transactionDate);
			bill.setrECEIPTNO(RECEIPTNO);
			bill.setTransactionId(TRANSACTIONID);
			bill.setaMT(AMT);
			bill.seteMITRATIMESTAMP(EMITRATIMESTAMP);
			bill.settRANSACTIONSTATUS(TRANSACTIONSTATUS);
			bill.setvERIFYSTATUSCODE(VERIFYSTATUSCODE);
			bill.setmSG(MSG);
			bill.setdEPTNAME(DEPTNAME);
			bill.setsRVNAME(SRVNAME);
			
		}catch(Exception e) {
			logger.error("Exception in tokenVerficationDetails while parsing response in Json or Stroing response data :"+e.getMessage());
			e.printStackTrace();
		}
		
		return bill;
		
	}


	@Override
	@Transactional
	public String getAadharNumber(String response) {
		
		String aadharNumber = null;
		
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(response);
			aadharNumber = (String) json.get("AADHARNUMBER");
			
		}catch(Exception e) {}
		
		return aadharNumber;
	}
	

}
