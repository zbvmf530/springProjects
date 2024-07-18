package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	private BoardMapper brdMapper;
	
	@Autowired // 생성자 주입
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.brdMapper = boardMapper;
	}
	
	@Override
	public List<BoardVO> brdList() {
		// TODO Auto-generated method stub
		return brdMapper.selectBoardAll();
	}

	@Override
	public BoardVO brdInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return brdMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int brdInsert(BoardVO boardVO) {
		// TODO Auto-generated method stub
		int result = brdMapper.insertBoardInfo(boardVO);
		return result == 1 ? boardVO.getBoardNo() : -1;
	}

	@Override
	public Map<String, Object> brdUpdate(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boolean isSuccessed = false;
		Map<String, Object> map = new HashMap<String, Object>();
		int result = brdMapper.updateBoardInfo(boardVO);
		
		if(result == 1) {isSuccessed = true;}
		map.put("result", isSuccessed);
		map.put("target", boardVO);
		
		return map;
	}

	@Override
	public int brdDelete(int boardNo) {
		// TODO Auto-generated method stub
		
		return brdMapper.deleteBoardInfo(boardNo);
	}

}
