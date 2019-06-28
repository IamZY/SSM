package com.ntuzy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	// 在Controller方法完成之后被执行
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("执行MyInterceptor1的afterCompletion");
	}

	// 在Controller方法执行之后被执行
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("执行MyInterceptor1的postHandle");
	}

	// 在Controller方法执行之前被执行
	/**
	 * 该方法的返回值，代表是否继续执行Controller方法 true：继续执行 false:不执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("执行MyInterceptor1的preHandle");
		return true;
	}

}
