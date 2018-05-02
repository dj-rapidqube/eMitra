package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BillDAO;
import model.Bill;
import model.CardPaymentDetails;
import model.LatestVersionDetails;
import model.MachineAuth;

@Service("billService")
public class BillServiceImpl implements BillService{
	@Autowired
	private BillDAO billDAO;
	
	@Override
	@Transactional
	public void updateBillInformation(Bill bill) {
		billDAO.updateBillInformation(bill) ;
		
	}

	@Override
	@Transactional
	public String getbackToBackurl(String amt, String trnsid, String serviceId,String flag) {
		return billDAO.getbackToBackurl(amt, trnsid, serviceId, flag) ;
	}
//Precise Code
	/*@Override
	@Transactional
	public void saveBackToBackTransaction(String backToBackDetail, String paymentMode) {
		billDAO.saveBackToBackTransaction(backToBackDetail,paymentMode) ;
		
	}
*/
	
	//Grinaar Code
	@Override
	@Transactional
	public void saveBackToBackTransaction(String backToBackDetail, String paymentMode) throws Exception {
		billDAO.saveBackToBackTransaction(backToBackDetail, paymentMode);
	}
	
	
	@Override
	@Transactional
	public Bill getPrintBillDetails(Bill bill) {
		return billDAO.getPrintBillDetails(bill);
		
	}
	@Override
	public void saveCardPaymentDetails(CardPaymentDetails cpd) {
		billDAO.saveCardPaymentDetails(cpd) ;
		
	}
	
	@Override
	public  List<Bill>  getPaymentInfo(String PRN) {
		// TODO Auto-generated method stub
		return billDAO.getPaymentInfo(PRN);
	}

	@Override
	public String getCancelTranscationurl(String trnsid) {
		// TODO Auto-generated method stub
		return billDAO.getCancelTranscationurl(trnsid);
	}
	
	@Override
	public void savePaymentStatus(String tokenid, String certificateType, int certificareYear) {
		billDAO.savePaymentStatus(tokenid,certificateType, certificareYear);
		
	}

	@Override
	public void updateStatusCash(String status, String amt,String token) {
		billDAO.updateStatusCash(status,amt,token);
		
	}
	
	@Override
	public Bill getTransactionDetails(String transactionid) {
		// TODO Auto-generated method stub
		return billDAO.getTransactionDetails(transactionid);
	}
//Precise
/*@Override
	public void updateTransactionDetails(String emitraTransactionFlag, Bill transactionDetails, String trnsid) {
		// TODO Auto-generated method stub
		billDAO.updateTransactionDetails(emitraTransactionFlag, transactionDetails, trnsid) ;
	}*/

//Grinaar
@Override
public void updateTransactionDetails(String emitraTransactionFlag, Bill transactionDetails, String trnsid) throws Exception {
	// TODO Auto-generated method stub
	billDAO.updateTransactionDetails(emitraTransactionFlag, transactionDetails, trnsid) ;
}

	@Override
	public void updateTransactionDetails(String transid) {
		// TODO Auto-generated method stub
		billDAO.updateTransactionDetails(transid) ;
	}

	@Override
	public void saveCancelTranscationurl(String decriptCancelTranscationUrl) {
		billDAO.saveCancelTranscationurl(decriptCancelTranscationUrl) ;
	}

	@Override
	public String getBacktoBacktransactionId(String transid) {
		return billDAO.getBacktoBacktransactionId(transid);
	}
	
	@Override
	public String getcertibackToBackurl(String amt, String trnsid, String serviceId, String flag) {
		return billDAO.getcertibackToBackurl(amt, trnsid, serviceId, flag) ;
	}

	@Override
	public void updatedAmount(double d, int resultAmount,String tid) {
		billDAO.updatedAmount(d,resultAmount,tid);
	}

	@Override
	public LatestVersionDetails versionCheck() {
		return billDAO.versionCheck();
	}


	@Override
	public MachineAuth getMachineAuthenticationDetails(String ssoid) {
		return billDAO.getMachineAuthenticationDetails(ssoid);
		
	}
	@Override
	public void updateDeleteTransactionFlag(String msg, String emitraTransactionId) {
		billDAO.updateDeleteTransactionFlag(msg, emitraTransactionId) ;
		
	}

	@Override
	public void saveMachineAuth(MachineAuth mach, String SSOID, String versionNo) {
		// TODO Auto-generated method stub
		billDAO.saveMachineAuth(mach,SSOID,versionNo);
	}

	@Override
    public boolean insertUntrackedEmitraTransaction(Bill bill) {
        return billDAO.insertUntrackedEmitraTransaction(bill);
    }

	@Override
    public boolean updateUntrackedEmitraTransaction(Bill billDetails) {
        return billDAO.updateUntrackedEmitraTransaction(billDetails);
    }
	
	/*@Override
	public String getBankReferenceNumber(String btbTransactionID) {
		return billDAO.getBankReferenceNumber(btbTransactionID);
	}*/
	
	@Override
	public void accpetMachineAmountDetails(String transid, String totalAmount, String noteValue) {
		billDAO.accpetMachineAmountDetails(transid,totalAmount,noteValue);
	}

	@Override
	public void saveVerifiedData(String verifiedData) {
		billDAO.saveVerifiedData(verifiedData);
	}
	
	

	@Override
	public JSONObject downloadfile(JSONObject json, String registration,
			HttpServletRequest req) throws JSONException, IOException  {
		String certificateurl = (String) json.get("URL");
		String arr[] = certificateurl.split("urlOfPrinting=");
		String directory = System.getProperty( "catalina.base" ) + "\\webapps";
		URL url = new URL(arr[1]);
		directory = directory + File.separator + "certificates";
		File f = new File(directory);
		if(!f.exists()) {
			f.mkdirs();
		}else {
			File allfile[] = f.listFiles();
			for(int i=0;i<allfile.length;i++) {
				if(allfile[i].isFile()) {
					allfile[i].delete();
				}
			}
		}
		
		f = new File(directory + File.separator + registration+"_certificates.pdf");
		if(!f.exists())
			f.createNewFile();
		InputStream in = url.openStream();
		FileOutputStream fos = new FileOutputStream(f);
		int length = -1;
		byte[] buffer = new byte[1024];// buffer for portion of data from connection
		while ((length = in.read(buffer)) > -1) {
		    fos.write(buffer, 0, length);
		}
		fos.close();
		in.close();
		if(f.exists()) {
			directory = "http://localhost:"+req.getLocalPort()+"/KioskService/certificatecontainer.jsp?urlOfPrinting=http://localhost:"+req.getLocalPort()+"/certificates/"+registration+"_certificates.pdf";
		}else {
			json.put("STATUS_CODE", "ApiException");
			json.put("RESPONSE_CODE", "File not down load succesfully");
			json.put("ERROR_MESSAGE", "File not download");
		}
		json.put("URL", directory);
		return json;
	}

}
