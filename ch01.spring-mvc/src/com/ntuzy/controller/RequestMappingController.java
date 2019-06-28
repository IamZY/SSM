package com.ntuzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/requestMapping")
public class RequestMappingController {

	@RequestMapping("/test1")
	public ModelAndView test1() {
		System.out.println("test1....");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public ModelAndView test2() {
		System.out.println("test2....");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}

	@RequestMapping(value = "/test3", method = RequestMethod.GET, params = { "name" })
	public ModelAndView test3() {
		System.out.println("test3....");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}

}
