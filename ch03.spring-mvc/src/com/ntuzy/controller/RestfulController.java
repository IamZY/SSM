package com.ntuzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ntuzy.domain.User;

@Controller
@RequestMapping("/restful")
public class RestfulController {

	/**
	 * ��ѯ����
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String testGet(){
		System.out.println("ִ��RestfulController��testGet");
		return "success";
	}

	/**
	 * ��������
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String testPost(User user){
		System.out.println("ִ��RestfulController��testPost");
		System.out.println(user);
		return "success";
	}
	
	/**
	 * ���²���
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public String testPut(User user){
		System.out.println("ִ��RestfulController��testPut");
		System.out.println(user);
		return "success";
	}
	
	/**
	 * ɾ������
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable("id")Integer id){
		System.out.println("ִ��RestfulController��testDelete");
		System.out.println(id);
		return "success";
	}
	
}
