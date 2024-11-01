<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>데뷔조 추가</title>
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
	
	#form table {
		width: 500px;
		border: 1px solid #CBD5E1;
		font-size: 1.1em;
	}
	
	#form table th {
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
	
	#modal-box {
		position: fixed;
		top: 0;
		left: 0;
		bottom: 0;
		right: 0;
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
<body>
	<jsp:include page="/common/header.jsp" />
	<div id="content">
		<form action="save" method="post" id="form" enctype="multipart/form-data" class="d-flex justify-content-center align-items-center w-100">
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
					<td><input type="text" id="name" name="name" /></td>
				</tr>
				<tr>
					<th>인원</th>
					<td><input type="number" id="memeberCount" name="memberCount" /></td>
				</tr>
				<tr>
					<th>컨셉</th>
					<td><input type="text" id="concept" name="concept" /></td>
				</tr>
				<tr>
					<th>데뷔 예정일</th>
					<td><input type="date" id="debutDate" name="debutDate" /></td>
				</tr>
				<tr>
					<th>종합 등급</th>
					<td class="py-0">
						<select id="grade" name="grade" class="form-select">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="E">E</option>
							<option value="F">F</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
		<div class="d-flex justify-content-center w-50 mt-4 mb-3">
			<button type="button" id="save" class="col-3 mx-5" onclick="checkInput()">저장하기</button>
			<button type="button" id="toList" class="col-3 mx-5" onclick="location.href='/produce365/debuts'">목록으로</button>
		</div>
	</div>
	<script>
		function checkInput() {
			const name = document.getElementById("name").value;
			const memeberCount = document.getElementById("memeberCount").value;
			const concept = document.getElementById("concept").value;
			const debutDate = document.getElementById("debutDate").value;
			const grade = document.getElementById("grade").value;
			const form = document.getElementById("form")

			if (name != "" && memeberCount != "" && concept != ""
					&& debutDate != "" && grade != "") {
				form.submit();
			} else {
				alert("다시 입력해~");
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
</body>
</html>