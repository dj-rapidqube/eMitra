<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
   	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   	<title>Emitra Plus SSO Login</title>
    <link href="css/font-awesome.css" type="text/css" rel="stylesheet" />
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    <link href="css/my-style.css" type="text/css" rel="stylesheet" />
    <link href="css/jquery.mCustomScrollbar.css" type="text/css" rel="stylesheet" />
    <link href="css/formValidation.min.css" type="text/css" rel="stylesheet" />
</head>

   <style>
    .versionbox{
        position: fixed;
	    top: 130px;
	    left: 37%;
	    height: 40px;
	    width: 25%;
	    padding-top: 5px;	    
	    font-weight: 700;
   	}
    .versionbox h4{
      color: #ec4556 !important;
      font-size: 15px;
      
    }
    </style>


<body onload="versionCheck()">
	<div id="wrapper">
		<div id="mask">
			<div id="loginpage" class="item">
				<div class="content">
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
							</div>
						</div>
					</div>
					<div class="fourservices loginform">
						<div class="innermid">
							<div class="container main_row" id="showform" style="width: 30%">

								<div class="billmidmain" >
									<h1 class="">Emitra Plus SSO Login</h1>
									<div class="col-md-12">

										<div class="form-group col-md-12">
											<div class="twobtn">
												<button type="button" id="loginbtn" 
													class="btn btn-default getone griefrom" name="signup"
													value="Log In" >Click Emitra Plus SSO Login</button>
											</div>
										</div>
									</div>
								</div>
								
							</div>
							
							<div class="container main_row" id="showmsg" style="width: 50%;display: none; ">
								<h4 class="error" id="versionMsg" style="margin-top: 20px;"></h4>
								 
								<div class="twobtn">
									<button type="button" id="loginbtn" 
										class="btn btn-default getone griefrom" data-toggle="modal" data-target="#myModal" >Read Guidelines </button>
								</div>
							</div>

							<div class="col-md-12 versionbox">
								<h4>
									Version 2.0
								</h4>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg versionmodel">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Please make a note of the following points for Update of E-mitra+ Kiosk Software.</h4>
        </div>
        <div class="modal-body">
         <div class="col-md-12 versionins">
         <h4>Please follow these steps for updating the Emitra+ Kiosk software.</h4>
         
         
                                               <ul>
	<li><span class="step">Step 1:-</span>  
	<span class="stepleft">Please click on the link that is shared to you by your respected "DLO's". Now make a note of these steps  and then click on Exit button to exit from the Kiosk Mode and follow the further steps.</span></li>
	<li><span class="step">Step 2:-</span>  
	<span class="stepleft"> Open the shared google drive link in browser for downloading the latest version. </span></li>
	
	<li><span class="step">Step 3:-</span>
	<span class="stepleft">A google drive window will appear with Download button. Click on "Download".</span></li>
	
	<li>
		<span class="step">Step 4:-</span> <span class="stepleft"> A new tab will open with (Download Anyway).Click on "Download Anyway".</span></li>
	
	<li><span class="step">Step 5:-</span> <span class="stepleft">Let it download successfully.</span></li>
	<li><span class="step">Step 6:-</span> <span class="stepleft">You will have "KioskUpdateSetup.rar" in your "Downloads".</span></li>
	<li><span class="step">Step 7:-</span> <span class="stepleft">Right click on the "KioskUpdateSetup.rar"  and choose extract to "KioskUpdateSetup.rar\ option" and setup will be extracted in the "KioskUpdateSetup.rar" folder in 'Downloads'.</span></li>
    <li><span class="step">Step 8:-</span><span class="stepleft">Go in "KioskUpdateSetup"-->click on "ServerUpdate.bat" file.(A cmd will run and close automatically after few seconds.)</span></li>
<li>
<span class="step">Step 9:-</span><span class="stepleft">You are done with the Updation process.</span></li>
<li>Note : If still any problem occurs in installation process, you can contact to <b>Naveen Kumar Yadav</b> on his <b> Email ID - yaphets.fear@gmail.com </b> or on the <b>Mobile No - 7976596290</b>

 </li>
</ul>
                                            </div>
        </div>
        <div class="modal-footer">
          <button type="button"  id="close" class="btn btn-default" >Exit</button>                       
      
        </div>
      </div>
      
    </div>
  </div>


	<script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <script type="text/javascript" src="js/app-inner.js"></script>
	<script>
	
		$( "#close" ).click(function() {				
			window.top.close();		
		});
	
		$( "#loginbtn" ).click(function() {
		  	window.location.href="https://sso.rajasthan.gov.in/signin?ru=http://localhost:1000/KioskService/login";
		});
	
	function versionCheck() {
		$("#versionMsg").html("");
	 	$.ajax({
			url : '/KioskService/checkVersion/',
			type : "POST",
			success : function(data) {
				//alert("msg :: "+data);
			 	if(data=='true'){
			      //  alert("Updated Version is installed in current machine!");
			    }else{
			    	$("#showform").hide();
			    	$("#showmsg").show();
			    	if(data.indexOf("##")>-1){
			    		var valArr = data.split("##");
			    		$("#versionMsg").html("Latest Version "+valArr[1]+" available, Please Click on <span style='color:red;'>\"Read Guidelines\" </span>button for more instructions!");
			    		return false;
			    	}else{
			    		$("#versionMsg").html("Latest Version available, Please Click on READ MORE button for more instructions!");
			    		return false;
			    	}
			    }
				
			}
		});  
	}
	
	</script>
</body>
</html>