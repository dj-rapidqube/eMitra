package service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import model.DisabilityCertificateInfo;

public interface DisabilityService {

	public Map<String, Object> uidOtpGeneration(String aadharId);

	public HashMap<String, String> authOTP(String otp, String txnId, String aadharNo ,String serialNo,  HttpServletRequest req) throws Exception;

	public String saveDisabilityCertificateDetails(DisabilityCertificateInfo disabilityinfo);

}
