package com.ntuzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
	
	@RequestMapping("/test1")
	public String test1() {
		System.out.println("test1.....");
		return "success";
	}
	
}
