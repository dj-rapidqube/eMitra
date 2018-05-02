<%@ page language="java" contentType="text/html; charset=utf-8"
	 pageEncoding="utf-8"%>
	 <%@page import="java.util.Hashtable"%>
	  <%@page import="java.util.Map"%>
	   <%@page import="java.util.HashMap"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Agriculture Department</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700" rel="stylesheet" />
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
</head>

<body style="background: url(img/inner-bg.png); background-size: cover;">

    <div id="wrapper">
        <div id="mask">

            <div id="fill" class="item gr">
                <div class="content">
                    <!--<a href="#item1" class="panel">back</a>-->
                    <div class="mainone innermaintop">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="logomain">
                                        <div class="cartoon innercartoon">
                                            <img src="img/cartooon-bg-inner.png" alt="" />
                                            <img src="img/bubble.png" class="bubble" alt="" />
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="logomain midinnerlogomain">
                                        <div class="logo midinnerlogo">
                                            <a href="#">
                                                <img src="img/logo-inner.png" alt="" /></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <a href="index" class="panel pull-right homebtn">
                                        <img src="img/new/home.png" alt="" /></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="fourservices">
                        <div class="innermid">
                            <div class="container main_row">
                                <div class="row circle-container">
                                       <div class="billmidmain">
                                        <h1 class="">PLEASE ENTER YOUR DETAILS FOR Disability Certificate</h1>   
                                         <h5>Available Only From 1 January 2017 Onwards</h5>
                                         <label id="adharError" style="color:red">${adharError}</label>
                                        <form id="Finger_details">
											<input type="hidden" name="serviceID" value="${serviceID}">
											<input type="hidden" name="serviceName" value="${serviceName}">
											<input type="hidden" name="subServiceID" value="${subServiceID}">
											<input type="hidden" name="authaadhar" value="${authaadhar}" id="authaadhar">
											<input type="hidden" name="langCode" id="langCode" value="0">
											<input type="hidden" id="certificateDetails" name="certificateDetails" value="${certificateDetails}">
                                        <div class="feildone" style="text-align: center">
												<div class="col-md-7 col-md-offset-2">
													<div class="col-md-5">
														<div class="billid">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">Aadhaar Number <span style="color:red">*</span></label>
														</div>
													</div>
													<div class="col-md-7">
														<div class="billidright">
															<div class="form-group">
																<input type="text" class="form-control"
																	 autocomplete="off" name="addhaarid"
																	id="uid" placeholder="Enter Aadhaar Number" required>
																<div class="billidright" id="uidError"></div>
															</div>
														</div>
													</div>
												</div>
		
											</div>  
										            
											 <div class="feildone" style="text-align: center">
												<div class="col-md-7 col-md-offset-2">
													<div class="col-md-5">
														<div class="billid">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">Application Serial No<span style="color:red">*</span></label>
														</div>
													</div>
													<div class="col-md-7">
														<div class="billidright">
															<div class="form-group">
																<input type="text" class="form-control"
																	required="required" placeholder="Enter Application Serial No" autocomplete="off" name="serialNo"
																	id="application_sno"  >
																<div class="billidright" id="serialError"></div>
															</div>
														</div>
													</div>
												</div>
											</div>  
											 <div class="twobtn">
												<button class="btn btn-default getone" id="checkForm"
													type="button">Submit</button>
												<button class="btn btn-default btn-raised getone"
													type="reset">Reset</button>
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
        <div class="modal fade" id="myModal" role="dialog"
		data-backdrop="static" data-keyboard="false">
	
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Please Enter Aadhaar OTP Authentication</h4>
				</div>
				
				<div class="modal-body">
				<form id="Finger">
			
				<input type="text" class="form-control" placeholder="Enter OTP" autocomplete="off" name="aadhaar_otp"
																	id="aadhaar_otp" />
						<input type="hidden" name="serviceID" value="${serviceID}" />
						<input type="hidden" name="serviceName" value="${serviceName}" />
						<input type="hidden" name="subServiceID" value="${subServiceID}" />
						<input type="hidden" name="langCode" id="langCode" value="0">
						<input type="hidden" id="certificateDetails" name="certificateDetails" value="${certificateDetails}" />
						<input type="hidden" name="serialNo" value="${applicationno}" />
						<input type="hidden" name="addhaarid" value="${addhaarid}" />
						<input type="hidden" name="otptransectionId" value="${otptransectionId}" />
						<input type="hidden" name="otpstatus" value="${otpstatus}" id="otpstatus" />
						<label id="otperror" style="color:red">${message}</label>				
						<div class="modal-footer" style="text-align: center">
						
				</div>
					</form>	
					<button class="btn btn-default getone" id="checkForm1">Yes</button>
					<button class="btn btn-default getone" data-dismiss="modal">No</button>										
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
	<script type="text/javascript">
		$(function() {
			
			$("#checkForm1").on('click',	function() {
				var otp = $('#aadhaar_otp').val().trim();
				if(otp=="" | otp.length==0){
					$("#otperror")[0].innerHTML = "Please Enter OTP";
				}else if(!$.isNumeric(otp)){
					$("#otperror")[0].innerHTML = "OTP should contains only number";
				}
				else{
					$('#myModal').modal('hide');
					$('#loading').show();
				 	$("#Finger").attr("action", "disabilityOtpAuthChecking");
				    $("#Finger").attr("method", "post");
				    $("#Finger").submit();
				}
			});
		});
		
		$(document).ready(function(){
			 var authaadhar = $('#authaadhar').val();
			 var otpstatus = $('#otpstatus').val();
			if(otpstatus=="y" && authaadhar=="Yes"){
				 $("#myModal").modal();
				 $('#loading').hide();
			} 
		});

	
		
	 	$("#checkForm").click(function(){
	 		$('#loading').show();
			$('#uidError').html("");
			$('#serialError').html("");
			var uid =$('#uid').val().trim();
			var serial = $('#application_sno').val().trim();
			if(uid=="" | uid.length==0 ){
				$('#uidError').html("<p style='color:red;float: left;'>*Please Enter Aadhaar Number. </p>");
				$('#uid').focus();
		 	}else if(uid.length < 12 | !$.isNumeric(uid) | uid.length > 12){
				$('#uidError').html("<p style='color:red;float: left;'>*Please enter valid 12 digit Aadhar Number. </p>");
				$('#uid').focus();
			}else	if(serial=="" | serial.length==0){
				$('#serialError').html("<p style='color:red;float: left;'>*Please enter application serial number. </p>");
				$('#application_sno').focus();
			}else{
				$("#Finger_details").attr("action", "disabilityAuthRequest");
			    $("#Finger_details").attr("method", "post");
			    $("#Finger_details").submit();
			}
		}); 

	</script>
</body>

</html>