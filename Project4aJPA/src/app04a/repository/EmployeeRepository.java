package app04a.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app04a.domain.Employee;

	@Repository
	public interface EmployeeRepository extends  CrudRepository<Employee, Long> 
	{
	
  
	}

