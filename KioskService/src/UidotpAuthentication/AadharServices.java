package UidotpAuthentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.json.XML;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("deprecation")
public class AadharServices {

	private static final String SUBAUA = "STGDOIT028";
//    private static final String LICENCEKEY = "MEb05gqt5du2fk3enCvMrd6wkP6nVrHa4YEX6kRNJG5rsbaozzwh3Q0"; // PRE-PRODUCTION
    private static final String LICENCEKEY = "MF6rQo0E-mKDJolSKZtiirpopoXTjlxMg7ya93V6hMCZz60_9oT4lrk"; // PRODUCTION
//    private static final String MACADD = "74-27-EA-BE-57-0E"; // PRE-PRODUCTION OR PRODUCTION
    
	public Map<String, Object> aadharOtpGeneration(String aadharId , String requestUrl) {
		// TODO Auto-generated method stub
		
		String docXml = getXmlForAadharOtpGen(String.valueOf(aadharId));
		
		JSONObject jsonOtpGen = getResponseStringForAadhar(docXml , requestUrl);
    	String txnId = null;
    	Map<String , Object> map = new HashMap<String, Object>();
		if(jsonOtpGen != null && !jsonOtpGen.isEmpty()) {
			if(jsonOtpGen.containsKey("Status") && ((String)jsonOtpGen.get("Status")).equals("0")) {
				map.put("status", ((String)jsonOtpGen.get("Status")));
				map.put("message", ((String)jsonOtpGen.get("Message")));
				map.put("txnId", ((String)jsonOtpGen.get("ResponseCode")));
				map.put("error", "000");
			}else {
				String status = String.valueOf(((JSONObject)jsonOtpGen.get("authresponse")).get("status"));
				if(status.equals("200")) {
					String authStatus = (String) ((JSONObject)((JSONObject)jsonOtpGen.get("authresponse")).get("auth")).get("status");
					txnId = (String) ((JSONObject)((JSONObject)jsonOtpGen.get("authresponse")).get("auth")).get("txn");
					if(authStatus.equals("y")) {
						map.put("txnId", txnId);
						map.put("status", authStatus);
					}else {
						map.put("txnId", txnId);
						map.put("status", authStatus);
						map.put("message", String.valueOf(((JSONObject)jsonOtpGen.get("authresponse")).get("message")));
						map.put("error", String.valueOf(((JSONObject)jsonOtpGen.get("authresponse")).get("error")));
					}
				}
			}
		}
		return map;
	}
	
	public String getXmlForAadharOtpGen(String aadharNo) {
		Document doc = null;
		String output = null;
		try {
	         DocumentBuilderFactory dbFactory =
	         DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         doc = dBuilder.newDocument();
	         
	         // authrequest element
	         Element authrequest = doc.createElement("authrequest");
	         authrequest.setAttribute("uid", aadharNo);
	         authrequest.setAttribute("tid", "public");
	         authrequest.setAttribute("subaua", SUBAUA);
	         authrequest.setAttribute("appname", "Emitra+Bonafide");
	         authrequest.setAttribute("udc", "test123");
	         authrequest.setAttribute("lk", LICENCEKEY);
	         authrequest.setAttribute("rc", "Y");
	         authrequest.setAttribute("ip", "NA");
	         authrequest.setAttribute("fdc", "NA");
	         authrequest.setAttribute("idc", "NA");
	         authrequest.setAttribute("macadd", "");
	         authrequest.setAttribute("lot", "P");
	         authrequest.setAttribute("lov", "110002");
	         doc.appendChild(authrequest);

	         //otp Element
	         Element otp = doc.createElement("otp");
	         otp.setAttribute("channel", "00");
	         authrequest.appendChild(otp);
	         
	         output = getStringFromXml(doc);;
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return output;
	}
	
	@SuppressWarnings({ "resource", "unchecked" })
	public JSONObject getResponseStringForAadhar(String docXml, String requestUrl) {
		// TODO Auto-generated method stub
		int PRETTY_PRINT_INDENT_FACTOR = 4;
		JSONObject json = new JSONObject();
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(requestUrl);
			StringBuilder res = new StringBuilder();
			if (docXml != null) {
				StringEntity input = new StringEntity(docXml);
				post.setEntity((HttpEntity) input);
				post.setHeader("Content-Type", "application/xml");
				HttpResponse resp = client.execute((HttpUriRequest) post);
				BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
				String line = "";
				while ((line = rd.readLine()) != null) {
					res.append(line);
				}
			}
			String TEST_XML_STRING = res.toString();
			org.json.JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
			String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			JSONParser parser = new JSONParser();
			json = (JSONObject) parser.parse(jsonPrettyPrintString);
		
		} catch (Exception e) {
			json.put("Status", "0");
			json.put("ResponseCode", "ES-213");
			json.put("Message", "Problem in the server ,Please try again!");
		}
		return json;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject setMemberDataForAadhar(JSONObject dataObjMembers , String modeOfPage) {
		// TODO Auto-generated method stub
		JSONObject uidMemberObj = new JSONObject();
		if(dataObjMembers != null && !dataObjMembers.isEmpty()) {
			String otpAuthStatus = (String) ((JSONObject)((JSONObject)dataObjMembers.get("authresponse")).get("auth")).get("status");
			if(otpAuthStatus != null && otpAuthStatus.equalsIgnoreCase("y")) {
				JSONObject uidData = (JSONObject)((JSONObject)dataObjMembers.get("authresponse")).get("UidData");
				JSONObject pa = (JSONObject) uidData.get("pa");
				JSONObject pi = (JSONObject) uidData.get("pi");
				
				if(((String) pi.get("gender")).equalsIgnoreCase("M")) {
					if(modeOfPage.equals("ENG")) {
						uidMemberObj.put("titletyp","Mr");
						uidMemberObj.put("relationtyp","Father");
					}else if(modeOfPage.equals("HND")) {
						uidMemberObj.put("titletyp","श्री");
						uidMemberObj.put("relationtyp","पिता");
					}
					String fName = String.valueOf(pa.get("co"));
					if(fName.contains("S/O")) {
						String regex = "\\s*\\bS/O\\b\\s*";
						fName = fName.replaceAll(regex, "");
					}
					uidMemberObj.put("fathersNameEform",  String.valueOf(fName));
					uidMemberObj.put("husMarrigeDetail1", "");
				}else if(((String) pi.get("gender")).equalsIgnoreCase("F")) {
					
					String relativeName = String.valueOf(pa.get("co"));
					if(relativeName.contains("D/O")) {
						String regex = "\\s*\\bD/O\\b\\s*";
						relativeName = relativeName.replaceAll(regex, "");
						
						if(modeOfPage.equals("ENG")) {
							uidMemberObj.put("titletyp","Ms");
							uidMemberObj.put("relationtyp","Father");
							uidMemberObj.put("isMarried","No");
						}else if(modeOfPage.equals("HND")) {
							uidMemberObj.put("titletyp","सुश्री");
							uidMemberObj.put("relationtyp","पिता");
							uidMemberObj.put("isMarried","नही");
						}
						uidMemberObj.put("husMarrigeDetail1", "");
					}else if(relativeName.contains("W/O")) {
						String regex = "\\s*\\bW/O\\b\\s*";
						relativeName = relativeName.replaceAll(regex, "");
						
						if(modeOfPage.equals("ENG")) {
							uidMemberObj.put("titletyp","Mrs");
							uidMemberObj.put("relationtyp","Husband");
							uidMemberObj.put("isMarried","Yes");
						}else if(modeOfPage.equals("HND")) {
							uidMemberObj.put("titletyp","श्रीमती");
							uidMemberObj.put("relationtyp","पति");
							uidMemberObj.put("isMarried","हां");
						}
						uidMemberObj.put("husMarrigeDetail1",  String.valueOf(relativeName));
					}
					uidMemberObj.put("fathersNameEform", String.valueOf(relativeName));
				}
				uidMemberObj.put("applicantName", pi.get("name"));
				uidMemberObj.put("profileDob", pi.get("dob"));
				uidMemberObj.put("profileEmail", pi.get("email"));
				uidMemberObj.put("profileMobile", pi.get("dist"));
				uidMemberObj.put("profileAadharId", String.valueOf(uidData.get("uid")));
				String house = String.valueOf(pa.get("house"));
				String street = String.valueOf(pa.get("street"));
				String vtc = String.valueOf(pa.get("vtc"));
				String loc = String.valueOf(pa.get("loc"));
				String dist = String.valueOf(pa.get("dist"));
				String state = String.valueOf(pa.get("state"));
				String pc = String.valueOf(pa.get("pc"));
				String addEng = house +", "+ street +", "+ vtc +", "+ loc +", "+ dist +", "+ state +".("+ pc+")";
				uidMemberObj.put("permAddressInEngText", addEng);
				uidMemberObj.put("permAddressCountryIdtext", String.valueOf("India"));
				uidMemberObj.put("permAddressStateIdtext", state);
				uidMemberObj.put("permAddressDistrictIdtext", dist);
				uidMemberObj.put("permAddressDivisionIdtext", String.valueOf(""));
				uidMemberObj.put("permAddressTehsilIdtext", String.valueOf(""));
				uidMemberObj.put("permAddressMunicipalityIdtext", String.valueOf(""));
				uidMemberObj.put("permAddressWardIdtext", String.valueOf(""));
				uidMemberObj.put("permAddressPanchayatSamityIdtext", String.valueOf(""));
				uidMemberObj.put("permAddressGramPanchayatIdtext", String.valueOf(""));
				uidMemberObj.put("permAddressVillageIdtext", vtc);
				uidMemberObj.put("permAddressAddPinCodetext", pc);
				uidMemberObj.put("fromYearInRaj", String.valueOf(""));
				if(uidData.get("pht") != null && !uidData.get("pht").equals("")) {
					uidMemberObj.put("memberImage", "data:image/jpeg;base64,"+String.valueOf(uidData.get("pht")));
				}else {
					uidMemberObj.put("memberImage", "uidResource/person_6x8.png");
				}
			}
		}
		return uidMemberObj;
	}

	public String getXmlForAadharOtpAuthEkyc(String aadharNo , String txnId , String otp , String webPath) {
		String output = null;
		Document doc = null;
		try {
	         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	         String timeStamp = simpleDateFormat.format(new Date()).replace(" ","T");
	            
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         doc = dBuilder.newDocument();
	         
	         // authrequest element
	         Element authrequest1 = doc.createElement("authrequest");
	         authrequest1.setAttribute("uid", aadharNo);
	         authrequest1.setAttribute("tid", "");
	         authrequest1.setAttribute("subaua", SUBAUA);
	         authrequest1.setAttribute("appname", "Emitra+Bonafide");
	         authrequest1.setAttribute("udc", "test123");
	         authrequest1.setAttribute("lk", LICENCEKEY);
	         authrequest1.setAttribute("ra", "O");
	         authrequest1.setAttribute("rc", "Y");
	         authrequest1.setAttribute("de", "N");
	         authrequest1.setAttribute("lr", "N");
	         authrequest1.setAttribute("ts", timeStamp);
	         authrequest1.setAttribute("pfr", "N");
	         authrequest1.setAttribute("mec", "Y");
	         authrequest1.setAttribute("ver", "2.1");
	         authrequest1.setAttribute("txn", txnId);
	         authrequest1.setAttribute("dpID", "");
	         authrequest1.setAttribute("rdsID", "");
	         authrequest1.setAttribute("rdsVer", "");
	         authrequest1.setAttribute("dc", "");
	         authrequest1.setAttribute("mi", "");
	         authrequest1.setAttribute("mc", "");
	         authrequest1.setAttribute("deviceSrNO", "NA");
	         authrequest1.setAttribute("deviceError", "NA");
	         authrequest1.setAttribute("ip", "NA");
	         authrequest1.setAttribute("fdc", "NA");
	         authrequest1.setAttribute("idc", "NA");
	         authrequest1.setAttribute("macadd", "");
	         authrequest1.setAttribute("lot", "P");
	         authrequest1.setAttribute("lov", "110002");
	         authrequest1.setAttribute("bt", "OTP");
	         doc.appendChild(authrequest1);

	         //Pid Element
	         Element pid1 = doc.createElement("Pid");
	         pid1.setAttribute("ts", timeStamp);
	         pid1.setAttribute("ver", "2.0");
	         pid1.setAttribute("wadh", "v+MrMc87OfdpEanJHoImMzM7GVlqxMf5iJ8JGkafTas=");
	         
	         //Demo Element
	         Element Demo = doc.createElement("Demo");
	         Demo.setAttribute("lang", "06");
	         pid1.appendChild(Demo);
	         
	         //Pv Element
	         Element Pv = doc.createElement("Pv");
	         Pv.setAttribute("otp", otp);
	         pid1.appendChild(Pv);
	         
	         authrequest1 = prepareAuthRequestBio(pid1, authrequest1 , timeStamp , doc , webPath);
	         
	         output = getStringFromXml(doc);
		      
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return output;
	}
	
	public String getXmlForAadharOtpAuthSimple(String aadharNo , String txnId , String otp , String webPath) {
		String output = null;
		Document doc = null;
		try {
	         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	         String timeStamp = simpleDateFormat.format(new Date()).replace(" ","T");
	            
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         doc = dBuilder.newDocument();
	         
	         // authrequest element
	         Element authrequest = doc.createElement("authrequest");
	         authrequest.setAttribute("uid", aadharNo);
	         authrequest.setAttribute("tid", "");
	         authrequest.setAttribute("subaua", SUBAUA);
	         authrequest.setAttribute("appname", "Emitra+Bonafide");
	         authrequest.setAttribute("udc", "test123");
	         authrequest.setAttribute("lk", LICENCEKEY);
	         authrequest.setAttribute("ra", "O");
	         authrequest.setAttribute("rc", "Y");
	         authrequest.setAttribute("lr", "Y");
	         authrequest.setAttribute("ts", timeStamp);
	         authrequest.setAttribute("pfr", "N");
	         authrequest.setAttribute("mec", "Y");
	         authrequest.setAttribute("ver", "2.0");
	         authrequest.setAttribute("txn", txnId);
	         authrequest.setAttribute("dpID", "");
	         authrequest.setAttribute("rdsID", "");
	         authrequest.setAttribute("rdsVer", "");
	         authrequest.setAttribute("dc", "");
	         authrequest.setAttribute("mi", "");
	         authrequest.setAttribute("mc", "");
	         authrequest.setAttribute("deviceSrNO", "NA");
	         authrequest.setAttribute("deviceError", "NA");
	         authrequest.setAttribute("ip", "NA");
	         authrequest.setAttribute("fdc", "NA");
	         authrequest.setAttribute("idc", "NC");
	         authrequest.setAttribute("macadd", "NA");
	         authrequest.setAttribute("lot", "P");
	         authrequest.setAttribute("lov", "302005");
	         authrequest.setAttribute("bt", "OTP");
	         doc.appendChild(authrequest);

	         //deviceInfo Element
	         Element deviceInfo = doc.createElement("deviceInfo");
	         deviceInfo.setAttribute("fType", "NA");
	         deviceInfo.setAttribute("iCount", "NA");
	         deviceInfo.setAttribute("pCount", "NA");
	         deviceInfo.setAttribute("errCodeRDS", "NA");
	         deviceInfo.setAttribute("errInfoRDS", "NA");
	         deviceInfo.setAttribute("fCount", "NA");
	         deviceInfo.setAttribute("nmPoints", "NA");
	         deviceInfo.setAttribute("qScore", "NA");
	         deviceInfo.setAttribute("srno", "NA");
	         deviceInfo.setAttribute("deviceError", "NA");
	         
	         authrequest.appendChild(deviceInfo);
	         
	         //Pid Element
	         Element pid = doc.createElement("Pid");
	         pid.setAttribute("ts", timeStamp);
	         pid.setAttribute("ver", "2.0");
	         pid.setAttribute("wadh", "");
	         
	         //Demo Element
	         /*Element Demo = doc.createElement("Demo");
	         Demo.setAttribute("lang", "06");
	         pid1.appendChild(Demo);*/
	         
	         Element Pv = doc.createElement("Pv");
	         Pv.setAttribute("otp", otp);
	         pid.appendChild(Pv);
	         
	         authrequest = prepareAuthRequestBio(pid, authrequest , timeStamp , doc , webPath);
	         
	         output = getStringFromXml(doc);
		      
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return output;
	}
	
	@SuppressWarnings({ "unused", "restriction" })
	private static Element prepareAuthRequestBio(Element pid, Element authrequest , String timeStamp , Document doc , String webPath) {
		// TODO Auto-generated method stub
		try {
			Encrypter encrypter = null;
			String filepath = webPath + "uidai_auth_prod.cer";
			encrypter = new Encrypter(filepath);
			byte[] sessionKey = null;
			byte[] encryptedSessionKey = null;
			sessionKey = encrypter.generateSessionKey();
			encryptedSessionKey = encrypter.encryptUsingPublicKey(sessionKey);
			SessionKeyDetails sessionKeyDetailsCdac = SessionKeyDetails.createNormalSkey(encryptedSessionKey);
			String certificateIdentifier = encrypter.getCertificateIdentifier();

			String pidBlock = getStringFromXml(pid);
			pidBlock = pidBlock.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();

			byte[] encXMLPIDData = encrypter.encryptUsingSessionKey(sessionKey, pidBlock.getBytes("UTF-8"), timeStamp);
			byte[] hmac = generateSha256Hash(pidBlock.getBytes("UTF-8"));
			byte[] encryptedHmacBytes = encrypter.encryptUsingSessionKeyNoAdd(sessionKey, hmac, timeStamp);
			byte[] demoBytes = new byte[10];
			byte[] hashedDemoBytes = StringUtils.leftPad("0", 64, '0').getBytes();
			if (demoBytes != null && demoBytes.length > 0) {
				hashedDemoBytes = generateSha256Hash(demoBytes);
			}
			
			Element sKey = doc.createElement("Skey");
				sKey.setAttribute("ci", certificateIdentifier);
				sKey.appendChild(doc.createTextNode(new sun.misc.BASE64Encoder().encode(sessionKeyDetailsCdac.getSkeyValue())));
			authrequest.appendChild(sKey);
			
			Element data = doc.createElement("Data");
				data.setAttribute("type", "X");
				data.appendChild(doc.createTextNode(new sun.misc.BASE64Encoder().encode(encXMLPIDData)));
			authrequest.appendChild(data);
			
			Element hMac = doc.createElement("Hmac");
				hMac.appendChild(doc.createTextNode(new sun.misc.BASE64Encoder().encode(encryptedHmacBytes)));
			authrequest.appendChild(hMac);
			
		} catch (InvalidCipherTextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authrequest;
	}

	@SuppressWarnings("unused")
	public static byte[] generateSha256Hash(byte[] message) {
        String algorithm = "SHA-256";
        String SECURITY_PROVIDER = "BC";

        byte[] hash = null;

        MessageDigest digest;
        try {
//            digest = MessageDigest.getInstance(algorithm, SECURITY_PROVIDER);
            digest = MessageDigest.getInstance(algorithm);
            digest.reset();
            hash = digest.digest(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hash;
    }

	public static String getStringFromXml(Object object) {
		// write the content into xml file
		String blockElement = "";
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
			// write the content into string format
			StringWriter writer = new StringWriter();
			if (object instanceof Element) {
				transformer.transform(new DOMSource((Element)object), new StreamResult(writer));
			}else if (object instanceof Document) {
				transformer.transform(new DOMSource((Document)object), new StreamResult(writer));
			}
			
			blockElement = writer.getBuffer().toString();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blockElement;
	}
}
