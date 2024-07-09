package com.yedam.spring.java;

public class Restaurant {
	private Chef chef;
	
	public void setChef(Chef chef) {
		System.out.println("setter Injection");
		this.chef = chef;
	}
	
	public Restaurant(Chef chef) {
		System.out.println("constructor Injection");
		this.chef = chef;
	}
	
	public Restaurant() {}
	
	public Chef getChef() {
		return this.chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
