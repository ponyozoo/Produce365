<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>테이블 입력 폼</title>
<body>

	<form>
		<input type="file" value="사진" />

		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" placeholder="이름"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><select>
						<option value="M">남성</option>
						<option value="F">여성</option>
				</select></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date"></td>
			</tr>
			<tr>
				<th>국적</th>
				<td><input type="text" placeholder="국적"></td>
			</tr>
			<tr>
				<th>키</th>
				<td><input type="height" placeholder="키"></td>
			</tr>
			<tr>
				<th>몸무게</th>
				<td><input type="weight" placeholder="몸무게"></td>
			</tr>
			<tr>
				<th>입사일자</th>
				<td><input type="date"></td>
			</tr>
			<tr>
				<th>종합 등급</th>
				<td><select>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<th>보컬 등급</th>
				<td><select>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
			<tr>
				<th>랩 등급</th>
				<td><select>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>

				</select></td>
			</tr>
			<tr>
				<th>댄스 등급</th>
				<td><select>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
				</select></td>
			</tr>
		</table>
	</form>

	<input type="submit" value="저장하기" />
	<input type="submit" value="목록으로" />

</body>
</html>




<!-- http://localhost:8080/produce365/trainee/traineeNew.jsp -->