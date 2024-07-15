package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@GetMapping("empUpdate")
	public String empUpdateForm(@RequestParam Integer empid, Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(empid);
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo",findVO);
		return "emp/update";
	}
	
	
	// 수정 - 처리(연산,AJAX => QueryString)
	@PostMapping("empUpdate")
	@ResponseBody // => AJAX
	public Map<String,Object> empUpdateAJAXQueryString(EmpVO empVO){
		
		return empService.empUpdate(empVO);
	}
	// 수정 - 처리(연산,AJAX => JSON : @RequestBody)
	//@PostMapping("empUpdate")
	@ResponseBody // => AJAX
	public Map<String,Object> empUpdateAJAXJSON(@RequestBody EmpVO empVO){
		
		return empService.empUpdate(empVO);
	}
	// 삭제 - 처리
	@GetMapping("empDelete")
	public String empDelete(EmpVO empVO) {
		empService.empDelete(empVO);
		return "redirect:empList";
	}
}
