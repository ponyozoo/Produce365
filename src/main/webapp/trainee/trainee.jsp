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
		margin-top: 100px;
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
	}
	
	.cardImg {
		width: 100%;
		height: 100%;
		padding: 10px;
		object-fit: cover;
	}
	
	.traineeName {
		font-weight: bold;
		margin: 0 10px 10px 10px;
	}
</style>
<body>
	<jsp:include page="/common/header.jsp" />
	<div id="content">
		<div class="text-end pt-4 px-5">
			<button id="newButton" class="traineeButton"></button>
			<button id="searchButton" class="traineeButton"></button>
		</div>
		<div class="d-flex">
			<jsp:include page="/common/menu.jsp" />
			<div class="d-flex my-3">
				<div class="card shadow-sm">
					<img class="cardImg" src="https://pbs.twimg.com/media/GUXmYHEboAAl6dF.jpg:large"/>
					<span class="traineeName">변의주</span>
				</div>
			</div>
		</div>		
	</div>
</body>
</html>