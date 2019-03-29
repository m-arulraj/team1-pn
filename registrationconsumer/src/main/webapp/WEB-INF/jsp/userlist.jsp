<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<title>List of users</title><meta charset="UTF-8"><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-green.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
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
<body>
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
   
	<a href="#" class="w3-bar-item w3-button w3-theme-l1">Professional Networking</a>
   <a href="/api/home" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Home</a>
    <!-- <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Values</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">News</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>--><div class="c">
				<a href="/logout"
					class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">logout</a>
			</div>
  </div>
</div>

<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">About </a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Values</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Contact</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Partners</a>
</nav>
<br><br><br>
<div class="w3-main" style="margin-left: 250px">

	
		<c:forEach items="${users}" var="user">
			<div class="w3-container w3-card w3-white w3-round w3-margin">
				<br> <img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKXahcKzJheYoAI9n-U3od3bfhj_LKhofGs-ONsU4GLVzwihkX"
					class="w3-circle" style="height: 50px; width: 50px" alt="Avatar">
				user name  :  "${user.getName()}"<br>
			</div>
		</c:forEach>
	</div>



	<div class="footer">

		<div class="w3-container w3-theme-l1">
			<center>
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">TechnoCrats</a>
				</p>
			</center>
		</div>
	</div>
</body>
</html>