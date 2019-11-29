package com.ssafy.edu.vue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
	private Integer dept_id;
	private String name;
	private Integer region_id;	
}
