package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Employee;

public interface EmployeeService {

	Employee locateOneEmployeeByHisNumber(int employeeId);
	List<Employee> listEmployees();

}
