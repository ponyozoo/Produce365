function checkInput() {
	const trainer = document.getElementById("tra").value;
	const subject = document.getElementById("sub").value;
	const time = document.getElementById("ti").value;
	const form = document.getElementById("form");

	if (trainer.trim() == "") {
		msg.innerText = "선생님 성함을 입력해주세요.";
	} else if (subject.trim() == "") {			
		msg.innerText = "수업명을 입력해주세요.";
	} else if (time.trim() == "") {
		msg.innerText = "총 수업 시간을 입력해주세요.";
	} else {
		form.submit();
	}
}

if (msg != '') {
	alert("문제가 발생했습니다. 다시 시도해주세요.");
	location.href="/lesson";
}