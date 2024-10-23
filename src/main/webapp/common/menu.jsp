<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	#menuList {
		margin: 0px 70px 70px 70px;
	}
		
	.menuButton {
		font-size: 1.5em;
		border: 2px solid #383838;
		border-radius: 30px;
		background-color: white;
		padding: 10px 20px;
		margin: 15px 0;
	}
	
	.selectdMenu {
		background-color: #383838;
		color: white;
	}
</style>
<body>
	<div id="menuList" class="d-flex flex-column">
		<button class="menuButton selectdMenu">연습생 관리</button>
		<button class="menuButton">데뷔조 관리</button>
		<button class="menuButton">케어 관리</button>
		<button class="menuButton">케어 기록</button>
		<button class="menuButton">수업 관리</button>
		<button class="menuButton">수업 기록</button>
	</div>
</body>
</html>