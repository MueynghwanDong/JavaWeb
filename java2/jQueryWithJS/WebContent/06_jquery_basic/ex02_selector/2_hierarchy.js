$(document).ready(function() {
	var $selected = $("#org");
	/*------hierarchy 선택자-----*/
	// 자손 선택자 - body 아래 있는 자손 p
	// --선택된 개수:  9
	
	// 자식 선택자 - body 아래 있는 자식 p
	// --선택된 개수:  3
	
	// 바로 동생 선택자 - label 중에 클래스가 front인 요소 다음에 등장하는 input 요소들
	// --선택된 개수:  3
	
	// id가 name인 요소의 동생 label들
	// --선택된 개수:  2
	
	$selected.wrap("<span class='matched'>");
	console.log("선택된 개수: ", $selected.length);
	$selected.each(function(index, data) {
		console.log(index, data);
	});
});
