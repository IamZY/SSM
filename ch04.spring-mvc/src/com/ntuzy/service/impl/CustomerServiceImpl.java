package com.ntuzy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerDao customerDao;
	
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Customer findById(Long id) {
		return customerDao.findById(id);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(Long[] custIds) {
		if(custIds != null) {
			for(Long id : custIds) {
				customerDao.delete(id);
			}
		}
	}

}
