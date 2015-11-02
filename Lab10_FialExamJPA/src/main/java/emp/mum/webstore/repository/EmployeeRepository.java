package emp.mum.webstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import emp.mum.webstore.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("SELECT e FROM EMPLOYEE e WHERE e.employeeNumber = :employeeID")
	Employee locateOneEmployeeByHisNumber(@Param(value = "employeeID") int num);

	@Query("SELECT e FROM EMPLOYEE e")
	List<Employee> listEmployees();
}
