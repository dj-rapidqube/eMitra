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
										<h1 class="">Department of Agriculture</h1>
										<span class="text-info">Application Form for Incentive to Girl students</span>
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
																	<label class="col-sm-5 control-label"
																		for="Address In English">Year</label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass dateRange" required id="txtYearName" name="txtYearName" minlength="9" maxlength="9" data-msg="Please provide correct 'YEAR'. Accepted values like 2004-2005" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label"
																		for="Address In Hindi">Girl Student Name </label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" required id="ApplicantName" name="ApplicantName" data-msg="Please provide an accurate 'Girl Student Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted." />
																	</div>
																</div>

																<div class="clearfix"></div>


																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Country">Father Name</label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" required id="fatherNameEform" name="fatherNameEform" data-msg="Please provide an accurate 'Father’s Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="State">Mother Name
																	</label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" required id="motherNameEform" name="motherNameEform" data-msg="Please provide an accurate 'Mother’s Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."/>
																	</div>
																</div>

																<div class="clearfix"></div>

																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Division">Husband's name</label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control col-sm-8 eformclass EformEnalphabetWithSpaceDot" id="Husbandname" name="Husbandname" data-msg="Please provide an accurate 'Husband’s Name'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">Date of Birth
																	</label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 eformclass calender date" required id="profiledobSpanEform" name="profiledobSpanEform" data-msg="Please enter correct 'Date of Birth'. It should be in DD/MM/YYYY format.[For e.g., 01/01/1940]"/>
																	</div>
																</div>

																<div class="clearfix"></div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Tehsil">Caste - Category</label>

																	<div class="col-sm-7">
																		<select id="categoryIdEform" name="categoryIdEform" class="form-control eformclass col-sm-8 cal">
          
        </select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="District">E-mail
																	</label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control col-sm-8 email" required id="txt_Email_Service" name="txt_Email_Service" />
																	</div>
																</div>

																<div class="clearfix"></div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Mobile Number</label>

																	<div class="col-sm-7">
																		<input type="text" id="Mobile" name="Mobile" class="form-control eformclass  RequiredField EformEnnumaricOnly1 col-sm-8" minlength="10" maxlength="13" placeholder="Enter Mobile Number" required data-msg="Please enter a correct 'Mobile No.' [For e.g.,  9038478092 or 09038478092 or +919038478092 for mobile and 0802359553 or +918023585530 for phone number]. Alphabets and special characters are not accepted . Maximum 11 digits are accepted or 12 digits preceeded by '+'."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">UID number</label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number" required id="UIDnumber" name="UIDnumber" maxlength="13" />
																	</div>
																</div>
																
																<div class="clearfix"></div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Home</label>

																	<div class="col-sm-7">
																		<select class="form-control eformclass col-sm-8 " id="mst_ddlDistrictPermanent_Service" name="mst_ddlDistrictPermanent_Service" >
      
      </select>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Class</label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters1 " required id="NameClass" name="NameClass" data-msg="Please provide an accurate 'Class'. Accepted values are alphabets, numbers, spaces, hyphen and dot only [For e.g., abcd-123 .xyz] .No other Special characters are being accepted."/>
																	</div>
																</div>
																
																	<div class="clearfix"></div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Admission Date in Current class </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 calender date" required id="AdmissionDate" name="AdmissionDate" data-msg="Please enter correct 'Admission Date in Current class'. It should be in DD/MM/YYYY format.[For e.g., 01/01/1940]"/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Name of School/college </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnblockSpacialCharacters" required id="NameofSchool" name="NameofSchool" data-msg="Please provide correct 'Name of School/college'. Accepted values are alphabets, numbers, spaces, slash, dot, comma and hyphen only. Any other special character is not being accepted."/>
																	</div>
																</div>
																
																
																<div class="clearfix"></div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Incentive amount received earlier </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number" required id="Incentiveamount" name="Incentiveamount" maxlength="10" data-msg="Please enter value in 'incentive amount received earlier' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label" for="Ward">Incentive amount for current year </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 number" required id="Incentiveamountcurrent" name="Incentiveamountcurrent" maxlength="10" data-msg="Please enter value in 'Incentive amount for current year' field  either in Decimal figure or in rounded off Integer figure  [For e.g., 310  or 47.89]. Alphabets  and special characters are not being accepted." />
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
																	<label class="col-sm-5 control-label" for="irrigated">Name of Bank</label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot" required id="Name_of_Bank" name="Name_of_Bank" data-msg="Please provide an accurate 'Name of Bank'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."/>
																	</div>
																</div>
																
																   <div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="irrigated">Name of Bank Branch</label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnalphabetWithSpaceDot " required id="Name_of_Bank_Branch" name="Name_of_Bank_Branch" data-msg="Please provide an accurate 'Name of Bank Branch'. Accepted values are alphabets, spaces and dot only [For e.g., Sudhir S.K. Chauhan]. No Special characters are being accepted."/>
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-5 control-label"
																		for="nonirrigated">IFSC Code </label>

																	<div class="col-sm-7">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnblockAlphanumaricWithoutSpace" required id="IFSC_Code" name="IFSC_Code" maxlength="15" />
																	</div>
																</div>
																<div class="form-group col-md-6 required">
																	<label class="col-sm-4 control-label" for="khasrano">Account Number </label>

																	<div class="col-sm-8">
																		<input type="text" class="form-control eformclass col-sm-8 EformEnnumaricOnly" required id="Account_Number" name="Account_Number" maxlength="20" data-msg="'Account Number' must be an integer."/>
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