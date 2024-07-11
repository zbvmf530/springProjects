package com.yedam.app.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class TestController {
	@Autowired
	EmpMapper empMapper;
	
	@RequestMapping("test")
	@ResponseBody
	public String userTest(String keyword) {
		return "Server Response: "+keyword;
	}
	
	// @RequestMapping(path="/sample", method=RequestMethod.GET)
	@GetMapping("sample")
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response: SELECT - "+keyword;
	}
	
	// @RequestMapping(path="/sample", method=RequestMethod.POST)
	@PostMapping("sample")
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server Response: INSERT - "+keyword;
	}
	
	@GetMapping("param")
	@ResponseBody
	public EmpVO paramGetTest(EmpVO empVO) {
		
		EmpVO emp = new EmpVO();
		emp = empMapper.selectEmpInfo(empVO);
		return emp;
	}
}
