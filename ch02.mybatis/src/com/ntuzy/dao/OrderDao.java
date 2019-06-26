package com.ntuzy.dao;

import java.util.List;

import com.ntuzy.domain.Order;
import com.ntuzy.domain.OrderUser;

public interface OrderDao {
	
	/**
	 * 自定义查询JavaBean
	 */
	public List<OrderUser> queryOrderUser();
	
	/**
	 * resultmap
	 */
	public List<Order> queryOrderUserResultMap();
	
}
