<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>

<style>/* 
body {font-family: Arial, Helvetica, sans-serif;} */
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif;
}

form {
	border: 3px solid #f1f1f1;
}

.w3-sidebar {
	z-index: 3;
	width: 250px;
	top: 43px;
	bottom: 0;
	height: inherit;
}

div.c {
	position: absolute;
	right: 50px;
	width: 200px;
	height: 120px;
}

.fa {
	font-size: 50px;
	cursor: pointer;
	user-select: none;
}

.fa:hover {
	color: darkblue;
}

.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #4CAF50;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ff0000;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

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

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: red;
	color: white;
	text-align: center;
}
</style>
</head>
<body>
	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-theme w3-top w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1"
				href="javascript:void(0)" onclick="w3_open()"><i
				class="fa fa-bars"></i></a> <a href="#"
				class="w3-bar-item w3-button w3-theme-l1">Professional
				Networking</a>
			<!--  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Values</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">News</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>-->
			<div class="c">
				<a href="api/user/login"
					class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Login
				</a> <a href="/api"
					class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Register</a>
			</div>
		</div>
	</div>
	<!-- Sidebar -->
	<nav
		class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left"
		id="mySidebar">
		<a href="javascript:void(0)" onclick="w3_close()"
			class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large"
			title="Close Menu"> <i class="fa fa-remove"></i>
		</a>
		<h4 class="w3-bar-item">
			<b>Menu</b>
		</h4>
		<a class="w3-bar-item w3-button w3-hover-black" href="#">About </a> <a
			class="w3-bar-item w3-button w3-hover-black" href="#">Values</a> <a
			class="w3-bar-item w3-button w3-hover-black" href="#">Contact</a> <a
			class="w3-bar-item w3-button w3-hover-black" href="#">Partners</a>
	</nav>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large" onclick="w3_close()"
		style="cursor: pointer" title="close side menu" id="myOverlay"></div>
	<br>
	<br>
	<br>

	<h2 align="center">Login Form</h2>

	<br>

	<hr class="w3-clear">
	<%-- <div class="content">
		<button class="w3-bar-item w3-button tablink w3-green"
			onclick="oepnForm(event,'personal')">Personal Details</button>
		<button class="w3-bar-item w3-button tablink"
			onclick="oepnForm(event,'education')">Educational Details</button>

	</div>

		<div class="container">
			<div class="form-group">
				<div id="personal" class="w3-container w3-border tab">
					<form action="/api/login" method='post'>

						<label for="exampleInputEmail1">User Name</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter Email"
							name="username">
				
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password" name="password">
				</div>

				<div class="container" style="background-color: #f1f1f1">
					<button type="submit">Login</button>
					<button type="button" class="cancelbtn">Cancel</button>
					<span class="psw">Forgot <a href="#">password?</a></span>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<c:if test="${not empty errorMessge}">
					<div class="card-footer text-danger">${errorMessge}</div>
				</c:if>
				</form>
				</div>
			</div>
		</div>


		<!-- educational details form -->
		<hr class="w3-clear">
		<div class="content">
			<div class="container">
				<div id="education" class="w3-container w3-border tab"
					style="display: none">
					<form action="/api/login" method='post'>
						<div class="form-group">
							<label for="exampleInputEmail1">User Name</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="Enter Email"
								name="username">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password" name="password">
						</div>

						<div class="container" style="background-color: #f1f1f1">
							<button type="submit">Login</button>
							<button type="button" class="cancelbtn">Cancel</button>
							<span class="psw">Forgot <a href="#">password?</a></span>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<c:if test="${not empty errorMessge}">
							<div class="card-footer text-danger">${errorMessge}</div>
						</c:if>
					</form>
				</div>
			</div> --%>
	<!-- 	****************************************old -->
	<%-- 	<div class="content">
		<div class="tab">
			<input type="radio" class="tablinks active" onclick="openCity(event, 'Professional')" name="type" checked="checked">Professional
			<input type="radio" class="tablinks" name="type" onclick="openCity(event, 'Company')">Company
		</div>
		<div id="Professional" class="tabcontent">
			<div class="container">
				<h3 style="color: red;">
					<c:out value="${error}"></c:out>
				</h3>

				<form action="/api/login" method='post'>
					<div class="form-group">
						<label for="exampleInputEmail1">User Name</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter Email"
							name="username">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password" name="password">
					</div>

					<div class="container" style="background-color: #f1f1f1"><button type="submit">Login</button>
						<button type="button" class="cancelbtn">Cancel</button>
						<span class="psw">Forgot <a href="#">password?</a></span>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						<c:if test="${not empty errorMessge}">
						<div class="card-footer text-danger">${errorMessge}</div>
					</c:if>
				</form>

				<form:form action="/api/login" modelAttribute="loginUser"
					method="post">

					<div class="form-group">
						<label for="uname"><b>Email-Id</b></label>
						<form:input type="text" path="username"
							placeholder="Enter Email Id" name="username" />
						<br> <label for="psw"><b>Password</b></label>
						<form:input type="password" path="password"
							placeholder="Enter Password" name="password" />

						<button type="submit">Login</button>
						<label> <input type="checkbox" checked="checked"
							name="remember"> Remember me
						</label>
					</div>

					<div class="container" style="background-color: #f1f1f1">
						<button type="button" class="cancelbtn">Cancel</button>
						<span class="psw">Forgot <a href="#">password?</a></span>
					</div>
				</form:form>
			</div>
		</div>
		<div id="Company" class="tabcontent" style="display: none">
			<div class="container">
				<form:form action="/login/user" modelAttribute="loginUser">


					<div class="container">
						<label for="uname"><b>Company-Id</b></label>
						<form:input type="text" path="email"
							placeholder="Enter company Id" />
						<br> <label for="psw"><b>Password</b></label>
						<form:input type="password" path="password"
							placeholder="Enter Password" />

						<button type="submit">Login</button>
						<label> <input type="checkbox" checked="checked"
							name="remember"> Remember me
						</label>
					</div>

					<div class="container" style="background-color: #f1f1f1">
						<button type="button" class="cancelbtn">Cancel</button>
						<span class="psw">Forgot <a href="#">password?</a></span>
					</div>
				</form:form>
			</div>

		</div>
		<div class="footer">
			<!--  <div class="w3-container w3-theme-l2 w3-padding-32">
      <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Login</a>
    </div>-->
			<div class="w3-container w3-theme-l1">
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">TechnoCrats</a>
				</p>
			</div>
		</div>
	</div> --%>
	
	<div class="content">
		<div class="tab">
			<button class="tablinks" onclick="openCity(event, 'Professional')">Professional</button>
			<button class="tablinks" onclick="openCity(event, 'Company')">Company</button>
		</div>
		<div id="Professional" class="tabcontent">
			<div class="container">
				<h3 style="color: red;">
					<c:out value="${error}"></c:out>
				</h3>


				<c:if test="${not empty errorMessge}">
					<div class="card-footer text-danger">${errorMessge}</div>
				</c:if>
				<div class="container">
					<label for="uname"><b></b></label>
					<form action="/api/login" method='post'>
						<div class="form-group">
							<label for="exampleInputEmail1">User Email</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="Enter Email"
								name="username">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password" name="password">
						</div>

						<div class="container" style="background-color: #f1f1f1">
							<button type="submit">Login</button>
							<button type="button" class="cancelbtn">Cancel</button>
							<span class="psw">Forgot <a href="#">password?</a></span>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

					</form>
				</div>
			</div>
			<div id="Company" class="tabcontent">
				<div class="container">
					<form:form action="/login/user" modelAttribute="loginUser">


						<div class="container">
							<label for="uname"><b>Company-Id</b></label>
							<form:input type="text" path="email"
								placeholder="Enter company Id" />
							<br> <label for="psw"><b>Password</b></label>
							<form:input type="password" path="password"
								placeholder="Enter Password" />

							<button type="submit">Login</button>
							<label> <input type="checkbox" checked="checked"
								name="remember"> Remember me
							</label>
						</div>

						<div class="container" style="background-color: #f1f1f1">
							<button type="button" class="cancelbtn">Cancel</button>
							<span class="psw">Forgot <a href="#">password?</a></span>
						</div>
					</form:form>
				</div>
			</div>
		</div>

		<div class="footer">
			<!--  <div class="w3-container w3-theme-l2 w3-padding-32">
      <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Login</a>
    </div>-->
			<div class="w3-container w3-theme-l1">
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">TechnoCrats</a>
				</p>
			</div>
		</div>
	</div>

	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}
		/* function oepnForm(evt, formName) {
			var i, x, tablinks;
			x = document.getElementsByClassName("tab");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < x.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" w3-green", "");
			}
			document.getElementById(formName).style.display = "block";
			evt.currentTarget.className += " w3-green";
		} */
	</script>
</body>
</html>