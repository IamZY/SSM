package com.ntuzy.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ntuzy.domain.Customer;
import com.ntuzy.utils.SessionUtils;

/**
 * 刚开始Config 需要右击 BuildPath=> use as source path
 * 
 * @author IamZY
 *
 */
public class Demo3 {

	@Test
	public void test1() {
		SqlSession sqlSession = SessionUtils.getSession();

		Customer customer = new Customer();
		customer.setName("李四");
		customer.setGender("女");
		customer.setTelephone("2222222222222");

		sqlSession.insert("insertCustomer", customer);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test2() {
		SqlSession sqlSession = SessionUtils.getSession();
		Customer customer = new Customer();
		customer.setId(3);
		customer.setName("李四");
		sqlSession.update("updateCustomer", customer);

		sqlSession.commit();
		sqlSession.close();

	}

	@Test
	public void test3() {
		SqlSession sqlSession = SessionUtils.getSession();

		List<Customer> custList = sqlSession.selectList("queryAllCustomer");

		for (Customer c : custList) {
			System.out.println(c);
		}

		sqlSession.close();

	}

	@Test
	public void test4() {
		SqlSession sqlSession = SessionUtils.getSession();
		Customer customer = sqlSession.selectOne("queryCustomerById", 1);
		System.out.println(customer);
		sqlSession.close();
	}

	@Test
	public void test5() {
		SqlSession sqlSession = SessionUtils.getSession();
		List<Customer> custList = sqlSession.selectList("queryCustomerByName", "%张%");

		for (Customer customer : custList) {
			System.out.println(customer);
		}

		sqlSession.close();
	}

	@Test
	public void test6() {
		SqlSession sqlSession = SessionUtils.getSession();
		sqlSession.delete("deleteCustomer", 3);
		sqlSession.commit();
		sqlSession.close();
	}

}
