package com.ntuzy.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

	@RequestMapping("/test1")
	public String test1() {
		System.out.println("test1......");
		String name = null;
		name.toLowerCase();
		return "success";
	}

	
	@RequestMapping("/test2")
	public String test2() {
		System.out.println("test2......");
		int i =  1/0;
		return "success";
	}
	
	@RequestMapping("/test3")
	public String test3() {
		int[] ids = new int[1];
		ids[2] = 10;
		return "success";
	}

	
}
