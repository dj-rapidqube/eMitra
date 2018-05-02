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
<title>Home</title>
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
										src="img/new/home.png" alt="" /></a>
								</div>
							</div>
						</div>
					</div>
					<div class="fourservices">
						<div class="innermid">
							<div class="container main_row">
								<div class="row">
									<div class="billmidmain">
										<h1 class="">Your PHED Details Are </h1>
									    <div style="overflow-x:auto;">
										<table class="table">
											<thead>
												<tr>
													<th>Consumer Name</th>
													<!-- <th>EmitraCId</th> -->
													<th>SubDivision</th>
													<th>Chouk Number</th>
													<th>Account Number</th>
													<!-- <th>BillMonth</th>
													<th>BillYear</th> -->
													<th>BillDate</th>
													<th>Mobile Number</th>
													<th>Amount Before DueDate</th>
													<th>Amount After DueDate</th>
													<th>CashDueDate</th>
													<th>ChequeDueDate</th>
													<!-- <th>Address</th>
													<th>Address2</th> -->
													<!-- <th>TranBillId</th> -->
													<th>Service Name</th>
													<th>Bill Amount</th>
													<th>Consumer KeyValue</th>
													<!-- <th>PartPaymentType</th> -->
													<!--<th>LookUpID</th> -->
													<!-- <th>SSOID</th> -->
												</tr>
											</thead>
											 <tbody>
												<tr>
												<c:forEach items="${details}" var="fm" varStatus="loop">
													<td >${fm.consumerName}</td>
													<%-- <td >${fm.emitraCId}</td> --%>
													<td >${fm.subDivision}</td>
													<td >${fm.choukNumber}</td>
													<td >${fm.accountNumber}</td>
													<%-- <td >${fm.billMonth}</td>
													<td >${fm.billYear}</td> --%>
													<td >${fm.billDate}</td>
													<td >${fm.mobileNumber}</td>
													<td >${fm.amountBeforeDueDate}</td>
													<td >${fm.amountAfterDueDate}</td>
													<td >${fm.cashDueDate}</td>
													<td >${fm.chequeDueDate}</td>
													<%-- <td >${fm.address}</td>
													<td >${fm.address2}</td> --%>
													<%-- <td >${fm.tranBillId}</td> --%>
													<td >${fm.serviceName}</td>
													<td >${fm.billAmount}</td>
													<td >${fm.consumerKeyValue}</td>
													<%-- <td >${fm.partPaymentType}</td> --%>
													<%-- <td >${fm.lookUpID}</td> --%>
													<%-- <td >${fm.ssoID}</td> --%>

												</c:forEach>
												</tr>

											</tbody>
										</table>
										<form id="click">
											<input type="hidden" id="billActualAmount" name="billActualAmount"  value="${infobill.billActualAmount}">
											<input type="hidden" id="billAmount" name="billAmount" value="${infobill.billAmount}" >
											<input type="hidden" id="transactionId" name="transactionId" value="${infobill.transactionId}" >
											<input type="hidden" id="serviceProviderID" name="serviceProviderID" value="${infobill.serviceProviderID}" >
											<input type="hidden" name="langCode" id="langCode" value="0" > 
											<c:forEach items="${details}" var="fm" varStatus="loop">
												<input type="hidden" name="name" value="${fm.consumerName}">
												<input type="hidden" name="billEmail" value="${fm.billEmailId}">
												<input type="hidden" name="billMobileNo" value="${fm.mobileNumber}">
												<input type="hidden" name="consumerKeyValue" value="${fm.consumerKeyValue}">
												<input type="hidden" name="createdDate" value="${fm.createdDate}">
											</c:forEach>
											
											
											<div class="twobtn onebtn">
												<c:choose>
													<c:when test="${infobill.billAmount=='NA'}">
														<input type="button" value="Click To Pay Now" 
															disabled="disabled" class="panel btn btn-default getone">
													</c:when>
													<c:otherwise>
														<input type="button" onclick="clicktopay()"
															value="Click To Pay Now" id="clickpay"
															class="panel btn btn-default getone">
													</c:otherwise>

												</c:choose>

											</div>

										</form>
										</div>
									<!-- 	<input type="button" value="Print Receipt" id="printRec" onclick="csd();csd1()" class="panel btn btn-default getone">
										 -->
									</div>
								</div>
								
							</div>
							 <div class="button_div">
                                <a href="phed" class="panel">
                                    <img src="img/new/back.png" alt=""></a>
                            </div>
							

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	   <div id="loading" style="display: none;">
	  <img id="loading-image" src="img/ajax-loader.gif" alt="Loading..." />
	</div>
	<form id="xyz">
	</form>
<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	  <script type="text/javascript"  src="js/jquery.scrollTo.js"></script>
	  <script type="text/javascript" src="js/app-inner.js"></script>

	 <script>
		function clicktopay() {
			$('#loading').show();
			document.getElementById('click').action = "clickToPay";
			document.getElementById('click').method = "POST";
			document.getElementById('click').submit();
		}
	</script>
 

</body>

</html>
