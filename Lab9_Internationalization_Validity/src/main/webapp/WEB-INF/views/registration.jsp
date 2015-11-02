<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<h1>Registration Form</h1>
	<br />
	
	
	<form:form commandName="student" method="post">
    <fieldset>
        <legend>Add an Student</legend>
  		<p>
  		     <form:errors path="*" cssStyle="color : red;" /> 
        </p>
        <p>
            <label for="id">ID </label>
           <form:input path="id" />
 	
 		 </p>
        <p>
            <label for="firstName">First Name: </label>
           <form:input path="firstName" />
 	
 		  	<div style="text-align: center;">
 				<form:errors path="firstName" cssStyle="color : red;" /> 
 			</div>
       </p>
        <p>
            <label for="lastName">Last Name: </label>
           <form:input path="lastName" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="lastName" cssStyle="color : red;" /> 
 			</div>
       </p>

        <p>
            <label for="email">Email </label>
            <form:input path="email" id="email" />
 			<form:errors path="email" cssStyle="color : red;" /> 
        </p>
       
           <p id="buttons">
           <input id="submit" type="submit" tabindex="5" 
                value="Add Student">
        </p>
    </fieldset>
</form:form>
	
	
	
<!-- 	<table align="center" cellpadding="5" cellspacing="5"> -->

<%-- 		<form:form commandName="student" action="registration" method="post"> --%>
<%-- 			<%-- 		<form:form modelAttribute="student" action="registration" method="post"> --%> -

<%-- 			<form:errors path="*" /> --%>


<!-- 			<tr> -->
<!-- 				<td><label for="id">ID</label></td> -->
<%-- 				<td><form:input path="id" /></td> --%>
<%-- 				<form:errors path="id" /> --%>
<!-- 			</tr> -->

<!-- 			<tr> -->
<!-- 				<td><label for="firstName">FirstName</label></td> -->
<%-- 				<td><form:input path="firstName" /></td> --%>
<%-- 				<form:errors path="firstName" /> --%>
<!-- 			</tr> -->


<!-- 			<tr> -->
<!-- 				<td><label for="lastName">LastName</label></td> -->
<%-- 				<td><form:input path="lastName" /></td> --%>
<%-- 				<form:errors path="lastName" /> --%>
<!-- 			</tr> -->


<!-- 			<tr> -->
<!-- 				<td><label for="email">EMAIL</label></td> -->
<%-- 				<td><form:input path="email" /></td> --%>
<%-- 				<form:errors path="email" /> --%>
<!-- 			</tr> -->


<!-- 			<!-- 			<tr> --> 
<%-- 			<%-- 				<td><form:label path="gender">Gender</form:label></td> --%> 
<%-- 			<%-- 				<td><form:input path="gender" /></td> --%> 
<%-- 			<%-- 				<form:errors path="gender" /> --%> 
<!-- 			<!-- 			</tr> --> 


<!-- 			<!-- 			<tr> --> 
<%-- 			<%-- 				<td><form:label path="birthday">Birthday</form:label></td> --%> 
<%-- 			<%-- 				<td><form:input path="birthday" /></td> --%> 
<%-- 			<%-- 				<form:errors path="birthday" /> --%>
<!-- 			<!-- 			</tr> --> 




<!-- 			<input type="submit" id="submit" value="Submit" /> -->

<%-- 		</form:form> --%>
<!-- 	</table> -->

</body>
</html>