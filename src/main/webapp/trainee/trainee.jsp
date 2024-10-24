<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>연습생 목록</title>
	<jsp:include page="/common/link.jsp" />
</head>
<style>
	#content {
		margin-top: 130px;
	}
	
	#buttonList {
		margin-left: 10px;
	}
	
	#newButton {
		background-image: url(/produce365/resources/newButton.png);
	}
	
	#searchButton {
		background-image: url(/produce365/resources/searchButton.png);
	}
	
	.traineeButton {
		background-color: transparent;
		background-size: cover;
		border: none;
		width: 50px;
		height: 50px;
		margin: 5px;
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
	
	.traineeName {
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
			<div id="buttonList">
				<button id="newButton" class="traineeButton" onclick="location.href='trainees/input'"></button>
				<button id="searchButton" class="traineeButton"></button>
			</div>
			<div class="d-flex flex-wrap my-3">
				<c:if test="${!empty list}">
					<c:forEach var="trainee" items="${list}">
						<div class="card shadow-sm">
							<img class="cardImg" src="${trainee.photo}"/>
							<span class="traineeName">${trainee.name}</span>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<span>연습생이 없습니다.</span>
				</c:if>
			</div>
		</div>		
	</div>
</body>
</html>