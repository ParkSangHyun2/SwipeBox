<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>FileList</title>
<h1>My File List</h1>
</head>
<body>
	<table border="0">
		<thead>
			<tr>
				<th>이름</th>
				<th>크기</th>
				<th>확장자</th>
				<th>삭제</th>
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
							<th><a href="/project/download?file=${file.fullFileName}">다운로드</a></th>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</tbody>

	</table>

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
</body>
</html>