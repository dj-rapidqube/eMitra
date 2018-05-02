package controller;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import UidotpAuthentication.AadharServices;
import locallogs.LocalLogSyncer;
import model.Bill;
import model.CardPaymentDetails;
import model.CertificateInfo;
import model.Discom;
import model.Jamabandi;
import model.LatestVersionDetails;
import model.Login;
import model.MachineAuth;
import model.NoteType;
import model.Phed;
import service.BillService;
import service.CertificateService;
import service.EncryptDecryptService;
import sun.misc.BASE64Decoder;
import webServicesRepository.utility.EncrptDesryptDataService;
import webServicesRepository.utility.VedioConference;

@EnableWebMvc
@Controller
public class BillController {
	static final Logger logger = Logger.getLogger(BillController.class);
	private final String USER_AGENT = "Mozilla/5.0";
	private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	private static final String AES = "AES";
	private static final String SHA256 = "SHA-256";
	private static final String yesCardEncryptionKey = "A93A58AA4ED6B323ACFD7735C56EA";
	private static final String noCardEncryptionKey = "7D118B59FE7691D56DB47C84D271C";
	
	private static final String yesCardCheckSum="Y-EQ!H&SIV.lFzh";
	private static final String noCardCheckSum="Pw<1!%l81bHY/YZ";
	
	private static final String yesCardMerchantCode = "EMITRAPLUSEZETAP";
	private static final String noCardMerchantCode = "EMITRAPLUSBILLDESK";
//	private final String USER_AGENT1 = "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0";

//	private final String USER_AGENT1 = "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0";
//	private final String SSOID = "CITIZENOFRAJASTHAN";
//	private final String SSOID = "ISHITA.GURTU";
	
//	private String SSOID = Login.SSOID;
	
//digit secure
	private static final String digitSecureEncryptionKey = "1AEED1A2FD4FE22A527A5AFA6EDEA";
	private static final String digitSecureMerchantCode = "EMITRAPLUSDIGITSECURE";
	private static final String digitSecureCheckSum="z[$#vdPb~:2h@8V";
	
	
	@Autowired
	BillService billService;
	
	@Autowired
	EncryptDecryptService encryptDecryptService;
	
	@Autowired
	CertificateService certificateService;
	
	@Autowired
    LocalLogSyncer localLogSyncer;

	
	@RequestMapping(value = "/serviceProviderInfo", method = RequestMethod.GET)
	public String getServiceProvider() {
		return "index";
	}

	@RequestMapping(value = "/hello11", method = RequestMethod.POST)
	public String getServiceP() {
		return "index";
	}

	@RequestMapping(value = "/serviceProviderInfo", method = RequestMethod.POST)
	public String postServiceProvider(Model model, Bill bill) {
		// System.out.println("ServiceProviderID :: "+bill.getServiceProviderID()+"
		// serviceProviderName :: "+bill.getServiceProviderName());
		model.addAttribute("serviceProvider", bill);
		return "serviceProviderInfo";

	}
	
	
	@RequestMapping(value = "/serviceProviderInfoHi", method = RequestMethod.POST)
	public String postserviceProviderInfoHi(Model model, Bill bill) {
		// System.out.println("ServiceProviderID :: "+bill.getServiceProviderID()+"
		// serviceProviderName :: "+bill.getServiceProviderName());
		model.addAttribute("serviceProvider", bill);
		return "serviceProviderInfoHi";

	}

	@RequestMapping(value = "/billinfo", method = RequestMethod.GET)
	public String getHomePage() {
		return "index";
	}

	@RequestMapping(value = "/noDetailsFoundHi")
	public ModelAndView noDetailsFoundHi() {
		return new ModelAndView("noDetailsFoundHi");
	}

	@RequestMapping(value = "/noDetailsFound")
	public ModelAndView noDetailsFound() {
		return new ModelAndView("noDetailsFound");
	}
	
	@RequestMapping(value = "/billinfo", method = RequestMethod.POST)
	public String showBillInfoPage(Model model, Bill bill, HttpServletRequest req) throws SQLException {
		int flag = 0;
		String strToEncrypt ="";
		String bsnlType = "";
		if(bill.getServiceProviderID()==2575) {
			bsnlType = req.getParameter("bsnlType");
		}
		
		logger.info("Billinfo, ServiceProviderID :: "+bill.getServiceProviderID()+" serviceProviderName :: "+bill.getServiceProviderName()+
		 " MobileNo : "+bill.getBillMobileNo()+" email id : "+bill.getBillEmail());
		
		if(bill.getBillEmail()==null ||bill.getBillEmail().equals(""))
			bill.setBillEmail("helpdesk.emitra@rajasthan.gov.in");
		
		bill.setSsoID(Login.SSOID);
		int langCode = bill.getLangCode();
		EncrptDesryptDataService encryptService = new EncrptDesryptDataService();
		String mobileNo = bill.getBillMobileNo();
		
	//	String strToEncrypt = "{'SRVID':'" + bill.getServiceProviderID() + "','searchKey':'" + mobileNo
	//			+ "','SSOID':'"+Login.SSOID+"'}";
		
		if(bill.getServiceProviderID()==2575) {
        	if(bsnlType.equalsIgnoreCase("mobile")) {
        		strToEncrypt = "{'SSOID':'" +Login.SSOID+ "','SRVID':'" + bill.getServiceProviderID()
     			+ "','searchKey':'"+mobileNo+"-"+mobileNo+"-GSM'}";
        	}
        	else if(bsnlType.equalsIgnoreCase("landline")) {
        		strToEncrypt = "{'SSOID':'" +Login.SSOID+ "','SRVID':'" + bill.getServiceProviderID()
     			+ "','searchKey':'"+mobileNo+"-"+mobileNo+"-CDR'}";
        	}
        }
        	 
        else
        	strToEncrypt = "{'SRVID':'" + bill.getServiceProviderID() + "','searchKey':'" + mobileNo
			+ "','SSOID':'"+Login.SSOID+"'}";
		
		String encryptData = null;
		String encryptDetails = null;
		List<Bill> billInformation = null;
		try {
			encryptData = encryptService.sendPostForEncryptData(strToEncrypt);
		} catch (Exception e) {
			logger.error("Billinfo, Exception in sendPostForEncryptData :" + e.getMessage());
			encryptData = null;
			e.printStackTrace();
		}

		logger.debug("Billinfo, encryptData  :" + encryptData);
		if (!encryptData.equals("") && encryptData != null ) {
			try {
				encryptDetails = encryptService.getBillInformationData(encryptData);
			} catch (Exception e) {
				logger.error("Exception in getBillInformationData encryptDetails: "+e.getMessage());
				encryptDetails = null;
				e.printStackTrace();
			}
		}
		logger.debug("Billinfo, encryptDetails : " + encryptDetails);

		try {
			//billInformation = encryptService.sendPostForDecryptData(encryptDetails, bill);
			billInformation = encryptDecryptService.sendPostForDecryptDetail(encryptDetails, bill);
		} catch (Exception e) {
			logger.error("Billinfo, Exception in decryptdetails :" + e.getMessage());
			e.printStackTrace();
		}
		String transactionId  ="";
		double d = 0.0;
		int billamount = 0;
		if (billInformation.size() > 0) {
			transactionId = billInformation.get(0).getTransactionId();
			
			d = Double.parseDouble(
					billInformation.get(0).getBillAmount().trim().equalsIgnoreCase("NA") ? "0" : billInformation.get(0).getBillAmount());

			int x = new EncrptDesryptDataService().getCashMachineAmount(d);
			billamount = x;
			flag = 1;
		}

		logger.info("Billinfo, billamount : " + billamount+" transactionId : "+transactionId+" ActualAmountt :: "+d+" serviceProverId : "+bill.getServiceProviderID());
		
		Bill infoBill  = new Bill();
		try{
			
			infoBill.setBillAmount(Integer.toString(billamount));
			infoBill.setTransactionId(transactionId);
			infoBill.setBillActualAmount(Double.toString(d));
			infoBill.setServiceProviderID(bill.getServiceProviderID());
			billService.updateBillInformation(infoBill);
		}catch(Exception e ){
			logger.error("Exception in updateBillInformation : "+e.getMessage());
			e.printStackTrace();
		}
		
		if (flag == 1) {
			req.setAttribute("details", billInformation);
			req.setAttribute("infobill", infoBill);
			if(langCode==0) 
				return "BillDetails";
			else
				return "BillDetailsHi";
		}
		else {
			//return "redirect:noDetailsFound";
			if(langCode==0) 
				return "redirect:noDetailsFound";
			else
				return "redirect:noDetailsFoundHi";
		}
	}

	
	@RequestMapping(value = "/clickToPay", method = RequestMethod.POST)
	public ModelAndView clickToPay(Model model, Bill bill, HttpServletRequest req) {
		logger.info("Actual Amount  :"+bill.getBillActualAmount()+" TransactionId : "+bill.getTransactionId()+" Billamount : "+bill.getBillAmount()+" ServiceProvider ID : "+bill.getServiceProviderID());
		
		
	    String checkSSO = EncrptDesryptDataService.checkSSOID();
	    if(checkSSO.equalsIgnoreCase("yes"))
	    {
	    	req.setAttribute("amount", bill.getBillAmount());
			req.setAttribute("Id", bill.getTransactionId());
			req.setAttribute("acutalAmt", bill.getBillActualAmount());
			req.setAttribute("serviceProviderID", bill.getServiceProviderID());
			req.setAttribute("name",bill.getName());
			req.setAttribute("email",bill.getBillEmail());
			req.setAttribute("mobile",bill.getBillMobileNo());
			req.setAttribute("consumerKeyValue", bill.getConsumerKeyValue());
			req.setAttribute("date",bill.getCreatedDate());
			
			logger.info("clickToPay :: Note Value, total10note :"+NoteType.total10Note+" total20note :"+NoteType.total20Note+" total50note:"+NoteType.total50Note
					+" total100note :"+NoteType.total100Note+" total200note :"+NoteType.total200Note+" total500note :"	+
					NoteType.total500Note+" total2000note :"+NoteType.total2000Note );
			NoteType.total10Note=0;
			NoteType.total20Note=0;
			NoteType.total50Note=0;
			NoteType.total100Note=0;
			NoteType.total200Note=0;
			NoteType.total500Note=0;
			NoteType.total2000Note=0;
			NoteType.cashTimer=0;
			NoteType.depositAmount = 0;
			
			logger.info("clickToPay ::After regreshing Note Value, total10note :"+NoteType.total10Note+" total20note :"+NoteType.total20Note+" total50note:"+NoteType.total50Note
					+" total100note :"+NoteType.total100Note+" total200note :"+NoteType.total200Note+" total500note :"	+
					NoteType.total500Note+" total2000note :"+NoteType.total2000Note );
			if(bill.getLangCode()==1)
				return new ModelAndView("PaymentmodeHi");
			else 
				return new ModelAndView("Paymentmode");
	    }
	    
	    else
	    {
	    	return new ModelAndView("Login");
	    }
			
		
		
	}

	
	@RequestMapping(value = "/information")
	public ModelAndView information(Model model, HttpServletRequest req) {

		return new ModelAndView("Information");
	}

	@RequestMapping(value = "/district")
	public ModelAndView district(Model model, HttpServletRequest req) {

		return new ModelAndView("District");

	}

	@RequestMapping(value = "/districtAdministration")
	public ModelAndView districtAdministration(Model model, HttpServletRequest req) {
		return new ModelAndView("DistrictAdministration");
	}

	@RequestMapping(value = "/districtDepartment")
	public ModelAndView districtDepartment(Model model, HttpServletRequest req) {
		return new ModelAndView("DistrictDepartment");
	}

	@RequestMapping(value = "/employeeDetails")
	public ModelAndView employeeDetails(Model model, HttpServletRequest req) {
		return new ModelAndView("EmployeeDetails");
	}

	@RequestMapping(value = "/allEmployeeDetails")
	public ModelAndView allEmployeeDetails(Model model, HttpServletRequest req) {
		return new ModelAndView("AllEmployeeDetails");
	}

	@RequestMapping(value = "/service")
	public ModelAndView service(Model model, HttpServletRequest request, HttpServletResponse response ) {
		return new ModelAndView("Service");
	}

	@RequestMapping(value = "/serviceprovider")
	public ModelAndView getServiceprovider(Model model, HttpServletRequest req) {
		return new ModelAndView("Serviceprovider");
	}
	

	@RequestMapping(value = "/serviceproviderHi")
	public ModelAndView getServiceproviderhindi(Model model, HttpServletRequest req) {
		return new ModelAndView("Serviceproviderhindi");
	}

	@RequestMapping(value = "/designationOfDepartment")
	public ModelAndView designationOfDepartment(Model model, HttpServletRequest req) {
		return new ModelAndView("DesignationOfDepartment");
	}

	@RequestMapping(value = "/governmentservice")
	public ModelAndView govtservice(Model model, HttpServletRequest req,CertificateInfo certificateInfo)
			throws IOException, JSONException, org.json.simple.parser.ParseException {
		String tokenid  = req.getParameter("tokenId");
		String certificateType=req.getParameter("certificateDetails");
		int langCode = Integer.parseInt(req.getParameter("langCode"));
		
		certificateInfo.setRegistrationNo(tokenid);
		String serviceName = certificateInfo.getServiceName();
		String serviceID = certificateInfo.getServiceID();
		String subServiceID = certificateInfo.getSubServiceID();
		
		logger.info("Government Service Token Id : "+tokenid);
		String encryptURL = "https://api.sewadwaar.rajasthan.gov.in/app/live/eMitra/Prod/PrintCert/Service/getCertDetails?tokenNo="
				+ tokenid + "&printType=A4&client_id=96f2ea05-8742-401d-aa42-ec269f8a71c0";
			
		String response1 = "";
		String result = "";
		response1 = encryptDecryptService.getGovtServiceDetail(encryptURL);

		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(response1);
			String url = (String) json.get("URL");
			logger.info("Government Service :: how Certificate URL with urlOfPrinting :" + url);
			
			if (url.equals("")) {
				if(langCode==0)
					result = "noDetailsFound";
				else
					result = "noDetailsFoundHi";
			}
			else {
				json = billService.downloadfile(json, tokenid, req);
				String downloadstatus = (String) json.get("STATUS_CODE");
				if (downloadstatus.equalsIgnoreCase("ApiException")) {
					if (langCode == 0)
						result = "noDetailsFound";
					else
						result = "noDetailsFoundHi";
					logger.info("CertificateService Service :: Error in downloading::"
							+ (String) json.get("ERROR_MESSAGE"));
					return new ModelAndView(result);
				} else {
					String arr[] = ((String) json.get("URL")).split("urlOfPrinting=");
					req.setAttribute("url", (String) json.get("URL"));
					logger.info("CertificateService Service :: urlOfPrinting::" + arr[1]);
					req.setAttribute("url1", arr[1]);
				}

				String certificateTransID = certificateService.insertCertificateDetails(certificateInfo);
				req.setAttribute("certificateType", certificateType);
				req.setAttribute("token", tokenid);
				req.setAttribute("serviceID", serviceID);
				req.setAttribute("subServiceID", subServiceID);
				req.setAttribute("serviceName", serviceName);
				req.setAttribute("transactionID", certificateTransID);
				Thread.sleep(8000);
				if (langCode == 0)
					result = "governmentPDF";
				else
					result = "governmentPDFHi";
			}

		} catch (Exception e) {
			if(langCode==0)
				result = "noDetailsFound";
			else
				result = "noDetailsFoundHi";
			e.printStackTrace();
		}
		logger.info("Government Service :: ModelAndView Name :" + result);
		return new ModelAndView(result);
	}

	@RequestMapping(value = "/ServicePaymentmode")
	public ModelAndView govern(Model model, HttpServletRequest req) {
		req.setAttribute("url", req.getParameter("govtpdf"));
		int langCode = Integer.parseInt(req.getParameter("langCode"));
		
		 String checkSSO = EncrptDesryptDataService.checkSSOID();
		 if(checkSSO.equalsIgnoreCase("yes"))
		 {
		
			logger.info("ServicePaymentmode :: Before flushing note value");
			logger.info("ServicePaymentmode :: Note Value, total10note :"+NoteType.total10Note+" total20note :"+NoteType.total20Note+" total50note:"+NoteType.total50Note
					+" total100note :"+NoteType.total100Note+" total200note :"+NoteType.total200Note+" total500note :"	+
					NoteType.total500Note+" total2000note :"+NoteType.total2000Note );
			NoteType.total10Note=0;
			NoteType.total20Note=0;
			NoteType.total50Note=0;
			NoteType.total100Note=0;
			NoteType.total200Note=0;
			NoteType.total500Note=0;
			NoteType.total2000Note=0;
			NoteType.cashTimer=0;
			NoteType.depositAmount =0 ;
			
			logger.info("ServicePaymentmode ::After regreshing Note Value, total10note :"+NoteType.total10Note+" total20note :"+NoteType.total20Note+" total50note:"+NoteType.total50Note
					+" total100note :"+NoteType.total100Note+" total200note :"+NoteType.total200Note+" total500note :"	+
					NoteType.total500Note+" total2000note :"+NoteType.total2000Note );
			
			String token= req.getParameter("token");
			String certificateType= req.getParameter("certificateType");
			int certificareYear = Integer.parseInt(req.getParameter("certificateYear")==null?"0":req.getParameter("certificateYear"));
			
			/*	System.out.println(token+" "+certificateType);
			System.out.println("certificareYear :: "+certificareYear);
			req.setAttribute("token", token);
			billService.savePaymentStatus(token,certificateType, certificareYear);
			
			*/
			
			String Amount = req.getParameter("amount");
			String CertiTransID = req.getParameter("transactionID");
			String ServiceID = req.getParameter("serviceID");
			String serviceName = req.getParameter("serviceName");
			logger.info("ServicePaymentmode ::Amount :"+Amount+" CertiTransID :"+CertiTransID+" ServiceID:"+ServiceID);
			
			
		//	System.out.println(token+" "+certificateType);
		//	System.out.println("certificareYear :: "+certificareYear);
			req.setAttribute("token", token);
			req.setAttribute("certiTransID", CertiTransID);
			req.setAttribute("serviceID", ServiceID);
			req.setAttribute("serviceName", serviceName);
			billService.savePaymentStatus(CertiTransID,certificateType, certificareYear);
			
			
			
	
			if(langCode==0)
				return new ModelAndView("ServicePaymentmode");
			else
				return new ModelAndView("ServicePaymentmodehi");
		 
		}
		else
		 {
			 return new ModelAndView("Login");
		 }
		 
		
	}

	@RequestMapping(value = "/governmentServiceProvider")
	public ModelAndView governmentServiceProvider(Model model, HttpServletRequest req) {
		return new ModelAndView("GovernmentServiceProvider");
	}

	/*@RequestMapping(value = "/printPdf")
	public ModelAndView printPdf(Model model, HttpServletRequest req) throws Exception {
		System.out.println("++++++++++++++++++++++++value of url :::" + req.getParameter("govtpdf"));
		String tokenid = req.getParameter("tokenId");
		String encryptURL = "https://api.sewadwaar.rajasthan.gov.in/app/live/eMitra/Prod/PrintCert/Service/getCertDetails?tokenNo="
				+ tokenid + "&printType=A4&client_id=96f2ea05-8742-401d-aa42-ec269f8a71c0";
		
		String response1 = "";
		
		response1 = encryptDecryptService.getPDFPrinted(encryptURL);

		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(response1);
			// System.out.println("fetch details" );
			String url = (String) json.get("URL");

			req.setAttribute("url", url);
			// System.out.println("fetch details"+url);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("url", req.getParameter("govtpdf"));
		return new ModelAndView("prinPDF");
	}*/

	@RequestMapping(value = "/transactionservice1")
	public ModelAndView transactionservice(Model model, HttpServletRequest req) throws Exception {
		return new ModelAndView("tokenVerification");
	}

	
	@RequestMapping(value = "/transactionservicehi1")
	public ModelAndView transactionservicehi(Model model, HttpServletRequest req) throws Exception {
		return new ModelAndView("tokenVerificationHi");
	}
	
	@RequestMapping(value = "/onlineverification")
	public ModelAndView applicationservice(Model model, HttpServletRequest req) throws Exception {
		return new ModelAndView("OnlineVerification");
	}
	
	@RequestMapping(value = "/onlineverificationhi")
	public ModelAndView applicationservicehi(Model model, HttpServletRequest req) throws Exception {
		return new ModelAndView("OnlineVerificationhi");
	}

	@RequestMapping(value = "/transactionservice")
	public ModelAndView tokenVerification(Model model, HttpServletRequest req) throws Exception {
		String transId = req.getParameter("transId");
		int langCode = Integer.parseInt(req.getParameter("langCode"));
		logger.info("tokenVerification, TransactionID :" + transId);

		//String URL = "http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/getTokenVerify";
		String URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenVerify";
		try {
			
			Bill tr = encryptDecryptService.tokenVerficationDetails(URL,transId);
			
			/*req.setAttribute("transactionDate", transactionDate);
			req.setAttribute("RECEIPTNO", RECEIPTNO);
			req.setAttribute("TRANSACTIONID", TRANSACTIONID);
			req.setAttribute("AMT", AMT);
			req.setAttribute("TRANSACTIONSTATUS", TRANSACTIONSTATUS);
			req.setAttribute("MSG", MSG);
			req.setAttribute("DEPTNAME", DEPTNAME);
			req.setAttribute("SRVNAME", SRVNAME);*/
			
			req.setAttribute("transactionDate", tr.getTransactionDate());
			req.setAttribute("RECEIPTNO", tr.getrECEIPTNO() );
			req.setAttribute("TRANSACTIONID",tr.getTransactionId() );
			req.setAttribute("AMT", tr.getaMT());
			req.setAttribute("TRANSACTIONSTATUS",tr.gettRANSACTIONSTATUS());
			req.setAttribute("MSG", tr.getmSG());
			req.setAttribute("DEPTNAME", tr.getdEPTNAME());
			req.setAttribute("SRVNAME", tr.getsRVNAME());
			
		} catch (Exception e) {
			logger.error("Exception in tokenVerification ::"+e.getMessage());
			e.printStackTrace();
		}
		
		if(langCode==0)
			return new ModelAndView("transactionDetails");
		else
			return new ModelAndView("transactionDetailsHi");

	}

	/*@RequestMapping(value = "/onlinever")
	public ModelAndView onlineverify(Model model, HttpServletRequest req) throws Exception {
		logger.info("onlineverify");
		String serviceId = req.getParameter("serviceId");
		String tokenNo =  req.getParameter("token");
		logger.info("Online verification, ServiceID:::" + serviceId+ " tokenNo :::" + tokenNo);
		String URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getMetaDataDetailsForCertificateEmitra";

		try {
			URL obj = new URL(URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			// con.setRequestProperty("Accept","");
			con.setDoOutput(true);
			// con.setRequestProperty("Accept","");
			String param = "SRV_ID=" + serviceId + "&TOKEN_NO=" + tokenNo;
			String urlParameters = param;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			// System.out.println("\nSending 'POST' request to URL : " + encryptURL);
			logger.debug("Online verification, Post parameters : " + urlParameters);
			logger.info("Online verification, Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			String trans = response.toString();
			logger.info("Online verification, response json :" + trans);
			JSONParser parser = new JSONParser();

			JSONObject json = (JSONObject) parser.parse(trans);
			String Approved_Date = (String) json.get("Approved_Date");
			String Status = (String) json.get("Status");
			String Permanent_Address = (String) json.get("Permanent_Address");
			String Digitally_Signed = (String) json.get("Digitally_Signed");
			String Father_Name = (String) json.get("Father_Name");
			String Date_Of_Birth = (String) json.get("Date_Of_Birth");
			String Applicant_Name = (String) json.get("Applicant_Name");
			String Approved_And_Signed_By = (String) json.get("Approved_And_Signed_By");
			String Mother_Name = (String) json.get("Mother_Name");
			String ISAVAILABLE = (String) json.get("ISAVAILABLE");
			String TOKEN_NO = (String) json.get("TOKEN_NO");
			String Current_Address = (String) json.get("Current_Address");

			Bill tr = new Bill();
			tr.setTransactionDate(Approved_Date);
			tr.setrECEIPTNO(Status);
			tr.setTransactionId(Permanent_Address);
			tr.setaMT(Digitally_Signed);
			tr.seteMITRATIMESTAMP(Father_Name);
			tr.settRANSACTIONSTATUS(Date_Of_Birth);
			tr.setvERIFYSTATUSCODE(Applicant_Name);
			tr.setmSG(Approved_And_Signed_By);
			tr.setdEPTNAME(Mother_Name);
			tr.setsRVNAME(ISAVAILABLE);
			tr.setBillActualAmount(TOKEN_NO);
			tr.setBillEmail(Current_Address);

			req.setAttribute("Approved_Date", Approved_Date);
			req.setAttribute("Status", Status);
			req.setAttribute("Permanent_Address", Permanent_Address);
			req.setAttribute("Digitally_Signed", Digitally_Signed);
			req.setAttribute("Father_Name", Father_Name);
			req.setAttribute("Date_Of_Birth", Date_Of_Birth);
			req.setAttribute("Applicant_Name", Applicant_Name);
			req.setAttribute("Approved_And_Signed_By", Approved_And_Signed_By);
			req.setAttribute("Mother_Name", Mother_Name);
			req.setAttribute("ISAVAILABLE", ISAVAILABLE);
			req.setAttribute("TOKEN_NO", TOKEN_NO);
			req.setAttribute("Current_Address", Current_Address);
			// print result
			// System.out.println(response.toString());
		} catch (Exception e) {
			logger.error("Exception in onlineverify: "+e.getMessage());
			e.printStackTrace();
		}
		return new ModelAndView("OnlineVerify");

	}*/
	
	@RequestMapping(value = "/onlinever")
	public ModelAndView onlineverify(Model model, HttpServletRequest req) throws Exception {
		logger.info("onlineverify");
		
		String methodName="onlineverify";
		
		String serviceId = req.getParameter("serviceId");
		String tokenNo =  req.getParameter("token");
		logger.info("Online verification, ServiceID:::" + serviceId+ " tokenNo :::" + tokenNo);
		String URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getMetaDataDetailsForCertificateEmitra";

		try {
			
			EncrptDesryptDataService service = new EncrptDesryptDataService();
			
			String param = "SRV_ID=" + serviceId + "&TOKEN_NO=" + tokenNo;
			
			String response = service.getPOSTResponse(methodName, param, "", URL);

			logger.info("Online verification, response json :" + response);
			JSONParser parser = new JSONParser();

			JSONObject json = (JSONObject) parser.parse(response);
			String Approved_Date = (String) json.get("Approved_Date");
			String Status = (String) json.get("Status");
			String Permanent_Address = (String) json.get("Permanent_Address");
			String Digitally_Signed = (String) json.get("Digitally_Signed");
			String Father_Name = (String) json.get("Father_Name");
			String Date_Of_Birth = (String) json.get("Date_Of_Birth");
			String Applicant_Name = (String) json.get("Applicant_Name");
			String Approved_And_Signed_By = (String) json.get("Approved_And_Signed_By");
			String Mother_Name = (String) json.get("Mother_Name");
			String ISAVAILABLE = (String) json.get("ISAVAILABLE");
			String TOKEN_NO = (String) json.get("TOKEN_NO");
			String Current_Address = (String) json.get("Current_Address");

			req.setAttribute("Approved_Date", Approved_Date);
			req.setAttribute("Status", Status);
			req.setAttribute("Permanent_Address", Permanent_Address);
			req.setAttribute("Digitally_Signed", Digitally_Signed);
			req.setAttribute("Father_Name", Father_Name);
			req.setAttribute("Date_Of_Birth", Date_Of_Birth);
			req.setAttribute("Applicant_Name", Applicant_Name);
			req.setAttribute("Approved_And_Signed_By", Approved_And_Signed_By);
			req.setAttribute("Mother_Name", Mother_Name);
			req.setAttribute("ISAVAILABLE", ISAVAILABLE);
			req.setAttribute("TOKEN_NO", TOKEN_NO);
			req.setAttribute("Current_Address", Current_Address);
			// System.out.println(response.toString());
		} catch (Exception e) {
			logger.error("Exception in onlineverify: "+e.getMessage());
			e.printStackTrace();
		}
		return new ModelAndView("OnlineVerify");

	}

	/*@RequestMapping(value = "/discomservice", method = RequestMethod.POST)
	public String discomservice(Model model, Bill bill, Discom dis1, HttpServletRequest req) throws SQLException {
		bill.setServiceProviderID(1223);
		bill.setSsoID(Login.SSOID);
		int flag = 0;
		// System.out.println("HHEyyeyeyeyeyeyyeyeyeeyyeyeyey::"+dis1.getK_Number());
		// System.out.println("ServiceProviderID :: "+bill.getServiceProviderID()+"
		// serviceProviderName :: "+bill.getServiceProviderName()+
		// " MobileNo : "+bill.getBillMobileNo()+" email id : "+bill.getBillEmail());
		int langCode = Integer.parseInt(req.getParameter("langCode"));
		EncrptDesryptDataService encryptService = new EncrptDesryptDataService();

		String strToEncrypt = "{'SRVID':'1223','searchKey':'" + dis1.getK_Number() + "','SSOID':'"+Login.SSOID+"'}";

		String strToEncrypt = "{'SRVID':'" + bill.getServiceProviderID() + "','searchKey':'" + mobileNo
				+ "','SSOID':'"+SSOID+"'}";
		
		
		if(bill.getBillEmail()==null ||bill.getBillEmail().equals(""))
			bill.setBillEmail("helpdesk.emitra@rajasthan.gov.in");
		
		String encryptData = null;
		String encryptDetails = null;
		List<Discom> discomInformation = null;
		try {
			encryptData = encryptService.sendPostForEncryptData(strToEncrypt);
		} catch (Exception e) {
			logger.error("Exception in discomservice for getting encrypt data :" + e.getMessage());
			encryptData = null;
			e.printStackTrace();
		}

		logger.debug("encryptData  :" + encryptData);
		if (encryptData != null) {
			try {
				encryptDetails = encryptService.getDiscomInformationData(encryptData);
			} catch (Exception e) {
				encryptDetails = null;
				logger.error("Exception in getting discom information :" + e.getMessage());
				e.printStackTrace();
			}
		}
		logger.debug("discom information : " + encryptDetails);

		try {
			//discomInformation = encryptService.sendPostForDiscomDecryptData(encryptDetails, bill, dis1);
			discomInformation = encryptDecryptService.sendPostForDiscomDecryptData(encryptDetails, bill, dis1);
		} catch (Exception e) {
			logger.error("Exception  sendPostForDiscomDecrptData:" + e.getMessage());
			e.printStackTrace();
		}
		logger.info("discomInformation list size :: " + discomInformation.size());
		
		
		*//****************************************************************************************************************************//*
		
		String transactionId  ="";
		double d = 0.0;
		int billamount = 0;
		if (discomInformation.size() > 0) {
			d = Double.parseDouble(
					discomInformation.get(0).getTotalAmount().trim().equalsIgnoreCase("NA") ? "0" : discomInformation.get(0).getTotalAmount());

			// d = Double.parseDouble(billInformation.get(0).getBillAmount());

			transactionId = discomInformation.get(0).getTransactionId();
			int x = (int) d;
			int y = x % 10;
			double z = d - x;
			if (y == 0) {
				if (z > 0)
					x = x + 1;
			} else {
				if (y == 1)
					x = x + 9;
				else if (y == 2)
					x = x + 8;
				else if (y == 3)
					x = x + 7;
				else if (y == 4)
					x = x + 6;
				else if (y == 5)
					x = x + 5;
				else if (y == 6)
					x = x + 4;
				else if (y == 7)
					x = x + 3;
				else if (y == 8)
					x = x + 2;
				else if (y == 9)
					x = x + 1;
			}
			billamount = x;
			flag = 1;
		}

		logger.info("Billinfo, billamount : " + billamount+" transactionId : "+transactionId+" ActualAmountt :: "+d+" serviceProverId : "+bill.getServiceProviderID());
		
		Bill infoBill  = new Bill();
		try{
			
			infoBill.setBillAmount(Integer.toString(billamount));
			infoBill.setTransactionId(transactionId);
			infoBill.setBillActualAmount(Double.toString(d));
			infoBill.setServiceProviderID(bill.getServiceProviderID());
			billService.updateBillInformation(infoBill);
		}catch(Exception e ){
			logger.error("Exception in Discom details updateBillInformation : "+e.getMessage());
			e.printStackTrace();
		}
		
		if (flag == 1) {
			req.setAttribute("details", discomInformation);
			req.setAttribute("infobill", infoBill);
			if(langCode==0) 
				return "Discomdetails";
			else
				return "DiscomDetailsHi";
		}
		else {
			//return "redirect:noDetailsFound";
			if(langCode==0) 
				return "redirect:noDetailsFound";
			else
				return "redirect:noDetailsFoundHi";
		}
		
		*//*******************************************************************************************************************************//*
		
	//	req.setAttribute("details", discomInformation);
		
		//return new ModelAndView("Discomdetails");
	}*/
	

	@RequestMapping(value = "/discomservice", method = RequestMethod.POST)
	public String discomservice(Model model, Bill bill, Discom dis1, HttpServletRequest req) throws SQLException {
		bill.setServiceProviderID(1223);
		bill.setSsoID(Login.SSOID);
		int flag = 0;
		// System.out.println("HHEyyeyeyeyeyeyyeyeyeeyyeyeyey::"+dis1.getK_Number());
		// System.out.println("ServiceProviderID :: "+bill.getServiceProviderID()+"
		// serviceProviderName :: "+bill.getServiceProviderName()+
		// " MobileNo : "+bill.getBillMobileNo()+" email id : "+bill.getBillEmail());
		int langCode = Integer.parseInt(req.getParameter("langCode"));
		EncrptDesryptDataService encryptService = new EncrptDesryptDataService();

		String strToEncrypt = "{'SRVID':'1223','searchKey':'" + dis1.getK_Number() + "','SSOID':'"+Login.SSOID+"'}";

		/*String strToEncrypt = "{'SRVID':'" + bill.getServiceProviderID() + "','searchKey':'" + mobileNo
				+ "','SSOID':'"+SSOID+"'}";
		*/
		
		if(bill.getBillEmail()==null ||bill.getBillEmail().equals(""))
			bill.setBillEmail("helpdesk.emitra@rajasthan.gov.in");
		
		String encryptData = null;
		String encryptDetails = null;
		List<Discom> discomInformation = null;
		try {
			encryptData = encryptService.sendPostForEncryptData(strToEncrypt);
		} catch (Exception e) {
			logger.error("Exception in discomservice for getting encrypt data :" + e.getMessage());
			encryptData = null;
			e.printStackTrace();
		}

		logger.debug("encryptData  :" + encryptData);
		if (encryptData != null) {
			try {
				encryptDetails = encryptService.getDiscomInformationData(encryptData);
			} catch (Exception e) {
				encryptDetails = null;
				logger.error("Exception in getting discom information :" + e.getMessage());
				e.printStackTrace();
			}
		}
		logger.debug("discom information : " + encryptDetails);

		try {
			//discomInformation = encryptService.sendPostForDiscomDecryptData(encryptDetails, bill, dis1);
			discomInformation = encryptDecryptService.sendPostForDiscomDecryptData(encryptDetails, bill, dis1);
		} catch (Exception e) {
			logger.error("Exception  sendPostForDiscomDecrptData:" + e.getMessage());
			e.printStackTrace();
		}
		logger.info("discomInformation list size :: " + discomInformation.size());
		
		
		/****************************************************************************************************************************/
		
		String transactionId  ="";
		double d = 0.0;
		int billamount = 0;
		if (discomInformation.size() > 0) {
			d = Double.parseDouble(
					discomInformation.get(0).getTotalAmount().trim().equalsIgnoreCase("NA") ? "0" : discomInformation.get(0).getTotalAmount());

			// d = Double.parseDouble(billInformation.get(0).getBillAmount());

			transactionId = discomInformation.get(0).getTransactionId();
			int x = (int) d;
			int y = x % 10;
			double z = d - x;
			if (y == 0) {
				if (z > 0)
					x = x + 1;
			} else {
				
				switch (y) {
				
					case 1:
						x = x + 9;
						break;
					case 2:
						x = x + 8;
						break;
					case 3:
						x = x + 7;
						break;
					case 4:
						x = x + 6;
						break;
					case 5:
						x = x + 5;
						break;
					case 6:
						x = x + 4;
						break;
					case 7:
						x = x + 3;
						break;
					case 8:
						x = x + 2;
						break;
					case 9:
						x = x + 1;
						break;

				}
				
			}
			billamount = x;
			flag = 1;
		}

		logger.info("Billinfo, billamount : " + billamount+" transactionId : "+transactionId+" ActualAmountt :: "+d+" serviceProverId : "+bill.getServiceProviderID());
		
		Bill infoBill  = new Bill();
		try{
			
			infoBill.setBillAmount(Integer.toString(billamount));
			infoBill.setTransactionId(transactionId);
			infoBill.setBillActualAmount(Double.toString(d));
			infoBill.setServiceProviderID(bill.getServiceProviderID());
			billService.updateBillInformation(infoBill);
		}catch(Exception e ){
			logger.error("Exception in Discom details updateBillInformation : "+e.getMessage());
			e.printStackTrace();
		}
		
		if (flag == 1) {
			req.setAttribute("details", discomInformation);
			req.setAttribute("infobill", infoBill);
			if(langCode==0) 
				return "Discomdetails";
			else
				return "DiscomDetailsHi";
		}
		else {
			//return "redirect:noDetailsFound";
			if(langCode==0) 
				return "redirect:noDetailsFound";
			else
				return "redirect:noDetailsFoundHi";
		}
		
		/*******************************************************************************************************************************/
		
	//	req.setAttribute("details", discomInformation);
		
		//return new ModelAndView("Discomdetails");
	}

	
	@RequestMapping(value = "/discom")
	public ModelAndView discom(HttpServletRequest req) {

		return new ModelAndView("DiscomSearchKey");
	} 
	@RequestMapping(value = "/discomHi")
	public ModelAndView discomHi(HttpServletRequest req) {

		return new ModelAndView("DiscomSearchKeyHi");
	} 
	@RequestMapping(value = "/returnindex")
	public String returnindex(HttpServletRequest req) {

		return "redirect:serviceProviderInfo";
	}

	@RequestMapping(value = "/governmentservice11")
	public ModelAndView govtservice1(Model model, HttpServletRequest req) {
		req.setAttribute("serviceID", req.getParameter("serviceID"));
		return new ModelAndView("birth_death");
	}

	/*@RequestMapping(value = "/governmentservices12")
	public ModelAndView govtservice2(Model model, HttpServletRequest req) {
		req.setAttribute("certificateDetails", "Domicile" );
		return new ModelAndView("GovernmentService");
	}*/
	
	
	@RequestMapping(value = "/governmentservices12")
	public ModelAndView govtservice2(Model model, HttpServletRequest req) {
		String sID = req.getParameter("serviceID");
		String ssID = req.getParameter("subServiceID");
		String serviceName = req.getParameter("serviceName");
		req.setAttribute("serviceName", serviceName);
		req.setAttribute("serviceID", sID);
		req.setAttribute("subServiceID", ssID);
		req.setAttribute("certificateDetails", "Domicile" );
		return new ModelAndView("GovernmentService");
	}

	@RequestMapping(value = "/governmentservicesHi12")
	public ModelAndView govtservice2Hindi(Model model, HttpServletRequest req) {
		/*req.setAttribute("certificateDetails", "Domicile" );*/
		String sID = req.getParameter("serviceID");
		String ssID = req.getParameter("subServiceID");
		String serviceName = req.getParameter("serviceName");
		req.setAttribute("serviceName", serviceName);
		req.setAttribute("serviceID", sID);
		req.setAttribute("subServiceID", ssID);
		req.setAttribute("certificateDetails", "Domicile" );
		return new ModelAndView("GovernmentServiceHi");
	}
	
	@RequestMapping(value = "/phed")
	public ModelAndView phed(HttpServletRequest req) {
		return new ModelAndView("PhedSearchKey");
	}

	@RequestMapping(value = "/phedhi")
	public ModelAndView phedhi(HttpServletRequest req) {
		return new ModelAndView("PhedSearchKeyHi");
	}
	
	/*@RequestMapping(value = "/phedservice", method = RequestMethod.POST)
	public String phedservice(Model model, Bill bill, Phed ph, HttpServletRequest req) throws SQLException {
		bill.setServiceProviderID(2354);
		bill.setSsoID(Login.SSOID);
		int flag = 0;
		// System.out.println("HHEyyeyeyeyeyeyyeyeyeeyyeyeyey::"+dis1.getK_Number());
		// System.out.println("ServiceProviderID :: "+bill.getServiceProviderID()+"
		// serviceProviderName :: "+bill.getServiceProviderName()+
		// " MobileNo : "+bill.getBillMobileNo()+" email id : "+bill.getBillEmail());
		int langCode = Integer.parseInt(req.getParameter("langCode"));
		EncrptDesryptDataService encryptService = new EncrptDesryptDataService();
	//	System.out.println("ppp"+ ph.getWbill_Number()+"mobile"+bill.getBillMobileNo()+"email"+bill.getBillEmail());

		String strToEncrypt = "{'SRVID':'2354','searchKey':'" + ph.getWbill_Number() + "','SSOID':'"+Login.SSOID+"'}";

		if(bill.getBillEmail()==null ||bill.getBillEmail().equals(""))
			bill.setBillEmail("helpdesk.emitra@rajasthan.gov.in");
		
		String encryptData = null;
		String encryptDetails = null;
		List<Phed>phedInformationlist = null;
		try {
			encryptData = encryptService.sendPostForEncryptData(strToEncrypt);
		} catch (Exception e) {
			logger.error("Exception in phedservice for getting encrypt data :" + e.getMessage());
			encryptData = null;
			e.printStackTrace();
		}

		logger.debug("phedservice, encryptData  :" + encryptData);
		if (encryptData != null) {
			try {
				encryptDetails = encryptService.getPhedInformationData(encryptData);
			} catch (Exception e) {
				logger.error("Exception in getPhedInformationData: "+e.getMessage());
				encryptDetails = null;
				e.printStackTrace();
			}
		}
		logger.debug("phedservice, encryptDetails : " + encryptDetails);

		try {
			//phedInformationlist = encryptService.sendPostForPhedDecryptData(encryptDetails, bill, ph);
			phedInformationlist = encryptDecryptService.sendPostForPhedDecryptData(encryptDetails, bill, ph);
		} catch (Exception e) {
			logger.error("Exception phedservice  :" + e.getMessage());
			e.printStackTrace();
		}
		logger.info("phedservice, phedInformationlist " + phedInformationlist.size());
		
		
		
		*//****************************************************************************************************************************//*
		
		String transactionId  ="";
		double d = 0.0;
		int billamount = 0;
		if (phedInformationlist.size() > 0) {
			d = Double.parseDouble(
					phedInformationlist.get(0).getBillAmount().trim().equalsIgnoreCase("NA") ? "0" : phedInformationlist.get(0).getBillAmount());

			// d = Double.parseDouble(billInformation.get(0).getBillAmount());

			transactionId = phedInformationlist.get(0).getTranBillId();
			int x = (int) d;
			int y = x % 10;
			double z = d - x;
			if (y == 0) {
				if (z > 0)
					x = x + 1;
			} else {
				if (y == 1)
					x = x + 9;
				else if (y == 2)
					x = x + 8;
				else if (y == 3)
					x = x + 7;
				else if (y == 4)
					x = x + 6;
				else if (y == 5)
					x = x + 5;
				else if (y == 6)
					x = x + 4;
				else if (y == 7)
					x = x + 3;
				else if (y == 8)
					x = x + 2;
				else if (y == 9)
					x = x + 1;
			}
			billamount = x;
			flag = 1;
		}

		logger.info("Billinfo, billamount : " + billamount+" transactionId : "+transactionId+" ActualAmountt :: "+d+" serviceProverId : "+bill.getServiceProviderID());
		
		Bill infoBill  = new Bill();
		try{
			
			infoBill.setBillAmount(Integer.toString(billamount));
			infoBill.setTransactionId(transactionId);
			infoBill.setBillActualAmount(Double.toString(d));
			infoBill.setServiceProviderID(bill.getServiceProviderID());
			billService.updateBillInformation(infoBill);
		}catch(Exception e ){
			logger.error("Exception in Phed details updateBillInformation : "+e.getMessage());
			e.printStackTrace();
		}
		
		if (flag == 1) {
			req.setAttribute("details", phedInformationlist);
			req.setAttribute("infobill", infoBill);
			if(langCode==0) 
				return "Pheddetails";
			else
			return "PheddetailsHi";
		}
		else {
		//	return "redirect:noDetailsFound";
			if(langCode==0) 
				return "redirect:noDetailsFound";
			else
				return "redirect:noDetailsFoundHi";
		}
		
		*//*******************************************************************************************************************************//*
	}*/
	
	@RequestMapping(value = "/phedservice", method = RequestMethod.POST)
	public String phedservice(Model model, Bill bill, Phed ph, HttpServletRequest req) throws SQLException {
		bill.setServiceProviderID(2354);
		bill.setSsoID(Login.SSOID);
		int flag = 0;
		int langCode = Integer.parseInt(req.getParameter("langCode"));
		EncrptDesryptDataService encryptService = new EncrptDesryptDataService();

		String strToEncrypt = "{'SRVID':'2354','searchKey':'" + ph.getWbill_Number() + "','SSOID':'"+Login.SSOID+"'}";

		if( null == bill.getBillEmail() ||bill.getBillEmail().equals("") )
			bill.setBillEmail("helpdesk.emitra@rajasthan.gov.in");
		
		String encryptData = null;
		String encryptDetails = null;
		List<Phed>phedInformationlist = null;
		try {
			encryptData = encryptService.sendPostForEncryptData(strToEncrypt);
		} catch (Exception e) {
			logger.error("Exception in phedservice for getting encrypt data :" + e.getMessage());
			encryptData = null;
			e.printStackTrace();
		}

		logger.debug("phedservice, encryptData  :" + encryptData);
		if (encryptData != null) {
			try {
				encryptDetails = encryptService.getPhedInformationData(encryptData);
			} catch (Exception e) {
				logger.error("Exception in getPhedInformationData: "+e.getMessage());
				encryptDetails = null;
				e.printStackTrace();
			}
		}
		logger.debug("phedservice, encryptDetails : " + encryptDetails);

		try {
			//phedInformationlist = encryptService.sendPostForPhedDecryptData(encryptDetails, bill, ph);
			phedInformationlist = encryptDecryptService.sendPostForPhedDecryptData(encryptDetails, bill, ph);
		} catch (Exception e) {
			logger.error("Exception phedservice  :" + e.getMessage());
			e.printStackTrace();
		}
		logger.info("phedservice, phedInformationlist " + phedInformationlist.size());
		
		
		
		/****************************************************************************************************************************/
		
		String transactionId  ="";
		double d = 0.0;
		int billamount = 0;
		if (phedInformationlist.size() > 0) {
			d = Double.parseDouble(
					phedInformationlist.get(0).getBillAmount().trim().equalsIgnoreCase("NA") ? "0" : phedInformationlist.get(0).getBillAmount());

			// d = Double.parseDouble(billInformation.get(0).getBillAmount());

			transactionId = phedInformationlist.get(0).getTranBillId();
			int x = (int) d;
			int y = x % 10;
			double z = d - x;
			if (y == 0) {
				if (z > 0)
					x = x + 1;
			} else {
				
				switch (y) {
				
						case 1:
							x = x + 9;
							break;
						case 2:
							x = x + 8;
							break;
						case 3:
							x = x + 7;
							break;
						case 4:
							x = x + 6;
							break;
						case 5:
							x = x + 5;
							break;
						case 6:
							x = x + 4;
							break;
						case 7:
							x = x + 3;
							break;
						case 8:
							x = x + 2;
							break;
						case 9:
							x = x + 1;
							break;
					
				}
				
			}
			billamount = x;
			flag = 1;
		}
		logger.info("Billinfo, billamount : " + billamount+" transactionId : "+transactionId+" ActualAmountt :: "+d+" serviceProverId : "+bill.getServiceProviderID());
		
		Bill infoBill  = new Bill();
		try{
			
			infoBill.setBillAmount(Integer.toString(billamount));
			infoBill.setTransactionId(transactionId);
			infoBill.setBillActualAmount(Double.toString(d));
			infoBill.setServiceProviderID(bill.getServiceProviderID());
			billService.updateBillInformation(infoBill);
		}catch(Exception e ){
			logger.error("Exception in Phed details updateBillInformation : "+e.getMessage());
			e.printStackTrace();
		}
		
		if (flag == 1) {
			req.setAttribute("details", phedInformationlist);
			req.setAttribute("infobill", infoBill);
			if(langCode==0) 
				return "Pheddetails";
			else
			return "PheddetailsHi";
		}
		else {
		//	return "redirect:noDetailsFound";
			if(langCode==0) 
				return "redirect:noDetailsFound";
			else
				return "redirect:noDetailsFoundHi";
		}
		
		/*******************************************************************************************************************************/
	}


/*	@RequestMapping(value = "/birthservice")
	public ModelAndView birthservice(Model model, HttpServletRequest req) {
		req.setAttribute("differ", 0);
		req.setAttribute("certificateDetails", "Birth" );
		return new ModelAndView("birthCertificate");
	}*/

	@RequestMapping(value = "/birthservice", method = RequestMethod.POST)
	public ModelAndView birthservice(Model model, HttpServletRequest req) {
		String sID = req.getParameter("serviceID");
		String ssID = req.getParameter("subServiceID");
		String serviceName = req.getParameter("serviceName");
		req.setAttribute("serviceID", sID);
		req.setAttribute("subServiceID", ssID);
		req.setAttribute("serviceName", serviceName);
		req.setAttribute("differ", 0);
		req.setAttribute("certificateDetails", "Birth" );
		return new ModelAndView("birthCertificate");
	}
	
	
	@RequestMapping(value = "/CertificateService" , method = RequestMethod.POST)
	public ModelAndView birthCertificateService(Model model, HttpServletRequest req, CertificateInfo certificateInfo)
			throws IOException, JSONException, org.json.simple.parser.ParseException, InterruptedException {
		
		/*String rno = certificateInfo.getRegistrationNo();
		String certificateDetails=certificateInfo.getCertificateDetails();
		int langCode = certificateInfo.getLangCode();
		String payload = "";
		int flag = 0;
		// {"registrationNumber":"test/12345678/2016/Birth"}
		int differ = certificateInfo.getCertificateValue();
		int year =certificateInfo.getYear();
		*/
		
		
		String serviceName = certificateInfo.getServiceName();
		String rno = certificateInfo.getRegistrationNo();
		String certificateDetails=certificateInfo.getCertificateDetails();
		int langCode = certificateInfo.getLangCode();
		int flag = 0;
		// {"registrationNumber":"test/12345678/2016/Birth"}
		int differ = certificateInfo.getCertificateValue();
		int year =certificateInfo.getYear();
		String serviceID = certificateInfo.getServiceID();
		String subServiceID = certificateInfo.getSubServiceID();
		String requestUrl = "";
		logger.debug("CertificateService, registrationNo :"+rno+" CertificateValue :"+differ+" year :"+year+" certificateDetails :"+certificateDetails);
		
		
		if (differ == 0)
			     requestUrl="https://emitraapp.rajasthan.gov.in/webServicesRepository/getPehchanCertificateURLWithEmitra?"
					+ "registrationNumber="+rno.trim()+"&year="+year+"&event=1";
		else if (differ == 1)
				 requestUrl="https://emitraapp.rajasthan.gov.in/webServicesRepository/getPehchanCertificateURLWithEmitra?"
						+ "registrationNumber="+rno.trim()+"&year="+year+"&event=2";
		else
				 requestUrl="https://emitraapp.rajasthan.gov.in/webServicesRepository/getPehchanCertificateURLWithEmitra?"
						+ "registrationNumber="+rno.trim()+"&year="+year+"&event=3";
		
		logger.info("CertificateService, requestUrl :"+requestUrl);
		
		//http://reportsemitraapp.rajasthan.gov.in/emitraReportsRepository/getPehchanCertificateURLWithEmitra
		
		
		
		
	//	String requestUrl = "http://reportsemitraapp.rajasthan.gov.in/emitraReportsRepository/getPehchanCertificateURLWithEmitra";
		//String requestUrl = "https://api.sewadwaar.rajasthan.gov.in/app/live/RajeVault/Prod/eSign/webresources/generic/searchdoc?client_id=0bb937ac-fcee-4a9b-ad60-cee32140dcd7" ;
		/*String requestUrl="https://emitraapp.rajasthan.gov.in/webServicesRepository/getPehchanCertificateURLWithEmitra?"
				+ "registrationNumber="+rno.trim()+"&year="+year+"&event=3";*/
		
		try {
			
			URL url = new URL(requestUrl);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// optional default is GET
			connection.setRequestMethod("GET");

			// add request header
			connection.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = connection.getResponseCode();
			if(responseCode!=200) {
				logger.info("CertificateService, response code : "+responseCode+" due to API server error");
				flag = 1;
			}else {
				logger.info("CertificateService, response code : "+responseCode);
			//	System.out.println("content InputStream::" + connection.getInputStream());
				
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer jsonString = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					jsonString.append(line);            
				}
				String s = new String(jsonString);
				String content = "";
	
				JSONParser parser = new JSONParser();
				JSONObject json;
				json = (JSONObject) parser.parse(s);
				
				
				String certiStatusCode = (String) json.get("STATUS_CODE");
				logger.info("CertificateService, certiStatusCode :" + certiStatusCode + " Message " +(String) json.get("MESSAGE"));
				
				if(!certiStatusCode.equals("200")) 
					flag = 1;
				else {
					content = (String) json.get("URL");
					req.setAttribute("url", content);
					logger.info("CertificateService, Show Certificate URL with urlOfPrinting :" + content);
					
					if (null==content || content.equals("") )
						flag = 1;
				
					if (flag == 0) {
						json = billService.downloadfile(json, rno, req);
						String downloadstatus = (String)json.get("STATUS_CODE");
						if(downloadstatus.equalsIgnoreCase("ApiException")) {
							flag = 1;
							logger.info("CertificateService Service :: Error in downloading::"+(String)json.get("ERROR_MESSAGE"));
						}else {
							String arr[] = ((String)json.get("URL")).split("urlOfPrinting=");
							req.setAttribute("url", (String)json.get("URL"));
							logger.info("CertificateService Service :: urlOfPrinting::"+arr[1]);
							req.setAttribute("url1", arr[1]);
						}
						
					}
					
				}
				
			}

		} 
		catch (Exception e) {
			flag = 1;
			logger.error("CertificateService, Exception msg :: " + e.getMessage());
			e.printStackTrace();
		}

		if (flag == 0) {
			/*req.setAttribute("certificateType", certificateDetails);
			req.setAttribute("certificateYear", year);
			req.setAttribute("token", rno);
			if(langCode==0)
				return new ModelAndView("birthCertificatePdf");
			else
				return new ModelAndView("birthCertificatePdfHi");*/
			
			//certificateService.insertCertificateDetails(certificateInfo);
			//String certificateTransID = certificateService.getCertificateTransID(certificateInfo.getRegistrationNo());
			
			String certificateTransID =	certificateService.insertCertificateDetails(certificateInfo);
			req.setAttribute("transactionID", certificateTransID);
			req.setAttribute("serviceID", serviceID);
			req.setAttribute("subServiceID", subServiceID);
			req.setAttribute("serviceName", serviceName);
			
			req.setAttribute("certificateType", certificateDetails);
			req.setAttribute("certificateYear", year);
			req.setAttribute("token", rno);
			Thread.sleep(10000);
			if(langCode==0)
				return new ModelAndView("birthCertificatePdf");
			else
				return new ModelAndView("birthCertificatePdfHi");
		}
		else {
			if(langCode==0)
				return new ModelAndView("noDetailsFound");
			else
				return new ModelAndView("noDetailsFoundHi");
		}
	}
	
/*	@RequestMapping(value = "/CertificateService" , method = RequestMethod.POST)
	public ModelAndView birthCertificateService(Model model, HttpServletRequest req, CertificateInfo certificateInfo)
			throws IOException, JSONException, org.json.simple.parser.ParseException {
		
		String rno = certificateInfo.getRegistrationNo();
		String certificateDetails=certificateInfo.getCertificateDetails();
		int langCode = certificateInfo.getLangCode();
		String payload = "";
		int flag = 0;
		// {"registrationNumber":"test/12345678/2016/Birth"}
		int differ = certificateInfo.getCertificateValue();
		int year =certificateInfo.getYear();
		
		
		
		String serviceName = certificateInfo.getServiceName();
		String rno = certificateInfo.getRegistrationNo();
		String certificateDetails=certificateInfo.getCertificateDetails();
		int langCode = certificateInfo.getLangCode();
		String payload = "";
		int flag = 0;
		// {"registrationNumber":"test/12345678/2016/Birth"}
		int differ = certificateInfo.getCertificateValue();
		int year =certificateInfo.getYear();
		String serviceID = certificateInfo.getServiceID();
		String subServiceID = certificateInfo.getSubServiceID();
		
		logger.debug("CertificateService, registrationNo :"+rno+" CertificateValue :"+differ+" year :"+year+" certificateDetails :"+certificateDetails);
		if (differ == 0)
		//	payload = "{\"registrationNumber\":\"test123/" + rno + "/"+ year +"/Birth\"}";
			payload = "{\"registrationNumber\":\""+rno+"\",\"year\":\""+year+"\",\"event\":\"Birth\"}";
		else if (differ == 1)
		//	payload = "{\"registrationNumber\":\"test123/" + rno + "/"+year+"/Death\"}";
			payload = "{\"registrationNumber\":\""+rno+"\",\"year\":\""+year+"\",\"event\":\"Death\"}";
		else
		//	payload = "{\"registrationNumber\":\"test123/" + rno + "/"+year+"/Marriage\"}";
			payload = "{\"registrationNumber\":\""+rno+"\",\"year\":\""+year+"\",\"event\":\"Marriage\"}";
		
		logger.info("CertificateService, url parameters :"+payload);
		
	//	String requestUrl = "https://apitest.sewadwaar.rajasthan.gov.in/app/live/RajeVault/Staging/eSign/webresources/generic/searchdoc?client_id=ecdd4211-d325-45f9-a0d4-2a5415ec228b";
		String requestUrl = "https://api.sewadwaar.rajasthan.gov.in/app/live/RajeVault/Prod/eSign/webresources/generic/searchdoc?client_id=0bb937ac-fcee-4a9b-ad60-cee32140dcd7" ;
		
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			
			int responseCode = connection.getResponseCode();
			if(responseCode!=200) {
				logger.info("CertificateService, response code : "+responseCode+" due to API server error");
			}else {
				logger.info("CertificateService, response code : "+responseCode);
			//	System.out.println("content InputStream::" + connection.getInputStream());
				
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer jsonString = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					jsonString.append(line);
				}
				String s = new String(jsonString);
				String content = "";
	
				JSONParser parser = new JSONParser();
				JSONObject json;
				json = (JSONObject) parser.parse(s);
				content = (String) json.get("url");
				req.setAttribute("url", content);
				logger.info("CertificateService, Show Certificate URL with urlOfPrinting :" + content);
				if (null==content || content.equals("") )
					flag = 1;
			
				if (flag == 0) {
					String arr[] = content.split("urlOfPrinting=");
					logger.info("CertificateService, urlOfPrinting::"+arr[1]);
					req.setAttribute("url1", arr[1]);
				}
			}

		} 
		catch (Exception e) {
			flag = 1;
			logger.error("CertificateService, Exception msg :: " + e.getMessage());
			e.printStackTrace();
		}

		if (flag == 0) {
			req.setAttribute("certificateType", certificateDetails);
			req.setAttribute("certificateYear", year);
			req.setAttribute("token", rno);
			if(langCode==0)
				return new ModelAndView("birthCertificatePdf");
			else
				return new ModelAndView("birthCertificatePdfHi");
			certificateService.insertCertificateDetails(certificateInfo);
			
			String certificateTransID = certificateService.getCertificateTransID(certificateInfo.getRegistrationNo());
			
			req.setAttribute("transactionID", certificateTransID);
			
			req.setAttribute("serviceID", serviceID);
			req.setAttribute("subServiceID", subServiceID);
			req.setAttribute("serviceName", serviceName);
			
			req.setAttribute("certificateType", certificateDetails);
			req.setAttribute("certificateYear", year);
			req.setAttribute("token", rno);
			if(langCode==0)
				return new ModelAndView("birthCertificatePdf");
			else
				return new ModelAndView("birthCertificatePdfHi");
		}
		else {
			if(langCode==0)
				return new ModelAndView("noDetailsFound");
			else
				return new ModelAndView("noDetailsFoundHi");
		}
	}

	@RequestMapping(value = "/deathservice")
	public ModelAndView deathservice(Model model, HttpServletRequest req) {
		req.setAttribute("differ", 1);
		req.setAttribute("certificateDetails", "Death");
		return new ModelAndView("birthCertificate");
	}*/

	@RequestMapping(value = "/deathservice")
	public ModelAndView deathservice(Model model, HttpServletRequest req) {
		String sID = req.getParameter("serviceID");
		String ssID = req.getParameter("subServiceID");
		String serviceName = req.getParameter("serviceName");
		req.setAttribute("serviceName", serviceName);
		req.setAttribute("serviceID", sID);
		req.setAttribute("subServiceID", ssID);
		req.setAttribute("differ", 1);
		req.setAttribute("certificateDetails", "Death");
		return new ModelAndView("birthCertificate");
	}
	
	/*@RequestMapping(value = "/marriageservice")
	public ModelAndView marriageservice(Model model, HttpServletRequest req) {
		req.setAttribute("differ", 2);
		req.setAttribute("certificateDetails", "Marriage" );
		return new ModelAndView("birthCertificate");
	}*/
	
	@RequestMapping(value = "/marriageservice")
	public ModelAndView marriageservice(Model model, HttpServletRequest req) {
		String sID = req.getParameter("serviceID");
		String ssID = req.getParameter("subServiceID");
		String serviceName = req.getParameter("serviceName");
		req.setAttribute("serviceName", serviceName);
		req.setAttribute("serviceID", sID);
		req.setAttribute("subServiceID", ssID);
		req.setAttribute("differ", 2);
		req.setAttribute("certificateDetails", "Marriage" );
		return new ModelAndView("birthCertificate");
	}
	
	@RequestMapping(value = "/birthservicehi")
	public ModelAndView birthservicehi(Model model, HttpServletRequest req) {
		/*req.setAttribute("differ", 0);
		req.setAttribute("certificateDetails", "Birth" ); */
		String sID = req.getParameter("serviceID");
		String ssID = req.getParameter("subServiceID");
		String serviceName = req.getParameter("serviceName");
		req.setAttribute("serviceID", sID);
		req.setAttribute("subServiceID", ssID);
		req.setAttribute("serviceName", serviceName);
		req.setAttribute("differ", 0);
		req.setAttribute("certificateDetails", "Birth" );
		return new ModelAndView("birthCertificateHi");
	}
	
	@RequestMapping(value = "/deathservicehi")
	public ModelAndView deathservicehi(Model model, HttpServletRequest req) {
		/*req.setAttribute("differ", 1);
		req.setAttribute("certificateDetails", "Death" );*/
		String sID = req.getParameter("serviceID");
		String ssID = req.getParameter("subServiceID");
		String serviceName = req.getParameter("serviceName");
		req.setAttribute("serviceName", serviceName);
		req.setAttribute("serviceID", sID);
		req.setAttribute("subServiceID", ssID);
		req.setAttribute("differ", 1);
		req.setAttribute("certificateDetails", "Death");
		return new ModelAndView("birthCertificateHi");
	}

	@RequestMapping(value = "/marriageservicehi")
	public ModelAndView marriageservicehi(Model model, HttpServletRequest req) {
		/*req.setAttribute("differ", 2);
		req.setAttribute("certificateDetails", "Marriage" );*/
		String sID = req.getParameter("serviceID");
		String ssID = req.getParameter("subServiceID");
		String serviceName = req.getParameter("serviceName");
		req.setAttribute("serviceName", serviceName);
		req.setAttribute("serviceID", sID);
		req.setAttribute("subServiceID", ssID);
		req.setAttribute("differ", 2);
		req.setAttribute("certificateDetails", "Marriage" );
		return new ModelAndView("birthCertificateHi");
	}
	
	/*@RequestMapping(value = "/printPdf11")
	public ModelAndView printPdf11(Model model, HttpServletRequest req) {
		req.setAttribute("url", req.getParameter("govtpdf"));
		return new ModelAndView("prinPDF");
	}*/

	@RequestMapping(value = "/videoconferncing")
	public ModelAndView videoconferncing() {
		new VedioConference().getVedioConference();
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/governmentServiceProviderhindi")
	public ModelAndView governmentServiceProviderhindi(Model model, HttpServletRequest req) {
		return new ModelAndView("GovernmentServiceProviderhindi");
	}

	@RequestMapping(value = "/servicehindi")
	public ModelAndView servicehindi(Model model, HttpServletRequest req, HttpServletResponse response ) {
		
		return new ModelAndView("Servicehindi");
	}
	
	@RequestMapping(value = "/governmentservicehindi11")
	public ModelAndView govtservice1hindi(Model model, HttpServletRequest req) {
		req.setAttribute("serviceID", req.getParameter("serviceID"));
		return new ModelAndView("birth_deathhindi");
	}
	
	@RequestMapping(value = "/paymentByCard")
	public ModelAndView CardpaymentChecksum(Bill bill, HttpServletRequest req) throws Exception {
		String seString="";
		if(bill.getYesorno()==1)
			seString =yesCardMerchantCode+"|"+bill.getTransactionId()+"|"+bill.getBillAmount()+"|"+yesCardCheckSum;
		else
			seString =noCardMerchantCode+"|"+bill.getTransactionId()+"|"+bill.getBillAmount()+"|"+noCardCheckSum;	
		//seString =noCardMerchantCode+"|"+bill.getTransactionId()+"|"+1+"|"+noCardCheckSum;	
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(seString.getBytes());

		byte byteData[] = md.digest();
		
		Formatter formatter = new Formatter();
		try {
			int j = byteData.length;
			for (int i = 0; i < j; i++) {
				byte b = byteData[i];

				formatter.format("%02x", new Object[] { Byte.valueOf(b) });
			}
		//	System.out.println("MD5 Encrypted String: "+formatter.toString());
			//BillController billC=new BillController();
			String encData=cardPaymentEncDetails(bill,formatter.toString());
			req.setAttribute("enc",encData);
			
			if(bill.getYesorno()==1)
				req.setAttribute("merchant",yesCardMerchantCode);
			else
				req.setAttribute("merchant",noCardMerchantCode);
			
			req.setAttribute("flag",bill.getYesorno());
		
	} catch (Exception e) {
		logger.error("Exception in CardpaymentChecksum: "+e.getMessage());
		e.printStackTrace();
	} finally {
		formatter.close();
	}
		return new ModelAndView("CardPayment");
	}
	
	public String cardPaymentEncDetails(Bill bill, String checkSum) throws Exception {
		//String encryptionKey = "E2579841F97C9B6D48C79B4367EFC";
	//	String encryptionKey = cardEncryptionKey;
		String encryptedString="";
		String decryptedString="";
		String merchantCode="";
		String username = bill.getName()==null?"":bill.getName().replaceAll("[^a-zA-Z\\s]", "");
		
		if( !username.equals("") && username.length()>50) {
  			username = username.substring(0, 49);
		}
		if(bill.getYesorno()==1)
			merchantCode=yesCardMerchantCode;
		else
			merchantCode=noCardMerchantCode;
		
		String toBeEncryptedString = "{\"MERCHANTCODE\": \""+merchantCode+"\","
				+ "\"PRN\": \""+bill.getTransactionId()+"\","
				+ "\"REQTIMESTAMP\": \""+bill.getCreatedDate()+"\","
				+"\"PURPOSE\": \"Online purchase\","
				+"\"AMOUNT\": \""+bill.getBillAmount()+"\","
				/*+"\"AMOUNT\": \"1\","*/
				+"\"SUCCESSURL\": \"http://localhost:1000/KioskService/index\","
				+"\"FAILUREURL\": \"http://localhost:1000/KioskService/index\","
				+ "\"CANCELURL\": \"http://localhost:1000/KioskService/index\","
				+ "\"USERNAME\": \""+username+"\","
				+ "\"USERMOBILE\": \""+bill.getBillMobileNo()+"\","
				+ "\"USEREMAIL\": \""+bill.getBillEmail()+"\","
				+ "\"UDF1\": \""+bill.getServiceProviderID()+"\","
				+ "\"UDF2\": \""+bill.getLangCode()+"\","
				+ "\"UDF3\": \"sample 3\","
				+ "\"OFFICECODE\": \"HQ\","
				+ "\"REVENUEHEAD\": \"ProductFee-100.00|MerchantComm-26.00\","
				+ "\"CHECKSUM\": \""+checkSum+"\"}";
		  

	//	System.out.println("Original String = " + toBeEncryptedString);
		logger.info("cardPaymentEncDetails, Original String = " + toBeEncryptedString);
	//	BillController billC= new BillController();
		if(bill.getYesorno()==1)
		{
		 encryptedString = encryptCardDetails(yesCardEncryptionKey, toBeEncryptedString); // Encrypting the string
	     decryptedString = decryptCardDetails(yesCardEncryptionKey, encryptedString); // Decrypting the string
		}
		else
		{
		  encryptedString = encryptCardDetails(noCardEncryptionKey, toBeEncryptedString); // Encrypting the string
		  decryptedString = decryptCardDetails(noCardEncryptionKey, encryptedString); // Decrypting the string
		}
	//	System.out.println("Encrypted String = " + encryptedString);
		logger.info("cardPaymentEncDetails, Encrypted String = " + encryptedString);
	//	System.out.println("Decrypted String = " + decryptedString);
		logger.info("cardPaymentEncDetails, Decrypted String = " + decryptedString);
		return encryptedString; 

	}
	
	public String encryptCardDetails(String key, String toBeEncryptString) {
		if (toBeEncryptString == null) {
			throw new IllegalArgumentException("To be encrypt string must not be null");
		}
		try {
			MessageDigest md = MessageDigest.getInstance(SHA256);
			byte[] byteData = Arrays.copyOf(md.digest(key.getBytes("UTF-8")), 16);

			SecretKeySpec secretKey = new SecretKeySpec(byteData, AES);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(byteData);

			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(ENCRYPT_MODE, secretKey, ivParameterSpec);
			return Base64.encodeBase64String(cipher.doFinal(toBeEncryptString.getBytes("UTF-8")));
		} catch (Exception ex) {
			// Handle exception here
			return null;
		}
	}
	
	public String decryptCardDetails(String key, String toBeDecryptString) {
		if (toBeDecryptString == null) {
			throw new IllegalArgumentException("To be decrypt string must not be null");
		}
		try {
			MessageDigest md = MessageDigest.getInstance(SHA256);
			byte[] byteData = Arrays.copyOf(md.digest(key.getBytes("UTF-8")), 16);

			SecretKeySpec secretKey = new SecretKeySpec(byteData, AES);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(byteData);

			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(DECRYPT_MODE, secretKey, ivParameterSpec);
			return new String(cipher.doFinal(Base64.decodeBase64(toBeDecryptString)));
		} catch (Exception ex) {
			// Handle exception here
			return null;
		}
	}
	
	//Precise Code
	/*public String backToBackCardTrans(String amt,String trnsid, String serviceId,String merchantCode,String transcationId,String PAYMENTMODE) {
		
		logger.info("backToBackTrans, trnsid :"+trnsid+ "amount :"+amt+"service id::"+ serviceId);
		String backToBackTransStatus = null;
		String backToBackTransactionID = null;
		if (trnsid != null) {

			String backToBackurl = billService.getbackToBackurl(amt, trnsid, serviceId,"card");
			String backToBackurl = billService.getbackToBackurl(amt, trnsid, serviceId,"card:"+merchantCode+":"+transcationId);
			logger.info("backToBackTrans, BackToBackurl :"+backToBackurl);
			
			EncrptDesryptDataService eds = new EncrptDesryptDataService();
			String encriptBackTOBackUrl = null;
			try {
				encriptBackTOBackUrl = eds.sendPostForEncryptData(backToBackurl);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("backToBackTrans, encriptBackTOBackUrl :"+encriptBackTOBackUrl);
			String backtoBackUrl = null;
			try {
				backtoBackUrl = eds.sendPostForBacktoBack(encriptBackTOBackUrl);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			logger.info("backToBackTrans, backtoBackUrl :"+backtoBackUrl);
			String decriptBackTOBackUrl = null;
			try {
				decriptBackTOBackUrl = eds.sendPostForDecryptData(backtoBackUrl);
				JSONParser parser = new JSONParser();
		        JSONObject json;
		        json = (JSONObject) parser.parse(decriptBackTOBackUrl);
		        backToBackTransStatus=(String)json.get("TRANSACTIONSTATUS");
                backToBackTransactionID=(String)json.get("TRANSACTIONID");
                
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("backToBackTrans, decriptBackTOBackUrl :"+decriptBackTOBackUrl);
			if(PAYMENTMODE==null || PAYMENTMODE.equals(""))
				PAYMENTMODE = "CARD";
			
			billService.saveBackToBackTransaction(decriptBackTOBackUrl,PAYMENTMODE);
			logger.info("backToBackTrans, Transaction Status :"+backtoBackUrl);
			
			String emitraTransactionFlag = null;
			Bill transactionDetails = new Bill();
			transactionDetails.setBackToBackTransactionStatus(backToBackTransStatus);
			transactionDetails.setBackToBackTransactionID(backToBackTransactionID);
			
			if(transactionDetails.getBackToBackTransactionStatus().equalsIgnoreCase("success"))
			    emitraTransactionFlag = "1";
			else if(transactionDetails.getBackToBackTransactionStatus().equalsIgnoreCase("failure"))
				emitraTransactionFlag = "0";
			
			billService.updateTransactionDetails(emitraTransactionFlag, transactionDetails, trnsid);
			
		}
		return backToBackTransStatus;

	}
	*/
	//Grinnar Developer Updatation code 
	
	
	public String backToBackCardTrans(String amt, String trnsid, String serviceId, String merchantCode,
		String transcationId, String PAYMENTMODE) {

        logger.info("backToBackTrans, trnsid :" + trnsid + "amount :" + amt + "service id::" + serviceId);
        String backToBackTransStatus = null;
        String backToBackTransactionID = null;

        if (StringUtils.isBlank(trnsid)) {
            logger.error("TransactionId is empty.");
            return null;
        }

       
	    try {
	        /* String backToBackurl = billService.getbackToBackurl(amt, trnsid, serviceId,"card"); */
	        String backToBackurl = billService.getbackToBackurl(amt, trnsid, serviceId, "card:" + merchantCode + ":" + transcationId);
	        logger.info("backToBackTrans, BackToBackurl: " + backToBackurl);
	
	        EncrptDesryptDataService eds = new EncrptDesryptDataService();
	
	        String encryptedB2BUrl = eds.sendPostForEncryptData(backToBackurl);
	        logger.info("backToBackTrans, BackTOBackResponse: " + encryptedB2BUrl);
	
	        String backtoBackResponse = eds.sendPostForBacktoBack(encryptedB2BUrl);
	        logger.info("backToBackTrans, backtoBackUrl :" + backtoBackResponse);
	
	        String decryptB2BResponse = eds.sendPostForDecryptData(backtoBackResponse);
	        logger.info("backToBackTrans, decriptBackTOBackResponse :" + decryptB2BResponse);
	
	        org.json.JSONObject json = new org.json.JSONObject(decryptB2BResponse);
	        backToBackTransStatus = json.optString("TRANSACTIONSTATUS");
	        backToBackTransactionID = json.optString("TRANSACTIONID");
	
	        if (StringUtils.isBlank(PAYMENTMODE)) {
	            PAYMENTMODE = "CARD";
	        }
	
	        try {
	            billService.saveBackToBackTransaction(decryptB2BResponse, PAYMENTMODE);
	
	            String emitraTransactionFlag = null;
	            Bill transactionDetails = new Bill();
	            transactionDetails.setBackToBackTransactionStatus(backToBackTransStatus);
	            transactionDetails.setBackToBackTransactionID(backToBackTransactionID);
	
            	if (backToBackTransStatus.equalsIgnoreCase("SUCCESS")) 
	                emitraTransactionFlag = "1";
	            else	
	                emitraTransactionFlag = "0";
	            
	
	            billService.updateTransactionDetails(emitraTransactionFlag, transactionDetails, trnsid);
	
	        } catch (Exception ex) {
	            logger.error("Caught an exception while inserting backToBackCardtransaction details in the DB for transactionId: " + trnsid, ex);
	
	            if (backToBackTransStatus.equalsIgnoreCase("SUCCESS")) {
	                localLogSyncer.writeToLocalLogs(backToBackTransactionID, trnsid, serviceId, amt);
	            }
	            backToBackTransStatus = null;
	        }
	
	    } catch (Exception ex) {
	        logger.error("Caught an exception while processing emitra backToBackCardTransaction for transactionId: " + trnsid, ex);
	    }
	
	    return backToBackTransStatus;

    }
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public ModelAndView getSSOLoginResult(HttpServletRequest req ,HttpServletResponse response) {
		return new ModelAndView("Login");
	}
	// SSO ID login Response method
	@RequestMapping(value = "/login", method = RequestMethod.POST )
	public String getSSOLoginResponseInfornation(HttpServletRequest req ,HttpServletResponse response) {
		
		String SSOID = null;
		String SESSIONID = null;
		String CHECKSUM = null;
		boolean ISVALID = false;
		
		
		String SSOAUTH_RESPONSE = req.getParameter("SSOAUTH_RESPONSE");
		logger.info("getSSOLoginResponseInfornation, SSOAUTH_RESPONSE :"+SSOAUTH_RESPONSE);
		String resp  =new String(Base64.decodeBase64(SSOAUTH_RESPONSE.getBytes()));
		logger.info("getSSOLoginResponseInfornation, SSOAUTH_RESPONSE JSON "+resp);
		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			
			json = (JSONObject) parser.parse(resp);
			SSOID = (String) json.get("SSOID");
			SESSIONID = (String) json.get("SESSIONID");
			ISVALID = (boolean) json.get("ISVALID");
			CHECKSUM = (String) json.get("CHECKSUM");
			
			// ISVALID is false, let's keep the logs for further verification of data
			if(ISVALID == false) {
				
				logger.info("getSSOLoginResponseInfornation, We received ISVALID parameter as a false so process will not go further :");
				logger.info("getSSOLoginResponseInfornation, SSOID = "+SSOID+" , SESSIONID = "+SESSIONID+" , CHECKSUM= "+CHECKSUM);
				
				return "redirect:login";
				
			}
			
			String generatedMD5CheckSum=getMd5HashDetails(SSOID+ "|" +SESSIONID);
			
			logger.info("getSSOLoginResponseInfornation, generatedMD5CheckSum :"+ generatedMD5CheckSum);
			
			if(CHECKSUM.equals(generatedMD5CheckSum)==true) {
				 InetAddress ipAddr = InetAddress.getLocalHost();
				 
				//Storing response data to login property for further use
				Login login=new Login();
				
				login.setCHECKSUM(CHECKSUM);
				
				login.setISVALID(ISVALID);
				
				login.setSESSIONID(SESSIONID);
				
				login.setSSOID(SSOID);
				
				login.setMACHINEIPADDRESS(ipAddr.getHostAddress());
				
				//All validations are seems correct so redirecting to machine SSO Authentication page 
				return "redirect:machinessoauth";
				
			}
			
		}
		catch(Exception e){
			
			logger.error("getSSOLoginResponseInfornation , exception in paring json info ,"+e.getMessage());
			logger.info("getSSOLoginResponseInfornation, SSOI= "+SSOID+" , SESSIONID= "+SESSIONID+" , CHECKSUM= "+CHECKSUM+" , ISVALID= "+ISVALID);
			
			e.printStackTrace();
			
		}
		
		return "redirect:login";
	}

	public String getMd5HashDetails(String plainText) {
		Formatter formatter= new Formatter();
		String mD5CheckSum = "";
		try	{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte byteData[] = md.digest();
			int j = byteData.length;
			for (int i = 0; i < j; i++) {
				byte b = byteData[i];
				formatter.format("%02x", new Object[] { Byte.valueOf(b) });
			}
			mD5CheckSum = formatter.toString();
	    }
		catch(Exception e)	{
			formatter.close();
			logger.error("Exception in getting GetMd5Hash : "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			formatter.close();
		}
		
		return mD5CheckSum;
	}
	
	@RequestMapping(value = "/jamabandiRecord")
	public ModelAndView jamabandiRecord(HttpServletRequest req) {
		String requestUrl ="https://api.sewadwaar.rajasthan.gov.in/app/live/eSeva/Prod/Service/District/Master/getDetails?State_Code=08&User_Name=ws_eseva&Password=ws_eseva%23789&client_id=96f2ea05-8742-401d-aa42-ec269f8a71c0";
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				logger.info("examServiceDetails, response code : " + responseCode + " due to API server error");
			} else {
				logger.info("examServiceDetails, response code : " + responseCode);
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer jsonString = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					jsonString.append(line);
				}
				String s = new String(jsonString);
			//	System.out.println("response:::::"+s);
				logger.info("examServiceDetails, getting JSON details ::" + s);
				JSONParser parser = new JSONParser();
				JSONObject json;
				String s1[]=s.split("\"DocumentElement\":");
				String s2[]=s1[1].split("\"DistrictMaster\":");
			//	System.out.println("response:::::"+s1[1]);
				List<Jamabandi> list=new ArrayList<Jamabandi>();

				for(int i=1;i<s2.length;i++)
				{
					String s4,s5=null;
					Jamabandi jama=new Jamabandi();
				//	System.out.println("response:::::"+s2[i]);
					if(i==(s2.length-1))
					{
						json = (JSONObject)parser.parse(s2[i].substring(0,s2[i].length()-5));
						//s4=new String((StringEscapeUtils.unescapeJava(StringEscapeUtils.unescapeHtml4(URLDecoder.decode(((String) json.get("distname")).replaceAll("%u","\\\\u"),"UTF-8")))));
	
						s4=new String(((String) json.get("distname")).getBytes(),"UTF-8");
						s5=new String(((String) json.get("distno_census")));
						jama.setDistname(s4);
						jama.setDistrict_code(s5);
						list.add(jama);
					}
					else
					{
						json = (JSONObject)parser.parse(s2[i].substring(0,s2[i].length()-1));
						s4=new String(((String) json.get("distname")).getBytes(),"UTF-8");
						s5=new String(((String) json.get("distno_census")));
						jama.setDistname(s4);
						jama.setDistrict_code(s5);
						list.add(jama);
					}
				}
				req.setAttribute("list",list);
				}

		} catch (Exception e) {
			logger.error("examServiceDetails, Exception msg :: " + e.getMessage());
			e.printStackTrace();
		}

		return new ModelAndView("Jamabandi");
	}
	
	
	@RequestMapping(value = "/getTehsilByDistrict", method = RequestMethod.GET)
	public void getTehsilByDistrict(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String distcode=req.getParameter("distcode").trim();
		JSONArray array=new JSONArray();
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		String requestUrl ="https://api.sewadwaar.rajasthan.gov.in/app/live/eSeva/Prod/Service/Tehsil/Master/getDetails?District_Code="+distcode+"&User_Name=ws_eseva&Password=ws_eseva%23789&client_id=96f2ea05-8742-401d-aa42-ec269f8a71c0";
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				logger.info("examServiceDetails, response code : " + responseCode + " due to API server error");
			} else {
				logger.info("examServiceDetails, response code : " + responseCode);
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer jsonString = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					jsonString.append(line);
				}
				String s = new String(jsonString);
				JSONParser parser = new JSONParser();
				JSONObject json;
				String s1[]=s.split("\"DocumentElement\":");
				String s2[]=s1[1].split("\"tehsilmaster\":");
			//	System.out.println("response:::::"+s1[1]);
				for(int i=1;i<s2.length;i++)
				{
					String s4,s5=null;
			//		System.out.println("response:::::"+s2[i]);
					if(i==(s2.length-1))
					{
						json = (JSONObject)parser.parse(s2[i].substring(0,s2[i].length()-5));			
						s4=new String(((String) json.get("tehsilname")).getBytes(),"UTF-8");
						s5=new String(((String) json.get("tehsilno_census")));
						org.json.JSONObject jobj=new org.json.JSONObject();			
						jobj.put("tehsilname",s4) ;
						jobj.put("tehsilno_census",s5);
						array.put(jobj);
					
					}
					else
					{					
						json = (JSONObject)parser.parse(s2[i].substring(0,s2[i].length()-1));
						s4=new String(((String) json.get("tehsilname")).getBytes(),"UTF-8");
						s5=new String(((String) json.get("tehsilno_census")));
						org.json.JSONObject jobj=new org.json.JSONObject();		
					//	System.out.println("tehsilname"+s4);
						jobj.put("tehsilname",s4) ;
						jobj.put("tehsilno_census",s5);
						array.put(jobj);
					}
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		PrintWriter pw=res.getWriter();
		//System.out.println("array is::"+array);
		pw.print(array);
		pw.flush();
		pw.close();
	}
	
	@RequestMapping(value = "/getVillageByTehsil", method = RequestMethod.GET)
	public void getVillageByTehsil(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String distcode=req.getParameter("distcode").trim();
		String tehsilcode=req.getParameter("tehsilcode").trim();
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		JSONArray array=new JSONArray();
		String requestUrl ="https://api.sewadwaar.rajasthan.gov.in/app/live/eSeva/Prod/Service/Village/Master/getDetails?District_Code="+distcode+"&Tehsil_Code="+tehsilcode+"&User_Name=ws_eseva&Password=ws_eseva%23789&client_id=96f2ea05-8742-401d-aa42-ec269f8a71c0";
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				logger.info("examServiceDetails, response code : " + responseCode + " due to API server error");
			} else {
				logger.info("examServiceDetails, response code : " + responseCode);
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer jsonString = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					jsonString.append(line);
				}
				String s = new String(jsonString);
				JSONParser parser = new JSONParser();
				JSONObject json;
				String s1[]=s.split("\"DocumentElement\":");
				String s2[]=s1[1].split("\"VillageMaster\":");
			//	System.out.println("response:::::"+s1[1]);
				for(int i=1;i<s2.length;i++)
				{
				//	System.out.println("response:::::"+s2[i]);
					if(i==(s2.length-1))
					{
					json = (JSONObject)parser.parse(s2[i].substring(0,s2[i].length()-5));				
					org.json.JSONObject jobj=new org.json.JSONObject();			
								
					jobj.put("VILLAGENAME",new String(((String) json.get("VILLAGENAME")))) ;
					jobj.put("VILLAGEID",new String(((String) json.get("villageid_census"))));
					array.put(jobj);
					}
					else
					{
						json = (JSONObject)parser.parse(s2[i].substring(0,s2[i].length()-1));						
						org.json.JSONObject jobj=new org.json.JSONObject();			
						jobj.put("VILLAGENAME",new String(((String) json.get("VILLAGENAME")))) ;
						jobj.put("VILLAGEID",new String(((String) json.get("villageid_census"))));
						array.put(jobj);
					}
				}
			}
		}catch(Exception e)
		{
			
		}
		PrintWriter pw=res.getWriter();
		pw.print(array);
		pw.flush();
		pw.close();
	}
	
	
	
	
	
	
	@RequestMapping(value = "/jamabandiRecordHi")
	public ModelAndView jamabandiRecordHi(HttpServletRequest req) {

		String requestUrl ="https://api.sewadwaar.rajasthan.gov.in/app/live/eSeva/Prod/Service/District/Master/getDetails?State_Code=08&User_Name=ws_eseva&Password=ws_eseva%23789&client_id=96f2ea05-8742-401d-aa42-ec269f8a71c0";
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				logger.info("examServiceDetails, response code : " + responseCode + " due to API server error");
			} else {
				logger.info("examServiceDetails, response code : " + responseCode);
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer jsonString = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					jsonString.append(line);
				}
				String s = new String(jsonString);
			//	System.out.println("response:::::"+s);
				logger.info("examServiceDetails, getting JSON details ::" + s);
				JSONParser parser = new JSONParser();
				JSONObject json;
				String s1[]=s.split("\"DocumentElement\":");
				String s2[]=s1[1].split("\"DistrictMaster\":");
			//	System.out.println("response:::::"+s1[1]);
				List<Jamabandi> list=new ArrayList<Jamabandi>();

				for(int i=1;i<s2.length;i++)
				{
					String s4,s5=null;
					Jamabandi jama=new Jamabandi();
			//		System.out.println("response:::::"+s2[i]);
					if(i==(s2.length-1))
					{
						json = (JSONObject)parser.parse(s2[i].substring(0,s2[i].length()-5));
						//s4=new String((StringEscapeUtils.unescapeJava(StringEscapeUtils.unescapeHtml4(URLDecoder.decode(((String) json.get("distname")).replaceAll("%u","\\\\u"),"UTF-8")))));
	
						s4=new String(((String) json.get("distname")).getBytes(),"UTF-8");
						s5=new String(((String) json.get("distno_census")));
						jama.setDistname(s4);
						jama.setDistrict_code(s5);
						list.add(jama);
					}
					else
					{
						json = (JSONObject)parser.parse(s2[i].substring(0,s2[i].length()-1));
						s4=new String(((String) json.get("distname")).getBytes(),"UTF-8");
						s5=new String(((String) json.get("distno_census")));
						jama.setDistname(s4);
						jama.setDistrict_code(s5);
						list.add(jama);
					}
				}
				req.setAttribute("list",list);
				}

		} catch (Exception e) {
			logger.error("examServiceDetails, Exception msg :: " + e.getMessage());
			e.printStackTrace();
		}

		return new ModelAndView("JamabandiHi");
	}
	
	
	@RequestMapping(value = "/jamabandiservice", method = RequestMethod.POST)
	public ModelAndView jamabandiservice(Model model, Bill bill, Jamabandi jam, HttpServletRequest req) throws SQLException{
		bill.setServiceProviderID(2354);
		bill.setSsoID(Login.SSOID);
		int langCode = Integer.parseInt(req.getParameter("langCode"));
		EncrptDesryptDataService encryptService = new EncrptDesryptDataService();
		logger.info("district"+ jam.getDistrict_code()+"tehsil"+jam.getTehsil_code()+"village code"+jam.getVillage_code()+"khasra"+jam.getKhasra());
		String uname="ws_eseva";
		String pwd="ws_eseva%23789";
		String clientid="96f2ea05-8742-401d-aa42-ec269f8a71c0";
		String strToEncrypt = "https://api.sewadwaar.rajasthan.gov.in/app/live/eSeva/Prod/Service/ROR/getDetails?District_Code="+jam.getDistrict_code().trim()+"&Tehsil_Code="+jam.getTehsil_code().trim()+"&Village_Code="+jam.getVillage_code().trim()+"&Khasra="+jam.getKhasra().trim()+"&User_Name="+uname.trim()+"&Password="+pwd.trim()+"&client_id="+clientid.trim()+"";

		String encryptData = null;
	
		try {
			encryptData = encryptService.sendPostForJamabandiData(strToEncrypt);
			logger.info("jamabandi details ::"+encryptData);
			req.setAttribute("details", encryptData);
			logger.debug("phedservice, encryptData  :" + encryptData);
			String s[]=encryptData.split("\"ROR\":");
			
			JSONParser parser = new JSONParser();
			JSONObject json;
			List<Jamabandi> list=new ArrayList<Jamabandi>();
			for(int i=1;i<s.length;i++)
			{
				json = (JSONObject) parser.parse(s[i].substring(0, s[i].length()-1));
				Jamabandi jama=new Jamabandi();
				if(json.get("id") instanceof String)
				jama.setId((String) json.get("id"));
				else
				jama.setId("");
				if(json.get("rowOrder") instanceof String)
				jama.setRowOrder((String) json.get("rowOrder"));
				else
					jama.setRowOrder("");	
				if(json.get("khata") instanceof String)
				jama.setKhata((String) json.get("khata"));
				else
				jama.setKhata("");
				if(json.get("oldkhata") instanceof String)
				jama.setOldkhata((String) json.get("oldkhata"));
				else
				jama.setOldkhata("");
				if(json.get("OwnerName") instanceof String)
				{
					String s4=new String(((String) json.get("OwnerName")).getBytes(),"UTF-8");
				    jama.setOwnerName(s4);
				}
				else
				jama.setOwnerName("");	
				if(json.get("khasra") instanceof String)
				jama.setKhasra((String) json.get("khasra"));
				else
				jama.setKhasra("");
				if(json.get("khasraarea") instanceof String)
				jama.setKhasraarea((String) json.get("khasraarea"));
				else
				jama.setKhasraarea("");	
				if(json.get("SoilName") instanceof String)
				{
				String s5=new String(((String) json.get("SoilName")).getBytes(),"UTF-8");
				jama.setSoilName(s5);
				}
				else
				jama.setSoilName("");
				if(json.get("SoilArea") instanceof String)
				jama.setSoilArea((String) json.get("SoilArea"));
				else
					jama.setSoilArea("");
				if(json.get("SoilRev") instanceof String)
				jama.setSoilRev((String) json.get("SoilRev"));
				else
					jama.setSoilRev("");
				if(json.get("SoilRate") instanceof String)
				jama.setSoilRate((String) json.get("SoilRate"));
				else
					jama.setSoilRate("");
				if(json.get("areaunit") instanceof String)
				jama.setAreaunit((String) json.get("areaunit"));
				else
					jama.setAreaunit("");
				if(json.get("KhasraIrrigation") instanceof String)
					jama.setKhasraIrrigation((String) json.get("KhasraIrrigation"));
				else
					jama.setKhasraIrrigation("");
				if(json.get("KhasraPlot") instanceof String)
					jama.setKhasraPlot((String) json.get("KhasraPlot"));
				else
					jama.setKhasraPlot("");
				list.add(jama);
			}
			req.setAttribute("details", list);
		} catch (Exception e) {		
			
			logger.error("Exception in phedservice for getting encrypt data :" + e.getMessage());
			//encryptData = null;
			e.printStackTrace();
		}
		
		if(langCode==0)
			return new ModelAndView("JamabandiDetails");
		else
			return new ModelAndView("JamabandiDetailsHi");
	
	}

	

	@RequestMapping(value = "/examservice")
	public ModelAndView examservice(HttpServletRequest req ,HttpServletResponse response) {
		return new ModelAndView("Exam");
	}
	@RequestMapping(value = "/examservicehi")
	public ModelAndView examservicehi(HttpServletRequest req ,HttpServletResponse response) {
		return new ModelAndView("ExamHi");
	}
	@RequestMapping(value = "/examserviceDetails" ,method = RequestMethod.POST)
	public ModelAndView examServiceDetails(HttpServletRequest req, HttpServletResponse response, Jamabandi jama, Bill bill) {

		String requestUrl = "https://api.sewadwaar.rajasthan.gov.in/app/live/eMitra/Prod/bserws/api/Certificate?ExamYear="
				+ jama.getExamYear() + "&ExamName=SEC&ExamType=MAIN&RollNo=" + jama.getRollNo()
				+ "&client_id=96f2ea05-8742-401d-aa42-ec269f8a71c0";
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				logger.info("examServiceDetails, response code : " + responseCode + " due to API server error");
			} else {
				logger.info("examServiceDetails, response code : " + responseCode);
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer jsonString = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					jsonString.append(line);
				}
				String s = new String(jsonString);
				logger.info("examServiceDetails, getting JSON details ::" + s);
				JSONParser parser = new JSONParser();
				JSONObject json;
				json = (JSONObject) parser.parse(s);
				if (((String) json.get("Description")).equals("DATA NOT FOUND") || ((String) json.get("Description"))
						.equals("ERROR: Invalid object name 'BSER-2018.dbo.M2018_SEC_MAIN'."))
					req.setAttribute("MSG", "Invalid roll no,exam year");
				else {
					req.setAttribute("examyear", (Long) json.get("ExamYear"));
					req.setAttribute("examname", (String) json.get("ExamName"));
					req.setAttribute("ExamType", (String) json.get("ExamType"));
					req.setAttribute("RollNo", (String) json.get("RollNo"));
					req.setAttribute("StudentName", (String) json.get("StudentName"));
					req.setAttribute("Gender", (String) json.get("Gender"));
					req.setAttribute("FatherName", (String) json.get("FatherName"));
					req.setAttribute("MotherName", (String) json.get("MotherName"));
					String dob = (String) json.get("DateofBirth");
					if(dob!=null && !dob.equals("")) {
						dob = dob.substring(0,2)+"/"+dob.substring(2,4)+"/"+dob.substring(4,8);
					}
					req.setAttribute("DateofBirth", dob);
					String doi =  (String) json.get("DateofIssue");
					if(doi!=null && !doi.equals("")) {
						doi = doi.substring(0,2)+"/"+doi.substring(2,4)+"/"+doi.substring(4,6);
					}
					req.setAttribute("DateofIssue", doi);
					req.setAttribute("Status", (String) json.get("Status"));
				}

			}

		} catch (Exception e) {
			logger.error("examServiceDetails, Exception msg :: " + e.getMessage());
			e.printStackTrace();
		}

		if (bill.getLangCode() == 0)
			return new ModelAndView("ExamDetails");
		else
			return new ModelAndView("ExamDetailsHi");

	}
	
	
	
	@RequestMapping(value = "/checkVersion", method = RequestMethod.POST)
	@ResponseBody
	public String checkVersionStatus(HttpServletRequest request ,HttpServletResponse response) {
		
		InputStream input = null;
		String flag = "false";
		
		try {

			// Properties properties = (Properties)
			// request.getSession().getAttribute("projectLicense.properties");
			Properties properties = new Properties();
			input = this.getClass().getResourceAsStream("../versionDetail.properties");
			properties.load(input);
			String versionNo = properties.getProperty("version_no");
			String versionDate = properties.getProperty("version_date");
			//System.out.println("Version Properties , Version No : " + versionNo + " Version Date : " + versionDate);
			logger.info("Version Properties , Version No : " + versionNo + " Version Date : " + versionDate);
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				versionNo = new String(decoder.decodeBuffer(versionNo));
				versionDate = new String(decoder.decodeBuffer(versionDate));
				// System.out.println("decode "+decode);
			} catch (IOException e) {
				e.printStackTrace();
			}

			double version_number = Double.parseDouble(versionNo);
		//	System.out.println("Version Properties , Version No : " + version_number + " Version Date : " + versionDate);
			logger.info("Version Properties , Version No : " + version_number + " Version Date : " + versionDate);
			LatestVersionDetails latestVersion = billService.versionCheck();

			if (version_number == latestVersion.getVersionNo() && (versionDate.equals(latestVersion.getCreatedDate())))
				flag = "true";
			else
				flag = flag + "##" + latestVersion.getVersionNo();

		}catch (Exception e) {
			logger.error("Exception in getting Connection "+e.getMessage());
			e.printStackTrace();
		} 
		
		return flag;
	}



	@RequestMapping(value = "/machinessoauth")
	public ModelAndView machineIntegration(Model model, HttpServletRequest req) {	
		try {
			MachineAuth machi = billService.getMachineAuthenticationDetails(Login.SSOID);
			String machineId = machi.getMachineId();
			logger.info("MachineId : "+machineId);
			req.setAttribute("MachineId", machineId);

		} catch (Exception e) {
			logger.error("Exception in machineIntegration: "+e.getMessage());
			e.printStackTrace();
		}
		return new ModelAndView("MachineSSOAuth");
	}

	@RequestMapping(value = "/validateEmitraPlusMachine", method = RequestMethod.GET)
	public String getMachineAuth(HttpServletRequest req, HttpServletResponse response1)
	{
		return "redirect:login";
		
	}
	
	/*@RequestMapping(value = "/validateEmitraPlusMachine", method = RequestMethod.POST)
	public ModelAndView getMachineAuth(HttpServletRequest req, MachineAuth mach1, HttpServletResponse response1)
			throws IOException {
		 
		String SERIALNO = mach1.getMachineId();
		String SSOID = Login.SSOID;

		logger.info("getMachineAuth , MachineId :" + SERIALNO + " SSOID :" + SSOID);
         String URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/validateEmitraPlusMachine";
		//String URL =  "http://reportsemitraapp.rajasthan.gov.in/emitraReportsRepository/validateEmitraPlusMachine";		
		
		
		
		String result = "";

		try {
			
			Properties properties = new Properties();
			InputStream input = this.getClass().getResourceAsStream("../versionDetail.properties");
            properties.load(input);
            String versionNo = properties.getProperty("version_no");
            logger.info("Version Properties , Version No : " + versionNo );
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                    versionNo = new String(decoder.decodeBuffer(versionNo));
            } catch (IOException e) {
                    e.printStackTrace();
            }

          
			URL obj = new URL(URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			con.setDoOutput(true);
			String urlParameters = "SERIALNO=" + SERIALNO + "&SSOID=" + SSOID;;

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
		//	logger.debug("getMachineAuth, Post parameters : " + urlParameters);
			logger.info("getMachineAuth, Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			String trans = response.toString();
		//	System.out.println("getMachineAuth, response :" + trans+" for SSOID : "+SSOID+" and machine id : "+mach1.getMachineId());
			logger.info("getMachineAuth, response :" + trans+" for SSOID : "+SSOID+" and machine id : "+mach1.getMachineId());

			
			  if (trans.equals("TRUE")) {
                  try {
                          result = "index";
                          billService.saveMachineAuth(mach1, SSOID,versionNo);
                  } catch (Exception e) {
                          result = "MachineSSOAuth";
                          req.setAttribute("error", "2");
                          e.printStackTrace();
                  }
          } else {
                  result = "MachineSSOAuth";
                  req.setAttribute("error", "1");
          }
			if (trans.equals("TRUE")) {
				try {
					result = "index";
					billService.saveMachineAuth(mach1, SSOID);
				} catch (Exception e) {
					result = "MachineSSOAuth";
					req.setAttribute("error", "2");
					e.printStackTrace();
				}
			} else {
				result = "MachineSSOAuth";
				req.setAttribute("error", "1");
			}
			
			//result = "index";

		} catch (Exception e) {
			result = "MachineSSOAuth";
			req.setAttribute("error", "2");
			logger.error("getMachineAuth, Exception :" + e.getMessage());
			e.printStackTrace();
		}

		return new ModelAndView(result);

	}*/
	
	//Optimized code
	@RequestMapping(value = "/validateEmitraPlusMachine", method = RequestMethod.POST)
	public ModelAndView getMachineAuth(HttpServletRequest req, MachineAuth mach1, HttpServletResponse response1)
			throws IOException {
		 
		String methodName = "getMachineAuth";
		String SERIALNO = mach1.getMachineId();
		String SSOID = Login.SSOID;

		logger.info("getMachineAuth, MachineId :" + SERIALNO + " SSOID :" + SSOID);
        String URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/validateEmitraPlusMachine";
	//	String URL = "http://reportsemitraapp.rajasthan.gov.in/emitraReportsRepository/validateEmitraPlusMachine";		
		
		String result = "";

		try {
			
			Properties properties = new Properties();
			InputStream input = this.getClass().getResourceAsStream("../versionDetail.properties");
            properties.load(input);
            String versionNo = properties.getProperty("version_no");
            logger.info("Version Properties , Version No : " + versionNo );
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                    versionNo = new String(decoder.decodeBuffer(versionNo));
            } catch (IOException e) {
                    e.printStackTrace();
            }
            
            EncrptDesryptDataService service = new EncrptDesryptDataService();
    		
    		String urlParameters = "SERIALNO=" + SERIALNO + "&SSOID=" + SSOID;
    		String response =  service.getPOSTResponse(methodName, urlParameters, "", URL);

		//	System.out.println("getMachineAuth, response :" + trans+" for SSOID : "+SSOID+" and machine id : "+mach1.getMachineId());
			logger.info(methodName+", response :" + response+" for SSOID : "+SSOID+" and machine id : "+mach1.getMachineId());
			
			if (response.equals("TRUE")) {
                  try {
                          result = "index";
                          billService.saveMachineAuth(mach1, SSOID,versionNo);
                  } catch (Exception e) {
                          result = "MachineSSOAuth";
                          req.setAttribute("error", "2");
                          e.printStackTrace();
                  }
			} else {
                  result = "MachineSSOAuth";
                  req.setAttribute("error", "1");
			}

		} catch (Exception e) {
			result = "MachineSSOAuth";
			req.setAttribute("error", "2");
			logger.error("getMachineAuth, Exception :" + e.getMessage());
			e.printStackTrace();
		}
		
		return new ModelAndView(result);

	}
	
	

	//digitSecure
	

//	@RequestMapping(value = "/paymentByBiomatric")
	public ModelAndView biomatricPaymentChecksum(Bill bill, HttpServletRequest req) throws Exception {
		
		String seString="";
		if(bill.getYesorno()==3)
			seString =digitSecureMerchantCode+"|"+bill.getTransactionId()+"|"+bill.getBillAmount()+"|"+digitSecureCheckSum;
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(seString.getBytes());

		
		byte byteData[] = md.digest();

		Formatter formatter = new Formatter();
		try {
			int j = byteData.length;
			for (int i = 0; i < j; i++) {
				byte b = byteData[i];

				formatter.format("%02x", new Object[] { Byte.valueOf(b) });
			}
	
			//BillController billC=new BillController();
			String encData=digitSecurePaymentEncDetails(bill,formatter.toString());
			req.setAttribute("enc",encData);
			
			if(bill.getYesorno()==3)
				req.setAttribute("merchant",digitSecureMerchantCode);
//			else
//				req.setAttribute("merchant",noCardMerchantCode);
			
			req.setAttribute("flag",bill.getYesorno());
		
		
		
	} catch (Exception e) {
		logger.error("Exception in DigitSecurepaymentChecksum: "+e.getMessage());
		e.printStackTrace();
	} finally {
		formatter.close();
	}
		return new ModelAndView("DigitSecurePayment");
	}
	
	
	public String digitSecurePaymentEncDetails(Bill bill, String checkSum) throws Exception {
		
		String encryptedString="";
		String decryptedString="";
		String merchantCode="";
		String username = bill.getName()==null?"":bill.getName().replaceAll("[^a-zA-Z\\s]", "");
		
		if( !username.equals("") && username.length()>50) {
  			username = username.substring(0, 49);
		}
		if(bill.getYesorno()==3)
			merchantCode=digitSecureMerchantCode;

		
		String toBeEncryptedString = "{\"MERCHANTCODE\": \""+merchantCode+"\","
				+ "\"PRN\": \""+bill.getTransactionId()+"\","
				+ "\"REQTIMESTAMP\": \""+bill.getCreatedDate()+"\","
				+"\"PURPOSE\": \"Online purchase\","
				+"\"AMOUNT\": \""+bill.getBillAmount()+"\","
				/*+"\"AMOUNT\": \"1\","*/
				+"\"SUCCESSURL\": \"http://localhost:1000/KioskService/index\","
				+"\"FAILUREURL\": \"http://localhost:1000/KioskService/index\","
				+ "\"CANCELURL\": \"http://localhost:1000/KioskService/index\","
				+ "\"USERNAME\": \""+username+"\","
				+ "\"USERMOBILE\": \""+bill.getBillMobileNo()+"\","
				+ "\"USEREMAIL\": \""+bill.getBillEmail()+"\","
				+ "\"UDF1\": \""+bill.getServiceProviderID()+"\","
				+ "\"UDF2\": \""+bill.getLangCode()+"\","
				+ "\"UDF3\": \"sample 3\","
				+ "\"OFFICECODE\": \"HQ\","
				+ "\"REVENUEHEAD\": \"ProductFee-100.00|MerchantComm-26.00\","
				+ "\"CHECKSUM\": \""+checkSum+"\"}";
		  

	//	System.out.println("Original String = " + toBeEncryptedString);
		logger.info("digitSecurePaymentEncDetails, Original String = " + toBeEncryptedString);
	//	BillController billC= new BillController();
		if(bill.getYesorno()==3)
		{
			 encryptedString = encryptCardDetails(digitSecureEncryptionKey, toBeEncryptedString); // Encrypting the string
		     decryptedString = decryptCardDetails(digitSecureEncryptionKey, encryptedString); // Decrypting the string
			
		}
		
		logger.info("digitSecurePaymentEncDetails, Encrypted String = " + encryptedString);
		System.out.println("Decrypted String = " + decryptedString);
		logger.info("digitSecurePaymentEncDetails, Decrypted String = " + decryptedString);
		return encryptedString; 
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView getCardDetailsAfterPayment(HttpServletRequest req){
		//String encryptionKey = "E2579841F97C9B6D48C79B4367EFC";
		String cardDecryptedDetails="";
		String seString="";
		String merchantcode = req.getParameter("MERCHANTCODE");
		String encdata = req.getParameter("ENCDATA");
		String status = req.getParameter("STATUS");
	//	String CheckSum=req.getParameter("EncCS");
		logger.info("getCardDetailsAfterPayment, merchantcode : "+merchantcode+" status : "+status);
		
		if(merchantcode.equalsIgnoreCase(yesCardMerchantCode))
			cardDecryptedDetails=decryptCardDetails(yesCardEncryptionKey,encdata);
		
		else if(merchantcode.equalsIgnoreCase(noCardMerchantCode))
			cardDecryptedDetails=decryptCardDetails(noCardEncryptionKey,encdata);
		
		else if(merchantcode.equalsIgnoreCase(digitSecureMerchantCode))
			cardDecryptedDetails=decryptCardDetails(digitSecureEncryptionKey,encdata);
		
	//	System.out.println("cardDecryptedDetails : "+cardDecryptedDetails);
		logger.info("getCardDetailsAfterPayment, cardDecryptedDetails : "+cardDecryptedDetails);
		boolean isCheckSumFlag = false; 
		String UDF2="";
		JSONParser parser = new JSONParser();
		JSONObject json;
		String backToBackStatus="";
		try {
			json = (JSONObject) parser.parse(cardDecryptedDetails);
			// System.out.println("fetch details" );
			String MERCHANTCODE = (String) json.get("MERCHANTCODE");
			String REQTIMESTAMP = (String) json.get("REQTIMESTAMP");
			String PRN = (String) json.get("PRN");
			String RPPTXNID = (String) json.get("RPPTXNID");
			String AMOUNT = (String) json.get("AMOUNT");
			String RPPTIMESTAMP = (String) json.get("RPPTIMESTAMP");
			String STATUS = (String) json.get("STATUS");
			String RESPONSECODE = (String) json.get("RESPONSECODE");
			String RESPONSEMESSAGE = (String) json.get("RESPONSEMESSAGE");
			String PAYMENTMODE = (String) json.get("PAYMENTMODE");
			String PAYMENTMODEBID = (String) json.get("PAYMENTMODEBID");
			String PAYMENTMODETIMESTAMP = (String) json.get("PAYMENTMODETIMESTAMP");
			String PAYMENTAMOUNT = (String) json.get("PAYMENTAMOUNT");
			String UDF1 = (String) json.get("UDF1");
			UDF2 = (String) json.get("UDF2");
			String UDF3 = (String) json.get("UDF3");
			String CHECKSUM = (String) json.get("CHECKSUM");
			
			CardPaymentDetails cpd= new CardPaymentDetails();
			cpd.setMERCHANTCODE(MERCHANTCODE);
			cpd.setREQTIMESTAMP(REQTIMESTAMP);
			cpd.setPRN(PRN);
			cpd.setRPPTXNID(RPPTXNID);
			cpd.setAMOUNT(AMOUNT);
			cpd.setRPPTIMESTAMP(RPPTIMESTAMP);
			cpd.setSTATUS(STATUS);
			cpd.setRESPONSECODE(RESPONSECODE);
			cpd.setRESPONSEMESSAGE(RESPONSEMESSAGE);
			cpd.setPAYMENTMODE(PAYMENTMODE);
			cpd.setPAYMENTMODEBID(PAYMENTMODEBID);
			cpd.setPAYMENTMODETIMESTAMP(PAYMENTMODETIMESTAMP);
			cpd.setPAYMENTAMOUNT(PAYMENTAMOUNT);
			cpd.setUDF1(UDF1);
			cpd.setUDF2(UDF2);
			cpd.setUDF3(UDF3);
			cpd.setCHECKSUM(CHECKSUM);
			
			billService.saveCardPaymentDetails(cpd);
			List<Bill>  billdetails=billService.getPaymentInfo(PRN);
			String amt = billdetails.get(0).getBillAmount();
			String serviceid = String.valueOf(billdetails.get(0).getServiceProviderID());
			String transactionid = billdetails.get(0).getTransactionId();
			
			logger.info("getCardDetailsAfterPayment, amt :"+amt+" serviceid :"+serviceid+" transactionid :"+transactionid);
			if(!STATUS.equalsIgnoreCase("SUCCESS") && !RESPONSECODE.equals("00") && PAYMENTMODE.equals("NA")){
				logger.info("getCardDetailsAfterPayment, Card Payment Error Occured");
				req.setAttribute("RPPFLAG", "1");
				req.setAttribute("RPPMSG", RESPONSEMESSAGE);
				req.setAttribute("RPPSERVICEID", serviceid);
				req.setAttribute("RPPTXNID", RPPTXNID);
				req.setAttribute("RPPPRN", PRN);
				backToBackStatus="";
			}else {
			
		//	System.out.println("getCardDetailsAfterPayment, billdetails :: "+billdetails);
			if(merchantcode.equalsIgnoreCase(yesCardMerchantCode))
				seString =MERCHANTCODE+"|"+PRN+"|"+RPPTXNID+"|"+AMOUNT+"|"+yesCardCheckSum;
			
			else if(merchantcode.equalsIgnoreCase(noCardMerchantCode))
				seString =MERCHANTCODE+"|"+PRN+"|"+RPPTXNID+"|"+AMOUNT+"|"+noCardCheckSum;
			
			else if(merchantcode.equalsIgnoreCase(digitSecureMerchantCode))
				seString =MERCHANTCODE+"|"+PRN+"|"+RPPTXNID+"|"+AMOUNT+"|"+digitSecureCheckSum;
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(seString.getBytes());

			byte byteData[] = md.digest();
			String generatedCheckSum = "";
			Formatter formatter = new Formatter();
			try {
				int j = byteData.length;
				for (int i = 0; i < j; i++) {
					byte b = byteData[i];

					formatter.format("%02x", new Object[] { Byte.valueOf(b) });
				}
			//	System.out.println("MD5 Encrypted String: "+formatter.toString());
				generatedCheckSum = formatter.toString();
				
			} catch (Exception e) {
				generatedCheckSum = "";
				e.printStackTrace();
				formatter.close();
				logger.error("getCardDetailsAfterPayment Exception in generating checksum, generatedCheckSum :"+generatedCheckSum+" exception :"+e.getMessage());
			} finally {
				formatter.close();
			}
			
			//System.out.println("getCardDetailsAfterPayment generatedCheckSum : "+generatedCheckSum);
			logger.info("getCardDetailsAfterPayment, generatedCheckSum : "+generatedCheckSum);
			
			if(generatedCheckSum.equals(CHECKSUM)) {
				isCheckSumFlag = true;
			}

			//System.out.println("isCheckSumFlag :"+isCheckSumFlag);
			logger.info("getCardDetailsAfterPayment, isCheckSumFlag : "+isCheckSumFlag+" RPPTXNID: "+RPPTXNID+" STATUS: "+STATUS
					+" RESPONSECODE: "+RESPONSECODE+ ": PAYMENTMODE : "+PAYMENTMODE);
			if(STATUS.equalsIgnoreCase("SUCCESS") && RESPONSECODE.equals("00") && !PAYMENTMODE.equals("NA") && isCheckSumFlag) {
		//	if(STATUS.equalsIgnoreCase("SUCCESS")  && isCheckSumFlag) {
				logger.info("getCardDetailsAfterPayment, payment status :"+isCheckSumFlag);
				billService.updateTransactionDetails(PRN);
				
				backToBackStatus =  backToBackCardTrans(amt, transactionid, serviceid,MERCHANTCODE,RPPTXNID, PAYMENTMODE);
				
				String backToBackTransactionID = billService.getBacktoBacktransactionId(PRN);
			//	String bankRefNumber = 	billService.getBankReferenceNumber(backToBackTransactionID);
				req.setAttribute("bankRefNumber", RPPTXNID);
				req.setAttribute("details", billdetails);
				req.setAttribute("tdate",billdetails.get(0).getCreatedDate());
				req.setAttribute("tid",backToBackTransactionID );
			//	req.setAttribute("receipt", billdetails.get(0).getrECEIPTNO());
				
			}
			}
			
		} catch (Exception e) {
			backToBackStatus="";
			logger.error("Exception in getCardDetailsAfterPayment: "+e.getMessage());
			e.printStackTrace();
		}
		
		
		if(backToBackStatus.equalsIgnoreCase("success")){
			if(UDF2.equals("0"))
				return new ModelAndView("paymentSuccessful");
			else
				return new ModelAndView("paymentSuccessfulHi");
		}else{
			if(UDF2.equals("0"))
				return new ModelAndView("paymentError");
			else
				return new ModelAndView("paymentErrorHi");
		}
		
	}
	
	
	@RequestMapping(value = "/generateRefundOTP", method = RequestMethod.POST)
	public String generateRefundOTP(HttpServletRequest req){
		
		String param = "{\"SSOID\":\"" +Login.SSOID + "\",\"MERCHANTCODE\":\"EMITRAPLUS\"}";
		
		//Lets check whether AadharNumber is already present for Logged In SSOID at our end
		//If already present then skip getAadharNumber API functionality
		//else call getAadharNumber and update our DB for Logged In SSOID
		
		String aadharNumber = null;
		
		EncrptDesryptDataService encryptService = new EncrptDesryptDataService();
		
		String encryptData = null;
		
		try {
			
			encryptData = encryptService.sendPostForEncryptData(param);
			
		} catch (Exception e1) {
			logger.error("generateRefundOTP, Exxception "+e1.getMessage() );
			e1.printStackTrace();
			
		}
		
		//sending SSOID and MERCHANTCODE to E-Mitra to get Aadhar Number
		String response = encryptService.sendPostSSOIDAndMarchant(encryptData);
		
		aadharNumber = encryptDecryptService.getAadharNumber(response);
		logger.info("generateRefundOTP , SSOID : "+Login.SSOID+" with aadhar card number : "+aadharNumber);
		//Just hardcode for now
		aadharNumber = "201464372557";
		req.getServletContext().setAttribute("aadharNumber", aadharNumber);
		
		//calling AADHAR URL
		AadharServices aadharServices = new AadharServices();
		Map<String, Object> aadharMap = aadharServices.aadharOtpGeneration(aadharNumber, EncrptDesryptDataService.URL_OTP_GEN);
		
		if(aadharMap!=null && aadharMap.size()>0) {
			
			String transactionID = (String) aadharMap.get("txnId");
			String aadharStatus = (String) aadharMap.get("status");
			
			req.getServletContext().setAttribute("transactionID", transactionID);
			req.getServletContext().setAttribute("aadharStatus", aadharStatus);
			
			req.setAttribute("OTPSent","Sent");
			logger.info("generateRefundOTP is success for SSOID : "+Login.SSOID  );
			
		}
		
		
		return "index";
		
	}
	
	
	@RequestMapping(value = "/verifyRefundOTP", method = RequestMethod.POST)
	public String verifyRefundOTP(HttpServletRequest req){
		
		//String generatedOTP = (String)req.getServletContext().getAttribute("OTP");
		
		String aadharOtp = req.getParameter("otp");
		
		String transactionID = (String)req.getServletContext().getAttribute("transactionID");
		
	//	String aadharStatus = (String)req.getServletContext().getAttribute("aadharStatus");
		
		String aadharNumber = (String) req.getServletContext().getAttribute("aadharNumber");
		
		if(aadharNumber!=null && transactionID!=null && aadharOtp!=null) {
		
			String webPath = req.getSession().getServletContext().getRealPath("/uidResource/");
			
			webPath = webPath.replace("\\", File.separator);
		//	System.out.println("webPath: "+webPath);
			
			AadharServices aadharServices = new AadharServices();
			
			String docXml = aadharServices.getXmlForAadharOtpAuthSimple(aadharNumber , transactionID , aadharOtp , webPath);
			
			JSONObject jsonMemberDetails = aadharServices.getResponseStringForAadhar(docXml , EncrptDesryptDataService.URL_OTP_AUTH);
			
			boolean isStatusYes = false;
			String status = null;
			if(jsonMemberDetails != null && !jsonMemberDetails.isEmpty()) {
				status = String.valueOf(((JSONObject)jsonMemberDetails.get("authresponse")).get("status"));
				
				if(status.equals("200")) {
					String authStatus = (String) ((JSONObject)((JSONObject)jsonMemberDetails.get("authresponse")).get("auth")).get("status");
					if(authStatus.equals("y")) {
						isStatusYes = true;
					}
				}
			}
	
			logger.info("verifyRefundOTP, Error while getting response for OTP verification. status code is "+status);
			
			if(isStatusYes)
				return "refund";
			
			req.setAttribute("OTPCorrect", "No");
			
			return "index";
		}

		return "index";
			
	}
	
}
