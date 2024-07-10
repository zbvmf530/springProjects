package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private Integer empid;
	private int mgr, deptid;
	private double sal;
	private String empname;
	private Date hiredate;
}
