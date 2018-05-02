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
										<span class="text-info"> Application for Sale Permission (Source of Authentication)</span>
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

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Licensing Authority</label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnblockSpacialCharacters" required id="license" name="license" data-msg="Please provide correct Licensing Authority'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."/> 
																	</div>
																</div>
																

															</div>
														</div>
													</div>

												</div>



												<div class="col-md-12">

													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Applicant Name and full address</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Applicant Name </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" required id="applicant" name="applicant" data-msg="Please enter accurate 'Applicant name'. Only alphabets and spaces are allowed [For e.g., Suvarthi Das or Kolkata]. Numbers and special characters are not being accepted."/>
        
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="Firm Name">Applicant Address </label>

																	<div class="col-sm-8">
																		<textarea style="height:35px;" required id="address"  name="address" class="form-control eformclass EformEnblockSpacialCharacters col-sm-8 " data-msg="Please provide correct Applicant Address. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."></textarea>
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="License No">Mobile No. </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnnumaricOnly1" minlength="10" maxlength="13" required id="mobile1" name="mobile1" data-msg="Please enter a correct 'Mobile No.' [For e.g., 9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">Telephone </label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnnumaricOnly1" minlength="10" maxlength="13" id="telephone" name="telephone" data-msg="Please enter a correct 'Telephone No.' [For e.g., 9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'."/>
																    </div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="Mobile No">E-mail </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass email" id="email" name="email" data-msg="Please enter a proper 'E-mail' : For e.g., kavita.krishna12@gmail.com"/>
								                                </div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="MobileNumber">Is the applicant new comer? </label>

																	<div class="col-sm-8">
																		<select id="newcomer" name="newcomer" class="form-control col-sm-8 " required>
																			<option selected disabled>Select</option>
																			<option>Yes</option>
																			<option>No</option>
																		</select>
																	</div>
																</div>
																

																<div class="widget-main">
																<div class="col-md-6 form-group required">
																	<table class="table table-striped">
																	<thead>
																	<tr>
																	<th><label class="control-label">Name Of The Principals</label></th>
																
																	</tr>
																	</thead>
															
																	<tbody id="possessionTableAdd">
																	
																	<tr>
																	<td><input type="text" class="form-control col-sm-8 " data-msg="Please provide an accurate Name Of The Principals. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Principals0" id="Principals0" required/></td>
																	</tr>
											                        
											                        <tr>
																	<td><input type="text" class="form-control col-sm-8 " data-msg="Please provide an accurate Name Of The Principals. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Principals1" id="Principals1" /></td>
																	</tr>
											                        
											                        <tr>
																	<td><input type="text" class="form-control col-sm-8 " data-msg="Please provide an accurate Name Of The Principals. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Principals2" id="Principals2" /></td>
																	</tr>
											                        
											                        <tr>
																	<td><input type="text" class="form-control col-sm-8 " data-msg="Please provide an accurate Name Of The Principals. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Principals3" id="Principals3" /></td>
																	</tr>
											                        
											                        <tr>
																	<td><input type="text" class="form-control col-sm-8 " data-msg="Please provide an accurate Name Of The Principals. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Principals4" id="Principals4" /></td>
																	</tr>
											                        
											                        <tr>
																	<td><input type="text" class="form-control col-sm-8 " data-msg="Please provide an accurate Name Of The Principals. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Principals5" id="Principals5" /></td>
																	</tr>
																	</tbody>								
																	</table>
					                                                
					                                             </div>
					                                             
					                                             <div class="col-md-6 form-group required">
					                                             <table class="table table-hover table-bordered">
																	<thead>
																	<tr>
																	<th><label class="control-label">Name Of The Insecticide</label></th>
																	
																	</tr>
																	</thead>
															
																	<tbody id="possessionTableAdd1">
																	<tr>
																	<td><input type="text" class="form-control col-sm-12 EformEnalphabetWithSpaceDot" data-msg="Please provide an accurate Name Of The Insecticide. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Insecticides1" name="Insecticides1" required/></td>
																	</tr>
											                        
											                        <tr>
																	<td><input type="text" class="form-control col-sm-12 EformEnalphabetWithSpaceDot" data-msg="Please provide an accurate Name Of The Insecticide. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Insecticides2" name="Insecticides2" /></td>
																	</tr>
											                        
											                          <tr>
																	<td><input type="text" class="form-control col-sm-12 EformEnalphabetWithSpaceDot" data-msg="Please provide an accurate Name Of The Insecticide. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Insecticides3" name="Insecticides3" /></td>
																	</tr>
											                        
											                         <tr>
																	<td><input type="text" class="form-control col-sm-12 EformEnalphabetWithSpaceDot" data-msg="Please provide an accurate Name Of The Insecticide. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Insecticides4" name="Insecticides4" /></td>
																	</tr>
											                        
											                         <tr>
																	<td><input type="text" class="form-control col-sm-12 EformEnalphabetWithSpaceDot" data-msg="Please provide an accurate Name Of The Insecticide. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." name="Insecticides5" name="Insecticides5" /></td>
																	</tr>
																	</tbody>								
																	</table>
					                                             
																</div>

															</div>
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
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Address In English</label>

																	<div class="col-sm-7">
																		<textarea class="form-control wd65 englishDescription eformclass" id="permeEformAddressInEngtext" name="permeEformAddressInEngtext"  minlength="2" maxlength="300" readonly></textarea>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Address In Hindi">Address In Hindi </label>

																	<div class="col-sm-8">
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
																	<label class="col-sm-4 control-label" for="State">State
																	</label>

																	<div class="col-sm-8">
																		<input type="text" id="permeEformStateIdtext" name="permeEformStateIdtext" class="form-control wd65 eformclass" disabled="">
																	</div>
																</div>

																<div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Division">Division</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformDivisionIdtext" name="permeEformDivisionIdtext" class="form-control wd65 eformclass" disabled=""> 
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">District
																	</label>

																	<div class="col-sm-8">
																		<input type="text" id="permeEformDistrictIdtext" name="permeEformDistrictIdtext" class="form-control wd65 eformclass" disabled="" />
																	</div>
																</div>

																<div class="clearfix"></div>
																
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Tehsil">Tehsil</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformTehsilIdtext" name="permeEformTehsilIdtext" class="form-control wd65 eformclass" disabled="" /> 
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Municipality
																	</label>

																	<div class="col-sm-8">
																		<input type="text" id="permeEformMunicipalityIdtext" name="permeEformMunicipalityIdtext" class="form-control wd65 eformclass" disabled="" />
																	</div>
																</div>

																<div class="clearfix"></div>
																
																
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Ward </label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformWardIdtext" name="permeEformWardIdtext" class="form-control wd65 eformclass" disabled="" /> 
																	</div>
																</div>

                                                            <div class="permeEformVillageMstrMap hide-service"
																	style="display: none;">

																<div class="form-group col-md-6 required hide-service">
																		<label class="col-sm-4 control-label"
																			for="Panchayat Samity">Panchayat Samity </label>

																		<div class="col-sm-8">
																			<input type="text" id="permeEformPanchayatSamityIdtext" name="permeEformPanchayatSamityIdtext" class="form-control col-sm-8 eformclass" /> 
																		</div>
																</div>


																<div class="form-group col-md-6 required">
																		<label class="col-sm-5 control-label" for="Ward">Gram Panchayat </label>

																		<div class="col-sm-7">
																			<input type="text" id="permeEformGramPanchayatIdtext" name="permeEformGramPanchayatIdtext" class="form-control col-sm-8 eformclass" /> 

																		</div>
																</div>

																<div class="form-group col-md-6 required"
																			aria-required="true">

																			<label class="col-sm-4 control-label" for="Village">Village
																			</label>

																			<div class="col-sm-8">
																				<input type="text" id="permeEformVillageIdtext" name="permeEformVillageIdtext" class="form-control wd65 eformclass" />
																			</div>
																</div>
                                                            </div>
														
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Pin Code </label>

																	<div class="col-sm-8">
																		<input type="number" class="form-control wd65 eformclass " id="permeEformAddPinCodetext" name="permeEformAddPinCodetext" maxlength="6" minlength="6" placeholder="Pin Code" value="" readonly> 
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
															<h4 class="widget-title">Full Particulars of Licenses issued in his name by other State Governments</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Name Of Firm </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnblockSpacialCharacters" required id="firmname" name="firmname" data-msg="Please enter accurate 'Firm name'.Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Address In Hindi">Manufacture License No </label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnblockSpacialCharacters" required id="manufactureno" name="manufactureno" data-msg="Please enter accurate 'Manufacture License No'.Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."/>  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Valid Up To</label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass calender" required id="validupto" name="validupto"/> 
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