package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// 전체
	public List<EmpVO> selectEmpAll();
	// 단건
	public EmpVO selectEmpInfo(EmpVO empVO);
	// 등록
	public int insertEmpInfo(EmpVO empVO);
	// 수정
	public int updateEmpInfo(@Param("id")int empId, @Param("emp")EmpVO empVO);
	// 삭제
	public int deleteEmpInfo(int empId);

}
