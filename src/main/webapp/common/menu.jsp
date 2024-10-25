<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	#menuList {
		min-width: 400px;
		margin-top: 60px;
	}
		
	.menuButton {
		width: 50%;
		font-size: 1.5em;
		border: 2px solid #383838;
		border-radius: 30px;
		background-color: white;
		padding: 10px 20px;
		margin: 15px 0;
	}
	
	.selectedMenu {
		background-color: #383838;
		color: white;
	}
</style>
<body>
	<div id="menuList" class="d-flex flex-column align-items-center">
		<button id="trainees" class="menuButton" onclick="location.href='trainees'">연습생 관리</button>
		<button id="debuts" class="menuButton" onclick="location.href='debuts'">데뷔조 관리</button>
		<button id="cares" class="menuButton" onclick="location.href='cares'">케어 관리</button>
		<button id="careHistory" class="menuButton" onclick="location.href='careHistory'">케어 기록</button>
		<button id="lessons" class="menuButton" onclick="location.href='lessons'">수업 관리</button>
		<button id="lessonHistory" class="menuButton" onclick="location.href='lessonHistory'">수업 기록</button>
	</div>
	
	<script>
		const uri = window.location.pathname;
		const menu = uri.substring(uri.lastIndexOf("/") + 1);
		document.getElementById(menu).className += ' selectedMenu';
	</script>
</body>
</html>