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
<title>KIOSK - Home</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	type="text/css" rel="stylesheet">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-material-design.min.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link href="css/my-style.css" type="text/css" rel="stylesheet" />

</head>

<body>
	<div id="wrapper">
		<div id="mask">

			<div id="bill" class="item">
				<div class="content">
					<!--<a href="#item1" class="panel">back</a> -->
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
											<a href=""> <img src="img/logo-inner.png" alt="" /></a>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<a href="index" class="panel pull-right homebtn">
										<img src="img/new/home.png" alt="" />
									</a>
								</div>
							</div>
						</div>
					</div>
					<c:set var="serviceId" value="${serviceProvider.serviceProviderID}" />
					<div class="fourservices">
						<div class="innermid">
							<div class="container main_row">
								<div class="row">
									<div class="billmidmain">
										<h1>Please enter your details for
											${serviceProvider.serviceProviderName} BILL</h1>
										<form id="bill_details">
											<input type="hidden" name="serviceProviderName"
												id="serviceProviderName"
												value="${serviceProvider.serviceProviderName}" /> <input
												type="hidden" name="serviceProviderID"
												id="serviceProviderID" value="0" />
												<input type="hidden" name="langCode" id="langCode" value="0" />
											<div class="feildone">
												<div class="col-md-6">
													<div class="col-md-4">
														<div class="billid">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">Email Id</label>
														</div>
													</div>
													<div class="col-md-8">
														<div class="billidright">
															<div class="form-group">
																<input type="email" class="form-control"
																	autocomplete="off" name="billEmail" id="billEmail"
																	placeholder="Enter Email-Id" required="required">
															</div>
														</div>
														<div class="billidright" id="errEmail"></div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="col-md-4">
														<div class="billid">
															<label for="exampleInputEmail1" id="contacttext"
																class="bmd-label-floating"></label>
														</div>
													</div>
													
													
													<c:choose>
														<c:when test="${serviceId == 2575}">
															<div class="col-md-3">
																<select name="bsnlType" id="bsnlType"
																	style="padding: 5px;">
																	<option id="mobile" value="mobile">Mobile</option>
																	<option id="landLine" value="landline">LandLine</option>
																</select>
															</div>
															<div class="col-md-5" id="mobileinput">
																<div class="billidright">
																	<div class="input-group form-group">
																		<div class="input-group-addon input-land"
																			style="width: 38px; background: #dedada;">+91</div>
																		<input type="text" class="form-control mobilenoph"
																			autocomplete="off" name="billMobileNo"
																			id="billMobileNo" placeholder="Enter Mobile NO"
																			required="required">
																	</div>
																</div>
																<div class="billidright" id="errMobile"></div>
															</div>
														
														</c:when>

														<c:otherwise>
														
															<div class="col-md-8">
																<div class="billidright">
																	<div class="input-group form-group">
																		<div class="input-group-addon"
																			style="width: 38px; background: #dedada;">+91</div>
																		<input type="text" class="form-control"
																			autocomplete="off" name="billMobileNo"
																			id="billMobileNo" placeholder="Enter Mobile Number"
																			required="required">
																	</div>
																</div>
																<div class="billidright" id="errMobile"></div>
															</div>
														</c:otherwise>

													</c:choose>
													
												</div>
											</div>

											<!--  <div class="feildone"></div> -->

											<div class="twobtn">
												<button class="btn btn-default getone" id="serviceBill"
													type="button">GET BILL</button>
												<button class="btn btn-default getone"
													type="reset">RESET</button>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="button_div">
								<a href="serviceprovider"> <img
									src="img/new/back.png" alt="" />
								</a>
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
	<script type="text/javascript" src="js/app.js"></script>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>

	<script type="text/javascript">
	
		 $("#bsnlType").change(function(){
	     	var bsnlType = this.value;	   
			if(bsnlType == "landline"){						
				$("#contacttext").text("Landline*");
				$(".input-land").hide();
				$(".mobilenoph").attr('placeholder','Enter Landline NO');	
				$("#errMobile").html('<p style="font-size:13px; float: left;">Note:-BSNL Landline Format XXXXXXXXXX. Ex.1412305647</p>');
			}
			else{				
				$("#contacttext").text("Mobile NO*");
				$(".mobilenoph").attr('placeholder','Enter Mobile NO');
				$(".input-land").show();
				$("#errMobile").html("");
			}
	    });
	 
	 
		$(function() {	
			$("#contacttext").text("Mobile NO*");	
			$("#serviceBill").on('click',function() {
				$("#serviceProviderID").val("${serviceId}");
				var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				//	alert("serviceId  :: "+$("#serviceProviderID").val());
				//	alert("billMobileNo : "+$("#billMobileNo").val()+" billEmail : "+$("#billEmail").val());
				var contact = $.trim($("#billMobileNo").val());
				var emailid = $.trim($("#billEmail").val());
				var bsnlType = $('#bsnlType :selected').val();
				$("#errEmail").html('');
				$("#errMobile").html('');

				if (emailid != '') {
					if (!regex.test(emailid)) {
						$("#billEmail").focus();
						$("#errEmail").html("<span style='color:red '>* Enter Valid Email ID</span>");
						return false;
					}
				}
				if(bsnlType == "landline"){		
					if (contact == '') {
						$("#errMobile").html('<p style="color:red; font-size:13px;float: left;">* Enter Landline no.</p>');
						$("#billMobileNo").focus();
						//setTimeout(function(){$("#errMobile").html('')}, 3000);
						return false;
					}
					if (contact != '') {
						if (!$.isNumeric(contact)) {
							$("#billMobileNo").focus();
							$("#errMobile").html("<span style='color:red; font-size:13px;float: left;'>* Enter valid landline number</span>");
							return false;
						} else if (contact.length != 10) {
							$("#billMobileNo").focus();
							$("#errMobile").html("<span style='color:red; font-size:13px;float: left;'>* Enter valid 10 digits landline number.</span>");
							return false;					
						}
					}
				}else{
					if (contact == '') {
						$("#errMobile").html('<p style="color:red;float: left; font-size:13px;float: left;">* Enter mobile no.</p>');
						$("#billMobileNo").focus();
						//setTimeout(function(){$("#errMobile").html('')}, 3000);
						return false;
					}
					if (contact != '') {
						if (!$.isNumeric(contact)) {
							$("#billMobileNo").focus();
							$("#errMobile").html("<span style='color:red'>* Enter valid contact number</span>");
							return false;
						} else if (contact.length != 10) {
							$("#billMobileNo").focus();
							$("#errMobile").html("<span style='color:red'>* Enter valid 10 digits contact number.</span>");
							return false;					
						}
					}
				}
				

				
				
				if (emailid == '') {
					/* $("#billEmail").focus();
					$("#errEmail").html("<span style='color:red'>* Enter Email ID</span>");
					return false; */
					$("#billEmail").val('helpdesk.emitra@rajasthan.gov.in');
				}
				
				$('#loading').show();
				$("#bill_details").attr("action", "billinfo");
				$("#bill_details").attr("method", "post");
				$("#bill_details").submit();
			})
		});
	</script>


</body>

</html>
