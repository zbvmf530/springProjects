package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	@Autowired
	EmpMapper empMapper;
	@Test
	void contextLoads() {
		assertNotNull(empMapper);
	}
	
	//@Test
	void selectEmpAll() {
		List<EmpVO> empList = empMapper.selectEmpAll();
		assertFalse(empList.isEmpty());
	}
	
	//@Test
	void selectEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(114);
		EmpVO findedEmp = empMapper.selectEmpInfo(empVO);
		assertEquals(findedEmp.getEmpname(),"Den");
	}
	
	@Test
	void insertEmpInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmpname("NewHong");
		emp.setDeptid(40);
		emp.setSal(1000);
		
		int result = empMapper.insertEmpInfo(emp);
		
		assertEquals(emp.getEmpid(), 207);
	}
	
	//@Test
	void updateEmpInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmpid(206);
		
		EmpVO findVO = empMapper.selectEmpInfo(emp);
		findVO.setEmpname("Kim");
		findVO.setSal(4000);
		int result = empMapper.updateEmpInfo(findVO.getEmpid(),findVO);
		
		assertEquals(result, 1);
	}
	
	//@Test
	void deleteEmpInfo() {
		int result = empMapper.deleteEmpInfo(207);
		
		assertEquals(result, 1);
	}
}
