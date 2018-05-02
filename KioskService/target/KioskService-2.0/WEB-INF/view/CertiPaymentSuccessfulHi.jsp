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
											<h1 class="">आपका भुगतान सफलतापूर्वक किया गया है|</h1>
									        <c:set var="tid" value="${tid}"/>
									        <c:set var="receipt" value="${receipt}"/>
									         <c:set var="tdate" value="${tdate}"/>
										<table class="table">
											<thead>
												<tr>
													<th>फोन नंबर</th>
													<th>ईमेल आईडी</th>
													<th>सेवा</th>
													<th>बिल की राशि</th>
													<th>भुगतान योग्य राशि</th>
													<th>भुगतान का तरीका</th>
													<th>स्थिति</th>
												</tr>
											</thead>
											<tbody>
												<tr>
												<c:forEach items="${details}" var="fm" varStatus="loop">
													<td id="bill11">${fm.billMobileNo}</td>
													<td id="email11"></td>
													<td id="spname">${fm.serviceProviderName}</td>
													<td id="billActual">${fm.billActualAmount}</td>
													<td id="payable">${fm.billAmount}</td>
													<td id="payment">${fm.paymentMode}</td>
													<td id="msg">${fm.mSG}</td>

												</c:forEach>
												</tr>

											</tbody>
										</table>
										<input type="button" value="प्रिंट रसीद" id="printRec" onclick="csd();csd1()" class="panel btn btn-default getone">
									
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

	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
		<script type="text/javascript" src="js/app-inner.js"></script>
    <script>
 
	function csd() {
		var id1=document.getElementById('bill11').innerHTML;
		var id2="${tid}";
		var id4=document.getElementById('spname').innerHTML;
		var id5=document.getElementById('billActual').innerHTML;
		var id6=document.getElementById('payable').innerHTML;
		var id7="${tdate}";
		var id8=document.getElementById('payment').innerHTML;
		var dataString='&billMobileNo='+id1+'&transactionId='+id2
        +'&serviceProviderName='+id4+'&billActualAmount='+id5+'&billAmount='+id6+'&transcationDate='+id7+'&paymentMode='+id8;
		//alert("dataString::"+dataString);
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
