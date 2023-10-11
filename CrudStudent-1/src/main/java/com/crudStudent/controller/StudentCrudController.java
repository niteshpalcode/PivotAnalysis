package com.crudStudent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentCrudController {

	
	
	@GetMapping("/home")
	public String homePage() {
		System.out.println("home page");
		return "myhome";
	}
}
