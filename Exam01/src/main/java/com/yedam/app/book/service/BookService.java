package com.yedam.app.book.service;

import java.util.List;

public interface BookService {
	public BookVO getBook(BookVO vo);
	public List<BookVO> getBookList();
	public BookVO getMaxBookNo();
	int insertBook(BookVO vo);
}
