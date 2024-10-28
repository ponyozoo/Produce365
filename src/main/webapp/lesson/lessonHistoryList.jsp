<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수업 기록</title>
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
	
	.lessonHistory {
		font-size: 1.5em;
		font-weight: bold;
		border: 1px solid lightgrey;
		border-radius: 10px;
		padding: 17px;
		margin: 10px 0;
	}
	
	#lessonHistorySubject {
		width: 50%;
		margin-left: 13px;
	}
	
	#lesssonHistoryTrainee {
		width: 30%;
	}
	
	#lessonHistoryDate {
		text-align: right;
		width: 20%;
		margin-right: 13px;
	}
</style>
<body>
	<jsp:include page="/common/header.jsp" />
	<div class="modal">
	    <div class="modal_popup">
	        <jsp:include page="/lesson/lessonHistoryNew.jsp" />
	    </div>
	</div>
	<div id="content" class="d-flex">
		<jsp:include page="/common/menu.jsp" />
		<div id="rightBox">
			<button id="newButton"></button>
			<div id="infoWrapper">
				<c:if test="${!empty lessonHistories}">
					<c:forEach var="lessonHistory" items="${lessonHistories}">
						<div class="d-flex justify-content-between align-items-center lessonHistory">
							<div id="lessonHistorySubject">${lessonHistory.lesson.subject}</div>
							<div id="lesssonHistoryTrainee">${lessonHistory.trainee.name}</div>
							<div id="lessonHistoryDate">${lessonHistory.lessonDate}</div>
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