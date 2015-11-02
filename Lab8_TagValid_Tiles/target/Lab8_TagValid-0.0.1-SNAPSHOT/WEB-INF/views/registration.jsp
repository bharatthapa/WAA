<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title><spring:message code="registration" /></title>
</head>
<body>
	<h1>
		<spring:message code="registrationForm" />
	</h1>
	<br />
	<form:form method="POST" commandName="student"
		enctype="multipart/form-data">
	Image: <form:input type="file" path="file"></form:input>
		<form:errors path="*" cssStyle="color : red;" />
		<table>

			<tr>
				<td><spring:message code="id" /></td>
				<td><form:input path="id" /> <form:errors path="id"
						cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="firstName" /></td>
				<td><form:input path="firstName" /> <form:errors
						path="firstName" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="lastName" /></td>
				<td><form:input path="lastName" /> <form:errors
						path="lastName" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="email" /></td>
				<td><form:input path="email" /> <form:errors path="email"
						cssStyle="color : red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="gender" /></td>
				<td><form:radiobutton path="gender" value="M" label="M" /> <form:radiobutton
						path="gender" value="F" label="F" /></td>
			</tr>
			<tr>
				<td><spring:message code="birthday" /></td>
				<td><form:input path="birthday" /> <form:errors
						path="birthday" cssStyle="color : red;" /></td>
			</tr>


			<tr>
				<td><spring:message code="phone" /></td>
			</tr>
			<tr>
				<td><spring:message code="area" /></td>
				<td><form:input path="phone.area" /> <form:errors
						path="phone.area" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="prefix" /></td>
				<td><form:input path="phone.prefix" /> <form:errors
						path="phone.prefix" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="number" /></td>
				<td><form:input path="phone.number" /> <form:errors
						path="phone.number" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value='<spring:message code="register" />'></td>
			</tr>
		</table>
	</form:form>








































</body>
</html>