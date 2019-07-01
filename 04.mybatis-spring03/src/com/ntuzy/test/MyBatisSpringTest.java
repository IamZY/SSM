package com.ntuzy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ntuzy.dao.CustomerMapper;
import com.ntuzy.domain.Customer;

public class MyBatisSpringTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerMapper customerMapper = (CustomerMapper) ac.getBean("customerMapper");
		Customer customer = new Customer();
		customer.setName("¿œ¿Ó");
		customer.setGender("≈Æ");
		customer.setTelephone("666666666666");
		customer.setAddress("bj");
		customerMapper.saveCustomer(customer);
		
	}
	
	
	
}
