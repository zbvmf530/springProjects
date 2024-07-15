package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired // 필드 주입
	DeptMapper deptMapper;
	
	@Override
	public List<DeptVO> deptList() {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO deptInfo(DeptVO DeptVO) {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptInfo(DeptVO);
	}

	@Override
	public int deptInsert(DeptVO DeptVO) {
		// TODO Auto-generated method stub
		int result = deptMapper.insertDeptInfo(DeptVO);
		return result == 1 ? DeptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> deptUpdate(DeptVO DeptVO) {
		// TODO Auto-generated method stub
		boolean isSuccessed = false;
		Map<String, Object> map = new HashMap<String, Object>();
		int result = deptMapper.updateDeptInfo(DeptVO.getDepartmentId(), DeptVO);
		
		if(result == 1) {isSuccessed = true;}
		map.put("result", isSuccessed);
		map.put("target", DeptVO);
		return map;
	}

	@Override
	public Map<String, Object> deptDelete(DeptVO DeptVO) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int result = deptMapper.deleteDeptInfo(DeptVO.getDepartmentId());
		
		if(result == 1) {map.put("Deptid", DeptVO.getDepartmentId());}
		
		return map;
	}

}
