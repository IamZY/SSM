package com.ntuzy.controller;

import javax.jws.WebParam.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name","Spring Mvc");
		
		mv.setViewName("success");
		
		return mv;
	}
	
	
}
