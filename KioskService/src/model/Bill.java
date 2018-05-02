package model;

public class Bill {

	String name;
	String billAmount;
	String dueDate;
	int serviceProviderID;
	String serviceProviderName;
	String billEmail;
	String discomId;
	String billMobileNo;
	String transactionId;
	int tokenId;

	String transactionDate;
	String rECEIPTNO;
	String tRANSACTIONID;
	String aMT;
	String eMITRATIMESTAMP;
	String tRANSACTIONSTATUS;
	String vERIFYSTATUSCODE;
	String mSG;
	String dEPTNAME;
	String sRVNAME;
	String ssoID;
	String createdDate;
	int yesorno;
	int langCode;
	
	String backToBackTransactionID;
	String backToBackTransactionStatus;
	String paymentMode;
	boolean partpaymentallow;
	String partpaymenttype;
	
	String certiBackToBackTransactionID;
	String certiServiceID;
	String certiSubServiceID;
	String certiServiceName;
	private String consumerKeyValue;

	private String localLogStatus;
	
	
	
	public String getConsumerKeyValue() {
		return consumerKeyValue;
	}

	public void setConsumerKeyValue(String consumerKeyValue) {
		this.consumerKeyValue = consumerKeyValue;
	}

	public boolean isPartpaymentallow() {
		return partpaymentallow;
	}

	public void setPartpaymentallow(boolean partpaymentallow) {
		this.partpaymentallow = partpaymentallow;
	}

	public String getPartpaymenttype() {
		return partpaymenttype;
	}

	public void setPartpaymenttype(String partpaymenttype) {
		this.partpaymenttype = partpaymenttype;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getBackToBackTransactionID() {
		return backToBackTransactionID;
	}

	public void setBackToBackTransactionID(String backToBackTransactionID) {
		this.backToBackTransactionID = backToBackTransactionID;
	}

	public String getBackToBackTransactionStatus() {
		return backToBackTransactionStatus;
	}

	public void setBackToBackTransactionStatus(String backToBackTransactionStatus) {
		this.backToBackTransactionStatus = backToBackTransactionStatus;
	}

	public int getYesorno() {
		return yesorno;
	}

	public void setYesorno(int yesorno) {
		this.yesorno = yesorno;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getSsoID() {
		return ssoID;
	}

	public void setSsoID(String ssoID) {
		this.ssoID = ssoID;
	}

	public String getDiscomId() {
		return discomId;
	}

	public void setDiscomId(String discomId) {
		this.discomId = discomId;
	}

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public String getTranscationDate() {
		return transcationDate;
	}

	public void setTranscationDate(String transcationDate) {
		this.transcationDate = transcationDate;
	}

	String status;
	String billActualAmount;
	String transcationDate;

	public String getBillActualAmount() {
		return billActualAmount;
	}

	public void setBillActualAmount(String billActualAmount) {
		this.billActualAmount = billActualAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getBillEmail() {
		return billEmail;
	}

	public void setBillEmail(String billEmail) {
		this.billEmail = billEmail;
	}

	public String getBillMobileNo() {
		return billMobileNo;
	}

	public void setBillMobileNo(String billMobileNo) {
		this.billMobileNo = billMobileNo;
	}

	public int getServiceProviderID() {
		return serviceProviderID;
	}

	public void setServiceProviderID(int serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getrECEIPTNO() {
		return rECEIPTNO;
	}

	public void setrECEIPTNO(String rECEIPTNO) {
		this.rECEIPTNO = rECEIPTNO;
	}

	public String gettRANSACTIONID() {
		return tRANSACTIONID;
	}

	public void settRANSACTIONID(String tRANSACTIONID) {
		this.tRANSACTIONID = tRANSACTIONID;
	}

	public String getaMT() {
		return aMT;
	}

	public void setaMT(String aMT) {
		this.aMT = aMT;
	}

	public String geteMITRATIMESTAMP() {
		return eMITRATIMESTAMP;
	}

	public void seteMITRATIMESTAMP(String eMITRATIMESTAMP) {
		this.eMITRATIMESTAMP = eMITRATIMESTAMP;
	}

	public String gettRANSACTIONSTATUS() {
		return tRANSACTIONSTATUS;
	}

	public void settRANSACTIONSTATUS(String tRANSACTIONSTATUS) {
		this.tRANSACTIONSTATUS = tRANSACTIONSTATUS;
	}

	public String getvERIFYSTATUSCODE() {
		return vERIFYSTATUSCODE;
	}

	public void setvERIFYSTATUSCODE(String vERIFYSTATUSCODE) {
		this.vERIFYSTATUSCODE = vERIFYSTATUSCODE;
	}

	public String getmSG() {
		return mSG;
	}

	public void setmSG(String mSG) {
		this.mSG = mSG;
	}

	public String getdEPTNAME() {
		return dEPTNAME;
	}

	public void setdEPTNAME(String dEPTNAME) {
		this.dEPTNAME = dEPTNAME;
	}

	public String getsRVNAME() {
		return sRVNAME;
	}

	public void setsRVNAME(String sRVNAME) {
		this.sRVNAME = sRVNAME;
	}

	public int getLangCode() {
		return langCode;
	}

	public void setLangCode(int langCode) {
		this.langCode = langCode;
	}

	public String getCertiBackToBackTransactionID() {
		return certiBackToBackTransactionID;
	}

	public void setCertiBackToBackTransactionID(String certiBackToBackTransactionID) {
		this.certiBackToBackTransactionID = certiBackToBackTransactionID;
	}

	public String getCertiServiceID() {
		return certiServiceID;
	}

	public void setCertiServiceID(String certiServiceID) {
		this.certiServiceID = certiServiceID;
	}

	public String getCertiSubServiceID() {
		return certiSubServiceID;
	}

	public void setCertiSubServiceID(String certiSubServiceID) {
		this.certiSubServiceID = certiSubServiceID;
	}

	public String getCertiServiceName() {
		return certiServiceName;
	}

	public void setCertiServiceName(String certiServiceName) {
		this.certiServiceName = certiServiceName;
	}

	public String getLocalLogStatus() {
        return localLogStatus;
    }

	public void setLocalLogStatus(String localLogStatus) {
        this.localLogStatus = localLogStatus;
    }
}
