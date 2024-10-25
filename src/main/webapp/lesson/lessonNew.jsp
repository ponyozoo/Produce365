<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레슨 등록</title>
<jsp:include page="/common/link.jsp" />
</head>
<body>
	<form action="save" method="post" id="f1">
		<h3>새 수업 정보 등록</h3>
		<input type="text" placeholder="선생님 성함을 입력해주세요." id="tra" name="trainer"></br>
		<input type="text" placeholder="수업 과목을 입력해주세요." id="sub" name="subject"></br>
		<input type="text" placeholder="수업 시간을 입력해주세요." id="ti" name="time"></br>
		<button type="button" onclick="checkInput()">추가</button>
	</form>
</body>
<script>
	function checkInput() {
		const trainer = document.getElementById("tra").value;
		const subject = document.getElementById("sub").value;
		const time = document.getElementById("ti").value;
		const form = document.getElementById("f1");

		if (trainer.trim() == "" || subject.trim() == "" || time.trim() == "") {
			alert("등록을 위한 값을 설정해 주세요.");
		} else {
			form.submit();
		}
	}
</script>
</html>