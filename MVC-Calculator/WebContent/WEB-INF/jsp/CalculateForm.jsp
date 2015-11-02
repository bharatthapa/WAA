<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate JSP</title>
</head>
<body>
<div id="divID">
<c:if test="${errors !=null}">

	<p id="errors">
         Error(s)!
        <ul>
	        <c:forEach var="error" items="${errors}">
	            <li>${error}</li>
	        </c:forEach>
	    </ul>
	
</c:if>

Calculate JSP page 
<form method="post" action="calculate_save">

<input type="text" name ="sum1" value="${inputDOMAIN.sum1}">
+
<input type="text" name ="sum2"  value="${inputDOMAIN.sum2}">
<br>
<input type="text" name ="mul1"  value="${inputDOMAIN.mul1}">
*
<input type="text" name ="mul2"  value="${inputDOMAIN.mul2}">

<input type="submit" name ="submit" value="Submit">

</form>
</div>
</body>
</html>