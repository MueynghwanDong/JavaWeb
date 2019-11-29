$(document).ready(function() {
	var $selected = $("#org");
	/*-- 위치 필터 선택자-----*/
	// 홀수번째에 등장하는 <p>
	// --선택된 개수: 4
	
	// 짝수번째에 등장하는 <p>
	// --선택된 개수: 5
	
	// 처음 등장하는 <p>
	// --선택된 개수: 1
	
	// 마지막에 등장하는 <p>
	// --선택된 개수: 1
	
	// li 중에 부모 태그 기준으로 index가 2인 요소
	// --선택된 개수: 4
	
	// li 중에 index가 2보다 큰 요소
	// --선택된 개수: 1
	
	// li 중에 index가 2보다 작은 요소
	// --선택된 개수: 2
	
	// 자식들 중 <p>가 첫째로 등장한 경우
	// --선택된 개수: 1
	
	// 자식들 중 <p>가 막내로 등장한 경우
	// --선택된 개수: 1
	
	// <li> 중 1,4,7 번째에 나온 경우
	// --선택된 개수: 2
	
	// 자식 <p>들 중 처음 등장한 경우
	// --선택된 개수: 4
	
	// 요소:last-of-type - 자식 <p>들 중 마지막 등장한 경우
	// --선택된 개수: 4
	
	// 요소:nth-of-type - <li> 중 짝수번째에 나온 경우
	// --선택된 개수: 4
	
	// 결과 검증
	$selected.wrap("<span class='matched'>");
	console.log("선택된 개수: ", $selected.length);
	$selected.each(function(index, data) {
		console.log(index, data);
	});
});
