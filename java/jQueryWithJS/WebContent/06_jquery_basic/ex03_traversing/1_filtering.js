$(document).ready(function() {
	var $selected = $("#org");
	// checkbox 중에서 2번 index 요소
	// --선택된 개수: 1

	// tr요소 중 th를 가진 요소 선택
	// --선택된 개수: 1

	// tr 중 짝수 index 요소 중 index가 2인 요소
	// --선택된 개수: 1

	// input 요소 중 요소의 type이 email이거나 text인 경우 선택
	// --선택된 개수: 2

	// input 요소 중 요소의 type이 email이나 text가 아닌 경우 선택
	// --선택된 개수: 10

	// 위에서 선택된 요소에 radio 가 있는지 여부를 console에 출력하시오.
	// --radio 요소가 있음 출력

	// 위에서 선택된 요소에 단일 선택용 select(요소의 type이 select-one)가 있는지 여부를 console에 출력하시오.
	// --select-one이 있음 출력

	// td에서 값이 비어있는 것들 중 처음 요소
	// --선택된 개수: 1

	// checked된 상태의 요소 중 마지막 요소
	// --선택된 개수: 1

	// li 요소들의 텍스트($(elem).text())를 대괄로호 감싼 내용의 2번째 인덱스의 내용
	// --[캡틴아메리카] 출력

	// 값이 있는 td 중 2 <=x < 5 사이의 요소
	// --선택된 개수: 3

	// 결과 검증
	$selected.wrap("<span class='matched'>");
	console.log("선택된 개수: ", $selected.length);
	$selected.each(function(index, data) {
		console.log(index, data);
	});
});

