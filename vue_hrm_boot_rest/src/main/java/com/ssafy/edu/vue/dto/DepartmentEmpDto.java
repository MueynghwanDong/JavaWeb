package com.ssafy.edu.vue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEmpDto {
    private Integer eid;
    private String ename;
    private String emailid;
    private Integer deptid;
    private String dname;
}
