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
									<div class="billmidmain ">
										<h1 class="">Details of Board of Secondary Education, Ajmer (10th Class) Exam</h1>
										
										<center>
											<table class="table" style="width: 50%">
												<c:choose>
													<c:when test="${MSG=='Invalid roll no,exam year'}">
														<tr>
															<th>Message</th>
															<td>${MSG}</td>
														</tr>
													</c:when>
													<c:otherwise>

														<tr>
															<th>Exam Year</th>
															<td>${examyear}</td>
														</tr>
														<tr>
															<th>Exam Name</th>
															<td>${examname}</td>
														</tr>
														<tr>
															<th>Roll No</th>
															<td>${RollNo}</td>
														</tr>
														<tr>
															<th>Student Name</th>
															<td>${StudentName}</td>
														</tr>
														<tr>
															<th>Gender</th>
															<td>${Gender}</td>
														</tr>
														<tr>
															<th>Father Name</th>
															<td>${FatherName}</td>
														</tr>
														<tr>
															<th>Mother Name</th>
															<td>${MotherName}</td>
														</tr>
														<tr>
															<th>Date Of Birth</th>
															<td>${DateofBirth}</td>
														</tr>
														<tr>
															<th>Date Of Issue</th>
															<td>${DateofIssue}</td>
														</tr>
														<tr>
															<th>Status</th>
															<td>${Status}</td>
														</tr>
													</c:otherwise>
												</c:choose>


											</table>
										</center>
									</div>
								</div>

							</div>


							<div class="button_div">
								<a href="examservice" class="panel"> <img src="img/new/back.png"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	  <script type="text/javascript"  src="js/jquery.scrollTo.js"></script>
	  <script type="text/javascript" src="js/app-inner.js"></script>


</body>

</html>
