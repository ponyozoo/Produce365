<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>연습생 추가</title>
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
	
	#file-field label {
	    width: 500px;
	    padding-bottom: 600px;
	    display: inline-block;
	    background-image: url('../resources/newPhoto.png');
	    background-size: cover;
	    background-repeat: no-repeat;
	    background-position: center center;
	    cursor: pointer;
   		margin: 0 3rem;
	}
	
	#file-field #file {
		display: none;
	}
	
	#file-field div {
		width: 500px;
		display: flex;
		visibility: hidden;
		align-items: center;
		justify-content: space-between;
	}
	
	#file-field div p {
		width: 450px;
    	overflow: hidden;
	    white-space: nowrap;
	    text-overflow: ellipsis;
	    margin-bottom: 0;
	}
	
	#file-field div button {
		background-image: url(/produce365/resources/deleteButton.png);
		background-color: transparent;
		background-size: cover;
		border: none;
		width: 30px;
		height: 30px;
	}
</style>
<body>
	<jsp:include page="/common/header.jsp" />
	<div id="content">
		<form action="save" method="post" id="f1" enctype="multipart/form-data" class="d-flex justify-content-center align-items-center w-100">
			<div id="file-field">
               <label for="file"><input type="file" id="file" name="photo" accept='image/*' onchange="uploadFile(this)" /></label>
               <div>
                   <p></p>
                   <button type="button" onclick="deleteFile(this)"></button>
               </div>
            </div>
			<table class="mx-5 mb-4">
				<tr>
					<th>이름</th>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td class="py-0">
						<select id="sex" name="sex" class="form-select">
							<option value="M" selected>M</option>
							<option value="F">F</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" id="birth" name="birth"></td>
				</tr>
				<tr>
					<th>국적</th>
					<td><input type="text" id="nationality" name="nationality"></td>
				</tr>
				<tr>
					<th>키</th>
					<td><input type="text" id="height" name="height"></td>
				</tr>
				<tr>
					<th>몸무게</th>
					<td><input type="text" id="weight" name="weight"></td>
				</tr>
				<tr>
					<th>입사일자</th>
					<td><input type="date" id="hireDate" name="hireDate"></td>
				</tr>
				<tr>
					<th>종합 등급</th>
					<td class="py-0">
						<select id="total" name="total" class="form-select">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="F">F</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>보컬 등급</th>
					<td class="py-0">
						<select id="vocal" name="vocal" class="form-select">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="F">F</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>랩 등급</th>
					<td class="py-0">
						<select id="rap" name="rap" class="form-select">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="F">F</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>댄스 등급</th>
					<td class="py-0">
						<select id="dance" name="dance" class="form-select">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="F">F</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
		<div class="d-flex justify-content-center w-50 mt-4 mb-3">
			<button type="button" class="col-3 mx-5" onclick="checkInput()">저장하기</button>
			<button type="button" class="col-3 mx-5" onclick="location.href='/produce365/trainees'">목록으로</button>
		</div>
	</div>
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
	
	function uploadFile(target) {
        const targetLabel = target.parentElement;
        const nextDiv = targetLabel.nextElementSibling;
        const nameP = nextDiv.querySelector('p');
        const img = target.files && target.files[0];

	    var reader = new FileReader();
	    reader.onload = function(e) {
	    	const imgUrl = e.target.result;
            targetLabel.style.backgroundImage = "url('" + imgUrl + "')";
            nextDiv.style.visibility = "visible";
            nameP.textContent = img.name;
	    };
	    reader.readAsDataURL(target.files[0]);
	}
	
	function deleteFile(target) {
	    const nameBox = target.parentElement;
	    const fileField = nameBox.parentElement;
	    const fileInput = fileField.querySelector('input');
	    const fileLable = fileField.querySelector('label');

	    if (fileInput && fileLable) {
	        fileInput.value = '';
	        nameBox.style.visibility = "hidden";
	        fileLable.style.backgroundImage = "url('../resources/newPhoto.png')";
	    }
	}
</script>

</html>


<!-- http://localhost:8080/produce365/trainee/traineeNew.jsp -->