package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
// import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bill;
import model.CardPaymentDetails;
import model.DBServiceResponse;
import model.LatestVersionDetails;
import model.Login;
import model.MachineAuth;
import model.QueryDetails;
import utils.DBHTTPUtils;
import utils.TimeUtils;
import webServicesRepository.utility.EncrptDesryptDataService;

@Repository("billDao")
public class BillDAOImpl implements BillDAO {

	static final Logger logger = Logger.getLogger(BillDAOImpl.class);

	@Autowired
	private DBHTTPUtils dbHTTPUtils;

	/*
	 * public void updateBillInformation(Bill infoBill) { String procedureCall = "";
	 * Connection connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [proc_kiosk](?,?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "addPayAmount"); callableSt.setString(2, infoBill.getTransactionId());
	 * callableSt.setString(3, infoBill.getBillAmount()); callableSt.execute();
	 * 
	 * connection.commit(); } catch (Exception e) {
	 * logger.error("Exception in updateBillInformation : "+e.getMessage());
	 * e.printStackTrace(); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */

	public void updateBillInformation(Bill infoBill) {
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "addPayAmount");
			queryDetails.addQueryParams(2, infoBill.getTransactionId());
			queryDetails.addQueryParams(3, infoBill.getBillAmount());

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of updateBillInformation:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in updateBillInformation : ", ex);
		}
	}

	/*
	 * @Override public Bill getPrintBillDetails(Bill bill) {
	 * 
	 * Bill printBillInfo =new Bill(); String procedureCall = ""; Connection
	 * connection = null; CallableStatement callableSt = null;
	 * logger.info("getPrintBillDetails, serviceProviderID : "+bill.
	 * getServiceProviderID()); try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [proc_kiosk](?,?)}"; callableSt =
	 * connection.prepareCall(procedureCall); if(bill.getServiceProviderID()==1214)
	 * callableSt.setString(1, "ShowPrintRerceiptAirtel"); else
	 * if(bill.getServiceProviderID()==1219) callableSt.setString(1,
	 * "ShowPrintRerceiptVoda"); else if(bill.getServiceProviderID()==1220)
	 * callableSt.setString(1, "ShowPrintRerceiptIdea");
	 * 
	 * callableSt.setString(2,bill.getTransactionId()); ResultSet
	 * rs=callableSt.executeQuery(); if (rs.next()) {
	 * printBillInfo.setBillAmount(bill.getBillAmount());
	 * printBillInfo.setBillMobileNo(rs.getString("mobilenumber"));
	 * printBillInfo.setBillActualAmount(rs.getString("amountafterduedate").equals(
	 * "") ? bill.getBillAmount() : rs.getString("amountafterduedate") );
	 * printBillInfo.setDueDate(rs.getString("duedate"));
	 * printBillInfo.setrECEIPTNO(rs.getString("RECEIPTNO"));
	 * printBillInfo.settRANSACTIONID(rs.getString("TRANSACTIONID"));
	 * printBillInfo.setName(rs.getString("consumername"));
	 * printBillInfo.setServiceProviderName(rs.getString("servicename"));
	 * printBillInfo.setBillEmail(rs.getString("EmailId"));
	 * printBillInfo.setTransactionDate(rs.getString("TransactionDate"));
	 * printBillInfo.setmSG(rs.getString("MSG")); //
	 * System.out.println("1::"+rs.getString("RECEIPTNO")+"2::"+rs.getString(
	 * "TRANSACTIONID")); }
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in getPrintBillDetails : "+e.getMessage());
	 * e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return printBillInfo;
	 * 
	 * }
	 */

	/*
	 * @Override public Bill getPrintBillDetails(Bill bill) {
	 * 
	 * Bill printBillInfo =new Bill(); String procedureCall = ""; Connection
	 * connection = null; CallableStatement callableSt = null;
	 * logger.info("getPrintBillDetails, serviceProviderID : "+bill.
	 * getServiceProviderID()); try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [proc_kiosk](?,?)}"; callableSt =
	 * connection.prepareCall(procedureCall); if(bill.getServiceProviderID()==1214)
	 * callableSt.setString(1, "ShowPrintRerceiptAirtel"); else
	 * if(bill.getServiceProviderID()==1219) callableSt.setString(1,
	 * "ShowPrintRerceiptVoda"); else if(bill.getServiceProviderID()==1220)
	 * callableSt.setString(1, "ShowPrintRerceiptIdea"); else
	 * if(bill.getServiceProviderID()==1223) callableSt.setString(1,
	 * "ShowPrintRerceiptDiscom"); else if(bill.getServiceProviderID()==2354)
	 * callableSt.setString(1, "ShowPrintRerceiptPhed"); else
	 * if(bill.getServiceProviderID()==2575) callableSt.setString(1,
	 * "ShowPrintRerceiptBSNL");
	 * 
	 * //Optimized code switch(bill.getServiceProviderID()) { case 1214:
	 * callableSt.setString(1, "ShowPrintRerceiptAirtel"); break; case 1219:
	 * callableSt.setString(1, "ShowPrintRerceiptVoda"); break; case 1220:
	 * callableSt.setString(1, "ShowPrintRerceiptIdea"); break; case 1223:
	 * callableSt.setString(1, "ShowPrintRerceiptDiscom"); break; case 2354:
	 * callableSt.setString(1, "ShowPrintRerceiptPhed"); break; case 2575:
	 * callableSt.setString(1, "ShowPrintRerceiptBSNL"); break; }
	 * 
	 * callableSt.setString(2,bill.getTransactionId()); ResultSet
	 * rs=callableSt.executeQuery(); if (rs.next()) {
	 * printBillInfo.setBillAmount(rs.getString("billamount"));
	 * 
	 * printBillInfo.setBillMobileNo(rs.getString("consumerkeyvalue"));
	 * 
	 * printBillInfo.setBillActualAmount(rs.getString("payAmount").equals("") ?
	 * rs.getString("billamount") : rs.getString("payAmount") );
	 * 
	 * if(bill.getServiceProviderID() == 1223 || bill.getServiceProviderID() == 2354
	 * )
	 * printBillInfo.setDueDate(rs.getString("ChequeDueDate").equalsIgnoreCase("na")
	 * ? "NA" : rs.getString("ChequeDueDate")); else
	 * printBillInfo.setDueDate(rs.getString("duedate").equalsIgnoreCase("na") ?
	 * "NA" : rs.getString("duedate"));
	 * 
	 * printBillInfo.setrECEIPTNO(rs.getString("RECEIPTNO"));
	 * printBillInfo.settRANSACTIONID(rs.getString("TRANSACTIONID"));
	 * printBillInfo.setName(rs.getString("consumername"));
	 * printBillInfo.setServiceProviderName(rs.getString("servicename"));
	 * printBillInfo.setBillEmail(rs.getString("EmailId"));
	 * printBillInfo.setTransactionDate(rs.getString("TransactionDate"));
	 * printBillInfo.setmSG(rs.getString("MSG"));
	 * printBillInfo.setPaymentMode(rs.getString("PaymentMode")); //
	 * System.out.println("1::"+rs.getString("RECEIPTNO")+"2::"+rs.getString(
	 * "TRANSACTIONID")); }
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in getPrintBillDetails : "+e.getMessage());
	 * e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return printBillInfo;
	 * 
	 * }
	 */

	@Override
	public Bill getPrintBillDetails(Bill bill) {

		Bill printBillInfo = new Bill();
		logger.info("getPrintBillDetails, serviceProviderID : " + bill.getServiceProviderID());
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");

			if (bill.getServiceProviderID() == 1214)
				queryDetails.addQueryParams(1, "ShowPrintRerceiptAirtel");
			else if (bill.getServiceProviderID() == 1219)
				queryDetails.addQueryParams(1, "ShowPrintRerceiptVoda");
			else if (bill.getServiceProviderID() == 1220)
				queryDetails.addQueryParams(1, "ShowPrintRerceiptIdea");
			else if (bill.getServiceProviderID() == 1223)
				queryDetails.addQueryParams(1, "ShowPrintRerceiptDiscom");
			else if (bill.getServiceProviderID() == 2354)
				queryDetails.addQueryParams(1, "ShowPrintRerceiptPhed");
			else if (bill.getServiceProviderID() == 2575)
				queryDetails.addQueryParams(1, "ShowPrintRerceiptBSNL");

			queryDetails.addQueryParams(2, bill.getTransactionId());

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);

					printBillInfo.setBillAmount(rs.optString("billamount"));
					printBillInfo.setBillMobileNo(rs.optString("consumerkeyvalue"));

					printBillInfo.setBillActualAmount(rs.optString("payAmount").equals("") ? rs.optString("billamount")
							: rs.optString("payAmount"));

					if (bill.getServiceProviderID() == 1223 || bill.getServiceProviderID() == 2354) {
						printBillInfo.setDueDate(rs.optString("ChequeDueDate").equalsIgnoreCase("na") ? "NA"
								: rs.optString("ChequeDueDate"));
					} else {
						printBillInfo.setDueDate(
								rs.optString("duedate").equalsIgnoreCase("na") ? "NA" : rs.optString("duedate"));
					}

					printBillInfo.setrECEIPTNO(rs.optString("RECEIPTNO"));
					printBillInfo.settRANSACTIONID(rs.optString("TRANSACTIONID"));
					printBillInfo.setName(rs.optString("consumername"));
					printBillInfo.setServiceProviderName(rs.optString("servicename"));
					printBillInfo.setBillEmail(rs.optString("EmailId"));
					printBillInfo.setTransactionDate(rs.optString("TransactionDate"));
					printBillInfo.setmSG(rs.optString("MSG"));
					printBillInfo.setPaymentMode(rs.optString("PaymentMode"));
				}
			}

		} catch (Exception ex) {
			logger.error("Exception in getPrintBillDetails : ", ex);
		}

		return printBillInfo;
	}

	/*
	 * public String getbackToBackurl(String amt,String trnsid, String serviceId,
	 * String flag) {
	 * 
	 * String procedureCall = ""; String serviceHead=null; String backToBackurl =
	 * null; Connection connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [proc_kiosk](?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall);
	 * 
	 * //Optimized code switch(serviceId) { case "1219": callableSt.setString(1,
	 * "selectprintrerceiptVoda"); break; case "1214": callableSt.setString(1,
	 * "selectprintrerceipt"); break; case "1220": callableSt.setString(1,
	 * "selectprintrerceiptIdea"); break; case "1223": callableSt.setString(1,
	 * "selectprintrerceiptDiscom"); break; case "2354": callableSt.setString(1,
	 * "selectprintrerceiptPhed"); break; case "2575": callableSt.setString(1,
	 * "selectprintrerceiptBSNL"); break; }
	 * 
	 * 
	 * callableSt.setString(2, trnsid); ResultSet rs=callableSt.executeQuery();
	 * if(rs.next()) { String transid=rs.getString("TransId"); String
	 * timestamp=rs.getString("gettimestamp"); // String
	 * billamount=rs.getString("amountafterduedate"); String
	 * consumerkey=rs.getString("consumerkeyvalue"); String
	 * consumerName=rs.getString("consumername"); String
	 * serviceid=rs.getString("ServiceId"); String
	 * officeCode=rs.getString("officecodevalue"); String lookupid =
	 * rs.getString("lookupid"); String mobileNumber =
	 * rs.getString("MobileNumber")==null?"": rs.getString("MobileNumber"); String
	 * emailId= rs.getString("EmailId")==null ? "" : rs.getString("EmailId");
	 * 
	 * 
	 * //Optimozed code switch(serviceId) {
	 * 
	 * case "1214": serviceHead="212-"+amt+"|213-5.00"; break;
	 * 
	 * case "1220": serviceHead="217-"+amt+"|219-5.00"; break;
	 * 
	 * case "1216": serviceHead="214-"+amt+"|215-5.00"; break;
	 * 
	 * case "1219": serviceHead="218-"+amt+"|220-5.00"; break;
	 * 
	 * case "1223":
	 * 
	 * if(Integer.parseInt(amt)<=2000) serviceHead="230-"+amt+"|231-5.00"; else
	 * if(Integer.parseInt(amt)>2000 && Integer.parseInt(amt)<=5000)
	 * serviceHead="230-"+amt+"|231-8.00"; else if(Integer.parseInt(amt)>5000)
	 * serviceHead="230-"+amt+"|231-10.00";
	 * 
	 * break;
	 * 
	 * case "2354": serviceHead="260-"+amt+"|261-5.00"; break;
	 * 
	 * case "2575": serviceHead="226-"+amt+"|228-5.00"; break;
	 * 
	 * }
	 * 
	 * logger.info("getbackToBackurl, ServiceID"+serviceid+"ServiceHEAD"+serviceHead
	 * );
	 * 
	 * EncrptDesryptDataService eds =new EncrptDesryptDataService();
	 * 
	 * String checksumurl="{\"SSOID\":\""+Login.SSOID+"\",\"REQUESTID\":\""+transid+
	 * "\",\"REQTIMESTAMP\":\""+timestamp+"\",\"SSOTOKEN\":\"0\"}";
	 * logger.info("getbackToBackurl, checkSUMURL" +checksumurl); String
	 * checksum=eds.sendPostCheckSum(checksumurl);
	 * 
	 * int x=flag.indexOf(":");
	 * 
	 * 
	 * if(x!=-1) {
	 * 
	 * String s[]=flag.split(":"); String paymentMode = "";
	 * 
	 * if(s[1].equalsIgnoreCase("EMITRAPLUSEZETAP")) { paymentMode = "571"; }else
	 * if(s[1].equalsIgnoreCase("EMITRAPLUSBILLDESK")) { paymentMode = "231"; }else
	 * if(s[1].equalsIgnoreCase("EMITRAPLUSDIGITSECURE")) { paymentMode = "671";
	 * 
	 * } backToBackurl="{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\""+transid+
	 * "\"," + "\"REQTIMESTAMP\":\""+timestamp+"\",\"SERVICEID\":\""+serviceid+
	 * "\",\"SUBSERVICEID\":\"\"," +
	 * "\"REVENUEHEAD\":\""+serviceHead+"\",\"CONSUMERKEY\":\""+consumerkey+"\","+
	 * "\"LOOKUPID\":\""+lookupid+"\"," +
	 * "\"CONSUMERNAME\":\""+consumerName+"\",\"COMMTYPE\":\"1\",\"SSOID\":\""+Login
	 * .SSOID+"\",\"OFFICECODE\":\""+officeCode+"\"," +
	 * "\"SSOTOKEN\":\"0\",\"CHECKSUM\":\""+checksum+"\"," +
	 * "\"PAYMODE\":\""+paymentMode+"\",\"BANKREFNUMBER\":\""+s[2] +"\"}";
	 * 
	 * backToBackurl="{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\""+transid+
	 * "\"," + "\"REQTIMESTAMP\":\""+timestamp+"\",\"SERVICEID\":\""+serviceid+
	 * "\",\"SUBSERVICEID\":\"\"," +
	 * "\"REVENUEHEAD\":\""+serviceHead+"\",\"CONSUMERKEY\":\""+consumerkey+"\","+
	 * "\"LOOKUPID\":\""+lookupid+"\"," +
	 * "\"CONSUMERNAME\":\""+consumerName+"\",\"COMMTYPE\":\"1\",\"SSOID\":\""+Login
	 * .SSOID+"\",\"OFFICECODE\":\""+officeCode+"\"," +
	 * "\"SSOTOKEN\":\"0\",\"CHECKSUM\":\""+checksum+"\"," +
	 * "\"PAYMODE\":\""+paymentMode+"\",\"BANKREFNUMBER\":\""+s[2] +"\"," +
	 * "\"MOBILENUMBER\":\""+mobileNumber+"\",\"EMAILID\":\""+emailId +"\"}"; } else
	 * 
	 * backToBackurl="{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\""+transid+
	 * "\"," + "\"REQTIMESTAMP\":\""+timestamp+"\",\"SERVICEID\":\""+serviceid+
	 * "\",\"SUBSERVICEID\":\"\"," +
	 * "\"REVENUEHEAD\":\""+serviceHead+"\",\"CONSUMERKEY\":\""+consumerkey+"\","+
	 * "\"LOOKUPID\":\""+lookupid+"\"," +
	 * "\"CONSUMERNAME\":\""+consumerName+"\",\"COMMTYPE\":\"1\",\"SSOID\":\""+Login
	 * .SSOID+"\"," +
	 * "\"OFFICECODE\":\""+officeCode+"\",\"SSOTOKEN\":\"0\",\"CHECKSUM\":\""+
	 * checksum+"\" }";
	 * 
	 * 
	 * backToBackurl="{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\""+transid+
	 * "\"," + "\"REQTIMESTAMP\":\""+timestamp+"\",\"SERVICEID\":\""+serviceid+
	 * "\",\"SUBSERVICEID\":\"\"," +
	 * "\"REVENUEHEAD\":\""+serviceHead+"\",\"CONSUMERKEY\":\""+consumerkey+"\","+
	 * "\"LOOKUPID\":\""+lookupid+"\"," +
	 * "\"CONSUMERNAME\":\""+consumerName+"\",\"COMMTYPE\":\"1\",\"SSOID\":\""+Login
	 * .SSOID+"\",\"OFFICECODE\":\""+officeCode+"\"," +
	 * "\"SSOTOKEN\":\"0\",\"CHECKSUM\":\""+checksum+"\"," +
	 * "\"MOBILENUMBER\":\""+mobileNumber+"\",\"EMAILID\":\""+emailId+"\" }"; }
	 * 
	 * logger.info("backToBackurl : "+backToBackurl);
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in getbackToBackurl : "+e.getMessage());
	 * e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return backToBackurl; }
	 */

	public String getbackToBackurl(String amt, String trnsid, String serviceId, String flag) {

		String serviceHead = null;
		String backToBackurl = null;
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");

			/*
			 * if (serviceId.equals("1219")) { queryDetails.addQueryParams(1,
			 * "selectprintrerceiptVoda"); } else if (serviceId.equals("1214")) {
			 * queryDetails.addQueryParams(1, "selectprintrerceipt"); } else if
			 * (serviceId.equals("1220")) { queryDetails.addQueryParams(1,
			 * "selectprintrerceiptIdea"); } else if (serviceId.equals("1223")) {
			 * queryDetails.addQueryParams(1, "selectprintrerceiptDiscom"); } else if
			 * (serviceId.equals("2354")) { queryDetails.addQueryParams(1,
			 * "selectprintrerceiptPhed"); } else if (serviceId.equals("2575")) {
			 * queryDetails.addQueryParams(1, "selectprintrerceiptBSNL"); }
			 */

			// Optimized code
			switch (serviceId) {
			case "1219":
				queryDetails.addQueryParams(1, "selectprintrerceiptVoda");
				break;
			case "1214":
				queryDetails.addQueryParams(1, "selectprintrerceipt");
				break;
			case "1220":
				queryDetails.addQueryParams(1, "selectprintrerceiptIdea");
				break;
			case "1223":
				queryDetails.addQueryParams(1, "selectprintrerceiptDiscom");
				break;
			case "2354":
				queryDetails.addQueryParams(1, "selectprintrerceiptPhed");
				break;
			case "2575":
				queryDetails.addQueryParams(1, "selectprintrerceiptBSNL");
				break;
			}

			queryDetails.addQueryParams(2, trnsid);

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);

					String transid = rs.optString("TransId");
					String timestamp = rs.optString("gettimestamp");
					String consumerkey = rs.optString("consumerkeyvalue");
					String consumerName = rs.optString("consumername");
					String serviceid = rs.optString("ServiceId");
					String officeCode = rs.optString("officecodevalue");
					String lookupid = rs.optString("lookupid");
					String mobileNumber = rs.optString("MobileNumber") == null ? "" : rs.optString("MobileNumber");
					String emailId = rs.optString("EmailId") == null ? "" : rs.optString("EmailId");

					switch (serviceId) {

					case "1214":
						serviceHead = "212-" + amt + "|213-5.00";
						break;

					case "1220":
						serviceHead = "217-" + amt + "|219-5.00";
						break;

					case "1216":
						serviceHead = "214-" + amt + "|215-5.00";
						break;

					case "1219":
						serviceHead = "218-" + amt + "|220-5.00";
						break;

					case "1223":

						if (Integer.parseInt(amt) <= 2000)
							serviceHead = "230-" + amt + "|231-5.00";
						else if (Integer.parseInt(amt) > 2000 && Integer.parseInt(amt) <= 5000)
							serviceHead = "230-" + amt + "|231-8.00";
						else if (Integer.parseInt(amt) > 5000)
							serviceHead = "230-" + amt + "|231-10.00";

						break;

					case "2354":
						serviceHead = "260-" + amt + "|261-5.00";
						break;

					case "2575":
						serviceHead = "226-" + amt + "|228-5.00";
						break;

					}
					logger.info("getbackToBackurl, ServiceID" + serviceid + "ServiceHEAD" + serviceHead);

					EncrptDesryptDataService eds = new EncrptDesryptDataService();

					String checksumurl = "{\"SSOID\":\"" + Login.SSOID + "\",\"REQUESTID\":\"" + transid
							+ "\",\"REQTIMESTAMP\":\"" + timestamp + "\",\"SSOTOKEN\":\"0\"}";
					logger.info("getbackToBackurl, checkSUMURL" + checksumurl + "flag, ::" + flag);

					String checksum = eds.sendPostCheckSum(checksumurl);

					int x = flag.indexOf(":");

					if (x != -1) {

						String s[] = flag.split(":");
						String paymentMode = "";

						if (s[1].equalsIgnoreCase("EMITRAPLUSEZETAP")) {
							paymentMode = "571";
						} else if (s[1].equalsIgnoreCase("EMITRAPLUSBILLDESK")) {
							paymentMode = "231";
						} else if (s[1].equalsIgnoreCase("EMITRAPLUSDIGITSECURE")) {
							paymentMode = "671";

						}
						backToBackurl = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + transid + "\","
								+ "\"REQTIMESTAMP\":\"" + timestamp + "\",\"SERVICEID\":\"" + serviceid
								+ "\",\"SUBSERVICEID\":\"\"," + "\"REVENUEHEAD\":\"" + serviceHead
								+ "\",\"CONSUMERKEY\":\"" + consumerkey + "\"," + "\"LOOKUPID\":\"" + lookupid + "\","
								+ "\"CONSUMERNAME\":\"" + consumerName + "\",\"COMMTYPE\":\"1\",\"SSOID\":\""
								+ Login.SSOID + "\",\"OFFICECODE\":\"" + officeCode + "\","
								+ "\"SSOTOKEN\":\"0\",\"CHECKSUM\":\"" + checksum + "\"," + "\"PAYMODE\":\""
								+ paymentMode + "\",\"BANKREFNUMBER\":\"" + s[2] + "\"," + "\"MOBILENUMBER\":\""
								+ mobileNumber + "\",\"EMAILID\":\"" + emailId + "\"}";
					} else
						backToBackurl = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + transid + "\","
								+ "\"REQTIMESTAMP\":\"" + timestamp + "\",\"SERVICEID\":\"" + serviceid
								+ "\",\"SUBSERVICEID\":\"\"," + "\"REVENUEHEAD\":\"" + serviceHead
								+ "\",\"CONSUMERKEY\":\"" + consumerkey + "\"," + "\"LOOKUPID\":\"" + lookupid + "\","
								+ "\"CONSUMERNAME\":\"" + consumerName + "\",\"COMMTYPE\":\"1\",\"SSOID\":\""
								+ Login.SSOID + "\",\"OFFICECODE\":\"" + officeCode + "\","
								+ "\"SSOTOKEN\":\"0\",\"CHECKSUM\":\"" + checksum + "\"," + "\"MOBILENUMBER\":\""
								+ mobileNumber + "\",\"EMAILID\":\"" + emailId + "\" }";
				}
				logger.info("getbackToBackurl, backToBackurl : " + backToBackurl);
				if (backToBackurl != null) {
					queryDetails = new QueryDetails("proc_kiosk");
					queryDetails.addQueryParams(1, "updateTransInfoBBTB");
					queryDetails.addQueryParams(2, trnsid);
					DBServiceResponse serviceResponse1 = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
					logger.info("getbackToBackurl, Response status of serviceResponse:" + serviceResponse1.getStatus());
				}
			}
		} catch (Exception ex) {
			logger.error("Exception in getbackToBackurl : ", ex);
		}

		return backToBackurl;
	}

	/*
	 * @Override public void saveBackToBackTransaction(String decriptBackTOBackUrl,
	 * String paymentMode) { JSONParser parser = new JSONParser(); JSONObject json;
	 * Connection connection = null; try { json = (JSONObject)
	 * parser.parse(decriptBackTOBackUrl); String REQUESTID = (String)
	 * json.get("REQUESTID"); String TRANSACTIONSTATUSCODE = (String)
	 * json.get("TRANSACTIONSTATUSCODE"); String RECEIPTNO = (String)
	 * json.get("RECEIPTNO"); String TRANSACTIONID = (String)
	 * json.get("TRANSACTIONID"); String TRANSAMT = (String) json.get("TRANSAMT");
	 * String REMAININGWALLET = (String) json.get("REMAININGWALLET"); String
	 * EMITRATIMESTAMP = (String) json.get("EMITRATIMESTAMP"); String
	 * TRANSACTIONSTATUS = (String) json.get("TRANSACTIONSTATUS"); // String
	 * transstatus = (String) json.get("TRANSACTIONSTATUS"); String MSG = (String)
	 * json.get("MSG"); String CHECKSUM = (String) json.get("CHECKSUM");
	 * 
	 * String procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	 * connection = jdbcTemplate.getDataSource().getConnection(); CallableStatement
	 * callableSt2 = connection.prepareCall(procedureCall); callableSt2.setString(1,
	 * "transactionStatusInsert"); callableSt2.setString(2, REQUESTID);
	 * callableSt2.setString(3, TRANSACTIONSTATUSCODE); callableSt2.setString(4,
	 * RECEIPTNO); callableSt2.setString(5, TRANSACTIONID); callableSt2.setString(6,
	 * null); callableSt2.setString(7, REMAININGWALLET); callableSt2.setString(8,
	 * EMITRATIMESTAMP); callableSt2.setString(9, TRANSACTIONSTATUS);
	 * callableSt2.setString(10, MSG); callableSt2.setString(11, CHECKSUM);
	 * callableSt2.setString(12, TRANSAMT); callableSt2.setString(13, paymentMode);
	 * callableSt2.execute();
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in saveBackToBackTransaction : "+e.getMessage());
	 * e.printStackTrace(); }finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */

	// Precise Code
	/*
	 * @Override public void saveBackToBackTransaction(String decriptBackTOBackUrl,
	 * String paymentMode) { JSONParser parser = new JSONParser(); JSONObject json;
	 * Connection connection = null; try { json = (JSONObject)
	 * parser.parse(decriptBackTOBackUrl); String REQUESTID = (String)
	 * json.get("REQUESTID"); String TRANSACTIONSTATUSCODE = (String)
	 * json.get("TRANSACTIONSTATUSCODE"); String RECEIPTNO = (String)
	 * json.get("RECEIPTNO"); String TRANSACTIONID = (String)
	 * json.get("TRANSACTIONID"); String TRANSAMT = (String) json.get("TRANSAMT");
	 * String REMAININGWALLET = (String) json.get("REMAININGWALLET"); String
	 * EMITRATIMESTAMP = (String) json.get("EMITRATIMESTAMP"); String
	 * TRANSACTIONSTATUS = (String) json.get("TRANSACTIONSTATUS"); // String
	 * transstatus = (String) json.get("TRANSACTIONSTATUS"); String MSG = (String)
	 * json.get("MSG"); String CHECKSUM = (String) json.get("CHECKSUM");
	 * 
	 * String procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	 * connection = jdbcTemplate.getDataSource().getConnection(); CallableStatement
	 * callableSt2 = connection.prepareCall(procedureCall); callableSt2.setString(1,
	 * "transactionStatusInsert"); callableSt2.setString(2, REQUESTID);
	 * callableSt2.setString(3, TRANSACTIONSTATUSCODE); callableSt2.setString(4,
	 * RECEIPTNO); callableSt2.setString(5, TRANSACTIONID); callableSt2.setString(6,
	 * null); callableSt2.setString(7, REMAININGWALLET); callableSt2.setString(8,
	 * EMITRATIMESTAMP); callableSt2.setString(9, TRANSACTIONSTATUS);
	 * callableSt2.setString(10, MSG); callableSt2.setString(11, CHECKSUM);
	 * callableSt2.setString(12, TRANSAMT); callableSt2.setString(13, paymentMode);
	 * callableSt2.execute();
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in saveBackToBackTransaction : "+e.getMessage());
	 * e.printStackTrace(); }finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */

	// Grinaar Developer Code

	/*
	 * @Override public void saveBackToBackTransaction(String decriptBackTOBackUrl,
	 * String paymentMode) throws Exception { org.json.JSONObject json = new
	 * org.json.JSONObject(decriptBackTOBackUrl);
	 * 
	 * String REQUESTID = json.getString("REQUESTID"); String TRANSACTIONSTATUSCODE
	 * = json.getString("TRANSACTIONSTATUSCODE"); String RECEIPTNO =
	 * json.getString("RECEIPTNO"); String TRANSACTIONID =
	 * json.getString("TRANSACTIONID"); String TRANSAMT =
	 * json.getString("TRANSAMT"); String REMAININGWALLET =
	 * json.getString("REMAININGWALLET"); String EMITRATIMESTAMP =
	 * json.getString("EMITRATIMESTAMP"); String TRANSACTIONSTATUS =
	 * json.getString("TRANSACTIONSTATUS"); String MSG = json.getString("MSG");
	 * String CHECKSUM = json.getString("CHECKSUM");
	 * 
	 * String procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	 * Connection connection = jdbcTemplate.getDataSource().getConnection();
	 * CallableStatement callableSt2 = connection.prepareCall(procedureCall);
	 * callableSt2.setString(1, "transactionStatusInsert"); callableSt2.setString(2,
	 * REQUESTID); callableSt2.setString(3, TRANSACTIONSTATUSCODE);
	 * callableSt2.setString(4, RECEIPTNO); callableSt2.setString(5, TRANSACTIONID);
	 * callableSt2.setString(6, null); callableSt2.setString(7, REMAININGWALLET);
	 * callableSt2.setString(8, EMITRATIMESTAMP); callableSt2.setString(9,
	 * TRANSACTIONSTATUS); callableSt2.setString(10, MSG); callableSt2.setString(11,
	 * CHECKSUM); callableSt2.setString(12, TRANSAMT); callableSt2.setString(13,
	 * paymentMode);
	 * 
	 * callableSt2.execute(); }
	 */

	@Override
	public void saveBackToBackTransaction(String decriptBackTOBackUrl, String paymentMode) throws Exception {
		JSONObject json = new JSONObject(decriptBackTOBackUrl);
		String REQUESTID = json.optString("REQUESTID");
		String TRANSACTIONSTATUSCODE = json.optString("TRANSACTIONSTATUSCODE");
		String RECEIPTNO = json.optString("RECEIPTNO");
		String TRANSACTIONID = json.optString("TRANSACTIONID");
		String TRANSAMT = json.optString("TRANSAMT");
		String REMAININGWALLET = json.optString("REMAININGWALLET");
		String EMITRATIMESTAMP = json.optString("EMITRATIMESTAMP");
		String TRANSACTIONSTATUS = json.optString("TRANSACTIONSTATUS");
		String MSG = json.optString("MSG");
		String CHECKSUM = json.optString("CHECKSUM");

		QueryDetails queryDetails = new QueryDetails("proc_kiosk");
		queryDetails.addQueryParams(1, "transactionStatusInsert");
		queryDetails.addQueryParams(2, REQUESTID);
		queryDetails.addQueryParams(3, TRANSACTIONSTATUSCODE);
		queryDetails.addQueryParams(4, RECEIPTNO);
		queryDetails.addQueryParams(5, TRANSACTIONID);
		queryDetails.addQueryParams(6, null);
		queryDetails.addQueryParams(7, REMAININGWALLET);
		queryDetails.addQueryParams(8, EMITRATIMESTAMP);
		queryDetails.addQueryParams(9, TRANSACTIONSTATUS);
		queryDetails.addQueryParams(10, MSG);
		queryDetails.addQueryParams(11, CHECKSUM);
		queryDetails.addQueryParams(12, TRANSAMT);
		queryDetails.addQueryParams(13, paymentMode);

		DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
		logger.info("Response status of saveBackToBackTransaction:" + serviceResponse.getStatus());
	}

	/*
	 * @Override public void saveCardPaymentDetails(CardPaymentDetails cpd) { String
	 * procedureCall = ""; Connection connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [Proc_CardBill](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	 * CallableStatement callableSt = connection.prepareCall(procedureCall);
	 * callableSt.setString(1, "insertAirtelCardBill"); callableSt.setString(2,
	 * cpd.getMERCHANTCODE()); callableSt.setString(3, cpd.getREQTIMESTAMP());
	 * callableSt.setString(4,cpd.getPRN());
	 * callableSt.setString(5,cpd.getRPPTXNID());
	 * callableSt.setString(6,cpd.getAMOUNT());
	 * callableSt.setString(7,cpd.getRPPTIMESTAMP());
	 * callableSt.setString(8,cpd.getSTATUS());
	 * callableSt.setString(9,cpd.getRESPONSECODE());
	 * callableSt.setString(10,cpd.getRESPONSEMESSAGE());
	 * callableSt.setString(11,cpd.getPAYMENTMODE());
	 * callableSt.setString(12,cpd.getPAYMENTMODEBID());
	 * callableSt.setString(13,cpd.getPAYMENTMODETIMESTAMP());
	 * callableSt.setString(14,cpd.getPAYMENTAMOUNT());
	 * callableSt.setString(15,cpd.getUDF1());
	 * callableSt.setString(16,cpd.getUDF2());
	 * callableSt.setString(17,cpd.getUDF3());
	 * //callableSt.setString(18,cpd.getCHECKSUM()); callableSt.setString(18,"");
	 * callableSt.execute();
	 * 
	 * connection.commit(); } catch (Exception e) {
	 * logger.error("Exception in saveCardPaymentDetails : "+e.getMessage());
	 * e.printStackTrace(); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } } }
	 */

	@Override
	public void saveCardPaymentDetails(CardPaymentDetails cpd) {
		try {
			QueryDetails queryDetails = new QueryDetails("Proc_CardBill");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "insertAirtelCardBill");
			queryDetails.addQueryParams(2, cpd.getMERCHANTCODE());
			queryDetails.addQueryParams(3, cpd.getREQTIMESTAMP());
			queryDetails.addQueryParams(4, cpd.getPRN());
			queryDetails.addQueryParams(5, cpd.getRPPTXNID());
			queryDetails.addQueryParams(6, cpd.getAMOUNT());
			queryDetails.addQueryParams(7, cpd.getRPPTIMESTAMP());
			queryDetails.addQueryParams(8, cpd.getSTATUS());
			queryDetails.addQueryParams(9, cpd.getRESPONSECODE());
			queryDetails.addQueryParams(10, cpd.getRESPONSEMESSAGE());
			queryDetails.addQueryParams(11, cpd.getPAYMENTMODE());
			queryDetails.addQueryParams(12, cpd.getPAYMENTMODEBID());
			queryDetails.addQueryParams(13, cpd.getPAYMENTMODETIMESTAMP());
			queryDetails.addQueryParams(14, cpd.getPAYMENTAMOUNT());
			queryDetails.addQueryParams(15, cpd.getUDF1());
			queryDetails.addQueryParams(16, cpd.getUDF2());
			queryDetails.addQueryParams(17, cpd.getUDF3());
			queryDetails.addQueryParams(18, "");

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of saveCardPaymentDetails:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in saveCardPaymentDetails : ", ex);
		}
	}

	/*
	 * @Override public List<Bill> getPaymentInfo(String PRN) {
	 * System.out.println("PRN  ::::"+PRN); List<Bill> list= new ArrayList<Bill>();
	 * String procedureCall = ""; Connection connection = null; CallableStatement
	 * callableSt = null; Bill bill1=new Bill(); try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [Proc_CardBill](?,?)}"; callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "selectAirtelCardBill"); callableSt.setString(2, PRN);
	 * 
	 * ResultSet rs=callableSt.executeQuery(); if(rs.next()) {
	 * bill1.setBillAmount(rs.getString("payAmount"));
	 * bill1.setBillMobileNo(rs.getString("consumerkeyvalue"));
	 * bill1.setDueDate(""); bill1.setName(rs.getString("consumername"));
	 * bill1.setServiceProviderName(rs.getString("servicename"));
	 * bill1.setBillEmail(rs.getString("EmailId"));
	 * bill1.setTransactionId(rs.getString("TransId"));
	 * bill1.setBillActualAmount(rs.getString("billamount")); list.add(bill1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { if (connection !=
	 * null) try { connection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } } return list; }
	 */

	/*
	 * @Override public List<Bill> getPaymentInfo(String PRN) { //
	 * System.out.println("PRN  ::::"+PRN); List<Bill> list= new ArrayList<Bill>();
	 * String procedureCall = ""; Connection connection = null; CallableStatement
	 * callableSt = null; Bill bill1=new Bill(); try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [Proc_CardBill](?,?)}"; callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "selectAirtelCardBill"); callableSt.setString(2, PRN);
	 * 
	 * ResultSet rs=callableSt.executeQuery(); if(rs.next()) {
	 * bill1.setBillAmount(rs.getString("billamount"));
	 * bill1.setBillMobileNo(rs.getString("consumerkeyvalue"));
	 * bill1.setDueDate(""); bill1.setName(rs.getString("consumername"));
	 * bill1.setServiceProviderName(rs.getString("servicename"));
	 * bill1.setBillEmail(rs.getString("EmailId"));
	 * bill1.setTransactionId(rs.getString("TransId"));
	 * bill1.setBillActualAmount(rs.getString("PAYMENTAMOUNT"));
	 * bill1.setServiceProviderID(Integer.parseInt(rs.getString("ServiceId")));
	 * bill1.setmSG(rs.getString("RESPONSEMESSAGE"));
	 * bill1.setCreatedDate(rs.getString("CreatedOn"));
	 * bill1.setPaymentMode(rs.getString("PAYMENTMODE")); list.add(bill1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in getPaymentInfo : "+e.getMessage());
	 * e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return list; }
	 */

	@Override
	public List<Bill> getPaymentInfo(String PRN) {
		List<Bill> list = new ArrayList<Bill>();
		Bill bill1 = new Bill();
		try {
			QueryDetails queryDetails = new QueryDetails("Proc_CardBill");

			queryDetails.addQueryParams(1, "selectAirtelCardBill");
			queryDetails.addQueryParams(2, PRN);

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
					bill1.setBillAmount(rs.optString("billamount"));
					bill1.setBillMobileNo(rs.optString("consumerkeyvalue"));
					bill1.setDueDate("");
					bill1.setName(rs.optString("consumername"));
					bill1.setServiceProviderName(rs.optString("servicename"));
					bill1.setBillEmail(rs.optString("EmailId"));
					bill1.setTransactionId(rs.optString("TransId"));
					bill1.setBillActualAmount(rs.optString("PAYMENTAMOUNT"));
					bill1.setServiceProviderID(Integer.parseInt(rs.optString("ServiceId")));
					bill1.setmSG(rs.optString("RESPONSEMESSAGE"));
					bill1.setCreatedDate(rs.optString("CreatedOn"));
					bill1.setPaymentMode(rs.optString("PAYMENTMODE"));
					list.add(bill1);
				}
			}
		} catch (Exception ex) {
			logger.error("Exception in getPaymentInfo : ", ex);
		}

		return list;
	}

	/*
	 * public String getCancelTranscationurl(String emitraTransactionId) {
	 * 
	 * String procedureCall = ""; String cancelTranscationUrl = null; Connection
	 * connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [proc_kiosk](?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall);
	 * 
	 * callableSt.setString(1, "selectEmitraTransId"); callableSt.setString(2,
	 * emitraTransactionId); ResultSet rs=callableSt.executeQuery(); if(rs.next()) {
	 * //System.out.println("REQUESTID"+rs.getString("TransId")); String requestID
	 * =rs.getString("REQUESTID"); // String
	 * timestamp=rs.getString("EMITRATIMESTAMP");
	 * 
	 * String EMITRATOKEN=rs.getString("TRANSACTIONID");
	 * 
	 * String CANCELREMARK= "Cash Not Received";
	 * 
	 * EncrptDesryptDataService eds =new EncrptDesryptDataService();
	 * 
	 * // String
	 * checksumurl="{\"SSOID\":\""+Login.SSOID+"\",\"REQUESTID\":\""+requestID+
	 * "\",\"REQTIMESTAMP\":\""+timestamp+"\",\"SSOTOKEN\":\"0\"}"; String
	 * checksumurl="{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\""+requestID+
	 * "\",\"SSOTOKEN\":\"0\"}";
	 * 
	 * //{"MERCHANTCODE":"EMITRAPLUS","REQUESTID":"90014113559644","SSOTOKEN":"0"}
	 * 
	 * logger.info("getbackToBackurl, checkSUMURL" +checksumurl); String
	 * checksum=eds.sendPostCheckSum(checksumurl);
	 * 
	 * cancelTranscationUrl="{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\""+
	 * requestID+"\"," +
	 * "\"EMITRATOKEN\":\""+EMITRATOKEN+"\",\"CANCELREMARK\":\""+CANCELREMARK+"\","
	 * + "\"ENTITYTYPEID\":\"4\"," +
	 * "\"SSOTOKEN\":\"0\",\"CHECKSUM\":\""+checksum+"\" }";
	 * 
	 * 
	 * } } catch (Exception e) {
	 * logger.error("Exception in getCancelTranscationurl, getbackToBackurl : "+e.
	 * getMessage()); e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return cancelTranscationUrl; }
	 */

	public String getCancelTranscationurl(String emitraTransactionId) {
		String cancelTranscationUrl = null;
		try {
			QueryDetails queryDetails = new QueryDetails("Proc_kiosk");

			queryDetails.addQueryParams(1, "selectEmitraTransId");
			queryDetails.addQueryParams(2, emitraTransactionId);

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);

					String requestID = rs.optString("REQUESTID");
					String EMITRATOKEN = rs.optString("TRANSACTIONID");
					String CANCELREMARK = "Cash Not Received";

					EncrptDesryptDataService eds = new EncrptDesryptDataService();

					String checksumurl = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + requestID
							+ "\",\"SSOTOKEN\":\"0\"}";

					logger.info("getbackToBackurl, checkSUMURL" + checksumurl);
					String checksum = eds.sendPostCheckSum(checksumurl);

					cancelTranscationUrl = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + requestID + "\","
							+ "\"EMITRATOKEN\":\"" + EMITRATOKEN + "\",\"CANCELREMARK\":\"" + CANCELREMARK + "\","
							+ "\"ENTITYTYPEID\":\"4\"," + "\"SSOTOKEN\":\"0\",\"CHECKSUM\":\"" + checksum + "\" }";
				}
			}
		} catch (Exception ex) {
			logger.error("Exception in getCancelTranscationurl, getbackToBackurl : ", ex);
		}

		return cancelTranscationUrl;
	}

	/*
	 * @Override public void savePaymentStatus(String token, String certType, int
	 * certificareYear) { String procedureCall = ""; Connection connection = null;
	 * try { connection = jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [Proc_CardBill](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	 * CallableStatement callableSt = connection.prepareCall(procedureCall);
	 * callableSt.setString(1, "insertCertPaymentDetails"); callableSt.setString(2,
	 * token); callableSt.setString(3, certType); callableSt.setString(4, null);
	 * callableSt.setString(5, null); callableSt.setString(6, null);
	 * callableSt.setString(7, null); callableSt.setString(8, null);
	 * callableSt.setString(9, null); callableSt.setString(10, null);
	 * callableSt.setString(11, null); callableSt.setString(12, null);
	 * callableSt.setString(13, null); callableSt.setString(14, null);
	 * callableSt.setString(15, null); callableSt.setString(16, null);
	 * callableSt.setString(17, null); callableSt.setString(18, null);
	 * callableSt.setInt(19, certificareYear);
	 * 
	 * callableSt.execute(); connection.commit(); } catch (Exception e) {
	 * logger.error("Exception in insertCertPaymentDetails, savePaymentStatus : "+e.
	 * getMessage()); e.printStackTrace(); try { connection.rollback(); } catch
	 * (SQLException e1) { e1.printStackTrace(); } } finally { if (connection !=
	 * null) try { connection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */

	@Override
	public void savePaymentStatus(String token, String certType, int certificareYear) {
		try {
			QueryDetails queryDetails = new QueryDetails("Proc_CardBill");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "insertCertPaymentDetails");
			queryDetails.addQueryParams(2, token);
			queryDetails.addQueryParams(3, certType);
			queryDetails.addQueryParams(4, null);
			queryDetails.addQueryParams(5, null);
			queryDetails.addQueryParams(6, null);
			queryDetails.addQueryParams(7, null);
			queryDetails.addQueryParams(8, null);
			queryDetails.addQueryParams(9, null);
			queryDetails.addQueryParams(10, null);
			queryDetails.addQueryParams(11, null);
			queryDetails.addQueryParams(12, null);
			queryDetails.addQueryParams(13, null);
			queryDetails.addQueryParams(14, null);
			queryDetails.addQueryParams(15, null);
			queryDetails.addQueryParams(16, null);
			queryDetails.addQueryParams(17, null);
			queryDetails.addQueryParams(18, null);
			queryDetails.addQueryParams(19, certificareYear);

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of savePaymentStatus:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in insertCertPaymentDetails, savePaymentStatus : ", ex);
		}
	}

	/*
	 * @Override public void updateStatusCash(String status, String amt,String
	 * token) { String procedureCall = ""; Connection connection = null; try {
	 * connection = jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [Proc_CardBill](?,?,?,?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "updateCertPaymentDetails"); callableSt.setString(2, token);
	 * callableSt.setString(3, status); callableSt.setString(4, amt);
	 * callableSt.setString(5, "cash"); callableSt.execute(); connection.commit(); }
	 * catch (Exception e) {
	 * logger.error("Exception in updateStatusCash: "+e.getMessage());
	 * e.printStackTrace(); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * 
	 * }
	 */

	@Override
	public void updateStatusCash(String status, String amt, String token) {
		try {
			QueryDetails queryDetails = new QueryDetails("Proc_CardBill");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "updateCertPaymentDetails");
			queryDetails.addQueryParams(2, token);
			queryDetails.addQueryParams(3, status);
			queryDetails.addQueryParams(4, amt);
			queryDetails.addQueryParams(5, "cash");

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of updateStatusCash:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in updateStatusCash: ", ex);
		}
	}

	/*
	 * @Override public Bill getTransactionDetails(String transactionid) { String
	 * procedureCall = ""; Connection connection = null; CallableStatement
	 * callableSt = null; Bill bill1 =new Bill(); try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [proc_kiosk](?,?)}"; callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "selectTransactionDetails"); callableSt.setString(2, transactionid);
	 * 
	 * ResultSet rs=callableSt.executeQuery(); if(rs.next()){
	 * bill1.setBackToBackTransactionID(rs.getString("transactionid"));
	 * bill1.setBackToBackTransactionStatus(rs.getString("TRANSACTIONSTATUS")); }
	 * 
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in getTransactionDetails: "+e.getMessage());
	 * e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return bill1; }
	 */

	@Override
	public Bill getTransactionDetails(String transactionid) {
		Bill bill1 = new Bill();
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");

			queryDetails.addQueryParams(1, "selectTransactionDetails");
			queryDetails.addQueryParams(2, transactionid);

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
					bill1.setBackToBackTransactionID(rs.optString("TRANSACTIONID"));
					bill1.setBackToBackTransactionStatus(rs.optString("TRANSACTIONSTATUS"));
				}
			}
		} catch (Exception ex) {
			logger.error("Exception in getTransactionDetails: ", ex);
		}

		return bill1;
	}

	// Precise Code
	/*
	 * @Override public void updateTransactionDetails(String emitraTransactionFlag,
	 * Bill transactionDetails, String trnsid) { String procedureCall = "";
	 * Connection connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [proc_kiosk](?,?,?,?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "updateTransactionDetails"); callableSt.setString(2,
	 * transactionDetails.getBackToBackTransactionID()); callableSt.setString(3,
	 * transactionDetails.getBackToBackTransactionStatus()); callableSt.setString(4,
	 * emitraTransactionFlag); callableSt.setString(5, trnsid);
	 * callableSt.execute();
	 * 
	 * connection.commit(); } catch (Exception e) { logger.
	 * error("Exception in updateTransactionDetails (updateTransactionDetails) : "+e
	 * .getMessage()); e.printStackTrace(); try { connection.rollback(); } catch
	 * (SQLException e1) { e1.printStackTrace(); } } finally { if (connection !=
	 * null) try { connection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } } }
	 */

	// Grinnar CODE

	/*
	 * @Override public void updateTransactionDetails(String emitraTransactionFlag,
	 * Bill transactionDetails, String trnsid) throws Exception { Connection
	 * connection = jdbcTemplate.getDataSource().getConnection();
	 * 
	 * String procedureCall = "{call [proc_kiosk](?,?,?,?,?)}"; CallableStatement
	 * callableSt = connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "updateTransactionDetails"); callableSt.setString(2,
	 * transactionDetails.getBackToBackTransactionID()); callableSt.setString(3,
	 * transactionDetails.getBackToBackTransactionStatus()); callableSt.setString(4,
	 * emitraTransactionFlag); callableSt.setString(5, trnsid);
	 * callableSt.execute(); }
	 */

	@Override
	public void updateTransactionDetails(String emitraTransactionFlag, Bill transactionDetails, String trnsid)
			throws Exception {
		QueryDetails queryDetails = new QueryDetails("proc_kiosk");

		queryDetails.addQueryParams(1, "updateTransactionDetails");
		queryDetails.addQueryParams(2, transactionDetails.getBackToBackTransactionID());
		queryDetails.addQueryParams(3, transactionDetails.getBackToBackTransactionStatus());
		queryDetails.addQueryParams(4, emitraTransactionFlag);
		queryDetails.addQueryParams(5, trnsid);

		DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
		logger.info("Response status of updateTransactionDetails:" + serviceResponse.getStatus());
	}

	/*
	 * @Override public void updateTransactionDetails(String transid) { String
	 * procedureCall = ""; Connection connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall = "{call [proc_kiosk](?,?)}";
	 * CallableStatement callableSt = connection.prepareCall(procedureCall);
	 * callableSt.setString(1, "updateTransactionpaymentDetails");
	 * callableSt.setString(2, transid); callableSt.execute();
	 * 
	 * connection.commit();
	 * 
	 * } catch (Exception e) { logger.
	 * error("Exception in updateTransactionDetails, updateTransactionpaymentDetails: "
	 * +e.getMessage()); e.printStackTrace(); try { connection.rollback(); } catch
	 * (SQLException e1) { e1.printStackTrace(); } } finally { if (connection !=
	 * null) try { connection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * 
	 * }
	 */

	@Override
	public void updateTransactionDetails(String transid) {
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");

			queryDetails.addQueryParams(1, "updateTransactionpaymentDetails");
			queryDetails.addQueryParams(2, transid);

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of updateTransactionPaymentDetails:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in updateTransactionDetails, updateTransactionpaymentDetails: ", ex);
		}
	}

	/*
	 * @Override public String getBacktoBacktransactionId(String transid) {
	 * 
	 * String getBacktoBacktransactionId = null; String procedureCall = "";
	 * Connection connection = null; CallableStatement callableSt = null;
	 * 
	 * try { connection = jdbcTemplate.getDataSource().getConnection();
	 * procedureCall = "{call [proc_kiosk](?,?)}"; callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "selectBackToBackTransaId"); callableSt.setString(2,transid); ResultSet
	 * rs=callableSt.executeQuery(); if (rs.next()) { getBacktoBacktransactionId =
	 * rs.getString("backtobacktransactionid"); }
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in getBacktoBacktransactionId : "+e.getMessage());
	 * e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return getBacktoBacktransactionId;
	 * 
	 * }
	 */

	@Override
	public String getBacktoBacktransactionId(String transid) {
		String getBacktoBacktransactionId = null;
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");

			queryDetails.addQueryParams(1, "selectBackToBackTransaId");
			queryDetails.addQueryParams(2, transid);

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
			logger.info("Response status of updateTransactionPaymentDetails:" + serviceResponse.getStatus());

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
					getBacktoBacktransactionId = rs.optString("backtobacktransactionid");
				}
			}
		} catch (Exception ex) {
			logger.error("Exception in getBacktoBacktransactionId : ", ex);
		}

		return getBacktoBacktransactionId;
	}

	/*
	 * @Override public void saveCancelTranscationurl(String
	 * decriptCancelTranscationUrl) { String procedureCall = ""; Connection
	 * connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
	 * ; CallableStatement callableSt = connection.prepareCall(procedureCall);
	 * JSONParser parser = new JSONParser(); JSONObject json; json = (JSONObject)
	 * parser.parse(decriptCancelTranscationUrl);
	 * 
	 * String receiptNo = (String)json.get("RECEIPTNO"); String requestId =
	 * (String)json.get("REQUESTID"); String transactionId =
	 * (String)json.get("TRANSACTIONID"); String amt = (String)json.get("AMT");
	 * String emitraTimeStamp = (String)json.get("EMITRATIMESTAMP");
	 * 
	 * String cancelStatusCode = (String)json.get("CANCELSTATUSCODE"); String msg =
	 * (String)json.get("MSG"); String SOTOKEN= (String)json.get("SSOTOKEN");
	 * 
	 * cancelStatus=(String)json.get("CANCELSTATUS"); callableSt.setString(1,
	 * "insertIntoCancelTransactionDetails");
	 * callableSt.setString(2,(String)json.get("CANCELSTATUS"));
	 * callableSt.setString(3,(String)json.get("MSG")); callableSt.setString(4,"");
	 * callableSt.setString(5,""); callableSt.setString(6,"");
	 * callableSt.setString(7,""); callableSt.setString(8,"");
	 * callableSt.setString(9,""); callableSt.setString(10,"");
	 * callableSt.setString(11,""); callableSt.setString(12,"");
	 * callableSt.setString(13,""); callableSt.setString(14,"");
	 * callableSt.setString(15,""); callableSt.setString(16,"");
	 * callableSt.setString(17,""); callableSt.setString(18,"");
	 * callableSt.setString(19,""); callableSt.setString(20,"");
	 * callableSt.setString(21,""); callableSt.setString(22,"");
	 * callableSt.setString(23,""); callableSt.setString(24,"");
	 * callableSt.setString(25,""); callableSt.setString(26,"");
	 * callableSt.setString(27,""); callableSt.setString(28,"");
	 * callableSt.setString(29,"");
	 * callableSt.setString(30,(String)json.get("RECEIPTNO"));
	 * callableSt.setString(31,(String)json.get("REQUESTID"));
	 * callableSt.setString(32,(String)json.get("TRANSACTIONID"));
	 * callableSt.setString(33,(String)json.get("EMITRATIMESTAMP"));
	 * callableSt.setString(34,(String)json.get("CANCELSTATUSCODE"));
	 * callableSt.setString(35,(String)json.get("SSOTOKEN"));
	 * callableSt.setString(36,(String)json.get("AMT")); callableSt.execute();
	 * 
	 * connection.commit(); } catch (Exception e) {
	 * logger.error("Exception in saveCancelTranscationurl : "+e.getMessage());
	 * e.printStackTrace(); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } } }
	 */

	@Override
	public void saveCancelTranscationurl(String decriptCancelTranscationUrl) {
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");
			queryDetails.setAutoCommit(false);

			JSONObject json = new JSONObject(decriptCancelTranscationUrl);

			queryDetails.addQueryParams(1, "insertIntoCancelTransactionDetails");
			queryDetails.addQueryParams(2, json.optString("CANCELSTATUS"));
			queryDetails.addQueryParams(3, json.optString("MSG"));
			queryDetails.addQueryParams(4, "");
			queryDetails.addQueryParams(5, "");
			queryDetails.addQueryParams(6, "");
			queryDetails.addQueryParams(7, "");
			queryDetails.addQueryParams(8, "");
			queryDetails.addQueryParams(9, "");
			queryDetails.addQueryParams(10, "");
			queryDetails.addQueryParams(11, "");
			queryDetails.addQueryParams(12, "");
			queryDetails.addQueryParams(13, "");
			queryDetails.addQueryParams(14, "");
			queryDetails.addQueryParams(15, "");
			queryDetails.addQueryParams(16, "");
			queryDetails.addQueryParams(17, "");
			queryDetails.addQueryParams(18, "");
			queryDetails.addQueryParams(19, "");
			queryDetails.addQueryParams(20, "");
			queryDetails.addQueryParams(21, "");
			queryDetails.addQueryParams(22, "");
			queryDetails.addQueryParams(23, "");
			queryDetails.addQueryParams(24, "");
			queryDetails.addQueryParams(25, "");
			queryDetails.addQueryParams(26, "");
			queryDetails.addQueryParams(27, "");
			queryDetails.addQueryParams(28, "");
			queryDetails.addQueryParams(29, "");
			queryDetails.addQueryParams(30, json.optString("RECEIPTNO"));
			queryDetails.addQueryParams(31, json.optString("REQUESTID"));
			queryDetails.addQueryParams(32, (String) json.get("TRANSACTIONID"));
			queryDetails.addQueryParams(33, (String) json.get("EMITRATIMESTAMP"));
			queryDetails.addQueryParams(34, (String) json.get("CANCELSTATUSCODE"));
			queryDetails.addQueryParams(35, (String) json.get("SSOTOKEN"));
			queryDetails.addQueryParams(36, (String) json.get("AMT"));

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of saveCancelTranscationurl:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in saveCancelTranscationurl : ", ex);
		}
	}

	/*
	 * @Override public String getcertibackToBackurl(String amt, String trnsid,
	 * String serviceId, String flag) {
	 * 
	 * 
	 * String procedureCall = ""; String revenueHead=null; String backToBackurl =
	 * null; Connection connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [Proc_PrintCertificate](?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall);
	 * 
	 * callableSt.setString(1, "SelectPrintReceiptCerti"); callableSt.setString(2,
	 * trnsid); ResultSet rs=callableSt.executeQuery(); if(rs.next()) { String
	 * registrationNo=rs.getString("ConsumerKeyValue"); String
	 * timestamp=rs.getString("gettimestamp"); String
	 * subServiceID=rs.getString("SubServiceId"); String mobileNumber = ""; String
	 * emailId = ""; if(serviceId.equals("3025")) {
	 * revenueHead="277-0.00|276-10.00"; mobileNumber = rs.getString("MobileNo");
	 * }else { revenueHead="797-0.00|798-10.00"; }
	 * 
	 * 
	 * logger.info("getcertibackToBackurl, ServiceID"+serviceId+" revenueHead "
	 * +revenueHead);
	 * 
	 * EncrptDesryptDataService eds =new EncrptDesryptDataService();
	 * 
	 * String checksumurl="{\"SSOID\":\""+Login.SSOID+"\",\"REQUESTID\":\""+trnsid+
	 * "\",\"REQTIMESTAMP\":\""+timestamp+"\",\"SSOTOKEN\":\"0\"}";
	 * logger.info("getbackToBackurl, checkSUMURL" +checksumurl); String
	 * checksum=eds.sendPostCheckSum(checksumurl);
	 * 
	 * 
	 * backToBackurl="{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\""+trnsid+
	 * "\"," + "\"REQTIMESTAMP\":\""+timestamp+"\",\"SERVICEID\":\""+serviceId+
	 * "\",\"SUBSERVICEID\":\""+subServiceID+"\"," +
	 * "\"REVENUEHEAD\":\""+revenueHead+"\",\"CONSUMERKEY\":\""+registrationNo+
	 * "\","+ "\"LOOKUPID\":\"\"," + "\"CONSUMERNAME\":\"\",";
	 * 
	 * if(serviceId.equals("3025")) { backToBackurl +=
	 * "\"COMMTYPE\":\"1\",\"SSOID\":\""+Login.SSOID+
	 * "\",\"OFFICECODE\":\"BHAMA0001\",\"MOBILENUMBER\":\""+mobileNumber
	 * +"\",\"EMAILID\":\""+emailId+"\""; }else { backToBackurl +=
	 * "\"COMMTYPE\":\"2\",\"SSOID\":\""+Login.SSOID+"\",\"OFFICECODE\":\"HOREV\"";
	 * }
	 * 
	 * backToBackurl += ",\"SSOTOKEN\":\"0\",\"CHECKSUM\":\""+checksum+"\" }"; }
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in getcertibackToBackurl : "+e.getMessage());
	 * e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return backToBackurl;
	 * 
	 * }
	 */

	@Override
	public String getcertibackToBackurl(String amt, String trnsid, String serviceId, String flag) {
		String revenueHead = null;
		String backToBackurl = null;
		try {
			QueryDetails queryDetails = new QueryDetails("Proc_PrintCertificate");

			queryDetails.addQueryParams(1, "SelectPrintReceiptCerti");
			queryDetails.addQueryParams(2, trnsid);

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
			logger.info("Response status of getcertibackToBackurl:" + serviceResponse.getStatus());

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
					String registrationNo = rs.optString("ConsumerKeyValue");
					String timestamp = rs.optString("gettimestamp");
					String subServiceID = rs.optString("SubServiceId");
					String mobileNumber = "";
					String emailId = "";
					if (serviceId.equals("3025")) {
						revenueHead = "277-0.00|276-10.00";
						mobileNumber = rs.getString("MobileNo");
					} else {
						revenueHead = "797-0.00|798-10.00";
					}

					logger.info("getcertibackToBackurl, ServiceID" + serviceId + " revenueHead " + revenueHead);

					EncrptDesryptDataService eds = new EncrptDesryptDataService();

					String checksumurl = "{\"SSOID\":\"" + Login.SSOID + "\",\"REQUESTID\":\"" + trnsid
							+ "\",\"REQTIMESTAMP\":\"" + timestamp + "\",\"SSOTOKEN\":\"0\"}";
					logger.info("getbackToBackurl, checkSUMURL" + checksumurl);
					String checksum = eds.sendPostCheckSum(checksumurl);

					backToBackurl = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + trnsid + "\","
							+ "\"REQTIMESTAMP\":\"" + timestamp + "\",\"SERVICEID\":\"" + serviceId
							+ "\",\"SUBSERVICEID\":\"" + subServiceID + "\"," + "\"REVENUEHEAD\":\"" + revenueHead
							+ "\",\"CONSUMERKEY\":\"" + registrationNo + "\"," + "\"LOOKUPID\":\"\","
							+ "\"CONSUMERNAME\":\"\",";
					if (serviceId.equals("3025")) {
						backToBackurl += "\"COMMTYPE\":\"1\",\"SSOID\":\"" + Login.SSOID
								+ "\",\"OFFICECODE\":\"BHAMA0001\",\"MOBILENUMBER\":\"" + mobileNumber
								+ "\",\"EMAILID\":\"" + emailId + "\"";
					} else {
						backToBackurl += "\"COMMTYPE\":\"2\",\"SSOID\":\"" + Login.SSOID
								+ "\",\"OFFICECODE\":\"HOREV\"";
					}
					backToBackurl += ",\"SSOTOKEN\":\"0\",\"CHECKSUM\":\"" + checksum + "\" }";
				}
				logger.info("getbackToBackurl, backToBackurl : " + backToBackurl);
				if (backToBackurl != null) {
					queryDetails = new QueryDetails("proc_kiosk");
					queryDetails.addQueryParams(1, "updateTransInfoBBTB");
					queryDetails.addQueryParams(2, trnsid);
					DBServiceResponse serviceResponse1 = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
					logger.info("getbackToBackurl, Response status of serviceResponse:" + serviceResponse1.getStatus());
				}
			}

		} catch (Exception ex) {
			logger.error("Exception in getcertibackToBackurl : ", ex);
		}

		return backToBackurl;
	}

	/*
	 * @Override public void updatedAmount(double d, int resultAmount,String tid) {
	 * String procedureCall = ""; Connection connection = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [proc_kiosk](?,?,?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "updateAmount"); callableSt.setString(2,new Double(d).toString());
	 * callableSt.setString(3,new Integer(resultAmount).toString());
	 * callableSt.setString(4,tid); callableSt.execute(); connection.commit(); }
	 * catch (Exception e) {
	 * logger.error("Exception in updatedAmount : "+e.getMessage());
	 * e.printStackTrace(); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } } }
	 */

	@Override
	public void updatedAmount(double d, int resultAmount, String tid) {
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "updateAmount");
			queryDetails.addQueryParams(2, new Double(d).toString());
			queryDetails.addQueryParams(3, new Integer(resultAmount).toString());
			queryDetails.addQueryParams(4, tid);

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of updatedAmount:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in updatedAmount : ", ex);
		}
	}

	/*
	 * @Override public LatestVersionDetails versionCheck() { Connection connection
	 * = null; LatestVersionDetails latestVersionDetails = new
	 * LatestVersionDetails(); ResultSet rs = null; try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); String procedureCall =
	 * "{call [proc_kiosk](?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "selectVersionDetail"); rs = callableSt.executeQuery(); if(rs.next()) {
	 * String vno = rs.getString("VersionNo");
	 * 
	 * latestVersionDetails.setVersionNo( Double.parseDouble(vno.replaceAll("Ver",
	 * "")));
	 * latestVersionDetails.setCreatedDate(String.valueOf(rs.getDate("createdDate"))
	 * ); // System.out.println("Database Version NO : "+rs.getString("VersionNo")
	 * +" Version Date : "+rs.getDate("createdDate"));
	 * logger.info("Database Version NO : "+rs.getString("VersionNo")
	 * +" Version Date : "+rs.getDate("createdDate")); }
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in versionCheck : "+e.getMessage());
	 * e.printStackTrace(); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return latestVersionDetails;
	 * 
	 * }
	 */

	@Override
	public LatestVersionDetails versionCheck() {
		LatestVersionDetails latestVersionDetails = new LatestVersionDetails();
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "selectVersionDetail");

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
					String vno = rs.optString("VersionNo");
					String createdDate = TimeUtils.getFormattedSQLDateStrFromDateStr(rs.optString("createdDate"));

					latestVersionDetails.setVersionNo(Double.parseDouble(vno.replaceAll("Ver", "")));
					latestVersionDetails.setCreatedDate(createdDate);
					logger.info("Database Version NO : " + vno + " Version Date : " + createdDate);
				}
			}
		} catch (Exception ex) {
			logger.error("Exception in versionCheck : ", ex);
		}

		return latestVersionDetails;
	}

	/*
	 * @Override public MachineAuth getMachineAuthenticationDetails(String ssoid) {
	 * Connection connection = null; MachineAuth machine_auth =new MachineAuth();
	 * try { connection = jdbcTemplate.getDataSource().getConnection(); String
	 * procedureCall = "{call [Proc_Info](?,?,?,?,?)}"; CallableStatement callableSt
	 * = connection.prepareCall(procedureCall);
	 * 
	 * callableSt.setString(1, "select"); callableSt.setInt(2, 0);
	 * callableSt.setInt(3, 0); callableSt.setInt(4, 0); callableSt.setString(5,
	 * ssoid);
	 * 
	 * ResultSet rs=callableSt.executeQuery(); if(rs.next()){
	 * machine_auth.setMachineId(rs.getString("MachineId"));
	 * machine_auth.setSsoId(rs.getString("SSOId")); }
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in getMachineAuthenticationDetails : "+e.getMessage()
	 * ); e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return machine_auth; }
	 */

	@Override
	public MachineAuth getMachineAuthenticationDetails(String ssoid) {
		MachineAuth machine_auth = new MachineAuth();
		try {
			QueryDetails queryDetails = new QueryDetails("Proc_Info");

			queryDetails.addQueryParams(1, "select");
			queryDetails.addQueryParams(2, 0);
			queryDetails.addQueryParams(3, 0);
			queryDetails.addQueryParams(4, 0);
			queryDetails.addQueryParams(5, ssoid);

			DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
			logger.info("Response status of getMachineAuthenticationDetails:" + serviceResponse.getStatus());

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				JSONArray resultSet = serviceResponse.getJsonArray();
				if (null != resultSet && resultSet.length() > 0) {
					org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
					machine_auth.setMachineId(rs.optString("MachineId"));
					machine_auth.setSsoId(rs.optString("SSOId"));
				}
			}
		} catch (Exception ex) {
			logger.error("Exception in getMachineAuthenticationDetails : ", ex);
		}

		return machine_auth;
	}

	/*
	 * public void updateDeleteTransactionFlag(String msg, String
	 * emitraTransactionId) { String procedureCall = ""; Connection connection =
	 * null; try { connection = jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [proc_kiosk](?,?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "updateDeleteTransactionFlag"); callableSt.setString(2, msg);
	 * callableSt.setString(3, emitraTransactionId); callableSt.execute();
	 * connection.commit();
	 * 
	 * } catch (Exception e) {
	 * logger.error("Exception in updateDeleteTransactionFlag : " + e.getMessage());
	 * e.printStackTrace(); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */

	public void updateDeleteTransactionFlag(String msg, String emitraTransactionId) {
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "updateDeleteTransactionFlag");
			queryDetails.addQueryParams(2, msg);
			queryDetails.addQueryParams(3, emitraTransactionId);

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of updateDeleteTransactionFlag:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in updateDeleteTransactionFlag : ", ex);
		}
	}

	/*
	 * @Override public void saveMachineAuth(MachineAuth mach, String SSOID, String
	 * versionNo) { String procedureCall = ""; Connection connection = null; try {
	 * connection = jdbcTemplate.getDataSource().getConnection();
	 * connection.setAutoCommit(false); procedureCall =
	 * "{call [Proc_Info](?,?,?,?,?,?,?,?)}"; CallableStatement callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1, "insert");
	 * callableSt.setInt(2,0); callableSt.setInt(3,0); callableSt.setInt(4,0);
	 * callableSt.setString(5,SSOID); callableSt.setString(6,mach.machineId);
	 * callableSt.setInt(7,0); callableSt.setString(8,versionNo);
	 * 
	 * callableSt.execute();
	 * 
	 * connection.commit(); // System.out.println("successfully"); } catch
	 * (Exception e) {
	 * logger.error("Exception in saveMachineAuth : "+e.getMessage());
	 * e.printStackTrace(); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { if (connection != null) { try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } } } }
	 */

	@Override
	public void saveMachineAuth(MachineAuth mach, String SSOID, String versionNo) {
		try {
			QueryDetails queryDetails = new QueryDetails("Proc_Info");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "insert");
			queryDetails.addQueryParams(2, 0);
			queryDetails.addQueryParams(3, 0);
			queryDetails.addQueryParams(4, 0);
			queryDetails.addQueryParams(5, SSOID);
			queryDetails.addQueryParams(6, mach.machineId);
			queryDetails.addQueryParams(7, 0);
			queryDetails.addQueryParams(8, versionNo);

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of saveMachineAuth:" + serviceResponse.getStatus());
		} catch (Exception ex) {
			logger.error("Exception in saveMachineAuth : ", ex);
		}
	}

	/*
	 * @Override public boolean insertUntrackedEmitraTransaction(Bill bill) { try {
	 * Connection connection = jdbcTemplate.getDataSource().getConnection();
	 * CallableStatement callableSt =
	 * connection.prepareCall("{call [proc_kiosk](?,?,?,?,?,?)}");
	 * callableSt.setString(1, "insertUntrackedEmitraTransaction");
	 * callableSt.setString(2, bill.getBackToBackTransactionID());
	 * callableSt.setString(3, bill.getTransactionId()); callableSt.setString(4,
	 * bill.getSsoID()); callableSt.setInt(5, bill.getServiceProviderID());
	 * callableSt.setString(6, bill.getBillAmount()); callableSt.execute(); return
	 * true; } catch (Exception ex) { logger.
	 * error("Caught an exception while inserting UntrackedEmitraTransaction !!",
	 * ex); }
	 * 
	 * return false; }
	 */

	@Override
	public boolean insertUntrackedEmitraTransaction(Bill bill) {
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");

			queryDetails.addQueryParams(1, "insertUntrackedEmitraTransaction");
			queryDetails.addQueryParams(2, bill.getBackToBackTransactionID());
			queryDetails.addQueryParams(3, bill.getTransactionId());
			queryDetails.addQueryParams(4, bill.getSsoID());
			queryDetails.addQueryParams(5, bill.getServiceProviderID());
			queryDetails.addQueryParams(6, bill.getBillAmount());

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of saveMachineAuth:" + serviceResponse.getStatus());

			if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
				return true;
			}
		} catch (Exception ex) {
			logger.error("Caught an exception while inserting UntrackedEmitraTransaction !!", ex);
		}

		return false;
	}

	/*
	 * @Override public String getBankReferenceNumber(String btbTransactionID) {
	 * String referenceNo = ""; String procedureCall = ""; Connection connection =
	 * null; CallableStatement callableSt = null;
	 * logger.info("getBankReferenceNumber, backtobackTransactionID: "
	 * +btbTransactionID); try { connection =
	 * jdbcTemplate.getDataSource().getConnection(); procedureCall =
	 * "{call [proc_kiosk](?,?)}"; callableSt =
	 * connection.prepareCall(procedureCall); callableSt.setString(1,
	 * "selectBankTxn"); callableSt.setString(2,btbTransactionID); ResultSet
	 * rs=callableSt.executeQuery(); if (rs.next()) { referenceNo =
	 * rs.getString("RPPTXNID"); }
	 * 
	 * } catch (Exception e) { referenceNo = "";
	 * logger.error("Exception in getBankReferenceNumber : "+e.getMessage());
	 * e.printStackTrace(); } finally { if (connection != null) try {
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * return referenceNo; }
	 */

	@Override
	public void accpetMachineAmountDetails(String transid, String totalAmount, String noteValue) {
		try {
			QueryDetails queryDetails = new QueryDetails("proc_kiosk");
			queryDetails.setAutoCommit(false);

			queryDetails.addQueryParams(1, "acceptAmount");
			queryDetails.addQueryParams(2, transid);
			queryDetails.addQueryParams(3, totalAmount);
			queryDetails.addQueryParams(4, noteValue);

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("Response status of accpetMachineAmountDetails:" + serviceResponse.getStatus());

		} catch (Exception ex) {
			logger.error("Caught an exception while accpetMachineAmountDetails !!", ex);
		}

	}

	@Override
	public void saveVerifiedData(String verifiedData) {
		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(verifiedData);
			String TRANSACTIONDATE = (String) json.get("TRANSACTIONDATE");
			String RECEIPTNO = (String) json.get("RECEIPTNO");
			String REQUESTID = (String) json.get("REQUESTID");
			String TRANSACTIONID = (String) json.get("TRANSACTIONID");
			String AMT = (String) json.get("AMT");
			String EMITRATIMESTAMP = (String) json.get("EMITRATIMESTAMP");
			String TRANSACTIONSTATUS = (String) json.get("TRANSACTIONSTATUS");
			String VERIFYSTATUSCODE = (String) json.get("VERIFYSTATUSCODE");
			String MSG = (String) json.get("MSG");
			String SSOTOKEN = (String) json.get("SSOTOKEN");
			String CHECKSUM = (String) json.get("CHECKSUM");
			String SERVICEID = (String) json.get("SERVICEID");
			String CONSUMERKEY = (String) json.get("CONSUMERKEY");

			QueryDetails queryDetails = new QueryDetails("Proc_CardBill");

			queryDetails.addQueryParams(1, "verifyInsertDetails");
			queryDetails.addQueryParams(2, TRANSACTIONDATE);
			queryDetails.addQueryParams(3, RECEIPTNO);
			queryDetails.addQueryParams(4, REQUESTID);
			queryDetails.addQueryParams(5, TRANSACTIONID);
			queryDetails.addQueryParams(6, AMT);
			queryDetails.addQueryParams(7, EMITRATIMESTAMP);
			queryDetails.addQueryParams(8, TRANSACTIONSTATUS);
			queryDetails.addQueryParams(9, VERIFYSTATUSCODE);
			queryDetails.addQueryParams(10, MSG);
			queryDetails.addQueryParams(11, SSOTOKEN);
			queryDetails.addQueryParams(12, CHECKSUM);
			queryDetails.addQueryParams(13, SERVICEID);
			queryDetails.addQueryParams(14, CONSUMERKEY);

			DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
			logger.info("saveVerifiedData, Response status of saveVerifiedData(Insertion):" + serviceResponse.getStatus());
			
			
		/*	procedureCall = "{call [Proc_CardBill](?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement callableSt2 = connection.prepareCall(procedureCall);
			callableSt2.setString(1, "verifyInsertDetails");
			callableSt2.setString(2, TRANSACTIONDATE);
			callableSt2.setString(3, RECEIPTNO);
			callableSt2.setString(4, REQUESTID);
			callableSt2.setString(5, TRANSACTIONID);
			callableSt2.setString(6, AMT);
			callableSt2.setString(7, EMITRATIMESTAMP);
			callableSt2.setString(8, TRANSACTIONSTATUS);
			callableSt2.setString(9, VERIFYSTATUSCODE);
			callableSt2.setString(10, MSG);
			callableSt2.setString(11, SSOTOKEN);
			callableSt2.setString(12, CHECKSUM);
			callableSt2.setString(13, SERVICEID);
			callableSt2.setString(14, CONSUMERKEY);
			callableSt2.execute();*/

			if (VERIFYSTATUSCODE.equals("200")) {
				
				queryDetails = new QueryDetails("Proc_CardBill");

				queryDetails.addQueryParams(1, "updateVerifiedData");
				queryDetails.addQueryParams(2, RECEIPTNO);
				queryDetails.addQueryParams(3, REQUESTID);
				queryDetails.addQueryParams(4, TRANSACTIONID);
				queryDetails.addQueryParams(5, AMT);
				queryDetails.addQueryParams(6, EMITRATIMESTAMP);
				queryDetails.addQueryParams(7, TRANSACTIONSTATUS);
				queryDetails.addQueryParams(8, VERIFYSTATUSCODE);
				queryDetails.addQueryParams(9, MSG);
				queryDetails.addQueryParams(10, CHECKSUM);
				
				serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
				logger.info("saveVerifiedData, Response status of saveVerifiedData(Updation):" + serviceResponse.getStatus());
				/*procedureCall = "{call [Proc_CardBill](?,?,?,?,?,?,?,?,?,?)}";
				callableSt2 = connection.prepareCall(procedureCall);
				callableSt2.setString(1, "updateVerifiedData");
				callableSt2.setString(2, RECEIPTNO);
				callableSt2.setString(3, REQUESTID);
				callableSt2.setString(4, TRANSACTIONID);
				callableSt2.setString(5, AMT);
				callableSt2.setString(6, EMITRATIMESTAMP);
				callableSt2.setString(7, TRANSACTIONSTATUS);
				callableSt2.setString(8, VERIFYSTATUSCODE);
				callableSt2.setString(9, MSG);
				callableSt2.setString(10, CHECKSUM);
				callableSt2.execute();*/
			}

		} catch (Exception e) {
			logger.error("Exception in saveVerifiedData :" + e.getMessage());
		} 
	}

	@Override
    public boolean updateUntrackedEmitraTransaction(Bill billDetails) {
        try {
            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

            queryDetails.addQueryParams(1, "updateUntrackedEmitraTransaction");
            queryDetails.addQueryParams(2, billDetails.getBackToBackTransactionID());
            queryDetails.addQueryParams(3, billDetails.getTransactionId());
            queryDetails.addQueryParams(4, billDetails.getSsoID());
            queryDetails.addQueryParams(5, billDetails.getServiceProviderID());
            queryDetails.addQueryParams(6, billDetails.getBillAmount());
            queryDetails.addQueryParams(7, billDetails.getrECEIPTNO());
            queryDetails.addQueryParams(8, billDetails.geteMITRATIMESTAMP());
            queryDetails.addQueryParams(9, billDetails.gettRANSACTIONSTATUS());
            queryDetails.addQueryParams(10, billDetails.getvERIFYSTATUSCODE());
            queryDetails.addQueryParams(11, billDetails.getmSG());

            DBServiceResponse serviceResponse = dbHTTPUtils.pushDataToDBApiServer(queryDetails);
            logger.info("Response status of saveMachineAuth:" + serviceResponse.getStatus());

            if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
                return true;
            }
        } catch (Exception ex) {
            logger.error("Caught an exception while inserting UntrackedEmitraTransaction !!", ex);
        }

        return false;
    }
}
