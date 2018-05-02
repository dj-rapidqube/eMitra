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
										<span class="text-info"> Application for Sprinkler subsidy under NFSM/NMOOP etc by the Head of Farmer's family</span>
										<div id="content-1" class="content mCustomScrollbar">
											<form id="defaultForm" method="post"
												class="form-horizontal detailform">



												<div class="col-md-12">

													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Personal Details</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="name">Beneficiary Name </label>

																	<div class="col-sm-7">
																		<input type='text' class='form-control col-sm-8 col-xs-8 eformclass EformEnalphabetWithSpaceDot' required id='ApplicantName' name='ApplicantName'  data-msg='Please enter accurate Beneficiary Name.Only Alaphabets and spaces are allowed[For e.g., Suvarthi Das or Kolkata]. Numbers and special characters are not being accepted.' />
        
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="Firm Name">Gender </label>

																	<div class="col-sm-8">
																		<select id='gender' name='gender' class='form-control col-sm-8 col-xs-8 eformclass' required>
										                                   <option selected disabled>Select</option>
																		   <option value='MALE'>Male</option>
																		   <option value='FEMALE'>Female</option>
										                                   <option value='OTHER'>Other</option>								
																		</select>
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label eformclass"
																		for="License No">Relation Type </label>

																	<div class="col-sm-7">
																		<select id='Relationtype' name='Relationtype' class='form-control col-xs-8 eformclass' required>
										                                   <option selected disabled>Select</option>
																		   <option>Father</option>
																		   <option>Husband</option>
																	
																		</select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label eformclass"
																		for="CasteCategory">Father/Husband Name </label>

																	<div class="col-sm-8">
																		<input type='text' class='form-control col-sm-8 col-xs-8 eformclass EformEnalphabetWithSpaceDot' required id='Fathe_Hus_Name' name='Fathe_Hus_Name' data-msg='Please provide an accurate 'Father / Husband's Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted.' />
																    </div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="Mobile No">Farmer's Class </label>

																	<div class="col-sm-7">
																		<select id='FarmerClass' name='FarmerClass' class='form-control col-xs-8 eformclass' required>
												                                  <option selected disabled>Select</option>
																				  <option>Marginal</option>
																				  <option>Others</option>
																				  <option>Small</option>
																			
																	    </select>
								   </div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="MobileNumber">Caste - Category </label>

																	<div class="col-sm-8">
																		<select id='categoryIdEform' name='categoryIdEform' class='form-control col-xs-8 eformclass' required>
										                                   <option selected disabled >Select</option>
																		  
																		</select>
																	</div>
																</div>

																<div class="clearfix"></div>
																
																
																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="Mobile No">E-mail </label>

																	<div class="col-sm-7">
																		   <input type='text' class='form-control eformclass col-sm-8 col-xs-8 email' required id='txt_Email_Service' name='txt_Email_Service' data-msg='Please enter a proper 'E-mail' : For e.g., kavita.krishna12@gmail.com' />
                                
								                                    </div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="MobileNumber">Mobile Number </label>

																	<div class="col-sm-8">
																		<input type='text' id='Mobile' name='Mobile' class='form-control eformclass EformEnnumaricOnly1 col-sm-8 col-xs-8' minlength='10' maxlength='13' placeholder='Enter Mobile Number' required data-msg='Please enter a correct 'Mobile No.' [For e.g.,  9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'.' />
																	</div>
																</div>
																
																
																<div class="clearfix"></div>
																
																
																<div class="form-group col-md-6">
																	<label class="col-sm-5 control-label eformclass"
																		for="Mobile No">Landline number </label>

																	<div class="col-sm-7">
																		  <input type='text' id='Landline' name='Landline' class='form-control eformclass  EformEnnumaricOnly1 col-sm-8 col-xs-8' minlength='10' maxlength='12' placeholder='Enter Landline Number'  data-msg='Please enter a correct 'Landline number' [For e.g.,  9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'.' />
                                
								                                    </div>
																</div>

															</div>
														</div>
													</div>
												</div>

												<div class="col-md-12">
													<div class="widget-box">
														<div class="widget-header">
															<h4 class="widget-title">Land on Applicant/Agriculture Details</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">Land owned by Applicant (in hectares)</label>

																	<div class="col-sm-7">
																		<input type='text' class='form-control eformclass col-sm-12 col-xs-12 number Irrigated' required id='Landowned' name='Landowned' data-msg='Please enter value in 'Land owned by Applicant (in hectares)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted.' />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Address In Hindi">Khasra number in which Sprinkler/Raingun is to be installed </label>

																	<div class="col-sm-8">
																		<input type='text' class='form-control eformclass  col-sm-12 col-xs-12 EformEnblockAlphanumaricWithDash1' required id='Khasranumber' name='Khasranumber' data-msg='Please provide correct Khasra Number.It allows only alphanumeric with space and comma.' />
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Availed any subsidy for Sprinkler/Raingun in any Scheme of Horticulture and Agriculture Department</label>

																	<div class="col-sm-7">
																		<select id='subsidyforSprinklerDiscript' class='select form-control col-xs-12  col-sm-12 eformclass' name='subsidyforSprinklerDiscript'>
																				<option selected disabled>Select</option>
																				<option>YES</option>
																				<option>NO</option>
																		</select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="State">If yes, give description: Area (in hectares)
																	</label>

																	<div class="col-sm-8">
																		<textarea style='height:35px;' disabled id='SprinklerDiscript' name='SprinklerDiscript' class='form-control eformclass SprinklerYes col-sm-12 col-xs-12 number'data-msg='Please provide correct 'If yes, give description: Area (in hectares)'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash.'></textarea> 
																	</div>
																</div>

																<div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Division">Cropped Area (in hectares)</label>

																	<div class="col-sm-7">
																		<input disabled type='text' id='CroppedArea' name='CroppedArea' class='form-control eformclass SprinklerYes col-sm-12 col-xs-12 number ' data-msg='Please enter value in 'Cropped Area (in hectares)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted.'/> 
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Year of Installation
																	</label>

																	<div class="col-sm-8">
																		<select id='YearofInstallation' class='select form-control col-sm-12 col-xs-12 eformclass SprinklerYes' name='YearofInstallation' disabled>
																		<option selected disabled>Select</option>
																	
																		</select>
																	</div>
																</div>

																<div class="clearfix"></div>
																
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Tehsil">Crop proposed to be grown</label>

																	<div class="col-sm-7">
																		<input  type='text' id='Cropproposed' name='Cropproposed' class='form-control eformclass col-sm-12 col-xs-12 EformEnalphabetWithSpaceDot' data-msg='Please provide correct 'Crop proposed to be grown'. Accepted values are alphabets, spaces, slash, dot, dash and comma.' /> 
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Type of MI set to be installed
																	</label>

																	<div class="col-sm-8">
																		<select id='TypeofMI' class='select col-sm-12 col-xs-6 form-control  eformclass' name='TypeofMI' >
																			<option selected disabled>Select</option>
																			<option>Raingun</option>
																			<option>Sprinklers</option>
																	    </select>
																	</div>
																</div>

																<div class="clearfix"></div>
																
																
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">If Raingun</label>

																	<div class="col-sm-7">
																		<input type='text' disabled id='IfRaingun' name='IfRaingun' class='form-control eformclass col-sm-12 col-xs-12 EformEnblockSpacialCharacters' data-msg='Please provide correct 'If Raingun'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash'/> 
																	</div>
																</div>


																<div class="form-group col-md-6 required">
																		<label class="col-sm-4 control-label"
																			for="Panchayat Samity">Size of HDPE/ALLM </label>

																		<div class="col-sm-8">
																			<input disabled type='text' id='SizeofHDPE' name='SizeofHDPE ' class='form-control IfSprinklers eformclass col-sm-12 col-xs-12 number'data-msg='Please enter value in 'Size of HDPE/ALLM' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted.'/> 
																		</div>
																</div>

                                                                <div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																		<label class="col-sm-5 control-label" for="Ward">If Sprinklers </label>

																		<div class="col-sm-7">
																			<input disabled type='text' id='IfSprinklers' name='IfSprinklers ' class='form-control IfSprinklers eformclass col-sm-12 col-xs-12 EformEnblockSpacialCharacters' data-msg='Please provide correct 'If Sprinklers'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash.' /> 

																		</div>
																</div>

																<div class="form-group col-md-6 required"
																			aria-required="true">

																			<label class="col-sm-4 control-label" for="Village">Whether MI Set is for Pulses or Wheat Crop
																			</label>

																			<div class="col-sm-8">
																				<select id='PulsesorWheat' class='select col-sm-12 col-xs-12 form-control  eformclass ' name='PulsesorWheat' >
																					<option selected disabled>Select</option>
																					<option>Pulses</option>
																					<option>Wheat</option>
																					<option>Other</option>
																					</select>
																			</div>
																</div>

														
																
                                                                <div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="District">Total area for micro irrigation </label>

																	<div class="col-sm-7">
																		<input  type='text' id='microirrigation' name='microirrigation' class='form-control eformclass col-sm-12 col-xs-12 number' data-msg='Please enter value in ' Total area for micro irrigation' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted.' data-msg='Please enter value in ' Total area for micro irrigation' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted.'/> 
																	</div>
																</div>

																
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Source of Water </label>

																	<div class="col-sm-8">
																		<input  type='text' id='SourceofWater' name='SourceofWater ' class='form-control eformclass col-sm-12 col-xs-12 EformEnalphabetWithSpaceDot' data-msg='Please enter accurate 'Source of Water'. Only alphabets and spaces are allowed [For e.g., Suvarthi Das or Kolkata]. Numbers and special characters are not being accepted.'/>   
																	</div>
																</div>
																
																<div class="clearfix"></div>
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="District">Type of Well </label>

																	<div class="col-sm-7">
																		<select id='TypeofWell' class='select col-sm-12 col-xs-12 required  form-control  eformclass' name='TypeofWell' >
																			<option selected >Select</option>
																			<option>Open Well</option>
																			<option>Tube Well</option>
																			<option>Other</option>
																			</select> 
																	</div>
																</div>
																
																
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Water level (in meters) </label>

																	<div class="col-sm-8">
																		<input  type='text' id='Waterlevel' name='Waterlevel' class='form-control eformclass col-xs-12 col-sm-12 number' data-msg='Please enter value in 'water level (in meters)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted.'/>    
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
															<h4 class="widget-title">For Water Harvesting Structure</h4>

														</div>


														<div class="widget-body">
															<div class="widget-main" id="textaddeform">

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="Address In English">If Irrigation is done through canal, then any other water harvesting structure available? </label>

																	<div class="col-sm-7">
																		<select id='IfIrrigation' class='select col-sm-12 col-xs-12 required eformclass form-control ' name='IfIrrigation' >
																			<option selected >Select</option>
																			<option>YES</option>
																			<option>NO</option>
																			</select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Address In Hindi">If yes, give description </label>

																	<div class="col-sm-8">
																		<textarea style='height:35px;' disabled id='Irrigationdescription' name='Irrigationdescription' class='form-control eformclass col-xs-12  col-sm-12 EformEnblockSpacialCharacters' data-msg='Please provide correct 'If yes, give description'. Accepted values are alphabets, numbers, spaces, slash, comma, dot, hyphen,underscore and hash.'></textarea>  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Availability of electricity (in hours)</label>

																	<div class="col-sm-7">
																		<input  type='text' id='electricity' name='electricity' class='form-control eformclass col-sm-12 col-xs-12 number1 ' data-msg='Please enter value in 'Availability of electricity (in hours)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 11  or 16.00]. Alphabets  and special characters are not being accepted.'/> 
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="State">Pump capacity (in horsepower)
																	</label>

																	<div class="col-sm-8">
																		<input  type='text' id='Pumpcapacity' required name='Pumpcapacity' class='form-control eformclass col-sm-12 col-xs-12 EformEnnumaricOnly'data-msg=''Pump capacity (in horsepower)' must be an integer.' />  
																	</div>
																</div>

																<div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Division">Horsepower of diesel engine, if available </label>

																	<div class="col-sm-7">
																		<input  type='text' id='Horsepower'  name='Horsepower' class='form-control eformclass col-sm-12 col-xs-12 EformEnnumaricOnly'data-msg=''Horsepower of diesel engine, if available' must be an integer.' />  
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Size of land holding (in hectares)
																	</label>

																	<div class="col-sm-8">
																		<input  type='text' required id='landholding'  name='landholding' class='form-control eformclass col-sm-12 col-xs-12 number'data-msg='Please enter value in 'Size of land holding  (in hectares)' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted.' /> 
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
																		for="Address In English">Account Holder Name </label>

																	<div class="col-sm-7">
																		<input type='text' class='form-control col-sm-8 col-xs-8 eformclass EformEnalphabetWithSpaceDot' required id='AccountHolderName' name='AccountHolderName' data-msg='Please enter accurate 'Name of Account holder'. Only alphabets and spaces are allowed [For e.g., Suvarthi Das or Kolkata]. Numbers and special characters are not being accepted.' />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Address In Hindi">Name of Bank </label>

																	<div class="col-sm-8">
																		<input type='text' class='form-control eformclass col-sm-8 col-xs-8 EformEnalphabetWithSpaceDot' required id='Name_of_Bank' name='Name_of_Bank'data-msg='Please enter accurate 'Bank Name'. Only alphabets and spaces are allowed [For e.g., Suvarthi Das or Kolkata]. Numbers and special characters are not being accepted.' />  
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Name of Bank Branch</label>

																	<div class="col-sm-7">
																		<input type='text' class='form-control eformclass col-sm-8 col-xs-8 EformEnalphabetWithSpaceDot ' required id='Name_of_Bank_Branch' name='Name_of_Bank_Branch' data-msg='Please enter accurate 'Name of Account holder'. Only alphabets and spaces are allowed [For e.g., Suvarthi Das or Kolkata]. Numbers and special characters are not being accepted.' /> 
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="State">IFSC Code
																	</label>

																	<div class="col-sm-8">
																		<input type='text' class='form-control eformclass col-sm-8 col-xs-8 EformEnblockAlphanumaricWithoutSpace' required id='IFSC_Code' name='IFSC_Code' maxlength='15' />  
																	</div>
																</div>

																<div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Division">Account Number </label>

																	<div class="col-sm-7">
																		<input type='text' class='form-control eformclass col-sm-8 col-xs-8 EformEnnumaricOnly' required id='Account_Number' name='Account_Number' data-msg=''Account Number' must be an integer.'/>  
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