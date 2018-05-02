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
<title>Kiosk - बिल विवरण</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link href="css/my-style.css" type="text/css" rel="stylesheet" />

</head>

<body style="background: url(img/inner-bg.png); background-size: cover;">

	<div id="wrapper">
		<div id="mask">

			<div id="payment_succ" class="item">
				<div class="content">
					<!--<a href="#item1" class="panel">back</a>-->
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
										src="img/new/homehindi.png" alt="" /></a>
								</div>
							</div>
						</div>
					</div>
					<div class="fourservices">
						<div class="innermid">
							<div class="container main_row">
								<div class="row">
									<div class="billmidmain">
										<h1 class="">आपका  बिल विवरण</h1>
										<table class="table">
											<thead>
												<tr>
													<th>नाम</th>
													<th>फोन नंबर</th>
													<th>ईमेल आईडी</th>
													<th>सेवा</th>
													<th>बिल की राशि</th>
													<th>नियत तारीख</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${details}" var="fm" varStatus="loop">
													<tr>
														<td>${fm.name}</td>
														<td>${fm.billMobileNo}</td>
														<td>${fm.billEmail}</td>
														<td>${fm.serviceProviderName}</td>
														<td>
															<c:choose>
																<c:when test="${fm.partpaymentallow}">
																	<input type="text" class="form-control"
																	autocomplete="off"
																	name="udpateAmount" id="udpateAmount" value="${fm.billAmount}" style="width: 80%; margin-left: 15px;">
																	<input type="hidden" id="partpaymenttype" name="partpaymenttype" value="${fm.partpaymenttype}" >
																</c:when>
																<c:otherwise> ${fm.billAmount} </c:otherwise>
															</c:choose>
															<input type="hidden" id="partpaymentallow" name="partpaymentallow" value="${fm.partpaymentallow}" >
														</td>
														<td>${fm.dueDate}</td>

													</tr>
												</c:forEach>

											</tbody>
										</table>
										<form id="click">
											<input type="hidden" id="billActualAmount" name="billActualAmount"  value="${infobill.billActualAmount}">
											<input type="hidden" id="billAmount" name="billAmount" value="${infobill.billAmount}" >
											<input type="hidden" id="transactionId" name="transactionId" value="${infobill.transactionId}" >
											<input type="hidden" id="serviceProviderID" name="serviceProviderID" value="${infobill.serviceProviderID}" >
											<input type="hidden" name="langCode" id="langCode" value="1" />
											
											<c:forEach items="${details}" var="fm" varStatus="loop">
												<input type="hidden" name="name" value="${fm.name}">
												<input type="hidden" name="billEmail" value="${fm.billEmail}">
												<input type="hidden" name="billMobileNo" value="${fm.billMobileNo}">
												<input type="hidden" name="createdDate" value="${fm.createdDate}">
											</c:forEach>
											
											
											<div class="twobtn onebtn">
												<c:choose>
													<c:when test="${infobill.billAmount=='NA'}">
														<input type="button" value="अब भुगतान करने के लिए क्लिक करें" 
															disabled="disabled" class="panel btn btn-default getone">
													</c:when>
													<c:otherwise>
														<input type="button" onclick="clicktopay()"
															value="अब भुगतान करने के लिए क्लिक करें" id="clickpay"
															class="panel btn btn-default getone">
													</c:otherwise>

												</c:choose>

											</div>

										</form>
										<p id="errUpdateAmount"></p>
									</div>
								</div>

							</div>


							<div class="button_div">
								<a href="serviceproviderHi" class="panel"> <img src="img/new/backhindi.png"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	 <div id="loading" style="display: none;">
	  	<img id="loading-image" src="img/ajax-loader.gif" alt="लोड हो रहा है..." />
	</div>
		<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js/app-inner.js"></script>

	<script>

	function clicktopay() {
		var billAmount = $("#billActualAmount").val();
	 	$("#errUpdateAmount").html("");
	 	var partpaymentallow = $("#partpaymentallow").val();
		var tid= $("#transactionId").val();
		
		if(partpaymentallow  == 'true'){
			var udpateAmount = $("#udpateAmount").val();
			var letters = /^[0-9\.]+$/;
			if(udpateAmount==null){
				$("#errUpdateAmount").html("<span style='color:red;'>* कृपया जमा राशि दर्ज करें</span>");
				$("#udpateAmount").focus();
				return false;
			}else if(!udpateAmount.match(letters)) {
				$("#errUpdateAmount").html("<span style='color:red;'>* कृपया केवल सकारात्मक राशि दर्ज करें। कृपया पुनः प्रयास करें</span>");
				$("#udpateAmount").focus();
				return false;
			}else if (parseInt(udpateAmount) <= 0 || isNaN(udpateAmount)) {
		    	$("#errUpdateAmount").html("<span style='color:red;'>* कृपया 0 रुपये से अधिक राशि दर्ज करें। कृपया फिर से प्रयास करें</span>");
				$("#udpateAmount").focus();
				return false;
		    }else if (Math.sign(udpateAmount)!=1 ){
		    	//alert("(Math.sign(udpateAmount)  :: "+(Math.sign(udpateAmount)));
		    	$("#errUpdateAmount").html("<span style='color:red;'>* कृपया 0 रुपये से अधिक राशि दर्ज करें। कृपया फिर से प्रयास करें।</span>");
				$("#udpateAmount").focus();
				return false;
		    }else if(billAmount != udpateAmount){
			//	alert("(Math.sign(udpateAmount)  2222:: "+(Math.sign(udpateAmount)));
				var partpaymenttype = $("#partpaymenttype").val();
			//	alert("amount : "+udpateAmount+" partpaymenttype : "+partpaymenttype);
				if(partpaymenttype=="Above"){
					if(billAmount<udpateAmount){
						$("#errUpdateAmount").html("<span style='color:red;'>* कृपया बिल की राशि से अधिक राशि दर्ज करें ।</span>");
						$("#udpateAmount").focus();
						return false;
					}
				}else if(partpaymenttype=="Below"){
					if(billAmount>udpateAmount){
						$("#errUpdateAmount").html("<span style='color:red;'>* कृपया  बिल राशि से कम राशि दर्ज करें ।</span>");
						$("#udpateAmount").focus();
						return false;
					}
				}
				
				$.ajax({
					url : '/KioskService/CashMachineAmount/'+udpateAmount+'/'+partpaymenttype+'/'+tid+'/',
					type : "POST",
					success : function(data) {
						$("#billActualAmount").val(udpateAmount);
						$("#billAmount").val(data);
						document.getElementById('click').action = "clickToPay";
						document.getElementById('click').method = "POST";
						document.getElementById('click').submit();
					},
					error : function(xhr, status, error) {
						//alert("Some Error Occoured..");
						console.log("कुछ त्रुटि हुई..");
					}
				});
				
			}else{
		 		$('#loading').show();
				document.getElementById('click').action = "clickToPay";
				document.getElementById('click').method = "POST";
				document.getElementById('click').submit(); 
			}
		}else if (Math.sign(billAmount)!=1 ){
			//	alert("(Math.sign(udpateAmount)  111:: "+(Math.sign(billAmount)));
			$("#errUpdateAmount").html("<span style='color:red;'>* आपका बिल राशि रु 0 से अधिक नहीं है, इसलिए आप अपना बिल नहीं दे सकते ।</span>");
			return false;
		}else{
	 		$('#loading').show();
			document.getElementById('click').action = "clickToPay";
			document.getElementById('click').method = "POST";
			document.getElementById('click').submit(); 
		}
		
	}
	</script>
</body>

</html>
