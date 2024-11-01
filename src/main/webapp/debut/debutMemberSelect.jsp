<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<body>
	<div class="grid text-center">
		<div class="g-col-6">
			<input type="text" id="searchName" placeholder="연습생 이름을 입력해주세요." />
			<button type="button" onclick="getData()">검색</button>
			<div id="listBox"></div>
		</div>
		<div class="g-col-6">
			<div class="container"></div>
		</div>
		<div class="g-col-6">
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
	        	
	        	if (Object.keys(list).length === 0) {
	        		listBox.innerText = "검색 결과가 없습니다.";
	        		return ;
	        	}
	        	
	        	for (id in list) {
	        		let html = "";
	        		if (document.getElementById(id) == null)
		        		html = "<div><span>" + id + " </span><span>" + list[id] + "</span><button onclick='addMember(this)'>추가</button></div>";
	        		else
	        			html = "<div><span>" + id + " </span><span>" + list[id] + "</span><button onclick='delMember(this)'>삭제</button></div>";
	        		listBox.innerHTML += html;
	        	}
	        });
        }
	    
	    function addMember(button) {
	    	const traineeId = button.previousElementSibling.previousElementSibling.innerText.trim();
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
	    	const traineeId = button.previousElementSibling.previousElementSibling.innerText.trim();
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