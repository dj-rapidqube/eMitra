package service;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

public interface BhamashahCardService {

	public JSONObject uidOtpGeneration(String uid, String modeOfPage);

	public JSONObject uidOtpAuth(HttpServletRequest request, JSONObject serviceDataJson);

	public JSONObject getOtpForMobileVerify(String mobileNo , String txnId);

	public JSONObject getIFSCDetails(String ifscCode);

	public JSONObject updateMobileAccountNumber(String transId , String updateCount , String languageCode);

	public String updateBhamashahPaymentDetails(HttpServletRequest request , JSONObject data);

	public JSONObject statusForUpdateNumber(JSONObject memberData, String updateFlag);

	public String convertDate(String date);

	public void updateBhamashahStatus(String transId, String string);
}