package service;

import model.Bill;
import model.CertificateInfo;

public interface CertificateService {
	public String insertCertificateDetails(CertificateInfo certiInfo);
    public String getCertificateTransID(String certiInfo);
    public Bill getCertiPrintBillDetails(Bill bill);
}
