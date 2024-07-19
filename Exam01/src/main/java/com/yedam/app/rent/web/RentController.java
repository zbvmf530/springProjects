package com.yedam.app.rent.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.rent.service.RentService;

@Controller
public class RentController {
	
	@Autowired
	RentService service;
	
	@GetMapping("/rentList")
	public String getRents(Model model) {
		model.addAttribute("rents", service.getRentList());
		return "rent/rentList";
	}
}
