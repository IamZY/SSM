package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

public class CustomerServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		CustomerService customerService = (CustomerService) ac.getBean("customerServiceImpl");
		Customer customer = new Customer();
		customer.setCustName("уехЩ");
		customer.setCustTelephone("1111111111111");
		customerService.save(customer );
	}
	
}
