package service;

import java.sql.SQLException;
import java.util.List;

import model.Bill;
import model.Discom;
import model.Phed;

public interface EncryptDecryptService {
	public List<Bill> sendPostForDecryptDetail(String encryptDetails,Bill bill);
	public String getGovtServiceDetail(String encryptURL);
	public String getPDFPrinted(String encryptURL);
	public Bill tokenVerficationDetails(String tokenVerfiyURl,String transId);
	public List<Discom> sendPostForDiscomDecryptData(String encryptDetails, Bill bill, Discom discom); 
	public List<Phed> sendPostForPhedDecryptData(String encryptDetails, Bill bill, Phed ph) throws SQLException; 
	public String getAadharNumber(String response);
}
