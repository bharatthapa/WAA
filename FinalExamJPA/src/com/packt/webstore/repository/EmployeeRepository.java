package com.packt.webstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

	@Query("SELECT e FROM EMPLOYEE e WHERE EMPLOYEEID = :employeeID")
	Employee locateOneEmployeeByHisNumber(@Param(value = "employeeID") int num);

	@Query("SELECT e FROM EMPLOYEE e")
	List<Employee> listEmployees();
}
