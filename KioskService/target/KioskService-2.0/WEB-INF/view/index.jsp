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
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>KIOSK - Home</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-material-design.min.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="css/slick-theme.css" />
    <link rel="stylesheet" type="text/css" href="css/slick.css" />
      <style>
    .versionbox{
        position: fixed;
	    top: 130px;
	    left: 11%;
	    height: 40px;
	    width: 25%;
	    padding-top: 5px;	    
	    font-weight: 700;
	   
   	}
    .versionbox h4{
      color: #ec4556 !important;
       font-size: 15px;
       text-transform: uppercase;
    }
    </style>
</head>

<body>
    <div id="wrapper">
        <div id="mask">
            <div id="item1" class="item home_back">
                <div class="topone">
                    <div class="container">
                        <div class="col-md-12">
                            <div class="col-md-4 logo_div">
                                <img src="img/logo.png" class="logo">
                            </div>
                            <!--<div class="col-md-4 emitra_div"><img src="img/e-mitra.png" class="emitra_logo"></div>-->
                            <div class="col-md-4"></div>
                        </div>
                        <div class="col-md-12 lahar">
                            <img src="img/home_red1.png" class="lahar_img">
                            <div class="lang_div">
                             <!--   <img src="img/e-mitra.png" class="left_e">-->
                                <div>
                                    <a class="btn btn-default panel" href="servicehindi" id="hindi">
                                        <img src="img/hindi.png" class="lang_btn"></a>
                                    <a class="btn btn-default panel" href="service" id="hindi">
                                        <img src="img/english.png" class="lang_btn"></a>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-md-12 versionbox">
								<h4>
									Version 2.0
								</h4>
							</div>
                        
                       <img src="img/cartooon-new.png" id="myImage" onclick="changeImage()" class="a" alt="" />
                    </div>
                </div>
            </div>
        </div>
    </div>
    
  
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.js"></script>
    <script type="text/javascript" src="js/app.js"></script>
    <script type="text/javascript" src="js/jquery.flexisel.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/slick.js"></script>
    <script type="text/javascript">
    
    
    /* function getSP(id,name) {
    	$("#serviceProviderID").val(id);
    	$("#serviceProviderName").val(name);
   
		//alert("serviceProviderID : "+$("#serviceProviderID").val()+" serviceProviderName : "+$("#serviceProviderName").val());
		document.getElementById("spd").action = "serviceProviderInfo";
		document.getElementById("spd").method = "post";
		//$("#spd").attr("action", "/serviceProviderInfo");
		$("#spd").submit();
	}

    
	$(function() {
		$("#eCardPayment").bind('click', function() {
			var token = $('#tokenNum').val();
			var appDEtail = $('#apDetail').val();
			var loginUser = $('#loginUser').val();

			var dataToSend = {
				"token" : token,
				"appDetail" : appDEtail,
				"loginUser" : loginUser
			};
			dataToSend = JSON.stringify(dataToSend);
			$.ajax({
				url : '/KioskService/eCardPayment/',
				type : "POST",
				contentType : 'application/json; charset=utf-8',
				dataType : 'text',
				data : dataToSend,
				success : function(data) {
					
					if(data==''){
						alert("Some Error Occoured..");
						console.log("Error " + data);
						window.location.href="paymentError";
					}else{
						$('#d1').html(data);
						console.log(data);
						window.location.href="paymentSuccessful";
					}
				},

				error : function(xhr, status, error) {
					$('#d1').html(error);
					alert("Some Error Occoured..");
					console.log("Error " + error);
					window.location.href="paymentError";
				}
			});
		})
	});

	


	$(function() {
		$("#fingurePaymewnt").bind('click', function() {
			
			alert("Please Put Your Finger After..");
			$.ajax({
				url : '/KioskService/printRec/init/',
				type : "POST",
				success : function(data) {
					//$('#d4').html(data);
					alert("figure  data ::"+data);
					console.log(data);
					if(data=='device is not Recognize'){
						window.location.href="paymentError";
					}else{
						window.location.href="paymentSuccessful";
					}

				},
				error : function(xhr, status, error) {
					//$('#d4').html(error);
					alert("Some Error Occoured..");
					console.log("Error " + error);
					window.location.href="paymentError";
				}
			});
		})
	});
	 */
		
	/* $(function() {
		$("#cash").on('click', function() {
			var amt = $('#amt').val();
			alert("Please submit your Cash Amount.");
			$.ajax({
				url : '/KioskService/cashAcceptor/'+amt+'/',
				type : "POST",
				success : function(data) {
					//$('#d4').html(data);
					alert(data);
					console.log(data);
					window.location.href="paymentSuccessful";

				},
				error : function(xhr, status, error) {
					//$('#d4').html(error);
					alert("Some Error Occoured..");
					window.location.href="paymentError";
					console.log("Error " + error);
				}
			});
		})
	}); */
	
	/* $(function() {
		$("#cash").bind('click', function(e) {
			var amt = $('#amt').val();
			alert("Please submit your Cash Amount.");
			$.ajax({
				url : '/KioskService/cashAcceptor/'+amt+'/',
				type : "POST",
				success : function(data) {
					//$('#d4').html(data);
					alert(data);
					console.log(data);
					if(data=='NoData'){
						alert("No Data Found");
						window.location.href="paymentError";
					}else{
						window.location.href="paymentSuccessful";
					}

				},
				error : function(xhr, status, error) {
					//$('#d4').html(error);
					alert("Some Error Occoured, then move paymentError");
					window.location.href="paymentError";
					console.log("Error " + error);
				}
			});
		})
	});
	 */
	
</script>


</body>

</html>
