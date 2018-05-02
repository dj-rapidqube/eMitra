package dao;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

public interface BhamashahCardDao {

	public JSONObject getIFSCDetails(String ifscCode);
	
	public void insertEntryIntoLog(JSONObject responseObj);
	
	public String updateBhamashahPaymentDetails(HttpServletRequest request , JSONObject memberData);

	public String insertUidAuthDetails(JSONObject serviceDataJson);

	public org.json.JSONObject getUpdateDetails(String transId , String action);

	public void updateBhamashahStatus(String transId, String status);
}