package com.ntuzy.Test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ntuzy.domain.Customer;
import com.ntuzy.utils.SessionUtils;

/**
 * 刚开始Config 需要右击 BuildPath=> use as source path
 * 
 * @author IamZY
 *
 */
public class Demo2 {

	public static void main(String[] args) throws IOException {
		SqlSession sqlSession = SessionUtils.getSession();
		// 执行操作
		Customer customer = new Customer();
		customer.setName("张三");
		customer.setGender("男");
		customer.setTelephone("111111111");
		sqlSession.insert("insertCustomer", customer);
		// 更新造作 需要提交事务
		sqlSession.commit();

		// 关闭连接
		sqlSession.close();

	}

}
