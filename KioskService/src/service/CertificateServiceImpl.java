package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CertificateDAO;
import model.Bill;
import model.CertificateInfo;


@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {

	@Autowired
	private CertificateDAO certificateDAO;

	@Override
	public String insertCertificateDetails(CertificateInfo certiInfo) {
		return certificateDAO.insertCertificateDetails(certiInfo);
	}

	@Override
	public String getCertificateTransID(String certiInfo) {
		return certificateDAO.getCertificateTransID(certiInfo);
	}

	@Override
	public Bill getCertiPrintBillDetails(Bill bill) {
		return certificateDAO.getCertiPrintBillDetails(bill);
	}


	


}
