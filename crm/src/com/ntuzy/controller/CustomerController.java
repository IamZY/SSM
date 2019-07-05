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
	 * ��ѯ�������� ����json��ʽ����
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<Customer> list() {
		List<Customer> findAll = customerService.findAll();
		return findAll;
	}

	private Map<String, Object> result = new HashMap<>();

	/**
	 * ��ҳ��ѯ
	 */
	@RequestMapping("/listByPage")
	@ResponseBody
	public Map<String, Object> listByPage(Integer page, Integer rows) {
		// ���÷�ҳ����
		PageHelper.startPage(page, rows);
		// ��ѯ��������
		List<Customer> list = customerService.findAll();

		// ʹ��PageInfo��װ��ѯ���
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);

		// ��PageInfo����ȡ����ѯ���
		// �ܼ�¼��
		long total = pageInfo.getTotal();
		// ��ǰҳ�����б�
		List<Customer> custList = pageInfo.getList();

		result.put("total", total);
		result.put("rows", custList);

		return result;

	}
}
