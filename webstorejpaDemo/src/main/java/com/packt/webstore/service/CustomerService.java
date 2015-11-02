package com.packt.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.repository.query.Param;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.Product;

public interface CustomerService {

	public void save(Customer customer);
	public List<Customer> findAll();
 
}
