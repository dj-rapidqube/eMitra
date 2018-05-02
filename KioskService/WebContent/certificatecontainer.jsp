<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function printPdf() {
var iframe = document.frames ? document.frames['pdfFrame'] : document
.getElementById('pdfFrame');
var ifWin = iframe.contentWindow || iframe;
iframe.focus();
ifWin.print();
setTimeout(function(){window.self.close();}, 9000);
return false;
}
</script>
<body>


<iframe 
src='<%= request.getParameter("urlOfPrinting")%>'

width="10%" height="10px" id="pdfFrame"
frameborder="0" onload="printPdf();"></iframe>

</body>
</html>