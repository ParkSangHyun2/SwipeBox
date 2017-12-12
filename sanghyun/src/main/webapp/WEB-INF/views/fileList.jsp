<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>flex_holygraillayout</title>
<meta charset="utf-8">

<style>

header {
	/*border-bottom:1px solid gray;*/
	padding-top: 40px;
	padding-bottom: 20px;
	padding-left: 20px;
}

footer {
	border-top: 1px solid gray;
	padding: 20px;
	text-align: center;
}

.container section table tbody tr th{
	flex-basis: 250px;
}
.content {
	display: flex;
}

.content nav {
	/*border-right:1px solid gray;*/
	
}

.content aside {
	/*border-left:1px solid gray;*/
	
}

nav, aside {
	flex-basis: 150px;
	flex-shrink: 0;
}

main {
	padding: 10px;
}
</style>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
<body>
	<nav class="white" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="http://swipebox.cf" class="brand-logo">Swipebox</a>
			<ul class="right hide-on-med-and-down">
				<li><a><i class="small material-icons">account_circle</i></a></li>
				<li>${s_id}</li>
				<li><a href="#">Login</a></li>
				<li><a href="#">MyFiles</a></li>
			</ul>

			<ul id="nav-mobile" class="side-nav">
				<li><a><i class="small material-icons">account_circle</i></a></li>
				<li><a href="#">Login</a></li>
				<li><a href="#">MyFiles</a></li>
			</ul>
			<a href="#" data-activates="nav-mobile" class="button-collapse"><i
				class="material-icons">menu</i></a>
		</div>
	</nav>
	<div class="container">
		<header>
			<h3 class="ui header">File List</h3>
		</header>
		<section class="content">
			<main>
			<table border="0">
				<thead>
					<tr>
						<th style="width:70%;">이름</th>
						<th style="width:10%;">크기</th>
						<th style="width:10%;">확장자</th>
						<th style="width:10%;">다운로드</th>
					</tr>
				</thead>

				<tbody>
					<c:choose>
						<c:when test="${empty userList}">
							<tr>
								<td colspan="4">파일이 없습니다</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="file" items="${userList}" varStatus="index">
								<tr>
									<th>${file.fileName}</th>
									<th>${file.fileSize}</th>
									<th>${file.fileType}</th>
									<th>
									<button class="ui primary button" onclick="location.href='/project/download?file=${file.fullFileName}'">Download</button>
									</th>
									<th>
									<button class="ui button" onclick="#">Delete</button>
									</th>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>

			</table>

			</main>
		</section>
		<footer>
			<a href="https://github.com/msHanObject/swipebox">Github Swipebox</a>
		</footer>
	</div>


	<script type="text/javascript">
		$("#downloadFilesBtn")
				.on(
						"click",
						function(e) {
							var fileId = $("#fileId").val();
							var version = $("#version").val();
							var url = "${pageContext.request.contextPath}/downloadFiles.do?fileId="
									+ fileId + "&rsVer=" + version;
							window.location = url;
						});
	</script>

	<!—  Scripts—>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/materialize.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/init.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/semantic.min.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/resources/js/semantic.min.js"></script>
</body>
</html>