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
<style>
.modal-content {
	height: 400px;
}

.modal-body {
	position: absolute;
	top: -100px;
	right: 100px;
	bottom: 0;
	left: 194px;
}
</style>
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
											<a href="#"> <img src="img/logo-inner.png" alt="" /></a>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<a href="index" class="panel pull-right homebtn"> <img
										src="img/new/home.png" alt="" /></a>
								</div>
							</div>
						</div>
					</div>

					<div class="fourservices">
						<div class="innermid">
							<div class="container main_row">
								<div class="row circle-container">

									<form>

										<table class="table table-hover table-bordered"
											style="width: 50%" align="center">
											<thead>
												<tr>
													<th style="width: 300px;">S. No.</th>
													<th style="width: 300px;">Refund</th>
													<th style="width: 300px;">Consumer Name</th>
													<th style="width: 300px;">Mobile</th>
													<th style="width: 300px;">Service Name</th>
													<th style="width: 300px;">Amount</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td id="sno">1</td>
													<td id="chech"><input type="radio" id="c1" name="c1"
														onclick="showMe('div1')"></td>
													<td id="ConsName">John</td>
													<td id="phn"><%= request.getServletContext().getAttribute("PhoneNumber") %></td>
													<td id="serv">abc</td>
													<td id="amt">8000</td>
												</tr>
											</tbody>
										</table>

									</form>

									<div class="modal-body"
										style="display: none; width: 75%; height: 100%" id="div1"
										role="dialog">
										<div class="modal-dialog modal-md">
											<div class="modal-content">
												<div class="modal-header myhead refunfhead">

													<button type="button" class="close" onclick="hideMe()"
														data-dismiss="modal">&times;</button>
													Refund Details
												</div>

												<table>
													<div class="modal-body">
														<div class="row">
															<div class="form-group col-md-12 motp">
																<tr>
																	<td>
																		<label class="col-sm-3 control-label" for="form-field-1">
																			Consumer Name
																		</label>
																	</td>

																	<div class="col-sm-9">
																		<div class="input-group form-group">
																			<td>
																				<input type="text" id="consumerName" name="consumerName" placeholder="Consumer Name" class="form-control" autocomplete="on" />
																			</td>

																		</div>

																	</div>
																</tr>
																<tr>

																	<td><label class="col-sm-3 control-label"
																		for="form-field-1">Mobile NO</label></td>

																	<td><div class="col-sm-9">
																			<div class="input-group form-group">
																				<div class="input-group-addon addoninput">+91</div>

																				<input type="text" id="mobileno" name="mobileno"
																					placeholder="Mobile NO" class="form-control"
																					autocomplete="on" />

																			</div>
																			<span id="mobileerror" class="text-danger"></span>
																		</div></td>
																</tr>
																<tr>
																	<td><label class="col-sm-3 control-label"
																		for="form-field-1">Service Name</label></td>

																	<td>
																		<div class="col-sm-9">
																			<div class="input-group form-group">


																				<input type="text" id="serviceName"
																					name="serviceName" placeholder="Service Name"
																					class="form-control" autocomplete="on" />

																			</div>
																	</td>
																</tr>
																<tr>
																	<td><label class="col-sm-3 control-label"
																		for="form-field-1">Amount</label></td>

																	<td><div class="col-sm-9">
																			<div class="input-group form-group">


																				<input type="text" id="amount" name="amount"
																					placeholder="Amount" class="form-control"
																					autocomplete="on" />

																			</div>

																		</div></td>
																</tr>
															</div>
														</div>
													</div>
												</table>

												<div class="col-sm-3">
													<input type="button" onclick="sendOTP()"
														class="btn btn-default btn-raised getone" value="Refund">
												</div>
											</div>
										</div>
									</div>

								</div>

							</div>

						</div>
						<div class="button_div">
						<a href="index" class="panel"> <img src="img/new/back.png"
							alt="" /></a>
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
	<script type="text/javascript" src="js/app.js"></script>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>
	<script type="text/javascript" src="js/slick.js"></script>
	<script src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>

	<script type="text/javascript">
	 function showMe (box) {
	        
	        var chboxs = document.getElementsByName("c1");
	        var vis = "none";
	        for(var i=0;i<chboxs.length;i++) { 
	            if(chboxs[i].checked){
	             vis = "block";
	                break;
	            }
	        }
	        document.getElementById(box).style.display = vis;
	    	document.getElementById('amount').value = document.getElementById('amt').innerHTML;
	    	document.getElementById('consumerName').value = document.getElementById('ConsName').innerHTML;	    	
	    	document.getElementById('mobileno').value = document.getElementById('phn').innerHTML;
	    	document.getElementById('serviceName').value = document.getElementById('serv').innerHTML;
	    }
	 function hideMe(){
		 $('#div1').hide();
		 document.getElementById('c1').checked = false;
	 }
	</script>

</body>

</html>

