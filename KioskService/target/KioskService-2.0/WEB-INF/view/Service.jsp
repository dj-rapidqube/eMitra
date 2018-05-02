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
    <title>Service</title>
    <link href="css/font-awesome.css" type="text/css" rel="stylesheet" />
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
</head>




<body style="background: url(img/inner-bg.png); background-size: cover;">

    <div id="wrapper">
        <div id="mask">
            <div id="fill" class="item allservice">             
                <div class="content">                 
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
                                
                                 <div class="col-md-4">
                                        <div class="oneservices lasrservices">
                                            <a href="governmentServiceProvider">
                                                <img src="img/gov-ser.png" alt="" />
                                                <span>GOVERNMENT SERVICES</span>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="oneservices">
                                            <a href="serviceprovider" class="panel">
                                                <img src="img/bils.png" alt="" />
                                                <span>UTILITY BILLS</span>

                                            </a>
                                        </div>
                                    </div>
                                
                                
                                     <div class="col-md-4">
                                        <div class="oneservices lasrservices">
                                            <a href="videoconferncing">
                                                <img src="img/videoconf.png" alt="" />
                                                <span>VIDEO CONFERENCING</span>
                                            </a>
                                        </div>
                                    </div>
                                    
                                   <!--  <div class="col-md-3 deg0">
                                        <div class="oneservices">
                                            <a href="#" class="panel">
                                                <img src="img/ques-bg.png" alt="" />

                                                <span>GRIEVANCE REDRESSAL</span>

                                            </a>
                                        </div>
                                    </div>

                                    <div class="col-md-3 deg20">
                                        <div class="oneservices">
                                            <a href="information">
                                                <img src="img/info.png" alt="" />
                                                <span>INFORMATION</span>

                                            </a>
                                        </div>
                                    </div>

                                    <div class="col-md-3 deg40">
                                        <div class="oneservices">
                                            <a href="#">
                                                <img src="img/timetable.png" alt="" />
                                                <span>TRANSPORT TIME <br>TABLE</span>

                                            </a>
                                        </div>
                                    </div>

                                    <div class="col-md-3 deg60">
                                        <div class="oneservices lasrservices">
                                            <a href="videoconferncing">
                                                <img src="img/videoconf.png" alt="" />
                                                <span>VIDEO CONFERENCING</span>
                                            </a>
                                        </div>
                                    </div>

                                     <div class="col-md-3 deg80">
                                        <div class="oneservices">
                                            <a href="serviceprovider" class="panel">
                                                <img src="img/bils.png" alt="" />
                                                <span>UTILITY BILLS</span>

                                            </a>
                                        </div>
                                    </div>

                                    <div class="col-md-3 deg100" >
                                        <div class="oneservices">
                                            <a href="#">
                                                <img src="img/pay.png" alt="" />
                                                <span>QUICK PAY</span>

                                            </a>
                                        </div>
                                    </div>

                                    <div class="col-md-3 deg120">
                                        <div class="oneservices">
                                            <a href="#">
                                                <img src="img/digikit.png" alt="" />
                                                <span>RAJASTHAN DIGIKIT</span>

                                            </a>
                                        </div>
                                    </div>

                                    <div class="col-md-3 deg140">
                                        <div class="oneservices lasrservices">
                                            <a href="governmentServiceProvider">
                                                <img src="img/gov-ser.png" alt="" />
                                                <span>GOVERNMENT SERVICES</span>
                                            </a>
                                        </div>
                                    </div> -->


                                   <!--  <div class="col-md-3 deg180">
                                        <div class="oneservices lasrservices">
                                            <a href="#">
                                                <img src="img/info.png" alt="" />
                                                <h2>INFORMATION</h2>


                                            </a>
                                        </div>
                                    </div> -->


                                    <div style="position: absolute; left:34%; top: 30%;">

                                        <img src="img/k11.png" alt="" style="height: 400px;" />
                                    </div>

                                </div>

                            </div>
                            <!-- Container div ends here -->
                            <div class="button_div">
                                <a href="index" class="panel">
                                    <img src="img/new/back.png" alt="" /></a>
                             
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>







    </div>
    </div>
    <script	type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/app-inner.js"></script>


</body>

</html>

