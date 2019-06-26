package com.ntuzy.Test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ntuzy.domain.Customer;

/**
 * 刚开始Config 需要右击 BuildPath=> use as source path
 * 
 * @author IamZY
 *
 */
public class Demo1 {

	public static void main(String[] args) throws IOException {
		// 加载全局文件 SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// SqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory factory = builder.build(inputStream);
		// 创建SqlSession 可用于执行增删改查
		SqlSession sqlSession = factory.openSession();
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
