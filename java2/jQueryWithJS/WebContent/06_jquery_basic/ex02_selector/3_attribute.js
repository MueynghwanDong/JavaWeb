$(document).ready(function() {
	var $selected = $("#org");
	/*------속성 선택자-----*/
	// lang 속성이 있는 p 태그
	// --선택된 개수: 1

	// type 속성이 text인 input
	// --선택된 개수: 1

	// type 속성이 text가 아닌 input
	// --선택된 개수: 11

	// title 속성에 Hello가 단어 수준으로 들어있는 p 태그
	// --선택된 개수: 1

	// class 속성이 i로 시작하는 모든 태그
	// --선택된 개수: 1

	// id 속성이 s로 끝나는 모든 태그
	// --선택된 개수: 3

	// type에 t가 포함된 input 요소
	// --선택된 개수: 4

	// 모든 요소 중 id 속성이 s로 끝나고 value 속성이 있는 것
	// --선택된 개수: 1
	
	// 결과 검증
	$selected.wrap("<span class='matched'>");
	console.log("선택된 개수: ", $selected.length);
	$selected.each(function(index, data) {
		console.log(index, data);
	});
});
