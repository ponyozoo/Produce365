<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>연습생 정보 수정</title>
	<jsp:include page="/common/link.jsp" />
</head>
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
	
	#f1 table {
		width: 500px;
		border: 1px solid #CBD5E1;
		font-size: 1.1em;
	}
	
	#f1 table th {
		border: 1px solid #CBD5E1;
		background-color: #EEF4FC;
		padding: 10px;
		font-weight: bold;
	}
	
	#f1 table td {
		border: 1px solid #CBD5E1;
		padding: 10px;
	}
	
	#f1 table input {
		border: none;
		background-color: transparent;
	}
	
	#f1 table input:focus {
		outline: none;
	}
	
	#f1 table .inputDisable {
		background-color: #F0F0F0;
	}
	
	#f1 table .inputDisable input {
		color: #6C6C6C;
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
</style>
<body>
	<jsp:include page="/common/header.jsp" />
	<div id="content">
		<form action="trainees/update" method="post" id="f1" class="d-flex justify-content-center align-items-center w-100">
			<div id="photoWrapper">
				<img src="${trainee.photo}" />
			</div>
			<table class="mx-5">
				<tr>
					<th>사번</th>
					<td class="inputDisable"><input type="text" name="id" value="${trainee.id}" readonly /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="name" name="name" value="${trainee.name}" /></td>
				</tr>
				<tr>
					<th>성별</th>
					<td class="inputDisable"><input type="text" id="sex" name="sex" value="${trainee.sex}" disabled /></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td class="inputDisable"><input type="text" id="birth" name="birth" value="${trainee.birth}" disabled /></td>
				</tr>
				<tr>
					<th>국적</th>
					<td><input type="text" id="nationality" name="nationality" value="${trainee.nationality}" /></td>
				</tr>
				<tr>
					<th>키</th>
					<td><input type="text" id="height" name="height" value="${trainee.height}" /></td>
				</tr>
				<tr>
					<th>몸무게</th>
					<td><input type="text" id="weight" name="weight" value="${trainee.weight}" /></td>
				</tr>
				<tr>
					<th>입사일자</th>
					<td class="inputDisable"><input type="text" id="hireDate" name="hireDate" value="${trainee.hireDate}" disabled /></td>
				</tr>
				<tr>
					<th>종합 등급</th>
					<td class="py-0">
						<select id="total" name="total" class="form-select">
							<c:forEach var="rating" items="${ratings}">
								<c:if test="${rating.category == 'TOTAL'}">
									<option value="A" <c:if test="${rating.grade == 'A'}">selected</c:if>>A</option>
									<option value="B" <c:if test="${rating.grade == 'B'}">selected</c:if>>B</option>
									<option value="C" <c:if test="${rating.grade == 'C'}">selected</c:if>>C</option>
									<option value="D" <c:if test="${rating.grade == 'D'}">selected</c:if>>D</option>
									<option value="E" <c:if test="${rating.grade == 'E'}">selected</c:if>>E</option>
									<option value="F" <c:if test="${rating.grade == 'F'}">selected</c:if>>F</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>보컬 등급</th>
					<td class="py-0">
						<select id="vocal" name="vocal" class="form-select">
							<c:forEach var="rating" items="${ratings}">
								<c:if test="${rating.category == 'VOCAL'}">
									<option value="A" <c:if test="${rating.grade == 'A'}">selected</c:if>>A</option>
									<option value="B" <c:if test="${rating.grade == 'B'}">selected</c:if>>B</option>
									<option value="C" <c:if test="${rating.grade == 'C'}">selected</c:if>>C</option>
									<option value="D" <c:if test="${rating.grade == 'D'}">selected</c:if>>D</option>
									<option value="E" <c:if test="${rating.grade == 'E'}">selected</c:if>>E</option>
									<option value="F" <c:if test="${rating.grade == 'F'}">selected</c:if>>F</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>랩 등급</th>
					<td class="py-0">
						<select id="rap" name="rap" class="form-select">
							<c:forEach var="rating" items="${ratings}">
								<c:if test="${rating.category == 'RAP'}">
									<option value="A" <c:if test="${rating.grade == 'A'}">selected</c:if>>A</option>
									<option value="B" <c:if test="${rating.grade == 'B'}">selected</c:if>>B</option>
									<option value="C" <c:if test="${rating.grade == 'C'}">selected</c:if>>C</option>
									<option value="D" <c:if test="${rating.grade == 'D'}">selected</c:if>>D</option>
									<option value="E" <c:if test="${rating.grade == 'E'}">selected</c:if>>E</option>
									<option value="F" <c:if test="${rating.grade == 'F'}">selected</c:if>>F</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>댄스 등급</th>
					<td class="py-0">
						<select id="dance" name="dance" class="form-select">
							<c:forEach var="rating" items="${ratings}">
								<c:if test="${rating.category == 'DANCE'}">
									<option value="A" <c:if test="${rating.grade == 'A'}">selected</c:if>>A</option>
									<option value="B" <c:if test="${rating.grade == 'B'}">selected</c:if>>B</option>
									<option value="C" <c:if test="${rating.grade == 'C'}">selected</c:if>>C</option>
									<option value="D" <c:if test="${rating.grade == 'D'}">selected</c:if>>D</option>
									<option value="E" <c:if test="${rating.grade == 'E'}">selected</c:if>>E</option>
									<option value="F" <c:if test="${rating.grade == 'F'}">selected</c:if>>F</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
		</form>
		<div class="d-flex justify-content-between w-50 mt-5 mb-3">
			<button type="button" class="col-3" onclick="checkUpdate()">수정하기</button>
			<button type="button" class="col-3" onclick="location.href='trainees/delete?id=${trainee.id}'">삭제하기</button>
			<button type="button" class="col-3" onclick="location.href='trainees'">목록으로</button>
		</div>
	</div>

	<script>
		function checkUpdate() {
			const name = document.getElementById("name").value.trim();
			const nationality = document.getElementById("nationality").value
					.trim();
			const height = document.getElementById("height").value.trim();
			const weight = document.getElementById("weight").value.trim();
			const form = document.getElementById("f1");

			if (name === "" || nationality === "" || height === ""
					|| weight === "") {
				alert("다시 입력하세요.");
			} else {
				form.submit();
			}
		}
	</script>

</body>
</html>
