package com.yedam.app.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> bList = bookService.getBookList();
		model.addAttribute("books",bList);
		return "book/bookList";
	}
	
	@GetMapping("home")
	public String bookHome() {
		return "home";
	}
	
	@GetMapping("bookInsert")
	public String bookInsert(Model model) {
		BookVO newBook = bookService.getMaxBookNo();
		newBook.setBookNo(newBook.getBookNo()+1);
		model.addAttribute("book", newBook);
		return "book/bookInsert";
	}
	
	 @PostMapping("bookInsert")
	public String empInsertProc(BookVO vo) {
		// 커맨드객체
		//logger.debug(vo.toString());
		System.out.println(vo);
		bookService.insertBook(vo);
		//System.out.println(vo.getEmployeeId() + "사번 등록");
		return "redirect:bookList";
	}
}
