<%@ page language="java" contentType="text/html; charset=utf-8"
	 pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Certificate Services</title>
    <link href="css/font-awesome.css" type="text/css" rel="stylesheet" />
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
</head>

<body style="background:url(img/inner-bg.png); background-size:cover;">

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
                    
					<form id="SubSerId">
						<input type="hidden" name="serviceID" id="serviceID" /> <input
							type="hidden" name="subServiceID" id="subServiceID" /> <input
							type="hidden" name="serviceName" id="serviceName" />
					</form>
					<input type="hidden" value="${serviceID}" id="srvID" />
					
					<div class="fourservices">
                        <div class="innermid">
                            <div class="container main_row">
                                <div class="row circle-container">
									<div class="billmidmain">
										<h1 class="">Certificate Services</h1>

										<!-- <div class="col-md-3 deg0">
                                                <div class="grevanceservices">
                                                <a href="governmentservices12" class="panel">
                                                    <img src="img/print.png" alt="" />
                                                    <span>Domicile Certificate</span>
                                                </a>
                                                    </div>
                                            </div>

                                           <div class="col-md-3 deg60">
                                                <div class="grevanceservices">
                                                 <a href="birthservice" class="panel"> 
                                                    <img src="img/birth.png" alt="" />
                                                    <span>Birth Certificate</span>
                                                </a>
                                                    </div>
                                            </div>
                                            <div class="col-md-3 deg90">
                                                <div class="grevanceservices">
                                                <a href="deathservice" class="panel">
                                                    <img src="img/death.png" alt="" />
                                                    <span>Death Certificate</span>
                                                </a>
                                                    </div>
                                            </div>
                                            <div class="col-md-3 deg180">
                                                <div class="grevanceservices">
                                                <a href="marriageservice" class="panel">
                                                <a href="#" class="panel">
                                                    <img src="img/marriage.png" alt="" />

                                                    <span>Marriage Certificate</span>
                                                </a>
                                                    </div>
                                    		</div> -->


										<div class="col-md-3 deg0">
											<div class="grevanceservices">
												<a href="javascript:void(0);"
													onclick="setSSId('100','Bonafide Certificate')"
													class="panel"> <img src="img/print.png" alt="" /> 
													<span>Domicile, Caste, Minority, General Certificates etc...</span>
												</a>
											</div>
										</div>
										<div class="col-md-3 deg60">
											<div class="grevanceservices">
												<a href="javascript:void(0);"
													onclick="setSSId('300','Birth Certificate')" class="panel">
													<img src="img/birth.png" alt="" /> <span>Birth
														Certificate</span>
												</a>
											</div>
										</div>
										<div class="col-md-3 deg90">
											<div class="grevanceservices">
												<a href="javascript:void(0);"
													onclick="setSSId('400','Death Certificate')" class="panel">
													<img src="img/death.png" alt="" /> <span>Death
														Certificate</span>
												</a>
											</div>
										</div>
										<div class="col-md-3 deg180">
											<div class="grevanceservices">
												<a href="javascript:void(0);"
													onclick="setSSId('500','Marriage Certificate')"
													class="panel"> <img src="img/marriage.png" alt="" /> <span>Marriage Registration
														Certificate</span>
												</a>
											</div>
										</div>
										
									</div>

								</div>
                         
                            </div>
                            <div class="button_div">
                                <a href="governmentServiceProvider" class="panel">
                                    <img src="img/new/back.png" alt=""/></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script	type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript"  src="js/bootstrap.min.js"></script>
    <script type="text/javascript"  src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/app-inner.js"></script>
  	<script >
    function setSSId(id,name) {
		var sID=$("#srvID").val();
		$("#serviceID").val(sID);
		$("#subServiceID").val(id);
		$("#serviceName").val(name);
		if(id==300){
			document.getElementById("SubSerId").action = "birthservice";
			document.getElementById("SubSerId").method = "post";
			$("#SubSerId").submit();	
		}
		else if(id==100){
			document.getElementById("SubSerId").action = "governmentservices12";
			document.getElementById("SubSerId").method = "post";
			$("#SubSerId").submit();
		}
		
		else if(id==400){
			document.getElementById("SubSerId").action = "deathservice";
			document.getElementById("SubSerId").method = "post";
			$("#SubSerId").submit();
		}
		else if(id==500){
			document.getElementById("SubSerId").action = "marriageservice";
			document.getElementById("SubSerId").method = "post";
			$("#SubSerId").submit();
		}
	}
    </script>

</body>

</html>

