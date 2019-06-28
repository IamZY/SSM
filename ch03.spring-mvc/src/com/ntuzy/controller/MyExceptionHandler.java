package com.ntuzy.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class MyExceptionHandler {
	/**
	 * “Ï≥£¥¶¿Ì {@value}
	 * 
	 * @return
	 */
	@ExceptionHandler(value = { java.lang.NullPointerException.class })
	public ModelAndView ExceptionHandler(Exception ex) {
		ModelAndView mv = new ModelAndView();
		StringWriter writer = new StringWriter();
		PrintWriter s = new PrintWriter(writer);
		ex.printStackTrace(s);
		mv.addObject("ex", writer.toString());
		mv.setViewName("error");
		return mv;
	}
}
