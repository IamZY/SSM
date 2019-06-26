package com.ntuzy.Test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.domain.Customer;
import com.ntuzy.utils.SessionUtils;

public class Demo2 {

//	private CustomerDao dao = new CustomerDaoImpl();

	@Test
	public void test1() {
		Customer customer = new Customer();
		customer.setName("陈留");
		customer.setGender("男");
		customer.setTelephone("555555555555");

		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		dao.saveCustomer(customer);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test2() {
		Customer c = new Customer();
		c.setId(5);
		c.setName("李四");
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		dao.updateCustomer(c);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test3() {
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		dao.deleteCustomer(8);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test4() {
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		List<Customer> list = dao.queryAllCustomer();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

	@Test
	public void test5() {
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		Customer customer = dao.queryCustomerById(1);
		System.out.println(customer);
	}

	@Test
	public void test6() {
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		List<Customer> list = dao.queryCustomerByName("%陈%");
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

}
