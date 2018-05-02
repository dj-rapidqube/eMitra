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
<link href="css/font-awesome.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
</head>




<body style="background: url(img/inner-bg.png); background-size: cover;">

	<div id="wrapper">
		<div id="mask">


			<div id="fill" class="item gr gs">
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
					
					 <form method="post" id="spd">
									<input type="hidden" name="serviceID" id="serviceID" />
				     </form>
				     
				     
					<div class="fourservices">
						<div class="innermid">
							<div class="container main_row">
								<div class="row circle-container">
									<div class="billmidmain">
										<h1 class="">सरकारी सेवाएं</h1>
										<!-- <div class="col-md-3 deg30">
											<div class="grevanceservices">
												<a href="onlineverificationhi" class="panel"> <img
													src="img/online-verification.png" alt="" /> <span>ऑनलाइन
														सत्यापन</span>
												</a>
											</div>
										</div>
										<div class="clearfix"></div> -->
										<div class="col-md-3 deg0">
											<div class="grevanceservices">
												<!-- <a href="governmentservicehindi11" class="panel"> <img
													src="img/print-certificate.png" alt="" /> <span>प्रिंट
														प्रमाणपत्र</span>
												</a> -->
												<a href="javascript:void(0);"  onclick="getSP('2289')" class="panel"> <img
													src="img/print-certificate.png" alt="" /> <span>प्रमाणपत्र देखें/छापें
														</span>
												</a>
											</div>
										</div>

										<div class="col-md-3 deg60">
											<div class="grevanceservices">
												<a href="transactionservicehi1" class="panel"> <img
													src="img/Get-status.png" alt="" /> <span>
													ई-मित्र ट्रांन्जेकशन की स्थिति प्राप्त करें</span>
												</a>
											</div>
										</div>
										<div class="col-md-3 deg90">
											<div class="grevanceservices">
												<a href="examservicehi" class="panel"> <img
													src="img/sexam.png" alt="" /> 
												<span> माध्यमिक परीक्षा का  विवरण देखें
                                                                                                                                                                                    बी.एस.ई.आर., अजमेर</span>												
												</a>

											</div>
										</div>
										<div class="col-md-3 deg180">
											<div class="grevanceservices">
												<a href="jamabandiRecordHi" class="panel"> <img
													src="img/ror.png" alt="" /> 
													<span>भूमि   रिकॉर्ड   देखें</span>
													<!-- <span>जमाबन्दी  देखें (भूमि रिकॉर्ड)</span> -->
												</a>
											</div>
										</div>
										<!--      <div class="col-md-3 deg180">
                                                <div class="grevanceservices">
                                                <a href="agricultureDeptHindi" class="panel">
                                                    <img src="img/Application-Service.png" alt="" />

                                                    <span>अनुप्रयोग सेवाएं</span>
                                                </a>
                                                    </div>
                                            </div> -->
									</div>


								</div>

							</div>
							<div class="button_div">
								<a href="servicehindi" class="panel"> <img
									src="img/new/backhindi.png" alt=""></a>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js/app-inner.js"></script>
	<script type="text/javascript">
		function getSP(id) {
	    	$("#serviceID").val(id);
			document.getElementById("spd").action = "governmentservicehindi11";
			document.getElementById("spd").method = "post";
			$("#spd").submit();
		}
	
	</script>

</body>

</html>
