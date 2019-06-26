package com.ntuzy.Test;

import java.util.List;

import org.junit.Test;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.domain.Customer;

public class Demo1 {

	private CustomerDao dao = new CustomerDaoImpl();

	@Test
	public void test1() {
		Customer customer = new Customer();
		customer.setName("³ÂÁô");
		customer.setGender("ÄĞ");
		customer.setTelephone("444444444");

		dao.saveCustomer(customer);

	}

	@Test
	public void test2() {
		Customer c = new Customer();
		c.setId(1);
		c.setName("ÀîËÄ");

		dao.updateCustomer(c);
	}

	@Test
	public void test3() {
		dao.deleteCustomer(8);
	}

	@Test
	public void test4() {
		List<Customer> list = dao.queryAllCustomer();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

	@Test
	public void test5() {
		Customer customer = dao.queryCustomerById(1);
		System.out.println(customer);
	}

	@Test
	public void test6() {
		List<Customer> list = dao.queryCustomerByName("%³Â%");
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

}
