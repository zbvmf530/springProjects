package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {
	@Autowired
	DeptService deptService;
	
	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		// 1. 기능수행
		List<DeptVO> deptList = deptService.deptList();
		
		// 2. 클라이언트에 전달할 데이터 담기
		model.addAttribute("deptList",deptList);
		
		// 3. 데이터를 출력할  페이지 결정
		return "dept/list";
	}
	
	// 단건조회
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO,Model model) {
		
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo",findVO);
		
		return "dept/info";
	}
	
	// 등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	// 등록 - 처리(연산, submit)
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int did = deptService.deptInsert(deptVO);
		String url = null;
		if(did>-1) {
			url="redirect:deptInfo?deptid="+did;
		}
		else {
			url="redirect:deptInfo?deptList";
		}
		return url;
	}
	// 수정 - 페이지
	// 수정 - 처리(연산,AJAX => QueryString)
	// 수정 - 처리(연산,AJAX => JSON)
	
	// 삭제 - 처리
	
}
