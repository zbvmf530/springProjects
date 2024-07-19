package com.yedam.app.rent.service;

import java.util.Date;

import lombok.Data;

@Data
public class RentVO {
	private Integer rentNo;
	private Integer bookNo;
	private Integer rentPrice;
	private String rentStatus;
	private String bookName;	
	private Integer total;
	private Integer count;
	private Date rentDate;
}
