package com.ntuzy.Test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.dao.OrderDao;
import com.ntuzy.dao.UserDao;
import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.domain.Customer;
import com.ntuzy.domain.CustomerRM;
import com.ntuzy.domain.CustomerVo;
import com.ntuzy.domain.Order;
import com.ntuzy.domain.OrderUser;
import com.ntuzy.domain.User;
import com.ntuzy.utils.SessionUtils;

public class Demo4 {

	@Test
	public void test1() {

		SqlSession sqlSession = SessionUtils.getSession();
		OrderDao dao = sqlSession.getMapper(OrderDao.class);
		List<OrderUser> list = dao.queryOrderUser();

		for (OrderUser ou : list) {
			System.out.println(ou.getName() + "--" + ou.getProductname());
		}

		sqlSession.close();
	}

	@Test
	public void test2() {

		SqlSession sqlSession = SessionUtils.getSession();
		OrderDao dao = sqlSession.getMapper(OrderDao.class);
		List<Order> orders = dao.queryOrderUserResultMap();

		for (Order ou : orders) {
			System.out.println(ou.getUser().getName() + "--" + ou.getProductname());
		}

		sqlSession.close();
	}

	@Test
	public void test3() {

		SqlSession sqlSession = SessionUtils.getSession();
		UserDao dao = sqlSession.getMapper(UserDao.class);

		List<User> users = dao.queryUserOrder();

		for (User ou : users) {
			System.out.println(ou.getName());
			for (Order order : ou.getOrders()) {
				System.out.println(order.getProductname());
			}
		}

		sqlSession.close();
	}

}
