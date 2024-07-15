package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	Integer departmentId, managerId, locationId;
	String departmentName; 
}
