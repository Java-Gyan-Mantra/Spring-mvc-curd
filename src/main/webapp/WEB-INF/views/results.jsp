<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
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

p {
	text-align: center;
	color: green;
	font-style: italic;
	font-size: 30px;
}

td {
	text-align: center;
	table-layout: auto;
	color: blue;
	border-spacing: 2px;
}
</style>
</head>
<body>
	<p>${response}</p>
	<p>${data}</p>
	<p id="deleteResponse">${deleteResponse}</p>
	<table align="center" border="2" cellpadding="2">
		<tr id="upperHead">
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Phone No</th>
			<th>Location</th>
		</tr>
		<c:forEach items="${users}" var="users">
			<tr>
				<td>${users.firstName}</td>
				<td>${users.lastName}</td>
				<td>${users.emailId}</td>
				<td>${users.phone}</td>
				<td>${users.location}</td>
				<%-- <td>${users.userId}</td> --%>
				<td><a
					href="${pageContext.request.contextPath}/edit.aspx?id=${users.userId}"><input
						type="submit" value="EDIT"></a></td>

				<td><a
					href="${pageContext.request.contextPath}/delete.aspx?id=${users.userId}"><input
						type="submit" value="DELETE"></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>