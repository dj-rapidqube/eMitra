package model;

public class Online {
	
	String token;
	String appDetail;
	String loginUser;
	String orderId; 
	String amount;


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppDetail() {
		return appDetail;
	}

	public void setAppDetail(String appDetail) {
		this.appDetail = appDetail;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
}
