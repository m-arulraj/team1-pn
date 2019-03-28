<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<title>Professional Networking</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
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
</style>
<body class="w3-theme-l5">

	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-theme-d2 w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2"
				href="javascript:void(0);" onclick="openNav()"><i
				class="fa fa-bars"></i></a> <a href="#"
				class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i
				class="fa fa-home w3-margin-right"></i>Professional Networking</a>
			<!--<a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="News"><i class="fa fa-globe"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Account Settings"><i class="fa fa-user"></i>profile</a>-->

			<a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"></i>About
				Us</a> <a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"></i>contact</a>
			<a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white">Log
				out</a>
		</div>
	</div>

	<!-- Navbar on small screens -->
	<div id="navDemo"
		class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">My
			Profile</a>
	</div>

	<br>
	<br>
	<br>
	<form class="example" action="/action_page.php"
		style="margin: auto; max-width: 300px">
		<input type="radio" name="gender" value="name" checked> Name <input
			type="radio" name="gender" value="female"> Email-id <input
			type="radio" name="gender" value="other"> Skill <input
			type="text" placeholder="Search.." name="search2">
		<button type="submit">
			<i class="fa fa-search"></i>
		</button>
	</form>
	<!-- Page Container -->
	<div class="w3-container w3-content"
		style="max-width: 1400px; margin-top: 30px">
		<!-- The Grid -->
		<div class="w3-row">
			<!-- Left Column -->
			<div class="w3-col m3">
				<!-- Profile -->
				<div class="w3-card w3-round w3-white">
					<div class="w3-container">
						<h4 class="w3-center">My Profile</h4>
						<p class="w3-center">
							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKXahcKzJheYoAI9n-U3od3bfhj_LKhofGs-ONsU4GLVzwihkX"
								class="w3-circle" style="height: 106px; width: 106px"
								alt="Avatar">
						</p>
						<hr>
						<p>
							<i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i>
							java Developer
						</p>
						<p>
							<i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i>
							Chennai,India
						</p>
						<p>
							<i
								class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i>
							December 12, 1992
						</p>
						<p>
							<a class="w3-button w3-border w3-center" href="profile">Edit
								profile</a>
						</p>
					</div>
				</div>
				<br>
				<!-- Alert Box -->
				<div
					class="w3-container w3-display-container w3-round w3-theme-l4 w3-border w3-theme-border w3-margin-bottom w3-hide-small">
					<span onclick="this.parentElement.style.display='none'"
						class="w3-button w3-theme-l3 w3-display-topright"> <i
						class="fa fa-remove"></i>
					</span>
					<p>
						<strong>Hey!</strong>
					</p>
					<p>People are looking at your profile. Find out who.</p>
				</div>

				<!-- End Left Column -->
			</div>

			<!-- Middle Column -->
			<div class="w3-col m7">
				<form class="example" action="/action_page.php">
					<input type="text" placeholder="Add Post" name="search2">
					<button type="submit">
						Add Post <i class="fa-search"></i>
					</button>
				</form>
				<c:forEach items="${allPost}" var="post">
					<div class="w3-container w3-card w3-white w3-round w3-margin">
						<br> <img
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKXahcKzJheYoAI9n-U3od3bfhj_LKhofGs-ONsU4GLVzwihkX"
							class="w3-circle" style="height: 50px; width: 50px" alt="Avatar">
						user name <br>name company

						<hr class="w3-clear">
						<p>         
							message : "${post.getMessage()}" <br> Job
							Posting: 18/03/2019, 4:01:14 PM
						</p>
						<div class="w3-row-padding" style="margin: 0 -10px"></div>
						likes:10 &nbsp<i onclick="myFunction(this)"
							class="fa fa-thumbs-up"></i> <a href="/api/post/comment"
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
						message : hai i am intrested to work in java <br> Job
						Posting: 18/03/2019, 4:01:14 PM
					</p>
					<div class="w3-row-padding" style="margin: 0 -10px"></div>
					likes:10
					<button type="button"
						class="w3-button w3-theme-d1 w3-margin-bottom"
						onclick="location.href=' ';">like</button>
					&emsp; <a href="/api/post/comment"
						class="w3-button w3-theme-d2 w3-margin-bottom">comment</a>
				</div>


				<!-- End Middle Column -->
			</div>

			<!-- Right Column -->


			<!-- End Grid -->
		</div>

		<!-- End Page Container -->
	</div>
	<br>

	<!-- Footer -->

	<footer class="w3-container w3-theme-d5">
		<center>
			<p>Powered by -TechnoCrats</p>
		</center>
	</footer>

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
		function openNav() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>

</body>
</html>
