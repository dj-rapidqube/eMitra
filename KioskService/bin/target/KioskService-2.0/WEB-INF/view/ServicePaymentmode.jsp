<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Kiosk - Bill</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet">
<link href="css/font-awesome.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
<script src="https://printjs-4de6.kxcdn.com/print.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://printjs-4de6.kxcdn.com/print.min.css">

<script type="text/javascript">
function printPDF(pdfUrl) 
{
	// window.document.write($('#printCertificate').html());
	 window.open(pdfUrl);
    /*  window.print();
     window.close();  */
     window.location.href="returnindex";
   
}
</script>


</head>

<body style="background: url(img/inner-bg.png); background-size: cover;">

	<div id="wrapper">
		<div id="mask">
			<div id="payment" class="item">
				<div class="content">
					<div class="mainone innermaintop">
						<div class="container">
							<div class="row">
								<div class="col-md-4">
									<div class="logomain">
										<div class="cartoon innercartoon">
											<img src="img/cartooon-bg-inner.png" alt="" /> <img
												src="img/bubble.png" class="bubble" alt="" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="logomain midinnerlogomain">
										<div class="logo midinnerlogo">
											<a href="#"> <img src="img/logo-inner.png" alt="" /></a>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<a href="index" class="panel pull-right homebtn"> <img
										src="img/new/home.png" alt="" />
									</a>
								</div>
							</div>
						</div>
					</div>
					<div class="fourservices">
						<div class="innermid">
							<div class="container main_row">
								<div class="row">
									<div class="billmidmain">
										<h1>Choose Payment Method</h1>
										<div class="feildone">
											<div class="col-md-12 paymentone">
												<%-- <input type="hidden" id="amt" value="10"> <input
													type="hidden" id="token" value="${token}"> --%>
												<input type="hidden" id="amt" value="10">
												<input type="hidden" id="trnsID" value="${certiTransID}">
												<input type="hidden" id="serviceID" value="${serviceID}">
												<input type="hidden" id="token" value="${token}">
												<input type="hidden" id="serName" value="${serviceName}">
												<a onclick="csd()"> <img src="img/cash.png" />

													<h2>Cash</h2>
												</a>
											</div>
											<!--<div class="col-md-4 paymentone">
												<a href="javascript:void(0);" id="fingurePaymewnt"> <img
													src="img/thumb.png" />

													<h2>Biometric</h2>
												</a>
											</div> -->
											<!-- <div class="col-md-6 paymentone">
												 <a	href="javascript:void(0);" id="eCardPayment">
													<img src="img/credit.png" />

													<h2>Credit/Debit Card</h2>
												</a>
											</div> -->
										</div>
									</div>
								</div>

								<div class="modal fade" id="list-link1-popup" role="dialog"
									data-backdrop="static" data-keyboard="false">
									<div class="modal-dialog">
										<div class="modal-content">

											<div class="modal-body">
												<div class="row">
													<div class="col-md-12 text-center">
														<p>Are you sure ?</p>
														<p>
															To continue press OK and deposit <i class="fa fa-inr"
																aria-hidden="true"></i><span id="Pamt"></span> note in
															cash collector device.
														</p>

													</div>
												</div>

											</div>

											<div class="modal-footer text-center"
												style="text-align: center">

												<button type="submit" class="btn btn-default getone"
													id="cash" onclick="ok();">Ok</button>
												<a href="index" class="panel">
													<button class="btn btn-default getone" id="cancel">Cancel</button>
												</a>
											</div>

										</div>
									</div>
								</div>


								<div class="modal fade" id="noteslist" role="dialog"
									data-backdrop="static" data-keyboard="false">
									<div class="modal-dialog">
										<div class="modal-content">

											<div class="modal-header">
												<h5 class="modal-title">Details Of Cash</h5>
											</div>

											<div class="modal-body">
												<div class="row">
													<div class="col-md-12 text-center">
														<h2>Timer : <span  id="cashTimer"></span></h2>
														<h4>Total Amount To Be Deposited : <span id="depositAmount"></span></h4>
														<table class="table table-bordered table-striped">
															<thead>
																<tr>
																	<th>Amount</th>
																	<th colspan="2">Note</th>
																	<th>Total</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<td>10</td>
																	<td colspan="2">* <span id="count1">0</span></td>
																	<td><span id="totalcount1">0</span></td>

																</tr>
																<tr>
																	<td>20</td>
																	<td colspan="2">* <span id="count2">0</span></td>
																	<td><span id="totalcount2">0</span></td>

																</tr>
																<tr>
																	<td>50</td>
																	<td colspan="2">* <span id="count3">0</span></td>
																	<td><span id="totalcount3">0</span></td>

																</tr>
																<tr>
																	<td>100</td>
																	<td colspan="2">* <span id="count4">0</span></td>
																	<td><span id="totalcount4">0</span></td>

																</tr>
																<tr>
																	<td>200</td>
																	<td colspan="2">* <span id="count5">0</span></td>
																	<td><span id="totalcount5">0</span></td>

																</tr>
																<tr>
																	<td>500</td>
																	<td colspan="2">* <span id="count6">0</span></td>
																	<td><span id="totalcount6">0</span></td>

																</tr>
																<tr>
																	<td>2000</td>
																	<td colspan="2">* <span id="count7">0</span></td>
																	<td><span id="totalcount7">0</span></td>

																</tr>

																<tr>
																	<td colspan="3">Total Amount</td>
																	<td><span id="totalAmount">0 </span></td>

																</tr>
															</tbody>
														</table>

													</div>
												</div>

											</div>

										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<form id="payment111">
			<input type="hidden" name="govtpdf" value="${url}">
		</form>
		<input type="hidden" value="0" name="emitraCertiTransactionId" id="emitraCertiTransactionId">
		
		<form id="certipayment">
			<input type="hidden" name="transactionId" value="0" id="csd">
			<input type="hidden" name="billAmount" value="0" id="csd1">
			<input type="hidden" name="certiServiceName" id="serviceName">
			<input type="hidden" value="0" name="langCode">
			<input type="hidden" value="${serviceID}" name="serviceProviderID">
		</form>
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.scrollTo.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
		<script type="text/javascript" src="js/jquery.flexisel.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript">
		function getNoteDetails(){
		//	alert("gdfh");
			$.ajax({
				url : '/KioskService/NoteDetails/',
				type : "POST",
				dataType: 'json',
				success : function(data) {
				//	alert(data);
					if(data==''){
						console.log("No Data Found");
						return false;
					}else{
						var json = jQuery.parseJSON(JSON.stringify(data)); 
					 	
						$("#count1").html(json[0].count1);
					 	$("#count2").html(json[0].count2);
						$("#count3").html(json[0].count3);
						$("#count4").html(json[0].count4);
						$("#count5").html(json[0].count5);
						$("#count6").html(json[0].count6);
						$("#count7").html(json[0].count7);
						
						$("#totalcount1").html(json[0].totalcount1);
						$("#totalcount2").html(json[0].totalcount2);
						$("#totalcount3").html(json[0].totalcount3);
						$("#totalcount4").html(json[0].totalcount4);
						$("#totalcount5").html(json[0].totalcount5);
						$("#totalcount6").html(json[0].totalcount6);
						$("#totalcount7").html(json[0].totalcount7);
						$("#totalAmount").html(json[0].totalAmount);  
						
						$("#cashTimer").html(json[0].cashTimer);
						//alert("depositAmount : "+json[0].depositAmount);
						$("#depositAmount").html(json[0].depositAmount);
						
						return true;
					}
				}
				
			});
	   	}
	
		
/* 		$(function() {
				$("#cash").bind('click', function(e) {
				var amt = $('#amt').val();
				var token = $('#token').val();
				// start calling function for showing note details
				var noteIntervalVar = setInterval(function(){ getNoteDetails(); }, 500);
				// End  calling function for showing note details

				
				$.ajax({
					url : '/KioskService/cashAcceptor/'+amt+'/'+token+'/',
					type : "POST",
					success : function(data) {
						console.log(data);
						if(data=='NoData'){
							console.log("No Data Found");
							window.location.href="paymentError";
						} else if(data=='cancel'){
							clearInterval(noteIntervalVar);
							window.location.href="index";
						}
						
						else{
							setTimeout(function(){ printPDF('${url}'); }, 1000);
						//	printPDF('${url}');
						}

					},
					error : function(xhr, status, error) {
						window.location.href="paymentError";
						console.log("Error " + error);
					}
				});
			})
		}); */
		
		$(function() {
			$("#cash").bind('click', function(e) {
			var amt = $('#amt').val();
			var token = $('#token').val();
			var transid = $('#trnsID').val();
			var serviceID = $('#serviceID').val();
			var serviceName = $('#serName').val();
			
			document.getElementById('serviceName').value=serviceName;
			document.getElementById('csd').value=transid;
			document.getElementById('csd1').value=amt;
			$("#emitraCertiTransactionId").val(0);
			
			$('#loading').show();
			$.ajax({
				url:'/KioskService/certificatebacktoback/'+amt+'/'+transid+'/'+serviceID+'/',
				//data:{field1:amt,field2 :trnsid},
				type:"POST",
				success : function(trans){
				//	alert("fgdgh :: "+trans);
					var valArr = trans.split("##");
					if(valArr[0]=='SUCCESS'){
						$('#noteslist').modal('show');
						$('#loading').hide();
						// start calling function for showing note details
						var noteIntervalVar = setInterval(function(){ getNoteDetails(); }, 500);
						// End  calling function for showing note details
						
					  	$("#emitraCertiTransactionId").val(valArr[1]);
						console.log($("#emitraCertiTransactionId").val());		
					
						$.ajax({
							url : '/KioskService/cashAcceptor/'+amt+'/'+transid+'/',
							type : "POST",
							success : function(data) {
								//alert(data);
								//console.log(data);
								if(data=='NoData'){
									console.log("No Data Found");
									window.location.href="paymentError";
								} else if(data=='cancel'){
									clearInterval(noteIntervalVar);
									$.ajax({
										url : '/KioskService/cancelTranscation/'+$("#emitraCertiTransactionId").val()+'/',
										type : "POST",
										success : function(data) {
											console.log(data);
											window.location.href="index";
										}
									}); 
								}
								
								else{
									setTimeout(function(){ 
										printPDF('${url}');
										/* $('#loading').show();
										document.getElementById('certipayment').action="certiPaymentSuccess";
										document.getElementById('certipayment').method="post";
										document.getElementById('certipayment').submit();  */
										},
									1000);
								
								}
			
							},
							error : function(xhr, status, error) {
								window.location.href="paymentError";
								console.log("Error " + error);
							}
						});
					}
			 		else{
			 			console.log("trans : "+trans);
						window.location.href="paymentError";
					}
				}
				});
			});
		});
		
		function csd()
		{
			var id=document.getElementById('amt').value;
			document.getElementById('Pamt').innerHTML=id;
			$('#list-link1-popup').modal('show');
		} 
		
		function ok()
		{
			// start function for showing note value
			$('#list-link1-popup').modal('hide');
		//	$('#noteslist').modal('show');
			// end function for showing note value
			document.getElementById('cancel').disabled=true;
			document.getElementById('cash').disabled=true;
			
		}
		
		/* function saveDetails(){
			
				var printData = $('#rp').val();
				printData = 'KAPIL';

				var dataToSend = {
					"printData" : printData
				};
				dataToSend = JSON.stringify(dataToSend);
				$.ajax({
					url : '/KioskService/printRec/',
					type : "POST",
					contentType : 'application/json; charset=utf-8',
					dataType : 'text',
					data : dataToSend,
					success : function(data) {
						$('#d4').html(data);
						alert(data);
						console.log(data);

						$.ajax({
							url : 'printReceipt',
							type : "POST",
							dataType : 'text',
							data : {
								"userData" : printData
							},
							success : function(data) {
								alert(data);
							},
							error : function(xhr, status, error) {
								//alert("Some Error Occoured..");
							}
						});
					},

					error : function(xhr, status, error) {
						$('#d4').html(error);
						//alert("Some Error Occoured..");
						console.log("Error " + error);
					}
				});
			} */
		
		</script>
</body>
</html>