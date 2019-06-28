package com.ntuzy.controller;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ntuzy.domain.User;
import com.ntuzy.domain.UserVo;

@Controller
@RequestMapping("/param")
public class ParamController {

	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public String test1(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("userPass");
		System.out.println(userName + "---" + passWord);
		return "success";
	}

	@RequestMapping(value = "/test2/{userName}/{userPass}", method = RequestMethod.POST)
	public String test2(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "userPass") String userPass) {
		System.out.println(userName + "---" + userPass);
		return "success";
	}

	/**
	 * @RequestParam() 指定参数名称 required=false 该参数不是必须的 可以为空 defalutValue 默认值
	 * @param userName
	 * @param userPass
	 * @return
	 */
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public String test3(@RequestParam(value = "name", required = false, defaultValue = "tom") String userName,
			String userPass) {
		System.out.println(userName + "---" + userPass);
		return "success";
	}

	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	public String test4(User user) {
		System.out.println(user.getUserPass() + "---" + user.getUserName());
		return "success";
	}

	@RequestMapping(value = "/test5", method = RequestMethod.POST)
	public String test5(UserVo userVo) {
		System.out.println(
				userVo.getUser().getUserName() + "---" + userVo.getUser().getUserPass() + "---" + userVo.getGender());
		return "success";
	}

	/**
	 * 6.绑定数组类型
	 */
	@RequestMapping(value = "/test6", method = RequestMethod.POST)
	public String test6(@RequestParam("custId") Integer[] id) {
		System.out.println(Arrays.asList(id));
		return "success";
	}

	/**
	 * 7.自定义参数类型转换
	 */
	@RequestMapping(value = "/test7", method = RequestMethod.POST)
	public String test7(Date birth) {
		System.out.println(birth);
		return "success";
	}

}
