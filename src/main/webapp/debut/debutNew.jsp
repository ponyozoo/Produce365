<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/link.jsp" />
</head>
<body>
<form action="/produce365/debuts/save" method="post" id="form">

		<div class="container text-center">
			<div class="row">
				<div class="col">
					<input type="file" name="photo">
				</div>
				<div class="col">
					<table class="table table-bordered">
						<tr>
							<td>이름</td>
							<td><input type="text" id="name" name="name" /></td>
						</tr>

						<tr>
							<td>인원</td>
							<td><input type="text" id="memeberCount" name="memberCount" /></td>
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

						<tr>
							<td>멤버목록</td>
							<td>
								<button>멤버 선택</button>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
	<div class="container text-center">
		<div class="row">
			<div class="col">
					<button type="button" id="save" onclick="checkInput()" >저장하기</button>
			</div>
			<div class="col">
					<button type="button" id="toList" onclick="checkToList()">목록으로</button>
			</div>
		</div>
	</div>
		
	</form>
	

	<script>
		
	function checkInput(){
		
		const name = document.getElementById("name").value;
		const memeberCount = document.getElementById("memeberCount").value;
		const concept = document.getElementById("concept").value;
		const debutDate = document.getElementById("debutDate").value;
		const grade = document.getElementById("grade").value;
		const form = document.getElementById("form")
		
	
		if(name != "" && memeberCount != "" && concept != "" && debutDate != "" && grade != ""){
			form.submit();
		} else {
			alert("다시 입력해~");
		}
		
	}
		
	</script>

</body>
</html>