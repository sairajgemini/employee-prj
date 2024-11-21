package org.luv2code.springboot.employeecrud.service;

import jakarta.transaction.Transactional;
import org.luv2code.springboot.employeecrud.dao.EmployeeDAO;
import org.luv2code.springboot.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public void save(List<Employee> employees) {
        employeeDAO.save(employees);
    }

    @Override
    @Transactional
    public List<Employee> update(List<Employee> employees) {
        return employeeDAO.update(employees);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return employeeDAO.deleteAll();
    }
}
