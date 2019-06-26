package com.ntuzy.dao;

import java.util.List;

import com.ntuzy.domain.Order;
import com.ntuzy.domain.OrderUser;

public interface OrderDao {
	
	/**
	 * �Զ����ѯJavaBean
	 */
	public List<OrderUser> queryOrderUser();
	
	/**
	 * resultmap
	 */
	public List<Order> queryOrderUserResultMap();
	
}
