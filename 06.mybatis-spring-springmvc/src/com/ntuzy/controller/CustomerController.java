package com.ntuzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/test")
	public String test() {
		
		System.out.println("test....");
		
		return "test";
	}
	
}
