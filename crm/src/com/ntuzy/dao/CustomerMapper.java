package com.ntuzy.dao;

import java.util.List;

import com.ntuzy.domain.Customer;

public interface CustomerMapper {
	
	/**
	 * ��ѯ����������Ϣ
	 */
	public List<Customer> findAll();
	
}
