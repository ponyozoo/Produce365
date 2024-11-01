<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>데뷔조 수정</title>
	<jsp:include page="/common/link.jsp" />
<style>
	#content {
		margin-top: 130px;
	}
	
	#debutPhoto {
		width: 100%;
		height: 70vh;
		object-fit: cover;
	}

	#modal-box {
		position: fixed;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		background-color: rgba(0, 0, 0, 0.6);
		display: none;
		justify-content: center;
		align-items: center;
	}
	
	#modal-box.active {
		display: flex;
	}
	
	#popup {
		width: 60%;
		height: 60%;
		max-width: 60%;
		max-height: 60%;
		background-color: #ffffff;
		border-radius: 10px;
		overflow: hidden;
	}
</style>

</head>
<body>
	<div id="modal-box">
		<div class="popup" id="popup">
			<jsp:include page="/debut/debutMemberSelect.jsp" />
		</div>
	</div>

	<jsp:include page="/common/header.jsp" />
	<div id="content">
		<form action="/produce365/debuts/update" method="post" id="form">
			<div class="container text-center">
				<div class="row">
					<div class="col-5">
						<img src="../${debut.photo}" id="debutPhoto" />
					</div>
					<div class="col-5">
						<input type="text" id="groupId" name="id" value="${debut.id}" hidden="hidden"/>
						<table class="table table-bordered">
							<tr>
								<td>이름</td>
								<td><input type="text" id="name" name="name" value="${debut.name}"/></td>
							</tr>
							<tr>
								<td>인원</td>
								<td><input type="text" id="memeberCount" name="memberCount" value="${debut.memberCount}"/></td>
							</tr>
							<tr>
								<td>컨셉</td>
								<td><input type="text" id="concept" name="concept" value="${debut.concept}"/></td>
							</tr>
							<tr>
								<td>데뷔 예정일</td>
								<td><input type="date" id="debutDate" name="debutDate" value="${debut.debutDate}"/></td>
							</tr>
							<tr>
								<td>종합 등급</td>
								<td>
									<select id="grade" name="grade">
										<option value="A" <c:if test="${debut.grade == 'A'}">selected</c:if>>A</option>
										<option value="B" <c:if test="${debut.grade == 'B'}">selected</c:if>>B</option>
										<option value="C" <c:if test="${debut.grade == 'C'}">selected</c:if>>C</option>
										<option value="D" <c:if test="${debut.grade == 'D'}">selected</c:if>>D</option>
										<option value="E" <c:if test="${debut.grade == 'E'}">selected</c:if>>E</option>
										<option value="F" <c:if test="${debut.grade == 'F'}">selected</c:if>>F</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>멤버목록</td>
								<td>
									<c:if test="${!empty trainees}">
										<c:forEach var="trainee" items="${trainees}">
											<div id="${trainee.trainee.id}">${trainee.trainee.name}</div>
										</c:forEach>
									</c:if> 
									<c:if test="${empty trainees}">
										<span>데뷔멤버가 없습니다.</span>
									</c:if>
									<button type="button" id="DMSModal-open">멤버 선택</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
	
			<div class="container text-center">
				<div class="row">
					<div class="col">
						<button type="button" id="save" onclick="checkUpdate()">수정하기</button>
					</div>
					<div class="col">
						<button type="button" id="deletebutton" onclick="location.href='debuts/delete?id=${debut.id}'">삭제하기</button>
					</div>
					<div class="col">
						<button type="button" id="toList" onclick="location.href='/produce365/debuts'">목록으로</button>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script>
		function checkUpdate() {
			const name = document.getElementById("name").value;
			const memeberCount = document.getElementById("memeberCount").value;
			const concept = document.getElementById("concept").value;
			const debutDate = document.getElementById("debutDate").value;
			const grade = document.getElementById("grade").value;
			const form = document.getElementById("form");

			if (name != "" && memeberCount != "" && concept != ""
					&& debutDate != "" && grade != "") {
				form.submit();
			} else {
				alert("다시 입력하세요!");
			}
		}
		
		const DMSModalOpen = document.querySelector("#DMSModal-open");
		const modalBox = document.querySelector("#modal-box");
		const DMSModalClose = document.querySelector("#DMSModal-close");
		
		DMSModalOpen.addEventListener("click",()=> {
			modalBox.classList.toggle("active");
		});
		
		DMSModalClose.addEventListener("click",()=>{
			  modalBox.classList.toggle("active");
			  location.reload(true);
        });
	</script>
</body>
</html>