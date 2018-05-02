package controller;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import model.DisabilityCertificateInfo;
import model.NoteType;
import service.DisabilityService;
import service.DisabilityServiceImpl;
import webServicesRepository.utility.EncrptDesryptDataService;

@EnableWebMvc
@Controller
public class DisabilityController {

	@Autowired
	DisabilityService disabilityService;
	
	static final Logger logger = Logger.getLogger(DisabilityController.class);

	@RequestMapping(value = "/disabilityCertificate", method = RequestMethod.POST)
	public ModelAndView disabilityCertificate(Model model, HttpServletRequest req , @ModelAttribute("disability") DisabilityCertificateInfo disability) {
		
		disability.setCertificateDetails("Disability");
		req.setAttribute("serviceID", disability.getServiceID());
		req.setAttribute("subServiceID", disability.getSubServiceID());
		req.setAttribute("serviceName", disability.getServiceName());
		req.setAttribute("authaadhar", "No");
		req.setAttribute("certificateDetails",disability.getCertificateDetails());
		if(disability.getLangCode().equalsIgnoreCase("0"))
			return new ModelAndView("DisabilityCertificate");
		return new ModelAndView("DisabilityCertificatehi");
	}

	@RequestMapping(value = "/disabilityAuthRequest", method = RequestMethod.POST)
	public ModelAndView getdisabilityAuthRequest(HttpServletRequest req , @ModelAttribute("disability") DisabilityCertificateInfo disability) throws IOException {
		
		Map<String, Object> dataMap = disabilityService.uidOtpGeneration(disability.getAddhaarid());
		disability.setOtptransectionId(dataMap.get("txnId")+"");
		disability.setOtpstatus(dataMap.get("status")+"");
		if("y".equalsIgnoreCase((String) dataMap.get("status"))) {
			req.setAttribute("langCode", disability.getLangCode());
			req.setAttribute("applicationno", disability.getSerialNo());
			req.setAttribute("addhaarid", disability.getAddhaarid());
			req.setAttribute("serviceID", disability.getServiceID());
			req.setAttribute("subServiceID", disability.getSubServiceID());
			req.setAttribute("serviceName", disability.getServiceName());
			req.setAttribute("otptransectionId",disability.getOtptransectionId());
			req.setAttribute("otpstatus",disability.getOtpstatus());
			req.setAttribute("certificateDetails",disability.getCertificateDetails());
			logger.info("getdisabilityAuthRequest:: otp Details :  OTP Generated for Aadhaar ID "+disability.getAddhaarid());
			req.setAttribute("authaadhar", "Yes");
		}
		else {
			req.setAttribute("authaadhar", "No");
			req.setAttribute("serviceID", disability.getServiceID());
			req.setAttribute("subServiceID", disability.getSubServiceID());
			req.setAttribute("serviceName", disability.getServiceName());
			req.setAttribute("certificateDetails",disability.getCertificateDetails());
			req.setAttribute("otpstatus",disability.getOtpstatus());
			req.setAttribute("adharError", (String)(dataMap.get("message")));
		}
		if(disability.getLangCode().equalsIgnoreCase("0"))
			return new ModelAndView("DisabilityCertificate");
		return new ModelAndView("DisabilityCertificatehi");
		
	}
	
	@RequestMapping(value = "/disabilityOtpAuthChecking", method = RequestMethod.POST)
	public ModelAndView getdisabilityOtpAuthChecking(@RequestParam("aadhaar_otp") String otp, HttpServletRequest req , @ModelAttribute("disability") DisabilityCertificateInfo disability)
			throws IOException, SQLException, InterruptedException {
		String txnId = disability.getOtptransectionId();
		HashMap<String,String> map = null;
		try {
//			DisabilityServiceImpl d = new DisabilityServiceImpl();
//			map = d.CertificateServicedisability("SAP/2017/181458", "469479675528", req);
			 map = disabilityService.authOTP(otp, txnId, disability.getAddhaarid() ,disability.getSerialNo() , req);
			 logger.info("getdisabilityOtpAuthChecking Response Details :"+map+" for AadhaarID : "+disability.getAddhaarid());
			 if ("200".equalsIgnoreCase((String) map.get("STATUS_CODE")) && map.get("URL").lastIndexOf(".pdf")!=-1) {
				 String transID = disabilityService.saveDisabilityCertificateDetails(disability);
				 disability.setTransID(transID);
				 String certificatePath = (String) map.get("URL");
				String arr[] = certificatePath.split("urlOfPrinting=");
				disability.setCertificatePath(certificatePath);
				req.setAttribute("url1", arr[1]);
				req.setAttribute("url", disability.getCertificatePath());
				req.setAttribute("serviceName", disability.getServiceName());
				req.setAttribute("certificateType", disability.getCertificateDetails());
				req.setAttribute("serviceID", disability.getServiceID());
				req.setAttribute("subServiceID", disability.getSubServiceID());
				req.setAttribute("langCode", disability.getLangCode());
				req.setAttribute("token", disability.getAddhaarid());
				req.setAttribute("transactionID", disability.getTransID());
				Thread.sleep(8000);
				if (disability.getLangCode().equalsIgnoreCase("0")) {
					return new ModelAndView("DisabilityCertificatepdf");
				}
				return new ModelAndView("DisabilityCertificatepdfhi");

			}else if("Error".equalsIgnoreCase((String)map.get("STATUS_CODE"))){
				logger.info("otp Details :  OTP Authenticated failed for AadhaarId : "+disability.getAddhaarid());
				req.setAttribute("authaadhar", "Yes");
				req.setAttribute("langCode", disability.getLangCode());
				req.setAttribute("applicationno", disability.getSerialNo());
				req.setAttribute("addhaarid", disability.getAddhaarid());
				req.setAttribute("serviceID", disability.getServiceID());
				req.setAttribute("subServiceID", disability.getSubServiceID());
				req.setAttribute("serviceName", disability.getServiceName());
				req.setAttribute("otpstatus",disability.getOtpstatus());
				req.setAttribute("certificateDetails",disability.getCertificateDetails());
				if(disability.getLangCode().equalsIgnoreCase("0")) {
					req.setAttribute("message", "wrong OTP.");
					return new ModelAndView("DisabilityCertificate");
				}else {
					req.setAttribute("message", "OTP गलत  है !");
					return new ModelAndView("DisabilityCertificatehi");
				}
			}else if("ApiException".equalsIgnoreCase((String)map.get("STATUS_CODE"))) {
				logger.info("DisabilityCertificateService, response code : "+map.get("RESPONSE_CODE")+" due to API server error for AadhaarID : "+disability.getAddhaarid());
				logger.error("DisabilityCertificateService, Exception msg :: " + map.get("ERROR_MESSAGE")+"for AadhaarID : "+disability.getAddhaarid());
				if(disability.getLangCode().equalsIgnoreCase("0"))
					return new ModelAndView("noDetailsFound");
				else
					return new ModelAndView("noDetailsFoundHi");
			}else {
				req.setAttribute("authaadhar", "No");
				req.setAttribute("serviceID", disability.getServiceID());
				req.setAttribute("subServiceID",disability.getSubServiceID());
				req.setAttribute("serviceName", disability.getServiceName());
				req.setAttribute("adharError", (String)map.get("MESSAGE"));
				req.setAttribute("certificateDetails", disability.getCertificateDetails());
				if(disability.getLangCode().equalsIgnoreCase("0")) 
					return new ModelAndView("DisabilityCertificate");
				return new ModelAndView("DisabilityCertificatehi");
			}
		}catch(Exception e) {
			if(disability.getLangCode().equalsIgnoreCase("0"))
				return new ModelAndView("noDetailsFound");
			else
				return new ModelAndView("noDetailsFoundHi");
		}
		
	}
	
	@RequestMapping(value = "/DisabilityServicePaymentmode", method = RequestMethod.POST)
	public ModelAndView check(HttpServletRequest req , @ModelAttribute("disability") DisabilityCertificateInfo disability) throws IOException, ParseException, SQLException {
		req.setAttribute("url", disability.getCertificateUrl());
		String langCode = disability.getLangCode();
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
			req.setAttribute("certiTransID", disability.getTransID());
			
			req.setAttribute("serviceID", disability.getServiceID());
			req.setAttribute("subServiceID", disability.getSubServiceID());
			req.setAttribute("serviceName", disability.getServiceName());
			
			req.setAttribute("certificateType", disability.getCertificateDetails());
			req.setAttribute("token", disability.getAddhaarid());
			if(langCode.equalsIgnoreCase("0"))
				return new ModelAndView("ServicePaymentmode");
			else
				return new ModelAndView("ServicePaymentmodehi");
		 }else
		 {
			 return new ModelAndView("Login");
		 }
	}
	@RequestMapping(value = "/deletedownload", method = RequestMethod.POST)
    @ResponseBody
    public String deletefile(HttpServletRequest req) {
		String directory = System.getProperty( "catalina.base" ) + "\\webapps" + File.separator + "disability";
		File file = new File(directory);
		boolean isdelete = false;
		if(file.exists() && file.isDirectory()) {
			File allfile[] = file.listFiles();
			for(int i=0;i<allfile.length;i++) {
				if(allfile[i].isFile()) {
					allfile[i].delete();
					isdelete = true;
				}
			}
		}
		if(isdelete)
			return "success";
		else
			return "Fail";
	}

}
