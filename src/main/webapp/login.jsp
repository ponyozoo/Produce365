<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<jsp:include page="/common/link.jsp" />
</head>
<style>
	#logo {
		font-size: 5em;
		font-family: 'TAEBAEK';
		font-weight: bold;
	}
	
	form {
		width: 40%;
		margin-top: 70px;
	}
	
	input {
		width: 100%;
		border: 1px solid #383838;
		border-radius: 20px;
		padding: 20px;
		margin: 10px 0;
		font-size: 1.5em;
	}
	
	#msg {
		color: #d62828;
	}
	
	button {
		width: 30%;
		font-size: 2em;
		background-color: #383838;
		color: white;
		border: 0px;
		border-radius: 20px;
		padding: 10px 30px;
		margin-top: 70px;
	}
</style>
<body>
	<div class="d-flex flex-column align-items-center justify-content-center vh-100">
		<div id="logo">PRODUCE 365 </div>
		<form action="login" method="post" id="form" class="d-flex flex-column align-items-center">
			<input type="text" name="id" id="id" placeholder="아이디를 입력해주세요." />
			<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력해주세요." />
			<div id="msg">
				<c:if test="${!empty msg}">${msg}</c:if>
			</div>
			<button type="button" onClick="checkInput()">로그인</button>
		</form>
	</div>
</body>
<script>
	function checkInput() {
		const form = document.getElementById("form");
		const msg = document.getElementById("msg");
		const id = document.getElementById("id").value;
		const pw = document.getElementById("pw").value;
		
		if (id == "")
			msg.innerText = "아이디를 입력해주세요.";
		else if (pw == "")
			msg.innerText = "비밀번호를 입력해주세요.";
		else
			form.submit();
	}
</script>
</html>