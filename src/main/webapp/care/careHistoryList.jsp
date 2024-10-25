<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>케어 기록</title>
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
	
	#rightBox {
		width: 100%;
	}
	
	#infoWrapper {
		margin: 15px 150px 50px 15px;
	}
	
	.careHistory {
		font-size: 1.5em;
		font-weight: bold;
		border: 1px solid lightgrey;
		border-radius: 10px;
		padding: 17px;
		margin: 10px 0;
	}
	
	#careHistoryCategory {
		width: 50%;
		margin-left: 13px;
	}
	
	#careHistoryTrainee {
		width: 30%;
	}
	
	#careHistoryDate {
		text-align: right;
		width: 20%;
		margin-right: 13px;
	}
</style>
<body>
	<jsp:include page="/common/header.jsp" />
	<div id="content" class="d-flex">
		<jsp:include page="/common/menu.jsp" />
		<div id="rightBox">
			<button id="newButton" onclick="location.href='careHistory/input'"></button>
			<div id="infoWrapper">
				<c:if test="${!empty careHistories}">
					<c:forEach var="careHistory" items="${careHistories}">
						<div class="d-flex justify-content-between align-items-center careHistory">
							<div id="careHistoryCategory">${careHistory.care.category}</div>
							<div id="careHistoryTrainee">${careHistory.trainee.name}</div>
							<div id="careHistoryDate">${careHistory.careDate}</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>