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
<title>सरकारी सेवाएं</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<!--   <link rel="stylesheet" href="css/bootstrap-material-design.min.css" /> -->
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
										<h1>कृपया <span id="serviceName"></span> प्रमाणपत्र देखने /छापने   के लिए अपना विवरण दर्ज करें</h1>
										<h5>केवल 1 जनवरी 2014 से उपलब्ध है</h5>
										<form id="certificate_details">
											<%-- <input type="hidden" name="certificateValue" value="${differ}">
											<input type="hidden" name="langCode" id="langCode" value="1">
											<input type="hidden" id="certificateDetails" name="certificateDetails" value="${certificateDetails}">
											 --%>
											<input type="hidden" name="certificateValue" value="${differ}">
											<input type="hidden" name="serviceID" value="${serviceID}">
											<input type="hidden" name="serviceName" value="${serviceName}">
											<input type="hidden" name="subServiceID" value="${subServiceID}">
											<input type="hidden" name="langCode" id="langCode" value="1">
											<input type="hidden" id="certificateDetails" name="certificateDetails" value="${certificateDetails}">
											
											 <div class="feildone" style="text-align: center">
												<div class="col-md-6 col-md-offset-3">
													<div class="col-md-4">
														<div class="billid">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">पंजीकरण संख्या<span style="color:red;">*</span></label>
														</div>
													</div>
													<div class="col-md-8">
														<div class="billidright">
															<div class="form-group">
																<input type="text" class="form-control"
																	required="required" autocomplete="off"
																	name="registrationNo" id="registrationNo"
																	placeholder="पंजीकरण संख्या दर्ज करें">
																<div class="billidright" id="errTokenId"></div>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-6 col-md-offset-3">
													<div class="col-md-4">
														<div class="billid">
															<label for="year" class="bmd-label-floating">पंजीकरण  वर्ष <span style="color:red;">*</span></label>
														</div>
													</div>
													<div class="col-md-8">
														<div class="billidright">
															<div class="form-group">
																<input type="text" class="form-control date-own"
																	name="year" id="year" placeholder="वर्ष दर्ज करें">
																<div class="billidright" id="errYear"></div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<div class="twobtn">
												<button class="btn btn-default getone" id="checkForm"
													type="button">दर्ज करें</button>
												<button class="btn btn-default getone"
													type="reset">रीसेट करें</button>
											</div>
										</form>

									</div>

								</div>

							</div>
							<div class="button_div">
								<a href="governmentservicehindi11" class="panel"> <img
									src="img/new/backhindi.png" alt=""></a>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="loading" style="display: none;">
		<img id="loading-image" src="img/ajax-loader.gif"
			alt="लोड हो रहा है..." />
	</div>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js/app-inner.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
				$(function() {
					var id ="${subServiceID}";
					if(id==300){
						$("#serviceName").html("जन्म");	
					}else if(id==400){
						$("#serviceName").html("मृत्यु");
					}else if(id==500){
						$("#serviceName").html("विवाह पंजीकरण");
					}
					
					
					$("#checkForm")	.on('click',function() {
						$("#errTokenId").html('');
						if ($("#registrationNo").val().trim() == '') {
							$("#errTokenId").html('<p style="color:red;float: left;">* पंजीकरण संख्या दर्ज करें</p>');
							$("#registrationNo").focus();
							return false;
						}
						$("#errYear").html('');
						if ($("#year").val().trim() == '') {
							$("#errYear").html('<p style="color:red;float: left;">*वर्ष दर्ज करें </p>');
							$("#year").focus();
							return false;
						}


						$('#loading').show();
						$("#certificate_details").attr("action", "CertificateService");
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

