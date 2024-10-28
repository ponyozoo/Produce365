<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 300px; height: 300px">
	<img id="preview" src="https://pbs.twimg.com/media/GUXmYHEboAAl6dF.jpg:large" style="height:100%; object-fit: cover"/>
</div>
<form action="testt" method="post" enctype="multipart/form-data">
	<input type="file" name="imgFile" onchange="showImg(this)"/>
	<button>저장</button>
</form>

<script>

function showImg(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('preview').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  }
}
	
</script>
</body>
</html>