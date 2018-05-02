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

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>GOVERNMENT SERVICES</title>
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
										src="img/new/home.png" alt="" /></a>
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
										<h1 class="">GOVERNMENT SERVICES</h1>
									<!-- 	<div class="col-md-3 deg30">
											<div class="grevanceservices">
												<a href="onlineverification" class="panel"> <img
													src="img/online-verification.png" alt="" /> <span>Online
														Verification</span>
												</a>
											</div>
										</div>
										<div class="clearfix"></div> -->
										<div class="col-md-3 deg0">
											<div class="grevanceservices">
												<a href="javascript:void(0);" onclick="getSP('2289')" class="panel"> <img
													src="img/print-certificate.png" alt="" /> <span>View/Print
													Certificate</span>
												</a>
											</div>
										</div>

										<div class="col-md-3 deg60">
											<div class="grevanceservices">
												<a href="transactionservice1" class="panel"> <img
													src="img/Get-status.png" alt="" /> <span>Get Status of E-mitra Transactions</span>
												</a>
											</div>
										</div>
										<div class="col-md-3 deg90">
											<div class="grevanceservices">
												<a href="examservice" class="panel">
												 <img src="img/sexam.png" alt="" /> <span>View Secondary Exam Detail
														 B.S.E.R., Ajmer</span>
												</a>
											</div>
										</div>
										<div class="col-md-3 deg180">
											<div class="grevanceservices">
												<a href="jamabandiRecord" class="panel">  
												<img src="img/ror.png" alt="" /> 												
												<span>View Land Records</span>
											<!-- 	<span>View Jamabandi (Land Records)</span> -->
												
												</a>
											</div>
										</div>
									</div>

									<!--      <div class="col-md-3 deg180">
                                                <div class="grevanceservices">
                                                <a href="agricultureDeptHindi" class="panel">
                                                    <img src="img/Application-Service.png" alt="" />

                                                    <span>Application Services</span>
                                                </a>
                                                    </div>
                                            </div> -->
								</div>

							</div>
							<div class="button_div">
								<a href="service" class="panel"> <img src="img/new/back.png"
									alt=""></a>

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
			document.getElementById("spd").action = "governmentservice11";
			document.getElementById("spd").method = "post";
			document.getElementById('spd').submit();
		}
		
	</script>

</body>

</html>
