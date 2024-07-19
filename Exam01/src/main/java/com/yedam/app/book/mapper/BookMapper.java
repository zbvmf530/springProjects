package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;

public interface BookMapper {
	public BookVO getBook(BookVO vo);
	public List<BookVO> getBookList();
	public BookVO getMaxBookNo();
	int insertBook(BookVO vo);
}
