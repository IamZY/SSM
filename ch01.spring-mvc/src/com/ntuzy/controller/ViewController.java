package com.ntuzy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class ViewController {

	@RequestMapping("/test1")
	public void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 不经过视图解析器
		// request.getRequestDispatcher("success").forward(request, response);
		// 不能重定向到WEB-INF下
		// response.sendRedirect(request.getContextPath() + "/success.jsp");
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	@RequestMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("name", "sss");
		return "success";
	}

	/**
	 * 重定向
	 * @return
	 */
	@RequestMapping("/test4")
	public String test4() {
		return "redirect:/index.jsp";
	}
	

}
