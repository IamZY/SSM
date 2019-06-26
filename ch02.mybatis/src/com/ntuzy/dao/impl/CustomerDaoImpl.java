package com.ntuzy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.domain.Customer;
import com.ntuzy.domain.CustomerRM;
import com.ntuzy.domain.CustomerVo;
import com.ntuzy.utils.SessionUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void saveCustomer(Customer customer) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.insert("insertCustomer", customer);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.update("updateCustomer", customer);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void deleteCustomer(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			sqlSession.update("deleteCustomer", id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Customer> queryAllCustomer() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectList("queryAllCustomer");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public Customer queryCustomerById(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectOne("queryCustomerById", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public List<Customer> queryCustomerByName(String name) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SessionUtils.getSession();
			return sqlSession.selectList("queryCustomerByName", name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}


	@Override
	public void testParameterType(CustomerVo customerVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long queryTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer queryCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerRM queryCustomerResultMap(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> queryCustomerByNameAndTelephone(String name, String telephone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomerByIn(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
