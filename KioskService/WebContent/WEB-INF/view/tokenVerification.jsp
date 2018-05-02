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
                                    <a href="serviceProviderInfo" class="panel pull-right homebtn">
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
                                        <h1>Please enter details of your E-mitra Transaction</h1>
                                         <form  id="certificate_details">
                                        <div class="feildone" style="text-align:center">
                                            <div class="col-md-6 col-md-offset-3">
                                                <div class="col-md-4">
                                                    <div class="billid">
                                                        <label for="exampleInputEmail1" class="bmd-label-floating">Transaction ID<span style="color:red;">*</span></label>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="billidright">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="transId" autocomplete="off" id="transId" placeholder="Enter Transaction Id">
                                                        	<div class="billidright" id="errTokenId">	</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                           
                                        </div>
										   <div class="twobtn">
										   		<input type="hidden" name="langCode" id="langCode" value="0" > 
                                                <button class="btn btn-default getone" id="checkForm" type="button">Submit</button>
                                                <button class="btn btn-default getone" type="reset">RESET</button>
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
    <script type="text/javascript"  src="js/bootstrap.min.js"></script>
    <script type="text/javascript"  src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/app-inner.js"></script>
  <script type="text/javascript">
  	$(function() {
		$("#checkForm").on('click',function() {
		//	alert("dfsgfdh");
			$("#errTokenId").html('');
			if( $("#transId").val().trim()==''){
				$("#errTokenId").html('<p style="color:red;float: left;">* Please enter transaction Id</p>');
				$("#transId").focus();
				//setTimeout(function(){$("#errEmail").html('')}, 3000);
				return false;
			}
			
			$('#loading').show();
			$("#certificate_details").attr("action", "transactionservice");
			$("#certificate_details").attr("method", "post");
			$("#certificate_details").submit();
		})
	});
  	
  	</script>

</body>

</html>

