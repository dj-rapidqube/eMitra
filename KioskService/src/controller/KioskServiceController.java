package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import CCNET.Answer;
import CCNET.CCNET;
import CCNET.CCNETCommand;
import CCNET.CCNET_Sub_Command;
import CCNET.DEVICE;
import CCNET.IConnection;
import CCNET.PC.sPort;
import Client.ClientExecution;
import finger.rdsample.RDSample;
import locallogs.LocalLogSyncer;
import model.ApplicationStatus;
import model.Bill;
import model.Login;
import model.NoteType;
import model.Online;
import model.PrintReceipt;
import model.TransactionHistory;
import service.BillService;
import service.CertificateService;
import webServicesRepository.utility.EncrptDesryptDataService;
import webServicesRepository.utility.VedioConference;

@EnableWebMvc
@Controller
public class KioskServiceController {
	static final Logger logger = Logger.getLogger(KioskServiceController.class);

	CCNET _ccnet = null;
	Answer answer = null;

	@Autowired
	BillService billService;

	@Autowired
	CertificateService certiService;
	
	@Autowired
    LocalLogSyncer localLogSyncer;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showHomePage() {
		System.out.println("login : "+Login.SSOID+" :: "+Login.SESSIONID+ " :: "+ Login.ISVALID+" :: "+Login.CHECKSUM);
		return "index";
	}

	@RequestMapping("/paymentSuccessful")
	public String showPaymentSuccessful() {
		return "paymentSuccessful";
	}

	@RequestMapping("/paymentSuccessfulHi")
	public String showPaymentSuccessfulHi() {
		return "paymentSuccessfulHi";
	}
	
	@RequestMapping("/paymentError")
	public String showPaymentError() {
		return "paymentError";
	}

	@RequestMapping("/paymentErrorHi")
	public String showPaymentErrorHindi() {
		return "paymentErrorHi";
	}

	
	@RequestMapping("/mitra")
	public String showMitraPage() {
		return "mitra";
	}

	@RequestMapping(value = "/eCardPayment", method = RequestMethod.POST)
	@ResponseBody
	public String applicationVerification(@RequestBody Online online) {
		online.setOrderId("89612345");
		online.setAmount("100");
		online.setLoginUser("Kapil Dev");
		return new ClientExecution().
		/*
		 * postClient(online.getToken(), online.getAppDetail(), online.getLoginUser());
		 */
				postClient(online.getOrderId(), online.getAmount(), online.getLoginUser());

	}

	@RequestMapping(value = "/getStatus", method = RequestMethod.POST)
	@ResponseBody
	public String mgetApplicationsStatusMobile(@RequestBody ApplicationStatus applicationStatus) {
		return new ClientExecution().mgetApplicationsStatusMobile(applicationStatus.getReceiptNumber());
	}

	@RequestMapping(value = "/getTransactionHistory", method = RequestMethod.POST)
	@ResponseBody
	public String getPhedTransactionHistory(@RequestBody TransactionHistory transactionHistory) {
		return new ClientExecution().getPhedTransactionHistory(transactionHistory.getConsumerKey(),
				transactionHistory.getFromDate(), transactionHistory.getToDate(), transactionHistory.getSrvId());
	}

	@RequestMapping(value = "/printRec", method = RequestMethod.POST)
	@ResponseBody
	public String printReceipt(@RequestBody PrintReceipt printReceipt) {
		// URL printLogoPath=
		// getClass().getClassLoader().getResource("/resources/img/javapos.bmp");

		return printReceipt.getPrintData();
	}

	@RequestMapping(value = "/printRec/{finger}", method = RequestMethod.POST)
	@ResponseBody
	public String getFinger(@PathVariable(value = "finger") String finger) {
		RDSample rdSample = new RDSample();
		if (finger.equals("init")) {
			boolean init = rdSample.MyDiscoverRDService("Mantra");
			if (init) {
				// call update the Kiosk heath file
			//	System.out.println("KioskHeathFile Finger_Scanner Machine Status :: SUCCESS");
				logger.info("KioskHeathFile Finger_Scanner Machine Status :: SUCCESS");
				new VedioConference().updateKioskHeathFile("Connected","Finger_Scanner");
				return rdSample.MyFingerCapture();
			} else {
				// call update the Kiosk heath file
			//	System.out.println("KioskHeathFile Finger_Scanner Machine Status :: FAILURE");
				logger.info("KioskHeathFile Finger_Scanner Machine Status :: FAILURE");
				new VedioConference().updateKioskHeathFile("Disconnected","Finger_Scanner");
				return "device is not Recognize";
			}
		}
		return "No data Found";
	}

	@RequestMapping(value = "/swipe/{test}", method = RequestMethod.POST)
	@ResponseBody
	public String swipe(@PathVariable(value = "amt") String amt) {

		int i = InitializeDevice();

		if (i == 0) {
			StartPoll(Integer.parseInt(amt),"1");
		}
		return "No data Found";
	}

	@RequestMapping(value = "/cashAcceptor/{amt}/{token}", method = RequestMethod.POST)
	@ResponseBody
	public String cashAcceptor(@PathVariable(value = "amt") String amt,@PathVariable(value = "token") String token) {
		logger.info("Start CashAccepter Device for collecting TRANSACTION Cash");
		logger.info("cashAcceptor, AMT::"+amt+"token::"+token);
		String msg = null;
		NoteType.depositAmount = Integer.parseInt(amt);
		
		int i = InitializeDevice();
		// System.out.println(i);
		if (i == 0) {
			
			msg = StartPoll(Integer.parseInt(amt),token);
			logger.info("cash accepter result :: "+msg);
			disconnect();
		} else {
			//msg = "cancel"; // testing purpose
			msg = "NoData";
		}

		if(!token.equals("0"))
			billService.updateStatusCash(msg,amt,token);
		if(msg.equals("success"))
			billService.updateTransactionDetails(token);
		
		return msg;
	}

	
	// simple cash accepter method
	/*public void StartPoll(int Amount) {
		try {
			boolean Start = true;
		//	logger.debug("CASH ACCEPT TRANSACTION START");
			logger.info("Application want to Accept Rupees \t" + Amount);
			int NoteValue = 0;
			int TotalAmount = Amount;
			while (Start) {
				answer = _ccnet.RunCommand(CCNETCommand.Poll);
				NoteValue = answer.ReceivedData[4];

				switch (NoteValue) {
				case 1: // 10 rupees
				{

					if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
					{
						logger.info("Hold Fire for 10");
						answer = _ccnet.RunCommand(CCNETCommand.HOLD);
						logger.info("10 Rupee Escrow ");
						logger.info("Hold Command Answer is: " + answer.Message + " TotalAmount : " + TotalAmount);
						if (TotalAmount >= 10) {
							logger.info("Stack Fire");
							answer = _ccnet.RunCommand(CCNETCommand.STACK);
							logger.info("10 Rupee Stacked");
							TotalAmount = TotalAmount - 10;
							// start show note value
							NoteType.total10Note++;
							logger.info("Total10Note value :: " + NoteType.total10Note);
							// end show note value

							logger.info("Stack Command Answer is: " + answer.Message);
							
							answer = _ccnet.RunCommand(CCNETCommand.ACK);

							if (TotalAmount <= 0) {
								logger.info("Pending Amount is Zero");
								Start = false;
								break;
							}
						} else {
							logger.info("Total Amount is less then 10 then Return Fire");
							answer = _ccnet.RunCommand(CCNETCommand.RETURN);
							logger.info("10 Rupee Return");
							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Return Command Answer is: " + answer.Message);
						}
					} 
				}
					break;
				case 2: // 20 rupees
				{
					if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
					{
						logger.info("Hold Fire for 20");
						answer = _ccnet.RunCommand(CCNETCommand.HOLD);
						logger.info("20 Rupee Escrow ");
						logger.info("Hold Command Answer is: " + answer.Message);
						if (TotalAmount >= 20) {
							logger.info("Stack Fire");
							answer = _ccnet.RunCommand(CCNETCommand.STACK);
							logger.info("20 Rupee Stacked");
							TotalAmount = TotalAmount - 20;
							// start show note value
							NoteType.total20Note++;
							logger.info("Total20Note value :: " + NoteType.total20Note);
							// end show note value

							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Stack Command Answer is: " + answer.Message);
							if (TotalAmount <= 0) {
								logger.info("Pending Amount is Zero");
								Start = false;
								break;
							}
						} else {
							logger.info("Total Amount is less then 20 then Return Fire");
							answer = _ccnet.RunCommand(CCNETCommand.RETURN);
							logger.info("20 Rupee Return");
							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Return Command Answer is: " + answer.Message);
						}
					}
				}
					break;
				case 3: // 50 rupees
				{
					if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
					{
						logger.info("Hold Fire for 50");
						answer = _ccnet.RunCommand(CCNETCommand.HOLD);
						logger.info("50 Rupee Escrow ");
						logger.info("Hold Command Answer is: " + answer.Message);
						if (TotalAmount >= 50) {
							logger.info("Stack Fire");
							answer = _ccnet.RunCommand(CCNETCommand.STACK);
							logger.info("50 Rupee Stacked");
							TotalAmount = TotalAmount - 50;
							// start show note value
							NoteType.total50Note++;
							logger.info("Total50Note value :: " + NoteType.total50Note);
							// end show note value

							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Stack Command Answer is: " + answer.Message);
							if (TotalAmount <= 0) {
								logger.info("Pending Amount is Zero");
								Start = false;
								break;
							}
						} else {
							logger.info("Total Amount is less then 50 then Return Fire");
							answer = _ccnet.RunCommand(CCNETCommand.RETURN);
							logger.info("50 Rupee Return");
							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Return Command Answer is: " + answer.Message);
						}
					}
				}
					break;
				case 4: // 100 rupees
				{
					if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
					{
						logger.info("Hold Fire for 100");
						answer = _ccnet.RunCommand(CCNETCommand.HOLD);
						logger.info("100 Rupee Escrow ");
						logger.info("Hold Command Answer is: " + answer.Message);
						if (TotalAmount >= 100) {
							logger.info("Stack Fire");
							answer = _ccnet.RunCommand(CCNETCommand.STACK);
							logger.info("100 Rupee Stacked");
							TotalAmount = TotalAmount - 100;
							// start show note value
							NoteType.total100Note++;
							logger.info("Total100Note value :: " + NoteType.total100Note);
							// end show note value

							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Stack Command Answer is: " + answer.Message);
							if (TotalAmount <= 0) {
								logger.info("Pending Amount is Zero");
								Start = false;
								break;
							}
						} else {
							logger.info("Total Amount is less then 100 then Return Fire");
							answer = _ccnet.RunCommand(CCNETCommand.RETURN);
							logger.info("100 Rupee Return");
							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Return Command Answer is: " + answer.Message);
						}
					}
				}
					break;
				case 6: // 500 rupees
				{
					if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
					{
						logger.info("Hold Fire for 500");
						answer = _ccnet.RunCommand(CCNETCommand.HOLD);
						logger.info("500 Rupee Escrow ");
						logger.info("Hold Command Answer is: " + answer.Message);
						if (TotalAmount >= 500) {
							logger.info("Stack Fire");
							answer = _ccnet.RunCommand(CCNETCommand.STACK);
							logger.info("500 Rupee Stacked");
							TotalAmount = TotalAmount - 500;
							// start show note value
							NoteType.total500Note++;
							logger.info("Total500Note value :: " + NoteType.total500Note);
							// end show note value

							answer = _ccnet.RunCommand(CCNETCommand.ACK);
							logger.info("Stack Command Answer is: " + answer.Message);
							if (TotalAmount <= 0) {
								logger.info("Pending Amount is Zero");
								Start = false;
								break;
							}
						} else {
							logger.info("Total Amount is less then 500 then Return Fire");
							answer = _ccnet.RunCommand(CCNETCommand.RETURN);
							logger.info("500 Rupee Return");
							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Return Command Answer is: " + answer.Message);
						}
					}
				}
					break;
				case 7: // 2000 rupees
				{
					if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
					{
						logger.debug("Hold Fire for 2000");
						answer = _ccnet.RunCommand(CCNETCommand.HOLD);
						logger.info("2000 Rupee Escrow ");
						logger.info("Hold Command Answer is: " + answer.Message);
						if (TotalAmount >= 2000) {
							logger.info("Stack Fire");
							answer = _ccnet.RunCommand(CCNETCommand.STACK);
							logger.info("2000 Rupee Stacked");
							TotalAmount = TotalAmount - 2000;
							// start show note value
							NoteType.total2000Note++;
							logger.info("Total2000Note value :: " + NoteType.total2000Note);
							// end show note value

							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Stack Command Answer is: " + answer.Message);
							if (TotalAmount <= 0) {
								logger.info("Pending Amount is Zero");
								Start = false;
								break;
							}
						} else {
							logger.info("Total Amount is less then 2000 then Return Fire");
							answer = _ccnet.RunCommand(CCNETCommand.RETURN);
							logger.info("2000 Rupee Return");
							answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
							logger.info("Return Command Answer is: " + answer.Message);
						}
					}
				}
					break;
				}

				Thread.sleep(100);

			}
			logger.info("Complete Collecting TRANSACTION CASH");

		} catch (Exception e1) {
			logger.error("Exception in TRANSACTION CASH :" + e1.getMessage());
		}

	}*/

// cash accepter with timer	
	public String StartPoll(int Amount, String tranID) {
		String result = "";
		try {
			boolean Start = true;
		//	logger.debug("CASH ACCEPT TRANSACTION START");
			logger.info("Application want to Accept Rupees \t" + Amount);
			int NoteValue = 0;
			int timeFlag = 0;
			int TotalAmount = Amount;
			NoteType.cashTimer = 30;
			while (Start) {
				
				answer = _ccnet.RunCommand(CCNETCommand.Poll);
			//	System.out.println("answer :: "+answer.ReceivedData);
			//	System.out.println("NoteType.cashTimer : "+NoteType.cashTimer);
				if(NoteType.cashTimer==0) {
					logger.info("Cash Timer is Zero");
				//	System.out.println("Cash Timer is Zero");
					Start = false;
					timeFlag = 1;
					break;
					
				}
			//	System.out.println("answer.ReceivedData : "+answer.ReceivedData[3]+":: "+answer.ReceivedData[2]+" :: "+answer.ReceivedData[1]);
				if(answer.ReceivedData[3]==20) {
					Thread.sleep(1000);
				//	System.out.println("fffddf "+ NoteType.cashTimer);
					NoteType.cashTimer--;
				}else{
					NoteValue = answer.ReceivedData[4];
				
					switch (NoteValue) {
					case 1: // 10 rupees
					{
	
						if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							logger.info("Hold Fire for 10");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							logger.info("10 Rupee Escrow ");
							logger.info("Hold Command Answer is: " + answer.Message + " TotalAmount : " + TotalAmount);
							if (TotalAmount >= 10) {
								logger.info("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								logger.info("10 Rupee Stacked");
								TotalAmount = TotalAmount - 10;
								// start show note value
								NoteType.total10Note++;
								
								// save machine accepted notes details 
								billService.accpetMachineAmountDetails(tranID,String.valueOf(Amount),"10");
								
								logger.info("Total10Note value :: " + NoteType.total10Note);
								// end show note value
								NoteType.cashTimer = 30;
								logger.info("Stack Command Answer is: " + answer.Message);
								
								answer = _ccnet.RunCommand(CCNETCommand.ACK);
	
								if (TotalAmount <= 0) {
									logger.info("Pending Amount is Zero");
									NoteType.cashTimer = 0;
									
									Start = false;
									break;
								}
							} else {
								logger.info("Total Amount is less then 10 then Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								logger.info("10 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Return Command Answer is: " + answer.Message);
							}
						} 
					}
						break;
					case 2: // 20 rupees
					{
						if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							logger.info("Hold Fire for 20");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							logger.info("20 Rupee Escrow ");
							logger.info("Hold Command Answer is: " + answer.Message);
							if (TotalAmount >= 20) {
								logger.info("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								logger.info("20 Rupee Stacked");
								TotalAmount = TotalAmount - 20;
								// start show note value
								NoteType.total20Note++;
								
								// save machine accepted notes details 
								billService.accpetMachineAmountDetails(tranID,String.valueOf(Amount),"20");
								
								logger.info("Total20Note value :: " + NoteType.total20Note);
								// end show note value
								NoteType.cashTimer = 30;
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Stack Command Answer is: " + answer.Message);
								if (TotalAmount <= 0) {
									logger.info("Pending Amount is Zero");
									NoteType.cashTimer = 0;
									Start = false;
									break;
								}
							} else {
								logger.info("Total Amount is less then 20 then Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								logger.info("20 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Return Command Answer is: " + answer.Message);
							}
						}
					}
						break;
					case 3: // 50 rupees
					{
						if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							logger.info("Hold Fire for 50");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							logger.info("50 Rupee Escrow ");
							logger.info("Hold Command Answer is: " + answer.Message);
							if (TotalAmount >= 50) {
								logger.info("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								logger.info("50 Rupee Stacked");
								TotalAmount = TotalAmount - 50;
								// start show note value
								NoteType.total50Note++;
								
								// save machine accepted notes details 
								billService.accpetMachineAmountDetails(tranID,String.valueOf(Amount),"50");
								
								logger.info("Total50Note value :: " + NoteType.total50Note);
								// end show note value
								NoteType.cashTimer = 30;
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Stack Command Answer is: " + answer.Message);
								if (TotalAmount <= 0) {
									logger.info("Pending Amount is Zero");
									NoteType.cashTimer = 0;
									Start = false;
									break;
								}
							} else {
								logger.info("Total Amount is less then 50 then Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								logger.info("50 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Return Command Answer is: " + answer.Message);
							}
						}
					}
						break;
					case 4: // 100 rupees
					{
						if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							logger.info("Hold Fire for 100");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							logger.info("100 Rupee Escrow ");
							logger.info("Hold Command Answer is: " + answer.Message);
							if (TotalAmount >= 100) {
								logger.info("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								logger.info("100 Rupee Stacked");
								TotalAmount = TotalAmount - 100;
								// start show note value
								NoteType.total100Note++;
								
								// save machine accepted notes details 
								billService.accpetMachineAmountDetails(tranID,String.valueOf(Amount),"100");
								
								
								logger.info("Total100Note value :: " + NoteType.total100Note);
								// end show note value
								NoteType.cashTimer = 30;
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Stack Command Answer is: " + answer.Message);
								if (TotalAmount <= 0) {
									logger.info("Pending Amount is Zero");
									NoteType.cashTimer = 0;
									Start = false;
									break;
								}
							} else {
								logger.info("Total Amount is less then 100 then Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								logger.info("100 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Return Command Answer is: " + answer.Message);
							}
						}
					}
						break;
					case 6: // 500 rupees
					{
						if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							logger.info("Hold Fire for 500");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							logger.info("500 Rupee Escrow ");
							logger.info("Hold Command Answer is: " + answer.Message);
							if (TotalAmount >= 500) {
								logger.info("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								logger.info("500 Rupee Stacked");
								TotalAmount = TotalAmount - 500;
								// start show note value
								NoteType.total500Note++;
								
								// save machine accepted notes details 
								billService.accpetMachineAmountDetails(tranID,String.valueOf(Amount),"500");
								
								
								logger.info("Total500Note value :: " + NoteType.total500Note);
								// end show note value
								NoteType.cashTimer = 30;
								answer = _ccnet.RunCommand(CCNETCommand.ACK);
								logger.info("Stack Command Answer is: " + answer.Message);
								if (TotalAmount <= 0) {
									logger.info("Pending Amount is Zero");
									NoteType.cashTimer = 0;
									Start = false;
									break;
								}
							} else {
								logger.info("Total Amount is less then 500 then Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								logger.info("500 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Return Command Answer is: " + answer.Message);
							}
						}
					}
						break;
					case 7: // 2000 rupees
					{
						if (answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							logger.debug("Hold Fire for 2000");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							logger.info("2000 Rupee Escrow ");
							logger.info("Hold Command Answer is: " + answer.Message);
							if (TotalAmount >= 2000) {
								logger.info("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								logger.info("2000 Rupee Stacked");
								TotalAmount = TotalAmount - 2000;
								// start show note value
								NoteType.total2000Note++;

								
								// save machine accepted notes details 
								billService.accpetMachineAmountDetails(tranID,String.valueOf(Amount),"2000");
								
								
								logger.info("Total2000Note value :: " + NoteType.total2000Note);
								// end show note value
								NoteType.cashTimer = 30;
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Stack Command Answer is: " + answer.Message);
								if (TotalAmount <= 0) {
									logger.info("Pending Amount is Zero");
									NoteType.cashTimer = 0;
									Start = false;
									break;
								}
							} else {
								logger.info("Total Amount is less then 2000 then Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								logger.info("2000 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);// Amit
								logger.info("Return Command Answer is: " + answer.Message);
							}
						}
					}
						break;
					}
				}
				
				Thread.sleep(100);
			
			}
			
			//logger.info(" timeFlag:: "+ timeFlag);

			//System.out.println(" timeFlag:: "+ timeFlag);
			
			if(timeFlag==1)
				result = "cancel";
			else
				result = "success";
		//	System.out.println("result "+ result);
			
			logger.info("Complete Collecting TRANSACTION CASH , timeFlag::"+ timeFlag+" result "+ result);

		} catch (Exception e1) {
			result = "cancel";
			logger.error("Exception in TRANSACTION CASH :" + e1.getMessage());
		}

		return result;
	}
	
	
	public int InitializeDevice() {
		int x = 0;
		String machinestatus = "";
		try {
			logger.info("Initialize Cash Acceptor");
			IConnection comPort = new sPort();
			comPort.setPath("COM2");
			comPort.setBaudRate(9600);
		//	System.out.println("DEVICE.Bill_Validator called");
			_ccnet = new CCNET(DEVICE.Bill_Validator, comPort);
			// evt = new MyEvents();
			// _ccnet.addEventListener(evt);

			logger.info("Reset Acceptor");
			answer = _ccnet.RunCommand(CCNETCommand.RESET);

			logger.debug("Reset Answer is:" + answer.Message);

			logger.debug("Poll Called");
			answer = _ccnet.RunCommand(CCNETCommand.Poll);
			logger.debug("Poll Answer is:" + answer.Message);
			logger.debug("ACK Called");
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			logger.debug("ACK Answer is:" + answer.Message);
			logger.debug("Get Status Called");
			answer = _ccnet.RunCommand(CCNETCommand.GET_STATUS);
			logger.debug("Get Status Answer is:" + answer.Message);
			
			answer = _ccnet.RunCommand(CCNETCommand.Poll);
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			logger.debug("Device Identification Called ");
			answer = _ccnet.RunCommand(CCNETCommand.IDENTIFICATION);
			
			if(CCNETCommand.IDENTIFICATION!=null) 
				machinestatus = "Connected";
			else 
				machinestatus = "Disconnected";
			
			logger.debug("Device Identification Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			logger.debug("Set Security Called");
			answer = _ccnet.RunCommand(CCNETCommand.SET_SECURITY);
			logger.debug("Set Security Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			logger.debug("Get Status Called");
			answer = _ccnet.RunCommand(CCNETCommand.GET_STATUS);
			logger.debug("Get Status Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			logger.debug("Get Bill Table Called");
			answer = _ccnet.RunCommand(CCNETCommand.GET_BILL_TABLE);
			logger.debug("Get Bill Table Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			logger.debug("Get Status Called");
			answer = _ccnet.RunCommand(CCNETCommand.GET_STATUS);
			logger.debug("Get Status Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);
			answer = _ccnet.RunCommand(CCNETCommand.ACK);

			logger.debug("Enable Bill Types Called");
			answer = _ccnet.RunCommand(CCNETCommand.ENABLE_BILL_TYPES,
					CCNET_Sub_Command.ENABLE_BILL_TYPES_to_escrow_mode);
						
			// call update the Kiosk heath file
		//	System.out.println("KioskHeathFile Cash_Acceptor Machine Status :: "+machinestatus);
			logger.info("KioskHeathFile Cash_Acceptor Machine Status :: "+machinestatus);
			new VedioConference().updateKioskHeathFile(machinestatus,"Cash_Acceptor");
			
		} catch (Exception e) {
			logger.error("Exception in Initialize Cash Acceptor :" + e.getMessage());
			x = 1;
		}

		return x;
	}

	public void disconnect() {
	     _ccnet = null;
	     logger.info("Disconnect Cash Acceptor");
	 }
	
	@RequestMapping("/paymentSuccess")
	public ModelAndView paymentSuccess(HttpServletRequest req, Bill bill) {
		List<Bill> details = new ArrayList<Bill>();
		logger.info("PaymentSuccess, TransactionId::" + bill.getTransactionId()+" serviceId :"+bill.getServiceProviderID()+ "  transid : "+bill.getTransactionId());
		Bill printBill = billService.getPrintBillDetails(bill);
		
		/*billService.updateTransactionDetails(bill.getTransactionId());
		
		details.add(printBill);

		req.setAttribute("details", details);
		req.setAttribute("tdate", printBill.getTransactionDate());
		req.setAttribute("tid", bill.getTransactionId());
		req.setAttribute("receipt", bill.getrECEIPTNO());
*/		
		billService.updateTransactionDetails(bill.getTransactionId());
		String backToBackTransactionID = billService.getBacktoBacktransactionId(bill.getTransactionId());
		details.add(printBill);
		//String bankRefNumber = 	billService.getBankReferenceNumber(backToBackTransactionID);
		req.setAttribute("bankRefNumber", "");
		req.setAttribute("details", details);
		req.setAttribute("tdate", printBill.getTransactionDate());
		req.setAttribute("tid", backToBackTransactionID);
		req.setAttribute("receipt", bill.getrECEIPTNO());
		if(bill.getLangCode()==0)
			return new ModelAndView("paymentSuccessful");
		else
			return new ModelAndView("paymentSuccessfulHi");

	}
//Precise Code
/*	@RequestMapping(value = "/backtoback/{amt}/{trnsid}/{serviceId}", method = RequestMethod.POST)
	@ResponseBody
	public String backToBackTrans(@PathVariable(value = "amt") String amt,
			@PathVariable(value = "trnsid") String trnsid, @PathVariable(value = "serviceId") String serviceId) {
		logger.info("backToBackTrans, trnsid :"+trnsid+ "amount :"+amt+"service id::"+ serviceId);
		String transstatus = null;
		String emitraTransactionFlag="";
		Bill transactionDetails;

		if (trnsid != null) {

			String backToBackurl = billService.getbackToBackurl(amt, trnsid, serviceId,"cash");
			logger.info("backToBackTrans, BackToBackurl :"+backToBackurl);

			EncrptDesryptDataService eds = new EncrptDesryptDataService();
			String encriptBackTOBackUrl = null;
			try {
				encriptBackTOBackUrl = eds.sendPostForEncryptData(backToBackurl);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("backToBackTrans, encriptBackTOBackUrl :"+encriptBackTOBackUrl);
			String backtoBackUrl = null;
			try {
				backtoBackUrl = eds.sendPostForBacktoBack(encriptBackTOBackUrl);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			logger.info("backToBackTrans, backtoBackUrl :"+backtoBackUrl);
			String decriptBackTOBackUrl = null;
			try {
				decriptBackTOBackUrl = eds.sendPostForDecryptData(backtoBackUrl);
				JSONParser parser = new JSONParser();
		        JSONObject json;
		        json = (JSONObject) parser.parse(decriptBackTOBackUrl);
                transstatus=(String)json.get("TRANSACTIONSTATUS");
                if(transstatus.equalsIgnoreCase("SUCCESS"))
                	transstatus = transstatus+"##"+(String) json.get("TRANSACTIONID");
                
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("backToBackTrans, decriptBackTOBackUrl :"+decriptBackTOBackUrl);
            billService.saveBackToBackTransaction(decriptBackTOBackUrl,"CASH");
			
			transactionDetails = billService.getTransactionDetails(trnsid);
			
			if(transactionDetails.getBackToBackTransactionStatus().equalsIgnoreCase("success"))
			    emitraTransactionFlag = "1";
			else if(transactionDetails.getBackToBackTransactionStatus().equalsIgnoreCase("failure"))
				emitraTransactionFlag = "0";
			
			billService.updateTransactionDetails(emitraTransactionFlag, transactionDetails, trnsid);
			logger.info("backToBackTrans, Transaction Status :"+backtoBackUrl);

		}
		return transstatus;

	}
*/
	//Grinaar CODE
	
	 @RequestMapping(value = "/backtoback/{amt}/{trnsid}/{serviceId}", method = RequestMethod.POST)
	    @ResponseBody
	    public String backToBackTrans(@PathVariable(value = "amt") String amt,
	            @PathVariable(value = "trnsid") String transactionId,
	            @PathVariable(value = "serviceId") String serviceId) throws Exception {
	        logger.info("backToBackTrans, trnsid :" + transactionId + "amount :" + amt + "service id::" + serviceId);

	        if (StringUtils.isBlank(transactionId)) {
	            logger.error("TransactionId is empty.");
	            return null;
	        }

	        String returnStatusStr = null;
	        try {
	            String backToBackurl = billService.getbackToBackurl(amt, transactionId, serviceId, "cash");
	            logger.info("backToBackTrans, BackToBackurl :" + backToBackurl);

	            EncrptDesryptDataService eds = new EncrptDesryptDataService();

	            String encryptedBackTOBackUrl = eds.sendPostForEncryptData(backToBackurl);
	            logger.info("backToBackTrans, encriptBackTOBackUrl :" + encryptedBackTOBackUrl);

	            String encryptedResponse = eds.sendPostForBacktoBack(encryptedBackTOBackUrl);
	            logger.info("backToBackTrans, backtoBackUrl :" + encryptedResponse);

	            String decryptedResponse = eds.sendPostForDecryptData(encryptedResponse);
	            logger.info("backToBackTrans, decriptBackTOBackUrl :" + decryptedResponse);

	            // Assuming the fact that if we get SUCCESS & TRANSACTIONID in the response
	            // It was a successful transaction at emitra's end and we would need to
	            // track this in our system OR if we fail to do so, we'll revert it.
	            org.json.JSONObject json = new org.json.JSONObject(decryptedResponse);
	            String transactionStatus = json.optString("TRANSACTIONSTATUS");
	            String emitraTransactionId = json.optString("TRANSACTIONID");
	            
	            if (transactionStatus.equalsIgnoreCase("SUCCESS")) 
	                returnStatusStr = transactionStatus + "##" + emitraTransactionId;
	            else
	            	returnStatusStr = transactionStatus+ "##" +(String) json.get("MSG");
	            
	            try {
	                billService.saveBackToBackTransaction(decryptedResponse, "CASH");
	                // transactionDetails = billService.getTransactionDetails(transactionId);

	                Bill transactionDetails = new Bill();
	                transactionDetails.setBackToBackTransactionID(emitraTransactionId);
	                transactionDetails.setBackToBackTransactionStatus(transactionStatus);

	                String emitraTransactionFlag = "";
	                
	                if (transactionStatus.equalsIgnoreCase("SUCCESS")) 
	                    emitraTransactionFlag = "1";
	                else
	                    emitraTransactionFlag = "0";
	                

	                billService.updateTransactionDetails(emitraTransactionFlag, transactionDetails, transactionId);
	                logger.info("backToBackTrans, Transaction Status :" + encryptedResponse);
	            } catch (Exception inEx) {
	                logger.error("Caught an exception while inserting backToBack transaction details in the DB for transactionId: " + transactionId, inEx);

	                if (transactionStatus.equalsIgnoreCase("SUCCESS")) {
	                    localLogSyncer.writeToLocalLogs(emitraTransactionId, transactionId, serviceId, amt);
	                }
	                String message = "There was some updating the Emitra+ DB, Please try again after some-time.";
	                returnStatusStr = "FAILURE##" + message;
	            }

	        } catch (Exception ex) {
	            logger.error("Caught an exception while processing emitra backToBackTransaction for transactionId: " + transactionId, ex);

	            String message = "There was error while getting data from Emitra, Please try again after some-time.";
	            returnStatusStr = "FAILURE##" + message;
	        }

	        return returnStatusStr;
	    }
	
	
	@RequestMapping(value = "/verifyTransaction/{requestid}/{serviceid}", method = RequestMethod.POST)
	@ResponseBody
	public String verifyTransaction(@PathVariable(value = "requestid") String requestID,
			@PathVariable(value = "serviceid") String serviceID) {
		String ssoToken = "0";
		logger.info("verifyTransaction, requestID :" + requestID + " ,serviceID::" + serviceID);
		String verifyStatus = null;
		if (requestID != null && serviceID != null) {

			String checkSumURL = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + requestID + "\",\"SSOTOKEN\":\""
					+ ssoToken + "\"}";
			logger.info("verifyTransaction, checksumurl :" + checkSumURL);

			EncrptDesryptDataService eds = new EncrptDesryptDataService();
			String checkSum = eds.getCheckSUM(checkSumURL);
			logger.info("verifyTransaction, checkSum :" + checkSum);
			String toBeEncrypt = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + requestID + "\",\"SERVICEID\":\""
					+ serviceID + "\",\"CHECKSUM\":\"" + checkSum + "\",\"SSOTOKEN\":\"" + ssoToken + "\"}";

			String encriptVerifyString = null;
			try {
				encriptVerifyString = eds.sendPostForEncryptData(toBeEncrypt);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("verifyTransaction, encriptVerifyString :" + encriptVerifyString);

			String verifyTransactionResponse = null;
			try {
				verifyTransactionResponse = eds.sendPostForVerifyTranscation(encriptVerifyString);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("verifyTransaction, verifyTransactionResponse :" + verifyTransactionResponse);

			String decriptVerifyTransactionResponse = null;
			try {
				decriptVerifyTransactionResponse = eds.sendPostForDecryptData(verifyTransactionResponse);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("verifyTransaction, decriptVerifyTransactionResponse :" + decriptVerifyTransactionResponse);
			billService.saveVerifiedData(decriptVerifyTransactionResponse);
		}
		return verifyStatus;
	}
	
	@RequestMapping(value = "/cancelTranscation/{emitraTransactionId}", method = RequestMethod.POST)
	@ResponseBody
	public String cancelTranscation(@PathVariable(value = "emitraTransactionId") String emitraTransactionId) {
		
		logger.info("cancelTranscation, emitraTransactionId :"+emitraTransactionId);
		String cancelStatus = null;
		if (emitraTransactionId != null) {

			String cancelTranscationurl = billService.getCancelTranscationurl(emitraTransactionId);
			logger.info("cancelTranscation, cancelTranscationurl :"+cancelTranscationurl);

			EncrptDesryptDataService eds = new EncrptDesryptDataService();
			String encriptCancelTranscationUrl = null;
			try {
				encriptCancelTranscationUrl = eds.sendPostForEncryptData(cancelTranscationurl);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("cancelTranscation, encriptBackTOBackUrl :"+encriptCancelTranscationUrl);
			String cancelTranscationResponse = null;
			try {
				cancelTranscationResponse = eds.sendPostForCancelTranscation(encriptCancelTranscationUrl);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			logger.info("cancelTranscation, cancelTranscationResponse :"+cancelTranscationResponse);
			String decriptCancelTranscationUrl = null;
			try {
				decriptCancelTranscationUrl = eds.sendPostForDecryptData(cancelTranscationResponse);
				logger.info("cancelTranscation, decriptCancelTranscationUrl :"+decriptCancelTranscationUrl);
			//	System.out.println("cancelTranscation, decriptCancelTranscationUrl :"+decriptCancelTranscationUrl);
				
				if(decriptCancelTranscationUrl!=null && !decriptCancelTranscationUrl.equals("")) {
			        billService.saveCancelTranscationurl(decriptCancelTranscationUrl);
			        JSONParser parser = new JSONParser();
			        JSONObject json;
			        json = (JSONObject) parser.parse(decriptCancelTranscationUrl);
			        String  CANCELSTATUS= (String)json.get("CANCELSTATUS");
			        if(CANCELSTATUS.equalsIgnoreCase("SUCCESS"))
			        	billService.updateDeleteTransactionFlag("Yes", emitraTransactionId);
	
				}
		        
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("cancelTranscation, decriptCancelTranscationUrl :"+decriptCancelTranscationUrl);
		
		}
		return cancelStatus;

	}
	//Precise Code
	
	/*@RequestMapping(value = "/certificatebacktoback/{amt}/{transid}/{serviceID}", method = RequestMethod.POST)
	@ResponseBody
	public String certificateBackToBackTrans(@PathVariable(value = "amt") String amt,
			@PathVariable(value = "transid") String transid, @PathVariable(value = "serviceID") String serviceID) {
		logger.info("certificateBackToBackTrans, trnsid :"+transid+ "amount :"+amt+"service id::"+ serviceID);
		String transstatus = null;
		String emitraTransactionFlag="";
		Bill transactionDetails;

		if (transid != null) {

			String backToBackurl = billService.getcertibackToBackurl(amt, transid, serviceID,"cash");
			logger.info("certificateBackToBackTrans, BackToBackurl :"+backToBackurl);

			EncrptDesryptDataService eds = new EncrptDesryptDataService();
			String encriptBackTOBackUrl = null;
			try {
				encriptBackTOBackUrl = eds.sendPostForEncryptData(backToBackurl);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("certificateBackToBackTrans, encriptBackTOBackUrl :"+encriptBackTOBackUrl);
			String backtoBackUrl = null;
			try {
				backtoBackUrl = eds.sendPostForBacktoBack(encriptBackTOBackUrl);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			logger.info("certificateBackToBackTrans, backtoBackUrl :"+backtoBackUrl);
			String decriptBackTOBackUrl = null;
			try {
				decriptBackTOBackUrl = eds.sendPostForDecryptData(backtoBackUrl);
				JSONParser parser = new JSONParser();
		        JSONObject json;
		        json = (JSONObject) parser.parse(decriptBackTOBackUrl);
                transstatus=(String)json.get("TRANSACTIONSTATUS");
                if(transstatus.equalsIgnoreCase("SUCCESS"))
                	transstatus = transstatus+"##"+(String) json.get("TRANSACTIONID");
                
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("certificateBackToBackTrans, decriptBackTOBackUrl :"+decriptBackTOBackUrl);
            billService.saveBackToBackTransaction(decriptBackTOBackUrl,"CASH");
			
			transactionDetails = billService.getTransactionDetails(transid);
			
			if(transactionDetails.getBackToBackTransactionStatus().equalsIgnoreCase("success")) {
			    emitraTransactionFlag = "1";
			   // billService.updateTransactionDetails(transid);
			}
			else if(transactionDetails.getBackToBackTransactionStatus().equalsIgnoreCase("failure"))
				emitraTransactionFlag = "0";
			
			billService.updateTransactionDetails(emitraTransactionFlag, transactionDetails, transid);
			
			
			logger.info("certificateBackToBackTrans, Transaction Status :"+backtoBackUrl);

		}
		return transstatus;

	}
*/
	//Grinnar Developer Code
	
	
	@RequestMapping(value = "/certificatebacktoback/{amt}/{transid}/{serviceID}", method = RequestMethod.POST)
    @ResponseBody
    public String certificateBackToBackTrans(@PathVariable(value = "amt") String amt,
            @PathVariable(value = "transid") String transactionId, @PathVariable(value = "serviceID") String serviceID) {
        logger.info("certificateBackToBackTrans, trnsid :" + transactionId + "amount :" + amt + "service id::" + serviceID);

        if (StringUtils.isBlank(transactionId)) {
            logger.error("TransactionId is null or empty.");
            return null;
        }

        String returnStatusStr = null; 
        try {
            String backToBackurl = billService.getcertibackToBackurl(amt, transactionId, serviceID, "cash");
            logger.info("certificateBackToBackTrans, BackToBackurl :" + backToBackurl);

            EncrptDesryptDataService eds = new EncrptDesryptDataService();

            String encryptedB2BUrl = eds.sendPostForEncryptData(backToBackurl);
            logger.info("certificateBackToBackTrans, encryptedBackTOBackUrl :" + encryptedB2BUrl);

            String backtoBackResponse = eds.sendPostForBacktoBack(encryptedB2BUrl);
            logger.info("certificateBackToBackTrans, backtoBackResponse :" + backtoBackResponse);

            String decryptB2BResponse = eds.sendPostForDecryptData(backtoBackResponse);
            logger.info("certificateBackToBackTrans, decriptBackTOBackUrl :" + decryptB2BResponse);

            org.json.JSONObject json = new org.json.JSONObject(decryptB2BResponse);

            String transactionStatus = json.optString("TRANSACTIONSTATUS");
            String emitraTransactionId = json.optString("TRANSACTIONID");
            
            if (transactionStatus.equalsIgnoreCase("SUCCESS")) 
                returnStatusStr = transactionStatus + "##" + emitraTransactionId;
            else
            	returnStatusStr = transactionStatus+ "##" +(String) json.get("MSG");

            try {
                billService.saveBackToBackTransaction(decryptB2BResponse, "CASH");

//                transactionDetails = billService.getTransactionDetails(transactionId);
                Bill transactionDetails = new Bill();
                transactionDetails.setBackToBackTransactionID(emitraTransactionId);
                transactionDetails.setBackToBackTransactionStatus(transactionStatus);

                String emitraTransactionFlag = "";
                
                if (transactionStatus.equalsIgnoreCase("SUCCESS")) 
                    emitraTransactionFlag = "1";
                else
                    emitraTransactionFlag = "0";
                

                billService.updateTransactionDetails(emitraTransactionFlag, transactionDetails, transactionId);
                logger.info("certificateBackToBackTrans, Transaction Status :" + backtoBackResponse);
            } catch (Exception ex) {
                logger.error("Caught an exception while inserting certificateBackToBack transaction details in the DB for transactionId: " + transactionId, ex);

                if (transactionStatus.equalsIgnoreCase("SUCCESS")) {
                    localLogSyncer.writeToLocalLogs(emitraTransactionId, transactionId, serviceID, amt);
                }
                
                String message = "There was some updating the Emitra+ DB, Please try again after some-time.";
                returnStatusStr = "FAILURE##" + message;
            }

        } catch (Exception ex) {
            logger.error("Caught an exception while processing emitra certificateBackToBackTransaction for transactionId: " + transactionId, ex);
            
            String message = "There was error while getting data from Emitra, Please try again after some-time.";
            returnStatusStr = "FAILURE##" + message;
        }

        return returnStatusStr;
    }

	
	
	
	
	
	
	
	@RequestMapping("/certiPaymentSuccess")
	public ModelAndView certiPaymentSuccess(HttpServletRequest req, Bill bill) {
		List<Bill> certiDetails = new ArrayList<Bill>();
		logger.info("certiPaymentSuccess, TransactionId::" + bill.getTransactionId()+" serviceId :"+bill.getServiceProviderID()+ "  transid : "+bill.getTransactionId());
		Bill printBill = certiService.getCertiPrintBillDetails(bill);
		printBill.setBillActualAmount(bill.getBillAmount());
		printBill.setName("");
		printBill.setBillEmail("");
		printBill.setDueDate("");
		printBill.setServiceProviderName(bill.getCertiServiceName());
		billService.updateTransactionDetails(bill.getTransactionId());
		certiDetails.add(printBill);
		req.setAttribute("details", certiDetails);
		req.setAttribute("serviceID", bill.getServiceProviderID());
		req.setAttribute("tdate", printBill.getTransactionDate());
		req.setAttribute("tid", printBill.getCertiBackToBackTransactionID());
		req.setAttribute("receipt", printBill.getrECEIPTNO());
		if(bill.getLangCode()==0)
			return new ModelAndView("CertiPaymentSuccessful");
		else
			return new ModelAndView("CertiPaymentSuccessfulHi");

	}
	
	@RequestMapping(value = "/CashMachineAmount/{amount}/{paymentType}/{tid}", method = RequestMethod.POST)
	@ResponseBody
	public String getCashMachineAmount(@PathVariable(value = "amount") String amount,@PathVariable(value = "paymentType") String paymentType,@PathVariable(value = "tid") String tid, HttpServletRequest req) {
		logger.info("paymentType : "+paymentType+" udpateAmount : "+amount+" tid: "+tid);
		int resultAmount =0;
		double d = Double.parseDouble(amount);
		resultAmount = new EncrptDesryptDataService().getCashMachineAmount(d);
	//	System.out.println("csddddddddddddddddddd:::::::::::::"+tid);
		billService.updatedAmount(d,resultAmount,tid);
		return resultAmount+"";
		
	}
	
	
	
	@ResponseBody
    @RequestMapping(value = "/cancelTranscationLLSyncer/{transactionId}/{requestId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> cancelTranscationLLSyncer(@PathVariable(value = "transactionId") String transactionId,
            @PathVariable(value = "requestId") String requestId) {

        try {
            logger.info("cancelTranscationLLSyncer, transactionId: " + transactionId + ", requestId: " + requestId);

            EncrptDesryptDataService eds = new EncrptDesryptDataService();
            String checksumurl = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + requestId
                    + "\",\"SSOTOKEN\":\"0\"}";
            logger.info("cancelTranscationLLSyncer, checkSUMURL" + checksumurl);
            String checksum = eds.sendPostCheckSum(checksumurl);

            String cancelTranscationUrl = "{\"MERCHANTCODE\":\"EMITRAPLUS\",\"REQUESTID\":\"" + requestId + "\","
                    + "\"EMITRATOKEN\":\"" + transactionId + "\",\"CANCELREMARK\":\"Cash Not Received\","
                    + "\"ENTITYTYPEID\":\"4\"," + "\"SSOTOKEN\":\"0\",\"CHECKSUM\":\"" + checksum + "\" }";

            logger.info("cancelTranscationLLSyncer, cancelTranscationUrl :" + cancelTranscationUrl);

            String encryptedCTUrl = eds.sendPostForEncryptData(cancelTranscationUrl);
            logger.info("cancelTranscationLLSyncer, encryptedCTUrl :" + encryptedCTUrl);

            String encryptedCTResponse = eds.sendPostForCancelTranscation(encryptedCTUrl);
            logger.info("cancelTranscationLLSyncer, encryptedCTResponse :" + encryptedCTResponse);

            String dencryptedCTResponse = eds.sendPostForDecryptData(encryptedCTResponse);
            logger.info("cancelTranscationLLSyncer, dencryptedCTResponse :" + dencryptedCTResponse);

            if (StringUtils.isNotBlank(dencryptedCTResponse)) {
                org.json.JSONObject jsonObj = new org.json.JSONObject(dencryptedCTResponse);

                int status = Integer.valueOf(jsonObj.optString("CANCELSTATUSCODE"));
                if(status >= HttpStatus.OK.value() && status < HttpStatus.BAD_REQUEST.value()) {
                    return ResponseEntity.ok(dencryptedCTResponse);
                }
            }
        } catch (Exception ex) {
            logger.error("Caught an exception while cancelling transactionId: " + transactionId, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        // assuming the fact that the transactionID & requestId are Invalid
        return ResponseEntity.badRequest().build();
    }
	
	

}
