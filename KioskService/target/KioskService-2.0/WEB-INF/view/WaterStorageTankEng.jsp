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
<title>Agriculture Department</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet" />
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link href="css/my-style.css" type="text/css" rel="stylesheet" />
<link href="css/jquery.mCustomScrollbar.css" type="text/css"
	rel="stylesheet" />
<link href="css/formValidation.min.css" type="text/css" rel="stylesheet" />
</head>




<body style="background: url(img/inner-bg.png); background-size: cover;">

	<div id="wrapper">
		<div id="mask">


			<div id="fill" class="item sinfo">
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
										<h1 class="">Agriculture Department</h1>
										<span class="text-info">Application for subsidy on
											Water Storage Tank</span>
										<div id="content-1" class="content mCustomScrollbar">
											<form id="myEForm" method="post" class="form-horizontal detailform">


												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-body">
															<div class="widget-main">
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Aadhaar
																		(UID Or EID Number) </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass  number" required
																			id="aadharId" name="aadharId" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="gender">Bhamashah
																		ID </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass  EformEnblockAlphanumaricWithoutSpace "
																			required id="bhamshahId" name="bhamshahId" />
																	</div>
																</div>


															</div>
														</div>
													</div>

												</div>


												<div class="col-md-12">

													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Personal Details</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Farmer
																		Name </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass EformEnalphabetWithSpaceDot"
																			required id="FarmerName" name="FarmerName"
																			data-msg="Please provide an accurate 'Farmer's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="RelationType">Relation Type </label>

																	<div class="col-sm-8">
																		<select id="RelationType" name="RelationType"
																			class="form-control  cal" required>
																			<option selected disabled>Select</option>
																			<option>Father</option>
																			<option>Husband</option>

																		</select>
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="FatherHusbandName">Father/Husband Name </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control  eformclass EformEnalphabetWithSpaceDot"
																			required id="Fathe_Hus_Name" name="Fathe_Hus_Name"
																			data-msg="Please provide an accurate 'Father/Husband's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">Caste - Category </label>

																	<div class="col-sm-8">
																		<select id="cast1" name="cast1"
																			class="form-control eformclass" required>
																			<option selected disabled>Select</option>
																			<option value="1">OBC</option>
																			<option value="2">SBC</option>
																			<option value="3">SC</option>
																			<option value="4">ST</option>
																			<option value="5">General</option>
																			<option value="6">Minority</option>
																			<option value="7">Others</option>
																		</select>
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="Email">E-mail </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control email"
																			id="txt_Email_Service" name="txt_Email_Service"
																			data-msg="Please enter a proper 'Email' : For e.g., kavita.krishna12@gmail.com" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="MobileNumber">Mobile Number </label>

																	<div class="col-sm-8">
																		<input type="text" id="Mobile" name="Mobile"
																			class="form-control eformclass EformEnnumaricOnly1"
																			minlength="10" maxlength="13"
																			placeholder="Enter Mobile Number"
																			data-msg="Please enter a correct 'Mobile No.' [For e.g., 9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'."
																			required />
																	</div>
																</div>

																<div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="aao">Assistant agriculture officer(AAO)
																		circle </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control  eformclass EformEnalphabetWithSpaceDot"
																			required id="agricultureofficer"
																			name="agricultureofficer"
																			data-msg="Please provide an accurate 'Assistant agriculture officer(AAO) circle'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="asc">Agriculture
																		supervisor Circle </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control  eformclass EformEnalphabetWithSpaceDot"
																			required id="supervisorCircle"
																			name="supervisorCircle"
																			data-msg="Please provide an accurate 'Agriculture supervisor Circle'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>

																<div class="clearfix"></div>

															</div>
														</div>
													</div>
												</div>


												<div class="col-md-12">

													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Farmer's Land Description</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="irrigated">Irrigated
																		(in Hectares)</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass  number Irrigated"
																			required id="LandonApplicantNameHectaresIrrigated"
																			name="LandonApplicantNameHectaresIrrigated"
																			data-msg="Please enter value in 'Irrigated (in Hectares)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="nonirrigated">Non-irrigated (in Hectares)
																	</label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass number Irrigated"
																			required id="LandonApplicantNameHectaresNonIrrigated"
																			name="LandonApplicantNameHectaresNonIrrigated"
																			data-msg="Please enter value in 'Non-irrigated (in Hectares)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." />
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="tl">Total
																		Land (in Hectares) </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass  number" required
																			disabled id="TotalLandHectares"
																			name="TotalLandHectares" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="khasrano">Khasra
																		number (in which farm pond is proposed) </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass  EformEnblockAlphanumaricWithSpaceComma"
																			required id="Khasranumber" name="Khasranumber"
																			data-msg="Please Provide correct Khasra Number. It allows only alphanumaric with space and comma." />
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="sourceofirr">Source of Irrigation</label>

																	<div class="col-sm-7">
																		<select id="mst_ddlIrrigation_serv"
																			class="select form-control"
																			name="mst_ddlIrrigation_serv" required>
																			<option selected disabled>Select</option>
																			<option value="2">Tube well</option>
																			<option value="1">Well</option>
																			<option value="3">Others</option>
																		</select>
																	</div>
																</div>

																<div class="clearfix"></div>

															</div>
														</div>
													</div>
												</div>


												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Size of farm pond(Length X
																Breadth X Depth)</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Length (in meter)">Length (in meter)</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass  number" required
																			id="LengthFarm" name="LengthFarm"
																			data-msg="Please enter value in 'Length (in Feet)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Breadth (in meter)">Breadth (in meter) </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass col-sm-8 number "
																			required id="BreadthNumber" name="BreadthNumber"
																			data-msg="Please enter value in 'Breadth (in Feet)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." />
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Depth (in meter)">Depth (in meter) </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass  number" required
																			id="Depth" name="Depth"
																			data-msg="Please enter value in 'Depth (in Feet)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="wstc">Water
																		Storage Tank Capacity (in lakh Litres) </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass  number" required
																			id="TankCapacity" name="TankCapacity"
																			data-msg="Please enter value in 'Water Storage Tank Capacity (in lakh Litres)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." />
																	</div>
																</div>

																<div class="clearfix"></div>

															</div>
														</div>
													</div>

												</div>


												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Address of the Premises
																where the manufacturing activity will be done</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Address In English</label>

																	<div class="col-sm-7">
																		<textarea
																			class="form-control wd65 englishDescription eformclass"
																			id="permeEformAddressInEngtext"
																			name="permeEformAddressInEngtext" minlength="2"
																			maxlength="300" readonly></textarea>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Address In Hindi">Address In Hindi </label>

																	<div class="col-sm-8">
																		<textarea
																			class="form-control wd65 hindiDescription eformclass"
																			id="permeEformAddressInHintext"
																			name="permeEformAddressInHintext"
																			placeholder="Address In Hindi" minlength="2"
																			maxlength="300" readonly></textarea>
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Country</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformCountryIdtext"
																			name="permeEformCountryIdtext"
																			class="form-control wd65 eformclass" disabled="" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="State">State
																	</label>

																	<div class="col-sm-8">
																		<input type="text" id="permeEformStateIdtext"
																			name="permeEformStateIdtext"
																			class="form-control wd65 eformclass" disabled="">
																	</div>
																</div>

																<div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Division">Division</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformDivisionIdtext"
																			name="permeEformDivisionIdtext"
																			class="form-control wd65 eformclass" disabled="">
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">District
																	</label>

																	<div class="col-sm-8">
																		<input type="text" id="permeEformDistrictIdtext"
																			name="permeEformDistrictIdtext"
																			class="form-control wd65 eformclass" disabled="" />
																	</div>
																</div>

																<div class="clearfix"></div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Tehsil">Tehsil</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformTehsilIdtext"
																			name="permeEformTehsilIdtext"
																			class="form-control wd65 eformclass" disabled="" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Municipality
																	</label>

																	<div class="col-sm-8">
																		<input type="text" id="permeEformMunicipalityIdtext"
																			name="permeEformMunicipalityIdtext"
																			class="form-control wd65 eformclass" disabled="" />
																	</div>
																</div>

																<div class="clearfix"></div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Ward</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformWardIdtext"
																			name="permeEformWardIdtext"
																			class="form-control wd65 eformclass" disabled="" />
																	</div>
																</div>


																<div class="permeEformVillageMstrMap hide-service"
																	style="display: none;">

																	<div class="form-group col-md-6 required">
																		<label class="col-sm-4 control-label"
																			for="Panchayat Samity">Panchayat Samity </label>

																		<div class="col-sm-8">
																			<input type="text"
																				id="permeEformPanchayatSamityIdtext"
																				name="permeEformPanchayatSamityIdtext"
																				class="form-control col-sm-8 eformclass" />
																		</div>
																	</div>

																	<div class="form-group col-md-6 required">
																		<label class="col-sm-5 control-label" for="Ward">Gram
																			Panchayat</label>

																		<div class="col-sm-7">
																			<input type="text" id="permeEformGramPanchayatIdtext"
																				name="permeEformGramPanchayatIdtext"
																				class="form-control col-sm-8 eformclass" />

																		</div>
																	</div>

																	<div
																		class="col-sm-6 permeEformVillageMstrMap hide-service required"
																		aria-required="true" style="display: none;">
																		<div class="form-group col-md-6 required"
																			aria-required="true">

																			<label class="col-sm-4 control-label" for="Village">Village
																			</label>

																			<div class="col-sm-8">
																				<input type="text" id="permeEformVillageIdtext"
																					name="permeEformVillageIdtext"
																					class="form-control wd65 eformclass" />
																			</div>
																		</div>

																	</div>
																</div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Pin
																		Code </label>

																	<div class="col-sm-8">
																		<input type="number"
																			class="form-control wd65 eformclass "
																			id="permeEformAddPinCodetext"
																			name="permeEformAddPinCodetext" maxlength="6"
																			minlength="6" placeholder="Pin Code" value=""
																			readonly>
																	</div>
																</div>

																<div class="clearfix"></div>

															</div>
														</div>
													</div>

												</div>

												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Pump Set</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Brand">Brand</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass EformEnblockSpacialCharacters"
																			required id="PumpSet" name="PumpSet"
																			data-msg="Please provide correct 'Brand'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."
																			maxlength="20" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="nonirrigated">Model </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters "
																			required id="PumpSetModel" name="PumpSetModel"
																			data-msg="Please provide correct 'Model'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."
																			maxlength="20" />
																	</div>
																</div>

																<div class="clearfix"></div>

															</div>
														</div>
													</div>
												</div>

												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Sprinkler set/ Drip
																/Micro-Sprinkler</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Brand">Brand</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters"
																			id="Brand" name="Brand"
																			data-msg="Please provide correct 'Brand'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."
																			maxlength="20" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="Model">Model
																	</label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters"
																			id="Model" name="Model"
																			data-msg="Please provide correct 'Model'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."
																			maxlength="20" />
																	</div>
																</div>

																<div class="clearfix"></div>

															</div>
														</div>
													</div>
												</div>

												<div class="col-md-12">
													<div class="widget-box">

														<div class="widget-header">
															<h4 class="widget-title">Boundary map and Nazariya
																Map of field (showing well/tubewell and Water Storage
																Tank position )</h4>
															<div class="clearfix"></div>
															<span>Note* :- Please give full boundry map
																details(Boundry Map include all directions as North,
																South, East, West)</span>

														</div>
														<div class="widget-body">
															<div class="widget-main">
																<div class="col-sm-12 form-group required">
																	<table class="table table-hover table-bordered">
																		<thead>
																			<tr>
																				<th><label class="control-label col-sm-12">Farmer’s
																						name in East direction</label></th>
																				<th><label class="control-label col-sm-12">Farmer’s
																						name in West direction</label></th>
																				<th><label class="control-label col-sm-12">Farmer’s
																						name in North direction</label></th>
																				<th><label class="control-label col-sm-12">Farmer’s
																						name in South direction</label></th>

																			</tr>
																		</thead>
																		<tbody id="possessionTableAdd2">
																			<tr>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="EastFarmername1" id="EastFarmername1"
																					data-msg="Please provide an accurate 'Farmer’s name in East direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."
																					required></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="WestFarmername1" id="WestFarmername1"
																					data-msg="Please provide an accurate 'Farmer’s name in West direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."
																					required></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="NorthFarmername1" id="NorthFarmername"
																					data-msg="Please provide an accurate 'Farmer’s name in North direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."
																					required></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="SouthFarmername1" id="SouthFarmername11"
																					data-msg="Please provide an accurate 'Farmer’s name in South direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."
																					required></th>

																			</tr>

																			<tr>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="EastFarmername2" id="EastFarmername2"
																					data-msg="Please provide an accurate 'Farmer’s name in East direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="WestFarmername2" id="WestFarmername2"
																					data-msg="Please provide an accurate 'Farmer’s name in West direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="NorthFarmername2" id="NorthFarmername2"
																					data-msg="Please provide an accurate 'Farmer’s name in North direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="SouthFarmername2" id="SouthFarmername2"
																					data-msg="Please provide an accurate 'Farmer’s name in South direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>

																			</tr>

																			<tr>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="EastFarmername3" id="EastFarmername3"
																					data-msg="Please provide an accurate 'Farmer’s name in East direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="WestFarmername3" id="WestFarmername3"
																					data-msg="Please provide an accurate 'Farmer’s name in West direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="NorthFarmername3" id="NorthFarmername3"
																					data-msg="Please provide an accurate 'Farmer’s name in North direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="SouthFarmername3" id="SouthFarmername3"
																					data-msg="Please provide an accurate 'Farmer’s name in South direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>

																			</tr>

																			<tr>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="EastFarmername4" id="EastFarmername4"
																					data-msg="Please provide an accurate 'Farmer’s name in East direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="WestFarmername4" id="WestFarmername4"
																					data-msg="Please provide an accurate 'Farmer’s name in West direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="NorthFarmername4" id="NorthFarmername4"
																					data-msg="Please provide an accurate 'Farmer’s name in North direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																				<th><input type="text"
																					class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot"
																					name="SouthFarmername4" id="SouthFarmername4"
																					data-msg="Please provide an accurate 'Farmer’s name in South direction'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>

																			</tr>

																		</tbody>

																	</table>

																	<div class="col-sm-8 form-group required">


																		<label class="col-sm-6 control-label" for="irrigated">I
																			have not availed subsidy in previous years</label>

																		<div class="col-sm-4">
																			<select id="subsidy" name="subsidy"
																				class="form-control eformclass" required>
																				<option selected disabled>Select</option>
																				<option>YES</option>
																				<option>NO</option>
																			</select>
																		</div>

																	</div>
																</div>

															</div>
														</div>
													</div>
												</div>


												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Bank Details</h4>
														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="irrigated">Name
																		of Bank</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot"
																			required id="Name_of_Bank" name="Name_of_Bank"
																			data-msg="Please provide an accurate 'Bank Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="nonirrigated">Name of Bank Branch </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot "
																			required id="Name_of _Bank_Branch"
																			name="Name_of _Bank_Branch"
																			data-msg="Please provide an accurate 'Branch Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>

																<div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="tl">IFSC
																		Code </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters"
																			required id="IFSC_Code" name="IFSC_Code"
																			maxlength="15" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="khasrano">Account
																		Number </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnnumaricOnly"
																			required id="Account_Number" name="Account_Number"
																			maxlength="20"
																			data-msg="'Account Number' must be an integer." />
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="sourceofirr">Source of Irrigation</label>

																	<div class="col-sm-7">
																		<select id="mst_ddlIrrigation_serv"
																			class="select form-control"
																			name="mst_ddlIrrigation_serv" required>
																			<option selected disabled>Select</option>
																			<option value="2">Tube well</option>
																			<option value="1">Well</option>
																			<option value="3">Others</option>
																		</select>
																	</div>
																</div>

																<div class="clearfix"></div>

															</div>
														</div>
													</div>

												</div>

													 <div class="twobtn">
													<button type="submit"
														class="btn btn-default getone griefrom" name="signup"
														value="Sign up" id="saveEform">Submit</button>
													<button class="btn btn-default btn-raised getone"
														type="reset">RESET</button>
												</div> 
											</form>
										</div>
									</div>
								</div>


							</div>
							<div class="button_div">
								<a href="agricultureDeptList" class="panel"> <img
									src="img/new/back.png" alt="" /></a>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/formValidation.min.js"></script>
	<script type="text/javascript" src="js/bootstrapvalid.min.js"></script>
	<script type="text/javascript" src="js/jquery.scrollTo.js"></script>
	<script type="text/javascript"
		src="js/jquery.mCustomScrollbar.concat.min.js"></script>

	
	
	<script src="js/dist/jquery.validate.js"></script>
 <script type="text/javascript">

        $('.calcWater').blur(function () {

            var totalCal = $('#Length').val() * $('#Breadth').val() * $('#Depth').val();
            $('#WaterIntakenumber').val(totalCal);

        });
        $(document).on('blur', '#IFSC_Code', function (event) {
            $('#Name_of_Bank').val('').prop('disabled', false);
            $('#Name_of_Bank_Branch').val('').prop('disabled', false);

            if ($(this).val() != '') {

                $.ajax({
                    url: 'getBankBranchDetailByIfscCode',
                    headers: { 'allow-bypass-header': 'getBankBranchDetailByIfscCode' },
                    type: 'POST',
                    data: {
                        ifscCode: $(this).val()
                    },
                    success: function (data) {
                        console.log(data);
                        $('#Name_of_Bank').val(data.bankNameEng).prop('disabled', true);
                        $('#Name_of_Bank_Branch').val(data.branchNameEng).prop('disabled', true);







                    },
                    error: function (data) {

                        bootbox.alert("IFSC Code Not found, please try again!");

                        $('#Name_of_Bank').val('').prop('disabled', false);
                        $('#Name_of_Bank_Branch').val('').prop('disabled', false);
                    }

                });
            }
            else {
                $('#lspBankId option:eq(0)').attr('selected', 'selected');
                $('#lspBankBranchId').html('<option value="">-Select Branch-</option>');
            }

        });

        $('#PumpSet').change(function () {

            if ($(this).val() == 'Already established' || $(this).val() == 'पूर्व मे स्थापित') {
                $('.PumpSetYes').prop('disabled', false);
            }
            else {
                $('.PumpSetYes').prop('disabled', true);
            }
        });


        $('#SprinklerDrip').change(function () {
            if ($(this).val() == 'Already established' || $(this).val() == 'पूर्व मे स्थापित') {
                $('.ifselectYes2').prop('disabled', false);
            }
            else {
                $('.ifselectYes2').prop('disabled', true);
            }
        });

        $('.Irrigated').blur(function () {
            var tohac = 0;
            $('.Irrigated').each(function () {
                tohac += +$(this).val();
            });
            $('#TotalLandHectares').val(tohac).prop('disabled', true);
        });











        if ($('#userImage').val() == 'NA' || $('#userImage').val() == "") {

        }
        else {
            $('#userImageView').attr('src', 'data:image/jpeg;base64,' + $('#userImage').val());
            $('#userImageEformValue').val('data:image/jpeg;base64,' + $('#userImage').val());
            $('#base64DataOfImage').val('data:image/jpeg;base64,' + $('#userImage').val());

            $('#userImageEform').removeClass('required').attr('disabled', true);



        }

        fillAddressBlock();
        function fillAddressBlock() {

            if ($('#addrType').val() == 'P') {
                $('.permanentaddressDivblock select').each(function (key) {
                    $('#textaddeform input').eq(key).val($('option:selected', this).text());
                    $('#textaddeformcurr input').eq(key).val($('option:selected', this).text());
                });


                $('.permanentaddressDivblock textarea').each(function (key) {
                    $('#textaddeform textarea').eq(key).val($(this).val());
                    $('#textaddeformcurr textarea').eq(key).val($(this).val());
                });

                $('.permanentaddressDivblock input').each(function (key) {
                    $('#permeEformAddPinCodetext').val($(this).val());
                    $('#permeEformAddPinCodetext').val($(this).val());
                });

            }
            else {

                $('.currentaddressDivblock select').each(function (key) {
                    $('#textaddeform input').eq(key).val($('option:selected', this).text());
                    $('#textaddeformcurr input').eq(key).val($('option:selected', this).text());
                });


                $('.currentaddressDivblock textarea').each(function (key) {
                    $('#textaddeform textarea').eq(key).val($(this).val());
                    $('#textaddeformcurr textarea').eq(key).val($(this).val());
                });

                $('.currentaddressDivblock input').each(function (key) {
                    $('#permeEformAddPinCodetext').val($(this).val());
                    $('#permeEformAddPinCodetext').val($(this).val());
                });
            }
        }




        setTimeout(autoage, 3000);

        function autoage() {

            $('#condAge').val(getAge($('#profiledobSpanEform').val())).attr('disabled', true);

        }

        function getAge(dateString) {


            var dateAr = dateString.split('/');
            var dateString = dateAr[1] + '/' + dateAr[0].slice(-2) + '/' + dateAr[2];


            var today = new Date();
            var birthDate = new Date(dateString);
            var age = today.getFullYear() - birthDate.getFullYear();
            var m = today.getMonth() - birthDate.getMonth();
            if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
                age--;
            }
            return age;
        }



        //LessCurrent Year 
        var today = new Date();
        var year = today.getFullYear();



        $("#myEForm").validate({
            rules: {
                ResidenceYear: {
                    required: true,
                    range: [1950, year]
                }
            },
            submitHandler: function (form) {



                if ($('#userImageView').attr('src') == 'resources/assets/images/default_profile.jpg') {

                    bootbox.alert("कृपया फ़ोटो अपलोड करें!");
                    return false;

                }





                saveEform();



            }
        });


        var json = "";

        function MultiWidget(json) {

            MemberWidget(json);

        }




        $('#titletyp').change(function () {
            if ($(this).val() == 'श्री') {
                $('#genEform').val('MALE').attr('disabled', true);
            }
            else {
                $('#genEform').val('FEMALE').attr('disabled', true);
            }

        })



        function MemberWidget(json) {

            var json = $.parseJSON(json);


            /*
            if(json.member.length > 0)
            {
                for(var i=0;i<json.member.length;i++){
            var HtmlTr = "<tr><input type='hidden' class='eformclass' set-tabname='MemberTable' /><td>1.</td><td><input type='text' class='form-control eformclass col-sm-12 EformEnalphabetWithSpaceDot' name='memberName"+i+" id="'memberName'+i+" required /><td><input type='text' class='form-control eformclass col-sm-12 EformEnalphabetWithSpaceDot' name='memberFather"+i+" id="'memberFather'+i+" required /> </td><td> <input type='text' class='form-control  eformclass col-sm-12 EformEnAgeInYears' name='memberAge"+i+" id='memberAge"+i+"' maxlength='3' required /></td><td><select class='form-control col-sm-12 eformclass' name='memberGender"+i+" id='memberGender"+i+"' required><option selected='selected' disabled='disabled' value='0'>Select</option><option value='1'>Female</option><option value='2'>Male</option><option value='3'>Others</option></select></td><td><select class='form-control col-sm-12 eformclass' name='memberRelation"+i+" id='memberRelation"+i+"' required><option selected='selected' disabled='disabled' value='0'>Select</option><option value='1'>Father</option><option value='2'>Mother</option><option value='3'>Others</option></select></td><td><i class='fa fa-plus-square-o fonts30 addMember'></i> <i class='fa fa-minus-square-o fonts30 remMember'></i></td></tr>"	
            $('#memberData').append(HtmlTr);	
            var startIndex=i;
            $('#memberData').append(startIndex);
            "<tr><input type='hidden' class='eformclass' settabname='memberTable'"
            
            }
        
            }
    */










            $(document).on('click', '.addMember', function () {
                $('#memberData').append(HtmlTr);
                $('#memberData tr:first td:last ').empty();
            });
            $(document).on('click', '.remMember', function () {
                $(this).parent().parent().remove();
            });

        }








        (function ($) {

            $.fn.ValidatePattern = function (options) {

                // This is the easiest way to have default options.
                var settings = $.extend(options);

                return this.each(function () {
                    var RegularExpression = settings.RegExp;
                    $(this).keypress(function (e) {
                        //var regex = new RegExp("^[a-zA-Z \s]+$");
                        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
                        if (RegularExpression.test(str)) {
                            return true;
                        }

                        e.preventDefault();
                        return false;
                    });
                });
            };

        }(jQuery));





        //*************/ Validation For Hindi /*************

        ////////// ========== write regax as per requirement ======////////////







        //blockAlphanumaricewithDash
        jQuery.validator.addMethod("dateRange", function (value, element) {
            return this.optional(element) || /^\d+-\d+$/.test(value);
        }, "Please provide correct 'Year'. Accepted values like 2016-2017");





        //blockAlphanumaricewithDash
        jQuery.validator.addMethod("EformHinblockAlphanumaricWithDash", function (value, element) {
            return this.optional(element) || /^[A-Z0-9-]*$/.test(value);
        }, "अंग्रेजी के बड़े अक्षर एवं नंबर एवं - के साथ स्वीकार्य हैं");


        //Amount Field Validation
        jQuery.validator.addMethod("EformHinmoney", function (value, element) {
            return this.optional(element) || /^\d+(\.\d{2})?$/.test(value);
        }, "मात्रा केवल अंक एवं  दश्मलव के बाद दो स्थानो तक ही स्वीकार्य हैं ");

        //BlockAlphanumaricWithoutSpace Validation
        jQuery.validator.addMethod("EformHinblockAlphanumaricWithoutSpace", function (value, element) {
            return this.optional(element) || /^[A-Z0-9]*$/.test(value);
        }, "अंग्रेजी के बड़े अक्षर एवं नंबर बिना रिक्त स्थान के स्वीकार्य हैं");

        //BlockSpacialCharacters Validation
        jQuery.validator.addMethod("EformHinblockSpacialCharacters", function (value, element) {
            return this.optional(element) || /^[A-Z0-9_@.#&+-\/\\s]*$/.test(value);
        }, "अंग्रेजी के बड़े अक्षर एवं नंबर कुछ अन्य अक्षर जैसे _@.#&+-\/\ बिना रिक्त स्थान के स्वीकार्य हैं");

        //Age Validation
        jQuery.validator.addMethod("EformHinmage", function (value, element) {
            return this.optional(element) || /^0*(?:[1-9][0-9]?|110)$/.test(value);
        }, "आयु केवल अंको में तथा 1 से 110 के मध्य अथवा समान ही हो सकती हैं");

        //Numaric Field Validation
        jQuery.validator.addMethod("EformHinnumaricOnly", function (value, element) {
            return this.optional(element) || /^\d+$/.test(value);
        }, "केवल अंक ही स्वीकार्य हैं");

        //Year Validation
        jQuery.validator.addMethod("EformHinyearValidation", function (value, element) {
            return this.optional(element) || /(?:(?:19|20)[0-9]{2})/.test(value);
        }, "वर्ष 1900 से 2099 के मध्य अथवा सामान स्वीकार्य हैं ");

        //Alphabet with space Validation 
        jQuery.validator.addMethod("EformHinalphabetWithSpace", function (value, element) {
            return this.optional(element) || /^[A-Za-z\s]+$/.test(value);
        }, "केवल अंग्रेजी के अक्षर रिक्त स्थान के साथ स्वीकार्य हैं");

        //HindiAlphabetwithSpace Validation
        jQuery.validator.addMethod("EformHinEformhindiAlphabetwithSpace", function (value, element) {
            return this.optional(element) || /^[ँ-॰\s]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान के साथ स्वीकार्य हैं");

        //Alphabet with space dot Validation 
        jQuery.validator.addMethod("EformHinalphabetWithSpaceDot", function (value, element) {

            return this.optional(element) || /^[A-Za-z.\s]+$/.test(value);
        }, "केवल अंग्रेजी के अक्षर रिक्त स्थान एवं . के साथ स्वीकार्य हैं");

        //HindiAlphabetwithSpaceDot Validation
        jQuery.validator.addMethod("EformHinEformhindiAlphabetwithSpaceDot", function (value, element) {
            return this.optional(element) || /^[ँ-॰\s.]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान . के साथ स्वीकार्य हैं");

        //Pincode Field Validation
        jQuery.validator.addMethod("EformHinpincode", function (value, element) {
            return this.optional(element) || /^[1-9][0-9]{5}$/.test(value);
        }, "सही पिनकोड अंकित करे");

        //Alphabet only Block Letters with space
        jQuery.validator.addMethod("EformHinblockLettersWithSpace", function (value, element) {
            return this.optional(element) || /^[A-Z\s]+$/.test(value);
        }, "अंग्रेजी के बड़े अक्षर रिक्त स्थान के साथ स्वीकार्य हैं");

        //Numaric with slash Validation
        jQuery.validator.addMethod("EformHinnumaricWithSlash", function (value, element) {
            return this.optional(element) || /^[\d\/]+$/.test(value);
        }, "केवल अंक एवं / स्वीकार्य हैं");

        //englishDescription
        jQuery.validator.addMethod("EformHinenglishDescription", function (value, element) {
            return this.optional(element) || /^[[A-Za-z 0-9_ \s \] \( \) \/ \. \- \@ \# \, \:\;]+$/.test(value);
        }, "केवल अंग्रेजी के अक्षर रिक्त स्थान . , - @ # : ; () [] के साथ स्वीकार्य हैं");

        //hindiDescription
        jQuery.validator.addMethod("EformHinhindiDescription", function (value, element) {
            return this.optional(element) || /^[[ँ-॰0-9_ \s \] \( \) \- \. \/ \@ \# \, \: \;]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान . , - @ # : ; () [] के साथ स्वीकार्य हैं");


        jQuery.validator.addMethod("EformHinhindiDescription1", function (value, element) {
            return this.optional(element) || /^[[ँ-॰ \s \].]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान . , - @ # : ; () [] के साथ स्वीकार्य हैं");

        jQuery.validator.addMethod("EformHinhindiDescription2", function (value, element) {
            return this.optional(element) || /^[[ँ-॰ \s \],]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान . , - @ # : ; () [] के साथ स्वीकार्य हैं");


        jQuery.validator.addMethod("EformHinhindiDescription3", function (value, element) {
            return this.optional(element) || /^[[ँ-॰ \s \].,-]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान . , - @ # : ; () [] के साथ स्वीकार्य हैं");

        jQuery.validator.addMethod("EformHinhindiDescriptionnumber", function (value, element) {
            return this.optional(element) || /^[[ँ-॰0-9 \s \].,-]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान . , - @ # : ; () [] के साथ स्वीकार्य हैं");


        jQuery.validator.addMethod("EformHinhindiDescription4", function (value, element) {
            return this.optional(element) || /^[[ँ-॰ \s \]]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान . , - @ # : ; () [] के साथ स्वीकार्य हैं");

        jQuery.validator.addMethod("EformHinhindiDescription5", function (value, element) {
            return this.optional(element) || /^[[A-Z 0-9 ँ-॰ \s \]]+$/.test(value);
        }, "केवल हिंदी के अक्षर रिक्त स्थान . , - @ # : ; () [] के साथ स्वीकार्य हैं");
















        ///////*************Validation For English*************//////






        //blockAlphanumaricewithDash
        jQuery.validator.addMethod("EformEnblockAlphanumaricWithDash", function (value, element) {
            return this.optional(element) || /^[A-Z0-9-]*$/.test(value);
        }, "Allows only Block Alphanumaric characters With dash");

        //Amount Field Validation
        jQuery.validator.addMethod("EformEnmmoney", function (value, element) {
            return this.optional(element) || /^\d+(\.\d{2})?$/.test(value);
        }, "Please provide a valid Money (up to 2 decimal places)");




        //BlockAlphanumaricWithoutSpace withDash  Validation
        jQuery.validator.addMethod("EformEnblockAlphanumaricWithoutSpaceWithDash", function (value, element) {
            return this.optional(element) || /^[a-zA-Z0-9._-]*$/.test(value);
        }, "Allows only Block Alphanumaric characters Without Space");






        //BlockAlphanumaricWithoutSpace Validation
        jQuery.validator.addMethod("EformEnblockAlphanumaricWithoutSpace", function (value, element) {
            return this.optional(element) || /^[A-Z0-9]*$/.test(value);
        }, "Allows only Block Alphanumaric characters Without Space");

        //BlockSpacialCharacters Validation
        jQuery.validator.addMethod("EformEnblockSpacialCharacters", function (value, element) {
            return this.optional(element) || /^[A-Za-z0-9_@.#&+-\/\\s]*$/.test(value);
        }, "Allows only Block Alphanumaric characters Without Space");

        //Age Validation
        jQuery.validator.addMethod("EformEnage", function (value, element) {
            return this.optional(element) || /^0*(?:[1-9][0-9]?|110)$/.test(value);
        }, "Age should be Numaric and exist between 1 to 110");

        //Numaric Field Validation
        jQuery.validator.addMethod("EformEnnumaricOnly", function (value, element) {
            return this.optional(element) || /^\d+$/.test(value);
        }, "Value should be numeric only");

        //Numaric Field Validation
        jQuery.validator.addMethod("EformEnnumaricOnly1", function (value, element) {
            return this.optional(element) || /^(\+91-|\+91|0)?\d{10}$/.test(value);
        }, "Value should be numeric only");

        //Year Validation
        jQuery.validator.addMethod("EformEnyearValidation", function (value, element) {
            return this.optional(element) || /(?:(?:19|20)[0-9]{2})/.test(value);
        }, "Year Should be between 1900 to 2099");

        //Alphabet with space Validation 
        jQuery.validator.addMethod("EformEnalphabetWithSpace", function (value, element) {
            return this.optional(element) || /^[A-Za-z\s]+$/.test(value);
        }, "Allows only Alphabet with space");

        //HindiAlphabetwithSpace Validation
        jQuery.validator.addMethod("EformEnhindiAlphabetwithSpace", function (value, element) {
            return this.optional(element) || /^[ँ-॰\s]+$/.test(value);
        }, "Allows only Hindi Alphabet with space");

        //Alphabet with space dot Validation 
        jQuery.validator.addMethod("EformEnalphabetWithSpaceDot", function (value, element) {
            return this.optional(element) || /^[A-Za-z.\s]+$/.test(value);
        }, "Allows only Alphabet with dot and space");



        //Pincode Field Validation
        jQuery.validator.addMethod("EformEnpincode", function (value, element) {
            return this.optional(element) || /^[1-9][0-9]{5}$/.test(value);
        }, "Enter a valid Pin Code");

        //Alphabet only Block Letters with space
        jQuery.validator.addMethod("EformEnblockLettersWithSpace", function (value, element) {
            return this.optional(element) || /^[A-Z\s]+$/.test(value);
        }, "Allows only Block Englsh Letters with space");

        //Numaric with slash Validation
        jQuery.validator.addMethod("EformEnnumaricWithSlash", function (value, element) {
            return this.optional(element) || /^[\d\/]+$/.test(value);
        }, "Allows only Numaric with slash");

        //englishDescription
        jQuery.validator.addMethod("EformEnDescription", function (value, element) {
            return this.optional(element) || /^[[A-Za-z 0-9_ \s \] \( \) \/ \. \- \@ \# \, \:\;]+$/.test(value);
        }, "Allows only English alphabet with some spacial character as space . , - @ # : ; () [] etc.");


        //in hours
        jQuery.validator.addMethod("number1", function (value, element) {
            return this.optional(element) || /^([1][0-9]|[0-9]|[2][0-4])([.][0-5][0-9])?$/.test(value);
        }, "Enter a valid Pin Code");


        //Number Only Validation
        jQuery.validator.addMethod("EformnumberOnly", function (value, element) {
            return this.optional(element) || /^[0-9]*$/.test(value);
        }, "Allows only numbers.");















        $(document).on('blur', 'input', function (event) {

            $(this).val($.trim($(this).val()));

        });

        getOtheruserProfileEform();
        function getOtheruserProfileEform() {
            //alert($('#emitraRegNo').val()+"OOOOOOOOOOOOOOOO"+$("#srvMasterId").val());
            if ($('#emitraRegNo').val() != "" && $('#emitraRegNo').val() != undefined && $('#emitraRegNo').val() != null) {
                otherUserEmitraRegId = $('#emitraRegNo').val();
                serviceId = $("#srvMasterId").val();
            }
            else if ($('#emitraRegNo').val() != "" && $('#emitraRegNo').val() != undefined && $('#emitraRegNo').val() != null) {
                otherUserEmitraRegId = $('#emitraRegNo').val();
                serviceId = $("#srvMasterId").val();


            }
            else {
                otherUserEmitraRegId = emitraRegNo;
                serviceId = serviceIdForCall;

            }



        }



        //Calender
















        $('#officeDatacopy').html($('#officeData').html());
        $('#officeData select').each(function (key, values) {
            $('#officeDatacopy select:eq(' + key + ')').val($(this).val());
        });




        setTimeout(delaydata, 5000);

        function delaydata() {

            $('#officeData').html('');


            var urldata = document.URL;
            var shortUrldata = urldata.substring(0, urldata.lastIndexOf("/"));



            var scriptsdata = [
             shortUrldata + '/resources/assets/js/eformjsp.js'


            ];

            var queue = scriptsdata.map(function (script) {
                return $.getScript(script);
            });

            $.when.apply(null, queue).done(function () {
                // Wait until done, then finish function
            });




        }


        /*IMage Upload ##################################################### */






        (function ($) {

            $.fn.base64img = function (options) {
                var settings = $.extend({
                    //list default here
                    result: '#result'
                }, options);

                if (typeof (settings.url) == 'undefined') {
                    console.error('Url parameter not exist.');
                    return;
                }

                var url = URL.createObjectURL(settings.url),
                    canvas = document.createElement('canvas'),
                    ctx = canvas.getContext("2d"),
                    img = new Image;

                var updateData = function (dataURL) {
                    $(settings.result).val(dataURL);
                }

                img.onload = function () {
                    canvas.height = img.height;
                    canvas.width = img.width;
                    ctx.drawImage(img, 0, 0);
                    var dataURL = canvas.toDataURL("image/jpeg");
                    updateData(dataURL);
                }

                img.src = url;
                return this;
            }
        }(jQuery));


        $('#userImageEform').on('change', function (e) {
            $(this).base64img({
                url: e.target.files[0],
                result: '#base64DataOfImage'
            });
        });





        $(document).on('click', '#uploadfileimge', function (e) {
            var uploadFile = $('#userImageEform').val();

            if (uploadFile == null || uploadFile == '') {

                bootbox.alert("कृपया फ़ोटो अपलोड करें!");
                return false;

            }

            var fileName = $('#userImageEform').val();


            /*var fileExtension = ['jpeg', 'jpg', 'png', 'gif', 'bmp','pdf','doc','docx'];*/
            var fileExtension = ['jpeg', 'jpg'];
            if ($.inArray(fileName.split('.').pop().toLowerCase(), fileExtension) == -1) {
                /*bootbox.alert("Only jpeg, jpg, png, gif, bmp, doc, docx formats are allowed.");*/
                bootbox.alert("Only jpeg,jpg Image formats are allowed.");
                $(this).val('');
            }
            else if (30000 < $('#userImageEform')[0].files[0].size) {
                bootbox.alert("Max File Size Allowed Is 30KB.");
            }
            else {


                var files = [];

                var oMyForm = new FormData();
                var otherUserEmitraRegId = $('#emitraRegNo').val();
                oMyForm.append("otherUserEmitraRegId",
                        otherUserEmitraRegId);

                var EmitraotherUserEmitraRegId = $('#emitraRegNo').val();
                oMyForm.append("EmitraotherUserEmitraRegId",
                        EmitraotherUserEmitraRegId);

                oMyForm.append('file', $('#userImageEform')[0].files[0]);
                oMyForm.append('fileNameOriginal', $('#userImageEform').val()
                        .replace(/C:\\fakepath\\/i, ''));




                $
                        .ajax({
                            url: 'genricFileUploadForEformPhoto',
                            headers: {
                                'allow-bypass-header': 'genricFileUploadForEformPhoto'
                            },
                            data: oMyForm,
                            dataType: 'text',
                            processData: false,
                            contentType: false,
                            type: 'POST',
                            success: function (data) {


                                console.log("data::" + data);
                                var obj = jQuery.parseJSON(data);
                                var url = document.URL;
                                var shortUrl = url.substring(0, url.lastIndexOf("/"));
                                shortUrl = shortUrl.substring(0, shortUrl.lastIndexOf("/"));



                                //	var EncImageshort = obj.newFileNameAvailEnclosurePath.substr(obj.newFileNameAvailEnclosurePath.lastIndexOf('/') + 1);

                                $('#userImageView').attr('src', shortUrl + obj.newFileNameAvailEnclosurePath);
                                $('#userImageEformValue').val(shortUrl + obj.newFileNameAvailEnclosurePath);


                            },
                            error: function (data) {

                            }
                        });


            }

        });


        /*End Of Image Upload ################################ */
        setTimeout(setSubcasteformTag, 8000);

        function setSubcasteformTag() {
            if (localStorage.getItem("subcasteformTag") != null) {
                var getId = localStorage.getItem("subcasteformTag");
                $('#subcasteform').val(getId);

                var subcasteformFather = localStorage.getItem("subcasteformFather");
                $('#subcasteformFather').val(subcasteformFather);


            }
        }
        //alert(localStorage.getItem("subcasteformTag"));
        if (localStorage.getItem("subcasteformTag") != null) {
            setTimeout(casteform, 6000);
        }
        function casteform() {

            getCasteListWithoutKey($('#casteform option:selected').attr('data-id'), "subcasteform");
            getCasteListWithoutKey($('#casteformFather option:selected').attr('data-id'), "subcasteformFather");

        }




        $('#casteform').on('change', function (e) {
            getCasteListWithoutKey($('option:selected', this).attr('data-id'), 'subcasteform');
        });


        $('#casteformFather').on('change', function (e) {
            getCasteListWithoutKey($('option:selected', this).attr('data-id'), 'subcasteformFather');
        });

        
        function getCasteListWithoutKey(categoryIdValue, casteId) {


            if (categoryIdValue != "") {
                $.ajax({
                    url: 'getCasteSetByCategory',
                    headers: {
                        'allow-bypass-header': 'getCasteSetByCategory'
                    },
                    type: 'POST',
                    data: {
                        categoryId: categoryIdValue
                    },
                    success: function (data) {
                        console.log(data);
                        var html = '<option value="">Select Caste</option>';
                        $.each(data, function (key, value) {
                            html += '<option>' + value
                                    + '</option>';
                        });

                        $('#' + casteId).html(html);

                    },
                    error: function (data) {

                    }
                });
            } else {
                var html = '<option value="">Select Caste</option>';
                $('#' + casteId).html(html);
                hideLoadingPopup();
            }
        }

        $(function () {
            $(".calender").datepicker({ maxDate: '0' });
        });

    </script>
    <script type="text/javascript" src="js/app-inner.js"></script>
</body>

</html>