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

<title>Insert title here</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
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
					class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Logout
				</a>
			</div>
		</div>
	</div>
	<!-- Sidebar -->

	<br>
	<br>

	<div class="content">
		<div class="container">
			<h2>Your Profile</h2>
			<br> Name : <br> <br> Email id : <br> <br> Gender :<br> <br> Date of Birth : <br> <br> Phone Number : <br> <br> Country : <br> <br> State :<br>


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
	</script>
</body>
</html>