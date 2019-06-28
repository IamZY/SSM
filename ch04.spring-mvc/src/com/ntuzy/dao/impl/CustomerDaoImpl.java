package com.ntuzy.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Repeat;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.domain.Customer;

@Repository
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = this.getHibernateTemplate().loadAll(Customer.class);
		return customerList;
	}

	@Override
	public Customer findById(Long id) {
		return this.getHibernateTemplate().get(Customer.class, id);
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	@Override
	public void delete(Long id) {
		this.getHibernateTemplate().delete(findById(id));
	}

}
