<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>케어 관리</title>
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
	
	.careInfo {
		font-size: 1.5em;
		font-weight: bold;
		border: 1px solid lightgrey;
		border-radius: 10px;
		padding: 10px;
		margin: 10px 0;
	}
	
	#careInfoCategory {
		margin-left: 20px;
	}
	
	#deleteButton {
		background-image: url(/produce365/resources/deleteButton.png);
		background-color: transparent;
		background-size: cover;
		border: none;
		width: 40px;
		height: 40px;
		margin: 5px 20px 5px 50px;
	}
</style>
<body>
	<jsp:include page="/common/header.jsp" />
	<div id="content" class="d-flex">
		<jsp:include page="/common/menu.jsp" />
		<div id="rightBox">
			<button id="newButton" onclick="location.href='cares/input'"></button>
			<div id="infoWrapper">
				<c:if test="${!empty cares}">
					<c:forEach var="care" items="${cares}">
						<div class="d-flex justify-content-between align-items-center careInfo">
							<div id="careInfoCategory">${care.category}</div>
							<div class="d-flex align-items-center">
								<div>₩ <fmt:formatNumber value="${care.cost}" pattern="#,###" /></div>
								<button id="deleteButton" type="button" onclick="location.href='delete?id=${care.id}'"></button>							
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>