package model;

import org.springframework.stereotype.Component;

@Component
public class Login {
	public static String SSOID;
	public static String SESSIONID;
	public static boolean ISVALID;
	public static String CHECKSUM;
	public static String MACHINEIPADDRESS;
	
	public void setMACHINEIPADDRESS(String mACHINEIPADDRESS) {
		MACHINEIPADDRESS = mACHINEIPADDRESS;
	}

	public void setSSOID(String sSOID) {
		SSOID = sSOID;
	}
	
	public void setSESSIONID(String sESSIONID) {
		SESSIONID = sESSIONID;
	}
	
	
	public void setISVALID(boolean iSVALID) {
		ISVALID = iSVALID;
	}
	
	public void setCHECKSUM(String cHECKSUM) {
		CHECKSUM = cHECKSUM;
	}
	

}
