package webServicesRepository.utility;

import CCNET.Answer;
import CCNET.CCNET;
import CCNET.CCNETCommand;
import CCNET.CCNET_Sub_Command;
import CCNET.DEVICE;
import CCNET.IConnection;
import CCNET.PC.sPort;

public class DeviceInfo {
	
	public static CCNET _ccnet = null;
	public static  Answer answer = null;
	public static int totalAmount = 0;
	
	 public static void main(String[] args) {
		totalAmount= 30;
		int i =InitializeDevice();
		//System.out.println(i);
		if(i == 0)
		{
			StartPoll(totalAmount);
		}else {
		}
	}
	 
	 /*
	  public static void StartPoll(int Amount)
	{
		try 
		{
			boolean Start = true;
			System.out.println("CASH ACCEPT TRANSACTION START");
			System.out.println("Application want to Accept Rupees \t" + Amount);
			int NoteValue = 0;
			int TotalAmount = Amount;
			while(Start)
			{				
				answer = _ccnet.RunCommand(CCNETCommand.Poll);				 
				NoteValue = answer.ReceivedData[4];
				System.out.println("event status :: "+answer.ReceivedData[3]);
				switch(NoteValue)
				{
					case 1: // 10 rupees
					{
						if(answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							System.out.println("Hold Fire");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							System.out.println("10 Rupee Escrow ");
							System.out.println("Hold Command Answer is: "+ answer.Message);
							if(TotalAmount >= 10)
							{
								TotalAmount = TotalAmount - 10;
								System.out.println("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								/*if(answer.ReceivedData[3] == 0x81) {
									TotalAmount = TotalAmount - 20;
								}
								System.out.println("10 Rupee Stacked");
								System.out.println("Stack Command Answer is: "+ answer.Message);
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								if(TotalAmount <= 0) {
									System.out.println("Pending Amount is Zero");
									Start = false;
									break;
								}
							}
							else {
								System.out.println("Total Amount is less then 10");
								System.out.println("Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								System.out.println("10 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Return Command Answer is: "+ answer.Message);
							}
						}
					}
					break;
					case 2: // 20 rupees
					{
						if(answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							System.out.println("Hold Fire");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							System.out.println("20 Rupee Escrow ");
							System.out.println("Hold Command Answer is: "+ answer.Message);
							if(TotalAmount >= 20)
							{
								System.out.println("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								if(answer.ReceivedData[3] == 0x81) {
									TotalAmount = TotalAmount - 20;
								}
								System.out.println("20 Rupee Stacked");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Stack Command Answer is: "+ answer.Message);
								if(TotalAmount <= 0)
								{
									System.out.println("Pending Amount is Zero");
									Start = false;
									break;
								}
							}
							else
							{
								System.out.println("Total Amount is less then 20");
								System.out.println("Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								System.out.println("20 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Return Command Answer is: "+ answer.Message);
							}	
						}
					}
					break;
					case 3: // 50 rupees
					{
						if(answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							System.out.println("Hold Fire");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							System.out.println("50 Rupee Escrow ");
							System.out.println("Hold Command Answer is: "+ answer.Message);
							if(TotalAmount >= 50)
							{
								TotalAmount = TotalAmount - 50;
								System.out.println("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								System.out.println("50 Rupee Stacked");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Stack Command Answer is: "+ answer.Message);
								if(TotalAmount <= 0)
								{
									System.out.println("Pending Amount is Zero");
									Start = false;
									break;
								}
							}
							else
							{
								System.out.println("Total Amount is less then 50");
								System.out.println("Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								System.out.println("50 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Return Command Answer is: "+ answer.Message);
							}
						}
					}
					break;
					case 4: // 100 rupees
					{
						if(answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							System.out.println("Hold Fire");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							System.out.println("100 Rupee Escrow ");
							System.out.println("Hold Command Answer is: "+ answer.Message);
							if(TotalAmount >= 100)
							{
								TotalAmount = TotalAmount - 100;
								System.out.println("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								System.out.println("100 Rupee Stacked");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Stack Command Answer is: "+ answer.Message);
								if(TotalAmount <= 0)
								{
									System.out.println("Pending Amount is Zero");
									Start = false;
									break;
								}
							}
							else
							{
								System.out.println("Total Amount is less then 100");
								System.out.println("Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								System.out.println("100 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Return Command Answer is: "+ answer.Message);
							}
						}
					}
					break;
					case 5: // 500 rupees
					{	
						if(answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							System.out.println("Hold Fire");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							System.out.println("500 Rupee Escrow ");
							System.out.println("Hold Command Answer is: "+ answer.Message);
							if(TotalAmount >= 500)
							{
								TotalAmount = TotalAmount - 500;
								System.out.println("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								System.out.println("500 Rupee Stacked");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Stack Command Answer is: "+ answer.Message);
								if(TotalAmount <= 0)
								{
									System.out.println("Pending Amount is Zero");
									Start = false;
									break;
								}
							}
							else
							{
								System.out.println("Total Amount is less then 500");
								System.out.println("Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								System.out.println("500 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Return Command Answer is: "+ answer.Message);
							}
						}
					}
					break;
					case 7: // 2000 rupees
					{
						if(answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
						{
							System.out.println("Hold Fire");
							answer = _ccnet.RunCommand(CCNETCommand.HOLD);
							System.out.println("2000 Rupee Escrow ");
							System.out.println("Hold Command Answer is: "+ answer.Message);
							if(TotalAmount >= 2000)
							{
								TotalAmount = TotalAmount - 2000;
								System.out.println("Stack Fire");
								answer = _ccnet.RunCommand(CCNETCommand.STACK);
								System.out.println("2000 Rupee Stacked");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Stack Command Answer is: "+ answer.Message);
								if(TotalAmount <= 0)
								{
									System.out.println("Pending Amount is Zero");
									Start = false;
									break;
								}
							}
							else
							{
								System.out.println("Total Amount is less then 2000");
								System.out.println("Return Fire");
								answer = _ccnet.RunCommand(CCNETCommand.RETURN);
								System.out.println("2000 Rupee Return");
								answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
								System.out.println("Return Command Answer is: "+ answer.Message);
							}
						}
					}
					break;
				}
				
				Thread.sleep(1000);
				
			}
			System.out.println("complete");
			
			
			
		} 
		catch (Exception e1) 
		{			
			System.out.println("Exception Received:" + e1.getMessage());			
		}	
      
	}*/
	
	public static void StartPoll(int Amount)
	{
		try 
		{
			boolean Start = true;
			System.out.println("CASH ACCEPT TRANSACTION START");
			System.out.println("Application want to Accept Rupees \t" + Amount);
			int NoteValue = 0;
			int TotalAmount = Amount;
			
			DeviceInfo deviceInfo = new DeviceInfo();
			
			while(Start)
			{				
				answer = _ccnet.RunCommand(CCNETCommand.Poll);				 
				NoteValue = answer.ReceivedData[4];
				System.out.println("event status :: "+answer.ReceivedData[3]);
				switch(NoteValue)
				{
					case 1: // 10 rupees
						Start = deviceInfo.startPollCalculation(TotalAmount,10);
						break;
					
					case 2: // 20 rupees
						Start = deviceInfo.startPollCalculation(TotalAmount,20);
						break;
						
					case 3: // 50 rupees
						Start = deviceInfo.startPollCalculation(TotalAmount,50);
						break;
						
					case 4: // 100 rupees
						Start = deviceInfo.startPollCalculation(TotalAmount,100);
						break;
						
					case 5: // 500 rupees
						Start = deviceInfo.startPollCalculation(TotalAmount,500);
						break;
						
					case 7: // 2000 rupees
						Start = deviceInfo.startPollCalculation(TotalAmount,2000);
						break;
					
				}
				
				Thread.sleep(1000);
				
			}
			System.out.println("complete");
			
			
			
		} 
		catch (Exception e1) 
		{			
			System.out.println("Exception Received:" + e1.getMessage());			
		}	
      
	}
	
	private boolean startPollCalculation(int totalAmount, int amount) {
		
		if(answer.ReceivedData[3] == 0x80) // 0x80 mean ESCROW Event
		{
			System.out.println("Hold Fire");
			answer = _ccnet.RunCommand(CCNETCommand.HOLD);
			System.out.println(amount+" Rupee Escrow ");
			System.out.println("Hold Command Answer is: "+ answer.Message);
			if(totalAmount >= amount)
			{
				totalAmount = totalAmount - amount;
				System.out.println("Stack Fire");
				answer = _ccnet.RunCommand(CCNETCommand.STACK);
				/*if(answer.ReceivedData[3] == 0x81) {
					TotalAmount = TotalAmount - 20;
				}*/
				System.out.println(amount+" Rupee Stacked");
				System.out.println("Stack Command Answer is: "+ answer.Message);
				answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
				
				if(totalAmount <= 0) {
					System.out.println("Pending Amount is Zero");
					return false;
				}
				
			}
			else {
				System.out.println("Total Amount is less then "+amount);
				System.out.println("Return Fire");
				answer = _ccnet.RunCommand(CCNETCommand.RETURN);
				System.out.println(amount+" Rupee Return");
				answer = _ccnet.RunCommand(CCNETCommand.ACK);//Amit
				System.out.println("Return Command Answer is: "+ answer.Message);
			}
		}
		
		return true;
		
		
	}

	public static int InitializeDevice()
	{
		int x=0;
		try 
		{
			System.out.println("Initialize Cash Acceptor");
			IConnection comPort = new sPort();
			comPort.setPath("COM2");
			comPort.setBaudRate(9600);
			System.out.println("DEVICE.Bill_Validator called");
			_ccnet = new CCNET(DEVICE.Bill_Validator, comPort);
			// evt = new MyEvents();
			//_ccnet.addEventListener(evt);
			
			System.out.println("Reset Acceptor");
			answer = _ccnet.RunCommand(CCNETCommand.RESET);			
			
			System.out.println("Reset Answer is:" + answer.Message);
			
			System.out.println("Poll Called");
			answer = _ccnet.RunCommand(CCNETCommand.Poll);
			System.out.println("Poll Answer is:" + answer.Message);
			System.out.println("ACK Called");
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			System.out.println("ACK Answer is:" + answer.Message);
			System.out.println("Get Status Called");
			answer = _ccnet.RunCommand(CCNETCommand.GET_STATUS);
			System.out.println("Get Status Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);				
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			System.out.println("Device Identification Called ");
			answer = _ccnet.RunCommand(CCNETCommand.IDENTIFICATION);
			System.out.println("Device Identification Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);			    
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			System.out.println("Set Security Called");
			answer = _ccnet.RunCommand(CCNETCommand.SET_SECURITY);
			System.out.println("Set Security Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);			   
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			System.out.println("Get Status Called");
			answer = _ccnet.RunCommand(CCNETCommand.GET_STATUS);
			System.out.println("Get Status Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);  
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			System.out.println("Get Bill Table Called");
			answer = _ccnet.RunCommand(CCNETCommand.GET_BILL_TABLE);
			System.out.println("Get Bill Table Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);			
			answer = _ccnet.RunCommand(CCNETCommand.ACK);
			System.out.println("Get Status Called");
			answer = _ccnet.RunCommand(CCNETCommand.GET_STATUS);
			System.out.println("Get Status Answer is:" + answer.Message);
			answer = _ccnet.RunCommand(CCNETCommand.Poll);				       
			answer = _ccnet.RunCommand(CCNETCommand.ACK);

			    		        	
			 System.out.println("Enable Bill Types Called");
			answer = _ccnet.RunCommand(CCNETCommand.ENABLE_BILL_TYPES,CCNET_Sub_Command.ENABLE_BILL_TYPES_to_escrow_mode);
			// System.out.println("Enable Bill Types Answer is:" + answer.Message);
			 //System.out.println("Get Status Called");
			//answer = _ccnet.RunCommand(CCNETCommand.GET_STATUS);
			 //System.out.println("Get Status Answer is:" + answer.Message);
		} 
		catch (Exception e) 
		{			
			System.out.println("Exception Received:" + e.getMessage());	
			x=1;
		}

		return x;
	}

}
