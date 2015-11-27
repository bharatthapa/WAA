/*package emp.mum.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import emp.mum.webstore.domain.Employee;
import emp.mum.webstore.repository.EmployeeRepository;
import emp.mum.webstore.service.EmployeeService;
import java.util.ArrayList;
import java.util.Iterator;

@Service
@Transactional
class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee locateOneEmployeeByHisNumber(int employeeId) {
        // TODO Auto-generated method stub
        return repository.locateOneEmployeeByHisNumber(employeeId);
    }

    @Override
    public List<Employee> listEmployees() {
        // TODO Auto-generated method stub
        return repository.listEmployees();
    }

    @Override
    public void add(Employee t) {
        if (this.repository.findOne(t.getId()) != null) {
            throw new IllegalArgumentException("Invalid employee.");
        }
        this.repository.save(t);
    }

    @Override
    public void update(Employee t) {
        if (this.repository.findOne(t.getId()) == null) {
            throw new IllegalArgumentException("Invalid employee");
        }
        this.repository.save(t);
    }

    @Override
    public void remove(Employee t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee findOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid employee id");
        }
        return this.repository.findOne(id);
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

}
*/