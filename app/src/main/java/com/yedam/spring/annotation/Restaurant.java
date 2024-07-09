package com.yedam.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	private Chef chef;
	
	public Restaurant(Chef chef) {
		System.out.println("constructor Injection");
		this.chef = chef;
	}
	
	public Restaurant() {}
	
	public Chef getChef() {
		return this.chef;
	}
	@Autowired
	public void setChef(Chef chef) {
		System.out.println("setter Injection");
		this.chef = chef;
	}
	public void run() {
		chef.cooking();
	}
}
