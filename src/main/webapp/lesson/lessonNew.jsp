<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
	#title {
		font-size: 2.5em;
		font-weight: bold;
		margin-bottom: 40px;
	}
	
	#tra, #sub, #ti {
		width: 80%;
		border: 1px solid #383838;
		border-radius: 20px;
		padding: 20px;
		margin: 10px 0;
		font-size: 1.5em;
	}
	
	#msg {
		color: #d62828;
	}
</style>
<body>
	<form action="lessons/save" method="post" id="f1" class="d-flex flex-column justify-content-center align-items-center h-100">
		<h3 id="title">새 수업 정보 등록</h3>
		<input type="text" placeholder="선생님 성함을 입력해주세요." id="tra" name="trainer">
		<input type="text" placeholder="수업 과목을 입력해주세요." id="sub" name="subject">
		<input type="number" placeholder="총 수업 시간을 입력해주세요." id="ti" name="time">
		<div id="msg"></div>
		<div id="modalButtons">
			<button id="saveButton" type="button" onclick="checkInput()">추가</button>
			<button id="closeButton" type="button">닫기</button>
		</div>
	</form>
</body>
<script>
	function checkInput() {
		const trainer = document.getElementById("tra").value;
		const subject = document.getElementById("sub").value;
		const time = document.getElementById("ti").value;
		const form = document.getElementById("f1");

		if (trainer.trim() == "") {
			msg.innerText = "선생님 성함을 입력해주세요.";
		} else if (subject.trim() == "") {			
			msg.innerText = "수업명을 입력해주세요.";
		} else if (time.trim() == "") {
			msg.innerText = "총 수업 시간을 입력해주세요.";
		} else {
			form.submit();
		}
	}
</script>
</html>