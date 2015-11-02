<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css"> 
p,li{
color: red;
}
</style>
<title> Calculate JSP </title>
</head>
<body>
<p id="errorRead">
<c:if test="${errors !=null}">

Errors!
<ul>
	<c:forEach var="errors" items="${errors}">
		<li>${errors}</li>
	</c:forEach>

</ul>
</c:if>
</p>
Calculate JSP page 
<form method="post" action="saveCalculate">

<input type="text" name ="sum1" id ="sum1" value="${calculator1.sum1}">
+
<input type="text" name ="sum2" id ="sum2"  value="${calculator1.sum2}">
<br>
<input type="text" name ="mul1" id ="mul1" value="${calculator1.mul1}">
*
<input type="text" name ="mul2" id ="mul2" value="${calculator1.mul2}">

<input type="submit" name ="submit" value="Submit">

</form>

</body>
</html>