<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수업 관리</title>
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
	
	.lessonInfo {
		font-size: 1.5em;
		font-weight: bold;
		border: 1px solid lightgrey;
		border-radius: 10px;
		padding: 10px;
		margin: 10px 0;
	}
	
	#lessonCategory {
		width: 30%;
		margin-left: 20px;
	}
	
	#lessonTrainer {
		width: 20%;
	}
	
	#lessonTime {
		width: 20%;
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
	<div class="modal">
	    <div class="modal_popup">
	        <jsp:include page="/lesson/lessonNew.jsp" />
	    </div>
	</div>
	<div id="content" class="d-flex">
		<jsp:include page="/common/menu.jsp" />
		<div id="rightBox">
		 	<button id="newButton"></button>
		 	<div id="infoWrapper">
			 	<c:if test="${!empty lessons}">
					<c:forEach var="lesson" items="${lessons}">
				 		<div class="d-flex justify-content-between align-items-center lessonInfo">
							<div id="lessonCategory">${lesson.subject}</div>
							<div id="lessonTrainer">${lesson.trainer}</div>
							<div id="lessonTime">
								<fmt:formatNumber type="number" maxFractionDigits="0" value="${lesson.time}" />시간
								<c:set var="minute" value="${lesson.time * 60 mod 60}" />
								<c:if test="${minute >= 1}">
									<fmt:formatNumber type="number" maxFractionDigits="0" value="${minute}" />분
								</c:if>
							</div>
							<button id="deleteButton" type="button" onclick="location.href='lessons/delete?id=${lesson.id}'"></button>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
	
	<script>
		const modal = document.querySelector('.modal');
		const modalOpen = document.getElementById("newButton");
		const modalClose = document.getElementById("closeButton");
	
		modalOpen.addEventListener('click',function(){
		    modal.style.display = 'block';
		});
		
		modalClose.addEventListener('click',function(){
		    modal.style.display = 'none';
		});
	</script>
</body>
</html>