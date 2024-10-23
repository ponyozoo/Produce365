<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>테이블 입력 폼</title>
<body>

	<form action="save" method="post" id="f1">

		<input type="file" id= "photo" name="photo">

		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" id= "name" name="name"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><select id= "sex" name="sex">
						<option value="M" selected>M</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" id= "birth" name="birth"></td>
			</tr>
			<tr>
				<th>국적</th>
				<td><input type="text" id= "nationality" name="nationality"></td>
			</tr>
			<tr>
				<th>키</th>
				<td><input type="text" id= "height" name="height"></td>
			</tr>
			<tr>
				<th>몸무게</th>
				<td><input type="text" id= "weight" name="weight"></td>
			</tr>
			<tr>
				<th>입사일자</th>
				<td><input type="date" id= "hireDate" name="hireDate"></td>
			</tr>
			<tr>
				<th>종합 등급</th>
				<td><select id= "total" name="total">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<th>보컬 등급</th>
				<td><select id= "vocal" name="vocal">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<th>랩 등급</th>
				<td><select id= "rap" name="rap">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>

				</select></td>
			</tr>
			<tr>
				<th>댄스 등급</th>
				<td><select id= "dance" name="dance">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
		</table>


		<!-- 	<input type="submit" value="저장하기" />
	<input type="submit" value="목록으로" /> -->

		<hr />


		<button type="button" onclick="checkInput()">저장하기</button>

		<button type="button">목록으로</button>
	</form>
</body>
<script>
	function checkInput() {

		const name = document.getElementById("name").value;
		const sex = document.getElementById("sex").value;
		const birth = document.getElementById("birth").value;
		const nationality = document.getElementById("nationality").value;
		const height = document.getElementById("height").value;
		const weight = document.getElementById("weight").value;
		const hireDate = document.getElementById("hireDate").value;
		const form = document.getElementById("f1");

		if (name.trim() == "" || sex.trim() == "" || birth.trim() == ""
				|| nationality.trim() == "" || height.trim() == ""
				|| weight.trim() == "" || hireDate.trim() == "") {
			alert("다시 입력하세요.");
		} else {
			form.submit();

		}
	}
</script>

</html>


<!-- http://localhost:8080/produce365/trainee/traineeNew.jsp -->