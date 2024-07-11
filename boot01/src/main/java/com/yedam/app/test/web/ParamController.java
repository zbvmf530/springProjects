package com.yedam.app.test.web;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {

	@RequestMapping(path="comobj",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
		String result="";
		result+="path : / comobj\n";
		result+="\t empid : "+empVO.getEmpid();
		result+="\t empname : "+empVO.getEmpname();
		result+="\t hiredate : "+sdf1.format(empVO.getHiredate());
		return result;
	}
	
	@RequestMapping(path="reqparam",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String requestParam(String empname, 
								@RequestParam Integer empid, 
								@RequestParam(name="message",
											  defaultValue = "No message",
											  required = true) String msg) {
		String result="";
		result+="path : / reqparam \n";
		result+="\t empid : "+empid;
		result+="\t empname : "+empname;
		result+="\t message : "+msg;
		return result;
	}
	
	@RequestMapping(path={"path/{id}/{pwd}","path/{id}"})
	@ResponseBody
	public String pathVariable(@PathVariable String id, @PathVariable(name="pwd", required = false) String password) {
		String result="";
		if(password==null) password="default pwd";
		result+="path : /path/{id} \n";
		result+="\t id : "+id;
		result+="\t pwd : "+password;
		return result;
	}
	
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result="";
		result+="path : / resbody\n";
		result+="\t empid : "+empVO.getEmpid();
		result+="\t empname : "+empVO.getEmpname();
		return result;
	}
	
	@PostMapping("resbodyList")
	@ResponseBody
	public String requestBodyList(@RequestBody List<EmpVO> empList) {
		String result="";
		result+="path : / resbodyList\n[\n";
		for(EmpVO empVO : empList) {		
			result+="\t {empid : "+empVO.getEmpid();
			result+="\t empname : "+empVO.getEmpname()+"},\n";			
		}
		result+="]";
		return result;
	}
}
