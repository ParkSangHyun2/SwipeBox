<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>login</title>
<h1>로그인</h1>
</head>
<body>

	<form name="login"  method="post" action="./login">
		 <input type="hidden" name="prevPage" value="${prevPage }"> 
			<table>
 				<tr style="height: 100px;">
					<td align="center" colspan="2"><a href="./logout.do"><img src="../images/logo.jpg"></a></td>
				</tr>
				<tr><td  colspan="2" height="5"></td></tr>
				<c:if test="${fail==1 }">
				<tr>
					<td colspan="2"><font color="red">☆ 현재 입력하신 아이디가 등록되어 있지 않거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다. </font></td>				
				</tr>
				<tr><td  colspan="2" height="3"></td></tr>		
				</c:if>
				
				 <tr>
					<td colspan="2"><input type="text" name="id" value='' size='20'
						placeholder="아이디" title="아이디 입력 편집창" style="width: 366px; height: 34px;"></td>
				</tr>
				
				<tr><td  colspan="2" height="3"></td></tr>
				<tr>
					<td colspan="2"><input type="password" name="passwd" value='' size='20'
						placeholder="비밀번호" title="비밀번호 입력 편집창" style="width: 366px; height: 34px;"></td>
				</tr>
				
				<tr><td  colspan="2" height="6"></td></tr>
				
				<tr  style="height: 34px;">
					<td><input type="checkbox" id="inpSaveId" class="input_check" >아이디 저장</td>					
					<td align="right" ><a href="#" title="아이디 찾기" class="first_child">아이디 찾기</a>&nbsp;|&nbsp;				
						<a href="#" title="비밀번호 찾기">비밀번호 찾기</a>&nbsp;|&nbsp;				
						<a href="./member" title="회원가입">회원가입</a>
					</td>
				</tr>
				
				<tr><td  colspan="2" height="6"></td></tr> 
				
				<tr>
					<td  colspan="2" align="center">
					<input type='submit' value='로그인' style="width: 366px; height: 34px;"> 
					<!-- <input type="button" id="btnLogin"  style="width: 366px; height: 34px;" title="로그인 " value='로그인' onclick="loginCheck(this.form)"> -->
					</td>
				</tr>
				
			
				<tr><td  colspan="2" height="30"></td></tr>
				<tr><td colspan="2"> 
						<a href="#"  title="이용약관">이용약관</a>&nbsp;|&nbsp;
          				<a href="#" title="개인정보처리방침"><strong>개인정보처리방침</strong></a>&nbsp;|&nbsp;
          				<a href="#" title="청소년보호정책">청소년보호정책</a>&nbsp;|&nbsp;
          				<a href="#" title="고객센터">고객센터</a>&nbsp;   </td></tr> 
          		
          		
			</table>			

	
	</form>


</body>
</html>