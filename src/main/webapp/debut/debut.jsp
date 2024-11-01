<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>데뷔조 목록</title>
	<jsp:include page="/common/link.jsp" />
</head>
<style>
	#content {
		margin-top: 130px;
	}
	
	#newButton {
		background-image: url(/produce365/resources/newButton.png);
		background-color: transparent;
		background-size: cover;
		border: none;
		width: 50px;
		height: 50px;
		margin: 5px 5px 5px 15px;
	}
	
	.card {
		cursor: pointer;
		width: 200px;
		height: 280px;
		margin: 0 15px 30px 15px;
		padding: 15px;
	}
	
	.cardImg {
		width: 100%;
		height: 90%;
		object-fit: cover;
	}
	
	.debutName {
		height: 10%;
		font-weight: bold;
		padding-top: 10px;
	}
</style>
<body>
	<jsp:include page="/common/header.jsp" />
	<div id="content" class="d-flex">
		<jsp:include page="/common/menu.jsp" />
		<div>
			<button id="newButton" onclick="location.href='debuts/new'"></button>
			<div class="d-flex flex-wrap my-3">
				<c:if test="${!empty list}">
					<c:forEach var="debut" items="${list}">
						<div class="card shadow-sm" onclick="location.href='debuts?id=${debut.id}'">
							<img class="cardImg" src="${debut.photo}"/>
							<span class="debutName">${debut.name}</span>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<span>데뷔조가 없습니다.</span>
				</c:if>
			</div>
		</div>		
	</div>
</body>
</html>