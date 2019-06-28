package com.ntuzy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	// ��Controller�������֮��ִ��
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("ִ��MyInterceptor1��afterCompletion");
	}

	// ��Controller����ִ��֮��ִ��
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("ִ��MyInterceptor1��postHandle");
	}

	// ��Controller����ִ��֮ǰ��ִ��
	/**
	 * �÷����ķ���ֵ�������Ƿ����ִ��Controller���� true������ִ�� false:��ִ��
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("ִ��MyInterceptor1��preHandle");
		return true;
	}

}
