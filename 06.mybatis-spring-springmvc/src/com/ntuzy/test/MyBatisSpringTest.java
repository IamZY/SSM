package com.ntuzy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ntuzy.dao.CustomerMapper;
import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

public class MyBatisSpringTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = (CustomerService) ac.getBean("customerService");
		Customer customer = new Customer();
		customer.setName("aaa");
		customer.setGender("Ů");
		customer.setTelephone("666666666666");
		customer.setAddress("bj");
		customerService.saveCustomer(customer);
		
	}
	
	
	
}
