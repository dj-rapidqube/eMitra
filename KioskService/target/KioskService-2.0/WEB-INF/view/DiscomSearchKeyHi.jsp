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
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700" rel="stylesheet" />
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
</head>

<body style="background:url(img/inner-bg.png); background-size:cover;">

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
                                        <img src="img/new/homehindi.png" alt="" /></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="fourservices">
                        <div class="innermid">
                            <div class="container main_row">
                                <div class="row">
                               
                                    <div class="billmidmain">
                                        <h1>कृपया  बिजली बिल के लिए  विवरण दर्ज करें।</h1>
                                         <form id="discom_details">
                                        <div class="feildone" style="text-align:center">
                                            <div class="col-md-6 col-md-offset-3">
                                                <div class="col-md-4">
                                                    <div class="billid">
                                                        <label for="exampleInputEmail1" class="bmd-label-floating">के.क्रमांक<span style="color:red;">*</span></label>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="billidright">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="k_Number" id="k_Number" required="required" autocomplete="off" 
                                                             placeholder="बिजली के.क्रमांक  दर्ज करें">
                                                             <div class="billidright" id="errKNumber">	</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                         
                                             <div class="col-md-6 col-md-offset-3">
                                                <div class="col-md-4">
                                                    <div class="billid">
                                                        <label for="exampleInputEmail1" class="bmd-label-floating">ईमेल आईडी</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="billidright">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="billEmail" id="billEmail" required="required" autocomplete="off" 
                                                             placeholder="ईमेल आईडी  दर्ज करें">
                                                             <div class="billidright" id="errKNumber">	</div>
                                                        </div>
                                                    </div>
                                                    <div class="billidright" id="errEmail"></div>
                                                </div>
                                            </div>
                                             <div class="col-md-6 col-md-offset-3">
                                                <div class="col-md-4">
                                                    <div class="billid">
                                                        <label for="exampleInputEmail1" class="bmd-label-floating">मोबाइल नंबर<span style="color:red;">*</span></label>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="billidright">
                                                        <div class="form-group">
                                                         <div class="input-group form-group">
																<div class="input-group-addon"
																	style="width: 38px; background: #dedada;">+91</div>
																<input type="text" class="form-control"
																	autocomplete="off" name="billMobileNo"
																	id="billMobileNo" placeholder="मोबाइल नंबर दर्ज करें"
																	required="required">
															</div>
                                                        </div>
                                                    </div>
                                                    <div class="billidright" id="errMobile"></div>
                                                </div>
                                            </div>
                                           
                                        </div>
										   <div class="twobtn">
										        <input type="hidden" name="langCode" id="langCode" value="1" > 
                                                 <button class="btn btn-default getone" id="checkForm"  type="button">सही</button>
                                                <button class="btn btn-default btn-raised getone"  type="reset">रीसेट करें</button>
                                        </div>
										 </form>
										
                                    </div>
                                   
                                </div>
                         
                            </div>
                             <div class="button_div">
                                <a href="serviceproviderHi" class="panel">
                                    <img src="img/new/backhindi.png" alt=""></a>
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
    <script	type="text/javascript" src="js/jquery.min.js"></script><script type="text/javascript"  src="js/bootstrap.min.js"></script>
    <script type="text/javascript"  src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/app-inner.js"></script>
  	<script type="text/javascript">
  	$(function() {
		$("#checkForm").on('click',function() {
			//alert("dfhg")
			$("#errKNumber").html('');
			if( $("#k_Number").val()==''){
				$("#errKNumber").html('<p style="color:red;float: left;">* बिजली के.क्रमांक  दर्ज करें</p>');
				$("#k_Number").focus();
				//setTimeout(function(){$("#errEmail").html('')}, 3000);
				return false;
			}
			var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			//	alert("serviceId  :: "+$("#serviceProviderID").val());
			//	alert("billMobileNo : "+$("#billMobileNo").val()+" billEmail : "+$("#billEmail").val());
			var contact = $.trim($("#billMobileNo").val());
			var emailid = $.trim($("#billEmail").val());
			$("#errEmail").html('');
			$("#errMobile").html('');

			if (emailid != '') {
				if (!regex.test(emailid)) {
					$("#billEmail").focus();
					$("#errEmail").html("<p style='color:red;float: left;'>* मान्य  ईमेल आईडी  दर्ज करें</p>");
					return false;
				}
			}

			if (contact == '') {
				$("#errMobile").html('<p style="color:red;float: left;">* मोबाइल नंबर दर्ज करें</p>');
				$("#billMobileNo").focus();
				return false;
			}

			if (contact != '') {
				if (!$.isNumeric(contact)) {
					$("#billMobileNo").focus();
					$("#errMobile").html("<p style='color:red;float: left;'>** मान्य  मोबाइल नंबर दर्ज करें</p>");
					return false;
				} else {
				//	alert(contact.length);
					if (contact.length != 10) {
							
						$("#billMobileNo").focus();
						$("#errMobile").html("<p style='color:red;float: left;'>** मान्य 10 अंकों   का  मोबाइल नंबर  दर्ज करें </p>");
						return false;
					}
				}
			}
			
			if (emailid == '') {
			/* 	$("#billEmail").focus();
				$("#errEmail").html("<p style='color:red;float: left;'>* ईमेल आईडी  दर्ज करें</p>");
				return false; */
				$("#billEmail").val('helpdesk.emitra@rajasthan.gov.in');
			} 
			
			$('#loading').show();
			$("#discom_details").attr("action", "discomservice");
			$("#discom_details").attr("method", "post");
			$("#discom_details").submit();
		})
	});
  	
  	</script>

</body>

</html>

