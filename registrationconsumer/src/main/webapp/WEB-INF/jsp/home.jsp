<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<title>Professional Networking</title>
<meta charset="UTF-8"><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
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
	.fa {
		font-size: 24px;
		cursor: pointer;
		user-select: none;
	}
	.fa:hover {
		color: darkblue;
	}
	form.example input[type=text] {
		padding: 10px;
		font-size: 17px;
		border: 1px solid grey;
		float: left;
		width: 80%;
		background: #f1f1f1;
	}
	form.example button {
		float: left;
		width: 20%;
		padding: 10px;
		background: #2196F3;
		color: white;
		font-size: 17px;
		border: 1px solid grey;
		border-left: none;
		cursor: pointer;
	}
	form.example button:hover {
		background: #0b7dda;
	}
	form.example::after {
		content: "";
		clear: both;
		display: table;
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
}
</style>
<body>
	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-theme w3-top w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1"
				href="javascript:void(0)" onclick="w3_open()"><i
				class="fa fa-bars"></i></a> <a href=""
				class="w3-bar-item w3-button w3-hide-small w3-hover-white">Professional
				Networking</a> <a href="profile/c"
				class="w3-bar-item w3-button w3-hide-small w3-hover-white">View
				Profile</a> <a href="profile"
				class="w3-bar-item w3-button w3-hide-small w3-hover-white">Update
				Profile</a>
			<!-- <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Values</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">News</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>-->
			<div class="c">
				<a href="/api/user/welcome"
					class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">logout</a>
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
	<!-- Middle Column -->
	<div class="w3-main" style="margin-left: 250px">
		<form class="example" action="/api/user/post/upost" method="post">
			<br> <br> <br> <input type="hidden" name="email" value="${email}" ></input><input type="text"
				placeholder="Add Post" name="message" /> <button class="w3-button w3-theme-d2 w3-margin-bottom"type ="submit">Add Post</button>
		</form>

		<c:forEach items="${listPost}" var="post" >
			<div class="w3-container w3-card w3-white w3-round w3-margin">
				<br> <img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKXahcKzJheYoAI9n-U3od3bfhj_LKhofGs-ONsU4GLVzwihkX"
					class="w3-circle" style="height: 50px; width: 50px" alt="Avatar">
				user name <br>name company

				<hr class="w3-clear">
				<p>
					message : "${post.getMessage()}"
					date:"${post.getDate()}"
				</p>
				<div class="w3-row-padding" style="margin: 0 -10px"></div>
				likes:10 &nbsp&nbsp &nbsp<i onclick="myFunction(this)"
					class="fa fa-thumbs-up"></i> &emsp; <a href="/api/post/comment"
					class="w3-button w3-theme-d2 w3-margin-bottom">comment</a>
			</div>
		</c:forEach>



		<div class="w3-container w3-card w3-white w3-round w3-margin">
			<br> <img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKXahcKzJheYoAI9n-U3od3bfhj_LKhofGs-ONsU4GLVzwihkX"
				class="w3-circle" style="height: 50px; width: 50px" alt="Avatar">
			user name <br>name company

			<hr class="w3-clear">
			<p>
				message : hai i am intrested to work in java <br> Job Posting:
				18/03/2019, 4:01:14 PM
			</p>
			<div class="w3-row-padding" style="margin: 0 -10px"></div>
			likes:10<i onclick="myFunction(this)" class="fa fa-thumbs-up"></i>
			&emsp; <a href="/api/post/comment"
				class="w3-button w3-theme-d2 w3-margin-bottom">comment</a>
		</div>


		<!-- End Middle Column -->
	</div>



	<br>

	<!-- Footer -->

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

	<script>
		// Accordion
		function myFunction(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-theme-d1";
			} else {
				x.className = x.className.replace("w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-theme-d1", "");
			}
		}
		function myFunction(x) {
			x.classList.toggle("fa-thumbs-down");
		}
		// Used to toggle the menu on smaller screens when clicking on the menu button
	</script>

</body>
</html>
