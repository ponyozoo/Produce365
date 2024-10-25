<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레슨관리</title>
<jsp:include page="/common/link.jsp" />
</head>
<body>
 <form action = "save" method = "post">
 	<input type = "button" class = "btn" name = "btn" value = "추가하기"
 	style = "float: right;" onclick = "location.href = 'input'">
 	<c:if test="${!empty lessons}">
			<table class="table table-bordered">
				<c:forEach var="lesson" items="${lessons}">
					<tr>
						<td>${lesson.trainer}</td>
						<td>${lesson.subject}</td>
						<td>${lesson.time}</td>
						<td><button type="button"
								onclick="location.href='delete?id=${lesson.id}'">X</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
 </form>
</body>
</html>