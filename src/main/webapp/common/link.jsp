<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
	@font-face {
	    font-family: 'NEXON';
	    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
	}
	
	@font-face {
	    font-family: 'TAEBAEK';
	    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2310@1.0/TAEBAEKfont.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
	}
	
	body {
		font-family: 'NEXON';
		min-width: 1600px;
	}
	
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button {
	  -webkit-appearance: none;
	  margin: 0;
	}
	
	.modal {
		display: none;
	    position: absolute;
	    top:0;
	    left: 0;
	    width: 100%;
	    height: 100vh;
	    overflow: hidden;
	    background: rgba(0,0,0,0.5);
	}
	
	.modal .modal_popup {
		width: 60%;
		height: 65%;
	    position: absolute;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%, -50%);
	    padding: 20px;
	    background: #ffffff;
	    border-radius: 20px;
	}
		
	#modalButtons {
		width: 30%;
		text-align: center;
	}
	
	#modalButtons button {
		font-size: 1.5em;
		color: white;
		border: 0px;
		border-radius: 20px;
		padding: 10px 30px;
		margin: 50px 5px 0 5px;
	}
	
	#modalButtons #saveButton {
		background-color: #EA5D5D;
	}
	
	#modalButtons #closeButton {
		background-color: #383838;		
	}
	
	#historyDate{
		background-color : #383838;
		padding: 15px;
		color : #ffffff;
		font-size : 18px;
		border : none;
		outline : none;
		border-radius : 5px;
		margin: 20px 0;
	}
	
	::-webkit-calendar-picker-indicator{
		background-color : #ffffff;
		padding : 5px;
		cursor : pointer;
		border-radius : 3px;
	}
</style>