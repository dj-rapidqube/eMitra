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
										<h1 class="">Department of Agriculture</h1>
										<span class="text-info">Application for subsidy on farm pond</span>
										<div id="content-1" class="content mCustomScrollbar">
											<form id="defaultForm" method="post"
												class="form-horizontal detailform">


                                                 <div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Aadhar Details</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Aadhaar(UID Or EID Number) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number " required id="aadharId" name="aadharId" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Address In Hindi">Bhamashah ID </label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnblockAlphanumaricWithoutSpace " required id="bhamshahId" name="bhamshahId" />
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
																	<label class="col-sm-5 control-label" for="name">Farmer Name </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" required id="FarmerName" name="FarmerName" data-msg="Please provide an accurate 'Farmer's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
        
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="Firm Name">Relation Type </label>

																	<div class="col-sm-8">
																		<select id="cast" name="cast" class="form-control col-sm-8 cal" required>
										                                   <option selected disabled>Select</option>
																		   <option>Father</option>
																		   <option>Husband</option>
																	
																		</select>
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="License No">Father/Husband Name </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" required id="Fathe_Hus_Name" name="Fathe_Hus_Name" data-msg="Please provide an accurate 'Father/Husband's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">Caste - Category </label>

																	<div class="col-sm-8">
																		<select id="cast" name="cast" class="form-control col-sm-8 eformclass" required data-msg="This field is required">
										                                   <option value="0">Select</option>
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


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="License No">Farmer Class </label>

																	<div class="col-sm-7">
																		<select id="FarmerClass" name="FarmerClass" class="form-control col-sm-8 eformclass" required>
											                                   <option selected disabled>Select</option>
																			  <option>Marginal</option>
																			  <option>Others</option>
																			  <option>Small</option>
																		
																			   </select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">E-mail </label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 email"  id="txt_Email_Service" name="txt_Email_Service" />
																    </div>
																</div>
																
																
																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="License No">Mobile Number </label>

																	<div class="col-sm-7">
																		<input type="text" id="Mobile" name="Mobile" class="form-control eformclass  RequiredField EformEnnumaricOnly1 col-sm-8" minlength="10" maxlength="13" placeholder="Enter Mobile Number" required data-msg="Please enter a correct 'Mobile No.' [For e.g.,  9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'."/>
																	</div>
																</div>

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
												
												
												
												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Permanent Address</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Address In English </label>

																	<div class="col-sm-7">
																		<textarea class="form-control wd65 englishDescription eformclass" id="permeEformAddressInEngtext" name="permeEformAddressInEngtext"  minlength="2" maxlength="300" readonly></textarea>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Address In Hindi </label>

																	<div class="col-sm-7">
																		<textarea class="form-control wd65 hindiDescription eformclass" id="permeEformAddressInHintext" name="permeEformAddressInHintext" placeholder="Address In Hindi" minlength="2" maxlength="300" readonly></textarea>  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Country</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformCountryIdtext" name="permeEformCountryIdtext" class="form-control wd65 eformclass" disabled="" /> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">State</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformStateIdtext" name="permeEformStateIdtext" class="form-control wd65 eformclass" disabled=""> 
																	</div>
																</div>
																
																
																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Division</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformDivisionIdtext" name="permeEformDivisionIdtext" class="form-control wd65 eformclass" disabled=""> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">District</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformDistrictIdtext" name="permeEformDistrictIdtext" class="form-control wd65 eformclass" disabled="" /> 
																	</div>
																</div>
																
																											<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Tehsil</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformTehsilIdtext" name="permeEformTehsilIdtext" class="form-control wd65 eformclass" disabled="" /> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Municipality</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformMunicipalityIdtext" name="permeEformMunicipalityIdtext" class="form-control wd65 eformclass" disabled="" /> 
																	</div>
																</div>
																
																											<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Ward</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformWardIdtext" name="permeEformWardIdtext" class="form-control wd65 eformclass" disabled="" /> 
																	</div>
																</div>
																
																
															 <div class="permeEformVillageMstrMap hide-service"
																	style="display: none;">	
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Panchayat Samity</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformPanchayatSamityIdtext" name="permeEformPanchayatSamityIdtext" class="form-control col-sm-8 eformclass" /> 
																	</div>
																</div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Gram Panchayat</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformGramPanchayatIdtext" name="permeEformGramPanchayatIdtext" class="form-control col-sm-8 eformclass" /> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Village</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformVillageIdtext" name="permeEformVillageIdtext" class="form-control wd65 eformclass" /> 
																	</div>
																</div>
															</div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Pin Code</label>

																	<div class="col-sm-7">
																		<input type="number" class="form-control wd65 eformclass " id="permeEformAddPinCodetext" name="permeEformAddPinCodetext" maxlength="6" minlength="6" placeholder="Pin Code" value="" readonly> 
																	</div>
																</div>
																

															</div>
														</div>
													</div>

												</div>
												
												
												
											    <div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Farmer Land Description (in Hectares)</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Irrigated (in Hectares) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-12 number Irrigated" required id="LandonApplicantNameHectaresIrrigated" name="LandonApplicantNameHectaresIrrigated" data-msg="Please enter value in 'Irrigated (in Hectares)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Non-irrigated (in Hectares) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-12 number Irrigated" required id="LandonApplicantNameHectaresNonIrrigated" name="LandonApplicantNameHectaresNonIrrigated" data-msg="Please enter value in 'Non-Irrigated (in Hectares)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted."/>  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Total Land (in Hectares) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass  col-sm-12 EformEnblockAlphanumaricWithDash" required id="TotalLandHectares" name="TotalLandHectares" /> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Khasra number (in which farm pond is proposed) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass  col-sm-12 EformEnblockAlphanumaricWithSpace" required id="Khasranumber" name="Khasranumber" data-msg="Please Provide correct Khasra Number. It allows only alphanumaric with space and comma." /> 
																	</div>
																</div>
																
																
																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Source of Irrigation </label>

																	<div class="col-sm-7">
																		<select id="mst_ddlIrrigation_serv" class="select col-sm-12" name="mst_ddlIrrigation_serv" data-msg="This field is required">
																		<option selected disabled>Select</option>
																		<option value="2">Tube well</option>
																		<option value="1">Well</option>
																		<option value="3">Others</option>
																		</select> 
																	</div>
																</div>
																

															</div>
														</div>
													</div>

												</div>
												
												
												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Size of farm pond(Length X Breadth X Depth)</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Length (in meter) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number" required id="LengthFarm" name="LengthFarm" data-msg="Please enter value in 'Length (in meter)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Breadth (in meter) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number " required id="BreadthNumber" name="BreadthNumber" data-msg="Please enter value in 'Breadth (in meter)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted."/>  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Depth (in meter) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number" required id="KilaNumber" name="KilaNumber" data-msg="Please enter value in 'Depth (in meter)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." /> 
																	</div>
																</div>

															</div>
														</div>
													</div>

												</div>
												
												
												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Boundary map of field (showing well/tubewell and farmpond position) </h4>
                                                            <p>Note* :- Please give full boundry map details(Boundry Map include all directions as North, South, East, West)</p>
														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">
                                                                   
                                                                <div class="col-md-12 form-group required">
																		<table class="table table-hover table-bordered">
																			<thead>
																			<tr>
																			<th><label class="control-label col-sm-4">Boundry</label></th>
																			<th><label class="control-label col-sm-4">Landholder's Name</label></th>
																			<th><label class="control-label col-sm-4">Relation</label></th>
																			<th><label class="control-label col-sm-4">Father/Husband's Name/Other/Reason</label></th>
											                                <th>Action</th>
																			</tr>
																			</thead>
																			<tbody id="possessionTableAdd2">
																			<tr>
																			<th><select id ="Boundry1" name="Boundry1" class="form-control col-sm-12 " required>
											                                   <option selected disabled>Select</option>
																			  <option>East</option>
											                                  <option>North</option>
																			  <option>West</option>
											                                  <option>South</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="LandholderName1" id="LandholderName1" data-msg="Please provide an accurate 'Landholder's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." required></th>
																			<th><select id ="fert" name="fert" class="form-control col-sm-12 " required>
											                                   <option selected disabled>Select</option>
																			  <option>Father</option>
											                                  <option>Husband</option>
																			  <option>Other</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="South" data-msg="Please provide an accurate 'Father/Husband's Name/Other/Reason'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." required></th>
																			<th></th>								
																			</tr>
																			
																			
																			
																			<tr>
																			<th><select id ="fertilizer" name="fertilizer" class="form-control col-sm-12 " required>
											                                   <option selected disabled>Select</option>
																			  <option>East</option>
											                                  <option>North</option>
																			  <option>West</option>
											                                  <option>South</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="West" data-msg="Please provide an accurate 'Landholder's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." required></th>
																			<th><select id ="fert" name="fert" class="form-control col-sm-12 " required>
											                                   <option selected disabled>Select</option>
																			  <option>Father</option>
											                                  <option>Husband</option>
																			  <option>Other</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="South" data-msg="Please provide an accurate 'Father/Husband's Name/Other/Reason'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." required></th>
																			<th></th>								
																			</tr>
																			
																			
																			
																			<tr>
																			<th><select id ="fertilizer" name="fertilizer" class="form-control col-sm-12 ">
											                                   <option selected disabled>Select</option>
																			  <option>East</option>
											                                  <option>North</option>
																			  <option>West</option>
											                                  <option>South</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="West" data-msg="Please provide an accurate 'Landholder's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																			<th><select id ="fert" name="fert" class="form-control col-sm-12 ">
											                                   <option selected disabled>Select</option>
																			  <option>Father</option>
											                                  <option>Husband</option>
																			  <option>Other</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="South" data-msg="Please provide an accurate 'Father/Husband's Name/Other/Reason'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																			<th></th>								
																			</tr>
																			
																			
																			
																			<tr>
																			<th><select id="fertilizer" name="fertilizer" class="form-control col-sm-12 ">
											                                   <option selected disabled>Select</option>
																			  <option>East</option>
											                                  <option>North</option>
																			  <option>West</option>
											                                  <option>South</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="West" data-msg="Please provide an accurate 'Landholder's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																			<th><select id ="fert" name="fert" class="form-control col-sm-12 ">
											                                   <option selected disabled>Select</option>
																			  <option>Father</option>
											                                  <option>Husband</option>
																			  <option>Other</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="South" data-msg="Please provide an accurate 'Father/Husband's Name/Other/Reason'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																			<th></th>								
																			</tr>
																			
																			
																			<tr>
																			<th><select id="fertilizer" name="fertilizer" class="form-control col-sm-12 ">
											                                   <option selected disabled>Select</option>
																			  <option>East</option>
											                                  <option>North</option>
																			  <option>West</option>
											                                  <option>South</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="West" data-msg="Please provide an accurate 'Landholder's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																			<th><select id ="fert" name="fert" class="form-control col-sm-12 ">
											                                   <option selected disabled>Select</option>
																			  <option>Father</option>
											                                  <option>Husband</option>
																			  <option>Other</option></select></th>
																			<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="South" data-msg="Please provide an accurate 'Father/Husband's Name/Other/Reason'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."></th>
																			<th></th>								
																			</tr>
																			
																			
																			
																			
																			</tbody>
								
								                                       </table>
					                                            </div>
					                                             
					                                            <div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">I have not availed subsidy in previous years </label>

																	<div class="col-sm-7">
																		<select id="subsidy" name="subsidy" class="form-control eformclass" required  >
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
												
												
												
												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Bank Details</h4>
														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Name of Bank </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpace" required id="Name_of_Bank" name="Name_of_Bank" data-msg="Please enter accurate 'Bank Name'. Only alphabets and spaces are allowed [For e.g., Suvarthi Das or Kolkata]. Numbers and special characters are not being accepted." />
																		</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Name of Bank Branch </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpace " required id="Name_of _Bank_Branch" name="Name_of _Bank_Branch" data-msg="Please enter accurate 'Name of Account holder'. Only alphabets and spaces are allowed [For e.g., Suvarthi Das or Kolkata]. Numbers and special characters are not being accepted."/>  
																	</div>
																</div>
                                                                
					                                             <div class="clearfix"></div>
					                                             
					                                             <div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">IFSC Code </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnblockAlphanumaricWithoutSpace" required id="IFSC_Code" name="IFSC_Code" />
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Account Number </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number" required id="Account_Number" name="Account_Number" data-msg="'Account Number' must be an integer." />
																	</div>
																</div>
																
															</div>
														</div>
													</div>

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

	<script type="text/javascript" src="js/app-inner.js"></script>

	<script src="js/dist/jquery.validate.js"></script>

</body>

</html>