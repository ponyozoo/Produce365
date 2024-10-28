<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
	#title {
		font-size: 2.5em;
		font-weight: bold;
		margin-bottom: 70px;
	}
	
	#category, #cost {
		width: 80%;
		border: 1px solid #383838;
		border-radius: 20px;
		padding: 20px;
		margin: 10px 0;
		font-size: 1.5em;
	}
	
	#msg {
		color: #d62828;
	}
</style>
<body>
	<form action="cares/save" method="post" id="f1" class="d-flex flex-column justify-content-center align-items-center h-100">
		<h3 id="title">새 케어 정보 등록</h3>
		<input id="category" name="category" type="text" placeholder="케어 항목을 입력해주세요." />
		<input id="cost" name="cost" type="number" placeholder="케어 가격을 입력해주세요." />
		<div id="msg"></div>
		<div id="modalButtons">
			<button id="saveButton" type="button" onclick="checkInput()">추가</button>
			<button id="closeButton" type="button">닫기</button>
		</div>
	</form>
</body>
<script>
	function checkInput() {
		const category = document.getElementById("category").value;
		const cost = document.getElementById("cost").value;
		const msg = document.getElementById("msg");
		const form = document.getElementById("f1");

		if (category.trim() == "")
			msg.innerText = "케어 항목을 입력해주세요.";
		else if (cost.trim() == "" || cost.trim() < 0)
			msg.innerText = "케어 가격을 정확히 입력해주세요.";
		else
			form.submit();
	}
</script>
</html>