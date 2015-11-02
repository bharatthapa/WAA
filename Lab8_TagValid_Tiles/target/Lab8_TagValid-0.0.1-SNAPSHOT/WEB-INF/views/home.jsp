<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
<title>Home</title>
</head>
<body>
	<h2>Tiles Demo</h2>
	<a href="hello">Hello Spring</a> |
	<a href="contact">Contact</a>
	<br/>
	<br/>
	<h2>Internationalization</h2>
	<a href="?language=en">en</a>|
	<a href="?language=np">np</a>
	<h2>
		<spring:message code="greeting" />
	</h2>

	<p>

		<button
			onclick="window.location='<spring:url value="/registration" />' ">
			<spring:message code="studentRegistration" />
		</button>

	</p>
</body>
</html>
