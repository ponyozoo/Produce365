<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<style>
	#title {
		font-size: 2.5em;
		font-weight: bold;
		margin-bottom: 50px;
	}
	
	#f2 select {
		width: 60%;
		padding: 15px 20px;
		margin: 10px 0;
		font-size: 1.3em;
	}
	
	#msg {
		color: #d62828;
	}
</style>
<body>
	<form action="lessonHistory/save" method="post" id="f2" class="d-flex flex-column justify-content-center align-items-center h-100 my-5">
		<h3 id="title">수업 기록 추가</h3>
		<select id="selectLesson" class="form-select" name="subject">
			<c:if test="${!empty lessons}">	
				<c:forEach var="lesson" items="${lessons}">
					<option value="${lesson.id}">${lesson.subject}</option>
				</c:forEach>
			</c:if>
			<c:if test="${empty lessons}">
				<option value="0">수업이 없습니다.</option>
			</c:if>
		</select> 
		<select id="selectTrainee" class="form-select" name="trainee">
			<c:if test="${!empty trainees}">
				<c:forEach var="trainee" items="${trainees}">
					<option value="${trainee.id}">${trainee.name}</option>						
				</c:forEach>
			</c:if>
			<c:if test="${empty trainees}">
				<option value="0">연습생이 없습니다.</option>
			</c:if>
		</select> 
		<input type="date" name="lessonDate" id="historyDate">
		<div id="msg"></div>
		<div id="modalButtons">
			<button id="saveButton" type="button" onclick="checkInput()">추가</button>
			<button id="closeButton" type="button">닫기</button>
		</div>
	</form>
</body>

<script>
	function checkInput() {
		const form = document.getElementById("f2");
		const lesson = document.getElementById("selectLesson").value;
		const trainee = document.getElementById("selectTrainee").value;
		const date = document.getElementById("historyDate").value;
		
		if (lesson == "0") {
			msg.innerText = "수업을 선택해주세요.";			
		} else if (trainee == "0") {
			msg.innerText = "연습생을 선택해주세요.";			
		} else if(date == ""){
			msg.innerText = "올바른 날짜를 입력해주세요.";
		} else {
			form.submit();
		}
	}
</script>
</html>