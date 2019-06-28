package com.ntuzy.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;

	/**
	 * 
	 */
	@RequestMapping("/saveUI")
	public String saveUI() {
		return "save";
	}

	/**
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String save(Customer customer, Map<String, Object> model) {
		customerService.save(customer);
		model.put("msg", "����ɹ�");
		return "success";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Map<String, List<Customer>> map) {
		List<Customer> custList = customerService.findAll();
		map.put("list", custList);
		return "list";
	}

	/**
	 * ��ѯһ���ͻ�
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") Long custId, Map<String, Object> model) {
		Customer cust = customerService.findById(custId);
		model.put("cust", cust);
		return "edit";
	}

	/**
	 * �ͻ��޸�
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public String update(Customer customer, Map<String, Object> model) {
		customerService.update(customer);
		model.put("msg", "�޸ĳɹ�");
		return "success";
	}

	/**
	 * ɾ���ͻ�
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(Long[] custIds, Map<String, Object> model) {
		customerService.delete(custIds);
		model.put("msg", "ɾ���ɹ�");
		return "success";
	}

}
