<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습생 정보 수정</title>
</head>
<body>

	<h3>연습생 정보 수정</h3>
	<form action="update" method="post" id="f1">


		<table>
			<tr>
				<td><img src="${trainee.photo}" width="200" height="200" /></td>
			</tr>
			<tr>
				<th>사번</th>
				<td><input type="text" name="id" value="${trainee.id}" readonly /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="name" name="name"
					value="${trainee.name}" /></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="text" id="sex" name="sex"
					value="${trainee.sex}" disabled /></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" id="birth" name="birth"
					value="${trainee.birth}" disabled /></td>
			</tr>
			<tr>
				<th>국적</th>
				<td><input type="text" id="nationality" name="nationality"
					value="${trainee.nationality}" /></td>
			</tr>
			<tr>
				<th>키</th>
				<td><input type="text" id="height" name="height"
					value="${trainee.height}" /></td>
			</tr>
			<tr>
				<th>몸무게</th>
				<td><input type="text" id="weight" name="weight"
					value="${trainee.weight}" /></td>
			</tr>
			<tr>
				<th>입사일자</th>
				<td><input type="text" id="hireDate" name="hireDate"
					value="${trainee.hireDate}" disabled /></td>
			</tr>
			<tr>
				<th>종합 등급</th>
				<td><select id="total" name="total">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<th>보컬 등급</th>
				<td><select id="vocal" name="vocal">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<th>랩 등급</th>
				<td><select id="rap" name="rap">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<th>댄스 등급</th>
				<td><select id="dance" name="dance">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
		</table>

		<hr />

		<button type="button" onclick="checkUpdate()">수정</button>
		<button type="button"
			onclick="location.href='delete?id=${trainee.id}'">삭제하기</button>
		<button type="button" onclick="location.href='trainees'">목록으로</button>
	</form>

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
