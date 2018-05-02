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
<title>Payment-Error</title>
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
										<h1 class="">
											Your payment was not successful.<br> Please try again or
											select a different payment type.
										</h1>
									</div>
								</div>
								<div class="modal fade" id="PaymentErrorBTB" role="dialog"
									data-backdrop="static" data-keyboard="false">
									<div class="modal-dialog">
										<div class="modal-content">

											<div class="modal-header" style="text-align: center">
												<h5 class="modal-title">RPP Payment Error Message</h5>
											</div>

											<div class="modal-body" style="text-align: center">
												<p>
													<span id="showError" style="color: red;"></span>
												</p>

											</div>
											<div class="modal-footer" style="text-align: center"></div>

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
	<c:set var="RPPFLAG" value="${RPPFLAG}"></c:set>
	<c:set var="RPPMSG" value="${RPPMSG}"></c:set>
	<c:set var="RPPSERVICEID" value="${RPPSERVICEID}"></c:set>
	<c:set var="RPPTXNID" value="${RPPTXNID}"></c:set>
	<c:set var="RPPPRN" value="${RPPPRN}"></c:set>
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js/app-inner.js"></script>
	<script type="text/javascript">
  	$( document ).ready(function() {
  		var flag = "${RPPFLAG}";
  	    if(flag=='1'){
  	    	var msg = "${RPPMSG}";
  	    	document.getElementById('showError').innerHTML=msg;
			$('#PaymentErrorBTB').modal('show');
			setTimeout(function(){
			    $('#PaymentErrorBTB').modal('hide');
			    console.log("trans : "+trans);
			    window.location.href = 'index';
			}, 10000);
  	    }
  	});
  	
  	
  	</script>
</body>

</html>
