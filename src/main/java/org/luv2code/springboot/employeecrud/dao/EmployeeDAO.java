package org.luv2code.springboot.employeecrud.dao;

import org.luv2code.springboot.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee findById(int id);

    List<Employee> findAll();

    void save(List<Employee> employees);

    List<Employee> update(List<Employee> employees);

    void deleteById(int id);

    int deleteAll();
}
