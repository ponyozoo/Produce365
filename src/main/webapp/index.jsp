<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Produce365</title>
	<jsp:include page="/common/link.jsp" />
</head>
<style>
	#logo {
		font-size: 8em;
		font-family: 'TAEBAEK';
		font-weight: bold;
	}
	
	button {
		width: 10%;
		font-size: 2em;
		background-color: #383838;
		color: white;
		border: 0px;
		border-radius: 20px;
		padding: 10px 30px;
	}
</style>
<body>
	<div class="d-flex flex-column align-items-center justify-content-center vh-100" style="text-align: center;">
		<div id="logo">PRODUCE 365</div>
		<button type="button" onclick="location.href='/produce365/login'">로그인</button>
	</div>
</body>
</html>