<%@ page contentType="text/html; charset=UTF-8"%>

<div class="container-fluid bg-1 text-center">

<form name="regForm" action="./member" method="POST">
		<h3>SwipeBox 회원가입</h3>
		
		<table border="1" align="center" style="background-color:rgb(212,244,250); color:rgb(63,0,153);">
			<tr>
				<th colspan="2">회원가입</th>
			</tr>
			<tr>
				<th>아이디</th>
				<th><input type="text" name="id"></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><input type="text" name="passwd"></th>
			</tr>
			<tr>
				<th>이름</th>
				<th><input type="text" name="name"></th>
			</tr>
			<tr>
				<th>핸드폰 번호</th>
				<td><input type="text" name="tel" id="tel"></td>
				<!-- <td><input type="button" value="핸드폰 중복확인" onclick="PhoneCheck()"></td> -->
			</tr>
				<tr>
				<th>email</th>
				<td><input type="text" name="email"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입">
				</td>
			</tr>
		</table>
	</form>
	</div>

<!-- 
<script>
function PhoneCheck(){
	//아이디 중복확인
	var sx = parseInt(screen.width);
	var sy = parseInt(screen.height);
	var x = (sx/2)+50;
	var y = (sy/2)-25;
	
	var win = window.open("view/phoneCheckForm.jsp","idwin","width=400,height=350");
	//팝업창을 띄운다 (띄우는 주소, 띄우는 이름, 가로, 세로);
	
	win.moveTo(x,y);	//화면 이동
}
</script> -->

</body>
</html>