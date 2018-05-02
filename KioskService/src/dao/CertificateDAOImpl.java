package dao;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bill;
import model.CertificateInfo;
import model.DBServiceResponse;
import model.Login;
import model.QueryDetails;
import utils.DBHTTPUtils;

@Repository("certificateDao")
public class CertificateDAOImpl implements CertificateDAO {

    static final Logger logger = Logger.getLogger(BillDAOImpl.class);
	
	 @Autowired
	 DBHTTPUtils dbHTTPUtils;
	/*
	@Override
	public String insertCertificateDetails(CertificateInfo certiInfo) {
		String procedureCall = "";
		Connection connection = null;
		String dbTransID=null;
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			connection.setAutoCommit(false);
			procedureCall = "{call [Proc_PrintCertificate](?,?,?,?,?,?,?,?)}";
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "Insert");
			callableSt.setString(2, certiInfo.getRegistrationNo());
			callableSt.setInt(3, certiInfo.getYear());
			callableSt.setString(4, "");
			callableSt.setString(5, Login.SSOID);
			//callableSt.setString(6, certiInfo.getServiceID());
			callableSt.setString(6, ((certiInfo.getServiceID()=="") || (certiInfo.getServiceID()== null))?"2289":certiInfo.getServiceID());
			callableSt.setString(7, certiInfo.getSubServiceID());
			callableSt.setString(8, certiInfo.getServiceName());
			//callableSt.execute();
			ResultSet rs= callableSt.executeQuery();
            if(rs.next()) {
            	dbTransID = rs.getString("TransId");
            }
			connection.commit();
		} catch (Exception e) {
			logger.error("Exception in insertCertificateDetails : "+e.getMessage());
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return dbTransID;
	}
*/
	 
	 @Override
	    public String insertCertificateDetails(CertificateInfo certiInfo) {
	        String dbTransID = null;
	        try {
	            QueryDetails queryDetails = new QueryDetails("Proc_PrintCertificate");
	            queryDetails.setAutoCommit(false);

	            queryDetails.addQueryParams(1, "Insert");
	            queryDetails.addQueryParams(2, certiInfo.getRegistrationNo());
	            queryDetails.addQueryParams(3, certiInfo.getYear());
	            queryDetails.addQueryParams(4, "");
	            queryDetails.addQueryParams(5, Login.SSOID);
	            queryDetails.addQueryParams(6, ((certiInfo.getServiceID() == "") || (certiInfo.getServiceID() == null)) ? "2289" : certiInfo.getServiceID());
	            queryDetails.addQueryParams(7, certiInfo.getSubServiceID());
	            queryDetails.addQueryParams(8, certiInfo.getServiceName());

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
	                dbTransID = rs.optString("TransId");
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in insertCertificateDetails : ", ex);
	        }

	        return dbTransID;
	    }
	 
/*	@Override
	public String getCertificateTransID(String certiInfo) {
		String procedureCall = "";
		Connection connection = null;
		String trnsid="";
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			procedureCall = "{call [Proc_PrintCertificate](?,?)}";
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "Select");
			callableSt.setString(2, certiInfo);
			ResultSet rs= callableSt.executeQuery();
            if(rs.next()) {
            	trnsid = rs.getString("TranId");
            }
			
		} catch (Exception e) {
			logger.error("Exception in getCertificateTransID : "+e.getMessage());
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}	
		return trnsid;
	}
*/
	 
	 
	  @Override
	    public String getCertificateTransID(String certiInfo) {
	        String trnsid = "";
	        try {
	            QueryDetails queryDetails = new QueryDetails("Proc_PrintCertificate");
	            queryDetails.setAutoCommit(false);

	            queryDetails.addQueryParams(1, "Select");
	            queryDetails.addQueryParams(2, certiInfo);

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
	                trnsid = rs.optString("TranId");
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in getCertificateTransID : ", ex);
	        }

	        return trnsid;
	    }
	  
	  
	  
	/*@Override
	public Bill getCertiPrintBillDetails(Bill bill) {

		Bill printCertiBillInfo =new Bill();
		String procedureCall = "";
		Connection connection = null;
		CallableStatement callableSt =  null;
		logger.info("getCertiPrintBillDetails, serviceProviderID : "+bill.getServiceProviderID());
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			procedureCall =  "{call [proc_kiosk](?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "ShowCertiPrintRerceipt");
			callableSt.setString(2,bill.getTransactionId());
			ResultSet rs=callableSt.executeQuery();
			if (rs.next()) {
				printCertiBillInfo.setBillAmount(rs.getString("TRANSAMT"));
				printCertiBillInfo.setBillMobileNo(rs.getString("MobileNo"));
				printCertiBillInfo.setrECEIPTNO(rs.getString("RECEIPTNO"));
				printCertiBillInfo.setCertiBackToBackTransactionID(rs.getString("TRANSACTIONID"));
				printCertiBillInfo.setCertiServiceID(rs.getString("ServiceId"));
				printCertiBillInfo.setCertiSubServiceID(rs.getString("SubServiceId"));
				printCertiBillInfo.setTransactionDate(rs.getString("TransactionDate"));
				printCertiBillInfo.setmSG(rs.getString("MSG"));
				printCertiBillInfo.setPaymentMode(rs.getString("PaymentMode"));
			}
		} catch (Exception e) {
			logger.error("Exception in getCertiPrintBillDetails : "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return printCertiBillInfo;
	
	}*/
	  
	  
	  @Override
	    public Bill getCertiPrintBillDetails(Bill bill) {

	        Bill printCertiBillInfo = new Bill();
	        logger.info("getCertiPrintBillDetails, serviceProviderID : " + bill.getServiceProviderID());
	        try {
	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "ShowCertiPrintRerceipt");
	            queryDetails.addQueryParams(2, bill.getTransactionId());

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();

	            if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
	                printCertiBillInfo.setBillAmount(rs.optString("TRANSAMT"));
	                printCertiBillInfo.setBillMobileNo(rs.optString("MobileNo"));
	                printCertiBillInfo.setrECEIPTNO(rs.optString("RECEIPTNO"));
	                printCertiBillInfo.setCertiBackToBackTransactionID(rs.optString("TRANSACTIONID"));
	                printCertiBillInfo.setCertiServiceID(rs.optString("ServiceId"));
	                printCertiBillInfo.setCertiSubServiceID(rs.optString("SubServiceId"));
	                printCertiBillInfo.setTransactionDate(rs.optString("TransactionDate"));
	                printCertiBillInfo.setmSG(rs.optString("MSG"));
	                printCertiBillInfo.setPaymentMode(rs.optString("PaymentMode"));
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in getCertiPrintBillDetails : ", ex);
	        }

	        return printCertiBillInfo;
	    }



}
