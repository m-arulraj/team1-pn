<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-green.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>comment page</title>
</head>
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
	<!-- Left Column -->
	<div class="w3-col m3">
		<!-- Profile -->
		<div class="w3-card w3-round w3-white"></div>
		<br>



		<!-- End Left Column -->
	</div>
	<div class="w3-col m7">

<h2>Comments</h2>

		<div class="w3-container w3-card w3-white w3-round w3-margin">
			<br> user name

			<p>
				message : hai i am intrested to work in java <br> Comment
				Posted: 18/03/2019, 4:01:14 PM
			</p>

		</div>

		<div class="w3-container w3-card w3-white w3-round w3-margin">
			<br> user name

			<p>
				message : hai i am intrested to work in java <br> Comment
				Posted: 18/03/2019, 4:01:14 PM
			</p>

		</div>



		<div class="w3-container w3-card w3-white w3-round w3-margin">
			<br> user name

			<p>
				message : hai i am intrested to work in java <br> Comment
				Posted: 18/03/2019, 4:01:14 PM
			</p>
		</div>


		<!-- End Middle Column -->

		<footer>
			<form class="example" action="/api/post/comment">
				<input type="text" placeholder="Add comment" name="search2">
				<button type="submit">Add Comment
					<i class="fa-search"></i>
				</button>
			</form>
		</footer>
	</div>


</body>
</html>