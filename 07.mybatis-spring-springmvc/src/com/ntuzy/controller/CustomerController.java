package com.ntuzy.controller;

import javax.print.attribute.standard.RequestingUserName;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// 
	private CustomerService customerService;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("test....");
		return "test";
	}
	
	@RequestMapping("/input")
	public String input() {
		return "input";
	}
	
	
	@RequestMapping("/save")
	public String save(Customer customer) {
		customerService.saveCustomer(customer);
		return "test";
	}
	
	
}
