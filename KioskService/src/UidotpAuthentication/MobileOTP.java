package UidotpAuthentication;


import java.io.BufferedReader;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;


public class MobileOTP {
    
    static Logger logger = Logger.getLogger(MobileOTP.class.getName());
    
    @SuppressWarnings("unchecked")
	public JSONObject sendMessageOnMobile(String mobileNo) {
    	
    	JSONObject retrunObj = new JSONObject();
    	
    	String otp = generateOTP();
    	
    	try {
			char []mobileDigits = mobileNo.toCharArray();
			String maskMobile = "";
			for (int i = 0; i < mobileDigits.length; i++) {
				String character = String.valueOf(mobileDigits[i]);
				if(!character.equals("-")) {
					if(i < mobileDigits.length-3) {
						maskMobile += character.replace(character, "X");
					}else {
						maskMobile += character;
					}
				}else {
					maskMobile += character;
				}
			}
			String currentTS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
			String msg = "OTP for Mobile (" + maskMobile + ") is " + otp + " and is valid for 15 minutes."
					+ "(Generated at "+	currentTS+")";
			
			HttpURLConnection connection = sendSMS(mobileNo , msg);
			if(connection.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream() , StandardCharsets.UTF_8));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				
				while((line = br.readLine()) != null) {
					buffer.append(line);
				}
				System.out.println(connection.getResponseCode());
				System.out.println(connection.getResponseMessage());
				retrunObj.put("OTP", otp);
				retrunObj.put("MSG", msg);
				retrunObj.put("CURRENT_TS", currentTS);
				retrunObj.put("MOBILE_NO", mobileNo);

				return retrunObj;
			}else {
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
    }
    
	public String generateOTP() {
        logger.info("in generateOTP");
        String chars = "0123456789";
        final int PW_LENGTH = 4;
        Random rnd = new SecureRandom();
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < PW_LENGTH; i++) {
            pass.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return pass.toString();
    }

    @SuppressWarnings({ "deprecation" })
	public static HttpURLConnection sendSingleSMS(HttpURLConnection lconnection, String username,
            String password, String senderId,
            String mobileNo, String message) {

        logger.info("sendSingleSMS");
        logger.info("sendSingleSMS");
        try {
            logger.info("**************");
            logger.info("Username = " + username + "Password = " + password
                    + "senderId = " + senderId + "mobileNo = " + mobileNo + "message = " + message);
            String smsservicetype = "singlemsg"; // For single message.
            String query = "username=" + URLEncoder.encode(username)
                    + "&password=" + URLEncoder.encode(password)
                    + "&smsservicetype=" + URLEncoder.encode(smsservicetype)
                    + "&content=" + URLEncoder.encode(message) + "&mobileno="
                    + URLEncoder.encode(mobileNo) + "&senderid="
                    + URLEncoder.encode(senderId);

            logger.info("Printing query = " + query);
            logger.info("Printing query = " + query);
            lconnection.setRequestProperty("Content-length", String.valueOf(query.length()));
            lconnection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            lconnection.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

            // open up the output stream of the connection
            DataOutputStream output = new DataOutputStream(lconnection.getOutputStream());

            // write out the data
            output.writeBytes(query);
            // output.close();

            // get ready to read the response from the cgi script
            DataInputStream input = new DataInputStream(lconnection.getInputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(lconnection.getInputStream() , StandardCharsets.UTF_8));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			
			while((line = br.readLine()) != null) {
				buffer.append(line);
			}
			
            
            // read in each character until end-of-stream is detected
            for (int c = input.read(); c != -1; c = input.read()) {
                logger.info((char) c);
            }
            
            input.close();
        } catch (Exception e) {
            logger.info("Something bad just happened.");
            logger.warn("Something bad just happened."+e.getMessage());
            logger.info(e);
            e.printStackTrace();
        }
        return lconnection;
    }

    @SuppressWarnings("static-access")
	public static HttpURLConnection sendSMS(String mobilenumber, String msg) throws MalformedURLException, IOException {
        
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.68.250.41", Integer.parseInt("8080")));
        URL surl = new URL("http://msdgweb.mgov.gov.in/esms/sendsmsrequest");
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) surl.openConnection(proxy);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setFollowRedirects(true);
        if (connection != null) {
            logger.info("Mobile NUmber length  for Sending SMS: " + mobilenumber.length());
            logger.info("Mobile NUmber length  for Sending SMS: " + mobilenumber.length());
            connection = sendSingleSMS(connection, "rajmsdg-elocker", "eLocker@16", "RAJSMS", mobilenumber, msg);
            logger.info("Sent successful SMS");
            logger.info("Sent successful SMS");
        }
        return connection;
    }
    
    public static void main(String[] args) {
		MobileOTP otp = new MobileOTP();
		otp.sendMessageOnMobile("9413036321");
	}
}