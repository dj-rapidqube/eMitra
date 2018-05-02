package dao;

import model.Bill;
import model.CertificateInfo;

public interface CertificateDAO {

	public String insertCertificateDetails(CertificateInfo certiInfo);
	public String getCertificateTransID(String certiInfo);
	 public Bill getCertiPrintBillDetails(Bill bill);
}
