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
<title>Kiosk - Bill</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans|Nunito+Sans:600|700"
	rel="stylesheet">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="css/bootstrap-material-design.min.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link href="css/my-style.css" type="text/css" rel="stylesheet" />

</head>
<%-- <c:choose>
  <c:when test="${flag==1}"> --%>
	 <body onload="submit()" style="background: url(img/inner-bg.png); background-size: cover;">
 <%--  </c:when>
  <c:otherwise>
	 <body onload="submit1()" style="background: url(img/inner-bg.png); background-size: cover;">
 </c:otherwise> --%>
<%-- </c:choose> --%>
 <form id="cardpayment">
 <input type="hidden" name="ENCDATA" value="${enc}">
 <input type="hidden" name="MERCHANTCODE" value="${merchant}">
 </form>
	
	
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script src="js/jquery-1.12.4.js"></script>
	<script>
function submit() {
	//alert("csd");
	document.getElementById('cardpayment').action = "https://rpp.rajasthan.gov.in/payments/v1/init";
//	document.getElementById('cardpayment').action = "http://uat.rpp.rajasthan.gov.in/payments/v1/init";
	
	document.getElementById('cardpayment').method = "POST";
	
	document.getElementById('cardpayment').submit();  
};

function submit1() {
	//alert("csd");
	document.getElementById('cardpayment').action = "https://rpp.rajasthan.gov.in/payments/v1/init";
//	document.getElementById('cardpayment').action = "http://uat.rpp.rajasthan.gov.in/payments/v1/init";
	
	document.getElementById('cardpayment').method = "POST";
	document.getElementById('cardpayment').submit();  
};
	</script>


</body>

</html>
