package com.ntuzy.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception ex) {

		// 取出异常信息
		StringWriter writer = new StringWriter();
		PrintWriter s = new PrintWriter(writer);
		ex.printStackTrace(s);

		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", writer.toString());
		mv.setViewName("error");
		return mv;
	}

}
