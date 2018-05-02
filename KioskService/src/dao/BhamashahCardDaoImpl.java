package dao;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.DBServiceResponse;
import model.Login;
import model.QueryDetails;
import utils.DBHTTPUtils;

@Repository("bhamashahCardDao")
public class BhamashahCardDaoImpl implements BhamashahCardDao {

	static final Logger logger = Logger.getLogger(BhamashahCardDaoImpl.class);
	
	@Autowired
    private DBHTTPUtils dbHTTPUtils;
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getIFSCDetails(String ifscCode) {
		// TODO Auto-generated method stub
		JSONObject bankDetails = new JSONObject();
		
		try {
            QueryDetails queryDetails = new QueryDetails("select_bankdetails");
            queryDetails.setAutoCommit(false);

            queryDetails.addQueryParams(1, ifscCode);
            
            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
            logger.info("Response status of selectBankDetails:" + serviceResponse.getStatus());
            if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
                JSONArray resultSet = serviceResponse.getJsonArray();
                if (null != resultSet && resultSet.length() > 0) {
                	org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
                	bankDetails.put("BANK_NAME", rs.optString("BANK_NAME"));
                	bankDetails.put("BRANCH_ADDRESS", rs.optString("BRANCH_ADDRESS"));
                }
            }
        } catch (Exception ex) {
            logger.error("Exception in selectBankDetails : ", ex);
        }
		
		return bankDetails;
	}

	@Override
	public void insertEntryIntoLog(JSONObject responseObj) {
		// TODO Auto-generated method stub
		
		try {
            QueryDetails queryDetails = new QueryDetails("sp_bhamashah_otp_log_details");
            queryDetails.setAutoCommit(false);

            queryDetails.addQueryParams(1, "insertbhamashahotplogdetails");
            queryDetails.addQueryParams(2, String.valueOf(responseObj.get("MOBILE_NO")));
            queryDetails.addQueryParams(3, String.valueOf(responseObj.get("TXN_ID")));
            queryDetails.addQueryParams(4, String.valueOf(responseObj.get("OTP")));
            queryDetails.addQueryParams(5, String.valueOf(responseObj.get("MSG")));
            queryDetails.addQueryParams(6, String.valueOf(responseObj.get("CURRENT_TS")));

            DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
            logger.info("Response status of insertMobileOTPInformation:" + serviceResponse.getStatus());
        } catch (Exception ex) {
            logger.error("Exception in insertMobileOTPInformation : ", ex);
        }
	}

	@Override
	public String insertUidAuthDetails(JSONObject serviceDataJson) {
		// TODO Auto-generated method stub
		String requestId = null;
		
		try {
            QueryDetails queryDetails = new QueryDetails("sp_bhamashah_paymentdetails");
            queryDetails.setAutoCommit(false);

            queryDetails.addQueryParams(1, "bhamashahinsert");
            queryDetails.addQueryParams(2, null);
			queryDetails.addQueryParams(3, null);
			queryDetails.addQueryParams(4, null);
			queryDetails.addQueryParams(5, String.valueOf(serviceDataJson.get("aadharId")));
			queryDetails.addQueryParams(6, null);
			queryDetails.addQueryParams(7, null);
			queryDetails.addQueryParams(8, null);
			queryDetails.addQueryParams(9, null);
			queryDetails.addQueryParams(10, String.valueOf(serviceDataJson.get("amount")));
			queryDetails.addQueryParams(11, String.valueOf(serviceDataJson.get("serviceProviderID")));
			queryDetails.addQueryParams(12, String.valueOf(serviceDataJson.get("serviceProviderName")));
			queryDetails.addQueryParams(13, null);
			queryDetails.addQueryParams(14, null);
			queryDetails.addQueryParams(15, null);
			queryDetails.addQueryParams(16, String.valueOf(serviceDataJson.get("aadharOtp")));
			queryDetails.addQueryParams(17, String.valueOf(serviceDataJson.get("txnId")));
			queryDetails.addQueryParams(18, null);
			queryDetails.addQueryParams(19, null);
			queryDetails.addQueryParams(20, String.valueOf(serviceDataJson.get("modeOfPage")));
            
            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
            logger.info("Response status of insertBhamashahPaymentDetails:" + serviceResponse.getStatus());
            if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
                JSONArray resultSet = serviceResponse.getJsonArray();
                if (null != resultSet && resultSet.length() > 0) {
                	org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
                	requestId = rs.optString("request_ID");
                }
            }
        } catch (Exception ex) {
            logger.error("Exception in insertBhamashahPaymentDetails : ", ex);
        }
		
		return requestId;
	}
	
	@Override
	public String updateBhamashahPaymentDetails(HttpServletRequest request , JSONObject memberData) {
		// TODO Auto-generated method stub
		String transId = null;
		
		try {
			transId = saveCertificateDetails(request , memberData);
			
            QueryDetails queryDetails = new QueryDetails("sp_bhamashah_paymentdetails");
            queryDetails.setAutoCommit(false);

            queryDetails.addQueryParams(1, "bhamashahupdate");
			queryDetails.addQueryParams(2, String.valueOf(memberData.get("HOF_NAME_ENG")));
			queryDetails.addQueryParams(3, String.valueOf(memberData.get("MEMBER_TYPE")));
			queryDetails.addQueryParams(4, String.valueOf(memberData.get("M_ID")));
			queryDetails.addQueryParams(5, null);
			queryDetails.addQueryParams(6, String.valueOf(memberData.get("BHAMASHAH_ID")));
			queryDetails.addQueryParams(7, String.valueOf(memberData.get("MOBILE_NO")) == null || String.valueOf(memberData.get("MOBILE_NO")).equals("")? null : String.valueOf(memberData.get("MOBILE_NO")));
			queryDetails.addQueryParams(8, String.valueOf(memberData.get("ACCOUNT_NUMBER")) == null || String.valueOf(memberData.get("ACCOUNT_NUMBER")).equals("")? null : String.valueOf(memberData.get("ACCOUNT_NUMBER")));
			queryDetails.addQueryParams(9, String.valueOf(memberData.get("IFSC_CODE")).equals("")? null : String.valueOf(memberData.get("IFSC_CODE")));
			queryDetails.addQueryParams(10, null);
			queryDetails.addQueryParams(11, null);
			queryDetails.addQueryParams(12, null);
			queryDetails.addQueryParams(13, null);
			queryDetails.addQueryParams(14, String.valueOf(request.getParameter("transactionID")));//transId
			queryDetails.addQueryParams(15, transId);//transId
			queryDetails.addQueryParams(16, null);
			queryDetails.addQueryParams(17, null);
			queryDetails.addQueryParams(18, String.valueOf(memberData.get("UPDATE_FLAG")));
			queryDetails.addQueryParams(19,String.valueOf(1));

            DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
            logger.info("Response status of updateBhamashahPaymentDetails:" + serviceResponse.getStatus());
        } catch (Exception ex) {
            logger.error("Exception in updateBhamashahPaymentDetails : ", ex);
        }
		
		return transId;
	}
	
	public String saveCertificateDetails(HttpServletRequest request , JSONObject serviceDataJson) {

		String transID = null;
		
		try {
			String consumerKey = null;
			String updateFlag = String.valueOf(serviceDataJson.get("UPDATE_FLAG"));
			if(updateFlag.equalsIgnoreCase("M")) {
				consumerKey = String.valueOf(serviceDataJson.get("ADDHAR_NO"))+"-"+String.valueOf(serviceDataJson.get("MOBILE_NO"));
			}else if(updateFlag.equalsIgnoreCase("A")) {
				consumerKey = String.valueOf(serviceDataJson.get("ADDHAR_NO"))+"-"+String.valueOf(serviceDataJson.get("ACCOUNT_NUMBER"));
			}
			
            QueryDetails queryDetails = new QueryDetails("Proc_PrintCertificate");
            queryDetails.setAutoCommit(false);

            queryDetails.addQueryParams(1 , "Insert");
			queryDetails.addQueryParams(2 , consumerKey);
			queryDetails.addQueryParams(3 , 0);
			queryDetails.addQueryParams(4 , String.valueOf(serviceDataJson.get("MOBILE_NUMBER_BILL")));
			queryDetails.addQueryParams(5 , Login.SSOID);
			queryDetails.addQueryParams(6 , String.valueOf(request.getParameter("serviceProviderID")));
			queryDetails.addQueryParams(7 , String.valueOf(request.getParameter("subServiceID")));
			queryDetails.addQueryParams(8 , String.valueOf(request.getParameter("serviceProviderName")));
			queryDetails.addQueryParams(9 , null);
            
            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
            logger.info("Response status of saveCertificateDetails:" + serviceResponse.getStatus());
            if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
                JSONArray resultSet = serviceResponse.getJsonArray();
                if (null != resultSet && resultSet.length() > 0) {
                	org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
                	transID = rs.optString("TransId");
                }
            }
        } catch (Exception ex) {
            logger.error("Exception in saveCertificateDetails : ", ex);
        }
		return transID;
	}


	@Override
	public org.json.JSONObject getUpdateDetails(String transId , String action) {
		// TODO Auto-generated method stub
		
		org.json.JSONObject responseJson = new org.json.JSONObject();
		try {
            QueryDetails queryDetails = new QueryDetails("sp_bhamashah_paymentdetails");
            queryDetails.setAutoCommit(false);

            queryDetails.addQueryParams(1, action);
            queryDetails.addQueryParams(2, transId);
            
            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
            logger.info("Response status of getUpdateDetails:" + serviceResponse.getStatus());
            if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
                JSONArray resultSet = serviceResponse.getJsonArray();
                if (null != resultSet && resultSet.length() > 0) {
                	org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
                	responseJson = rs;
                }
            }
        } catch (Exception ex) {
            logger.error("Exception in getUpdateDetails : ", ex);
        }
		
		return responseJson;
	}

	@Override
	public void updateBhamashahStatus(String transId, String status) {
		// TODO Auto-generated method stub
		try {
            QueryDetails queryDetails = new QueryDetails("sp_bhamashah_paymentdetails");
            queryDetails.setAutoCommit(false);

            queryDetails.addQueryParams(1, "bhamashahupdatestatus");
            queryDetails.addQueryParams(2, transId);
			queryDetails.addQueryParams(3, status);
            
			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
            logger.info("Response status of insertBhamashahPaymentDetails:" + serviceResponse.getStatus());
        } catch (Exception ex) {
            logger.error("Exception in insertBhamashahPaymentDetails : ", ex);
        }
	}
}