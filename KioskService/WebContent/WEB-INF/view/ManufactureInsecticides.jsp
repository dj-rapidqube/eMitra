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
										<span class="text-info"> Application for the Grant of License to manufacture Insecticides</span>
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
																	<label class="col-sm-5 control-label" for="Country">License Authority </label>

																	<div class="col-sm-7">
																		<select id="LicenseAuthority" name="LicenseAuthority" class="form-control col-sm-8 " required>
												                        <option selected disabled>Select</option>
																		<option>Joint Director Agriculture(PP)</option>
																		</select>
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="Country">Applicant/Firm name </label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 eformclass" required id="applicantfirm" name="applicantfirm" data-msg="Please provide correct 'Applicant/Firm name'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."/> 
																	</div>
																</div>
																
																
																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Status of the Applicant </label>

																	<div class="col-sm-7">
																		<select id="StatusApplicant" name="StatusApplicant" class="form-control col-sm-8 "  required>
													                        <option selected disabled>Select</option>
																			<option>Indivisual</option>
																			<option>Partnership Firm</option>
																			<option>Registered Company</option>
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
															<h4 class="widget-title">Applicant/Firm address</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Telephone </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass number" minlength="10" maxlength="13" id="telephone" name="telephone" data-msg="Please enter a correct 'Landline No.' [For e.g., 9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'."/>
        
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="Firm Name">E-mail </label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 eformclass email" id="email" name="email" data-msg="Please enter a proper 'E-mail' : For e.g., kavita.krishna12@gmail.com"/>
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="License No">Mobile No. </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass number" minlength="10" maxlength="13" required id="mobile1" name="mobile1" data-msg="Please enter a correct 'Mobile No.' [For e.g., 9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">Applicant Address </label>

																	<div class="col-sm-8">
																		<textarea style="height:35px;" required id="ApplicantAddress"  name="ApplicantAddress" class="form-control eformclass col-sm-8 " data-msg="Please provide correct Complete Address. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash."></textarea>
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
															<h4 class="widget-title">Address of the Premises where the manufacturing activity will be done</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Address In English </label>

																	<div class="col-sm-7">
																		<textarea class="form-control wd65 englishDescription eformclass" id="permeEformAddressInEngtext" name="permeEformAddressInEngtext"  minlength="2" maxlength="300"></textarea>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">Address In Hindi </label>

																	<div class="col-sm-7">
																		<textarea class="form-control wd65 hindiDescription eformclass" id="permeEformAddressInHintext" name="permeEformAddressInHintext" placeholder="Address In Hindi" minlength="2" maxlength="300"></textarea>  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Country</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformCountryIdtext" name="permeEformCountryIdtext" class="form-control wd65 eformclass"  /> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">State</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformStateIdtext" name="permeEformStateIdtext" class="form-control wd65 eformclass"> 
																	</div>
																</div>
																
																
																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Division</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformDivisionIdtext" name="permeEformDivisionIdtext" class="form-control wd65 eformclass" > 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">District</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformDistrictIdtext" name="permeEformDistrictIdtext" class="form-control wd65 eformclass"  /> 
																	</div>
																</div>
																
																											<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Tehsil</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformTehsilIdtext" name="permeEformTehsilIdtext" class="form-control wd65 eformclass" /> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Municipality</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformMunicipalityIdtext" name="permeEformMunicipalityIdtext" class="form-control wd65 eformclass" /> 
																	</div>
																</div>
																
																											<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Ward</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformWardIdtext" name="permeEformWardIdtext" class="form-control wd65 eformclass" /> 
																	</div>
																</div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Panchayat Samity</label>

																	<div class="col-sm-7">
																		<input type="text" id="permeEformPanchayatSamityIdtext" name="permeEformPanchayatSamityIdtext" class="form-control col-sm-8 eformclass" /> 
																	</div>
																</div>

																	<div class="clearfix"></div>


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
																
																									<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Pin Code</label>

																	<div class="col-sm-7">
																		<input type="number" class="form-control wd65 eformclass " id="permeEformAddPinCodetext" name="permeEformAddPinCodetext" maxlength="6" minlength="6" placeholder="Pin Code" value=""/> 
																	</div>
																</div>
																

															</div>
														</div>
													</div>

												</div>
												
												
												
												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Name of the insecticide for which manufacturing license is applied</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">
                                                                   
                                                                <div class="col-md-12 form-group required">
																	<table class="table table-hover table-bordered">
																    <thead>
																		<tr>
																		<th>Name Of The Insecticide</th>
																		<th>Registration Number</th>
																		
																		</tr>
																	</thead>
																
																	<tbody id="possessionTableAdd">
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides" id="Insecticides" required type="text"></td>
																			    <td><input class="form-control col-sm-12" name="Certificates" id="Certificates"  type="text"></td>
																			    
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides1" id="Insecticides1"   type="text"></td>
																			    <td><input class="form-control col-sm-12" name="Certificates1" id="Certificates1"  type="text"></td>
																			   
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides2" id="Insecticides2"  type="text"></td>
																			    <td><input class="form-control col-sm-12" name="Certificates2" id="Certificates2" type="text"></td>
																			   
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides3" id="Insecticides3"  type="text"></td>
																			    <td><input class="form-control col-sm-12" name="Certificates3" id="Certificates3"  type="text"></td>
																			    
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides4" id="Insecticides4"  type="text"></td>
																			    <td><input class="form-control col-sm-12" name="Certificates4" id="Certificates4"  type="text"></td>
																			    
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides5" id="Insecticides5" required="" type="text"></td>
																			    <td><input class="form-control col-sm-12" name="Certificates5" id="Certificates5" type="text"></td>
																			    
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides6" id="Insecticides6" type="text"></td>
																			    <td><input class="form-control col-sm-12"  name="Certificates6" id="Certificates6" type="text"></td>
																			  
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides7" id="Insecticides7" type="text"></td>
																			    <td><input class="form-control col-sm-12" name="Certificates7" id="Certificates7" type="text"></td>
																			  
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides8" type="text"></td>
																			    <td><input class="form-control col-sm-12"  name="Certificates8" id="Certificates8" type="text"></td>
																			    
																			  </tr>
																			  <tr>
																			    <td><input class="form-control col-sm-12" name="Insecticides9" type="text"></td>
																			    <td><input class="form-control col-sm-12" name="Certificates9" id="Certificates9" type="text"></td>
																			   
																			  </tr>
																		</tbody>								
						                                              </table>
					                                                
					                                             </div>
					                                             
					                                             				<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Whether any registration is provisional</label>

																	<div class="col-sm-7">
																		<select id="provisional" name="provisional" class="form-control col-sm-6 " required>
													                        <option selected disabled>Select</option>
																			<option>Yes</option>
																			<option>No</option>
																		</select> 
																	</div>
																</div>
																
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">If, so give particulars</label>

																	<div class="col-sm-7">
																		<textarea class="form-control col-sm-8 englishDescription eformclass" id="giveparticulars" name="giveparticulars"  minlength="2" maxlength="300" readonly></textarea> 
																	</div>
																</div>
																
									

															</div>
														</div>
													</div>

												</div>
												
												
												
													<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Details of the full time expert staff connected with the manufacture and testing of the insecticides in the above unit</h4>
                                                            <p>(enclosed copy of certificate of Registration of the insecticide duly certified by the Applicant)</p>
														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Whether registration is provisional or Regular </label>

																	<div class="col-sm-7">
																		<select id="whether" name="whether" class="form-control col-sm-8 " required>
													                        <option selected disabled>Select</option>
																			<option>Provisional</option>
																			<option>Regular</option>
																		</select>
																		</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In Hindi">If Provosional,give date of validity </label>

																	<div class="col-sm-7">
																		<input type="date" class="form-control col-sm-8 eformclass" id="validitydateProvosional" name="validitydateProvosional" required />  
																	</div>
																</div>

																<div class="clearfix"></div>
                                                               
                                                                
                                                                 <div class="col-md-12 form-group required">
																	<table class="table table-hover table-bordered">
																		<thead>
																		<tr>
																		<th><label class="control-label">Name</label></th>
																		<th><label class="control-label">Qualification</label></th>
																		<th><label class="control-label">Experience</label></th>
																		<th><label class="control-label">Designation</label></th>
																		
																		</tr>
																		</thead>
																						
																									
																		
																		
																		<tbody id="possessionTableAdd1">
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name" id="Name" required type="text"></td>
																		    <td><input class="form-control col-sm-12"  name="Qualification" id="Qualification" required type="text"></td>
																		    <td><input class="form-control col-sm-12"  name="Experience" id="Experience" required type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation" id="Designation" required="" aria-required="true" type="text"></td>
																		    <td></td>
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12"  name="Name1" name="Name1" type="text"></td>
																		    <td><input class="form-control col-sm-12"  name="Qualification1" name="Qualification1"  type="text"></td>
																		    <td><input class="form-control col-sm-12"  name="Experience1"  id="Experience1"  type="text"></td>
																		    <td><input class="form-control col-sm-12"  name="Designation1" id="Designation1" type="text"></td>
																		   
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name2" type="text"></td>
																		    <td><input class="form-control col-sm-12"  name="Qualification2" type="text"></td>
																		    <td><input class="form-control col-sm-12"  name="Experience2"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation2"  type="text"></td>
																		   
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name3"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Qualification3"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Experience3"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation3"  type="text"></td>
																		   
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name4"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Qualification4"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Experience4"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation4"  type="text"></td>
																		    
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name5" type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Qualification5"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Experience5"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation5"  type="text"></td>
																		    
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name6"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Qualification6"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Experience6"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation6" id="Designation6"  type="text"></td>
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name7" id="Name7"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Qualification7" id="Qualification7" type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Experience7" id="Experience7"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation7"  id="Designation7" type="text"></td>
																		   
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name8" id="Name8"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Qualification8"  id="Qualification8" type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Experience8" id="Experience8" type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation8" id="Designation8" type="text"></td>
																		    
																		  </tr>
																		  <tr>
																		    <td><input class="form-control col-sm-12" name="Name9" id="Name9" type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Qualification9" id="Qualification9" type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Experience9" id="Experience9"  type="text"></td>
																		    <td><input class="form-control col-sm-12" name="Designation9" id="Designation9" type="text"></td>
																		    
																		  </tr>
																		</tbody>	

					                                                  </table>
					                                                
					                                             </div>
					                                             
					                                             <div class="clearfix"></div>
					                                             
					                                             <div class="form-group col-md-12 required">
																	<label class="col-sm-8 control-label"
																		for="Address In Hindi">Whether all the facilities required under chapter VIII of the Insecticides Rules, 1971 have been provided. </label>

																	<div class="col-sm-4">
																		<select id="facilitiesrequired" name="facilitiesrequired" class="form-control col-sm-8 " required>
																		<option selected disabled>Select</option>
																		<option>Yes</option>
																		<option>No</option>
																		</select>
																	</div>
																</div>
																
																
																<div>(Enclouse complete details in a separate sheet duly signed by the Applicant)</div>
																
																<div class="col-sm-8 form-group required col-sm-offset-5">
																	<button class="btn btn-custom-secondary">Save</button>
																	<button class="btn btn-custom-secondary" type="button" id="eFormCancel" onClick="closeEform()">Cancel</button>
																	<button class="btn btn-custom-secondary" type="button" id="eFormPayment" onClick="payEform()" style="display: none">ProceedToPay</button>
																	<span class="btn btn-custom-primary print"><i class="fa fa-print"></i>Print</span>
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