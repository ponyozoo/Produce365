<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수업기록</title>
<jsp:include page="/common/link.jsp" />
</head>
<body>
	<form action="insert" method="post">
		<input type="button" class="btn" name="btn" value="추가하기"
			style="float: right;" onclick="location.href ='input'">
		<c:if test="${!empty lessonHistories}">
			<table class="table table-bordered">
				<c:forEach var="lessonHistory" items="${lessonHistories}">
					<tr>
						<td>${lessonHistory.idx}</td>
						<td>${lessonHistory.lessonDate}</td>
						<td>${lessonHistory.lesson.subject}</td>
						<td>${lessonHistory.trainee.name}</td>			
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
</body>
</html>