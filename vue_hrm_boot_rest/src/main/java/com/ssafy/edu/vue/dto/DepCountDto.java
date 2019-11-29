package com.ssafy.edu.vue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 부서별 소속 인원
public class DepCountDto {
	private Integer dept_id;
	private String name;
	private Integer count;
	
	
}
