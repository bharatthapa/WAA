package com.packt.webstore.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Employee;
import com.packt.webstore.repository.EmployeeRepository;
import com.packt.webstore.service.EmployeeService;

@Service
class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public void add(Employee t) {
		if (repository.findOne(t.getId()) != null) {
			throw new IllegalArgumentException("Invalid employee.");
		}
		repository.save(t);
	}

	@Override
	public void update(Employee t) {
		if (this.repository.findOne(t.getId()) == null) {
			throw new IllegalArgumentException("Employee does not exist.");
		}
		repository.save(t);

	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<>();
		Iterator<Employee> it = this.repository.findAll().iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	@Override
	public Employee findOne(Integer obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Invalid Argument.");
		}
		return this.repository.findOne(obj);
	}

	@Override
	public Employee getEmployeeByNumber(int empNumber) {
		if (empNumber <= 0) {
			throw new IllegalArgumentException("invalid empNumber.");
		}
		return this.repository.findEmployeeByNumber(empNumber);
	}

}
