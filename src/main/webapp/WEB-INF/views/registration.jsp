<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
p {
	text-align: center;
	color: green;
	font-style: italic;
	font-size: 30px;
}

#error {
	color: red;
}

h1 {
	text-align: center;
	color: blue;
}

#upperHead {
	text-align: center;
	color: navy;
	background: lavender;
}

#deleteResponse {
	text-align: center;
	color: red;
	font-style: italic;
	font-size: 20px;
}
</style>
<title>Registration Page</title>
</head>
<body>
	<h1>Registration Page</h1>

	<form:form
		action="${pageContext.request.contextPath}/saveRegistration.aspx"
		modelAttribute="registrationForm">
		<table align="center">
			<tr>
				<td>FirstName :</td>
				<td><form:input path="firstName" /></td>
				<td id="error"><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>LastName :</td>
				<td><form:input path="lastName" /></td>
				<td id="error"><form:errors path="lastName" /></td>

			</tr>
			<tr>
				<td>UserName :</td>
				<td><form:input path="userName" /></td>
				<td id="error"><form:errors path="userName" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
				<td id="error"><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>ConfirmPassword :</td>
				<td><form:input path="confirmPassword" /></td>
				<td id="error"><form:errors path="confirmPassword" /></td>
			</tr>
			<tr>
				<td>Email Id :</td>
				<td><form:input path="emailId" /></td>
				<td id="error"><form:errors path="emailId" /></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><form:input path="phone" /></td>
				<td id="error"><form:errors path="phone" /></td>
			</tr>
			<tr>
				<td>Location :</td>
				<td><form:input path="location" /></td>
				<td id="error"><form:errors path="location" /></td>
			</tr>
		</table>
		<center>
			<input type="submit" value="REGISTER">
		</center>
	</form:form>
</body>
</html>