<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>GOVERNMENT SERVICES</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<!-- <link rel="stylesheet" href="css/bootstrap-material-design.min.css" /> -->
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap-datepicker.css" type="text/css"
	rel="stylesheet" />
</head>

<body style="background: url(img/inner-bg.png); background-size: cover;">

	<div id="wrapper">
		<div id="mask">


			<div id="bill" class="item">
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
										<h1>Please enter your detail for viewing/printing ${serviceName} </h1>
										<h5>Available Only From 1 January 2014 Onwards</h5>
										<form id="certificate_details">
											<%-- <input type="hidden" name="certificateValue" value="${differ}">
											<input type="hidden" name="langCode" id="langCode" value="0">
											<input type="hidden" id="certificateDetails" name="certificateDetails" value="${certificateDetails}">
											 --%>
											<input type="hidden" name="certificateValue" value="${differ}">
											<input type="hidden" name="serviceID" value="${serviceID}">
											<input type="hidden" name="serviceName" value="${serviceName}">
											<input type="hidden" name="subServiceID" value="${subServiceID}">
											<input type="hidden" name="langCode" id="langCode" value="0">
											<input type="hidden" id="certificateDetails" name="certificateDetails" value="${certificateDetails}">
											
											 
											 <div class="feildone" style="text-align: center">
												<div class="col-md-6 col-md-offset-3">
													<div class="col-md-4">
														<div class="billid">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">Registration ID<span style="color:red;">*</span></label>
														</div>
													</div>
													<div class="col-md-8">
														<div class="billidright">
															<div class="form-group">
																<input type="text" class="form-control"
																	required="required" autocomplete="off"
																	name="registrationNo" id="registrationNo"
																	placeholder="Enter Registration No"> 
																<div class="billidright" id="errTokenId"></div>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-6 col-md-offset-3">
													<div class="col-md-4">
														<div class="billid">
															<label for="year" class="bmd-label-floating">Registration Year<span style="color:red;">*</span></label>
														</div>
													</div>
													<div class="col-md-8">
														<div class="billidright">
															<div class="form-group">
																<input type="text" class="form-control date-own"
																	name="year" id="year" placeholder="Select Year">
																<div class="billidright" id="errYear"></div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<div class="twobtn">
												<button class="btn btn-default getone" id="checkForm"
													type="button">Submit</button>
												<button class="btn btn-default getone"
													type="reset">RESET</button>
											</div>
										</form>

									</div>

								</div>

							</div>
							<div class="button_div">
								<a href="governmentServiceProvider" class="panel"> <img
									src="img/new/back.png" alt=""></a>

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
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js/app-inner.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>

	<script type="text/javascript">
		$(function() {
			$("#checkForm")	.on('click',function() {
				$("#errTokenId").html('');
				if ($("#registrationNo").val().trim() == '') {
					$("#errTokenId").html('<p style="color:red;float: left;">* Enter Registration No</p>');
					$("#registrationNo").focus();
					return false;
				}
				$("#errYear").html('');
				if ($("#year").val().trim() == '') {
					$("#errYear").html('<p style="color:red;float: left;">* Select Year</p>');
					$("#Year").focus();
					return false;
				}
				$('#loading').show();
				$("#certificate_details").attr(	"action", "CertificateService");
				$("#certificate_details").attr(	"method", "post");
				$("#certificate_details").submit();

			})
		});
		$(document).ready(function() {

			$('#year').datepicker({
				minViewMode : 2,
				autoclose : true,
				format : 'yyyy'
			});

		});
	</script>
</body>

</html>

