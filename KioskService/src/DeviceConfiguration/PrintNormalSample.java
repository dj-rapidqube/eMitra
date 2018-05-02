package DeviceConfiguration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import jpos.*;
import jpos.events.*;
import webServicesRepository.utility.VedioConference;

class MyEvents implements StatusUpdateListener {
	static final Logger logger = Logger.getLogger("Receipt_Printer Events");

	public void statusUpdateOccurred(jpos.events.StatusUpdateEvent e) {
		logger.info("Receipt_Printer status :: "+e.getStatus());
		String machinestatus = "";
		
		switch (e.getStatus()) {
		
		case POSPrinterConst.PTR_SUE_COVER_OK:
			System.out.println("PTR_SUE_COVER_OK");
			break;
		case POSPrinterConst.PTR_SUE_COVER_OPEN:
			System.out.println("PTR_SUE_COVER_OPEN");
			break;
		case POSPrinterConst.PTR_SUE_REC_EMPTY:
			System.out.println("PTR_SUE_REC_EMPTY");
			break;
		case POSPrinterConst.PTR_SUE_REC_NEAREMPTY:
			System.out.println("PTR_SUE_REC_NEAREMPTY");
			break;
		case POSPrinterConst.PTR_SUE_REC_PAPEROK:
			System.out.println("PTR_SUE_REC_PAPEROK");
			break;

		case JposConst.JPOS_SUE_POWER_OFF_OFFLINE:
			System.out.println("JPOS_SUE_POWER_ONLINE");
			machinestatus="Disconnected";
			break;
		case JposConst.JPOS_SUE_POWER_ONLINE:
			System.out.println("JPOS_SUE_POWER_ONLINE");
			machinestatus="Connected";
			break;

		}
		
		// call update the Kiosk heath file
		logger.info("Receipt_Printer KioskHeathFile :: "+machinestatus);
		new VedioConference().updateKioskHeathFile(machinestatus,"Receipt_Printer");
		
	}
}

public class PrintNormalSample {

	public static void main(String args[]) {
		/*
		 * MyEvents evnt = new MyEvents(); POSPrinter ptr = null; ptr = new
		 * POSPrinter(); try { ptr.open("SRP-330"); ptr.claim(0);
		 * ptr.setDeviceEnabled(true); //ptr.addStatusUpdateListener(si);
		 * //ptr.addStatusUpdateListener(this); //ptr.addOutputCompleteListener(this);
		 * //ptr.addErrorListener(this);
		 * 
		 * 
		 * ptr.printBitmap(POSPrinterConst.PTR_S_RECEIPT,
		 * "C:\\BIXOLONJavaPOS\\javapos.bmp", POSPrinterConst.PTR_BM_ASIS,
		 * POSPrinterConst.PTR_BM_CENTER); // CheckHealth
		 * //ptr.checkHealth(JposConst.JPOS_CH_EXTERNAL); // Feed 7 lines
		 * //ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, new String(ESCSquence) +
		 * "7lF");
		 * 
		 * //ptr.checkHealth(JposConst.JPOS_CH_INTERNAL);
		 * ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT,
		 * "---------------------------\r\n"); //ptr.setAsyncMode(true);
		 * //ptr.cutPaper(90);
		 * 
		 * ptr.addStatusUpdateListener(evnt); //ptr.setDeviceEnabled(false); //
		 * ptr.release(); // ptr.close(); // System.exit(0); } catch (JposException e) {
		 * e.printStackTrace(); System.exit(0); }
		 */

	}

	public void statusUpdateOccurred(StatusUpdateEvent e) {
		switch (e.getStatus()) {
		case POSPrinterConst.PTR_SUE_COVER_OK:
			System.out.println("PTR_SUE_COVER_OK");
			break;
		case POSPrinterConst.PTR_SUE_COVER_OPEN:
			System.out.println("PTR_SUE_COVER_OPEN");
			break;
		case POSPrinterConst.PTR_SUE_REC_EMPTY:
			System.out.println("PTR_SUE_REC_EMPTY");
			break;
		case POSPrinterConst.PTR_SUE_REC_NEAREMPTY:
			System.out.println("PTR_SUE_REC_NEAREMPTY");
			break;
		case POSPrinterConst.PTR_SUE_REC_PAPEROK:
			System.out.println("PTR_SUE_REC_PAPEROK");
			break;
		case JposConst.JPOS_SUE_POWER_OFF_OFFLINE:
			System.out.println("JPOS_SUE_POWER_OFF_OFFLINE");
			break;
		case JposConst.JPOS_SUE_POWER_ONLINE:
			System.out.println("JPOS_SUE_POWER_ONLINE");
			break;
		}
	}
}
