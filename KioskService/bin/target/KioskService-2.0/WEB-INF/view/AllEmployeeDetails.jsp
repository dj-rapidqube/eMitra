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
    <title>Employee Detail</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700" rel="stylesheet">
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="css/bootstrap-material-design.min.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
    <link href="css/jquery.mCustomScrollbar.css" type="text/css" rel="stylesheet" />
   
</head>



<body style="background:url(img/inner-bg.png); background-size:cover;">

 <div id="wrapper">
        <div id="mask">


  <div id="payment_succ" class="item">
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
                                <div class="row">
                                          <div class="billmidmain">
                                        <h1 class="">Employee Detail</h1>                                       
                                        <div id="content-1" class="content mCustomScrollbar">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>पदनाम</th>
                                                    <th>अधिकारी का नाम</th>
                                                    <th>मोबाइल</th>
                                                    <th>दूरभाष</th>
                                                    <th>ईमेल</th>
                                                    <th>कार्यालय का पता</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>जिला कलेक्टर</td>
                                                    <td>श्री गौरव गोयल</td>
                                                    <td>9530311002</td>
                                                    <td>0145-2626421,2623780</td>
                                                    <td>dm-ajm-rj@nic.in</td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                </tr>
                                                <tr>
                                                    <td>अतिरिक्त जिला मजिस्ट्रेट (प्रशासन)</td>
                                                    <td>श्री कैलाश चंद शर्मा</td>
                                                    <td>9414036291</td>
                                                    <td>0145-2627100</td>
                                                    <td></td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                </tr>
                                                 <tr>
                                                    <td>अतिरिक्त जिला मजिस्ट्रेट (शहर)</td>
                                                    <td>श्री अरविन्द कुमार सेंगवा</td>                                                 
                                                    <td>9414003585</td>
                                                    <td>0145-2627300</td>
                                                    <td>admcityajm@gmail.com</td>
                                                        <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                     </tr>

                                                      <tr>
                                                    <td>अतिरिक्त मुख्य कार्यकारी अधिकारी, जिला परिषद	</td>
                                                    <td>श्रीमती दिप्ती शर्मा</td>
                                                    <td>8890000050</td>
                                                    <td>0145-2431369</td>
                                                    <td></td>
                                                    <td>कार्यालय जिला परिषद अजमेर</td>
                                                          </tr>
                                                           <tr>
                                                    <td>सूचना प्रौद्योगिकी और संचार विभाग ए सी पी</td>
                                                    <td>श्री भगवती प्रसाद</td>
                                                    <td>7023064179, 7340025990</td>
                                                    <td>0145-2428565</td>
                                                    <td>dlo.doit.ajmer@rajasthan.gov.in	</td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                               </tr>
                                                                <tr>
                                                    <td>जिला साँख्यिकी कार्यालय, उपनिदेशक</td>
                                                    <td>श्रीमती पुष्पा सिंह</td>
                                                    <td>9828988858</td>
                                                    <td>0145-2427247</td>
                                                    <td>dsoajm.des@rajasthan.gov.in</td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                </tr>
                                                                <tr>
                                                    <td>जिला रसद अधिकारी</td>
                                                    <td>श्री संजय माथुर</td>
                                                    <td>9414072742</td>
                                                    <td>2627391</td>
                                                    <td>dsofood-ajm-nic.in</td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                </tr>
                                              
                                                  <tr>
                                                    <td>डी.आई.ओ.</td>
                                                    <td>श्री अंकुर गोयल</td>
                                                    <td>9928806699</td>
                                                    <td>0145-2627469</td>
                                                    <td>rajmer@nic.in</td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                </tr>
                                                
                                                 <tr>
                                                    <td>संभागीय आयुक्त</td>
                                                    <td>श्री हनुमान सहाय मीना</td>
                                                    <td>9828153204</td>
                                                    <td>0145-2425301, 2627501</td>
                                                    <td>dcommr-ajm-rj@nic.in</td>
                                                    <td>सेशन कोर्ट के सामने अजमेर</td>
                                                </tr>

                                                <tr>
                                                    <td>पुलिस अधीक्षक शहर</td>
                                                    <td>श्री राजेन्द्र सिंह</td>
                                                    <td>8764853001,9414157882</td>
                                                    <td>0145-2629910</td>
                                                    <td>sp.ajmer@rajpolice.gov.in</td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                </tr>
                                                 <tr>
                                                    <td>कोषाधिकारी</td>
                                                    <td>श्री मनोज शर्मा</td>
                                                    <td>9414153200, 7726064028</td>
                                                    <td>0145-2627938</td>
                                                    <td>to-ajm-rj@nic.in</td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                </tr>
                                                  <tr>
                                                    <td>अतिरिक्त जिला मजिस्ट्रेट द्वितीय</td>
                                                    <td>श्री अबू सुफियान चौहान</td>
                                                    <td>9414203086</td>
                                                    <td>0145-2422517</td>
                                                    <td>abusufiyan.ras@gmail.com</td>
                                                    <td>कलक्ट्रेट कार्यालय अजमेर</td>
                                                </tr>
                                                  <tr>
                                                    <td>मुख्य चिकित्सा एवं स्वास्थ्य अधिकारी</td>
                                                    <td>डा0 के के सोनी</td>
                                                    <td>9414003055</td>
                                                    <td>0145-2631111</td>
                                                    <td>cmho-ajm-aj@nic.in</td>
                                                    <td>मुख्य चिकित्सा एवं स्वास्थ्य अधिकारी अजमेर</td>
                                                </tr>
                                            </tbody>
                                        </table></div>





                                    </div>
                                </div>
                         
                            </div>
                            <div class="button_div">
                                <a href="districtAdministration" class="panel">
                                    <img src="img/new/back.png" alt="" /></a>
                                
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
    <script type="text/javascript" src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script type="text/javascript" src="js/app.js"></script>

   
  

</body>

</html>
