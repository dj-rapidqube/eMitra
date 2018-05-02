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
<title>सेवा प्रदाता</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/slick-theme.css" />
<link rel="stylesheet" type="text/css" href="css/slick.css" />
</head>




<body style="background: url(img/inner-bg.png); background-size: cover;">

	<div id="wrapper">
		<div id="mask">
			<div id="service" class="item utiltyservice">
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


								<form method="post" id="spd">
									<input type="hidden" name="serviceProviderID"
										id="serviceProviderID" /> <input type="hidden"
										name="serviceProviderName" id="serviceProviderName" />
								</form>
								<div class="row sliderow">
									<div class="billmidmain">
										<h1 class="">बिल भुगतान</h1>
										<ul id="" class="servicepro slider">
											<li>
												<div class="oneservices">
													<a href="javascript:void(0);"
														onclick="getSP('1214','AIRTEL')" class="panel"> <img
														src="img/Logos/Airtel.png" alt="" />
														<h2>एयरटेल</h2>
													</a>
												</div>
											</li>
											<li>

												<div class="oneservices">
													<a href="javascript:void(0);"
														onclick="getSP('1219','Vodafone')" class="panel"> <img
														src="img/Logos/vodafone.png" alt="" />
														<h2>वोडाफोन</h2>
													</a>
												</div>
											</li>
											<li>
												<div class="oneservices">
													<a href="phedhi"> <img src="img/Logos/Phed.png" />
														<h2>जन स्वास्थ्य अभियांत्रिकी विभाग</h2>
													</a>
												</div>

											</li>
											<li>
												<div class="oneservices">
													<a href="javascript:void(0);"
														onclick="getSP('1220','IDEA')" class="panel"> <img
														src="img/Logos/Idea.png" alt="" />
														<h2>आइडिया</h2>
													</a>
												</div>

											</li>
											<li>
												<div class="oneservices">
                                                    <a href="discomHi">
                                                        <img src="img/Logos/discom department.png" alt="" />
                                                        <h2>बिजली वितरण</h2>
                                                    </a>

												</div>

											</li>
											
											<li>
												<div class="oneservices">
													<a href="javascript:void(0);"
														onclick="getSP('2575','BSNL')" class="panel"> <img
														src="img/Logos/BSNL.png" alt="" />
														<h2>बीएसएनएल</h2>
													</a>
												</div>

											</li>

											<!--  <li>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/Bcit.png" alt="" />
                                                        <h2>BCITS Pvt Ltd</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/industries_dept.jpg" alt="" />
                                                        <h2>Industries Department</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/riico.png" alt="" />
                                                        <h2>Riico</h2>
                                                    </a>
                                                </div>

                                                 <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/Raj Rishi.jpg" />
                                                        <h2>Raj Rishi</h2>
                                                    </a>
                                                </div>

                                            </li>

                                            <li>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/BSNL.png" alt="" />
                                                        <h2>BSNL</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/IPTV Aksh.png" alt="" />
                                                        <h2>IPTV Aksh</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/university of kota.png" alt="" />
                                                        <h2>University of kota</h2>
                                                    </a>
                                                </div>

                                                 <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/rajasthan public serive comission.png" />
                                                        <h2>Rajasthan Public Serive Comission</h2>
                                                    </a>
                                                </div>
                                            </li>

                                            <li>

                                                <div class="oneservices">
                                                    <a href="discom">
                                                        <img src="img/Logos/discom department.png" alt="" />
                                                        <h2>DISCOM</h2>
                                                    </a>
                                                </div>


                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/Kota electricity.png" alt="" />
                                                        <h2>Kota electricity</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/university of rajasthan.png" alt="" />
                                                        <h2>University of Rajasthan</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/munciple corporation.png" />
                                                        <h2>Municipal Corporation</h2>
                                                    </a>
                                                </div>
                                            </li>


                                            <li>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/Maharishi Dayanand Saraswati.png" />
                                                        <h2>Maharishi Dayanand Saraswati</h2>
                                                    </a>
                                                </div>


                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/MS bharatpur.jpg" />
                                                        <h2>MS bharatpur</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/revenue department.png" />
                                                        <h2>Revenue Department</h2>
                                                    </a>
                                                </div>

                                                 <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/pandit deendayal univ.jpg" />
                                                        <h2>Pandit Deendayal Univ</h2>
                                                    </a>
                                                </div>
                                            </li>

                                            <li>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/MS Bikaner.jpg" />
                                                        <h2>MS Bikaner</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/MTS.png" />
                                                        <h2>MTS</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/riico.png" />
                                                        <h2>Riico</h2>
                                                    </a>
                                                </div>

                                                <div class="oneservices">
                                                    <a href="javascript:void(0);">
                                                        <img src="img/Logos/Rajasthan police.png" />
                                                        <h2>Rajasthan police</h2>
                                                    </a>
                                                </div>
                                            </li>
 -->


										</ul>
									</div>
								</div>

							</div>
							<div class="button_div">
								<a href="servicehindi" class="panel"> <img src="img/new/backhindi.png"
									alt="" /></a>

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
	<script type="text/javascript" src="js/slick.js"></script>
	<script type="text/javascript">
    
    
    function getSP(id,name) {
    	$("#serviceProviderID").val(id);
    	$("#serviceProviderName").val(name);
		document.getElementById("spd").action = "serviceProviderInfoHi";
		document.getElementById("spd").method = "post";
		$("#spd").submit();
	}
    $(document).ready(function () {

        $(".servicepro").slick({
            dots: false,
            infinite: true,
            slidesToShow: 6,
            slidesToScroll: 6
        });
    });
    </script>
</body>

</html>

