<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>케어 등록</title>
</head>
<body>
	<form action="save" method="post" id="f1">
		<h3>새 케어 정보 등록</h3>
		<input type="text" placeholder="케어 항목을 입력해주세요." id="category" name ="category">
		<input type="text" placeholder="케어 가격을 입력해주세요." id="cost" name ="cost"></br>
		<button type="button" onclick="checkInput()">추가하기</button>
	</form>
</body>
<script>
	function checkInput() {
		const category = document.getElementById("category").value;
		const cost = document.getElementById("cost").value;
		const form = document.getElementById("f1");
		
		if (category.trim() == "" || cost.trim() == "") {
			alert("등록을 위한 값을 설정해 주세요.");
		} else {
			form.submit();
		}
	}
</script>
</html>