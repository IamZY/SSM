package com.ntuzy.dao;

import java.util.List;

import com.ntuzy.domain.Customer;

public interface CustomerMapper {
	
	/**
	 * 查询所有数据信息
	 */
	public List<Customer> findAll();
	
}
