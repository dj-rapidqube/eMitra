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
										<h1 class="">Agriculture Department</h1>
										<h4>Form (IV)</h4>
										<h5>(See Rule 9(1))</h5>
										<span class="text-info"> "Application for Renewal of
											License to manufacture Insecticides"</span>
										<div id="content-1" class="content mCustomScrollbar">
											<form id="defaultForm" method="post"
												class="form-horizontal detailform">


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
															<h4 class="widget-title">Applicant Details</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Applicant
																		Name </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass EformEnalphabetWithSpaceDot"
																			required id="NameofApplicant" name="NameofApplicant"
																			data-msg="Please provide an accurate 'Applicant name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="Firm Name">Firm Name </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control eformclass EformEnblockSpacialCharacters"
																			required id="NameOfTheConcern"
																			name="NameOfTheConcern"
																			data-msg="Please provide correct 'Firm name'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash" />
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="License No">License No. </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control col-sm-8 eformclass EformEnblockSpacialCharacters"
																			required id="License_no" name="License_no"
																			data-msg="Please provide correct 'License No.'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">Date of License issued </label>

																	<div class="col-sm-8">
																		<input type="date"
																			class="form-control eformclass calender date"
																			required id="NameOfTheConcern1"
																			name="NameOfTheConcern1"
																			data-msg="Please enter correct 'Date of License issued'. It should be in DD/MM/YYYY format.[For e.g., 01/01/1940]" />
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="Mobile No">Mobile No </label>

																	<div class="col-sm-7">
																		<input type="text"
																			class="form-control eformclass EformEnnumaricOnly1"
																			required id="MobileNo" name="MobileNo" maxlength="13"
																			minlength="11"
																			data-msg="Please enter a correct 'Mobile No.' [For e.g.,  9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded." />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="MobileNumber">Telephone </label>

																	<div class="col-sm-8">
																		<input type="text"
																			class="form-control col-sm-8 eformclass EformEnnumaricOnly1"
																			id="Telephone" name="Telephone" maxlength="11"
																			minlength="10"
																			data-msg="Please enter a correct 'Telephone' [For e.g.,  9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'." />
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
															<div class="widget-main" id="textaddeform">

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
																	<span class="text-success">The other details
																		regarding the manufacture of the insecticide continue
																		to remail the same</span> <span class="clearfix"></span> <span
																		class="text-success">Particulars of fee
																		deposited. </span> <span class="clearfix"></span> <span
																		class="text-success">The License is enclosed
																		herewith . </span>
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