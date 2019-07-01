package com.ntuzy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntuzy.dao.CustomerMapper;
import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerMapper customerMapper;

	@Override
	public void saveCustomer(Customer customer) {
		customerMapper.saveCustomer(customer);
		int i = 1 / 0;
		customerMapper.saveCustomer(customer);
	}

}
