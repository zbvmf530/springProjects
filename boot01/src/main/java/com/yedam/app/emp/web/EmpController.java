package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	// 전체조회
	@GetMapping("empList")
	public String empList(Model model) {
		// 1. 기능수행
		List<EmpVO> empList = empService.empList();
		
		// 2. 클라이언트에 전달할 데이터 담기
		model.addAttribute("empList",empList);
		
		// 3. 데이터를 출력할  페이지 결정
		return "emp/list";
	}
	
	// 단건조회
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO,Model model) {
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo",findVO);
		
		return "emp/info";
	}
	
	// 등록 - 페이지
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	// 등록 - 처리(연산, submit)
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.empInsert(empVO);
		String url = null;
		if(eid>-1) {
			url="redirect:empInfo?empid="+eid;
		}
		else {
			url="redirect:empInfo?empList";
		}
		return url;
	}
	// 수정 - 페이지
	// 수정 - 처리(연산,AJAX => QueryString)
	// 수정 - 처리(연산,AJAX => JSON)
	
	// 삭제 - 처리
	
}
