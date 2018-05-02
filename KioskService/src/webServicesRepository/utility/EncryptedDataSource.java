package webServicesRepository.utility;

import java.io.IOException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import sun.misc.BASE64Decoder;

public class EncryptedDataSource extends DriverManagerDataSource {

 @Override
 public String getPassword() {
  String password = super.getPassword();
  return decode(password);
 }

 @Override
 public String getUsername() {
  String username = super.getUsername();
  return decode(username);
 }
 
 @Override
 public String getUrl() {
  String url = super.getUrl();
  return decode(url);
 }
 

 private String decode(String decode) {
  BASE64Decoder decoder = new BASE64Decoder();
  try {
   decode = new String(decoder.decodeBuffer(decode));
  // decode = decode.split("##")[0];
  // System.out.println("decode "+decode);
  } catch (IOException e) {
   e.printStackTrace();
  }
  return decode;
 }

}
