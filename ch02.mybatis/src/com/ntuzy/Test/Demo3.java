package com.ntuzy.Test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.domain.Customer;
import com.ntuzy.domain.CustomerRM;
import com.ntuzy.domain.CustomerVo;
import com.ntuzy.utils.SessionUtils;

public class Demo3 {

	// private CustomerDao dao = new CustomerDaoImpl();

	@Test
	public void test1() {
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		// Customer c = new Customer();
		// c.setName("张三");
		// c.setTelephone("55555555");
		CustomerVo vo = new CustomerVo();
		Customer customer = new Customer();
		customer.setName("结婚后");
		customer.setTelephone("111");
		vo.setCustomer(customer);
		dao.testParameterType(vo);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test2() {
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		Long queryTotalCount = dao.queryTotalCount();
		System.out.println(queryTotalCount);
		sqlSession.close();
	}

	@Test
	public void test3() {
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		Customer customer = dao.queryCustomer(1);
		System.out.println(customer);
		sqlSession.close();
	}

	@Test
	public void test4() {
		SqlSession sqlSession = SessionUtils.getSession();
		// getMapper 返回指定接口的动态代理的实现类对象
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		CustomerRM customer = dao.queryCustomerResultMap(1);
		System.out.println(customer);
		sqlSession.close();
	}

	@Test
	public void test5() {
		SqlSession sqlSession = SessionUtils.getSession();
		Customer c = new Customer();
		c.setName("%陈%");
		// c.setTelephone("%4%");
		List<Customer> custList = sqlSession.selectList("queryCustomerByNameAndTelephone", c);

		for (Customer customer : custList) {
			System.out.println(customer);
		}

	}

	@Test
	public void test6() {

		SqlSession sqlSession = SessionUtils.getSession();
		CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
		Customer customer = new Customer();
		customer.setIds(new Integer[] { 8, 9, 10 });
		dao.deleteCustomerByIn(customer);
		
		sqlSession.commit();
		sqlSession.close();
		
	}

}
