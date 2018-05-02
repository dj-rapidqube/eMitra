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
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-material-design.min.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="css/slick-theme.css" />
    <link rel="stylesheet" type="text/css" href="css/slick.css" />
      <style>
    .versionbox{
        position: fixed;
	    top: 130px;
	    left: 11%;
	    height: 40px;
	    width: 25%;
	    padding-top: 5px;	    
	    font-weight: 700;
	   
   	}
    .versionbox h4{
      color: #ec4556 !important;
       font-size: 15px;
       text-transform: uppercase;
    }
    </style>
</head>

<body>
    <div id="wrapper">
        <div id="mask">
            <div id="item1" class="item home_back">
                <div class="topone">
                    <div class="container">
                        <div class="col-md-12">
                            <div class="col-md-4 logo_div">
                                <img src="img/logo.png" class="logo">
                            </div>
                            <!--<div class="col-md-4 emitra_div"><img src="img/e-mitra.png" class="emitra_logo"></div>-->
                            <div class="col-md-4"></div>
                        </div>
                        <div class="col-md-12 lahar">
                            <img src="img/home_red1.png" class="lahar_img">
                            <div class="lang_div">
                             <!--   <img src="img/e-mitra.png" class="left_e">-->
                                <div>
                                    <a class="btn btn-default panel" href="servicehindi" id="hindi">
                                        <img src="img/hindi.png" class="lang_btn"></a>
                                    <a class="btn btn-default panel" href="service" id="hindi">
                                        <img src="img/english.png" class="lang_btn"></a>
                                    <!-- <a class="btn btn-default panel" href="#" id="refaundbox">
                                        <img src="img/Refund.png" class="lang_btn"></a> -->
                                        
                                        
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-md-12 versionbox">
								<h4>
									Version 2.2
								</h4>
							</div>
                        
                       <img src="img/cartooon-new.png" id="myImage" onclick="changeImage()" class="a" alt="" />
                    </div>
                </div>
            </div>
        </div>
    </div>

	<div class="modal fade" id="refaundm" role="dialog" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header myhead refunfhead">
					Kiosk Operator Verification
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>


				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 text-center">
							<div class="col-md-12" id="kioskmess">
								<span id="reftext">Are You Kiosk Operator For this
									Machine</span>
							</div>

							<div class="form-group col-md-12 verifyRefundOTP">
								<label class="col-sm-3 control-label" for="form-field-1">Enter
									OTP</label>
								<div class="col-sm-9">
									<div class="input-group form-group">
										<form id="OTPVerify">
											<input type="text" id="otp" name="otp"
												placeholder="Enter OTP" class="form-control" />
										</form>
									</div>
								</div>

								<div
									class="form-group col-md-12 errorMessage alert alert-danger fade in">
									<p id="error"></p>
								</div>

								<div class="col-sm-2">
									<input type="button" id="btnVerify"
										class="btn btn-default btn-raised getone" value="Verify OTP">
								</div>
							</div>

						</div>
					</div>

				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 text-center">
							<div class="modal-footer text-center">
								<div class="row">
									<div class="col-md-12 text-center">
										<button type="button" class="btn btn-default getone"
											id="yesref">Yes</button>
										<button type="button" class="btn btn-default getone"
											id="noref">NO</button>

									</div>
								</div>
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
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/app.js"></script>
    <script type="text/javascript" src="js/jquery.flexisel.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/slick.js"></script>
    <script type="text/javascript">
    
    
	    $('#otp').keypress(function(event) {
	        if (event.keyCode == 13) {
	            event.preventDefault();
	        }
	    });
    
        $("#refaundbox").click(function () {
        	 $('#refaundm').modal('show');
        	 $("#reftext").html("Are You Kiosk Operator For this Machine");
        	 $('#yesref').show();
        	 $('#noref').show();
        	 $('.errorMessage').hide();
        	 $('.verifyRefundOTP').hide();
        	 
        });
        
        $("#noref").click(function () {        	
        	$("#reftext").html("You are not Authorised person to avail this service");
        	 $('#yesref').hide();
        	 $('#noref').hide();
        	 $('.errorMessage').hide();
        	 $('.verifyRefundOTP').hide(); 
       });
        
        $("#yesref").click(function () {        	
        	$("#reftext").html("");
        	 $('#yesref').hide();
        	 $('#noref').hide();
        	 $('.errorMessage').hide();
        	 $('#refaundm').hide();
        	 $('#loading').show();
        	 
        	 $.post("generateRefundOTP",null, function (data) {  
        		        		 
        		 $('#refaundm').show();
        		 $('.verifyRefundOTP').show();
                 $('#loading').hide();
                 
             })
        	 
       });
        
        $("#btnVerify").click(function () { 
        	
        	$("#reftext").html("");
        	 $('#yesref').hide();
        	 $('#noref').hide();
        	 
        	 var otpValue = $("#otp").val();
        	 
        	 if(isAllBasicOTPValidationCorrect(otpValue)){
        		 
        		$('#refaundm').modal('hide');
        		$('#loading').show();
        		document.getElementById("OTPVerify").action = "verifyRefundOTP";
     			document.getElementById("OTPVerify").method = "post";
     			document.getElementById("OTPVerify").submit();
     			
        	 }
        	 
       });
        
        
        function isAllBasicOTPValidationCorrect(otpValue){
        
        	var isAPINeedToCall = true;
        	
        	if(otpValue == null ||  otpValue  == ''){
        		
	       		 //show error message to user
	       		 $("#error").html("Please enter OTP number");
	       		 $('.errorMessage').show();
	       		 $("#otp").focus();
	       		 
	       		 isAPINeedToCall = false;
       		 
       	 	}else{
       	 		
       		 	//check opt field should contain only numeric value
       		 	
	       		 if (!$.isNumeric(otpValue)) {
	       				
	       			$("#error").html("Entered OTP must be numeric");
	       			$('.errorMessage').show();
	       			$("#otp").focus();
					
	       			isAPINeedToCall = false;
	          		 
	       		 }
       		 
       	 	}
        	
        	return isAPINeedToCall;
        	
        }
        
      	window.onload = function(){
      		$("#error").html("");
      		<%if(request.getAttribute("OTPSent") != null){
      		if((request.getAttribute("OTPSent")).equals("Sent")){
      		%>
      		$('#refaundm').modal('show');
      		$('#reftext').hide();
      		$('#yesref').hide();
      		$('#noref').hide();
      		$('.alertPopup').hide();
      		$('.errorMessage').hide();
      		$('.verifyRefundOTP').show();      		
      		<% } 
      		}
      		if(request.getAttribute("OTPCorrect") != null){
      		
      			if((request.getAttribute("OTPCorrect")).equals("No")){ %>
      			
      				$('#loading').hide();	
      				$('#refaundm').modal('show');
      				$("#reftext").html("");
      				$("#error").html("Wrong OTP");
      	        	$('#yesref').hide();
      	        	$('#noref').hide();
      				$('.errorMessage').show();
      		<%}
      		}%>
      	}
    
    </script>
</body>

</html>
