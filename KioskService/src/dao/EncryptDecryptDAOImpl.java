package dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bill;
import model.DBServiceResponse;
import model.Discom;
import model.Phed;
import model.QueryDetails;
import utils.DBHTTPUtils;

@Repository("encryptDecryptDao")
public class EncryptDecryptDAOImpl implements EncryptDecryptDAO {
	
	static final Logger logger = Logger.getLogger(EncryptDecryptDAOImpl.class);
	
	 @Autowired
	 DBHTTPUtils dbHTTPUtils;
/*	
	@Override
	public List<Bill> getAirtelDetails(String apiResult, Bill bill) {
		List<Bill> airtelBillDetails = new ArrayList<Bill>();
		String procedureCall = "";
		Connection connection = null;
		String dbTransID=null;
		CallableStatement callableSt =  null;
		
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			
			String x[] = apiResult.split("TransactionDetails");
			String x1[] = x[1].split("BillDetails");
		//	String x4[] = x[1].split("SSODetails");
			String x2[] = x1[0].split(":");
			String x3[] = x1[1].split(":");
			for (int i = 0; i < x4.length; i++)
				System.out.println("csd::::::::" + x4[i]);
			
			procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "transactioninsert");
			callableSt.setString(2, x2[2].split(",")[0].substring(1, x2[2].split(",")[0].length() - 1));
			callableSt.setString(3, x2[3].split(",")[0].substring(1, x2[3].split(",")[0].length() - 1));
			callableSt.setString(4, x2[4].split(",")[0].substring(1, x2[4].split(",")[0].length() - 1));
			callableSt.setString(5, x2[5].split(",")[0].substring(1, x2[5].split(",")[0].length() - 1));
			callableSt.setString(6, x2[6].split(",")[0].substring(1, x2[6].split(",")[0].length() - 1));
			callableSt.setString(7, x2[7].split(",")[0].substring(1, x2[7].split(",")[0].length() - 1));
			callableSt.setString(8, x2[8].split(",")[0].substring(1, x2[8].split(",")[0].length() - 1));
			callableSt.setString(9, x2[9].split(",")[0].substring(1, x2[9].split(",")[0].length() - 1));
			callableSt.setString(10, x2[10].split(",")[0].substring(1, x2[10].split(",")[0].length() - 2));
			callableSt.setString(11, x3[3].split(",")[0].substring(1, x3[3].split(",")[0].length() - 2));
			callableSt.setString(12, x3[5].split(",")[0].substring(1, x3[5].split(",")[0].length() - 2));
			callableSt.setString(13, x3[7].split(",")[0].substring(1, x3[7].split(",")[0].length() - 2));
			callableSt.setString(14, x3[9].split(",")[0].substring(1, x3[9].split(",")[0].length() - 2));
			callableSt.setString(15, x3[11].split(",")[0].substring(1, x3[11].split(",")[0].length() - 2));
			// callableSt.setString(7, x3[13].split(",")[0].substring(1,
			// x3[13].split(",")[0].length()-2));
			callableSt.setString(16, x3[15].split(",")[0].substring(1, x3[15].split(",")[0].length() - 2));
			callableSt.setString(17, x3[17].split(",")[0].substring(1, x3[17].split(",")[0].length() - 2));
			callableSt.setString(18, x3[19].split(",")[0].substring(1, x3[19].split(",")[0].length() - 5));
			callableSt.setString(19, bill.getSsoID());
			callableSt.setInt(20, bill.getServiceProviderID());
			callableSt.setString(21, bill.getBillEmail());
		//	callableSt.execute();
			ResultSet rs1=callableSt.executeQuery();
			if (rs1.next()) {
				dbTransID=rs1.getString("TransId");
			}
		} catch (Exception e) {
			logger.error("Exception in insert trasaction AirtelDetails : "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			callableSt = null;
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			procedureCall = "{call [proc_kiosk](?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "selectbills");
			callableSt.setString(2,dbTransID );
			//callableSt.setString(2, bill.getBillMobileNo());
			ResultSet rs = callableSt.executeQuery();
			if (rs.next()) {
				Bill bill1 = new Bill();
				bill1.setBillAmount(rs.getString("amountafterduedate"));
				bill1.setBillMobileNo(rs.getString("mobilenumber"));
				bill1.setDueDate(rs.getString("duedate"));
				bill1.setName(rs.getString("consumername"));
				bill1.setServiceProviderName(rs.getString("servicename"));
				bill1.setBillEmail(rs.getString("EmailId"));
				bill1.setTransactionId(rs.getString("TransId"));
				bill1.setCreatedDate(rs.getString("gettimestamp"));
			//	bill1.setPartpaymentallow(rs.getBoolean("partpaymentallow"));
				if(rs.getInt("partpaymentallow")==1) {
					bill1.setPartpaymentallow(true);
				}else {
					bill1.setPartpaymentallow(false);
				}
				bill1.setPartpaymenttype(rs.getString("partpaymenttype"));
				airtelBillDetails.add(bill1);
			}

		} catch (Exception e) {
			logger.error("Exception in getAirtelDetails : "+e.getMessage());
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
		return airtelBillDetails;
	}*/
	
	 @Override
	    public List<Bill> getAirtelDetails(String apiResult, Bill bill) {
	        List<Bill> airtelBillDetails = new ArrayList<Bill>();
	        String dbTransID = null;

	        try {
	            String x[] = apiResult.split("TransactionDetails");
	            String x1[] = x[1].split("BillDetails");
	            String x2[] = x1[0].split(":");
	            String x3[] = x1[1].split(":");

	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "transactioninsert");
	            queryDetails.addQueryParams(2, x2[2].split(",")[0].substring(1, x2[2].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(3, x2[3].split(",")[0].substring(1, x2[3].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(4, x2[4].split(",")[0].substring(1, x2[4].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(5, x2[5].split(",")[0].substring(1, x2[5].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(6, x2[6].split(",")[0].substring(1, x2[6].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(7, x2[7].split(",")[0].substring(1, x2[7].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(8, x2[8].split(",")[0].substring(1, x2[8].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(9, x2[9].split(",")[0].substring(1, x2[9].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(10, x2[10].split(",")[0].substring(1, x2[10].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(11, x3[3].split(",")[0].substring(1, x3[3].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(12, x3[5].split(",")[0].substring(1, x3[5].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(13, x3[7].split(",")[0].substring(1, x3[7].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(14, x3[9].split(",")[0].substring(1, x3[9].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(15, x3[11].split(",")[0].substring(1, x3[11].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(16, x3[15].split(",")[0].substring(1, x3[15].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(17, x3[17].split(",")[0].substring(1, x3[17].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(18, x3[19].split(",")[0].substring(1, x3[19].split(",")[0].length() - 5));
	            queryDetails.addQueryParams(19, bill.getSsoID());
	            queryDetails.addQueryParams(20, bill.getServiceProviderID());
	            queryDetails.addQueryParams(21, bill.getBillEmail());

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs1 = (org.json.JSONObject) resultSet.get(0);
	                dbTransID = rs1.optString("TransId");
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in insert trasaction AirtelDetails : ", ex);
	        }

	        try {
	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "selectbills");
	            queryDetails.addQueryParams(2, dbTransID);

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
	                Bill bill1 = new Bill();
	                bill1.setBillAmount(rs.optString("amountafterduedate"));
	                bill1.setBillMobileNo(rs.optString("mobilenumber"));
	                bill1.setDueDate(rs.optString("duedate"));
	                bill1.setName(rs.optString("consumername"));
	                bill1.setServiceProviderName(rs.optString("servicename"));
	                bill1.setBillEmail(rs.optString("EmailId"));
	                bill1.setTransactionId(rs.optString("TransId"));
	                bill1.setCreatedDate(rs.optString("gettimestamp"));

	                if (rs.getInt("partpaymentallow") == 1) {
	                    bill1.setPartpaymentallow(true);
	                } else {
	                    bill1.setPartpaymentallow(false);
	                }
	                bill1.setPartpaymenttype(rs.optString("partpaymenttype"));
	                airtelBillDetails.add(bill1);
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in getAirtelDetails : ", ex);
	        }

	        return airtelBillDetails;
	    }
	
	/*@Override
	public List<Bill> getIdeaDetails(String apiResult, Bill bill) {
		List<Bill> ideaBillDetails = new ArrayList<Bill>();
		String procedureCall = "";
		Connection connection = null;
		String dbTransID=null;
		CallableStatement callableSt =  null;
		
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			
			String x[]=apiResult.split("TransactionDetails");
			String x1[]=x[1].split("BillDetails");
		//	String x4[]=x[1].split("SSODetails");
			String x2[]=x1[0].split(":");
			String x3[]=x1[1].split(":");
			for(int i=0;i<x3.length;i++)
				System.out.println("csd::::::::"+x3[i]);
			
		    procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "transactioninsertidea");
			callableSt.setString(2, x2[2].split(",")[0].substring(1, x2[2].split(",")[0].length()-1));
			callableSt.setString(3, x2[3].split(",")[0].substring(1, x2[3].split(",")[0].length()-1));
			callableSt.setString(4,  x2[4].split(",")[0].substring(1, x2[4].split(",")[0].length()-1));
			callableSt.setString(5, x2[5].split(",")[0].substring(1, x2[5].split(",")[0].length()-1));
			callableSt.setString(6,  x2[6].split(",")[0].substring(1, x2[6].split(",")[0].length()-1));
			callableSt.setString(7, x2[7].split(",")[0].substring(1, x2[7].split(",")[0].length()-1));
			callableSt.setString(8,  x2[8].split(",")[0].substring(1, x2[8].split(",")[0].length()-1));
			callableSt.setString(9,  x2[9].split(",")[0].substring(1, x2[9].split(",")[0].length()-1));
			callableSt.setString(10,  x2[10].split(",")[0].substring(1, x2[10].split(",")[0].length()-2));
			callableSt.setString(11, x3[3].split(",")[0].substring(1, x3[3].split(",")[0].length()-2));
			callableSt.setString(12, x3[5].split(",")[0].substring(1, x3[5].split(",")[0].length()-2));
			callableSt.setString(13,  x3[7].split(",")[0].substring(1, x3[7].split(",")[0].length()-2));
			callableSt.setString(14, x3[9].split(",")[0].substring(1, x3[9].split(",")[0].length()-2));
			callableSt.setString(15,  x3[11].split(",")[0].substring(1, x3[11].split(",")[0].length()-2));
		//	callableSt.setString(7, x3[13].split(",")[0].substring(1, x3[13].split(",")[0].length()-2));
			callableSt.setString(16,  x3[13].substring(1,x3[13].length()-5));
			callableSt.setString(17,  null);
			callableSt.setString(18,  null);
			callableSt.setString(19, bill.getSsoID());
			callableSt.setInt(20, bill.getServiceProviderID());
			callableSt.setString(21, bill.getBillEmail());
			//callableSt.execute();
			ResultSet rs1=callableSt.executeQuery();
			if (rs1.next()) {
				dbTransID=rs1.getString("TransId");
			}
		} catch (Exception e) {
			logger.error("Exception in insert transaction IdeaDetails : "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			callableSt = null;
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
            procedureCall = "{call [proc_kiosk](?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "selectbillsidea");
			callableSt.setString(2,dbTransID );
			ResultSet rs=callableSt.executeQuery();
			if(rs.next())
			{
				Bill bill1=new Bill();
				bill1.setBillAmount(rs.getString("AmountPayable"));
				bill1.setBillMobileNo(rs.getString("MobileNumber"));
				bill1.setDueDate(rs.getString("BillDate"));
				bill1.setName(rs.getString("ConsumerName"));
				bill1.setServiceProviderName(rs.getString("servicename"));
				bill1.setBillEmail(rs.getString("EmailId"));
				bill1.setTransactionId(rs.getString("TransId"));
				bill1.setCreatedDate(rs.getString("gettimestamp"));
				//bill1.setPartpaymentallow(rs.getBoolean("partpaymentallow"));
				if(rs.getInt("partpaymentallow")==1) {
					bill1.setPartpaymentallow(true);
				}else {
					bill1.setPartpaymentallow(false);
				}
				bill1.setPartpaymenttype(rs.getString("partpaymenttype"));
				ideaBillDetails.add(bill1);
			}
			

		} catch (Exception e) {
			logger.error("Exception in getIdeaDetails : "+e.getMessage());
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
		return ideaBillDetails;
	}*/
	 
	 
	 @Override
	    public List<Bill> getIdeaDetails(String apiResult, Bill bill) {
	        List<Bill> ideaBillDetails = new ArrayList<Bill>();
	        String dbTransID = null;
	        try {
	            String x[] = apiResult.split("TransactionDetails");
	            String x1[] = x[1].split("BillDetails");
	            String x2[] = x1[0].split(":");
	            String x3[] = x1[1].split(":");

	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "transactioninsertidea");
	            queryDetails.addQueryParams(2, x2[2].split(",")[0].substring(1, x2[2].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(3, x2[3].split(",")[0].substring(1, x2[3].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(4, x2[4].split(",")[0].substring(1, x2[4].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(5, x2[5].split(",")[0].substring(1, x2[5].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(6, x2[6].split(",")[0].substring(1, x2[6].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(7, x2[7].split(",")[0].substring(1, x2[7].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(8, x2[8].split(",")[0].substring(1, x2[8].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(9, x2[9].split(",")[0].substring(1, x2[9].split(",")[0].length() - 1));
	            queryDetails.addQueryParams(10, x2[10].split(",")[0].substring(1, x2[10].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(11, x3[3].split(",")[0].substring(1, x3[3].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(12, x3[5].split(",")[0].substring(1, x3[5].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(13, x3[7].split(",")[0].substring(1, x3[7].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(14, x3[9].split(",")[0].substring(1, x3[9].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(15, x3[11].split(",")[0].substring(1, x3[11].split(",")[0].length() - 2));
	            queryDetails.addQueryParams(16, x3[13].substring(1, x3[13].length() - 5));
	            queryDetails.addQueryParams(17, null);
	            queryDetails.addQueryParams(18, null);
	            queryDetails.addQueryParams(19, bill.getSsoID());
	            queryDetails.addQueryParams(20, bill.getServiceProviderID());
	            queryDetails.addQueryParams(21, bill.getBillEmail());

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs1 = (org.json.JSONObject) resultSet.get(0);
	                dbTransID = rs1.optString("TransId");
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in insert transaction IdeaDetails : ", ex);
	        }

	        try {
	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "selectbillsidea");
	            queryDetails.addQueryParams(2, dbTransID);

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
	                Bill bill1 = new Bill();
	                bill1.setBillAmount(rs.optString("AmountPayable"));
	                bill1.setBillMobileNo(rs.optString("MobileNumber"));
	                bill1.setDueDate(rs.optString("BillDate"));
	                bill1.setName(rs.optString("ConsumerName"));
	                bill1.setServiceProviderName(rs.optString("servicename"));
	                bill1.setBillEmail(rs.optString("EmailId"));
	                bill1.setTransactionId(rs.optString("TransId"));
	                bill1.setCreatedDate(rs.optString("gettimestamp"));
	                // bill1.setPartpaymentallow(rs.getBoolean("partpaymentallow"));
	                if (rs.getInt("partpaymentallow") == 1) {
	                    bill1.setPartpaymentallow(true);
	                } else {
	                    bill1.setPartpaymentallow(false);
	                }
	                bill1.setPartpaymenttype(rs.optString("partpaymenttype"));
	                ideaBillDetails.add(bill1);
	            }

	        } catch (Exception ex) {
	            logger.error("Exception in getIdeaDetails : ", ex);
	        }

	        return ideaBillDetails;
	    }
	
	
/*	@Override
	public List<Bill> getVodafoneDetails(String apiResult, Bill bill) {
		List<Bill> vodafoneBillDetails = new ArrayList<Bill>();
		String procedureCall = "";
		Connection connection = null;
		CallableStatement callableSt =  null;
		JSONParser parser = new JSONParser();
	    JSONObject json;
	    String dbTransID=null;
	    
		try {
			json = (JSONObject) parser.parse(apiResult);
			JSONObject fetchobj = (JSONObject) json.get("FetchDetails");
			JSONObject transobj = (JSONObject) fetchobj.get("TransactionDetails");
			JSONArray billarray = (JSONArray) fetchobj.get("BillDetails");
			
			for (Object o : billarray) {
				JSONObject jsonLineItem = (JSONObject) o;
				String key = (String) jsonLineItem.get("LableName");
				String value = (String) jsonLineItem.get("LableValue");
			}
			
			connection = jdbcTemplate.getDataSource().getConnection();
			procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "transactioninsertVoda");
			callableSt.setString(2, transobj.get("ServiceName").toString());
			callableSt.setString(3, transobj.get("officeID").toString());
			callableSt.setString(4, transobj.get("BillAmount").toString());
			callableSt.setString(5, transobj.get("ConsumerName").toString());
			callableSt.setString(6, transobj.get("consumerKeysValues").toString());
			callableSt.setString(7, transobj.get("partPaymentAllow").toString());
			callableSt.setString(8, transobj.get("partPaymentType").toString());
			callableSt.setString(9, transobj.get("lookUpId").toString());
			callableSt.setString(10, transobj.get("officeCodeValue").toString());

			 billarray=(JSONArray)fetchobj.get("BillDetails");
			 int temp =11;
	         for (Object o : billarray) {
	             JSONObject jsonLineItem = (JSONObject) o;
	             String value = (String)jsonLineItem.get("LableValue");
	             if(value == null || value.equals(""))
	            	 callableSt.setString(temp, null);
	             else
	            	 callableSt.setString(temp, value);
	              
	             temp++;
	             if(temp == 18)
	            	 break;
	         }
			callableSt.setString(18, null );
			
			callableSt.setString(19, bill.getSsoID());
			
			callableSt.setInt(20, bill.getServiceProviderID());
			
			callableSt.setString(21, bill.getBillEmail());
			//callableSt.execute();
			ResultSet rs1=callableSt.executeQuery();
			if (rs1.next()) {
				dbTransID=rs1.getString("TransId");
			}
		} catch (Exception e) {
			logger.error("Exception in inserting transaction VodafoneDetails : "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			callableSt = null;
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			procedureCall = "{call [proc_kiosk](?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "selectbillsvodafone");
			callableSt.setString(2,dbTransID );
			ResultSet rs=callableSt.executeQuery();
			if(rs.next())
			{
				Bill bill1=new Bill();
				bill1.setBillAmount(rs.getString("amountbeforeduedate").equals("NA")?"0":rs.getString("amountbeforeduedate"));
				bill1.setBillMobileNo(rs.getString("mobilenumber"));
				bill1.setDueDate(rs.getString("duedate"));
				bill1.setName(rs.getString("consumername"));
				bill1.setServiceProviderName(rs.getString("servicename"));
				bill1.setBillEmail(rs.getString("EmailId"));
				bill1.setTransactionId(rs.getString("TransId"));
				bill1.setCreatedDate(rs.getString("gettimestamp"));
				if(rs.getInt("partpaymentallow")==1) {
					bill1.setPartpaymentallow(true);
				}else {
					bill1.setPartpaymentallow(false);
				}
				bill1.setPartpaymenttype(rs.getString("partpaymenttype"));
				vodafoneBillDetails.add(bill1);
			}

		} catch (Exception e) {
			logger.error("Exception in getVodafoneDetails : "+e.getMessage());
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
		return vodafoneBillDetails;
	}*/

	 @Override
	    public List<Bill> getVodafoneDetails(String apiResult, Bill bill) {
	        List<Bill> vodafoneBillDetails = new ArrayList<Bill>();
	        String dbTransID = null;

	        try {
	            JSONObject json = new JSONObject(apiResult);
	            JSONObject fetchobj = json.getJSONObject("FetchDetails");
	            JSONObject transobj = fetchobj.getJSONObject("TransactionDetails");
	            JSONArray billarray = fetchobj.getJSONArray("BillDetails");

	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "transactioninsertVoda");
	            queryDetails.addQueryParams(2, transobj.get("ServiceName").toString());
	            queryDetails.addQueryParams(3, transobj.get("officeID").toString());
	            queryDetails.addQueryParams(4, transobj.get("BillAmount").toString());
	            queryDetails.addQueryParams(5, transobj.get("ConsumerName").toString());
	            queryDetails.addQueryParams(6, transobj.get("consumerKeysValues").toString());
	            queryDetails.addQueryParams(7, transobj.get("partPaymentAllow").toString());
	            queryDetails.addQueryParams(8, transobj.get("partPaymentType").toString());
	            queryDetails.addQueryParams(9, transobj.get("lookUpId").toString());
	            queryDetails.addQueryParams(10, transobj.get("officeCodeValue").toString());

	            int temp = 11;
	            for (int index = 0; index < billarray.length(); index++) {
	                JSONObject jsonLineItem = billarray.getJSONObject(index);

	                String value = (String) jsonLineItem.get("LableValue");
	                
	                if(value == null || value.equals(""))
	                	  queryDetails.addQueryParams(temp, null);
					 else
						 queryDetails.addQueryParams(temp, value);
	                

	                temp++;
	                if (temp == 18)
	                    break;
	            }

	            queryDetails.addQueryParams(18, null);
	            queryDetails.addQueryParams(19, bill.getSsoID());
	            queryDetails.addQueryParams(20, bill.getServiceProviderID());
	            queryDetails.addQueryParams(21, bill.getBillEmail());

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs1 = (org.json.JSONObject) resultSet.get(0);
	                dbTransID = rs1.optString("TransId");
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in inserting transaction VodafoneDetails : ", ex);
	        }

	        try {
	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "selectbillsvodafone");
	            queryDetails.addQueryParams(2, dbTransID);

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);

	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);

	                Bill bill1 = new Bill();
	                bill1.setBillAmount(rs.optString("amountbeforeduedate").equals("NA") ? "0" : rs.optString("amountbeforeduedate"));
	                bill1.setBillMobileNo(rs.optString("mobilenumber"));
	                bill1.setDueDate(rs.optString("duedate"));
	                bill1.setName(rs.optString("consumername"));
	                bill1.setServiceProviderName(rs.optString("servicename"));
	                bill1.setBillEmail(rs.optString("EmailId"));
	                bill1.setTransactionId(rs.optString("TransId"));
	                bill1.setCreatedDate(rs.optString("gettimestamp"));

	                if (rs.getInt("partpaymentallow") == 1) {
	                    bill1.setPartpaymentallow(true);
	                } else {
	                    bill1.setPartpaymentallow(false);
	                }

	                bill1.setPartpaymenttype(rs.optString("partpaymenttype"));
	                vodafoneBillDetails.add(bill1);
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in getVodafoneDetails : ", ex);
	        }

	        return vodafoneBillDetails;
	    }

	/*public List<Discom> getDiscomDetails(String apiResult, Bill bill, Discom discom) {

		List<Discom> discomDetails = new ArrayList<Discom>();
		String procedureCall = "";
		Connection connection = null;
		CallableStatement callableSt = null;
		JSONParser parser = new JSONParser();
		JSONObject json;
		String dbTransID=null;

		try {
			connection = jdbcTemplate.getDataSource().getConnection();

			json = (JSONObject) parser.parse(apiResult);

			JSONObject fetchobj = (JSONObject) json.get("FetchDetails");
			JSONObject transobj = (JSONObject) fetchobj.get("TransactionDetails");

			JSONArray billarray = (JSONArray) fetchobj.get("BillDetails");
		//	System.out.println(billarray);

			
			 * for (Object o : billarray) { JSONObject jsonLineItem = (JSONObject) o; String
			 * key = (String) jsonLineItem.get("LableName"); String value =
			 * (String)jsonLineItem.get("LableValue"); }
			 

			procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "transactioninsertElectricity");
			callableSt.setString(2, transobj.get("ServiceName").toString());
			callableSt.setString(3, transobj.get("officeID").toString());
			callableSt.setString(4, transobj.get("BillAmount").toString());
			
			
			//callableSt.setString(5, transobj.get("ConsumerName").toString());
	        String ConsumerName = transobj.get("ConsumerName").toString();
			try {
				ConsumerName = StringEscapeUtils.unescapeJava(StringEscapeUtils.unescapeHtml4(URLDecoder.decode(ConsumerName
				.replaceAll("%u","\\\\u"),"UTF-8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	
			callableSt.setString(5, ConsumerName);
			
			callableSt.setString(6, transobj.get("consumerKeysValues").toString());
			callableSt.setString(7, transobj.get("partPaymentAllow").toString());
			callableSt.setString(8, transobj.get("partPaymentType").toString());
			callableSt.setString(9, transobj.get("lookUpId").toString());
			callableSt.setString(10, transobj.get("officeCodeValue").toString());

			billarray = (JSONArray) fetchobj.get("BillDetails");
			int temp = 11;
			for (Object o : billarray) {
				JSONObject jsonLineItem = (JSONObject) o;
				String value = (String) jsonLineItem.get("LableValue");
				
				 if(value == null || value.equals(""))
	            	 callableSt.setString(temp, null);
				 else
					 callableSt.setString(temp, value);
				 
				temp++;
				if (temp == 25)
					break;
			}
			logger.info("1::"+bill.getSsoID()+"2::"+String.valueOf(bill.getServiceProviderID())+"3::"+bill.getBillEmail());
			callableSt.setString(25, bill.getSsoID());
			callableSt.setString(26, String.valueOf(bill.getServiceProviderID()));
			callableSt.setString(27, bill.getBillEmail());
			callableSt.setString(28, bill.getBillMobileNo());
			callableSt.setString(29, bill.getBillEmail());
			//callableSt.execute();
			ResultSet rs1=callableSt.executeQuery();
			if (rs1.next()) {
				dbTransID=rs1.getString("TransId");
			}

		} catch (Exception e) {
			logger.error("Exception in getDiscomDetails transactioninsertElectricity: "+e.getMessage());
			e.printStackTrace();
		} finally {
			callableSt = null;
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			procedureCall = "{call [proc_kiosk](?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "selectbillsDiscom");
			//callableSt.setString(2, discom.getK_Number());
			callableSt.setString(2, dbTransID);
			ResultSet rs = callableSt.executeQuery();
			if (rs.next()) {
				Discom dis = new Discom();
				dis.setK_Number(rs.getString("K_Number"));
				dis.setName(rs.getString("Name"));
				dis.setChequeDueDate(rs.getString("ChequeDueDate"));
				dis.setBillYear(rs.getString("BillYear"));
				dis.setMessage(rs.getString("Message"));
				dis.setBillNo(rs.getString("BillNo"));
				dis.setAccount_number(rs.getString("ACNumber"));
				dis.setBillMonth(rs.getString("BillMonth"));
				dis.setCashDueDate(rs.getString("CashDueDate"));
				dis.setOfficeCode(rs.getString("OfficeCode"));
				dis.setAddress(rs.getString("Address"));
				dis.setPaymentType(rs.getString("PaymentType"));
				dis.setBinderNo(rs.getString("BinderNo"));
				dis.setTotalAmount(rs.getString("TotalAmount"));
				dis.setTransactionId(rs.getString("TransId"));
				dis.setEmail(rs.getString("EmailId"));
				dis.setMobile(rs.getString("Mobile"));
				dis.setConsumerKeyValue(rs.getString("consumerkeyvalue"));
				dis.setCreatedDate(rs.getString("gettimestamp"));
				discomDetails.add(dis);
			}

		} catch (Exception e) {
			logger.error("Exception in getDiscomDetails : "+e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return discomDetails;

	}*/

	 
	 public List<Discom> getDiscomDetails(String apiResult, Bill bill, Discom discom) {

	        List<Discom> discomDetails = new ArrayList<Discom>();
	        String dbTransID = null;
	        try {
	            org.json.JSONObject jsonObject = new org.json.JSONObject(apiResult);

	            JSONObject fetchobj = jsonObject.getJSONObject("FetchDetails");
	            JSONObject transobj = (JSONObject) fetchobj.get("TransactionDetails");

	            JSONArray billarray = fetchobj.getJSONArray("BillDetails");

	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "transactioninsertElectricity");
	            queryDetails.addQueryParams(2, transobj.get("ServiceName").toString());
	            queryDetails.addQueryParams(3, transobj.get("officeID").toString());
	            queryDetails.addQueryParams(4, transobj.get("BillAmount").toString());

	            String ConsumerName = transobj.get("ConsumerName").toString();
	            try {
	                ConsumerName = StringEscapeUtils.unescapeJava(StringEscapeUtils.unescapeHtml4(URLDecoder.decode(
	                        ConsumerName.replaceAll("%u", "\\\\u"), "UTF-8")));
	            } catch (UnsupportedEncodingException ex) {
	                ex.printStackTrace();
	            }

	            queryDetails.addQueryParams(5, ConsumerName);

	            queryDetails.addQueryParams(6, transobj.get("consumerKeysValues").toString());
	            queryDetails.addQueryParams(7, transobj.get("partPaymentAllow").toString());
	            queryDetails.addQueryParams(8, transobj.get("partPaymentType").toString());
	            queryDetails.addQueryParams(9, transobj.get("lookUpId").toString());
	            queryDetails.addQueryParams(10, transobj.get("officeCodeValue").toString());

	            int temp = 11;
	            for (int index = 0; index < billarray.length(); index++) {
	                JSONObject jsonLineItem = billarray.getJSONObject(index);
	                String value = (String) jsonLineItem.get("LableValue");
	                
	                if(value == null || value.equals(""))
	                	  queryDetails.addQueryParams(temp, null);
					 else
						 queryDetails.addQueryParams(temp, value);
	                
	                
	                temp++;
	                if (temp == 25)
	                    break;
	            }
	            logger.info("1::" + bill.getSsoID() + "2::" + String.valueOf(bill.getServiceProviderID()) + "3::"
	                    + bill.getBillEmail());

	            queryDetails.addQueryParams(25, bill.getSsoID());
	            queryDetails.addQueryParams(26, String.valueOf(bill.getServiceProviderID()));
	            queryDetails.addQueryParams(27, bill.getBillEmail());
	            queryDetails.addQueryParams(28, bill.getBillMobileNo());
	            queryDetails.addQueryParams(29, bill.getBillEmail());

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs1 = (org.json.JSONObject) resultSet.get(0);
	                dbTransID = rs1.optString("TransId");
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in getDiscomDetails transactioninsertElectricity: ", ex);
	        }

	        try {
	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "selectbillsDiscom");
	            queryDetails.addQueryParams(2, dbTransID);

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
	                Discom dis = new Discom();
	                dis.setK_Number(rs.optString("K_Number"));
	                dis.setName(rs.optString("Name"));
	                dis.setChequeDueDate(rs.optString("ChequeDueDate"));
	                dis.setBillYear(rs.optString("BillYear"));
	                dis.setMessage(rs.optString("Message"));
	                dis.setBillNo(rs.optString("BillNo"));
	                dis.setAccount_number(rs.optString("ACNumber"));
	                dis.setBillMonth(rs.optString("BillMonth"));
	                dis.setCashDueDate(rs.optString("CashDueDate"));
	                dis.setOfficeCode(rs.optString("OfficeCode"));
	                dis.setAddress(rs.optString("Address"));
	                dis.setPaymentType(rs.optString("PaymentType"));
	                dis.setBinderNo(rs.optString("BinderNo"));
	                dis.setTotalAmount(rs.optString("TotalAmount"));
	                dis.setTransactionId(rs.optString("TransId"));
	                dis.setEmail(rs.optString("EmailId"));
	                dis.setMobile(rs.optString("Mobile"));
	                dis.setConsumerKeyValue(rs.optString("consumerkeyvalue"));
	                dis.setCreatedDate(rs.optString("gettimestamp"));
	                discomDetails.add(dis);
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in getDiscomDetails : ", ex);
	        }

	        return discomDetails;
	    }

	/*@Override
	public List<Bill> getBsnlDetails(String apiResult, Bill bill) {
		List<Bill> bsnlBillDetails = new ArrayList<Bill>();
		String procedureCall = "";
		Connection connection = null;
		String dbTransID=null;
		CallableStatement callableSt =  null;
		JSONParser parser = new JSONParser();
	    JSONObject json;
	    
		try {
			json = (JSONObject) parser.parse(apiResult);
			JSONObject fetchobj = (JSONObject) json.get("FetchDetails");
			JSONObject transobj = (JSONObject) fetchobj.get("TransactionDetails");
			JSONArray billarray = (JSONArray) fetchobj.get("BillDetails");
			
			connection = jdbcTemplate.getDataSource().getConnection();
			procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "transactioninsertBSNL");
			callableSt.setString(2, transobj.get("ServiceName").toString());
			callableSt.setString(3, transobj.get("officeID").toString());
			callableSt.setString(4,transobj.get("BillAmount").toString()==null || transobj.get("BillAmount").toString().equals("NA")?"0":transobj.get("BillAmount").toString());
			callableSt.setString(5, transobj.get("ConsumerName").toString());
			callableSt.setString(6, transobj.get("consumerKeysValues").toString());
			callableSt.setString(7, transobj.get("partPaymentAllow").toString());
			callableSt.setString(8, transobj.get("partPaymentType").toString());
			callableSt.setString(9, transobj.get("lookUpId").toString());
			callableSt.setString(10, transobj.get("officeCodeValue").toString());
            callableSt.setString(11, bill.getSsoID());
			callableSt.setInt(12, bill.getServiceProviderID());
			callableSt.setString(13, bill.getBillEmail());
			
			billarray=(JSONArray)fetchobj.get("BillDetails");
			 int temp =14;
	         for (Object o : billarray) {
	             JSONObject jsonLineItem = (JSONObject) o;
	             String value = (String)jsonLineItem.get("LableValue");
	             
	             if(value == null || value.equals(""))
	            	 callableSt.setString(temp, null);
				 else
					 callableSt.setString(temp, value);
	             
	             temp++;
	             if(temp == 30)
	            	 break;
	         }
			//callableSt.execute();
	         
	         ResultSet rs1=callableSt.executeQuery();
			 if (rs1.next()) {
				dbTransID=rs1.getString("TransId");
			 }
		} catch (Exception e) {
			logger.error("Exception in inserting transaction BsnlDetails : "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			callableSt = null;
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			procedureCall = "{call [proc_kiosk](?,?)}";
			callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "selectbillsbsnl");
			//callableSt.setString(2,bill.getBillMobileNo());
			callableSt.setString(2,dbTransID );
			ResultSet rs=callableSt.executeQuery();
			if(rs.next())
			{
				Bill bill1=new Bill();
				bill1.setBillAmount(rs.getString("Amount").equals("NA")?"0":rs.getString("Amount"));
				bill1.setBillMobileNo(rs.getString("Mobile_Landline_Number"));
				bill1.setDueDate(rs.getString("Due_Date"));
				bill1.setName(rs.getString("Customer_Name"));
				bill1.setServiceProviderName(rs.getString("servicename"));
				bill1.setBillEmail(rs.getString("EmailId"));
				bill1.setTransactionId(rs.getString("TransId"));
				bill1.setCreatedDate(rs.getString("gettimestamp"));
				//bill1.setPartpaymentallow(rs.getBoolean("partpaymentallow"));
				if(rs.getInt("partpaymentallow")==1) {
					bill1.setPartpaymentallow(true);
				}else {
					bill1.setPartpaymentallow(false);
				}
				bill1.setPartpaymenttype(rs.getString("partpaymenttype"));
				bsnlBillDetails.add(bill1);
			}

		} catch (Exception e) {
			logger.error("Exception in getBsnlDetails : "+e.getMessage());
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
		return bsnlBillDetails;
	}*/

	 @Override
	    public List<Bill> getBsnlDetails(String apiResult, Bill bill) {
	        List<Bill> bsnlBillDetails = new ArrayList<Bill>();
	        String dbTransID = null;
	        try {
	            org.json.JSONObject jsonObject = new org.json.JSONObject(apiResult);
	            JSONObject fetchobj = jsonObject.getJSONObject("FetchDetails");
	            JSONObject transobj = (JSONObject) fetchobj.get("TransactionDetails");
	            JSONArray billarray = fetchobj.getJSONArray("BillDetails");

	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "transactioninsertBSNL");
	            queryDetails.addQueryParams(2, transobj.get("ServiceName").toString());
	            queryDetails.addQueryParams(3, transobj.get("officeID").toString());
	            queryDetails.addQueryParams(4, transobj.get("BillAmount").toString() == null || transobj.get("BillAmount").toString().equals("NA") ? "0" : transobj.get("BillAmount").toString());
	            queryDetails.addQueryParams(5, transobj.get("ConsumerName").toString());
	            queryDetails.addQueryParams(6, transobj.get("consumerKeysValues").toString());
	            queryDetails.addQueryParams(7, transobj.get("partPaymentAllow").toString());
	            queryDetails.addQueryParams(8, transobj.get("partPaymentType").toString());
	            queryDetails.addQueryParams(9, transobj.get("lookUpId").toString());
	            queryDetails.addQueryParams(10, transobj.get("officeCodeValue").toString());
	            queryDetails.addQueryParams(11, bill.getSsoID());
	            queryDetails.addQueryParams(12, bill.getServiceProviderID());
	            queryDetails.addQueryParams(13, bill.getBillEmail());

	            int temp = 14;
	            for (int index = 0; index < billarray.length(); index++) {
	                JSONObject jsonLineItem = billarray.getJSONObject(index);
	                String value = (String) jsonLineItem.get("LableValue");

	                if(value == null || value.equals(""))
	                	  queryDetails.addQueryParams(temp, null);
					 else
						 queryDetails.addQueryParams(temp, value);

	                temp++;
	                if (temp == 30)
	                    break;
	            }

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs1 = (org.json.JSONObject) resultSet.get(0);
	                dbTransID = rs1.optString("TransId");
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in inserting transaction BsnlDetails : ", ex);
	        }

	        try {
	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "selectbillsbsnl");
	            // callableSt.setString(2,bill.getBillMobileNo());
	            queryDetails.addQueryParams(2, dbTransID);

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();

	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
	                Bill bill1 = new Bill();
	                bill1.setBillAmount(rs.optString("Amount").equals("NA") ? "0" : rs.optString("Amount"));
	                bill1.setBillMobileNo(rs.optString("Mobile_Landline_Number"));
	                bill1.setDueDate(rs.optString("Due_Date"));
	                bill1.setName(rs.optString("Customer_Name"));
	                bill1.setServiceProviderName(rs.optString("servicename"));
	                bill1.setBillEmail(rs.optString("EmailId"));
	                bill1.setTransactionId(rs.optString("TransId"));
	                bill1.setCreatedDate(rs.optString("gettimestamp"));
	                // bill1.setPartpaymentallow(rs.getBoolean("partpaymentallow"));

	                if (rs.getInt("partpaymentallow") == 1) {
	                    bill1.setPartpaymentallow(true);
	                } else {
	                    bill1.setPartpaymentallow(false);
	                }

	                bill1.setPartpaymenttype(rs.optString("partpaymenttype"));
	                bsnlBillDetails.add(bill1);
	            }
	        } catch (Exception ex) {
	            logger.error("Exception in getBsnlDetails : ", ex);
	        }

	        return bsnlBillDetails;
	    }


	/*@Override
	public List<Phed> getPhedDetails(String apiResult, Bill bill, Phed phed)  {
		
		JSONParser parser = new JSONParser();
	    JSONObject json;
	    String dbTransID=null;
	    Connection connection = null;
	    List<Phed> details=new ArrayList<Phed>();
	    try {
			json = (JSONObject) parser.parse(apiResult);
			JSONObject fetchobj=(JSONObject)json.get("FetchDetails");
			JSONObject transobj=(JSONObject)fetchobj.get("TransactionDetails");
        	JSONArray billarray=(JSONArray)fetchobj.get("BillDetails");
        	
	        connection = jdbcTemplate.getDataSource().getConnection();
			final String procedureCall = "{call [proc_kiosk](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "transactioninsertWater");
			callableSt.setString(2, transobj.get("ServiceName").toString());
			callableSt.setString(3, transobj.get("officeID").toString());
			callableSt.setString(4,  transobj.get("BillAmount").toString());
			//callableSt.setString(5, transobj.get("ConsumerName").toString());
			String ConsumerName = transobj.get("ConsumerName").toString();
			
			
			try {
				ConsumerName = StringEscapeUtils.unescapeJava(StringEscapeUtils.unescapeHtml4(URLDecoder.decode(ConsumerName
				.replaceAll("%u","\\\\u"),"UTF-8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	
			callableSt.setString(5, ConsumerName);
			
			
			callableSt.setString(6,  transobj.get("consumerKeysValues").toString());
			callableSt.setString(7, transobj.get("partPaymentAllow").toString());
			callableSt.setString(8,  transobj.get("partPaymentType").toString());
			callableSt.setString(9,  transobj.get("lookUpId").toString());
			callableSt.setString(10,  transobj.get("officeCodeValue").toString());
			//  20 and 21
			 billarray=(JSONArray)fetchobj.get("BillDetails");
			 int temp =11;
	         for (Object o : billarray) {
	             JSONObject jsonLineItem = (JSONObject) o;
	             String value = (String)jsonLineItem.get("LableValue");
	             
	             if(value == null || value.equals(""))
	            	 callableSt.setString(temp, null);
				 else
					 callableSt.setString(temp, value);
	             
	             temp++;
	             if(temp == 26)
	            	 break;
	         }
	         callableSt.setString(26, String.valueOf(bill.getServiceProviderID()));
			callableSt.setString(27, bill.getBillEmail());
			callableSt.setString(28, bill.getBillMobileNo());
			callableSt.setString(29, bill.getBillEmail());
			callableSt.setString(30, bill.getSsoID());
			//callableSt.execute();
			ResultSet rs1=callableSt.executeQuery();
			if (rs1.next()) {
				dbTransID=rs1.getString("TransId");
			}
		//	System.out.println("K_number::"+dis1.getK_Number());
			
			Connection connection1 = null;
			connection1 = jdbcTemplate.getDataSource().getConnection();
			final String procedureCall1 = "{call [proc_kiosk](?,?)}";
			CallableStatement callableSt1 = connection1.prepareCall(procedureCall1);
			callableSt1.setString(1, "selectbillsWater");
			//callableSt1.setString(2,phed.getWbill_Number());
			callableSt1.setString(2,dbTransID);
			ResultSet rs=callableSt1.executeQuery();
			Phed ph1=null;
			if(rs.next())
			{
				ph1=new Phed();
				ph1.setEmitraCId(rs.getString("EmitraCId"));
				ph1.setSubDivision(rs.getString("SubDivision"));
				ph1.setChoukNumber(rs.getString("ChoukNumber"));
				ph1.setAccountNumber(rs.getString("AccountNumber"));
				ph1.setBillMonth(rs.getString("BillMonth"));
				ph1.setBillYear(rs.getString("BillYear"));
				ph1.setBillDate(rs.getString("BillDate"));
				ph1.setAmountBeforeDueDate(rs.getString("AmountBeforeDueDate"));
				ph1.setAmountAfterDueDate(rs.getString("AmountAfterDueDate"));
				ph1.setMobileNumber(rs.getString("MobileNumber"));
				ph1.setConsumerName(rs.getString("ConsumerName"));
				ph1.setCashDueDate(rs.getString("CashDueDate"));
				ph1.setChequeDueDate(rs.getString("ChequeDueDate"));
				ph1.setAddress(rs.getString("Address"));
				ph1.setAddress2(rs.getString("Address2"));
				ph1.setTranBillId(rs.getString("TranBillId"));
				ph1.setServiceName(rs.getString("servicename"));
				ph1.setBillAmount(rs.getString("billamount"));
				ph1.setConsumerKeyValue(rs.getString("consumerkeyvalue"));
				ph1.setPartPaymentType(rs.getString("partpaymenttype"));
				ph1.setLookUpID(rs.getString("lookupid"));
				ph1.setSsoID(rs.getString("SsoId"));
				ph1.setBillEmailId(rs.getString("EmailId"));
				ph1.setCreatedDate(rs.getString("gettimestamp"));
				details.add(ph1);
			}
			logger.info("PHED  list size :"+details.size());
	             
	    } catch (ParseException e) {
	    	logger.error("Exception in phedDetails : " + e.getMessage());
	            e.printStackTrace();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
			
		return details;	
}*/
	 
	 @Override
	    public List<Phed> getPhedDetails(String apiResult, Bill bill, Phed phed) {
	        String dbTransID = null;
	        List<Phed> details = new ArrayList<Phed>();
	        try {
	            org.json.JSONObject jsonObject = new org.json.JSONObject(apiResult);
	            JSONObject fetchobj = jsonObject.getJSONObject("FetchDetails");
	            JSONObject transobj = (JSONObject) fetchobj.get("TransactionDetails");
	            JSONArray billarray = fetchobj.getJSONArray("BillDetails");

	            QueryDetails queryDetails = new QueryDetails("proc_kiosk");

	            queryDetails.addQueryParams(1, "transactioninsertWater");
	            queryDetails.addQueryParams(2, transobj.get("ServiceName").toString());
	            queryDetails.addQueryParams(3, transobj.get("officeID").toString());
	            queryDetails.addQueryParams(4, transobj.get("BillAmount").toString());

	            // callableSt.setString(5, transobj.get("ConsumerName").toString());
	            String ConsumerName = transobj.get("ConsumerName").toString();

	            try {
	                ConsumerName = StringEscapeUtils.unescapeJava(StringEscapeUtils.unescapeHtml4(URLDecoder.decode(
	                        ConsumerName.replaceAll("%u", "\\\\u"), "UTF-8")));
	            } catch (UnsupportedEncodingException ex) {
	                ex.printStackTrace();
	            }

	            queryDetails.addQueryParams(5, ConsumerName);

	            queryDetails.addQueryParams(6, transobj.get("consumerKeysValues").toString());
	            queryDetails.addQueryParams(7, transobj.get("partPaymentAllow").toString());
	            queryDetails.addQueryParams(8, transobj.get("partPaymentType").toString());
	            queryDetails.addQueryParams(9, transobj.get("lookUpId").toString());
	            queryDetails.addQueryParams(10, transobj.get("officeCodeValue").toString());

	            // 20 and 21
	            int temp = 11;
	            for (int index = 0; index < billarray.length(); index++) {
	                JSONObject jsonLineItem = billarray.getJSONObject(index);
	                String value = (String) jsonLineItem.get("LableValue");

	                if(value == null || value.equals(""))
	                	  queryDetails.addQueryParams(temp, null);
					 else
						 queryDetails.addQueryParams(temp, value);
		             
	                temp++;
	                if (temp == 26) {
	                    break;
	                }
	            }

	            queryDetails.addQueryParams(26, String.valueOf(bill.getServiceProviderID()));
	            queryDetails.addQueryParams(27, bill.getBillEmail());
	            queryDetails.addQueryParams(28, bill.getBillMobileNo());
	            queryDetails.addQueryParams(29, bill.getBillEmail());
	            queryDetails.addQueryParams(30, bill.getSsoID());

	            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
	            JSONArray resultSet = serviceResponse.getJsonArray();
	            if (null != resultSet && resultSet.length() > 0) {
	                org.json.JSONObject rs1 = (org.json.JSONObject) resultSet.get(0);
	                dbTransID = rs1.optString("TransId");
	            }

	            QueryDetails queryDetails1 = new QueryDetails("proc_kiosk");

	            queryDetails1.addQueryParams(1, "selectbillsWater");
	            // callableSt1.setString(2,phed.getWbill_Number());
	            queryDetails1.addQueryParams(2, dbTransID);
	            Phed ph1 = null;
	            DBServiceResponse serviceResponse1 = dbHTTPUtils.pullDataFromDBApiServer(queryDetails1);
	            JSONArray resultSet1 = serviceResponse1.getJsonArray();
	            if (null != resultSet1 && resultSet1.length() > 0) {
	                org.json.JSONObject rs = (org.json.JSONObject) resultSet1.get(0);
	                ph1 = new Phed();
	                ph1.setEmitraCId(rs.optString("EmitraCId"));
	                ph1.setSubDivision(rs.optString("SubDivision"));
	                ph1.setChoukNumber(rs.optString("ChoukNumber"));
	                ph1.setAccountNumber(rs.optString("AccountNumber"));
	                ph1.setBillMonth(rs.optString("BillMonth"));
	                ph1.setBillYear(rs.optString("BillYear"));
	                ph1.setBillDate(rs.optString("BillDate"));
	                ph1.setAmountBeforeDueDate(rs.optString("AmountBeforeDueDate"));
	                ph1.setAmountAfterDueDate(rs.optString("AmountAfterDueDate"));
	                ph1.setMobileNumber(rs.optString("MobileNumber"));
	                ph1.setConsumerName(rs.optString("ConsumerName"));
	                ph1.setCashDueDate(rs.optString("CashDueDate"));
	                ph1.setChequeDueDate(rs.optString("ChequeDueDate"));
	                ph1.setAddress(rs.optString("Address"));
	                ph1.setAddress2(rs.optString("Address2"));
	                ph1.setTranBillId(rs.optString("TranBillId"));
	                ph1.setServiceName(rs.optString("servicename"));
	                ph1.setBillAmount(rs.optString("billamount"));
	                ph1.setConsumerKeyValue(rs.optString("consumerkeyvalue"));
	                ph1.setPartPaymentType(rs.optString("partpaymenttype"));
	                ph1.setLookUpID(rs.optString("lookupid"));
	                ph1.setSsoID(rs.optString("SsoId"));
	                ph1.setBillEmailId(rs.optString("EmailId"));
	                ph1.setCreatedDate(rs.optString("gettimestamp"));
	                details.add(ph1);
	            }
	            logger.info("PHED  list size :" + details.size());
	        } catch (Exception ex) {
	            logger.error("Exception in phedDetails : " + ex.getMessage());
	        }

	        return details;
	    }


}

