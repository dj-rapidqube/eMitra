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
										<h1 class="">Your payment is successfully
											done</h1>
									        <c:set var="tid" value="${tid}"/>
									        <c:set var="receipt" value="${rECEIPTNO}"/>
									         <c:set var="tdate" value="${tdate}"/>
										<table class="table">
											<thead>
												<tr>
													<th>Name</th>
													<th>Phone NO</th>
													<th>Email ID</th>
													<th>Service</th>
													<th>Bill Amount</th>
		           									<th>Payable Amount</th>
													<th>Due Date</th>
													<th>Payment Mode</th>
													<th>Status</th>
												</tr>
											</thead>
											<tbody>
												<tr>
												<c:forEach items="${details}" var="fm" varStatus="loop">
													<td id="name11">${fm.name}</td>
													<td id="bill11">${fm.billMobileNo}</td>
													<td id="email11">${fm.billEmail}</td>
													<td id="spname">${fm.serviceProviderName}</td>
													<td id="billActual">${fm.billAmount}</td>
													<td id="payable">${fm.billActualAmount}</td>
													<td>${fm.dueDate}</td>
													<td id="payment">${fm.paymentMode}</td>
													<td id="msg">${fm.mSG}</td>

												</c:forEach>
												</tr>

											</tbody>
										</table>
										<input type="button" value="Print Receipt" id="printRec" onclick="csd();csd1()" class="panel btn btn-default getone">
									
									</div>
								</div>
								
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="xyz">
	</form>
	<%-- <c:set var="detaillist" value="${details}"></c:set> --%>
<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	  <script type="text/javascript"  src="js/jquery.scrollTo.js"></script>
	  <script type="text/javascript" src="js/app-inner.js"></script>
	
 <script>
 
	function csd() {
		var id=document.getElementById('name11').innerHTML;
		var id1=document.getElementById('bill11').innerHTML;
		var id2="${tid}";
		var id3=document.getElementById('email11').innerHTML;
		var id4=document.getElementById('spname').innerHTML;
		var id5=document.getElementById('billActual').innerHTML;
		var id6=document.getElementById('payable').innerHTML;
		var id7="${tdate}";
		var id8=document.getElementById('payment').innerHTML;
		var dataString='name='+id+'&billMobileNo='+id1+'&transactionId='+id2
        +'&billEmail='+id3+'&serviceProviderName='+id4+'&billActualAmount='+id5+'&billAmount='+id6+'&transcationDate='+id7+'&paymentMode='+id8;
		$.ajax({
			type:'POST',
			data:dataString,
			url:'printReceipt',
			success:function(data){
				
			}
		})
	}
	
	function csd1()
	{
		document.getElementById('xyz').action="hello11";
		document.getElementById('xyz').method="POST";
		document.getElementById('xyz').submit();
	}
 </script>
</body>

</html>
