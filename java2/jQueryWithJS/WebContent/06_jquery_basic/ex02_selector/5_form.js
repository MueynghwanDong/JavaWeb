$(document).ready(function() {
	var $selected = $("#org");
	/*-- 입력 양식 필터 선택자-----*/
	// 요소:type_name - 모든 input 요소
	// --선택된 개수: 12개
	
	// 요소:type_name - 사용자가 값을 입력할 수 있는 모든 요소
	// --선택된 개수: 13개
	
	// 요소:type_name - input 중에서 속성이 text 인 요소
	// --선택된 개수: 1
	
	// 요소:type_name - input 중에서 속성이 password 인 요소
	// --선택된 개수: 1
	
	// 요소:type_name - input 중에서 속성이 radio 인 요소
	// --선택된 개수: 3
	
	// 요소:상태 - input 가능한 요소 중 enabled 인 상태의 요소
	// --선택된 개수: 10
	
	// 요소:상태 - input 요소 중 disabled 인 상태의 요소
	// --선택된 개수: 3
	
	// 요소:상태 - option 요소 중 selected 인 상태의 요소
	// --선택된 개수: 1
	
	// 요소:상태 - input 요소 중 checked 인 상태의 요소
	// --선택된 개수: 4
	
	// 요소:상태 - 현재 focus를 받은 요소
	// --선택된 개수: 1
	
	// 결과 검증
	$selected.wrap("<span class='matched'>");
	console.log("선택된 개수: ", $selected.length);
	$selected.each(function(index, data) {
		console.log(index, data);
	});
});
