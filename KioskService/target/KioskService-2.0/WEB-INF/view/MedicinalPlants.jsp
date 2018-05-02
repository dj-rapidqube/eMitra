<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Horticulture Department</title>
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
										<h1 class="">Horticulture Department</h1>
										<span class="text-info">Application for Assistance under 
										National Mission for Medicinal Plants</span>
										<div id="content-1" class="content mCustomScrollbar">
											<form id="defaultForm" method="post"
												class="form-horizontal detailform">


												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-body">
															<div class="widget-main">
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">UID </label>

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
															
															<div class="clearfix"></div>

																<!--  <div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="FatherHusbandName">Father/Husband Name </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control  eformclass EformEnalphabetWithSpaceDot"
																			required id="Fathe_Hus_Name" name="Fathe_Hus_Name"
																			data-msg="Please provide an accurate 'Father/Husband's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>-->
															<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="RelationType">Organization Type</label>

																	<div class="col-sm-7">
																		<select id="Organization_Type" name="Organization_Type"
																			class="form-control  cal" required>
																			<option selected disabled>Select</option>
																			<option>Community(Farmer Group)</option>
																			<option>Individual Farmer</option>
																			<option>Private(Registered Society)</option>
																			<option>Public Government</option>

																		</select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="FatherHusbandName">Name of Farmer/Applicant </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control  eformclass EformEnalphabetWithSpaceDot"
																			required id="Fathe_Hus_Name" name="Fathe_Hus_Name"
																			data-msg="Please provide an accurate 'Father/Husband's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="RelationType">Relation Type </label>

																	<div class="col-sm-7">
																		<select id="RelationType" name="RelationType"
																			class="form-control  cal" required>
																			<option selected disabled>Select</option>
																			<option>Father</option>
																			<option>Husband</option>

																		</select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="RelationType">Gender </label>

																	<div class="col-sm-8">
																		<select id="RelationType" name="RelationType"
																			class="form-control  cal" required>
																			<option selected disabled>Select</option>
																			<option>Male</option>
																			<option>Female</option>
																			<option>others</option>

																		</select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="CasteCategory">Caste - Category </label>

																	<div class="col-sm-7">
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
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="RelationType">Farmer's Class </label>

																	<div class="col-sm-8">
																		<select id="RelationType" name="RelationType"
																			class="form-control  cal" required>
																			<option selected disabled>Select</option>
																			<option>Maginals</option>
																			<option>Small</option>
																			<option>others</option>

																		</select>
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="RelationType">Father/Husband Name </label>

																	<div class="col-sm-7">
																		<select id="cast2" name="cast2" class="form-control col-sm-8 eformclass" required>
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
<!--  


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Name of
																	 Beneficiary </label>

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

																-->

																<div class="clearfix"></div>

															</div>
														</div>
													</div>
												</div>



												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Permanent Address</h4>

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
															<h4 class="widget-title">Other Details</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">
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
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="RelationType">Name of activity/programme</label>

																	<div class="col-sm-7">
																		<select id="Name_of_Component/Activity" name="Name_of_Component/Activity"
																			class="form-control  cal" required>
																			<option selected disabled>Select</option>
																			<option>Nurseries</option>
																			<option>Cultivation of Medicinal Plants</option>
																			

																		</select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="name">Name of crop </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass EformEnalphabetWithSpaceDot"
																			required id="Name_of_Crop" name="Name_of_Crop"
																			data-msg="Please provide Name of Crop" />
																	</div>
																</div>
																<div class="clearfix"></div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="RelationType">Nurseries </label>

																	<div class="col-sm-7">
																		<select id="Name_of_Component/Activity" name="Name_of_Component/Activity"
																			class="form-control  cal" required>
																			<option selected disabled>Select</option>
																			
																			
																		</select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="irrigated">Khasra / Murabba Number on which 
																	Programme/Activity is applied</label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass  number Irrigated"
																			required id="LandonApplicantNameHectaresIrrigated"
																			name="LandonApplicantNameHectaresIrrigated"
																			data-msg="Please enter value Khasra / Murabba Number on which Programme/Activity is applied" />
																	</div>
																</div>
																<div class="clearfix"></div>

																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="sourceofirr">Source of Irrigation </label>

																	<div class="col-sm-7">
																		<select id="mst_ddlIrrigation_serv"
																			class="select form-control"
																			name="mst_ddlIrrigation_serv" required>
																			<option selected disabled>Select</option>
																			<option value="2">Tube well</option>
																			<option value="1">Well</option>
																			<option value="3">Canol</option>
																			<option value="4">Farmpond</option>
																		</select>
																	</div>
																</div>
																<!--  <div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Area or number for which Program/Activity 
																	is applied(Hectares in Case of Area) </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass EformEnalphabetWithSpaceDot"
																			required id="Area_program" name="Area_program"
																			data-msg="Please enter value in 'Irrigated (in Hectares)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." />
																	</div>
																</div>-->
																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="sourceofirr">Means of irrigation</label>

																	<div class="col-sm-7">
																		<select id="mst_ddlIrrigation_serv"
																			class="select form-control"
																			name="mst_ddlIrrigation_serv" required>
																			<option selected disabled>Select</option>
																			<option value="2">Diesel Engine</option>
																			<option value="1">Motor horsepwer</option>
																			
																		</select>
																	</div>
																</div>
																<div class="clearfix"></div>

																
																<!--  <div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="irrigated">Land Holding
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
																	<label class="col-sm-4 control-label" for="name">Khasra number in which MI Set is to be installed </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass EformEnalphabetWithSpaceDot"
																			required id="FarmerName" name="FarmerName"
																			data-msg="Please provide an accurate 'Farmer's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Irrigation Source (proof attached)</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass EformEnalphabetWithSpaceDot"
																			required id="FarmerName" name="FarmerName"
																			data-msg="Please provide an accurate 'Farmer's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="name">Agriculture Electricity Connection Bill</label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass EformEnalphabetWithSpaceDot"
																			required id="FarmerName" name="FarmerName"
																			data-msg="Please provide an accurate 'Farmer's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Water Table(Meters.)</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass EformEnalphabetWithSpaceDot"
																			required id="FarmerName" name="FarmerName"
																			data-msg="Please provide an accurate 'Farmer's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																
-->
																<div class="clearfix"></div>

															</div>
														</div>
													</div>
												</div>
												
												
												<div class="col-md-12">

													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Crop's Name/Area </h4>

														</div>


														<div class="widget-body">


																<div class="widget-main">
																<div class="col-md-12 form-group required">
																	<table class="table table-hover table-bordered">
								<thead>
								<tr>
								<th>Name of Crop</th>
								<th>Area (Hectares/Acres)</th>
								<th>Action</th>
								</tr>
								</thead>
								<tbody id="possessionTableAdd2">
								<tr>
								<td><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="NameofCrop1" name="NameofCrop1" data-msg="Please provide correct Name of Crop" required></td>
								
								<td><input type="text" class="form-control col-sm-12 eformclass" name="AreaHectares1" name="AreaHectares1"  required></td>
								
								  
								
                            
							<td></td>								
								</tr>
								
								
								</tbody>
								
								
																
								</table>
								
								
					                                             </div>
					                                             
																
																	<div class="col-sm-7 pull-left">
																		<button type="button" id="pAdd3" class="btn btn-default"><i class="fa fa-plus" aria-required="true"></i>Add More</button>
																	</div>
					                                             

														</div>
													</div>
												</div>
												</div>
                                                


		<div class="col-md-12">

													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Cost of Project(in rupees) </h4>

														</div>


														<div class="widget-body">


																<div class="widget-main">
																<div class="col-md-12 form-group required">
									 <table class="table table-hover table-bordered">
								
							
								<tr><th>1.</th>   <td>Cost of Seeds/Plants</td>    <td>
								
								<select id="mst_ddlSeedPlant_Service" class="form-control col-sm-12 eformclass required" required name="mst_ddlSeedPlant_Service"><option selected disabled>Select</option><option value="3">Plants</option><option value="1">Seed</option></select></td> </tr>
								
								<tr><th></th>   <td>Cost (Rs.) </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="CostRs " name="CostRs"  required></td> </tr>
								
								
								<tr><th>2.</th>   <td>Cost of Manures (Rs.) </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="CostoManures " name="CostoManures"  required></td> </tr>
								
								<tr><th>3.</th>   <td>Cost of Fertilizers (Rs.)  </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="CostoFertilizers " name="CostoFertilizers"  required></td> </tr>
								
								<tr><th>4.</th>   <td>Cost of Plant Protection Chemical (Rs.)   </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="PlantProtection " name="CostoFertilizers"  required></td> </tr>
								
									<tr><th>5.</th>   <td>Cost of Plant Bio-pesticide (Rs.) </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="Costopesticide " name="Costopesticide"  required></td> </tr>
									
									<tr><th>6.</th>   <td> Cost of Irrigation Equipment (Rs.) </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="CostoIrrigation " name="CostoIrrigation"  required></td> </tr>
									
									<tr><th>7.</th>   <td> Cost of Labor (Rs.)  </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="CostoLabor " name="CostoLabor"  required></td> </tr>
									
									<tr><th>8.</th>   <td> Cost of Land preparation (Rs.)  </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="Costopreparation " name="Costopreparation"  required></td> </tr>
									
									<tr><th>9.</th>   <td> Other Costs (Rs.)   </td>    <td><input type="number" class="form-control col-sm-12 eformclass autoaddclass" name="Costsother " name="Costsother"  required></td> </tr>
									
									<tr><th></th>   <td> Total Cost (Rs.)    </td>    <td><input disabled type="number" class="form-control col-sm-12 eformclass" name="totalcostland" id="totalcostland"  required></td> </tr>
								
								
									 </table>
                                   
								
					                                             </div>
					                                             

														</div>
													</div>
												</div>
												</div>
                                                
												
												
												
												
<!--  
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
-->
											<!--  	<div class="col-md-12">
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

-->
												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Beneficiary's bank account details</h4>
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
																	<label class="col-sm-4 control-label" for="irrigated">Name Of Acoount Holder</label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot"
																			required id="Name_of_Bank" name="Name_of_Bank"
																			data-msg="Please provide an accurate 'Bank Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="nonirrigated">RTGS-ECS Code </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot "
																			required id="RTGS-ECS_Code"
																			name="RTGS-ECS_Code"
																			data-msg="Please provide an accurate DD.Number" />
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
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="MobileNumber">Telephone Number of the Bank </label>

																	<div class="col-sm-7">
																		<input type="text" id="Mobile" name="Mobile"
																			class="form-control eformclass EformEnnumaricOnly1"
																			minlength="10" maxlength="13"
																			placeholder="Enter Mobile Number"
																			data-msg="Please enter a correct 'Mobile No.' [For e.g., 9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'."
																			required />
																	</div>
																</div>
																<div class="col-md-12">
													<div class="widget-box">


														<div class="widget-body">
															<div class="widget-main">
																<div class="form-group col-md-12">
																	<div class="col-sm-12">
																		<div class="checkbox">
																			<label> <input name="agreeterm"
																				id="agreeterm" type="checkbox"
																				data-msg="यह फ़ील्ड आवश्यक है"> This field
																				is required

																			</label>
																		</div>
																	</div>
																</div>

																<div class="form-group col-md-12">
																	<span class="text-success">The information provided by me is true to the best of my knowledge.</span> <span class="clearfix"></span> <span
																		class="text-success">As per policy, I will use the subsidy myself and will not misuse it.I hereby further state that, i have not received any subsidy from any organisation or scheme associated with this program. </span> <span class="clearfix"></span> <span
																		class="text-success">The License is enclosed
																		herewith . </span>
																</div>

															</div>
														</div>
													</div>

												</div>
																
																<!--     <div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="irrigated">Firm name for selected Plants installation</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot"
																			required id="Name_of_Bank" name="Name_of_Bank"
																			data-msg="Please provide an accurate 'Bank Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>-->
																<!--  <div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="tl">IFSC
																		Code </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters"
																			required id="IFSC_Code" name="IFSC_Code"
																			maxlength="15" />
																	</div>
																</div>-->
																

															<!--  	<div class="clearfix"></div>

																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="sourceofirr">Water resources on which solar power plant is to pump-based</label>

																	<div class="col-sm-7">
																		<select id="mst_ddlIrrigation_serv"
																			class="select form-control"
																			name="mst_ddlIrrigation_serv" required>
																			<option selected disabled>Select</option>
																			<option value="2">Tube well</option>
																			<option value="1">Well</option>
																			<option value="3">Surface Water Plant</option>
																		</select>
																	</div>
																</div>
																<div class="form-group col-md-6">
																	<label class="col-sm-4 control-label eformclass"
																		for="sourceofirr">Mounting Frame Type</label>

																	<div class="col-sm-8">
																		<select id="mst_ddlIrrigation_serv"
																			class="select form-control"
																			name="mst_ddlIrrigation_serv" required>
																			<option selected disabled>Select</option>
																			<option value="2">Auto Tracker</option>
																			<option value="1">Mannual Tracker</option>
																			
																		</select>
																	</div>
																</div>
																<div class="clearfix"></div>
																    <div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="irrigated">Depth (in meter)</label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters"
																			required id="IFSC_Code" name="IFSC_Code"
																			maxlength="15" />
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="khasrano">Amount </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass col-sm-8 EformEnnumaricOnly"
																			required id="Account_Number" name="Account_Number"
																			maxlength="7"
																			data-msg="'Account Number' must be an integer." />
																	</div>
																</div>
																

																<div class="clearfix"></div>-->

															</div>
														</div>
													</div>

												</div>

												<!-- <div class="twobtn">
													<button type="submit"
														class="btn btn-default getone griefrom" name="signup"
														value="Sign up">Submit</button>
													<button class="btn btn-default btn-raised getone"
														type="reset">RESET</button>
												</div> -->
											</form>
										</div>
									</div>
								</div>


							</div>
							<div class="button_div">
								<a href="horticultureDeptList" class="panel"> <img
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

	<script type="text/javascript" src="js/app-inner.js"></script>
	
	<script src="js/dist/jquery.validate.js"></script>

</body>

</html>