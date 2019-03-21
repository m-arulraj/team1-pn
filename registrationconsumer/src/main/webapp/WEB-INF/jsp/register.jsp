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
<%-- </head>
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
</body> --%>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 50%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}
.content {
height: 200px;
  position: relative;
  max-width: 600px;
  margin: auto;
   
}
img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
text-align: center;
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 50%;
  }
}
</style>
</head>
<body >
<div class="content">
<h2 align="center">Register Form</h2>

<form:form action="save" modelAttribute="user" >
  

  <div class="container">
  <br>
    <label for="psw"><b>Name</b></label>
    <form:input type="text" path="name" placeholder="Enter name"  />
    <br>
    <label for="uname"><b>Email-Id</b></label>
    <form:input type="text" path="email" placeholder="Enter Email Id"  />
    <br>
    <label for="psw"><b>Phone Number</b></label>
    <form:input type="text" path="phone" placeholder="Enter Phone Number"  />
	<br>
    <label for="psw"><b>Gender</b></label>
    <form:radiobutton  path="gender" value="m"  />Male
    <form:radiobutton  path="gender" value="f"  />Female
    <form:radiobutton  path="gender" value="o"  />others
    <br>
    
    <label for="psw"><b>Country</b></label>
    <form:input type="text" path="country" placeholder="Enter country"  />
    <br>
    <label for="psw"><b>State</b></label>
    <form:input type="text" path="state" placeholder="Enter state"  />
    <br>
    <label for="psw"><b>Password</b></label>
    <form:input type="password" path="password" placeholder="Enter Password"  />
    
    
    <button type="submit">Register</button>
   
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    
  </div>
</form:form>
</div>
</body>
</html>