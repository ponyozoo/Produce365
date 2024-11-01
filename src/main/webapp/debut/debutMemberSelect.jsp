<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<style>
	#searchButton, #DMSModal-close {
		font-size: 1.1em;
		padding: 7px 20px;
		margin-left: 10px;
		border-radius: 30px;
		background-color: #383838;
		color: white;
		border: none;
	}
	
	#searchName {
		padding: 7px;
		font-size: 1.1em;
		border-radius: 10px;
		border: 1px solid #383838;
	}
	
	#listBox {
		overflow: auto;
	}
	
	#listBox table {
		width: 600px;
		font-size: 1.1em;
		text-align: center;
	}
	
	#listBox table th {
		border: 1px solid #CBD5E1;
		background-color: #EEF4FC;
		padding: 7px;
	}
	
	#listBox table td {
		border: 1px solid #CBD5E1;
		padding: 7px;
	}
	
	#listBox table button {
		border: none;
		background-color: transparent;
		width: 100%;
		margin: 0;
		color: white;
	}
</style>
<body>
	<div class="d-flex flex-column align-items-center justify-content-between h-100">
		<div class="my-5">
			<input type="text" id="searchName" placeholder="연습생 이름 입력" />
			<button type="button" id="searchButton" onclick="getData()">검색</button>
		</div>
		<div id="listBox"></div>
		<div class="my-5">
			<button id="DMSModal-close">닫기</button>
		</div>
	</div>
	
	<script>
	    function getData() {
        	const listBox = document.getElementById("listBox");
        	listBox.innerHTML = '';
	    	
	    	const name = document.getElementById("searchName").value;
	        axios.get('/produce365/debutMembers/search', {
	        	params: {'name': name}
	        }).then((response) => {
	        	const list = response.data;
	        	
	        	if (Object.keys(list).length == 0) {
	        		listBox.innerText = "검색 결과가 없습니다.";
	        		return ;
	        	}
	        	
	        	let table = "<table>";
	        	
	        	for (id in list) {
	        		let html = "";
	        		if (document.getElementById(id) == null)
		        		html = "<tr><th>" + id + " </th><td>" + list[id] + "</td><td style='background-color: #90A2CF'><button onclick='addMember(this)'>추가</button></td></tr>";
	        		else
	        			html = "<tr><th>" + id + " </th><td>" + list[id] + "</td><td style='background-color: #F48888'><button onclick='delMember(this)'>삭제</button></td></tr>";
	        		table += html;
	        	}
	        	
        		listBox.innerHTML += table + "</table>";
	        });
        }
	    
	    function addMember(button) {
	    	const traineeId = button.parentElement.previousElementSibling.previousElementSibling.innerText.trim();
	    	const groupId = document.getElementById("groupId").value;
	    	
	    	button.disabled = true;
	    	
	    	axios.post('/produce365/debutMembers/add', {
    	    	'traineeId': traineeId,
    	    	'groupId': groupId
	    	  }).then((response) => {
	    		button.innerText = '삭제';
	    		button.disabled = false;
	    	  });
	    }
	    
	    function delMember(button) {
	    	const traineeId = button.parentElement.previousElementSibling.previousElementSibling.innerText.trim();
	    	const groupId = document.getElementById("groupId").value;
	    	
	    	button.disabled = true;
	    	
	    	axios.post('/produce365/debutMembers/del', {
    	    	'traineeId': traineeId,
    	    	'groupId': groupId
	    	  }).then((response) => {
	    		button.innerText = '추가';
	    		button.disabled = false;
	    	  });
	    	
	    }
	</script>

</body>
</html>