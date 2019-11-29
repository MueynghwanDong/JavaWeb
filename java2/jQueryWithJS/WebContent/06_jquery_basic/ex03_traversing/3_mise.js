$(document).ready(function() {
    var $selected = $("#org");
    // 모든 hn 태그와 select 태그
    
    // div의 자손 중 id가 name인 요소와 div 자신
    
    // body의 자손 중 ul의 모든 자식 요소(텍스트 포함)
    
    // ul의 자손 중 짝수번째 index 요소의 배경은 blue, 홀수번째 요소를 yellow로 처리
    
    $selected.wrap("<span class='matched'>");
    $selected.each(function(index, data) {
        console.log(index, data);
    });
});
