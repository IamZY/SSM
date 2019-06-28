package com.ntuzy.dao;

import java.util.List;

import com.ntuzy.domain.Customer;

public interface CustomerDao {
	
	public void save(Customer customer);
	public List<Customer> findAll();
	public Customer findById(Long id);
	public void update(Customer customer);
	public void delete(Long id);
}
