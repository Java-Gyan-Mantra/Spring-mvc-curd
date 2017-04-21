<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	<h1>${response}</h1>
	<form action="${pageContext.request.contextPath}/update.aspx">
		<table align="center">
			<tr>
				<td>UserId :</td>
				<td><input type="text" name="userId"
					value="${registrationModel.userId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>FirstName :</td>
				<td><input type="text" name="firstName"
					value="${registrationModel.firstName}"></td>
			</tr>
			<tr>
				<td>LastName :</td>
				<td><input type="text" name="lastName"
					value="${registrationModel.lastName}"></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="userName"
					value="${registrationModel.userName}"></td>
			</tr>
			<tr>
				<td>Mobile :</td>
				<td><input type="text" name="phone"
					value="${registrationModel.phone}" pattern="[7-8][0-9]{9}"></td>
			</tr>
			<tr>
				<td>Email id :</td>
				<td><input type="text" name="emailId"
					value="${registrationModel.emailId}"></td>
			</tr>
			<tr>
				<td>Location :</td>
				<td><input type="text" name="location"
					value="${registrationModel.location}" required></td>
			</tr>
		</table>
		<center>
			<input type="submit" value="UPDATE">
		</center>
	</form>
</body>
</html>