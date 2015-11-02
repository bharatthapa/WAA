package com.packt.webstore.service;

import com.packt.webstore.domain.Employee;

public interface EmployeeService extends AbstractService<Employee, Integer> {
	
	public Employee getEmployeeByNumber(int empNumber);

}
