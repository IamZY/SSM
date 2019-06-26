package com.ntuzy.dao;

import java.util.List;

import com.ntuzy.domain.Customer;
import com.ntuzy.domain.CustomerRM;
import com.ntuzy.domain.CustomerVo;

import net.sf.cglib.core.internal.CustomizerRegistry;

public interface CustomerDao {

	public void saveCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Integer id);

	public List<Customer> queryAllCustomer();

	public Customer queryCustomerById(Integer id);

	public List<Customer> queryCustomerByName(String name);
	
	
	//  ‰»Î”≥…‰
//	public void testParameterType(String name);
//	public void testParameterType(Customer customer);
	public void testParameterType(CustomerVo customerVo);
	
	
	public Long queryTotalCount();
	
	public Customer queryCustomer(Integer id);
	
	public CustomerRM queryCustomerResultMap(Integer id);
	
	public List<Customer> queryCustomerByNameAndTelephone(String name,String telephone);

	public void deleteCustomerByIn(Customer customer);

}
