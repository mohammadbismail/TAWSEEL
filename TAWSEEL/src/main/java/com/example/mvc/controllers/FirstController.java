package com.example.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

	@GetMapping("/")
	public String dashboardPage() {
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/hi")
	public String restuarant() {
		return"menu2.jsp";
	}
	@GetMapping("/hola")
	public String show() {
		return "show.jsp";
	}
}
