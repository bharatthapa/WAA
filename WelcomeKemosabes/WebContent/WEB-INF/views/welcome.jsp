<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>  Spring MVC Example with AJAX call</TITLE>
 </head>

<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/welcome.js"/>"></script>

<body>
    <div align="center">
         <h1>${message} </h1> 
        <!--div id="result"></div-->
    </div>   
    
 		<h1 class="welcome" style = "text-align:center"> </h1>  
  		
        <table class="duke">
        <tr>
        <td id="d1"  style="visibility: visible;"> <img src="<spring:url value="/resources/images/Duke2.png"  htmlEscape="true" />" height="300" width="150" /> </td>
        <td id="d1a"  style="visibility: hidden;"> <img src="<spring:url value="/resources/images/Duke21.png"  htmlEscape="true" />" height="300" width="300"  /> </td>
        <td id="d2"  style="visibility: hidden;"> <img src="<spring:url value="/resources/images/Duke2a.png"  htmlEscape="true" />" height="150" width="300"  /> </td>
        <td id="d2a"  style="visibility: hidden;"> <img src="<spring:url value="/resources/images/Duke2a1.png"  htmlEscape="true" />" height="300" width="300"  /> </td>
        <td id="d3"  style="visibility: hidden;"> <img src="<spring:url value="/resources/images/Duke2b.png"  htmlEscape="true" />" height="300" width="150"/>  </td>
        <td id="d3a"  style="visibility: hidden;"> <img src="<spring:url value="/resources/images/Duke2b1.png"  htmlEscape="true" />" height="300" width="300"/>  </td>
        <td id="d4"  style="visibility: hidden;"> <img src="<spring:url value="/resources/images/Duke2c.png"  htmlEscape="true" />" height="150" width="300" />  </td>
        <td id="d5"  style="visibility: hidden;"> <img src="<spring:url value="/resources/images/Duke2c1.png"  htmlEscape="true" />" height="300" width="300" />  </td>
         </tr>
        </table>
        <br>
 
</body>
</html>