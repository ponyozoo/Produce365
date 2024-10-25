<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>케어기록</title>
<jsp:include page="/common/link.jsp" />
</head>
<body>
	<form action="selectAll" method=post>
		<input type='button' class='btn' name='btn' value='추가하기'
			style="float: right;" onclick="location.href='input'">
		<c:if test="${!empty careHistories}">
			<table class="table table-bordered">
				<c:forEach var="careHistory" items="${careHistories}">
					<tr>
						<!-- careHistory클래스의 이름과 동일하게 해야함 -->
						<td>${careHistory.idx}</td>
						<td>${careHistory.careDate}</td>
						<td>${careHistory.care.category}</td>
						<td>${careHistory.trainee.name}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
</body>
</html>