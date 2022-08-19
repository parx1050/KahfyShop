package com.kahfy.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@PostMapping("/logout")
	public String logout() {
		
		return "redirect:http://localhost:8080/Shyu_Parker_Kahfy_SpringMVC/kahfy/home";
	}

}
