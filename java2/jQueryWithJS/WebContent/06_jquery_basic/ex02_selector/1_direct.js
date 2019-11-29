$(document).ready(function() {
	/* 지시사항에 적합한 선택자를 이용해서 요소를 선택하고 확인하시오. */
	
	// 아이디 선택자 : id가 org인 요소
	// --선택된 개수:  1
	var $selected = $("#org");
	
	// 클래스 선택자 : 클래스가 intro인 요소
	// --선택된 개수:  1
	
	// 태그 선택자: 모든 <li>
	// --선택된 개수:  4
	
	// 그룹 선택자 : <table> 또는 intro 클래스
	// --선택된 개수:  2
	
	// 복합 선택자 : td 중에 class가 name 인 요소
	// --선택된 개수:  4
	
	$selected.wrap("<span class='matched'>");
	console.log("선택된 개수: ", $selected.length);
	$selected.each(function(index, data) {
		console.log(index, data);
	});
});
