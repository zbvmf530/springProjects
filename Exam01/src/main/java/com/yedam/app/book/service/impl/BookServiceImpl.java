package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public BookVO getBook(BookVO vo) {
		// TODO Auto-generated method stub
		return bookMapper.getBook(vo);
	}

	@Override
	public List<BookVO> getBookList() {
		// TODO Auto-generated method stub
		return bookMapper.getBookList();
	}

	@Override
	public int insertBook(BookVO vo) {
		// TODO Auto-generated method stub
		return bookMapper.insertBook(vo);
	}

	@Override
	public BookVO getMaxBookNo() {
		// TODO Auto-generated method stub
		return bookMapper.getMaxBookNo();
	}

}
