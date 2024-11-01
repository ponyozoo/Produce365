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
		margin-top: 130px;
	}
	
	#file-field label {
	    width: 100%;
	    padding-bottom: 700px;
	    display: inline-block;
	    background-image: url('../resources/newPhoto.png');
	    background-size: cover;
	    background-repeat: no-repeat;
	    background-position: center center;
	    cursor: pointer;
	}
	
	#file-field #file1 {
		display: none;
	}
	
	#file-field div {
		display: none;
	}
	
	#file-field div p {
    	overflow: hidden;
	    white-space: nowrap;
	    text-overflow: ellipsis;
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
		<form action="save" method="post" id="form" enctype="multipart/form-data">
			<div class="container text-center">
				<div class="row">
					<div class="col-5">
						<div id="file-field">
		                    <label for="file1"><input type="file" id="file1" name="photo" accept='image/*' onchange="uploadFile(this)" /></label>
		                    <div>
		                        <p>이미지</p>
		                        <button type="button" onclick="deleteFile(this)">삭제</button>
		                    </div>
		                </div>
					</div>
					<div class="col-5">
						<table class="table table-bordered">
							<tr>
								<td>이름</td>
								<td><input type="text" id="name" name="name" /></td>
							</tr>
							<tr>
								<td>인원</td>
								<td><input type="number" id="memeberCount" name="memberCount" /></td>
							</tr>
							<tr>
								<td>컨셉</td>
								<td><input type="text" id="concept" name="concept" /></td>
							</tr>
							<tr>
								<td>데뷔 예정일</td>
								<td><input type="date" id="debutDate" name="debutDate" /></td>
							</tr>
							<tr>
								<td>종합 등급</td>
								<td><select id="grade" name="grade">
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
								</select></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
	
			<div class="container text-center">
				<div class="row">
					<div class="col">
						<button type="button" id="save" onclick="checkInput()">저장하기</button>
					</div>
					<div class="col">
						<button type="button" id="toList" onclick="location.href='/produce365/debuts'">목록으로</button>
					</div>
				</div>
			</div>
		</form>
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
                nextDiv.style.display = "block";
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
    	        nameBox.style.display = "none";
    	        fileLable.style.backgroundImage = "url('../resources/newPhoto.png')";
    	    }
    	}
	</script>
</body>
</html>