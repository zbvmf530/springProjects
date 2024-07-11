package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired // 필드 주입
	EmpMapper empMapper;
	
	@Override
	public List<EmpVO> empList() {
		// TODO Auto-generated method stub
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO empInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int empInsert(EmpVO empVO) {
		// TODO Auto-generated method stub
		int result = empMapper.insertEmpInfo(empVO);
		return result == 1 ? empVO.getEmpid() : -1;
	}

	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		// TODO Auto-generated method stub
		boolean isSuccessed = false;
		Map<String, Object> map = new HashMap<String, Object>();
		int result = empMapper.updateEmpInfo(empVO.getEmpid(), empVO);
		
		if(result == 1) {isSuccessed = true;}
		map.put("result", isSuccessed);
		map.put("target", empVO);
		return map;
	}

	@Override
	public Map<String, Object> empDelete(EmpVO empVO) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int result = empMapper.deleteEmpInfo(empVO.getEmpid());
		
		if(result == 1) {map.put("empid", empVO.getEmpid());}
		
		return map;
	}

}
