var statusCode = "";
function getAadharAuth(){
	$('#loading').show();
	document.getElementById("submitButtonAction").value = "N";
	document.getElementById('updateMessage').innerHTML = "";
	var xhttp = new XMLHttpRequest();
	var aadharElement = document.getElementById('aadharNo');
	var aadharId = aadharElement.value;
	var langCode = aadharElement.getAttribute("data-lang-code");
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var responseJson = JSON.parse(this.responseText);
			
			var status = responseJson["status"];
			
			document.getElementById('token').value = aadharId;
			
			if(status == 'y'){
				var txnId = responseJson["txnId"];
				document.getElementById('aadharOtp').value = '';
				$('#loading').hide();
				$("#modalForOtpUid").modal();
  				
  				document.getElementById('submitOtp').onclick=function(){
  					$('#modalForOtpUid').modal('hide');
  					$('#loading').show();
  					var aadharOtp = document.getElementById('aadharOtp').value;
  					var languageCode = document.getElementById('langCode').value;
  					var token = document.getElementById('token').value;
  					var amount = document.getElementById('amount').value;
  					var serviceProviderName = document.getElementById('serviceProviderName').value;
  					var serviceProviderID = document.getElementById('serviceProviderID').value;
  					var subServiceID = document.getElementById('subServiceID').value;
  					
  					var jsonServiceData = {
  							"aadharOtp" : aadharOtp,
  							"txnId" : txnId,
  							"langCode" : languageCode,
  							"token" : token,
  							"amount" : amount,
  							"serviceProviderName" : serviceProviderName,
  							"serviceProviderID" : serviceProviderID,
  							"subServiceID" : subServiceID,
  							"aadharId" : aadharId,
  							"modeOfPage" : langCode
  					};

  					var serviceData = JSON.stringify(jsonServiceData);
  					
  					var xhttp = new XMLHttpRequest();
			  		xhttp.onreadystatechange = function() {
			  			if (this.readyState == 4 && this.status == 200) {
			  				var responseJson = JSON.parse(this.responseText);
  				  			var responseStatus = responseJson["status"];
  				  			if(responseStatus == 200){
  				  				$('#loading').hide();
  				  				$('#modalForOtpUid').modal('hide');
  				  				
  				  				document.getElementById("transactionID").value = responseJson["requestId"];
  				  				document.getElementById("aadharNo").value = responseJson["aadharId"];//for temporary purpose
  				  				document.getElementById('token').value = responseJson["aadharId"];//for temporary purpose
  				  				
	  				  			document.getElementById('wrongOtp').style = "display :none;";
		  						document.getElementById('wrongOtp').innerHTML = "";
		  						
		  						var memIdList = responseJson["memIdList"];
	  				  			var nameList = responseJson["nameList"];
	  			  				var genderList = responseJson["genderList"];
	  			  				var dobList = responseJson["dobList"];
	  			  				var bhamashahIdList = responseJson["bhamashahIdList"];
	  			  				var memberTypeList = responseJson["memberTypeList"];
	  			  				var addharNoList = responseJson["addharNoList"];
	  			  				var mobileNoList = responseJson["mobileNoList"];
	  			  				var accountNumberList = responseJson["accountNumberList"];
	  			  				var membersData = responseJson["membersData"];
	  			  				
		  			  			var tableElement = document.getElementById('familyMemberTable');
				  				tableElement.innerHTML = '';
				  				
								var thead = document.createElement('thead');
								var trThead = document.createElement('tr');
								var th1 = document.createElement('th');
									th1.setAttribute("style" , "text-align:center;");
								var th2 = document.createElement('th');
									th2.setAttribute("style" , "text-align:left;");
								var th3 = document.createElement('th');
									th3.setAttribute("style" , "text-align:left;");
								var th4 = document.createElement('th');
									th4.setAttribute("style" , "text-align:left;");
								var th5 = document.createElement('th');
									th5.setAttribute("style" , "text-align:left;");
								var th6 = document.createElement('th');
									th6.setAttribute("style" , "text-align:left;");
								var th7 = document.createElement('th');
									th7.setAttribute("style" , "text-align:left;");
								var th8 = document.createElement('th');
									th8.setAttribute("style" , "text-align:left;");
								
								if(langCode == "ENG"){
									var text1 = document.createTextNode('Select');
								    var text2 = document.createTextNode('Name');
								    var text3 = document.createTextNode('DOB');
								    var text4 = document.createTextNode('Member Type');
								    var text5 = document.createTextNode('Bhamashah No');
								    var text6 = document.createTextNode('Aadhar No');
								    var text7 = document.createTextNode('Mobile No');
								    var text8 = document.createTextNode('Account No');
								    th1.appendChild(text1);
								    th2.appendChild(text2);
								    th3.appendChild(text3);
								    th4.appendChild(text4);
								    th5.appendChild(text5);
								    th6.appendChild(text6);
								    th7.appendChild(text7);
								    th8.appendChild(text8);
								}
								if(langCode == "HND"){
									var text1 = document.createTextNode('चुनें');
								    var text2 = document.createTextNode('नाम');
								    var text3 = document.createTextNode('जन्म तिथि');
								    var text4 = document.createTextNode('सदस्य प्रकार');
								    var text5 = document.createTextNode('भामाशाह संख्या');
								    var text6 = document.createTextNode('आधार संख्या');
								    var text7 = document.createTextNode('मोबाइल नंबर');
								    var text8 = document.createTextNode('खाता संख्या');
								    th1.appendChild(text1);
								    th2.appendChild(text2);
								    th3.appendChild(text3);
								    th4.appendChild(text4);
								    th5.appendChild(text5);
								    th6.appendChild(text6);
								    th7.appendChild(text7);
								    th8.appendChild(text8);
								}
							    trThead.appendChild(th1);
							    trThead.appendChild(th2);
							    trThead.appendChild(th3);
							    trThead.appendChild(th4);
							    trThead.appendChild(th5);
							    trThead.appendChild(th6);
							    trThead.appendChild(th7);
							    trThead.appendChild(th8);
							    thead.appendChild(trThead);
				  				
							    var tbody = document.createElement('tbody');
							    tbody.setAttribute("id" , "tBodyOfName");
							    
				  				for (var i = 0; i < nameList.length; i++){
// 						  		for (var i = 0; i < 5; i++){
				  				    var tr = document.createElement('tr');   

				  					var td1 = document.createElement('td');
				  				  		td1.setAttribute("style" , "text-align:center;");
				  				    var td2 = document.createElement('td');
				  				  		td2.setAttribute("style" , "text-align:left;");
				  				    var td3 = document.createElement('td');
				  				  		td3.setAttribute("style" , "text-align:left;");
				  				    var td4 = document.createElement('td');
				  				  		td4.setAttribute("style" , "text-align:left;");
				  				    var td5 = document.createElement('td');
				  				  		td5.setAttribute("style" , "text-align:left;");
				  				    var td6 = document.createElement('td');
				  				  		td6.setAttribute("style" , "text-align:left;");
				  				    var td7 = document.createElement('td');
				  				  		td7.setAttribute("style" , "text-align:left;");
				  				    var td8 = document.createElement('td');
				  				  		td8.setAttribute("style" , "text-align:left;");

				  				  	var inputRadioButton = document.createElement('input');
				  				  		inputRadioButton.setAttribute("type" , "radio");
				  				  		inputRadioButton.setAttribute("name" , "optradio");
				  				  		inputRadioButton.setAttribute("value" , memIdList[i]);
				  				  		inputRadioButton.setAttribute("id" , "radioName"+i);
				  				  		inputRadioButton.setAttribute("onclick" , "isRBChecked(this)");
				  				  		
				  				  	var text9 = document.createTextNode(nameList[i] + " (" + genderList[i] + ")");
				  				  	var text10 = document.createTextNode(dobList[i]);
				  				  	var text11 = document.createTextNode(memberTypeList[i]);
				  				  	var text12 = document.createTextNode(bhamashahIdList[i]);
				  				  	var text13 = document.createTextNode(addharNoList[i]);
				  				  	var text14 = document.createTextNode(mobileNoList[i]);
				  				  	var text15 = document.createTextNode(accountNumberList[i]);

				  					td1.appendChild(inputRadioButton);
				  				  	td2.appendChild(text9);
				  				  	td3.appendChild(text10);
				  				  	td4.appendChild(text11);
				  				  	td5.appendChild(text12);
				  				  	td6.appendChild(text13);
				  				  	td7.appendChild(text14);
				  				  	td8.appendChild(text15);
				  				    tr.appendChild(td1);
				  				    tr.appendChild(td2);
				  				    tr.appendChild(td3);
				  				    tr.appendChild(td4);
				  				    tr.appendChild(td5);
				  				    tr.appendChild(td6);
				  				    tr.appendChild(td7);
				  				    tr.appendChild(td8);

				  				  tbody.appendChild(tr);
				  				}
				  				
				  				tableElement.appendChild(thead);
				  				tableElement.appendChild(tbody);
				  				$('#loading').hide();
				  				$("#modalForBhamashahDetails").modal();
  				  				
				  				//For updating mobile Number
				  				document.getElementById('updateMobileNo').onclick=function(){
				  					
				  					var memberData = getMemberData(membersData , memIdList);
				  					document.getElementById('dataUpdateBnkAccDiv').style.display = "none";
				  					document.getElementById('dataUpdateMobileDiv').style.display = "block";
				  					
				  					document.getElementById('uidSubmitButton').disabled = "disabled";
				  					document.getElementById('aadharNo').disabled = "disabled";
				  					document.getElementById('uidResetButton').disabled = "disabled";
				  					
				  					document.getElementById('verifyMobileNo').onclick=function(){
				  						$('#loading').show();
										var mobileNumber = document.getElementById('mobileNumber').value;
										/* will call api to send an otp to the same mobile number 
										*
										*	In response, we will get the otp, which has been sent to the above mobile number.
										*
										*	then we will open the dialogue for asking an otp recieved on the same mobile number.
										*
										*	after inserting the OTP, we will check the both OTP values(recieved from popup and recieved from response)
										*/
										var xhttp = new XMLHttpRequest();
				  				  		xhttp.onreadystatechange = function() {
				  				  			if (this.readyState == 4 && this.status == 200) {
				  				  				var responseJson = JSON.parse(this.responseText);
				  				  				var OTP = responseJson["OTP"];
					  				  			
				  				  				if(OTP != null && OTP != undefined && OTP != ""){
					  				  				document.getElementById('aadharOtp').value = '';
					  				  				$('#loading').hide();
					  				  				$("#modalForOtpUid").modal();
									  				
									  				document.getElementById('submitOtp').onclick=function(){
									  					
									  					var mobileOtp = document.getElementById('aadharOtp').value;
									  					
									  					if(mobileOtp === OTP){
									  						
									  						memberData['ADDHAR_NO'] = aadharId;//for working purpose;
									  						memberData['ADDHAR_NO'] = document.getElementById("aadharNo").value//for temporary purpose;
									  						memberData['IFSC_CODE'] = '';
									  						memberData['MOBILE_NO'] = mobileNumber;
									  						memberData['UPDATE_FLAG'] = 'M';
									  						memberData['LANGUAGE_CODE'] = langCode;
									  						$('#modalForOtpUid').modal('hide');
							  				  				
								  				  			document.getElementById('wrongOtp').style = "display :none;";
									  						document.getElementById('wrongOtp').innerHTML = "";
									  						
									  						var memberDetails = JSON.stringify(memberData);
									  						
									  						//calling on controller for getting status of update
									  						var xhttp = new XMLHttpRequest();
									  				  		xhttp.onreadystatechange = function() {
									  				  			if (this.readyState == 4 && this.status == 200) {
										  				  			var responseJson = JSON.parse(this.responseText);
										  				  			
										  				  			if(responseJson['status'] == 'D'){
										  				  				var bhamashahId = responseJson['BHAMASHAH_ID'];
												  				  		document.getElementById('updateMessage').style = "color :red; display :block;";
												  				  		if(langCode == "ENG"){
	//											  				  			document.getElementById('updateMessage').innerHTML = "This mobile number is already exist for.";
												  				  			document.getElementById('updateMessage').innerHTML = "This mobile number is already exist for " + bhamashahId + ".";
												  				  		}
												  				  		if(langCode == "HND"){
	//											  				  			document.getElementById('updateMessage').innerHTML = "यह मोबाइल नंबर पहले से मौजूद है ।";
												  				  			document.getElementById('updateMessage').innerHTML = "यह मोबाइल नंबर पहले से "+ bhamashahId +" में मौजूद है।";
												  				  		}
													  					
												  				  		setTimeout(function() {
													  						document.getElementById("updateMessage").style.display = "none";
													  						document.getElementById("updateMessage").innerHTML = "";
													  					}, 5000);
												  				  		
										  				  			}else if(responseJson['status'] == 'F'){
											  				  			document.getElementById('updateMessage').style = "color :red; display :block;";
												  				  		if(langCode == "ENG"){
												  				  			document.getElementById('updateMessage').innerHTML = "Please try once again.";
												  				  		}
												  				  		if(langCode == "HND"){
												  				  			document.getElementById('updateMessage').innerHTML = "कृपया एक बार फिर से प्रयास करें।";
												  				  		}
													  					
												  				  		setTimeout(function() {
													  						document.getElementById("updateMessage").style.display = "none";
													  						document.getElementById("updateMessage").innerHTML = "";
													  					}, 5000);
												  				  		
										  				  			}else if(responseJson['status'] == 'N'){
											  				  			document.getElementById('updateMessage').style = "color :red; display :block;";
												  				  		if(langCode == "ENG"){
												  				  			document.getElementById('updateMessage').innerHTML = "There's an internal error occur in server, please try again after some time.";
												  				  		}
												  				  		if(langCode == "HND"){
												  				  			document.getElementById('updateMessage').innerHTML = "सर्वर में एक आंतरिक त्रुटि हुई है, कृपया कुछ समय बाद पुनः प्रयास करें।";
												  				  		}
													  					
												  				  		setTimeout(function() {
													  						document.getElementById("updateMessage").style.display = "none";
													  						document.getElementById("updateMessage").innerHTML = "";
													  					}, 5000);
												  				  		
										  				  			}else if(responseJson['status'] == 'V'){
										  				  			//here we will call the functionality of paying amount for the further process.
													  					//As we will get the status in return either YES or NO
												  						if(langCode == "ENG"){
												  							document.getElementById("paymentMessage").innerHTML = "Are you sure you want to make payment for update mobile number ?";
														  					document.getElementById("paymentChargeMessage").innerHTML = "The charges would be &#8377 10.";
												  				  		}
												  				  		if(langCode == "HND"){
													  				  		document.getElementById("paymentMessage").innerHTML = "क्या आप सुनिश्चित हैं कि आप मोबाइल नंबर अपडेट के लिए भुगतान करना चाहते हैं?";
														  					document.getElementById("paymentChargeMessage").innerHTML = "शुल्क  &#8377 10  होगा।";
												  				  		}
												  				  		
												  						$("#cnfrmPaymentModal").modal();
												  						document.getElementById('paymentYes').onclick=function(){
	//											  							memberData['EMAIL_ID_BILL'] = document.getElementById('emailIdBill').value;
												  							memberData['MOBILE_NUMBER_BILL'] = mobileNumber;
												  							var memberDetails = JSON.stringify(memberData);
													  						document.getElementById('memberDetails').value = memberDetails;
												  							openIt();
													  					}
										  				  			}
									  				  			}
									  				  		};
										  				  	xhttp.open("GET", "statusForUpdateNumber?memberData="+memberDetails+"&updateFlag=MV", true);
									  				  		xhttp.send();
									  					}else{
									  						document.getElementById('wrongOtp').style = "color :red; display :block;";
									  						if(langCode == "ENG"){
									  							document.getElementById('wrongOtp').innerHTML = "Wrong OTP Inserted..!!!";
									  				  		}
									  				  		if(langCode == "HND"){
									  				  			document.getElementById('wrongOtp').innerHTML = "गलत OTP डाला गया है..!!!";
									  				  		}
									  				  		
										  				  	setTimeout(function() {
										  				  		document.getElementById('wrongOtp').style = "display :none;";
										  						document.getElementById('wrongOtp').innerHTML = "";
									  						}, 5000);
									  					}							  				
									  				}
				  				  				}else{
				  				  					$('#loading').hide();
					  				  				document.getElementById('updateMessage').style = "color :red; display :block;";
						  				  			if(langCode == "ENG"){
							  				  			document.getElementById('updateMessage').innerHTML = "There's an internal error occur in server, please try again after some time.";
							  				  		}
							  				  		if(langCode == "HND"){
							  				  			document.getElementById('updateMessage').innerHTML = "सर्वर में एक आंतरिक त्रुटि हुई है, कृपया कुछ समय बाद पुनः प्रयास करें।";
							  				  		}
								  					
							  				  		setTimeout(function() {
								  						document.getElementById("updateMessage").style.display = "none";
								  						document.getElementById("updateMessage").innerHTML = "";
								  					}, 5000);
				  				  				}
				  				  			}
				  				  		};
					  				  	xhttp.open("GET", "getOtpForMobileVerify?mobileNo="+mobileNumber+"&modeOfPage="+langCode+"&txnId="+txnId, true);
				  				  		xhttp.send();
				  					}
				  				}
				  				
				  				//For updating Bank Account Number
				  				/*document.getElementById('updateBankAccNo').onclick=function(){
				  					
				  					var memberData = getMemberData(membersData , nameList);
				  					document.getElementById('dataUpdateBnkAccDiv').style.display = "block";
				  					document.getElementById('dataUpdateMobileDiv').style.display = "none";
				  					
				  					document.getElementById('uidSubmitButton').disabled = "disabled";
				  					document.getElementById('aadharNo').disabled = "disabled";
				  					document.getElementById('uidResetButton').disabled = "disabled";
				  					
				  					document.getElementById('getIFSCDetails').onclick=function(){
				  						
				  						var ifscCode = document.getElementById('ifscCode').value;
				  						var xhttp = new XMLHttpRequest();
				  				  		xhttp.onreadystatechange = function() {
				  				  			if (this.readyState == 4 && this.status == 200) {
				  				  				var responseJson = JSON.parse(this.responseText);
				  				  				
				  				  				var BANK_NAME = responseJson["BANK_NAME"];
				  				  				var BRANCH_ADDRESS = responseJson["BRANCH_ADDRESS"];
				  				  				
				  				  				if((BANK_NAME != undefined && BANK_NAME != null && BANK_NAME != "") &&
				  				  						(BRANCH_ADDRESS != undefined && BRANCH_ADDRESS != null && BRANCH_ADDRESS != "")){
					  				  				document.getElementById('bnkName').value = BANK_NAME;
						  				  			document.getElementById('branchName').value = BRANCH_ADDRESS;
					  				  				document.getElementById('bankDetails').style.display = "block";
					  				  				
					  				  				document.getElementById('updateAccNumber').onclick=function(){
					  				  					
					  				  					//transaction will be completed here
					  				  					//then we will update the account number by calling the given API
					  				  					var accNumber = document.getElementById('accNumber').value;
								  				  		var cnfrmAccNumber = document.getElementById('cnfrmAccNumber').value;
								  				  		
								  				  		//memberData['ADDHAR_NO'] = aadharId;
								  						memberData['ADDHAR_NO'] = document.getElementById("aadharNo").value//for temporary purpose;
								  						memberData['ACCOUNT_NUMBER'] = cnfrmAccNumber;
								  						memberData['IFSC_CODE'] = ifscCode;
								  						memberData['UPDATE_FLAG'] = 'A';
								  						var memberDetails = JSON.stringify(memberData);
								  						document.getElementById('memberDetails').value = memberDetails;
								  				  		
								  					//calling on controller for getting status of update
								  						var xhttp = new XMLHttpRequest();
								  				  		xhttp.onreadystatechange = function() {
								  				  			if (this.readyState == 4 && this.status == 200) {
									  				  			var responseJson = JSON.parse(this.responseText);
									  				  			
									  				  			if(responseJson['status'] == 'D'){
									  				  				var bhamashahId = responseJson['BHAMASHAH_ID'];
											  				  		document.getElementById('updateMessage').style = "color :red; display :block;";
											  				  		if(langCode == "ENG"){
											  				  			document.getElementById('updateMessage').innerHTML = "This account number is already exist for " + bhamashahId + ".";
											  				  		}
											  				  		if(langCode == "HND"){
											  				  			document.getElementById('updateMessage').innerHTML = "यह खाता संख्या पहले से "+ bhamashahId +" में मौजूद है ।";
											  				  		}
												  					
											  				  		setTimeout(function() {
												  						document.getElementById("updateMessage").style.display = "none";
												  						document.getElementById("updateMessage").innerHTML = "";
												  					}, 5000);
											  				  		
									  				  			}else if(responseJson['status'] == 'F'){
										  				  			document.getElementById('updateMessage').style = "color :red; display :block;";
											  				  		if(langCode == "ENG"){
											  				  			document.getElementById('updateMessage').innerHTML = "Please try once again.";
											  				  		}
											  				  		if(langCode == "HND"){
											  				  			document.getElementById('updateMessage').innerHTML = "कृपया एक बार फिर से प्रयास करें ।";
											  				  		}
												  					
											  				  		setTimeout(function() {
												  						document.getElementById("updateMessage").style.display = "none";
												  						document.getElementById("updateMessage").innerHTML = "";
												  					}, 5000);
											  				  		
									  				  			}else if(responseJson['status'] == 'V'){
									  				  				//here we will call the functionality of paying amount for the further process.
												  					//As we will get the status in return either YES or NO
											  				  		if(langCode == "ENG"){
													  				  	document.getElementById("paymentMessage").innerHTML = "Are you sure you want to make payment for update account number ?";
													  					document.getElementById("paymentChargeMessage").innerHTML = "The charges would be &#8377 10.";
											  				  		}
											  				  		if(langCode == "HND"){
												  				  		document.getElementById("paymentMessage").innerHTML = "क्या आप सुनिश्चित हैं कि आप खाता संख्या अपडेट के लिए भुगतान करना चाहते हैं?";
													  					document.getElementById("paymentChargeMessage").innerHTML = "शुल्क  &#8377 10  होगा।";
											  				  		}
											  				  		
												  					$("#cnfrmPaymentModal").modal();
											  						document.getElementById('paymentYes').onclick=function(){
//											  							memberData['EMAIL_ID_BILL'] = document.getElementById('emailIdBill').value;
//											  							memberData['MOBILE_NUMBER_BILL'] = document.getElementById('mobileNumberBill').value;
											  							var memberDetails = JSON.stringify(memberData);
												  						document.getElementById('memberDetails').value = memberDetails;
											  							openIt();
											  						}
									  				  			}
								  				  			}
								  				  		};
									  				  	xhttp.open("GET", "statusForUpdateNumber?memberData="+memberDetails+"&updateFlag=AV", true);
								  				  		xhttp.send();
					  				  				}
				  				  				}else{
					  				  				document.getElementById('updateMessage').style = "color :red; display :block;";
							  				  		if(langCode == "ENG"){
							  				  			document.getElementById('updateMessage').innerHTML = "Please enter a valid IFSC Code.";
							  				  		}
							  				  		if(langCode == "HND"){
							  				  			document.getElementById('updateMessage').innerHTML = "कृपया एक वैध आईएफएससी कोड दर्ज करें।";
							  				  		}
								  					
							  				  		setTimeout(function() {
								  						document.getElementById("updateMessage").style.display = "none";
								  						document.getElementById("updateMessage").innerHTML = "";
								  					}, 5000);
				  				  				}
				  				  			}
				  				  		};
				  				  		xhttp.open("GET", "getIFSCDetails?ifscCode="+ifscCode+"&modeOfPage="+langCode, true);
				  				  		xhttp.send();
				  					}
				  				}*/
  				  			}else if(responseStatus == 111){
  				  				$('#loading').hide();
  				  				$("#modalForOtpUid").modal();
  				  				var responseMsg = responseJson["msg"];
	  				  			document.getElementById('wrongOtp').style = "color :red; display :block;";
	  				  			document.getElementById('wrongOtp').innerHTML = responseMsg;
		  				  		
	  				  			/*if(langCode == "ENG"){
	  				  				document.getElementById('wrongOtp').innerHTML = "Wrong OTP inserted..!!!";
		  				  		}
		  				  		if(langCode == "HND"){
		  				  			document.getElementById('wrongOtp').innerHTML = "गलत OTP डाला गया है..!!!";
		  				  		}*/
	  				  			
		  				  		setTimeout(function() {
			  				  		document.getElementById('wrongOtp').style = "display :none;";
			  						document.getElementById('wrongOtp').innerHTML = "";
		  						}, 5000);
  				  			}
  			  				
			  			}
			  		};
			  		xhttp.open("POST", "uidOtpAuth?serviceData="+serviceData, true);
			  		xhttp.send(); 
  				}
			}else{
				$('#loading').hide();
				var message = responseJson["message"];
				document.getElementById('errAadharNoMessage').style = "display:block; color:red; font-size:15px;";
				document.getElementById('errAadharNoMessage').innerHTML = message;
	  			
				/*if(langCode == "ENG"){
	  				document.getElementById('errAadharNoMessage').innerHTML = "Invalid Aadhar Number.";
		  		}
		  		if(langCode == "HND"){
		  			document.getElementById('errAadharNoMessage').innerHTML = "अवैध आधार संख्या।";
		  		}*/
		  		
				setTimeout(function() {
					document.getElementById("errAadharNoMessage").style = "display:block; color:grey; font-size:15px;";
					if(langCode == "ENG"){
						document.getElementById("errAadharNoMessage").innerHTML = "Note * :- An OTP will be sent on your linked mobile.";
					}
					if(langCode == "HND"){
						document.getElementById("errAadharNoMessage").innerHTML = "ध्यान दें * :- आपके लिंक किए गए मोबाइल पर एक ओटीपी भेजा जाएगा।";
					}
				}, 5000);
			}
		}
	};
	xhttp.open("POST", "uidOtpGeneration?modeOfPage="+langCode+"&memberUniqueId="+aadharId, true);
	xhttp.send();
}

function isRBChecked(element){
	if(element.checked){
		document.getElementById('updateMobileNo').disabled = "";
		/*document.getElementById('updateBankAccNo').disabled = "";*/
	}
}

function getMemberData(membersData , memIdList){
	var selectedRadioButtonValue;
		
	for(var i = 0; i < memIdList.length; i++){
		if(document.getElementById("radioName"+i).checked){
			selectedRadioButtonValue = document.getElementById("radioName"+i).value;
			break;
		}
	}
	var memberData = membersData.filter(function(item) { return item.M_ID === selectedRadioButtonValue; });
	
	return memberData[0];
}

function isNumberKey(evt, obj , type) {

	var charCode = (evt.which) ? evt.which : event.keyCode;
	var value = obj.value;
	var dotcontains = value.indexOf(".") != - 1;
	var flag = true;
	if (dotcontains)
		if (charCode == 46)
			flag = false;
	if (charCode == 46)
		flag = false;
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		flag = false;
	
	if(flag){
		var length = obj.maxLength;
		var value = obj.value + evt.key;
		var valElement = document.getElementById('aadharNo').value;
		if(value.length === length || valElement.length === length){
			if(type=='uid'){
				document.getElementById('uidSubmitButton').disabled = "";
			}else if(type=='mob'){
				document.getElementById('verifyMobileNo').disabled = "";
			}
		}else{
			if(type=='uid'){
				document.getElementById('uidSubmitButton').disabled = "disabled";
			}else if(type=='mob'){
				document.getElementById('verifyMobileNo').disabled = "disabled";
			}
		}
	}
	return flag;
}

function matchAccountNo(langCode) {
    var id1 = document.getElementById('accNumber').value;
    var id2 = document.getElementById('cnfrmAccNumber').value;
    if(id1.length === id2.length){
    	if(id1 === id2){
    		document.getElementById('updateAccNumber').disabled = "";
    		if(langCode == "ENG"){
    			document.getElementById('accNoMatched').innerHTML = 'Account Number Matched';
	  		}
	  		if(langCode == "HND"){
	  			document.getElementById('accNoMatched').innerHTML = "खाता संख्या मिलान हुई";
	  		}
            document.getElementById('accNoMatched').style = 'display:block;color:green;';
			
        }else{
        	document.getElementById('updateAccNumber').disabled = "disabled";
        	if(langCode == "ENG"){
        		document.getElementById('accNoMatched').innerHTML = 'Account Number Not Matched';
	  		}
	  		if(langCode == "HND"){
	  			document.getElementById('accNoMatched').innerHTML = "खाता संख्या मिलान नहीं हुई";
	  		}
            document.getElementById('accNoMatched').style = 'display:block;color:red;';
        }
    	setTimeout(function() {
    		document.getElementById("accNoMatched").style.display = "none";
			document.getElementById("accNoMatched").innerHTML = "";
		}, 5000);
    }else{
    	document.getElementById('accNoMatched').style = 'display:none;';
    }
}

function setLengthOfCnfrmAccNo() {
	document.getElementById('cnfrmAccNumber').setAttribute("maxLength", document.getElementById('accNumber').value.length);
    console.log(document.getElementById('cnfrmAccNumber').maxLength);
}

function openIt(){
	$('#cnfrmPaymentModal').modal('hide');
	document.getElementById('govtPayment').action="paymentModeBhamashahCard";
	document.getElementById('govtPayment').method="post";
	document.getElementById('govtPayment').submit();
}

function cancelWork(){
	$('#modalForOtpUid').modal('hide');
	$('#loading').hide();
}

function reset(){
	document.getElementById('aadharNo').value = '';
}

function updateToBhamashahBack(){
	$('#updateToBhamashahBack').style = 'display:none;';
	document.getElementById('updateToBhamashah').action="updateMobileAccountNumber";
	document.getElementById('updateToBhamashah').method="post";
	document.getElementById('updateToBhamashah').submit();
}