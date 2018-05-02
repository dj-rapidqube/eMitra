<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
										<h1 class="">Your DISCOM Details Are </h1>
									    <div style="overflow-x:auto;">
										<table class="table">
											<thead>
												<tr>
													<th >K Number</th>
													<th>Name</th>
													<th>ChequeDueDate</th>
													<th>BillYear</th>
													<th>Message</th>
													<th>BillNo</th>
													<th>Account</th>
													<th>BillMonth</th>
													<th>CashDueDate</th>
													<!-- <th>OfficeCode</th> -->
													<th>Address</th>
													<!-- <th>PaymentType</th> -->
													<th>BinderNo</th>
													<th>TotalAmount</th>
													
												</tr>
											</thead>
											 <tbody>
												<tr>
												<c:forEach items="${details}" var="fm" varStatus="loop">
													<td >${fm.k_Number}</td>
													<td >${fm.name}</td>
													<td >${fm.chequeDueDate}</td>
													<td >${fm.billYear}</td>
													<td >${fm.message}</td>
													<td >${fm.billNo}</td>
													<td >${fm.account_number}</td>
													<td >${fm.billMonth}</td>
													<td >${fm.cashDueDate}</td>
													<%-- <td >${fm.officeCode}</td> --%>
													<td >${fm.address}</td>
													<%-- <td >${fm.paymentType}</td> --%>
													<td >${fm.binderNo}</td>
													<td >${fm.totalAmount}</td>

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
												<input type="hidden" name="name" value="${fm.name}">
												<input type="hidden" name="billEmail" value="${fm.email}">
												<input type="hidden" name="billMobileNo" value="${fm.mobile}">
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
									</div>
								</div>
								
							</div>
							 <div class="button_div">
                                <a href="index" class="panel">
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
