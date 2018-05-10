package service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import UidotpAuthentication.AadharServices;
import UidotpAuthentication.BhamashahServices;
import UidotpAuthentication.MobileOTP;
import dao.BhamashahCardDao;
import model.Login;

@Service("bhamashahCardService")
public class BhamashahCardServiceImpl implements BhamashahCardService {
	
	@Value("${CLIENTID_Uid_Production}")
	private static  String CLIENTID_Uid_Production;
	
	@Value("${CLIENTID_EMITRA_ID_Production}")
	private static  String CLIENTID_EMITRA_ID_Production;
	
	@Value("${URL_OTP_GENERATION}")
	private static  String URL_OTP_GENERATION;
	
	@Value("${URL_OTP_AUTHENTICATION}")
	private static  String URL_OTP_AUTHENTICATION;
	
	@Value("${URL_BHAMASHAH_GETDETAILS_PRODUCTION}")
	private static  String URL_BHAMASHAH_GETDETAILS_PRODUCTION;
	
	@Value("${URL_BHAMASHAH_MOBACC_NO_UPDATE_PRODUCTION}")
	private static  String URL_BHAMASHAH_MOBACC_NO_UPDATE_PRODUCTION;
	
	
	@Autowired
	BhamashahCardDao bhamashahCardDao;
    
	private static final String CLIENTID_UID_PROD = CLIENTID_Uid_Production; // PROD
	private static final String CLIENTID_EMITRA_ID_PROD = CLIENTID_EMITRA_ID_Production; // PROD
	
	private static final String URL_OTP_GEN = URL_OTP_GENERATION+CLIENTID_UID_PROD; // PROD
	private static final String URL_OTP_AUTH = URL_OTP_AUTHENTICATION+CLIENTID_UID_PROD; // PROD
	private static final String URL_BHAMASHAH_GETDETAILS_PROD = URL_BHAMASHAH_GETDETAILS_PRODUCTION;	// PROD
	private static final String URL_BHAMASHAH_MOBACC_NO_UPDATE_PROD = URL_BHAMASHAH_MOBACC_NO_UPDATE_PRODUCTION;// PRO
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject uidOtpGeneration(String uid, String modeOfPage) {
		// TODO Auto-generated method stub
		JSONObject responseObject = new JSONObject();
		AadharServices aadharServices = new AadharServices();
		Map<String , Object> dataMap = aadharServices.aadharOtpGeneration(uid, URL_OTP_GEN);
		String message = null;
		if(dataMap != null && !dataMap.isEmpty()) {
			if(String.valueOf(dataMap.get("status")).equalsIgnoreCase("y")) {
				responseObject.put("txnId", dataMap.get("txnId"));
				message = "";
			}else if(String.valueOf(dataMap.get("status")).equalsIgnoreCase("0")) {
				
				if(modeOfPage.equalsIgnoreCase("ENG")) {
					message = "There's an internal error occur in server, please try again after some time.";
				}else if(modeOfPage.equalsIgnoreCase("HND")) {
					message = "सर्वर में एक आंतरिक त्रुटि हुई है, कृपया कुछ समय बाद पुनः प्रयास करें।";
				}
			}else {
				responseObject.put("txnId", dataMap.get("txnId"));
				String errorCode = String.valueOf(dataMap.get("error"));
				if (errorCode.equalsIgnoreCase("997")) {
					
					if(modeOfPage.equalsIgnoreCase("ENG")) {
						message = "The aadhar number status is not valid.";
					}else if(modeOfPage.equalsIgnoreCase("HND")) {
						message = "आधार संख्या एक मान्य स्थिति में नहीं है।";
					}
					
				}else if (errorCode.equalsIgnoreCase("998")) {
					if(modeOfPage.equalsIgnoreCase("ENG")) {
						message = "Invalid Aadhar Number.";
					}else if(modeOfPage.equalsIgnoreCase("HND")) {
						message = "अवैध आधार संख्या।";
					}
				
				}else {
					if(modeOfPage.equalsIgnoreCase("ENG")) {
						message = "There's an internal error occur in server, please try again after some time.";
					}else if(modeOfPage.equalsIgnoreCase("HND")) {
						message = "सर्वर में एक आंतरिक त्रुटि हुई है, कृपया कुछ समय बाद पुनः प्रयास करें।";
					}
				}
			}
			responseObject.put("message", message);
			responseObject.put("status", String.valueOf(dataMap.get("status")));
			
		}else {
			if(modeOfPage.equalsIgnoreCase("ENG")) {
				message = "There's an internal error occur in server, please try again after some time.";
			}else if(modeOfPage.equalsIgnoreCase("HND")) {
				message = "सर्वर में एक आंतरिक त्रुटि हुई है, कृपया कुछ समय बाद पुनः प्रयास करें।";
			}
			responseObject.put("message", message);
			responseObject.put("status", "n");
		}
		return responseObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject uidOtpAuth(HttpServletRequest request , JSONObject serviceDataJson) {
		// TODO Auto-generated method stub
		JSONObject responseObject = new JSONObject();
		AadharServices aadharServices = new AadharServices();
		String webPath = request.getSession().getServletContext().getRealPath("/uidResource/");
		webPath = webPath.replace("\\", File.separator);
		
		String aadharId = String.valueOf(serviceDataJson.get("aadharId"));
        String txnId = String.valueOf(serviceDataJson.get("txnId"));
        String aadharOtp = String.valueOf(serviceDataJson.get("aadharOtp"));
        String modeOfPage = String.valueOf(serviceDataJson.get("modeOfPage"));
		String docXml = aadharServices.getXmlForAadharOtpAuthSimple(aadharId , txnId , aadharOtp , webPath);
		JSONObject jsonMemberDetails = aadharServices.getResponseStringForAadhar(docXml , URL_OTP_AUTH);
		
		if(jsonMemberDetails != null && !jsonMemberDetails.isEmpty()) {
			if(jsonMemberDetails.containsKey("Status") && ((String)jsonMemberDetails.get("Status")).equals("0")) {
				responseObject.put("status", 111);
				if(modeOfPage.equalsIgnoreCase("ENG")) {
					responseObject.put("msg", "There's an internal error occur in server, please try again after some time.");
				}else if(modeOfPage.equalsIgnoreCase("HND")) {
					responseObject.put("msg", "सर्वर में एक आंतरिक त्रुटि हुई है, कृपया कुछ समय बाद पुनः प्रयास करें।");
				}
				return responseObject;
			}else {
				String otpAuthStatus = (String) ((JSONObject)((JSONObject)jsonMemberDetails.get("authresponse")).get("auth")).get("status");
				if(otpAuthStatus != null && otpAuthStatus.equalsIgnoreCase("y")) {
					//save entry into database.
					//use txnId as Authentication txnId
//					aadharId = "760581847244";//for temporary purpose
//					serviceDataJson.put("aadharId", aadharId);//for temporary purpose
					String requestId = bhamashahCardDao.insertUidAuthDetails(serviceDataJson);
					BhamashahServices bhamashahServices = new BhamashahServices();
					String urlBhamashahGetDetails = URL_BHAMASHAH_GETDETAILS_PROD + aadharId + "?client_id=" + CLIENTID_EMITRA_ID_PROD;
					JSONObject dataJSON = bhamashahServices.getBhamashahDetails(modeOfPage , urlBhamashahGetDetails , "GET");
					if(dataJSON != null && !dataJSON.isEmpty()) {
						
						if(dataJSON.containsKey("STATUS")) {
							responseObject.put("status", 112);
							if(modeOfPage.equalsIgnoreCase("ENG")) {
								responseObject.put("msg", "Details of the Bhamashah family for the Aadhaar number are not present.");
							}else if(modeOfPage.equalsIgnoreCase("HND")) {
								responseObject.put("msg", "दिए गए आधार संख्या के लिए भामाशाह परिवार का विवरण मौजूद नहीं है।");
							}
							return responseObject;
							
						}else{
							dataJSON.put("status", 200);
							dataJSON.put("requestId", requestId);
//							dataJSON.put("aadharId", aadharId);//for temporary purpose
							return dataJSON;
						}
					}else {
						System.out.println("Details of Bhamashah family were not fetched successfully.");
						responseObject.put("status", 111);
						if(modeOfPage.equalsIgnoreCase("ENG")) {
							responseObject.put("msg", "Details of Bhamashah family were not fetched successfully.");
						}else if(modeOfPage.equalsIgnoreCase("HND")) {
							responseObject.put("msg", "भामाशाह परिवार का विवरण सफलतापूर्वक नहीं मिला।");
						}
						return responseObject;
					}
				}else {
					System.out.println("OTP Authentication is not successful!");
					responseObject.put("status", 111);
					if(modeOfPage.equalsIgnoreCase("ENG")) {
						responseObject.put("msg", "OTP Authentication is not successful.");
					}else if(modeOfPage.equalsIgnoreCase("HND")) {
						responseObject.put("msg", "ओटीपी सत्यापन सफल नहीं है।");
					}
					return responseObject;
				}
			}
		}else {
			System.out.println("There's an internal error occur in server, please try again after some time.");
			responseObject.put("status", 111);
			if(modeOfPage.equalsIgnoreCase("ENG")) {
				responseObject.put("msg", "There's an internal error occur in server, please try again after some time.");
			}else if(modeOfPage.equalsIgnoreCase("HND")) {
				responseObject.put("msg", "सर्वर में एक आंतरिक त्रुटि हुई है, कृपया कुछ समय बाद पुनः प्रयास करें।");
			}
			return responseObject;
		}
	}

	@Override
	public JSONObject getOtpForMobileVerify(String mobileNo , String txnId) {
		// TODO Auto-generated method stub
		
		MobileOTP mobileOTP = new MobileOTP();
		JSONObject responseObj = mobileOTP.sendMessageOnMobile(mobileNo);
		if(responseObj != null && !responseObj.isEmpty()) {
			bhamashahCardDao.insertEntryIntoLog(responseObj);
		}
		return responseObj;
	}
	
	@Override
	public JSONObject getIFSCDetails(String ifscCode) {
		// TODO Auto-generated method stub
		return bhamashahCardDao.getIFSCDetails(ifscCode);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public JSONObject updateMobileAccountNumber(String transId , String updateCount , String languageCode) {
		// TODO Auto-generated method stub
		JSONObject response = new JSONObject();
		try{
			String message = null;
			org.json.JSONObject statusOfTransaction = bhamashahCardDao.getUpdateDetails(transId , "bhamashahselectstatus");
			if(statusOfTransaction != null && statusOfTransaction.length() != 0) {
				String status = String.valueOf(statusOfTransaction.get("TRANSACTIONSTATUS"));
				if(status.equalsIgnoreCase("FAILURE")) {
					String aadharNo = String.valueOf(statusOfTransaction.get("UID"));
					String langCode = String.valueOf(statusOfTransaction.get("LangCode"));
					
					if(langCode.equalsIgnoreCase("ENG")) {
						response.put("message", "Transaction has been cancelled.");
					}else if(langCode.equalsIgnoreCase("HND")) {
						response.put("message", "लेनदेन रद्द कर दिया गया है।");
					}
					response.put("aadharNo", aadharNo);
					response.put("langCode", langCode);
					response.put("VERIFY_STATUS", "F");
					response.put("statusOfTransaction", statusOfTransaction);
				
				}else {
				
					org.json.JSONObject rowData = bhamashahCardDao.getUpdateDetails(transId , "bhamashahselect");
					
					String aadharNo = String.valueOf(rowData.get("UID"));
					String bhamashahId = String.valueOf(rowData.get("Bhamashah_Number"));
					String memberId = String.valueOf(rowData.get("Member_id"));
					String memberType = String.valueOf(rowData.get("Member_type"));
					String mobileNumber = String.valueOf(rowData.get("Mobile_No"));
					String acocuntNumber = String.valueOf(rowData.get("Bank_Account_No"));
					String ifscCode = String.valueOf(rowData.get("Bank_Ifsc_Code"));
					String userId = String.valueOf(Login.SSOID);
					String updateFlag = String.valueOf(rowData.get("Update_Flag"));
					String langCode = String.valueOf(rowData.get("LangCode"));
					
					String requestUrl = URL_BHAMASHAH_MOBACC_NO_UPDATE_PROD + bhamashahId + "/" + memberId + "/" + memberType + "/" + updateFlag + "/";
					
					if(updateFlag.equalsIgnoreCase("M")) {
						
						requestUrl += mobileNumber + "/0/0/";
						
					}else if(updateFlag.equalsIgnoreCase("A")) {
						
						requestUrl += "0/" + acocuntNumber + "/" + ifscCode + "/";
					}
					requestUrl +=  userId + "?client_id="+ CLIENTID_EMITRA_ID_PROD;
					
					int i = 0;
					BhamashahServices bhamashahServices = new BhamashahServices(requestUrl , "POST");
					JSONObject responseObj = new JSONObject();
					try {
						while (bhamashahServices.mythread.isAlive()) {
							if (i < 3) {
								if (bhamashahServices.dataJSON != null && !bhamashahServices.dataJSON.isEmpty()) {
									break;
								}
								Thread.sleep(10000);
								i++;
							}else {
								break;
							}
						}
						bhamashahServices.mythread.interrupt();

					} catch (InterruptedException e) {
						System.out.println("Main thread interrupted");
					}
					
					responseObj = bhamashahServices.dataJSON;
					
					String statusUpdate = "F";
					if(responseObj != null && !responseObj.isEmpty()) {
						String status_value[] = String.valueOf(responseObj.get("status")).split(",");
						if(status_value[0].equalsIgnoreCase("SUCESS")) {
							statusUpdate = "V";
						}
						if(status_value[0].equalsIgnoreCase("FAILED")) {
							statusUpdate = "F";
						}
						if(status_value[0].equalsIgnoreCase("DUPLICATE")) {
							statusUpdate = "D";
						}
					}else {
						statusUpdate = "N";
					}
					
					if(statusUpdate.equalsIgnoreCase("V")) {
						if(updateFlag.equalsIgnoreCase("M")) {
							if(langCode.equalsIgnoreCase("ENG")) {
								message = "Mobile Number has been updated.";
							}else if(langCode.equalsIgnoreCase("HND")) {
								message = "मोबाइल नंबर को अपडेट किया गया है।";
							}
						}else if(updateFlag.equalsIgnoreCase("A")) {
							if(langCode.equalsIgnoreCase("ENG")) {
								message = "Account Number has been updated.";
							}else if(langCode.equalsIgnoreCase("HND")) {
								message = "खाता नंबर अपडेट किया गया है।";
							}
						}
					}else if(statusUpdate.equalsIgnoreCase("F")) {
						if(updateFlag.equalsIgnoreCase("M")) {
							if(langCode.equalsIgnoreCase("ENG")) {
								message = "Mobile Number has not been updated. Your transaction will be cancelled soon.";
							}else if(langCode.equalsIgnoreCase("HND")) {
								message = "मोबाइल नंबर अपडेट नहीं किया गया है। आपका लेनदेन जल्द ही रद्द कर दिया जाएगा।";
							}
						}else if(updateFlag.equalsIgnoreCase("A")) {
							if(langCode.equalsIgnoreCase("ENG")) {
								message = "Account Number has not been updated. Your transaction will be cancelled soon.";
							}else if(langCode.equalsIgnoreCase("HND")) {
								message = "खाता नंबर अपडेट नहीं किया गया है। आपका लेनदेन जल्द ही रद्द कर दिया जाएगा।";
							}
						}
					}else if(statusUpdate.equalsIgnoreCase("D")) {
						if(updateCount.equals("1")) {
							if(updateFlag.equalsIgnoreCase("M")) {
								if(langCode.equalsIgnoreCase("ENG")) {
									message = "The mobile number, you are trying to update, already exists. Your transaction will be cancelled soon.";
								}else if(langCode.equalsIgnoreCase("HND")) {
									message = "जिस मोबाइल नंबर को आप अपडेट करने का प्रयास कर रहे हैं, वह पहले से मौजूद है। आपका लेनदेन जल्द ही रद्द कर दिया जाएगा।";
								}
							}else if(updateFlag.equalsIgnoreCase("A")) {
								if(langCode.equalsIgnoreCase("ENG")) {
									message = "The account number, you are trying to update, already exists. Your transaction will be cancelled soon.";
								}else if(langCode.equalsIgnoreCase("HND")) {
									message = "खाता नंबर जिसे आप अपडेट करने का प्रयास कर रहे हैं, पहले से मौजूद है। आपका लेनदेन जल्द ही रद्द कर दिया जाएगा।";
								}
							}
						}else if(updateCount.equals("2")) {
							if(updateFlag.equalsIgnoreCase("M")) {
								if(langCode.equalsIgnoreCase("ENG")) {
									message = "Mobile Number has been updated.";
								}else if(langCode.equalsIgnoreCase("HND")) {
									message = "मोबाइल नंबर को अपडेट किया गया है।";
								}
							}else if(updateFlag.equalsIgnoreCase("A")) {
								if(langCode.equalsIgnoreCase("ENG")) {
									message = "Account Number has been updated.";
								}else if(langCode.equalsIgnoreCase("HND")) {
									message = "खाता नंबर अपडेट किया गया है।";
								}
							}
						}
					}else if(statusUpdate.equalsIgnoreCase("N")) {
						if(updateCount.equals("1")) {
							if(langCode.equalsIgnoreCase("ENG")) {
								message = "There's a problem in network, please try again by clicking on \"TRY AGAIN\" button.";
							}else if(langCode.equalsIgnoreCase("HND")) {
								message = "नेटवर्क में कोई समस्या है, कृपया \"फिर कोशिश करें \" बटन पर क्लिक करके पुनः प्रयास करें।";
							}
						}else if(updateCount.equals("2")) {
							if(langCode.equalsIgnoreCase("ENG")) {
								message = "Due to some technical issue, your number will be updated within 24 hours.";
							}else if(langCode.equalsIgnoreCase("HND")) {
								message = "कुछ तकनीकी समस्या के कारण, आपका नंबर 24 घंटों के भीतर अपडेट हो जाएगा।";
							}
						}
					}
					
					response.put("message", message);
					response.put("aadharNo", aadharNo);
					response.put("langCode", langCode);
					response.put("VERIFY_STATUS", statusUpdate);
					response.put("statusOfTransaction", statusOfTransaction);
				}
			}else {
				if(languageCode.equalsIgnoreCase("0")) {
					message = "There's a problem in network, please try again by clicking on \"TRY AGAIN\" button.";
				}else if(languageCode.equalsIgnoreCase("1")) {
					message = "नेटवर्क में कोई समस्या है, कृपया \"फिर कोशिश करें \" बटन पर क्लिक करके पुनः प्रयास करें।";
				}
				response.put("message", message);
				response.put("VERIFY_STATUS", "N");
				response.put("aadharNo", "");
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public String updateBhamashahPaymentDetails(HttpServletRequest request , JSONObject data) {
		// TODO Auto-generated method stub
		
		String transId = bhamashahCardDao.updateBhamashahPaymentDetails(request , data);
		
		return transId;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject statusForUpdateNumber(JSONObject memberData, String updateFlag) {
		// TODO Auto-generated method stub
		
		BhamashahServices bhamashahServices = new BhamashahServices();
		String bhamashahId = String.valueOf(memberData.get("BHAMASHAH_ID"));
		String memberId = String.valueOf(memberData.get("M_ID"));
		String memberType = String.valueOf(memberData.get("MEMBER_TYPE"));
		String mobileNumber = String.valueOf(memberData.get("MOBILE_NO"));
		String acocuntNumber = String.valueOf(memberData.get("ACCOUNT_NUMBER"));
		String ifscCode = String.valueOf(memberData.get("IFSC_CODE"));
		String userId = String.valueOf(Login.SSOID);
		
		String requestUrl = URL_BHAMASHAH_MOBACC_NO_UPDATE_PROD + bhamashahId + "/" + memberId + "/" + memberType + "/" + updateFlag + "/";
		
		if(updateFlag.equalsIgnoreCase("MV")) {
			
			requestUrl += mobileNumber + "/0/0/";
			
		}else if(updateFlag.equalsIgnoreCase("AV")) {
			
			requestUrl += "0/" + acocuntNumber + "/" + ifscCode + "/";
		}
		requestUrl +=  userId + "?client_id="+ CLIENTID_EMITRA_ID_PROD;
		
		JSONObject responseObj = bhamashahServices.updateMobileOrBnkAcc(requestUrl , "POST");
		
		String updateStatus = "F";
		JSONObject resObj = new JSONObject();
		if(responseObj != null && !responseObj.isEmpty()) {
			String status[] = String.valueOf(responseObj.get("status")).split(",");
			if(status[0].equalsIgnoreCase("SUCESS"))
				updateStatus = "V";
			if(status[0].equalsIgnoreCase("FAILED"))
				updateStatus = "F";
			if(status[0].equalsIgnoreCase("DUPLICATE")) {
				updateStatus = "D";
				resObj .put("BHAMASHAH_ID", bhamashahServices.numberMasking(status[1]));
			}
			if(status[0].equalsIgnoreCase("null"))
				updateStatus = "N";
		}
		
		resObj.put("status", updateStatus);
		return resObj;
	}

	@Override
	public String convertDate(String date) {
		// TODO Auto-generated method stub
		String convertedDate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(date));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			convertedDate = sdf.format(cal.getTime());
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return convertedDate;
	}

	@Override
	public void updateBhamashahStatus(String transId, String status) {
		// TODO Auto-generated method stub
		bhamashahCardDao.updateBhamashahStatus(transId , status);
	}
}
