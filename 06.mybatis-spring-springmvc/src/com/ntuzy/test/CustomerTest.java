package com.ntuzy.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ntuzy.dao.CustomerMapper;
import com.ntuzy.domain.Customer;

public class CustomerTest {

	@Test
	public void test() throws IOException {
		// 创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 加载sqlMapperConfig.xml
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 创建sqlSessionFactory
		SqlSessionFactory factory = builder.build(inputStream);
		
		SqlSession sqlSession = factory.openSession();
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		
		Customer customer = new Customer();
		customer.setName("张三");
		customer.setAddress("nj");
		customer.setGender("男");
		customer.setTelephone("11111");
		customerMapper.saveCustomer(customer );
		sqlSession.commit();
		sqlSession.close();
	}
	
}
