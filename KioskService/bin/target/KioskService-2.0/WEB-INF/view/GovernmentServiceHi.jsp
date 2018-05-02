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
<link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
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
										<h1>कृपया  प्रमाण पत्र प्राप्त करने  के लिए अपना विवरण दर्ज करें</h1>
										<form id="certificate_details">
											<div class="feildone" style="text-align: center">
												<div class="col-md-6 col-md-offset-3">
													<div class="col-md-4">
														<div class="billid">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">ट्रांन्जेकशन आईडी <span style="color:red;">*</span></label>
														</div>
													</div>
													<div class="col-md-8">
														<div class="billidright">
															<div class="form-group">
																<%-- <input type="text" class="form-control"
																	required="required" autocomplete="off" name="tokenId"
																	id="tokenId" placeholder="लेनदेन आईडी दर्ज करें">
																	<input type="hidden" id="certificateDetails" name="certificateDetails"  value="${certificateDetails}">
																 --%>
															<input type="text" class="form-control" required="required" autocomplete="off" name="tokenId" id="tokenId" placeholder="ट्रांन्जेकशन आईडी दर्ज करें">
                                                       		<input type="hidden" id="certificateDetails" name="certificateDetails"  value="${certificateDetails}">
															<input type="hidden" name="serviceID" value="${serviceID}">
															<input type="hidden" name="serviceName" value="${serviceName}">
															<input type="hidden" name="subServiceID" value="${subServiceID}">
															<input type="hidden" name="langCode" id="langCode" value="1"> 
																 <div class="billidright" id="errTokenId"></div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<div class="twobtn">
												<input type="hidden" name="langCode" id="langCode" value="1" > 
												<button class="btn btn-default getone" id="checkForm"
													type="button">दर्ज करें</button>
												<button class="btn btn-default getone" type="reset">रीसेट करें</button>
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
	  	<img id="loading-image" src="img/ajax-loader.gif" alt="लोड हो रहा है..." />
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js/app-inner.js"></script>
	<script type="text/javascript">
  	$(function() {
		$("#checkForm").on('click',function() {
		//	alert("dfsgfdh");
			$("#errTokenId").html('');
			if( $("#tokenId").val().trim()==''){
				$("#errTokenId").html('<p style="color:red;float: left;">* ट्रांन्जेकशन आईडी दर्ज करें</p>');
				$("#tokenId").focus();
				//setTimeout(function(){$("#errEmail").html('')}, 3000);
				return false;
			}
			
			$('#loading').show();
			$("#certificate_details").attr("action", "governmentservice");
			$("#certificate_details").attr("method", "post");
			$("#certificate_details").submit();
		})
	});
  	
  	</script>

</body>

</html>

