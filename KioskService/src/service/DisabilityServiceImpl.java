package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UidotpAuthentication.AadharServices;
import controller.DisabilityController;
import dao.DisabilityDAO;
import model.DisabilityCertificateInfo;

@Service("disabilityService")
public class DisabilityServiceImpl implements DisabilityService {

	@Autowired
	DisabilityDAO disabilityDAO;
	static final Logger logger = Logger.getLogger(DisabilityServiceImpl.class);
	private final String USER_AGENT = "Mozilla/5.0";
	private static final String CLIENTID_UID = "9063b7b2-3a8d-4efb-8422-0572fff44ab2"; // PRODUCTION
	private static final String SUBAUA = "STGDOIT028";
    private static final String LICENCEKEY = "MCsgGevkwgSAL9BzBsoiPgPLlcfxoTx8IM8pwTks7WZwqzE0l7xWjuk"; // PROD
	private static final String URL_OTP_GEN = "https://api.sewadwaar.rajasthan.gov.in/app/live/api/aua/otp/request?client_id="+CLIENTID_UID; // PRODUCTION
	private static final String URL_OTP_AUTH = "https://api.sewadwaar.rajasthan.gov.in/app/live/api/aua/kyc/bio_otp/encr?client_id="+CLIENTID_UID; // PRODUCTION
	
	@Override
	public Map<String, Object> uidOtpGeneration(String aadharId) {
		// TODO Auto-generated method stub
		AadharServices aadharServices = new AadharServices();
		
		return aadharServices.aadharOtpGeneration(aadharId, URL_OTP_GEN);
	}

	@Override
	public HashMap<String,String> authOTP(String otp, String txnId, String aadharNo ,String serialNo , HttpServletRequest request) throws Exception{
		
		String webPath =  request.getSession().getServletContext().getRealPath("/uidResource/");
		webPath = webPath.replace("\\", File.separator);
		AadharServices aadharServices = new AadharServices();
		String docXml = aadharServices.getXmlForAadharOtpAuthEkyc(aadharNo, txnId, otp, webPath);
		HashMap<String,String> map=null;
		JSONObject memberObj = aadharServices.getResponseStringForAadhar(docXml, URL_OTP_AUTH);
		
		if(memberObj != null && !memberObj.isEmpty()) {
			if(memberObj.containsKey("Status")&&((String)memberObj.get("Status")).equals("0")) {
				map = new HashMap<String,String>();
				map.put("STATUS_CODE", "ApiException");
				map.put("RESPONSE_CODE", "ES-213");
				map.put("ERROR_MESSAGE", "Problem in otp authentication ,Please try again!");
			}
			else{
				String otpAuthStatus = (String) ((JSONObject)((JSONObject)memberObj.get("authresponse")).get("auth")).get("status");
				if(otpAuthStatus != null && otpAuthStatus.equalsIgnoreCase("y")) {
						return CertificateServicedisability(serialNo,aadharNo,request);
						}
				else {
					map = new HashMap<String,String>();
					map.put("Auth", "No");
					map.put("message", "wrong otp");
					map.put("STATUS_CODE", "Error");
				}
			}
		}
		return map;

	}
	public  HashMap<String,String>  CertificateServicedisability(String SAPID,String AADHAAR , HttpServletRequest req)
			throws IOException, ParseException {
		JSONObject json = new JSONObject();
		int responseCode = 0;
		HashMap<String,String> map = null;
		try {
				String URL = "http://reportsemitraapp.rajasthan.gov.in/emitraReportsRepository/getDisabilityCertificateURL?sapNumber="+SAPID+"&aadhar="+AADHAAR;
				//String URL = "http://reportsemitraapp.rajasthan.gov.in/emitraReportsRepository/getDisabilityCertificateURLWithEmitra?sapNumber="+SAPID+"&aadhar="+AADHAAR;
				//String URL = "https://dsa.rajasthan.gov.in/GetDisabiiltyCertByAadhaarSapID";
				URL obj = new URL(URL);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", USER_AGENT);
				con.setDoOutput(true);
	
				con.setDoOutput(true);
				responseCode = con.getResponseCode();
				if(responseCode == 200) {
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					json = null;
					JSONParser parser = new JSONParser();
					json=(JSONObject) parser.parse(response.toString());
					map = new HashMap<String,String>();
					map.put("STATUS_CODE", (String)json.get("STATUS_CODE"));
					map.put("URL", (String)json.get("URL"));
					map.put("MESSAGE", (String)json.get("MESSAGE"));
					map.put("AADHAAR", (String)json.get("AADHAAR"));
					map.put("SAP_NUMBER", (String)json.get("SAP_NUMBER"));
					if(map.get("STATUS_CODE").equals("200") && map.get("MESSAGE").equals("SUCCESS") && map.get("URL").lastIndexOf(".pdf")!=-1) {
						String directory = System.getProperty( "catalina.base" ) + "\\webapps";
						map = downloadfile(map,AADHAAR,directory,req);
					}
				}else {
					map = new HashMap<String,String>();
					map.put("STATUS_CODE", "ApiException");
					map.put("RESPONSE_CODE", responseCode+"");
					map.put("ERROR_MESSAGE", "Response Code Not 200 for certificate");
				}
				return map;
		}catch(Exception e) {
			map = new HashMap<String,String>();
			map.put("STATUS_CODE", "ApiException");
			map.put("RESPONSE_CODE", responseCode+"");
			map.put("ERROR_MESSAGE", e.getMessage());
		}
		return map;
	}

	

	@Override
	public String saveDisabilityCertificateDetails(DisabilityCertificateInfo disabilityinfo) {
		// TODO Auto-generated method stub
		return disabilityDAO.saveDisabilityCertificateDetails(disabilityinfo);
	}
	

	public HashMap<String,String> downloadfile(HashMap<String,String> map , String aadhaar ,String directory , HttpServletRequest req) throws IOException {
		URL url = new URL(map.get("URL"));
		directory = directory + File.separator + "disability";
		File f = new File(directory);
		if(!f.exists()) {
			f.mkdirs();
		}else {
			File allfile[] = f.listFiles();
			for(int i=0;i<allfile.length;i++) {
				if(allfile[i].isFile()) {
					allfile[i].delete();
				}
			}
		}
		
		f = new File(directory + File.separator + aadhaar+"_disability.pdf");
		if(!f.exists())
			f.createNewFile();
		InputStream in = url.openStream();
		FileOutputStream fos = new FileOutputStream(f);
		int length = -1;
		byte[] buffer = new byte[1024];// buffer for portion of data from connection
		while ((length = in.read(buffer)) > -1) {
		    fos.write(buffer, 0, length);
		}
		fos.close();
		in.close();
		if(f.exists()) {
			directory = "http://localhost:"+req.getLocalPort()+"/KioskService/certificatecontainer.jsp?urlOfPrinting=http://localhost:"+req.getLocalPort()+"/disability/"+aadhaar+"_disability.pdf";
		}else {
			map.put("STATUS_CODE", "ApiException");
			map.put("RESPONSE_CODE", "File not down load succesfully");
			map.put("ERROR_MESSAGE", "File not download");
		}
		map.put("URL", directory);
		return map;
	}
	
}
