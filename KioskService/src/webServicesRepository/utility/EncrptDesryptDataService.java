package webServicesRepository.utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Login;

public class EncrptDesryptDataService {

	static final Logger logger = Logger.getLogger(EncrptDesryptDataService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	private final String USER_AGENT = "Mozilla/5.0";
	// private final String USER_AGENT1 = "Mozilla/5.0 (Windows NT 5.1; rv:19.0)
	// Gecko/20100101 Firefox/19.0";
	// encrypt data required URL below

	// private final String encryptURL =
	// "http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/emitraAESEncryption";
	private final String encryptURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/emitraAESEncryption";

	// private final String billInfoURL =
	// "http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/getFetchDetailsEncryptedBySso";
	private final String billInfoURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getFetchDetailsEncryptedBySso";

	// encrypt data required URL below
	// private final String decryptURL =
	// "http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/emitraAESDecryption";
	private final String decryptURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/emitraAESDecryption";

	private final String checkSumURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/emitraMD5Checksum";

	// private final String
	// backToBackURL="https://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/backtobackTransactionWithEncryptionA";
	private final String backToBackURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/backtobackTransactionWithEncryptionA";

	private final String discomdetailsURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getFetchDetailsEncryptedBySso";

	private final String pheddetailsURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getFetchDetailsEncryptedBySso";

	private final String cancelTransacationURL = " https://emitraapp.rajasthan.gov.in/webServicesRepository/backendTransCancelByDepartmentWithEncryption";

	private final String verifyURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenVerifyNewProcessByRequestIdWithEncryption";
	// private final String cancelTransacationURL =
	// "http://emitrauat.rajasthan.gov.in/webservicesRepositoryUat/backendTransCancelByDepartmentWithEncryption";

	// All URL for refund are as below
	private final String SSOIDURL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getKioskDetailsJSON";

	public static final String CLIENTID_UID = "MEmVkcpNLahCE-9skCRMK36S_ufQGPaCiNFAZ33o_ICd01JIE6IBLpU"; // "9063b7b2-3a8d-4efb-8422-0572fff44ab2";
																											// // PROD

	public static final String URL_OTP_GEN = "https://api.sewadwaar.rajasthan.gov.in/app/live/api/aua/otp/request?client_id="
			+ CLIENTID_UID;

	public static final String URL_OTP_AUTH = "https://api.sewadwaar.rajasthan.gov.in/app/live/api/aua/otp/auth/encr?client_id="
			+ CLIENTID_UID; // PROD

	// HTTP GET request
	private String sendGetEncryptData(String param) throws Exception {
		String methodName = "sendGetEncryptData";
		return getGETResponse(methodName, encryptURL);

	}

	/*
	 * // HTTP POST request public String sendPostForEncryptData(String param)
	 * throws Exception {
	 * 
	 * StringBuffer response = new StringBuffer();
	 * 
	 * try { URL obj = new URL(encryptURL); HttpURLConnection con =
	 * (HttpURLConnection) obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5"); //
	 * con.setRequestProperty("Accept","");
	 * 
	 * String urlParameters = "toBeEncrypt=" + param;
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode(); //
	 * System.out.println("\nSending 'POST' request to URL : " + encryptURL); //
	 * System.out.println("Post parameters : " + urlParameters);
	 * logger.info("sendPostForEncryptData Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in sendPostForEncryptData : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	// HTTP POST request
	public String sendPostForEncryptData(String param) throws Exception {
		String methodName = "sendPostForEncryptData";
		return getPOSTResponse(methodName, param, "toBeEncrypt", encryptURL);

	}

	public String getCheckSUM(String checkSum) {
		StringBuffer response = new StringBuffer();

		try {
			URL obj = new URL(checkSumURL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			String urlParameters = "toBeCheckSumString=" + checkSum;

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			logger.info("getCheckSUM, Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			// System.out.println(response.toString());
		} catch (Exception e) {
			logger.error("Exception in getCheckSUM : " + e.getMessage());
			e.printStackTrace();
		}
		return response.toString();
	}

	/*
	 * // HTTP POST request for getting bill information public String
	 * getBillInformationData(String param) throws Exception { StringBuffer response
	 * = new StringBuffer();
	 * 
	 * try { URL obj = new URL(billInfoURL); HttpURLConnection con =
	 * (HttpURLConnection) obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 * 
	 * String urlParameters = "encData=" + param;
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode();
	 * logger.info("getBillInformationData, Response Code : " + responseCode); //
	 * System.out.println("\nSending 'POST' request to URL : " + billInfoURL); //
	 * System.out.println("Post parameters : " + urlParameters); //
	 * System.out.println("Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in getBillInformationData : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	// HTTP POST request for getting bill information
	public String getBillInformationData(String param) {

		String methodName = "getBillInformationData";

		return getPOSTResponse(methodName, param, "encData", billInfoURL);

	}

	/*
	 * public String sendPostCheckSum(String param) throws Exception {
	 * 
	 * StringBuffer response = new StringBuffer();
	 * 
	 * try { URL obj = new URL(checkSumURL); HttpURLConnection con =
	 * (HttpURLConnection) obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5"); //
	 * con.setRequestProperty("Accept","");
	 * 
	 * String urlParameters = "toBeCheckSumString=" + param;
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode();
	 * logger.info("sendPostCheckSum, Response Code : " + responseCode); //
	 * System.out.println("\nSending 'POST' request to URL : " + encryptURL); //
	 * System.out.println("Post parameters : " + urlParameters); //
	 * System.out.println("Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in sendPostCheckSum : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	public String sendPostCheckSum(String param) {

		String methodName = "sendPostCheckSum";

		return getPOSTResponse(methodName, param, "toBeCheckSumString", checkSumURL);

	}

	/*
	 * public String sendPostForBacktoBack(String param) throws Exception {
	 * 
	 * StringBuffer response = new StringBuffer();
	 * 
	 * try { URL obj = new URL(backToBackURL); HttpURLConnection con =
	 * (HttpURLConnection) obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5"); //
	 * con.setRequestProperty("Accept","");
	 * 
	 * String urlParameters = "encData=" + param;
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode();
	 * logger.info("sendPostForBacktoBack, Response Code : " + responseCode); //
	 * System.out.println("\nSending 'POST' request to URL : " + encryptURL); //
	 * System.out.println("Post parameters : " + urlParameters); //
	 * System.out.println("Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in sendPostForBacktoBack : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	public String sendPostForBacktoBack(String param) {

		String methodName = "sendPostForBacktoBack";

		return getPOSTResponse(methodName, param, "encData", backToBackURL);

	}

	/*
	 * public String sendPostForDecryptData(String param) throws Exception {
	 * 
	 * StringBuffer response = new StringBuffer();
	 * 
	 * try { URL obj = new URL(decryptURL); HttpURLConnection con =
	 * (HttpURLConnection) obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5"); //
	 * con.setRequestProperty("Accept","");
	 * 
	 * String urlParameters = "toBeDecrypt=" + param;
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode();
	 * logger.info("sendPostForDecryptData, Response Code : " + responseCode); //
	 * System.out.println("\nSending 'POST' request to URL : " + encryptURL); //
	 * System.out.println("Post parameters : " + urlParameters); //
	 * System.out.println("Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in sendPostForDecryptData : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	public String sendPostForDecryptData(String param) {
		String methodName = "sendPostForDecryptData";
		return getPOSTResponse(methodName, param, "toBeDecrypt", decryptURL);

	}

	/*
	 * public String getPhedInformationData(String param) throws Exception {
	 * StringBuffer response = new StringBuffer();
	 * 
	 * try { URL obj = new URL(pheddetailsURL); HttpURLConnection con =
	 * (HttpURLConnection) obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 * 
	 * String urlParameters = "encData=" + param;
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode();
	 * logger.info("getPhedInformationData, Response Code :" + responseCode); //
	 * System.out.println("\nSending 'POST' request to URL : " + billInfoURL); //
	 * System.out.println("Post parameters : " + urlParameters); //
	 * System.out.println("Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in getPhedInformationData : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	public String getPhedInformationData(String param) throws Exception {

		String methodName = "getPhedInformationData";

		return getPOSTResponse(methodName, param, "encData", pheddetailsURL);

	}

	/*
	 * public String getDiscomInformationData(String param) throws Exception {
	 * StringBuffer response = new StringBuffer();
	 * 
	 * try { URL obj = new URL(discomdetailsURL); HttpURLConnection con =
	 * (HttpURLConnection) obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 * 
	 * String urlParameters = "encData=" + param;
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode();
	 * logger.info("getDiscomInformationData, Response Code : " + responseCode); //
	 * System.out.println("\nSending 'POST' request to URL : " + billInfoURL); //
	 * System.out.println("Post parameters : " + urlParameters); //
	 * System.out.println("Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in getDiscomInformationData : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	public String getDiscomInformationData(String param) throws Exception {

		String methodName = "getDiscomInformationData";

		return getPOSTResponse(methodName, param, "encData", discomdetailsURL);

	}

	/*
	 * public String sendPostForJamabandiData(String param) throws Exception {
	 * 
	 * StringBuffer response = new StringBuffer();
	 * 
	 * try { URL obj = new URL(param); HttpURLConnection con = (HttpURLConnection)
	 * obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("GET");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5"); //
	 * con.setRequestProperty("Accept","");
	 * 
	 * // Send post request con.setDoOutput(true);
	 * 
	 * int responseCode = con.getResponseCode(); //
	 * System.out.println("\nSending 'POST' request to URL : " + encryptURL); //
	 * System.out.println("Post parameters : " + urlParameters);
	 * logger.info("sendPostForEncryptData Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in sendPostForEncryptData : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	public String sendPostForJamabandiData(String param) throws Exception {

		String methodName = "sendPostForJamabandiData";

		return getPOSTResponse(methodName, param, "", param);

	}

	/*
	 * public String sendPostForCancelTranscation(String param) throws Exception {
	 * 
	 * StringBuffer response = new StringBuffer();
	 * 
	 * try { URL obj = new URL(cancelTransacationURL); HttpURLConnection con =
	 * (HttpURLConnection) obj.openConnection();
	 * 
	 * // add reuqest header con.setRequestMethod("POST");
	 * con.setRequestProperty("User-Agent", USER_AGENT);
	 * con.setRequestProperty("Accept-Language", "en-US,en;q=0.5"); //
	 * con.setRequestProperty("Accept","");
	 * 
	 * String urlParameters = "encData=" + param;
	 * 
	 * // Send post request con.setDoOutput(true); DataOutputStream wr = new
	 * DataOutputStream(con.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.flush(); wr.close();
	 * 
	 * int responseCode = con.getResponseCode();
	 * logger.info("sendPostForBacktoBack, Response Code : " + responseCode); //
	 * System.out.println("\nSending 'POST' request to URL : " + encryptURL); //
	 * System.out.println("Post parameters : " + urlParameters); //
	 * System.out.println("Response Code : " + responseCode);
	 * 
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(con.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result // System.out.println(response.toString()); } catch
	 * (Exception e) { logger.error("Exception in sendPostForBacktoBack : " +
	 * e.getMessage()); e.printStackTrace(); } return response.toString();
	 * 
	 * }
	 */

	// Optimized code (removed redundancy)
	public String sendPostForCancelTranscation(String param) throws Exception {

		String methodName = "sendPostForCancelTranscation";

		return getPOSTResponse(methodName, param, "encData", cancelTransacationURL);

	}
	
	public String sendPostForVerifyTranscation(String param) throws Exception {

		String methodName = "sendPostForVerifyTranscation";

		return getPOSTResponse(methodName, param, "encData", verifyURL);

	}

	// Optimized code
	static public String checkSSOID() {
		return (null == Login.SSOID || "".equals(Login.SSOID)) ? "no" : "yes";
	}

	/*
	 * public int getCashMachineAmount(double amount) { int result = (int) amount;
	 * int y = result % 10; double z = amount - result; if (y == 0) { if (z > 0)
	 * result = result + 1; } else { if (y == 1) result = result + 9; else if (y ==
	 * 2) result = result + 8; else if (y == 3) result = result + 7; else if (y ==
	 * 4) result = result + 6; else if (y == 5) result = result + 5; else if (y ==
	 * 6) result = result + 4; else if (y == 7) result = result + 3; else if (y ==
	 * 8) result = result + 2; else if (y == 9) result = result + 1; }
	 * 
	 * return result;
	 * 
	 * }
	 */

	// Optimized code
	public int getCashMachineAmount(double amount) {
		int result = (int) amount;
		int y = result % 10;
		double z = amount - result;
		if (y == 0) {
			if (z > 0)
				result = result + 1;
			return result;
		}

		switch (y) {

		case 1:
			result = result + 9;
			break;
		case 2:
			result = result + 8;
			break;
		case 3:
			result = result + 7;
			break;
		case 4:
			result = result + 6;
			break;
		case 5:
			result = result + 5;
			break;
		case 6:
			result = result + 4;
			break;
		case 7:
			result = result + 3;
			break;
		case 8:
			result = result + 2;
			break;
		case 9:
			result = result + 1;
			break;

		}

		return result;

	}

	public String getPOSTResponse(String methodName, String param, String toBeEnOrDe, String URL) {

		StringBuffer response = new StringBuffer();
		String res = null;
		try {

			URL obj = new URL(URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = null;

			if ("getMachineAuth".equalsIgnoreCase(methodName) || "onlineverify".equalsIgnoreCase(methodName))
				urlParameters = param;
			else
				urlParameters = toBeEnOrDe + "=" + param;

			con.setDoOutput(true);

			if (!"sendPostForJamabandiData".equalsIgnoreCase(methodName)) {
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();
			}

			int responseCode = con.getResponseCode();
			logger.info(methodName + ", Post parameters : " + urlParameters);
			logger.info(methodName + ", Response Code : " + responseCode);
			// System.out.println("\nSending 'POST' request to URL : " + decryptURL);
			// System.out.println("Post parameters : " + urlParameters);
			// System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			res = response.toString();

		} catch (Exception e) {
			logger.error("Exception in " + methodName + " : " + e.getMessage());
			e.printStackTrace();
		}

		return res;
	}

	public String getGETResponse(String methodName, String URL) {

		StringBuffer response = null;

		try {

			URL obj = new URL(URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			logger.info(methodName + " Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();

		} catch (Exception e) {
			logger.error("Exception in " + methodName + " " + e.getMessage());
			e.printStackTrace();
		}

		return response.toString();

	}

	// use to get aadhar number by using SSOID and Marchant Code
	public String sendPostSSOIDAndMarchant(String param) {

		String methodName = "sendPostSSOIDAndMarchant";

		return getPOSTResponse(methodName, param, "encData", SSOIDURL);

	}

}
