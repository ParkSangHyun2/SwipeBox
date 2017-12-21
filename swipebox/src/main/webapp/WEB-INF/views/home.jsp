<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Swipebox Landing Page</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/materialize.css"
	type="text/css" rel="stylesheet" media="screen,projection" />
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
	<nav class="white" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="/project" class="brand-logo">Swipebox</a>
			<ul class="right hide-on-med-and-down">
				<li><a><i class="small material-icons">account_circle</i></a></li>
				<c:choose>
					<c:when test="${empty s_id}">
						<li><a href="./login">Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="./logout">Logout</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="./member">회원가입</a></li>
			</ul>

			<ul id="nav-mobile" class="side-nav">
				<c:choose>
					<c:when test="${empty s_id}">
						<li><a href="./login">Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="./logout">Logout</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="/project/list">Get Started</a></li>
			</ul>
			<a href="#" data-activates="nav-mobile" class="button-collapse"><i
				class="material-icons">menu</i></a>
		</div>
	</nav>

	<div id="index-banner" class="parallax-container">
		<div class="section no-pad-bot">
			<div class="container">
				<br> <br>
				<h1 class="header center teal-text text-lighten-2">Swipebox</h1>
				<div class="row center">
					<h5 class="header col s12 light">A cloud storage with
						user-friendly userinterface :: swipebox</h5>
				</div>
				<div class="row center">
					<a href="/project/list" id="download-button"
						class="btn-large waves-effect waves-light teal lighten-1">Get
						Started</a>
				</div>
				<br> <br>

			</div>
		</div>
		<div class="parallax">
			<img
				src="${pageContext.request.contextPath}/resources/background/box_background.jpg"
				alt="Unsplashed background img 1">
		</div>
	</div>


	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center brown-text">
							<i class="material-icons">archive</i>
						</h2>
						<h5 class="center">Archive Page</h5>

						<p class="light">We help animals of oblivion. swipbox keeps a
							record of all user actions (uploads, downloads, etc.) on the
							archive page. The archive page keeps records for up to seven
							days.</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center brown-text">
							<i class="material-icons">accessibility</i>
						</h2>
						<h5 class="center">User Experience Focused</h5>

						<p class="light">Swipebox is an accessible cloud storage that
							makes the user experience easier and more enjoyable.</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center brown-text">
							<i class="material-icons">work</i>
						</h2>
						<h5 class="center">Easy to work with Swipebox</h5>

						<p class="light">We provide specific documentation and
							specific examples for new users. It also provides feedback and
							answers to any questions the user may have about the swipe box.</p>
					</div>
				</div>
			</div>

		</div>
	</div>


	<div class="parallax-container valign-wrapper">
		<div class="section no-pad-bot">
			<div class="container">
				<div class="row center">
					<h5 class="header col s12 light"></h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img
				src="${pageContext.request.contextPath}/resources/background/file_background.jpg"
				alt="Unsplashed background img 2">
		</div>
	</div>

	<div class="container">
		<div class="section">
			<div class="row">
				<div class="col s12 center">
					<h4 class="center brown-text">
						<i class="mdi-content-send brown-text"></i>Contact Us
					</h4>
				</div>
				<div class="col s12 m4">
					<div class="card brown darken-1">
						<div class="card-content white-text">
							<span class="card-title">Minsu Han</span>
							<li>student_code: 20124170</li>
							<li>email: mshanObject@gmail.com</li>	
						</div>
						<div class="card-action">
							<a href="https://github.com/msHanObject">Github</a><a href="#">&emsp;Send E-mail</a>
						</div>
					</div>
				</div>
				<div class="col s12 m4">
					<div class="card brown darken-1">
						<div class="card-content white-text">
							<span class="card-title">Sanghyun Park</span>
							<li>student_code: 20124399</li>
							<li>email: pus5684@gmail.com</li>	
						</div>
						<div class="card-action">
							<a href="https://github.com/ParkSangHyun2/">Github</a><a href="#">&emsp;Send E-mail</a>
						</div>
					</div>
				</div>
				<div class="col s12 m4">
					<div class="card brown darken-1">
						<div class="card-content white-text">
							<span class="card-title">Byeongzin Hwang</span>
							<li>student_code: 20114334</li>
							<li>email: ghkdqudwls92@naver.com</li>	
						</div>
						<div class="card-action">
							<a href="https://github.com/">Github</a><a href="#">&emsp;Send E-mail</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="page-footer teal">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">Capstone2 Team No.3</h5>
					<p class="grey-text text-lighten-4">We are a college student
						team developing projects like Dropbox. The total working time is 5
						weeks and the development time is about 3 weeks. There are many
						drawbacks, but please understand.</p>
				</div>
			</div>
		</div>
	</footer>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/materialize.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/init.js"></script>

</body>
</html>
