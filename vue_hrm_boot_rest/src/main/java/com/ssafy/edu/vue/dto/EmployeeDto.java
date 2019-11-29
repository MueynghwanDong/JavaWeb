package com.ssafy.edu.vue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String name;
    private String mailid;
    private String start_date;
    private Integer manager_id;
    private String title;
    private Integer dept_id;
    private Double salary;
    private Double commission_pct;
}