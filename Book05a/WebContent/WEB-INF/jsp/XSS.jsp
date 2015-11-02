<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Test XSS</title>
 </head>
<body>

      <c:set var="test" value="javascript:alert('Oh no! You have been hacked!!')"></c:set>
  
 </br>
<c:url var="cURL" value="/addBook">
   <c:param name="filter" value="${test }"/>
 </c:url> 
 <a href="${cURL}"> HREF c:url </a>
</br>

 <a href= "<spring:url value="javascript:alert('Oh no! You have been hacked!!')"/> " > HREF spring:url </a>
 </br>
 <a href= "<spring:url value="/addBook?isbn= ${test }"/> " > spring:url </a>
 </br>


<!-- Query Parameter passing (Avoids XSS injection attack - URL encoding) -->
<spring:url value="/addBook" var="addBook_url" >
</spring:url>
<a href="${addBook_url}">Add Book</a><br/>

 


</body>
</html>
