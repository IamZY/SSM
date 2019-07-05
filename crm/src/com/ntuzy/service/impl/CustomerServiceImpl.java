package com.ntuzy.service.impl;

import java.util.List;

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
	public List<Customer> findAll() {
		return customerMapper.findAll();
	}

}
