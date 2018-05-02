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
<title>Details of Land Records</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
  <link href="css/jquery.mCustomScrollbar.css" type="text/css" rel="stylesheet" />

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
										<h1 class="">Details of Land Records</h1>
										 <div id="content-1" class="content mCustomScrollbar">
										<%-- <center> --%>
											<table class="table">
											<thead>
											<tr>
											<th>Id</th>
											<th>Row Order</th>
											<th>Khata</th>
											<th>Old Khata</th>
											<th style="width: 20%;">Owner Name</th>
											<th>Khasra</th>
											<th>Khasra Area</th>
											<th>Soil Name</th>
											<th>Soil Area</th>
											<th>Soil Rev</th>
											<th>Soil Rate</th>
											<th>Area Unit</th>
											<th>Khasra Irrigation</th>
											<th>Khasra Plot</th>
											</tr>
											</thead>
											<tbody>
											
											<c:forEach items="${details}" var="list">
												<tr>
											    <td>${list.id}</td>
											   <td>${list.rowOrder}</td>
											    <td>${list.khata}</td>
											     <td>${list.oldkhata}</td>
											     <td style="width: 20%;">${list.ownerName}</td>
											       <td>${list.khasra}</td>
											        <td>${list.khasraarea}</td>
											         <td>${list.soilName}</td>
											          <td>${list.soilArea}</td>
											           <td>${list.soilRev}</td>
											            <td>${list.soilRate}</td>
											             <td>${list.areaunit}</td>
											             <td>${list.khasraIrrigation}</td>
											             <td>${list.khasraPlot}</td>  
											
											</tr>
											</c:forEach>
											
											
											</tbody>
											
											


											</table>
											</div>
									<%-- 	</center> --%>
									</div>
								</div>

							</div>


							<div class="button_div">
								<a href="jamabandiRecord" class="panel"> <img src="img/new/back.png"></a>
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
	 <script type="text/javascript" src="js/jquery.mCustomScrollbar.concat.min.js"></script>
	 <script type="text/javascript" src="js/app-inner.js"></script>


</body>

</html>
