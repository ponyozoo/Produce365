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
		height: 100vh;
		padding-top: 130px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	#content button {
		width: 20%;
		font-size: 1.3em;
		padding: 7px 0;
		border-radius: 30px;
		background-color: #383838;
		color: white;
		border: none;
	}
	
	#form table {
		width: 500px;
		border: 1px solid #CBD5E1;
		font-size: 1.1em;
	}
	
	#form table th {
		width: 33%;
		border: 1px solid #CBD5E1;
		background-color: #EEF4FC;
		padding: 15px;	
		font-weight: bold;
	}
	
	#form table td {
		border: 1px solid #CBD5E1;
		padding: 15px;
	}
	
	#form table input {
		border: none;
		background-color: transparent;
	}
	
	#form table input:focus {
		outline: none;
	}
	
	
	#photoWrapper {
		width: 500px;
		height: 600px;
		margin: 0 3rem;
	}
	
	#photoWrapper img {
		width: 100%;
		height: 100%;
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
	
	#DMSModal-open {
		width: 40% !important;
		font-size: 1em !important;
		background-color: #6678A6 !important;
		margin-top: 10px;
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
		<form action="/produce365/debuts/update" method="post" id="form" class="d-flex justify-content-center align-items-center w-100">
			<div id="photoWrapper">
				<img src="${debut.photo}" />
			</div>
			<input type="text" id="groupId" name="id" value="${debut.id}" hidden="hidden"/>
			<table class="mx-5 mb-4">
				<tr>
					<th>이름</th>
					<td><input type="text" id="name" name="name" value="${debut.name}"/></td>
				</tr>
				<tr>
					<th>인원</th>
					<td><input type="text" id="memeberCount" name="memberCount" value="${debut.memberCount}"/></td>
				</tr>
				<tr>
					<th>컨셉</th>
					<td><input type="text" id="concept" name="concept" value="${debut.concept}"/></td>
				</tr>
				<tr>
					<th>데뷔 예정일</th>
					<td><input type="date" id="debutDate" name="debutDate" value="${debut.debutDate}"/></td>
				</tr>
				<tr>
					<th>종합 등급</th>
					<td class="py-0">
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
					<th>멤버 목록</th>
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
		</form>
		<div class="d-flex justify-content-between w-50 mt-5 mb-3">
			<button type="button" class="col-3" id="save" onclick="checkUpdate()">수정하기</button>
			<button type="button" class="col-3" id="deletebutton" onclick="location.href='debuts/delete?id=${debut.id}'">삭제하기</button>
			<button type="button" class="col-3" id="toList" onclick="location.href='/produce365/debuts'">목록으로</button>
		</div>
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