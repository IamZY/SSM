package com.ntuzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping("/test1")
	public String test1() {
		
		
		return "success";
	}
	
}
