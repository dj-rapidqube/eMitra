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
    <title>जमाबंदी  (भूमि रिकॉर्ड)</title>
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
                                        <img src="img/new/homehindi.png" alt="" /></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="fourservices">
                        <div class="innermid">
                            <div class="container main_row">
                                <div class="row">
                               
                                    <div class="billmidmain">
                                        <h1>कृपया    भूमि रिकॉर्ड  के लिए अपना विवरण दर्ज करें।</h1>
                                         <!--  <h1>कृपया जमाबन्दी   (भूमि रिकॉर्ड) के लिए अपना विवरण दर्ज करें।</h1> -->
                                         <form id="jamabandi_details">
                                         <input type="hidden" name="langCode" id="langCode" value="1" > 
                                        <div class="feildone" style="text-align:center">
                                           
                                           <div class="col-md-6 col-md-offset-3">
                                                <div class="col-md-4">
                                                    <div class="billid">
                                                        <label for="exampleInputEmail1" class="bmd-label-floating">जिला</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="billidright">
                                                        <div class="form-group">
                                                         <select class="form-control" name="District_code" id="District_code" required onchange="csd(this)">
									       <option value="">जिला  चुनें</option>
									       <c:forEach var="dist" items="${list }"> 
									       <option value="${dist.district_code}">${dist.distname}</option>
									       </c:forEach>
									    </select>	
									      <div id="errdist"></div>
                                                          <!--   <input type="text" class="form-control" name="District_code" id="District_code" required="required" autocomplete="off" 
                                                            placeholder="Enter District Code"> -->
                                                        </div>
                                                    </div>
                                          </div>
                                            </div>
                                            <div class="col-md-6 col-md-offset-3">
                                                <div class="col-md-4">
                                                    <div class="billid">
                                                        <label for="exampleInputEmail1" class="bmd-label-floating"> तहसील</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="billidright">
                                                     <div class="form-group">
                                                          <!--   <input type="text" class="form-control" name="Tehsil_code" id="Tehsil_code" required="required" autocomplete="off" 
                                                            placeholder="Enter Tehsil Code"> -->
                                                            <select class="form-control" id="Tehsil_code" name="Tehsil_code" onchange="findvillage(this)">
									                        <option value="">तहसील  चुनें</option>
									                      
								                             </select>
								                              <div id="errteh"></div>
                                                        </div>
                                                    </div>
                                                   
                                                </div>
                                            </div>
                                              <div class="col-md-6 col-md-offset-3">
                                                <div class="col-md-4">
                                                    <div class="billid">
                                                        <label for="exampleInputEmail1" class="bmd-label-floating"> गांव</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="billidright">
                                                        <div class="form-group">
                                                           <!--  <input type="text" class="form-control" name="Village_code" id="Village_code" required="required" autocomplete="off" 
                                                            placeholder="Enter Village Code"> -->
                                                            <select class="form-control" id="Village_code" name="Village_code">
									                        <option value="">गांव  चुनें </option>
									                         
								                             </select>
								                              <div id="errvill"></div>
                                                        </div>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                             <div class="col-md-6 col-md-offset-3">
                                                <div class="col-md-4">
                                                    <div class="billid">
                                                        <label for="exampleInputEmail1" class="bmd-label-floating">खसरा</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="billidright">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="khasra" id="khasra" required="required" autocomplete="off" 
                                                            placeholder="खसरा  नंबर  दर्ज   करें  ">
                                                              <div id="errkhasral"></div>
                                                        </div>
                                                    </div>
                                                   <!--  <div class="billidright" id="errEmail"></div> -->
                                                </div>
                                            </div>
                                           
                                        </div>
                                           
                    
                                            <div class="twobtn">
                                            	<input type="hidden" name="langCode" id="langCode" value="1" > 
                                                <button class="btn btn-default getone" id="checkForm"  type="button">जमा करें</button>
                                                <button class="btn btn-default getone"  type="reset">रीसेट  करें</button>
                                        </div>
                                      

										 </form>
										
                                    </div>
                                   
                                </div>
                         
                            </div>
                            <div class="button_div">
                                <a href="governmentServiceProviderhindi" class="panel">
                                    <img src="img/new/backhindi.png" alt=""></a>
                                
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
			$("#errdist").html('');
			$("#errteh").html('');
			$("#errvill").html('');
			$("#errkhasral").html('');
			
			if( $("#District_code").val().trim()==''){
				$("#errdist").html('<p style="color:red;float: left;">*जिला  चुनें</p>');
				$("#District_code").focus();
				return false;
			}
			if( $("#Tehsil_code").val().trim()==''){
				$("#errteh").html('<p style="color:red;float: left;">*तहसील  चुनें</p>');
				$("#Tehsil_code").focus();
				return false;
			}
			if( $("#Village_code").val().trim()==''){
				$("#errvill").html('<p style="color:red;float: left;">*गांव  चुनें </p>');
				$("#Village_code").focus();
				return false;
			}
			
			if( $("#khasra").val().trim()==''){
				$("#errkhasral").html('<p style="color:red;float: left;">*खसरा  नंबर  दर्ज   करें  </p>');
				$("#khasra").focus();
				return false;
			}
						
			$('#loading').show();
			$("#jamabandi_details").attr("action", "jamabandiservice");
			$("#jamabandi_details").attr("method", "post");
			$("#jamabandi_details").submit();
		})
	});

	  function csd(id) {
		document.getElementById("Tehsil_code").innerHTML="";
		document.getElementById("Village_code").innerHTML="";
		var distcode=id.value;
		var xhttp = new XMLHttpRequest();		
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
			    var options="<option value=''>तहसील  चुनें</option>";			
				var obj = JSON.parse(this.responseText);
				
				//var object = JSON.parse(data.toString('utf8'));
				var cohortList = '';
				for ( var x in obj) {
					var tehsilname= obj[x].tehsilname;	
				
					options+='<option value='+obj[x].tehsilno_census+'>'+tehsilname+'</option>';
				}
				//alert("options :: "+ options);
				document.getElementById("Tehsil_code").innerHTML=options;
			}
			
		};
		var action = "getTehsilByDistrict?distcode=" + distcode;		
		xhttp.open("GET", action, true);	
	    xhttp.send(); 
	} 

	function findvillage(id) {
		document.getElementById("Village_code").innerHTML="";
		var distcode=document.getElementById("District_code").value;
		var tehsilcode=id.value;		
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				 var options="<option value=''>गांव  चुनें </option>";		
				var obj = JSON.parse(this.responseText);
				var cohortList = '';
				for ( var x in obj) {
					var valueIs=obj[x].VILLAGENAME;
					
					options+='<option value='+obj[x].VILLAGEID+'>'+valueIs+'</option>';
				}
				//alert("options :: "+ options);
				document.getElementById("Village_code").innerHTML=options;
			}
			
		};
		var action = "getVillageByTehsil?distcode=" + distcode+" &tehsilcode="+tehsilcode;
		xhttp.open("GET", action, true);
		xhttp.send(); 
	} 
	
	
	

  	</script>

</body>

</html>

