<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<body>
	<div class="grid text-center">
		<!-- 검색 파트 -->
		<div class="g-col-6">
			<form class="search-box">
				<input class="search-text" type="text" name="nameSearch"
					placeholder="연습생 이름을 입력해주세요." width=500;> <img
					src="../resources/searchButton.png" width="30;" id="searchBTN" /> <br />

				<div>
					<!-- 여기에 연습생 이름 검색 결과 출력 : 체크해서 셀렉트 -->
				</div>

			</form>
		</div>

		<!-- 전체 목록 출력 파트 -->
		<div class="g-col-6">
			<!-- 여기에 전체 연습생 목록 출력 -->
			<div class="container"></div>
		</div>



		<!-- 닫기 파트 -->
		<div class="g-col-6">
			<form>
				<button id="DMSModal-close">닫기</button>
			</form>
		</div>
	</div>



</body>
</html>