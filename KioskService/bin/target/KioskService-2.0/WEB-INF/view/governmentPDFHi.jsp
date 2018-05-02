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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>सरकारी सेवाएं</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet" />
<link href="css/font-awesome.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
<script src="https://printjs-4de6.kxcdn.com/print.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://printjs-4de6.kxcdn.com/print.min.css">
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


										<div class="col-md-12">

											<embed src="${url1}#toolbar=0&navpanes=0&scrollbar=0"
												width="100%" height="480" alt="pdf"
												pluginspage="http://www.adobe.com/products/acrobat/readstep2.html" />
										</div>

										<%--   <div class="col-md-12">
                                                <object data="${url}" type="application/pdf" width="100%" height="550px">  
												</object>
                                            </div> --%>

										<form id="govtpdf">
											<input type="hidden" name="langCode" id="langCode" value="1" > 
											<input type="hidden" name="govtpdf" value="${url}">
											<input type="hidden" name="token" id="token" value="${token}"  > 
											<input type="hidden" name="certificateType" id="certificateType" value="${certificateType}"  >
											<input type="hidden" name="serviceName" value="${serviceName}">
                                            <input type="hidden" name="amount" value="10">
											<input type="hidden" name="serviceID" value="${serviceID}">
											<input type="hidden" name="subServiceID" value="${subServiceID}">
											<input type="hidden" name="transactionID" value="${transactionID}">
											
										</form>
										<div class="twobtn">

											<button type="button" class="panel btn btn-default getone"
												data-toggle="modal" data-target="#myModal">प्रमाणपत्र प्रिंट  करें</button>


										</div>

										<!--   <input type="button" value="Print Receipt" id="printRec" onclick="csd();" class="panel btn btn-default getone"> -->


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


		<div class="modal fade" id="myModal" role="dialog"
			data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-body" style="text-align: center">
						<p>क्या आप  प्रमाणपत्र का प्रिंट  लेना चाहते हैं	?</p>
						<p> शुल्क  <i class="fa fa-inr" aria-hidden="true"></i>10 प्रति प्रतिलिपि होगा.	</p>
					</div>
					<div class="modal-footer" style="text-align: center">

						<a onclick="openit()" class="panel">
							<button class="btn btn-default getone" id="yes" onclick="yes();">सही</button>
						</a> <a href="index" class="panel">
							<button class="btn btn-default getone" id="no" onclick="no();">नहीं</button>
						</a>

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
	<!-- <script>
    function csd()
    {
    	window.location.href="ServicePaymentmode";
    }
    </script> -->
	<script>
	
	
	document.onmousedown = disableRightclick;
	function disableRightclick(evt){
	    if(evt.button == 2){	       
	        return false;    
	    }
	}
    function openit()
    {
    	document.getElementById('govtpdf').action="ServicePaymentmode";
		document.getElementById('govtpdf').method="post";
		document.getElementById('govtpdf').submit();
    }
    
    function yes()
    {
    	$('#loading').show();
    	document.getElementById('no').disabled=true;
    }
    function no()
    {
    	document.getElementById('yes').disabled=true;
    }
    </script>


</body>

</html>

