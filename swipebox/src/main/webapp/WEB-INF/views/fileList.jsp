<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Swipebox file upload page</title>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html" />
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<style>
header {
	padding-top: 40px;
	padding-bottom: 20px;
	padding-left: 20px;
}

footer {
	border-top: 1px solid gray;
	padding: 20px;
	text-align: center;
}

.content {
	display: flex;
}

.content aside {
	display: flex;
	padding-top: 50px;
}

.content aside ul div {
	padding-bottom: 20px;
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
<link
	href="${pageContext.request.contextPath}/resources/css/materialize.css"
	type="text/css" rel="stylesheet" media="screen,projection" />
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet" media="screen,projection" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/semantic.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/dragAndDrop.css">
</head>

<body>
	<header>
		<div class="ui secondary pointing menu">
			<a class="ui header item" href="/project"
				style="font-size: 25px;">Swipebox</a>
			<div class="right menu">
				<a class="active item" style="color: #0080FD">${s_id} 's
					SwipeBox <a class="item" href="./logout">Logout</a> <a class="item">Help<i
						class="help icon"></i></a>
			</div>
	</header>
	<div class="container">
		<header>
			<h1 class="ui header">Home</h1>
		</header>
		<section class="content">
			<main>
			<table border="0" id="fileUpload" class="dragAndDropDiv">
				<thead>
					<tr>
						<th style="width: 5%;"></th>
						<th style="width: 30%;">이름</th>
						<th style="width: 30%;">수정된 날짜</th>
						<th style="width: 8%;">크기</th>
						<th style="width: 7%;">확장자</th>
						<th style="width: 10%;">다운로드</th>
						<th style="width: 10%;">옵션</th>
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
									<th>
										<div class="ui checkbox">
											<input type="checkbox" name="<filecheck></filecheck>">
											<label></label>
										</div>
									</th>
									<th style="font-size: 17px">${file.fileName}</th>
									<th style="color: #F0008F">${file.regDate}</th>
									<th>${file.fileSize}</th>
									<th>${file.fileType}</th>
									<th>
										<button class="ui primary button"
											onclick="location.href='/project/download?file=${file.fileUid}'">Download</button>
									</th>
									<th>
										<div class="ui icon top left pointing dropdown">
											<i class="ellipsis horizontal icon"></i>
											<div class="menu">
												<div class="header">Options</div>
												<div class="item">Rename</div>
												<div class="item">Copy</div>
												<div class="item"
													onclick="location.href='/project/delete?file=${file.fileUid}'">Delete</div>
											</div>
										</div>
									</th>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>

			</table>
			</main>
			<aside>
				<ul>
					<div>
						<form action="./fileUpload/directPost" method="post"
							enctype="multipart/form-data">
							<div class="ui grid">
								<div class="six wide column">
								<label for="file" class="ui primary icon submit button">
								<i class="file icon"></i>Select</label>
								<input type="file" id="file" name="fileUpload"
									style="display: none">
								</div>
								<div class="ten wide column">
								<button class="ui positive button" type="submit"><i class="cloud upload icon"></i>Upload</button>
								</div>
							</div>
						</form>
					</div>
					<div>
						<label class="ui icon button"><i class="folder icon"></i>New Folder</label>
					</div>
				</ul>
			</aside>
		</section>
		<footer>
			<a href="https://github.com/msHanObject/swipebox">Github Swipebox</a>
		</footer>
	</div>
	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/semantic.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/dragAndDrop.js"></script>
	<script>
		$('.ui.dropdown').dropdown();
		$('.ui.checkbox').checkbox({
			onChecked : function() {
				checked: 'checked'
			},
			onUnchecked : function() {
				checked: 'unchecked'
			}
		});
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
</body>

</html>
