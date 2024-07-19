package com.yedam.app.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	
	private Integer bookNo;
	private String bookName;
	private String bookCoverimg;
	private String bookPublisher;
	private String bookInfo;
	private Integer bookPrice;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date bookDate;
}
