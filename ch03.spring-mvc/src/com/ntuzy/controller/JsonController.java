package com.ntuzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ntuzy.domain.User;

@Controller
@RequestMapping("/json")
public class JsonController {

	/**
	 * @RequestBody 接受页面的json数据
	 * @param user
	 * @return
	 */
	@RequestMapping("/test1")
	@ResponseBody
	public User test1(@RequestBody User user) {
		return user;
	}

}
