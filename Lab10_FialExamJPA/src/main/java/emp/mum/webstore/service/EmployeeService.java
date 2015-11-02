package emp.mum.webstore.service;

import java.util.List;

import emp.mum.webstore.domain.Employee;

public interface EmployeeService extends AbstractService<Employee, Long>{

	Employee locateOneEmployeeByHisNumber(int employeeId);
	List<Employee> listEmployees();

}
