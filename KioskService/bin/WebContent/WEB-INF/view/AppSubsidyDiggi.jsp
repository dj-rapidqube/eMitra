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
										<span class="text-info">Application for subsidy on diggi</span>
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
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" required id="FarmerName" name="FarmerName" data-msg="Please provide an accurate 'Farmer’s Name'" />
        
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
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" required id="fathersNameEform" name="fathersNameEform" data-msg="Please provide an accurate 'Father/Husband's Name'"/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">Caste - Category </label>

																	<div class="col-sm-8">
																		<select id="casteform" name="casteform"  class="form-control col-sm-8 eformclass" required>
										                                   <option selected disabled>Select</option>
																		   <option>OBC</option>
																		   <option>SBC</option>
																		   <option>SC</option>
																		   <option>ST</option>
																		   <option>General</option>
																		   <option>Minority</option>
																		   <option>Others</option>
																		   </select>
																    </div>
																</div>
																
																
																									<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="License No">E-mail </label>

																	<div class="col-sm-7">
																		<input type="email" class="form-control col-sm-8 email" id="txt_Email_Service" name="txt_Email_Service" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">Mobile Number </label>

																	<div class="col-sm-8">
																		<input type="text" id="Mobile" name="Mobile" class="form-control eformclass  RequiredField EformEnnumaricOnly1 col-sm-8" minlength="10" maxlength="13" placeholder="Enter Mobile Number"  data-msg="Please enter a correct 'Mobile No'." required />
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
																		<textarea class="form-control wd65 englishDescription eformclass" id="permeEformeEformAddressInEng" name="permeEformAddressInEng"  minlength="2" maxlength="300" readonly></textarea>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Address In Hindi </label>

																	<div class="col-sm-7">
																		<textarea class="form-control wd65 hindiDescription eformclass" id="permeEformAddressInHin" name="permeEformAddressInHin" placeholder="Address In Hindi" minlength="2" maxlength="300" readonly></textarea>  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Country</label>

																	<div class="col-sm-7">
																		<select id="permeEformCountryId" name="permeEformCountryId" class="form-control wd65 eformclass" disabled="">
															
															</select> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">State</label>

																	<div class="col-sm-7">
																		<select id="permeEformStateId" name="permeEformStateId" class="form-control wd65 eformclass" disabled="">
															<option value="">-State-</option>
															
													</select>
																	</div>
																</div>
																
																
																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Division</label>

																	<div class="col-sm-7">
																		<select id="permeEformDivisionId" name="permeEformDivisionId" class="form-control wd65 eformclass" disabled="">
															<option value="">-Division-</option>
															</select> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">District</label>

																	<div class="col-sm-7">
																		<select id="permeEformDistrictId" name="permeEformDistrictId" class="form-control wd65 eformclass" disabled="">
															<option value="">-District-</option>
															
														</select> 
																	</div>
																</div>
																
																											<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Tehsil</label>

																	<div class="col-sm-7">
																		<select id="permeEformTehsilId" name="permeEformTehsilId" class="form-control wd65 eformclass" disabled="">
															<option value="">-Tehsil-</option>
															
														</select> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Municipality</label>

																	<div class="col-sm-7">
																		<select id="permeEformMunicipalityId" name="permeEformMunicipalityId" class="form-control wd65 eformclass" disabled="">
															<option value="">-Municipality-</option>
															
														</select> 
																	</div>
																</div>
																
																											<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Ward</label>

																	<div class="col-sm-7">
																		<select id="permeEformWardId" name="permeEformWardId" class="form-control wd65 eformclass" disabled="">
															</select> 
																	</div>
																</div>
																
																
															 <div class="permeEformVillageMstrMap hide-service"
																	style="display: none;">	
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Panchayat Samity</label>

																	<div class="col-sm-7">
																		<select id="permeEformPanchayatSamityId" name="permeEformPanchayatSamityId" class="form-control col-sm-8 eformclass">
							                                
							                              	                    
						                            	</select> 
																	</div>
																</div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Gram Panchayat</label>

																	<div class="col-sm-7">
																		<select id="permeEformGramPanchayatId" name="permeEformGramPanchayatId" class="form-control col-sm-8 eformclass">
							                             
							                              	                        
						                            	</select> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Village</label>

																	<div class="col-sm-7">
																		<select id="permeEformVillageId" name="permeEformVillageId" class="form-control wd65 eformclass">
															
															
														</select> 
																	</div>
																</div>
															</div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Pin Code</label>

																	<div class="col-sm-7">
																		<input type="number" class="form-control wd65 eformclass " id="permeEformAddPinCode" name="permeEformAddPinCode" maxlength="6" minlength="6" placeholder="Pin Code" value="" readonly> 
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

<div class="col-sm-12 form-group fetchDetailsEform">
											<button type="button" id="fetchDetailsEform" class="btn btn-default pull-left">Change Address </button>
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
															<h4 class="widget-title">Land on Applicant/Agriculture Details </h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Assistant Agriculture Officer Circle </label>

																	<div class="col-sm-7">
																		 <input type="text" class="form-control col-sm-12 eformclass  EformEnalphabetWithSpaceDot" id="AssistantAgriculture" name="AssistantAgriculture" data-msg="Please provide an accurate 'Assistant agriculture officer circle'" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Agriculture supervisor Circle </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-12 eformclass  EformEnalphabetWithSpaceDot" id="Agriculturesupervisor" name="Agriculturesupervisor" data-msg="Please provide an accurate 'Agriculture supervisor Circle'."/>  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Land on Applicant Name (Hectares)-Irrigated </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-12 number Irrigated" required id="LandonApplicantNameHectaresIrrigated" name="LandonApplicantNameHectaresIrrigated" data-msg="Please enter value in 'Land on Applicant’s name (Hectares)-Irrigated'"/> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Land on Applicant Name (Hectares)-Non-Irrigated </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-12 number Irrigated" required id="LandonApplicantNameHectaresNonIrrigated" name="LandonApplicantNameHectaresNonIrrigated" data-msg="Please enter value in 'Land on Applicant’s name (Hectares)-Non-Irrigated'" /> 
																	</div>
																</div>
																
																
																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Total Land (Hectares) </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass  col-sm-12 EformEnblockAlphanumaricWithDash" required disabled id="TotalLandHectares" name="TotalLandHectares" />
																	</div>
																</div>
																

															</div>
														</div>
													</div>

												</div>
												
												
												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Place where Farmer wants to construct the Diggi</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Chak Number </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpacehyphendot" required id="Chaknumber" name="Chaknumber" data-msg="Please provide an accurate 'Chak number'"/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Murabba Number </label>

																	<div class="col-sm-7">
																		 <input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpacehyphendot " required id="MurabbaNumber" name="MurabbaNumber" data-msg="Please provide an accurate 'Murabba number'" />  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Kila Number </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpacehyphendot" required id="KilaNumber" name="KilaNumber" data-msg="Please provide an accurate 'Kila number'" /> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Type of Diggi </label>

																	<div class="col-sm-7">
																		  <select id="TypeofDiggi" name="TypeofDiggi" class="form-control eformclass col-sm-8" required>
											                                   <option Selected disabled>Select</option>
																			   <option>Pakki</option>
																			   <option>Plastic lining</option>
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
															<h4 class="widget-title">Size Of Diggi</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Length Upper </label>

																	<div class="col-sm-7">
																		<input type="Number" class="form-control eformclass col-sm-8 number" required id="LengthUpper " name="LengthUpper" data-msg="Please enter value in 'Length Upper'."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Length Lower </label>

																	<div class="col-sm-7">
																		 <input type="Number" class="form-control eformclass col-sm-8 number " required id="LengthLower" name="LengthLower" data-msg="Please enter value in 'Length Lower'." />  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Breadth Upper </label>

																	<div class="col-sm-7">
																		<input type="Number" class="form-control eformclass col-sm-8 number" required id="BreadthUpper" name="BreadthUpper" data-msg="Please enter value in 'Breadth Upper'."/> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Breadth Lower </label>

																	<div class="col-sm-7">
																		<input type="Number" class="form-control eformclass col-sm-8 number" required id="BreadthLower" name="BreadthLower" data-msg="Please enter value in 'Breadth Lower'." />
																	</div>
																</div>
																
																	<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Depth </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number" required id="Depth " name="Depth" data-msg="Please enter value in 'Depth'"/> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Water Intake Capacity </label>

																	<div class="col-sm-7">
																		<input type="Number" class="form-control eformclass col-sm-8 number" required id="WaterIntake " name="WaterIntake" placeholder="Water Intake Capacity (in lakh Litres) " data-msg="Please enter value in 'Water Intake Capacity (in lakh Litres)'" />
																	</div>
																</div>
																
																													<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Pump Set </label>

																	<div class="col-sm-7">
																		 <select id="PumpSet" name="PumpSet" class="form-control col-sm-8 ifselect1" required>
                                   <option Selected disabled>Select</option>
								   <option>Already established</option>
								   <option>New</option>
								
								   </select> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Brand </label>

																	<div class="col-sm-7">
																		<input type="text" disabled class="form-control eformclass col-sm-8 PumpSetYes EformEnalphabetWithSpaceDot" required id="PumpSetBrand" name="PumpSetBrand" data-msg="Please provide an accurate Brand" />
																	</div>
																</div>
																
																
																															<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Model </label>

																	<div class="col-sm-7">
																	<input type="text" disabled class="form-control eformclass col-sm-8 PumpSetYes EformEnalphabetWithSpaceDot" required id="PumpSetModel" name="PumpSetModel" data-msg="Please provide an accurate Model" />
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Sprinkler/Drip/Micro-Sprinkler </label>

																	<div class="col-sm-7">
																		<select id="SprinklerDrip" name="SprinklerDrip" class="form-control col-sm-8 ifselect2">
										                                   <option Selected disabled>Select</option>
																		   <option>Already established</option>
																		   <option>New</option>
																		</select>
																	</div>
																</div>
																
																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Brand </label>

																	<div class="col-sm-7">
																	<input type="text" disabled class="form-control eformclass col-sm-8 ifselectYes2 EformEnalphabetWithSpaceDot"  id="SprinklerBrand " name="SprinklerBrand" data-msg="Please provide an accurate 'Brand'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."/>
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Model </label>

																	<div class="col-sm-7">
																		<input type="text" disabled class="form-control eformclass col-sm-8 ifselectYes2 EformEnalphabetWithSpaceDot" id="SprinklerModel " name="SprinklerModel"  data-msg="Please provide an accurate 'Model'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>

															</div>
														</div>
													</div>

												</div>
												
												
												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Boundary map of the field is as follows   </h4>
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
																					</tr>
																					</thead>
																					<tbody>
																					<tr>
																					<th><select id="Boundry1" name="Boundry1" class="form-control col-sm-12" required>
													                                   <option selected disabled>Select</option>
																					  <option>East</option>
													                                  <option>North</option>
																					  <option>West</option>
													                                  <option>South</option></select></th>
																					<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="LandholderName1" id="LandholderName1" required></th>
																					<th><select id="Relation1" name="Relation1" class="form-control col-sm-12 " required>
													                                   <option selected disabled>Select</option>
																					  <option>Father</option>
													                                  <option>Husband</option>
																					  <option>Other</option></select></th>
																					<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="Fatherhusband1" id="Fatherhusband1"   name="South" required></th>
																				 </tr>
																				 
																				 
																				 <tr>
																					<th><select id="Boundry2" name="Boundry2" class="form-control col-sm-12">
													                                   <option selected disabled>Select</option>
																					  <option>East</option>
													                                  <option>North</option>
																					  <option>West</option>
													                                  <option>South</option></select></th>
																					<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="LandholderName2" id="LandholderName2"></th>
																					<th><select id="Relation2" name="Relation2" class="form-control col-sm-12 ">
													                                   <option selected disabled>Select</option>
																					  <option>Father</option>
													                                  <option>Husband</option>
																					  <option>Other</option></select></th>
																					<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="Fatherhusband2" id="Fatherhusband2"></th>
																				 </tr>
																				 
																				 
																				 <tr>
																					<th><select id="Boundry3" name="Boundry3" class="form-control col-sm-12">
													                                   <option selected disabled>Select</option>
																					  <option>East</option>
													                                  <option>North</option>
																					  <option>West</option>
													                                  <option>South</option></select></th>
																					<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="LandholderName3" id="LandholderName3"></th>
																					<th><select id="Relation3" name="Relation3" class="form-control col-sm-12">
													                                   <option selected disabled>Select</option>
																					  <option>Father</option>
													                                  <option>Husband</option>
																					  <option>Other</option></select></th>
																					<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="Fatherhusband3" id="Fatherhusband3"></th>
																				 </tr>
																				 
																				 
																				  <tr>
																					<th><select id="Boundry4" name="Boundry4" class="form-control col-sm-12">
													                                   <option selected disabled>Select</option>
																					  <option>East</option>
													                                  <option>North</option>
																					  <option>West</option>
													                                  <option>South</option></select></th>
																					<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="LandholderName4" id="LandholderName4"></th>
																					<th><select id="Relation4" name="Relation4" class="form-control col-sm-12">
													                                   <option selected disabled>Select</option>
																					  <option>Father</option>
													                                  <option>Husband</option>
																					  <option>Other</option></select></th>
																					<th><input type="text" class="form-control col-sm-12 eformclass EformEnalphabetWithSpaceDot" name="Fatherhusband4" id="Fatherhusband4"></th>
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
																		<input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot" required id="Name_of_Bank" name="Name_of_Bank" data-msg="Please provide an accurate 'Bank Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."/>
																		</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Name of Bank Branch </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot " required id="Name_of_Bank_Branch" name="Name_of_Bank_Branch" data-msg="Please provide an accurate 'Branch Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."/>  
																	</div>
																</div>
                                                                
					                                             <div class="clearfix"></div>
					                                             
					                                             <div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">IFSC Code </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters" required id="IFSC_Code" name="IFSC_Code" maxlength="15" />
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Account Number </label>

																	<div class="col-sm-7">
																		<input type="number" class="form-control eformclass col-sm-8 EformEnnumaricOnly" required id="Account_Number" name="Account_Number" maxlength="20" data-msg="'Account Number' must be an integer." />
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