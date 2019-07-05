package com.ntuzy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.RequestingUserName;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//
	@Resource
	private CustomerService customerService;

	/**
	 * 查询所有数据 返回json格式数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<Customer> list() {
		List<Customer> findAll = customerService.findAll();
		return findAll;
	}

	private Map<String, Object> result = new HashMap<>();

	/**
	 * 分页查询
	 */
	@RequestMapping("/listByPage")
	@ResponseBody
	public Map<String, Object> listByPage(Integer page, Integer rows) {
		// 设置分页参数
		PageHelper.startPage(page, rows);
		// 查询所有数据
		List<Customer> list = customerService.findAll();

		// 使用PageInfo封装查询结果
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);

		// 从PageInfo对象取出查询结果
		// 总记录数
		long total = pageInfo.getTotal();
		// 当前页数据列表
		List<Customer> custList = pageInfo.getList();

		result.put("total", total);
		result.put("rows", custList);

		return result;

	}
}
