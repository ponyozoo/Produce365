<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>수업기록추가</title>
<jsp:include page="/common/link.jsp" />
</head>
<body>
	<h3>수업 기록 추가</h3>
	<form action="insert" method="post" id="f2">
		<select class="form-select" name="subject">
			<c:forEach var="lesson" items="${lessons}" varStatus="status">
				<c:choose>
					<c:when test="${status.index == 0}">
						<option value="${lesson.id}" selected>${lesson.subject}</option>
					</c:when>
					<c:otherwise>
						<option value="${lesson.id}" selected>${lesson.subject}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> <select class="form-select" name="trainee">
			<c:forEach var="trainee" items="${trainees}" varStatus="status">
				<c:choose>
					<c:when test="${status.index == 0}">
						<option value="${trainee.id}" selected>${trainee.name}</option>
					</c:when>
					<c:otherwise>
						<option value="${trainee.id}" selected>${trainee.name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> <input type="date" name="lessonDate" id="lessonDate">
		<button type="button" class="btn" onclick="checkInput()">추가</button>
	</form>
</body>

<script>
	function checkInput() {
		const date = document.getElementById("lessonDate").value;
		const form = document.getElementById("f2");
		if (date.trim() == "") {
			alert("값을 입력해 주세요.");
		} else {
			form.submit();
		}
	}
</script>
</html>