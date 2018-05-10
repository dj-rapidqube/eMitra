package UidotpAuthentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.springframework.beans.factory.annotation.Value;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("deprecation")
public class BhamashahServices implements Runnable{
	
	@Value("${GetDisabiiltyCertByAadhaarSapIDUrl}")
	private String GetDisabiiltyCertByAadhaarSapIDUrl;
	
	@Value("${getBonafiedAadharDetailsUrl}")
	private String getBonafiedAadharDetailsUrl;
	
	@Value("${MemberDataForBhamashaUrl}")
	private static String MemberDataForBhamashaUrl;
	
	public Thread mythread;
	public JSONObject dataJSON = new JSONObject();
	private String requestUrl = null;
	private String methodName = null;

	public BhamashahServices() {}
	
	public BhamashahServices(String requestUrl , String methodName) {
		mythread = new Thread(this, "my runnable thread");
		this.requestUrl = requestUrl;
		this.methodName = methodName;
		mythread.start();
	}
	
	public void run() {
		try {
			dataJSON = updateMobileOrBnkAcc(requestUrl, methodName);
			mythread.isAlive();
		} catch (Exception e) {
			System.out.println("my thread interrupted");
		}
	}
	
	public String getBhamashahIdByAadhar(String aadharId , String requestUrl) {
		// TODO Auto-generated method stub
		
		String docxml = getXmlForAadharInfo(String.valueOf(aadharId));
		JSONObject dataObjMembers = getResponseString(docxml , requestUrl);
		
		JSONObject uidMemberObj = getMemberData(dataObjMembers);
		
		String bhamashahFamilyId = getBhamashahFamilyId(uidMemberObj);
		
		return bhamashahFamilyId;
	}
	
	public String getXmlForAadharInfo(String aadharNo) {
		Document doc = null;
		String output = null;
		try {
	         DocumentBuilderFactory dbFactory =
	         DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         doc = dBuilder.newDocument();
	         
	         // root element
	         Element rootElement = doc.createElement("root");
	         doc.appendChild(rootElement);

	         // bhamashahInfoaadhar element
	         Element bhamashahInfoaadhar = doc.createElement("bhamashahInfoaadhar");
	         rootElement.appendChild(bhamashahInfoaadhar);

	         //aadharId Element
	         Element aadharId = doc.createElement("aadharId");
	         aadharId.appendChild(doc.createTextNode(aadharNo));
	         bhamashahInfoaadhar.appendChild(aadharId);
	         
	         //scheme Element
	         Element scheme = doc.createElement("scheme");
	         scheme.appendChild(doc.createTextNode("epbc"));
	         bhamashahInfoaadhar.appendChild(scheme);
	         
	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	         
	         //write the content into string format
	         StringWriter writer = new StringWriter();
	         transformer.transform(new DOMSource(doc), new StreamResult(writer));
	         output = writer.getBuffer().toString();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return output;
	}
	
	public JSONObject getResponseString(String docXml , String requestUrl) {
		// TODO Auto-generated method stub
		int PRETTY_PRINT_INDENT_FACTOR = 4;
		StringBuffer responseString = new StringBuffer();
		
		JSONObject json = new JSONObject();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Length", String.valueOf(docXml.length()));
			connection.setRequestProperty("SOAPAction", "");
			connection.setRequestProperty("Content-Type", "application/xml; text/html; charset=UTF-8");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(docXml);
			writer.close();
			
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);
			System.out.println(connection.getResponseMessage());
			if(responseCode!=200) {
//				logger.info("CertificateService, response code : "+responseCode+" due to API server error");
			}else {
//				logger.info("CertificateService, response code : "+responseCode);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream() , StandardCharsets.UTF_8));
				String inputLine;
		
				while ((inputLine = in.readLine()) != null) {
					responseString.append(inputLine);
				}
				in.close();
			}
			String TEST_XML_STRING = responseString.toString();
			org.json.JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            JSONParser parser = new JSONParser();
            json = (JSONObject) parser.parse(jsonPrettyPrintString);
            
		} catch (Exception e) {
//			logger.error("CertificateService, Exception msg :: " + e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
	
	public String getResponseStringForDisability(JSONObject requestJson , String requestUrl) {
		// TODO Auto-generated method stub
		StringBuffer responseString = new StringBuffer();
		
		requestUrl = GetDisabiiltyCertByAadhaarSapIDUrl;
		String PDFINBASE64 = "";
		
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Length", String.valueOf(requestJson.size()));
			connection.setRequestProperty("SOAPAction", "");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(requestJson.toString());
			writer.close();
			
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);
			System.out.println(connection.getResponseMessage());
			if(responseCode!=200) {
//				logger.info("CertificateService, response code : "+responseCode+" due to API server error");
			}else {
//				logger.info("CertificateService, response code : "+responseCode);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
		
				while ((inputLine = in.readLine()) != null) {
					responseString.append(inputLine);
				}
				in.close();
			}
			String TEST_XML_STRING = responseString.toString();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(TEST_XML_STRING);
            
            PDFINBASE64 = String.valueOf(json.get("PDFINBASE64"));
            
		} catch (Exception e) {
//			logger.error("CertificateService, Exception msg :: " + e.getMessage());
			e.printStackTrace();
		}
		return PDFINBASE64;
	}
	
	private JSONObject getMemberData(JSONObject dataObjMembers) {
		// TODO Auto-generated method stub
		JSONObject uidMemberObj = new JSONObject();
		System.out.println(dataObjMembers);
		if(dataObjMembers != null && !dataObjMembers.isEmpty()) {
			uidMemberObj = (JSONObject) ((JSONObject)((JSONObject)dataObjMembers.get("root")).get("personalInfo")).get("member");
		}
		return uidMemberObj;
	}
	
	private String getBhamashahFamilyId(JSONObject uidMemberObj) {
		// TODO Auto-generated method stub
		String familyId = String.valueOf(uidMemberObj.get("familyId"));
		
		return familyId;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBonafiedAadharDetails(String aadharId , String modeOfPage) {
		// TODO Auto-generated method stub
		String requestUrl = getBonafiedAadharDetailsUrl;
		System.out.println(String.valueOf(aadharId));
		String docxml = getXmlForAadharInfo(String.valueOf(aadharId));
		System.out.println(docxml);
		JSONObject dataObjMembers = getResponseString(docxml , requestUrl);
		
		JSONObject uidMemberObj = getMemberData(dataObjMembers);
//		if(uidMemberObj != null && !uidMemberObj.isEmpty()) {
//			getMemberPhotoData(uidMemberObj);
//		}
		Map<String , Object> map = new HashMap<String, Object>();
			JSONObject bonafide = setDataOfMember(uidMemberObj , modeOfPage);
			map.put("memberData", bonafide);
		return bonafide;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject setDataOfMember(JSONObject memberData , String modeOfPage) {
		// TODO Auto-generated method stub
		JSONObject bonafide = new JSONObject();
		if(modeOfPage.equalsIgnoreCase("ENG")) {
			if(((String) memberData.get("gender")).equalsIgnoreCase("Female")) {
				if(((String) memberData.get("maritalStatus")).equalsIgnoreCase("Married")) {
					bonafide.put("titletyp","श्रीमती");
					bonafide.put("relationtyp","पति");
					bonafide.put("fathersNameEform",(String) memberData.get("snameEng"));
				}else {
					bonafide.put("titletyp","सुश्री");
					bonafide.put("relationtyp","पिता");
					bonafide.put("fathersNameEform",(String) memberData.get("fnameEng"));
				}
			}else if(((String) memberData.get("gender")).equalsIgnoreCase("Male")) {
				bonafide.put("titletyp","श्री");
				bonafide.put("relationtyp","पिता");
				bonafide.put("fathersNameEform",(String) memberData.get("fnameEng"));
			}
			bonafide.put("applicantName",(String) memberData.get("nameEng"));
			bonafide.put("profileDob",(String) memberData.get("dob"));
			bonafide.put("profileBhamashahId",String.valueOf(memberData.get("familyId")));
			bonafide.put("profileAadharId", String.valueOf(memberData.get("aadhar")));
		}
		return bonafide;
	}
	
	public Map<String, Object> getBonafiedBhamashahDetails(String bhamasaId , String modeOfPage , String requestUrl) {
		// TODO Auto-generated method stub
		
		String docXml = getXmlForBhamashah(String.valueOf(bhamasaId));
		JSONObject dataObjMembers = getResponseString(docXml , requestUrl);
		Map<String , Object> dataMap = getMembersList(dataObjMembers , modeOfPage);
		
		return dataMap;
	}
	
	private String getXmlForBhamashah(String bhamasaId) {
		Document doc = null;
		String output = null;
		try {
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         doc = dBuilder.newDocument();
	         
	         // root element
	         Element rootElement = doc.createElement("root");
	         doc.appendChild(rootElement);

	         // Info element
	         Element Info = doc.createElement("Info");
	         rootElement.appendChild(Info);

	         if(bhamasaId.length() == 7) {
		         // familyId element
		         Element familyId = doc.createElement("familyId");
		         familyId.appendChild(doc.createTextNode(bhamasaId));
		         Info.appendChild(familyId);
		       //ackId Element
		         Element ackId = doc.createElement("ackId");
		         ackId.appendChild(doc.createTextNode(""));
		         Info.appendChild(ackId);
	         }else {
	        	// familyId element
		         Element familyId = doc.createElement("familyId");
		         familyId.appendChild(doc.createTextNode(""));
		         Info.appendChild(familyId);
	        	//ackId Element
		         Element ackId = doc.createElement("ackId");
		         ackId.appendChild(doc.createTextNode(bhamasaId));
		         Info.appendChild(ackId);
	         }
	         
	         //aadharId Element
	         Element aadharId = doc.createElement("aadharId");
	         aadharId.appendChild(doc.createTextNode(""));
	         Info.appendChild(aadharId);
	         
	         //scheme Element
	         Element scheme = doc.createElement("scheme");
	         scheme.appendChild(doc.createTextNode("epbc"));
	         Info.appendChild(scheme);
	         
	         //infoFlg Element
	         Element infoFlg = doc.createElement("infoFlg");
	         infoFlg.appendChild(doc.createTextNode("PFE"));
	         Info.appendChild(infoFlg);
	         
	         output = AadharServices.getStringFromXml(doc);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return output;
	}

	private Map<String, Object> getMembersList(JSONObject dataObjMembers, String modeOfPage) {
		// TODO Auto-generated method stub
		List<String> nameList = new ArrayList<String>();
		List<String> genderList = new ArrayList<String>();
		Map<String , Object> map = new HashMap<String, Object>();
		if(dataObjMembers != null && !dataObjMembers.isEmpty()) {
			JSONArray members = (JSONArray) ((JSONObject)((JSONObject)dataObjMembers.get("root")).get("personalInfo")).get("member");
			JSONObject familyDetails = (JSONObject) ((JSONObject)((JSONObject)dataObjMembers.get("root")).get("family")).get("familydetail");
			for (int i = 0; i < members.size(); i++) {
				JSONObject dataObj = (JSONObject) members.get(i);
				if(modeOfPage.equalsIgnoreCase("ENG")) {
					nameList.add(((String) dataObj.get("nameEng")));
				}else if(modeOfPage.equalsIgnoreCase("HND")) {
					nameList.add(((String) dataObj.get("nameHnd")));
				}
				genderList.add(((String) dataObj.get("gender")).toUpperCase());
			}
			map.put("nameList", nameList);
			map.put("genderList", genderList);
			map.put("membersData", members);
			map.put("familyDetails", familyDetails);
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getBhamashahDetails(String modeOfPage , String requestUrl , String methodName) {
		// TODO Auto-generated method stub
		JSONObject responseObject = new JSONObject();
		JSONArray dataObjMembers = getBhamashahResponseDataForFetchData(requestUrl , methodName);
		if(String.valueOf(((JSONObject)dataObjMembers.get(0)).get("STATUS")).equalsIgnoreCase("false")) {
			responseObject.put("STATUS", false);
		}else {
			responseObject = getBhamashahMembersData(modeOfPage , dataObjMembers);
		}
		return responseObject;
	}

	private JSONArray getBhamashahResponseDataForFetchData(String requestUrl , String methodName) {
		// TODO Auto-generated method stub
		JSONArray responseJson = new JSONArray();
		HttpURLConnection connection = null;
		try {
			URL urlObject = new URL(requestUrl);
			
			connection = (HttpURLConnection) urlObject.openConnection();
			connection.setRequestMethod(methodName);
			connection.setRequestProperty("Accept", "application/json  charset=UTF-8");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream() , StandardCharsets.UTF_8));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			
			while((line = br.readLine()) != null) {
				buffer.append(line);
			}
			JSONParser parser = new JSONParser();
			responseJson = (JSONArray) parser.parse(buffer.toString());
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseJson;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getBhamashahMembersData(String modeOfPage , JSONArray dataObjMembers) {
		// TODO Auto-generated method stub
		
		JSONObject responseObject = new JSONObject();
		List<String> memberIdList = new ArrayList<String>();
		List<String> nameList = new ArrayList<String>();
		List<String> genderList = new ArrayList<String>();
		List<String> dobList = new ArrayList<String>();
		List<String> bhamashahIdList = new ArrayList<String>();
		List<String> memberTypeList = new ArrayList<String>();
		List<String> addharNoList = new ArrayList<String>();
		List<String> mobileNoList = new ArrayList<String>();
		List<String> accountNumberList = new ArrayList<String>();
		for (int index = 0; index < dataObjMembers.size(); index++) {
			JSONObject indexJson = (JSONObject) dataObjMembers.get(index);
			memberIdList.add(String.valueOf(indexJson.get("M_ID")));
			if(modeOfPage.equalsIgnoreCase("ENG")) {
				nameList.add(String.valueOf(indexJson.get("HOF_NAME_ENG")));
				genderList.add(String.valueOf(indexJson.get("GENDER_DESC_ENG")));
			}else if(modeOfPage.equalsIgnoreCase("HND")) {
				nameList.add(String.valueOf(indexJson.get("HOF_NAME_HND")));
				genderList.add(String.valueOf(indexJson.get("GENDER_DESC_HIN")));
			}
			dobList.add(getDate(String.valueOf(indexJson.get("DOB"))));
			bhamashahIdList.add(numberMasking(String.valueOf(indexJson.get("BHAMASHAH_ID"))));
			memberTypeList.add(String.valueOf(indexJson.get("MEMBER_TYPE")));
			addharNoList.add(numberMasking(String.valueOf(indexJson.get("ADDHAR_NO"))));
			mobileNoList.add(numberMasking(String.valueOf(indexJson.get("MOBILE_NO"))));
			accountNumberList.add(numberMasking(String.valueOf(indexJson.get("ACCOUNT_NUMBER"))));
		}
		responseObject.put("membersData", dataObjMembers);
		responseObject.put("nameList", nameList);
		responseObject.put("memIdList", memberIdList);
		responseObject.put("genderList", genderList);
		responseObject.put("dobList", dobList);
		responseObject.put("bhamashahIdList", bhamashahIdList);
		responseObject.put("memberTypeList", memberTypeList);
		responseObject.put("addharNoList", addharNoList);
		responseObject.put("mobileNoList", mobileNoList);
		responseObject.put("accountNumberList", accountNumberList);
		
		return responseObject;
	}
	
	public String numberMasking(String number) {
		char []numberDigits = number.toCharArray();
		String maskNumber = "";
		for (int i = 0; i < numberDigits.length; i++) {
			String character = String.valueOf(numberDigits[i]);
			if(!character.equals("-")) {
				if(i < numberDigits.length-4) {
					maskNumber += character.replace(character, "X");
				}else {
					maskNumber += character;
				}
			}else {
				maskNumber += character;
			}
		}
		return maskNumber;
	}
	
	private String getDate(String dob) {

		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition ps = new ParsePosition(0);
		Date date = sdfIn.parse(dob, ps);

		SimpleDateFormat sdfOut = new SimpleDateFormat("dd/MMM/yyyy");
		dob = sdfOut.format(date);
		return dob;
	}

	public JSONObject updateMobileOrBnkAcc(String requestUrl , String methodName) {
		// TODO Auto-generated method stub
		
		JSONObject dataObjMembers = getBhamashahResponseDataForNumberUpdate(requestUrl , methodName);
		return dataObjMembers;
	}
	
	@SuppressWarnings({ "resource", "unchecked" })
	private JSONObject getBhamashahResponseDataForNumberUpdate(String requestUrl , String methodName) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(requestUrl);
			StringBuilder res = new StringBuilder();
				post.setHeader("Content-Type", "text/xml");
				HttpResponse resp = client.execute((HttpUriRequest) post);
				BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
				String line = "";
				while ((line = rd.readLine()) != null) {
					res.append(line);
				}
			String response = res.toString();
			JSONParser parser = new JSONParser();
			json = (JSONObject) parser.parse(response);
			
		} catch (Exception e) {
			json.put("status", "null");
//			e.printStackTrace();
		}
		return json;
	}
	
	public JSONObject getBonafideMemberPhoto(String requestUrl) {
		// TODO Auto-generated method stub
		StringBuffer responseString = new StringBuffer();
		JSONObject resJson = new JSONObject();
//			requestUrl = "https://api.sewadwaar.rajasthan.gov.in/app/live/bhamashahseeding/details/hofAndMemberPhoto/WDYMIWF/0?client_id=9063b7b2-3a8d-4efb-8422-0572fff44ab2";
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("SOAPAction", "");
			connection.setRequestProperty("Content-Type", "");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Accept" , "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			connection.setRequestProperty("User-Agent", 
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			int responseCode = connection.getResponseCode();
			if(responseCode!=200) {
			}else {
				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
		
				while ((inputLine = in.readLine()) != null) {
					responseString.append(inputLine);
				}
				in.close();
				
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(responseString.toString());
				if(json.containsKey("member_Photo")) {
					JSONArray photoArr = (JSONArray)json.get("member_Photo");
					resJson = (JSONObject) photoArr.get(0);
				}
				if(json.containsKey("hof_Photo")) {
					resJson = (JSONObject) json.get("hof_Photo");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return resJson;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject setMemberDataForBhamasa(JSONObject familyDetailsObj , JSONObject memberData , String modeOfPage) {
		// TODO Auto-generated method stub
		JSONObject bonafide = new JSONObject();
		if(modeOfPage.equalsIgnoreCase("HND")) {
			if(((String) memberData.get("gender")).equalsIgnoreCase("Male") || ((String) memberData.get("gender")).equalsIgnoreCase("M")) {
				bonafide.put("titletyp","श्री");
				bonafide.put("relationtyp","पिता");
				bonafide.put("fathersNameEform",(String) memberData.get("fnameHnd"));
				bonafide.put("isMarried","");
				bonafide.put("husMarrigeDetail1", "");
			}else if(((String) memberData.get("gender")).equalsIgnoreCase("Female")) {
				if(((String) memberData.get("maritalStatus")).equalsIgnoreCase("Married")) {
					bonafide.put("titletyp","श्रीमती");
					bonafide.put("relationtyp","पति");
					bonafide.put("fathersNameEform",(String) memberData.get("snameHnd"));
					bonafide.put("isMarried","हां");
					bonafide.put("husMarrigeDetail1", (String) memberData.get("snameHnd"));
				}else {
					bonafide.put("titletyp","सुश्री");
					bonafide.put("relationtyp","पिता");
					bonafide.put("fathersNameEform",(String) memberData.get("fnameHnd"));
					bonafide.put("isMarried","नहीं");
					bonafide.put("husMarrigeDetail1", "");
				}
			}
			bonafide.put("applicantName",(String) memberData.get("nameHnd"));
			bonafide.put("profileDob",(String) memberData.get("dob"));
			bonafide.put("profileBhamashahId",String.valueOf(memberData.get("familyId")));
			if(memberData.get("aadhar") instanceof JSONObject) {
				bonafide.put("profileAadharId", String.valueOf(""));
			}else if(memberData.get("aadhar") instanceof String) {
				bonafide.put("profileAadharId", String.valueOf(memberData.get("aadhar")));
			}else {
				bonafide.put("profileAadharId", String.valueOf(""));
			}
			if(memberData.get("mobile") instanceof JSONObject) {
				bonafide.put("profileMobile", String.valueOf(""));
			}else if(memberData.get("mobile") instanceof String) {
				bonafide.put("profileMobile", String.valueOf(memberData.get("mobile")));
			}else {
				bonafide.put("profileMobile", String.valueOf(""));
			}
			if(memberData.get("email") instanceof JSONObject) {
				bonafide.put("profileEmail", String.valueOf(""));
			}else if(memberData.get("email") instanceof String) {
				bonafide.put("profileEmail", String.valueOf(memberData.get("email")));
			}else {
				bonafide.put("profileEmail", String.valueOf(""));
			}
			if(((String) memberData.get("qualification")).equalsIgnoreCase("illiterate")) {
				bonafide.put("rowid0","--");
				bonafide.put("rowid1","--");
				bonafide.put("rowid2","--");
				bonafide.put("rowid3","--");
				bonafide.put("rowid4","--");
				bonafide.put("rowid5","--");
				bonafide.put("rowid6","--");
				bonafide.put("rowid7","--");
				bonafide.put("rowid8","--");
				bonafide.put("rowid9","--");
				bonafide.put("rowid10","illiterate");
				bonafide.put("rowid11","--");
			}
			bonafide.put("permAddressCountryIdtext", String.valueOf("India"));
			bonafide.put("permAddressStateIdtext", String.valueOf("Rajasthan"));
			bonafide.put("permAddressDistrictIdtext", String.valueOf(familyDetailsObj.get("districtName")));
			
			bonafide.put("permAddressDivisionIdtext", String.valueOf(""));
			bonafide.put("permAddressTehsilIdtext", String.valueOf(""));
			bonafide.put("permAddressMunicipalityIdtext", String.valueOf(""));
			bonafide.put("permAddressWardIdtext", String.valueOf(""));
			bonafide.put("permAddressPanchayatSamityIdtext", String.valueOf(""));
			
			if(familyDetailsObj.get("gp") instanceof JSONObject) {
				bonafide.put("permAddressGramPanchayatIdtext", String.valueOf(""));
			}else {
				bonafide.put("permAddressGramPanchayatIdtext", String.valueOf(familyDetailsObj.get("gp")));
			}
			if(familyDetailsObj.get("village") instanceof JSONObject) {
				bonafide.put("permAddressVillageIdtext", String.valueOf(""));
			}else {
				bonafide.put("permAddressVillageIdtext", String.valueOf(familyDetailsObj.get("village")));
			}
			if(familyDetailsObj.get("pin") instanceof JSONObject) {
				bonafide.put("permAddressAddPinCodetext", String.valueOf(""));
			}else {
				bonafide.put("permAddressAddPinCodetext", String.valueOf(familyDetailsObj.get("pin")));
			}
			if(familyDetailsObj.get("livSince") instanceof JSONObject) {
				bonafide.put("fromYearInRaj", String.valueOf(""));
			}else {
				bonafide.put("fromYearInRaj", String.valueOf(familyDetailsObj.get("livSince")));
			}
			bonafide.put("memberImage", String.valueOf(memberData.get("pht")));
			
		}else if(modeOfPage.equalsIgnoreCase("ENG")) {
			
			if(((String) memberData.get("gender")).equalsIgnoreCase("Male")) {
				bonafide.put("titletyp","Mr");
				bonafide.put("relationtyp","Father");
				bonafide.put("fathersNameEform",  String.valueOf(memberData.get("fnameEng")));
				bonafide.put("husMarrigeDetail1", "");
			}else if(((String) memberData.get("gender")).equalsIgnoreCase("Female")) {
				if(((String) memberData.get("maritalStatus")).equalsIgnoreCase("Married")) {
					bonafide.put("titletyp","Mrs");
					bonafide.put("relationtyp","Husband");
					bonafide.put("fathersNameEform",  String.valueOf(memberData.get("snameEng")));
					bonafide.put("isMarried","Yes");
					bonafide.put("husMarrigeDetail1",  String.valueOf(memberData.get("snameEng")));
				}else {
					bonafide.put("titletyp","Ms");
					bonafide.put("relationtyp","Father");
					bonafide.put("fathersNameEform", String.valueOf(memberData.get("fnameEng")));
					bonafide.put("isMarried","No");
					bonafide.put("husMarrigeDetail1", "");
				}
			}
			
			bonafide.put("applicantName",  String.valueOf(memberData.get("nameEng")));
			bonafide.put("profileDob",  String.valueOf(memberData.get("dob")));
			bonafide.put("profileBhamashahId",String.valueOf(memberData.get("familyId")));
			if(memberData.get("aadhar") instanceof JSONObject) {
				bonafide.put("profileAadharId", String.valueOf(""));
			}else {
				bonafide.put("profileAadharId", String.valueOf(memberData.get("aadhar")));
			}
			if(memberData.get("mobile") instanceof JSONObject) {
				bonafide.put("profileMobile", String.valueOf(""));
			}else {
				bonafide.put("profileMobile", String.valueOf(memberData.get("mobile")));
			}
			
			if(memberData.get("email") instanceof JSONObject) {
				bonafide.put("profileEmail", String.valueOf(""));
			}else {
				bonafide.put("profileEmail", String.valueOf(memberData.get("email")));
			}
			
			bonafide.put("permAddressCountryIdtext", String.valueOf("India"));
			bonafide.put("permAddressStateIdtext", String.valueOf("Rajasthan"));
			bonafide.put("permAddressDistrictIdtext", String.valueOf(familyDetailsObj.get("districtName")));
			
			bonafide.put("permAddressDivisionIdtext", String.valueOf(""));
			bonafide.put("permAddressTehsilIdtext", String.valueOf(""));
			bonafide.put("permAddressMunicipalityIdtext", String.valueOf(""));
			bonafide.put("permAddressWardIdtext", String.valueOf(""));
			bonafide.put("permAddressPanchayatSamityIdtext", String.valueOf(""));
			if(familyDetailsObj.get("gp") instanceof JSONObject) {
				bonafide.put("permAddressGramPanchayatIdtext", String.valueOf(""));
			}else {
				bonafide.put("permAddressGramPanchayatIdtext", String.valueOf(familyDetailsObj.get("gp")));
			}
			if(familyDetailsObj.get("village") instanceof JSONObject) {
				bonafide.put("permAddressVillageIdtext", String.valueOf(""));
			}else {
				bonafide.put("permAddressVillageIdtext", String.valueOf(familyDetailsObj.get("village")));
			}
			if(familyDetailsObj.get("pin") instanceof JSONObject) {
				bonafide.put("permAddressAddPinCodetext", String.valueOf(""));
			}else {
				bonafide.put("permAddressAddPinCodetext", String.valueOf(familyDetailsObj.get("pin")));
			}
			if(familyDetailsObj.get("livSince") instanceof JSONObject) {
				bonafide.put("fromYearInRaj", String.valueOf(""));
			}else {
				bonafide.put("fromYearInRaj", String.valueOf(familyDetailsObj.get("livSince")));
			}
			bonafide.put("memberImage", String.valueOf(memberData.get("pht")));
		}
		
		System.out.println(bonafide.toJSONString());
		return bonafide;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String urlBhamashahGetDetails = MemberDataForBhamashaUrl;
		BhamashahServices bhamashahServices = new BhamashahServices();
		/*String bhamashahId = String.valueOf("9999-2TBH-00035");
		String memberId = String.valueOf("21344");
		String memberType = String.valueOf("MEM");
		String mobileNumber = String.valueOf("9393939393");
		String acocuntNumber = String.valueOf("SBI010101010123");
		String ifscCode = String.valueOf("SBI010101");
		String userId = String.valueOf("ISHITA.GURTU");
		
		String updateFlag = "A";
		String requestUrl = "https://apitest.sewadwaar.rajasthan.gov.in/app/live/Bhamashah/Staging/Action/Dtl/KioskPlusPush/"
							+ bhamashahId + "/" + memberId + "/" + memberType + "/" + updateFlag  + "/";
		
		if(updateFlag.equalsIgnoreCase("M")) {
			
			requestUrl += mobileNumber + "/0/0/";
			
		}else if(updateFlag.equalsIgnoreCase("A")) {
			
			requestUrl += "0/" + acocuntNumber + "/" + ifscCode + "/";
		}
		requestUrl +=  userId + "?client_id=0d1c452f-5711-462b-8f58-bf5156ac3285";
		
		System.out.println(requestUrl);
		
		JSONObject obj = bhamashahServices.updateMobileOrBnkAcc(requestUrl , "POST");
		
		System.out.println(obj.toJSONString());*/
		
//		JSONObject obj = bhamashahServices.getBhamashahDetails(urlBhamashahGetDetails , "GET");
		
//		String obj = bhamashahServices.numberMasking("123456789");
		
//		System.out.println(obj.toString());
	}
}