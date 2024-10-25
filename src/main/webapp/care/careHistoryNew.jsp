<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>케어기록추가</title>
<jsp:include page="/common/link.jsp" />
</head>
<body>
	<h3>케어 기록 추가</h3>
	<form action="insert" method="post" id = "f2">
			<select class="form-select" name="category">
				<c:forEach var="care" items="${cares}" varStatus="status">
					<c:choose>
						<c:when test="${status.index == 0}">							
								<option value="${care.id}" selected>${care.category}</option>			
						</c:when>
						<c:otherwise>
							<option value="${care.id}" selected>${care.category}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			<select class="form-select" name="trainee">
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
			</select>
		<input type="date" name="careDate" id="careDate">
		<button type="button" class="btn" name="btn" onclick="checkInput()">추가</button>
	</form>
</body>

<script>
	function checkInput(){
	const date = document.getElementById("careDate").value;
	const form = document.getElementById("f2");
	if(date.trim() == ""){
		alert("값을 입력해 주세요");
	}else{
		form.submit();
	}
}
</script>
</html>