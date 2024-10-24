<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	#logo {
		font-size: 2.5em;
		font-family: 'TAEBAEK';
		font-weight: bold;
		cursor: pointer;
	}
	
	#logout {
		font-size: 1.3em;
		padding: 7px 30px;
		border-radius: 30px;
		background-color: #383838;
		color: white;
		border: none;
	}
</style>
<body>
	<div class="container-fluid fixed-top d-flex justify-content-between align-items-center shadow bg-white px-4 py-3">
		<div id="logo" onclick="location.href='trainees'">PRODUCE365</div>
		<button type="button" id="logout" onclick="location.href='/produce365/logout'">로그아웃</button>
	</div>
</body>
</html>