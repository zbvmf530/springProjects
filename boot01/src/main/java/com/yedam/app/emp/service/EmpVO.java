package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private Integer empid;
	private int mgr;
	private Integer deptid;
	private double sal;
	private String empname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate; // 2024/07/11 -> 2024-07-11
}
