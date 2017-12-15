<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>idCheckForm.jsp</title>
</head>
<body>
<p>*아이디 중복확인</p>

<form method="POST" action="./idcheck" onsubmit="return blankCheck(this)">
아이디번호: <input type="text" name="id" id="id" autofocus>
		<input type="submit" value="검색">

</form>

<script>
function blankCheck(f){
	var id = f.id.value;
	id = id.trim();
	if(id.length<1){
		alert("아이디 입력바람!!");
		f.id.focus();
		return false;
	}
	else{
	return true;
	}
	
}
</script>
</body>
</html>