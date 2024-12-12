function checkInput() {
	const category = document.getElementById("category").value;
	const cost = document.getElementById("cost").value;
	const form = document.getElementById("form");

	if (category.trim() == "") {
		msg.innerText = "케어 항목을 입력해주세요.";
	} else if (cost.trim() == "") {			
		msg.innerText = "가격을 입력해주세요.";
	} else {
		form.submit();
	}
}

if (msg.length !== 0) {
	alert("문제가 발생했습니다. 다시 시도해주세요.");
	location.href="/care";
}