package com.ntuzy.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ntuzy.dao.CustomerMapper;
import com.ntuzy.domain.Customer;

public class CustomerMapperImpl extends SqlSessionDaoSupport implements CustomerMapper {

	@Override
	public void saveCustomer(Customer customer) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("saveCustomer", customer);
		// 不需要事务提交 Spring框架自动提交
	}

}
