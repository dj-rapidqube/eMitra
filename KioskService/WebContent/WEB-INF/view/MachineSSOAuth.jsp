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
<title>MACHINE AUTH</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css" />
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
</head>

<body style="background: url(img/inner-bg.png); background-size: cover;">

	<div id="wrapper">
		<div id="mask">


			<div id="machineauth" class="item">
				<div class="content">
					<!--<a href="#item1" class="panel">back</a>-->
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
								<div class="col-md-4">
									<a href="login"
										class="panel pull-right homebtn"> <img
										src="img/new/back.png" alt="" /></a>
								</div>
							</div>
						</div>
					</div>
					<div class="fourservices machineauth">
						<div class="innermid">
							<div class="container main_row" id="showform" style="width: 50%">
								

									<div class="billmidmain">
										<h1>Kiosk Machine Authentication</h1>
										<div class="col-md-12">									

											<div class="feildone" style="text-align: center">
											<form id="Machine_details" class="form-horizontal detailform">
												<div class="form-group col-md-12">
													<div class="col-md-5">
														<div class="billid">
															<label for="exampleInputEmail1"
																class="bmd-label-floating">Machine Serial Number</label>
														</div>
													</div>
													<div class="col-md-7">
														<div class="billidright">
															<div class="form-group">
																<input type="text" class="form-control"
																	required="required" autocomplete="off" name="machineId"
																	id="machineId" placeholder=" Enter Machine Serial Number" VALUE="">
																<div class="billidright" id="errTokenId"></div>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group col-md-12">
												<div class="twobtn">
												<button class="btn btn-default getone" id="checkForm"
													type="button">Submit</button>
												<button class="btn btn-default getone"
													type="reset">Reset</button>
											</div>
                                            </div>
											
											
										</form>
</div>
									</div>
</div>
								

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" role="dialog"
		data-backdrop="static" data-keyboard="false">
	
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Machine Authentication</h4>
				</div>
				<div class="modal-body">
					<span id="showMsg" style="color: red;"></span>
				</div>
				<div class="modal-footer" style="text-align: center">
					<a href="login" class="panel">
						<button class="btn btn-default getone">Yes</button>
					</a>
					<button class="btn btn-default getone" data-dismiss="modal">No</button>
				</div>
			</div>

		</div>
	</div>
	<c:set var="errMsg" value="${error}"></c:set>
	<c:set var="machineSSOId" value="${MachineId}"></c:set>

	<div id="loading" style="display: none;">
		<img id="loading-image" src="img/ajax-loader.gif" alt="Loading..." />
	</div>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js/app-inner.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#checkForm").on('click',	function() {
				//	alert("dfsgfdh");
				$("#errTokenId").html('');
				if ($("#machineId").val().trim() == '') {
					$("#errTokenId").html('<p style="color:red;float: left;">* Enter Machine SSO ID No</p>');
					$("#machineId").focus();
					return false;
				}
				$('#loading').show();

				$("#Machine_details").attr("action",
						"validateEmitraPlusMachine");
				$("#Machine_details").attr("method", "post");
				$("#Machine_details").submit();

			})
		});

		$(document).ready(function() {
			var id = "${errMsg}";
			// alert("id"+ id);
			if (id != "") {
				var msg = '';
				if(id==1){
					msg = "You are not authorized to login on this machine. Please try again!";
				}else if(id ==2 ){
					msg = "Some issue occured, so please try again";
				}
				$("#showMsg").html(msg);
				$("#myModal").modal();
			}

			var SSoid = "${machineSSOId}";
			$('#machineId').val(SSoid);

		});

	
	</script>

</body>

</html>

