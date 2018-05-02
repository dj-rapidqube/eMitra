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
    <title>District Department</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700" rel="stylesheet" />
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


            <div id="fill" class="item sinfo">
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
                                <div class="row sliderow">
                                    <div class="billmidmain">
                                        <h1 class="">District Departments</h1>

                                        <ul class="regular">
                                            <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                    <span>जिला प्रशासन</span>
                                                    </a>
                                                </div>


                                          
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>जनप्रतिनिधि </span>
                                                    </a>
                                                </div>


                                            </li>
                                            <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>पी. एच. ई. डी.</span>
                                                    </a>
                                                </div>


                                       
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>लोक निर्माण विभाग</span>
                                                    </a>
                                                </div>


                                            </li>
                                            <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>पशुपालन विभाग </span>
                                                    </a>
                                                </div>


                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>कृषि विभाग </span>
                                                    </a>
                                                </div>


                                            </li>
                                             <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>विद्युत विभाग/डिस्कोम </span>
                                                    </a>
                                                </div>


                                           
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>स्वास्थ्य विभाग</span>
                                                    </a>
                                                </div>


                                            </li>
                                            <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>शिक्षा विभाग</span>
                                                    </a>
                                                </div>


                                           
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>पुलिस विभाग </span>
                                                    </a>
                                                </div>


                                            </li>
                                            <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>खण्ड विकास अधिकारी</span>
                                                    </a>
                                                </div>


                                         
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>ग्राम सेवक </span>
                                                    </a>
                                                </div>


                                            </li>

                                             <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>पटवारी</span>
                                                    </a>
                                                </div>


                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>विद्यालय </span>
                                                    </a>
                                                </div>


                                            </li>
                                            <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>आशा सहयोगिनी</span>
                                                    </a>
                                                </div>


                                           
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>प्राथमिक स्वास्थ्यकेन्द्र</span>
                                                    </a>
                                                </div>


                                            </li>
                                            <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>सामुदायिक स्वास्थ्यकेन्द्र</span>
                                                    </a>
                                                </div>


                                         
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>जी. एन. एम.</span>
                                                    </a>
                                                </div>


                                            </li>
                                             <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>ऎ. एन. एम.</span>
                                                    </a>
                                                </div>


                                            
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>महाविद्यालय</span>
                                                    </a>
                                                </div>


                                            </li>
                                            <li>
                                                <div class="grevanceservices">
                                                    <a href="districtAdministration" class="panel">


                                                        <span>तहसीलदार </span>
                                                    </a>
                                                </div>


                                            </li>
                                            
                                      </ul>

   </div>



                                </div>

                            </div>
                            <div class="button_div">
                                <a href="district" class="panel">
                                    <img src="img/new/back.png" alt="" /></a>

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
    <script type="text/javascript" src="js/slick.js"></script>

</body>

</html>