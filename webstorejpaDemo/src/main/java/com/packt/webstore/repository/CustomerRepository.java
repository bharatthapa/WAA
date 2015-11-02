package com.packt.webstore.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;

	@Repository
	public interface CustomerRepository extends  CrudRepository<Customer, Long> 
	{
  	}

