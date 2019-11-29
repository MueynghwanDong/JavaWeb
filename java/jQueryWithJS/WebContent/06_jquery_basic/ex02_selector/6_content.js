$(document).ready(function() {
	var $selected = $("#org");
	/*-- 함수 필터 선택자-----*/
	// 내용에 '요'를 <p>포함하는 요소
	// --선택된 개수: 2
	
	// 자식 요소가 없고 텍스트도 비어있는 요소
	// --선택된 개수: 1
	
	// 내용이 있는 td
	// --선택된 개수: 7
	
	// 요소:has(자손요소) - <form> 중 자손으로 <option>를 가지는 요소
	// --선택된 개수: 1
	
	// 요소:not(선택자) - <div> 중 class가 intro가 아닌 요소
	// --선택된 개수: 1
	
	// :header - 모든 <hn>태그
	// --선택된 개수: 3
	
	// 결과 검증
	$selected.wrap("<span class='matched'>");
	console.log("선택된 개수: ", $selected.length);
	$selected.each(function(index, data) {
		console.log(index, data);
	});
});
