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
										<h1>Please enter B.S.E.R., Ajmer Secondary Exam Details</h1>
											<h5>Available Only From Year 2011 Onwards</h5>
										<form id="certificate_details">
											<input type="hidden" name="langCode" id="langCode" value="0" > 
											<div class="feildone" style="text-align: center">
												<div class="col-md-6 col-md-offset-3">
													<div class="col-md-6">
														<div class="billid">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">Roll No<span style="color:red;">*</span></label>
														</div>
														
													</div>
													<div class="col-md-6">
														<div class="billidright">
															<div class="form-group">
																<input type="text" class="form-control"
																	required="required" autocomplete="off"
																	name="rollNo" id="rollno"
																	placeholder="Enter Roll No">
																	
																<div class="billidright" id="errRollNo"></div>
															</div>
														</div>
													</div>
													
													<div class="col-md-6">
														<div class="billid1">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">Exam Year<span style="color:red;">*</span></label>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<input type="text" class="form-control" 
																required="required" autocomplete="off"
																name="examYear" id="examyear"
																placeholder="Year Format: YYYY ">
															<div class="billidright" id="errYear"></div>
														</div>
														
													</div>
												</div>

											</div>
											<div class="twobtn">
												<button class="btn btn-default getone" id="checkForm" onclick="getsubmit();"
													type="button">Submit</button>
												<button class="btn btn-default getone"
													type="reset">RESET</button>
											</div>
										</form>

									</div>

								</div>
                         
                            </div>
                            <div class="button_div">
                                <a href="governmentServiceProvider" class="panel">
                                    <img src="img/new/back.png" alt=""></a>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div id="loading" style="display: none;">
	  <img id="loading-image" src="img/ajax-loader.gif" alt="Loading..." />
	</div>
    
    <script	type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/app-inner.js"></script>
  	<script type="text/javascript">
   	$(function() {
		$("#checkForm").on('click',function() {
		//	alert("dfsgfdh");
			$("#errRollNo").html('');
			$("#errYear").html('');
			if( $("#rollno").val().trim()==''){
				$("#errRollNo").html('<p style="color:red;float: left;">* Enter Roll No</p>');
				$("#rollno").focus();
				return false;
			}
			
			if(!$.isNumeric($("#rollno").val().trim())){
				$("#errRollNo").html('<p style="color:red;float: left;">* Please Enter valid Roll No</p>');
				$("#rollno").focus();
				return false;
			}
				
			
			if( $("#examyear").val().trim()==''){
				$("#errYear").html('<p style="color:red;float: left;">* Enter Exam Year</p>');
				$("#examyear").focus();
				return false;
			}
			else if( $("#examyear").val().length!=4){
				$("#errYear").html('<p style="color:red;float: left;">*Please Enter Correct Exam Year</p>');
				$("#examyear").focus();
				return false;
			}
			
			
		 	if(!$.isNumeric($("#examyear").val().trim())){
				$("#errYear").html('<p style="color:red;float: left;">* Please Enter Correct Exam Year</p>');
				$("#examyear").focus();
				return false;
			}
			
			$('#loading').show();
			
			$("#certificate_details").attr("action", "examserviceDetails");
			$("#certificate_details").attr("method", "post");
			$("#certificate_details").submit();
			
		})
	}); 
	
	
  	</script>
</body>

</html>

