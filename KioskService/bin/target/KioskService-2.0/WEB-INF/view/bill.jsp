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
<title>Kiosk - Bill</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link href="css/my-style.css" type="text/css" rel="stylesheet" />

</head>

<body style="background: url(img/inner-bg.png); background-size: cover;">

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
									<a href="index" class="panel pull-right homebtn"> <img
										src="img/new/home.png" alt="" /></a>
								</div>
							</div>
						</div>
					</div>
					<div class="fourservices">
						<div class="innermid">
							<div class="container main_row">
								<div class="row">
									<div class="billmidmain">
										<h1 class="">Your payment for Airtel Bill is successfully
											done</h1>
										<table class="table">
											<thead>
												<tr>
													<th>Name</th>
													<th>Phone NO</th>
													<th>Email ID</th>
													<th>Service</th>
													<th>Bill Amount</th>
													<th>Due Date</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>SACHIN BANSAL</td>
													<td>9874563210</td>
													<td>john@example.com</td>
													<td>Postpaid</td>
													<td>250</td>
													<td>22-Sep-17</td>
												</tr>

											</tbody>
										</table>
										<input type="button" value="Print Receipt" id="printRec">
									</div>
								</div>
								
							</div>

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

	<script>
		$(function() {
			$("#printRec").on('click', function() {
				var printData = $('#rp').val();
			//	printData = 'KAPIL';

				var dataToSend = {
					"printData" : printData
				};
				dataToSend = JSON.stringify(dataToSend);
				$.ajax({
					url : '/KioskService/printRec/',
					type : "POST",
					contentType : 'application/json; charset=utf-8',
					dataType : 'text',
					data : dataToSend,
					success : function(data) {
						$('#d4').html(data);
						alert(data);
						console.log(data);

						$.ajax({
							url : 'printReceipt',
							type : "POST",
							dataType : 'text',
							data : {
								"userData" : printData
							},
							success : function(data) {
								alert(data);
							},
							error : function(xhr, status, error) {
								//alert("Some Error Occoured..");
							}
						});
					},

					error : function(xhr, status, error) {
						$('#d4').html(error);
						//alert("Some Error Occoured..");
						console.log("Error " + error);
					}
				});
			})
		});
	</script>


</body>

</html>
