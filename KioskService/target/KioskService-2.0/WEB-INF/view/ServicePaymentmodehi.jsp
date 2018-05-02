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
<title>Kiosk - भुगतान का प्रकार</title>
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
					<!--<a href="#item1" class="panel">back</a>-->
					<!--   <div id="printCertificate" style="max-height:100% !important; display:none;  padding: 0px 0px 0px 16px;">
								<div style="width:100%; clear:both;" >     
<div style="width:75%; float:left; text-align:center;"> <div style="line-height: 28px;font-size: 20px;"> <div>राजस्थान सरकार </div> <div><span class="loggedUserOfficeNameHindi">कार्यालय तहसीलदार,चाकसू(जयपुर)</span></div> <div> ज़िला - <span class="districtName">जयपुर</span></div>  </div> <h4 style="font-size:18px;"> मूल निवास प्रमाण-पत्र</h4> </div>   </div>  <div style="width:100%; clear:both; padding-top:20px; font-size:16px;"> <div><b>क्रमांक : </b> RJ<span class="distCode"></span>/2017/राजस्व विभाग/मूल निवास प्रमाण-पत्र/<span class="receiptNumber">17069472121</span><br/> <b>दिनांक : </b><span class="applicationDateTemp">25-11-2017</span></div><div style="margin-left:80%; margin-top:-50px;  clear:both; font-size:20px;"><span><img src="https://emitraapp.rajasthan.gov.in/emitrashared/uploadeddocs/2002822101/Photo.jpg" width="80px;" height="80px;" alt="Smiley face"></span><br/> </div></div><br/>    <div style="width:100%; margin-top:05px; margin-bottom:05px;  clear:both; font-size:20px;"> प्रमाणित किया जाता है कि   <span class="titalName">सुश्री</span>   <span class="ApplicantName">शबनम  बानो</span>  पुत्र/पुत्री/पत्नी   श्री  <span class="RelationName">अब्दुल रहमान</span>  निवास - <span class="PermatanetAddress">सीमलिया</span>, राजस्थान  का/की मूल निवासी है।<br/><br/> आज दिनांक <span class="applicationDateTemp">25-11-2017</span> को यह प्रमाण पत्र मेरे डिजिटल हस्ताक्षर से प्रचलित किया गया। </div><br/>   <div style="width:100%; clear:both; font-size:15px;"> <div>नोट:</div> 1 . राजस्थान सरकार के गृह (ग्रुप -9) विभाग की अधिसूचना संख्या  प-15(1)32/गृह-9/61/ पार्ट-2 दिनांक 17.12.2009 के  द्वारा मूल निवास प्रमाण-पत्र जारी करने हेतु डिजिटल हस्ताक्षर के उपयोग को मान्यता प्रदान की गयी है।   <p>2. राजस्थान सरकार के गृह (ग्रुप -9) विभाग की आज्ञा संख्या  प-15(1)32/गृह-9/61/ पार्ट  दिनांक 28 अगस्त 2012 के द्वारा मूल निवास प्रमाण-पत्र जारी करने की मान्यता प्रदान की है | उक्त परिपत्र के तहत  जिला कलेक्टर , उपखंड अधिकारी, सहायक जिलाधीश व तहसीलदार मूल निवास प्रमाण-पत्र जारी करने हेतु अधिकृत किया हुआ है। </p>  <p> 3. उक्त मूल निवास  प्रमाण-पत्र शैक्षणिक और तकनीकी शिक्षा संस्थाओ में प्रवेश, योग्यता छात्रवृति के लिए आवदेन करने, केन्द्र/राज्य सेवाओं में  नियोजन प्रयोजनों एवं भूमि आदि के आवंटन इत्यादि के प्रयोजनार्थ हेतु उपयोग में लाया जा सकता है।  </p>  <p>4. प्रार्थी द्वारा प्रस्तुत किए गए मूल आवेदन पत्र एवं सम्बंधित दस्तावेज जिले के संबंधित प्रद्त अधिकारी जिसके हस्ताक्षर से यह जारी किया जायेगा के कार्यालय में  निरीक्षण/परीक्षण के  लिए उपलब्ध होंगे।  </p>   <p>5. मूल निवास एक बार ही बनाया जावेगा | लेकिन प्रमाण-पत्र ग़ुम हो जाने या क्षतिग्रस्त हो जाने पर दोहरी प्रति, प्रमाण-पत्र में नाम या पता बदलने पर संशोधित प्रति तथा आयु वृद्धि के अनुसार पहचान के लिए नए फोटो के साथ नवीनीकृत प्रति ( उक्त  नवीनीकृत प्रमाण-पत्र दस वर्ष के उपरान्त ही किया जा सकेगा )  बनवाया जा सकता है।  </p>   <p>6. सभी प्रयोजनार्थ प्रमाण-पत्र की सत्यापित प्रतियाँ काम में ली जा सकती है। </p>  <p>7. प्रार्थी को जारी किये गये  मूल निवास प्रमाण-पत्र  का सत्यापन   www.emitra.rajasthan.gov.in पर स्थित    ONLINE VERIFICATION SECTION से  Online सत्यापित किया जा सकता है।   टोकन संख्या  :  <span class="requestIDTemp">170071943938</span></p>   </div>     <div style="padding:5px; padding-top:10px;"> <div style="width: 50%;float:left;"> This Certificate is Electonically Signed By</br>SHARMANISHA03495 <h4 style="font-size:20px;"><span class="loggedUserOfficeNameshrtHindi">तहसीलदार,चाकसू,(जयपुर)</span> </h4> </div>  </div>
							
						</div> -->

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
									<a href="index" class="panel pull-right homebtn">
										<img src="img/new/homehindi.png" alt="" />
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
										<h1>भुगतान का तरीका चुनें</h1>
										<div class="feildone">
											<div class="col-md-12 paymentone">
												<%-- <input type="hidden" id="amt" value="10">
												<input type="hidden" id="token" value="${token}"> --%>
												<input type="hidden" id="amt" value="10">
												<input type="hidden" id="trnsID" value="${certiTransID}">
												<input type="hidden" id="serviceID" value="${serviceID}">
												<input type="hidden" id="token" value="${token}">
												<input type="hidden" id="serName" value="${serviceName}">
												<a onclick="csd()"> <img src="img/cash.png" />

													<h2>कैश</h2>
												</a>
											</div>
										<!-- <div class="col-md-4 paymentone">
												<a href="javascript:void(0);" id="fingurePaymewnt"> <img
													src="img/thumb.png" />

													<h2>बायोमेट्रिक</h2>
												</a>
											</div> -->
											<!-- <div class="col-md-6 paymentone">
												<a href="javascript:void(0);" id="eCardPayment"> <img
													src="img/credit.png" />

													<h2>क्रेडिट/ डेबिट कार्ड</h2>
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
														<p>	क्या आपको यकीन है ?</p>
														<p>जारी रखने के लिए सही  दबाएं और  <i class="fa fa-inr" 	aria-hidden="true"></i>
															<span id="Pamt"></span> नोट नकद संग्रह युक्ति में जमा करें
														</p>

													</div>
												</div>

											</div>

											<div class="modal-footer text-center"
												style="text-align: center">

												<button type="submit" class="btn btn-default getone"
													id="cash" onclick="ok();">सही</button>
												<a href="index" class="panel">
													<button class="btn btn-default getone" id="cancel">रद्द करना</button>
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
												<h5 class="modal-title">रोकड़  विवरण</h5>
											</div>

											<div class="modal-body">
												<div class="row">
													<div class="col-md-12 text-center">
														<h2>समय  विवरण : <span id="cashTimer"></span></h2>
														<h4>कुल जमा करने के लिए राशि : <span id="depositAmount"></span></h4>
														<table class="table table-bordered table-striped">
															<thead>
																<tr>
																	<th>रकम</th>
																	<th colspan="2">रोकड़</th>
																	<th>योग</th>
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

																	<td colspan="3">कुल रकम</td>
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
	</div>
	
	<form id="payment111">
		<input type="hidden" name="govtpdf" value="${url}">
	</form>
	<input type="hidden" value="0" name="emitraCertiTransactionId" id="emitraCertiTransactionId">
	
	<form id="certipayment">
		<input type="hidden" name="transactionId" value="0" id="csd">
		<input type="hidden" name="billAmount" value="0" id="csd1">
		<input type="hidden" name="certiServiceName" id="serviceName">
		<input type="hidden" value="1" name="langCode">
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
					//	alert("depositAmount : "+json[0].depositAmount);
						
						$("#depositAmount").html(json[0].depositAmount);
						
						return true;
					}
				}
				
			});
	   	}
	
		
		/* $(function() {
				$("#cash").bind('click', function(e) {
				var amt = $('#amt').val();
				var token = $('#token').val();
				// start calling function for showing note details
				var noteIntervalVar = setInterval(function(){ getNoteDetails(); }, 500);
				// End  calling function for showing note details
				
				
				$.ajax(
				//	 url : '/KioskService/cashAcceptor/'+amt+'/', 
					url : '/KioskService/cashAcceptor/'+amt+'/'+token+'/',
					type : "POST",
					success : function(data) {
						console.log(data);
						if(data=='NoData'){
							console.log("No Data Found");
							window.location.href="paymentErrorHi";
						} else if(data=='cancel'){
							clearInterval(noteIntervalVar);
							window.location.href="index";
						} else{
							setTimeout(function(){ printPDF('${url}'); }, 1000);
						//	printPDF('${url}');
						}

					},
					error : function(xhr, status, error) {
						window.location.href="paymentErrorHi";
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
							
								console.log(data);
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
										$('#loading').show();
										printPDF('${url}');
										/* document.getElementById('certipayment').action="certiPaymentSuccess";
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
		</script>

</body>
</html>