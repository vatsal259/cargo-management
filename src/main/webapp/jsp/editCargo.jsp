<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Cargo</title>
</head>
<body>

	<form:form action="update" modelAttribute="cargo">

		<form:hidden path="cargoId" />
	
Cargo ID : <form:input path="cargoId" />
		<br>
		<br>
			
Cargo Type : <form:input path="cargoType" />
		<br>
		<br>

Cargo Issuer : <form:input path="cargoIssuer" />
		<br>
		<br>
		<input type="submit" value="Update Cargo">

	</form:form>
	<br>
	<a style="color:black; text-decoration:none;" href="viewAllCargo">ViewAllCargo </a>

</body>
</html>