<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<!-- Site Properties -->
<title>Swipebox login page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/semantic.min.css">

<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/form.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/transition.js"></script>

<style type="text/css">
body {
	background-color: #DADADA;
}

body>.grid {
	height: 100%;
}

.image {
	margin-top: -100px;
}

.column {
	max-width: 450px;
}
</style>
<script>
	$(document).ready(function() {
		$('.ui.form').form({
			fields : {
				/*    email: {
				     identifier  : 'email',
				     rules: [
				       {
				         type   : 'empty',
				         prompt : 'Please enter your e-mail'
				       },
				       {
				         type   : 'email',
				         prompt : 'Please enter a valid e-mail'
				       }
				     ]
				   }, */
				password : {
					identifier : 'password',
					rules : [ {
						type : 'empty',
						prompt : 'Please enter your password'
					}, {
						type : 'length[6]',
						prompt : 'Your password must be at least 6 characters'
					} ]
				}
			}
		});
	});
</script>
</head>
<body>

	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<h2 class="ui black image header">
				<img
					src="${pageContext.request.contextPath}/resources/img/swipe_logo.png"
					class="image">
				<div class="content">Log-in to your account</div>
			</h2>
			<form class="ui large form" name="login" method="post"
				action="./login">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input type="text" name="id"
								placeholder="User ID">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="password" name="passwd"
								placeholder="Password">
						</div>
					</div>
					<div class="ui fluid large black submit button" >Login</div>
					<!-- <button class="ui button" type="submit">Login</button> -->
				</div>

				<div class="ui error message"></div>

			</form>

			<div class="ui message">
				New to us? <a href="./member">Sign Up</a>
			</div>
			<div>
				<c:if test="${fail==1 }">
					<div class="ui negative message">
						<i class="close icon"></i>
						<div class="header">로그인 오류</div>
						<p>아이디 또는 비밀번호를 잘못 입력하셨습니다.</p>
					</div>
				</c:if>
			</div>
		</div>
	</div>

</body>

</html>
