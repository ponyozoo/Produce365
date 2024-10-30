<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>연습생 검색</title>
	<jsp:include page="/common/link.jsp" />
</head>
<style>
	#content {
		margin-top: 130px;
	}
	
	select {
		width: 20% !important;
		font-size: 1.3em !important;
		margin: 20px 0;
	}
	
	.radios {
		display: none;
		margin: 10px 0;
	}
	
	input[type="radio"] {
		margin-left: 10px;
	}
	
	label {
		font-size: 1.3em;
		font-weight: bold;
		margin: 0 10px 0 10px;
	}
	
	#conSearchButton {
		font-size: 1.2em;
		padding: 7px 30px;
		border-radius: 30px;
		background-color: #383838;
		color: white;
		border: none;
		margin: 10px 0;
	}
	
	#traineeWrap {
		width: 90%;
	}
	
	.card {
		cursor: pointer;
		width: 200px;
		height: 280px;
		margin: 0 15px 30px 15px;
		padding: 15px;
	}
	
	.cardImg {
		width: 100%;
		height: 90%;
		object-fit: cover;
	}
	
	.traineeName {
		height: 10%;
		font-weight: bold;
		padding-top: 10px;
	}
</style>
<body>
	<jsp:include page="/common/header.jsp" />
	<div id="content" class="d-flex flex-column justify-content-between align-items-center">
		<select id="selectList" class="form-select" onchange="changeRadio()">
			<option value="sex" <c:if test="${menu == 'sex'}">selected</c:if>>성별 조회</option>
			<option value="nation" <c:if test="${menu == 'nation'}">selected</c:if>>국적 조회</option>
			<option value="grade" <c:if test="${menu == 'grade'}">selected</c:if>>종합 등급별 조회</option>
			<option value="debut" <c:if test="${menu == 'debut'}">selected</c:if>>데뷔조 여부 조회</option>
		</select>
		
		<div id="sexRadio" class="radios">
			<input type="radio" id="sex-M" name="sex" value="M" checked />
			<label for="sex-M">남성</label>
			<input type="radio" id="sex-F" name="sex" value="F" <c:if test="${menu == 'sex' && value == 'F'}">checked</c:if>/>
			<label for="sex-F">여성</label>
		</div>
		<div id="nationRadio" class="radios">
			<c:if test="${!empty nationality}">
				<c:forEach var="nation" items="${nationality}" varStatus="status">
	      			<c:choose>
		      			<c:when test="${status.index == 0}">
		      				<input type="radio" id="${nation}" name="nation" value="${nation}" checked />
							<label for="${nation}">${nation}</label>
		      			</c:when>
		      			<c:otherwise>
							<input type="radio" id="${nation}" name="nation" value="${nation}" <c:if test="${value == nation}">checked</c:if> />
							<label for="${nation}">${nation}</label>
		      			</c:otherwise>
	      			</c:choose>
				</c:forEach>
			</c:if>
			<c:if test="${empty nationality}">
				연습생이 존재하지 않아 국적을 선택할 수 없습니다.
			</c:if>
		</div>
		<div id="gradeRadio" class="radios">
			<input type="radio" id="grade-A" name="grade" value="A" checked />
			<label for="grade-A">A</label>
			<input type="radio" id="grade-B" name="grade" value="B" <c:if test="${value == 'B'}">checked</c:if> />
			<label for="grade-B">B</label>
			<input type="radio" id="grade-C" name="grade" value="C" <c:if test="${value == 'C'}">checked</c:if> />
			<label for="grade-C">C</label>
			<input type="radio" id="grade-D" name="grade" value="D" <c:if test="${value == 'D'}">checked</c:if> />
			<label for="grade-D">D</label>
			<input type="radio" id="grade-E" name="grade" value="E" <c:if test="${value == 'E'}">checked</c:if> />
			<label for="grade-E">E</label>
			<input type="radio" id="grade-F" name="grade" value="F" <c:if test="${menu == 'grade' && value == 'F'}">checked</c:if> />
			<label for="grade-F">F</label>
		</div>
		<div id="debutRadio" class="radios">
			<input type="radio" id="debut-T" name="debut" value="true" checked />
			<label for="debut-T">데뷔조 연습생</label>
			<input type="radio" id="debut-F" name="debut" value="false" <c:if test="${value == 'false'}">checked</c:if> />
			<label for="debut-F">비데뷔조 연습생</label>
		</div>
		
		<button type="button" id="conSearchButton" onclick="search()">검색</button>
		
		<div class="d-flex justify-content-center w-100">
			<div id="traineeWrap" class="d-flex flex-wrap p-5">
				<c:if test="${!empty trainees}">
					<c:forEach var="trainee" items="${trainees}">
						<div class="card shadow-sm">
							<img class="cardImg" src="${trainee.photo}"/>
							<span class="traineeName">${trainee.name}</span>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty trainees}">
					조건에 맞는 연습생이 없습니다.
				</c:if>			
			</div>		
		</div>
	</div>
	
	<script>
		const selectedMenu = document.getElementById("selectList");
		
		function changeRadio() {
			const radioBox = document.getElementById(selectedMenu.value + "Radio");
			const lastRadio = document.querySelector(".show");
			
			if (lastRadio) {
				lastRadio.style.display = 'none';
				lastRadio.classList.toggle('show');				
			}
			
			radioBox.style.display = 'block';
			radioBox.classList.toggle('show');
		}
		
		function search() {
			let form = document.createElement("form");
			const selected = selectedMenu.value;
			const value = document.querySelector('input[name="' + selected + '"]:checked').value;
			
			form.setAttribute("charset", "UTF-8");
			form.setAttribute("action", "/produce365/traineeSearch/" + selected);
			form.setAttribute("method", "post");
			
		    let input = document.createElement('input');
		    input.setAttribute('type', 'hidden');
		    input.setAttribute('name', 'value');
		    input.setAttribute('value', value);
		    
		    form.appendChild(input);
		    document.body.appendChild(form);
		    form.submit();
		}
		
		changeRadio();
	</script>
</body>
</html>