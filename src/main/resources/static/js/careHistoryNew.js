function checkInput() {
	const form = document.getElementById("form");
	const care = document.getElementById("selectCare").value;
	const trainee = document.getElementById("selectTrainee").value;
	const date = document.getElementById("historyDate").value;
	
	if (care == "0") {
		msg.innerText = "케어 항목을 선택해주세요.";			
	} else if (trainee == "0") {
		msg.innerText = "연습생을 선택해주세요.";			
	} else if(date == ""){
		msg.innerText = "올바른 날짜를 입력해주세요.";
	} else {
		form.submit();
	}
}

let now_utc = Date.now()
let timeOff = new Date().getTimezoneOffset( ) * 60000;
let today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("historyDate").setAttribute("max", today);