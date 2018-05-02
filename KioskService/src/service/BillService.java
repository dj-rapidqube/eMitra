package service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.simple.JSONObject;

import model.Bill;
import model.CardPaymentDetails;
import model.LatestVersionDetails;
import model.MachineAuth;

public interface BillService {
	public void updateBillInformation(Bill bill);
	public Bill getPrintBillDetails(Bill bill);
	public void saveVerifiedData(String verifiedData);
	public String getbackToBackurl(String amt,String trnsid, String serviceId,String flag);
	//Precise Code
	//public void saveBackToBackTransaction(String backToBackDetail, String paymentMode);
	//Grinaar Code
	public void saveBackToBackTransaction(String backToBackDetail, String paymentMode) throws Exception;
	
	public void saveCardPaymentDetails(CardPaymentDetails cpd);
	public  List<Bill>  getPaymentInfo(String PRN);
	public String getCancelTranscationurl(String trnsid);
	public void savePaymentStatus(String token,String certType, int certificareYear);
	public void updateStatusCash(String status, String amt,String token);
	public Bill getTransactionDetails(String transactionid) ; 
//Precise
//	public void updateTransactionDetails(String emitraTransactionFlag, Bill transactionDetails, String trnsid);
// Grinaar
	public void updateTransactionDetails(String emitraTransactionFlag, Bill transactionDetails, String trnsid) throws Exception;
	void updateTransactionDetails(String transid);
	public void saveCancelTranscationurl(String decriptCancelTranscationUrl);
	public String getBacktoBacktransactionId(String transid) ;
	public String getcertibackToBackurl(String amt,String trnsid, String serviceId,String flag);
	public void updatedAmount(double d, int resultAmount, String tid);
	public LatestVersionDetails versionCheck();
	public void saveMachineAuth(MachineAuth mach,String SSOID,String versionNo);
	public MachineAuth getMachineAuthenticationDetails(String ssoid);
	public void updateDeleteTransactionFlag(String msg, String emitraTransactionId) ;
	public boolean insertUntrackedEmitraTransaction(Bill bill);
	public boolean updateUntrackedEmitraTransaction(Bill billDetails);
	public void accpetMachineAmountDetails(String transid, String totalAmount, String noteValue);
	public JSONObject downloadfile(JSONObject  json , String registration ,HttpServletRequest req) throws MalformedURLException, IOException, JSONException;
	//public String getBankReferenceNumber(String btbTransactionID);
	
}
