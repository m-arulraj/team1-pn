<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
</head>
<body>
<h1>Register form</h1>
	<form:form action="save" modelAttribute="user" >
		<table>
			<tbody>
				<tr>
					<td>name :</td>
					<td><form:input path="name" type="text"/></td>
				</tr>
				<tr>
					<td>email-id :</td>
					<td><form:input path="email" type="text" /></td>
				</tr>
				<tr>
					<td>Date-of-Birth :</td>
					<td><form:input path="name" type="date" /></td>
				</tr>
				<tr>
					<td>phone number :</td>
					<td><form:input path="phone" type="number" /></td>
				</tr>
				
				<tr>
					<td>phone number :</td>
					<td><form:input path="gender" type="text" /></td>
				</tr>
				<tr>
					<td>country :</td>
					<td><form:input path="country" type="text" /></td>
				</tr>
				<tr>
					<td>state :</td>
					<td><form:input path="state" type="text" /></td>
				</tr>
				<tr>
					<td>password :</td>
					<td><form:input path="password" type="password" /></td>
				</tr>
				<tr><td><input type="submit">submit</td></tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>