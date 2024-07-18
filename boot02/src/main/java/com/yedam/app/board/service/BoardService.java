package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;


public interface BoardService {
	// 전체조회
	public List<BoardVO> brdList();
	
	// 단건조회
	public BoardVO brdInfo(BoardVO boardVO);
	
	// 등록
	public int brdInsert(BoardVO boardVO);
	
	// 수정
	public Map<String,Object> brdUpdate(BoardVO boardVO);
	
	//삭제
	public int brdDelete(int boardNo);
}

