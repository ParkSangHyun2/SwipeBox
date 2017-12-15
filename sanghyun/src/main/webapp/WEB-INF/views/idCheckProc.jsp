<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="ko">
<meta charset="UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>idCheckProc.jsp</title>
</head>
<body>
<p>*아이디 중복 확인 결과 *</p>

<%
String id = request.getParameter("id").trim();
//int cnt = Integer.parseInt(request.getParameter("cnt")); 
out.println("입력 id:<strong>"+ id+"</strong>");
%>
<br>

<c:if test="${0 eq cnt}">
    <%
	out.println("사용할 수 있는 아이디 입니다");
	out.println("<a href = 'javascript:apply(\"" +id+ "\")'>[사용]</a>"); //"" 안에서 "사용하기 위해서 \" 사용 
	%>
</c:if>

<script>
function apply(id){

	opener.document.regForm.id.value = id;
	window.close();
}
</script>

<c:if test="${0 ne cnt}">
<% out.print("사용할 수 없는 아이디 입니다"); %>
<hr>
<a href="javascript:window.history.back()">[다시 검색]</a>
<a href="javascript:window.close()">[닫기]</a> 
</c:if>


 </body>
</html>