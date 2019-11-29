$(document).ready(function() {
	var $selected = $("#org");
    // id가 org인 요소의 부모의 부모
	// --선택된 개수: 1
    
    // id가 name인 요소의 조상 중 relative 또는 absolute인 요소
	// --선택된 개수: 1
    
    // id가 org인 요소의 조상 중 html은 제거
	// --선택된 개수: 3
    
    // legend의 조상들 중 가장 가까운 basic class 요소
	// --선택된 개수: 1
    
    // <ul>의 자식들중 짝수번째 index의 요소
	// --선택된 개수: 2
    
    // body 하위의 div 요소의 하위 요소 중 id가 org인 요소
	// --선택된 개수: 1
    
    // id가 email 인 요소의 형제 중 label 요소
	// --선택된 개수: 3
    
    // id가 sports 인 요소의 바로 밑 동생 중 label 요소
	// --선택된 개수: 1
    
    // <option>에서 selected된 이후의 모든 동생 option 요소
	// --선택된 개수: 1
    
    // id가 pass인 요소의 바로 위 형
	// --선택된 개수: 1
    
    // id가 pass인 요소의  형 라벨 들
	// --선택된 개수: 3
    
	// 결과 검증
	$selected.wrap("<span class='matched'>");
	console.log("선택된 개수: ", $selected.length);
	$selected.each(function(index, data) {
		console.log(index, data);
	});
});
