package org.luv2code.springboot.employeecrud.rest;

import org.luv2code.springboot.employeecrud.entity.Employee;
import org.luv2code.springboot.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @DeleteMapping(value = "/employees/{employeeId}")
    public void delete(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
    }

    @DeleteMapping(value = "/employees")
    public int deleteAll() {
        return employeeService.deleteAll();
    }

    @PostMapping(value = "/employees")
    public void create(@RequestBody List<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("employee list is empty");
        }
        employeeService.save(employees);
    }

    @PutMapping(value = "/employees")
    public List<Employee> update(@RequestBody List<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("employee list is empty");
        }
        return employeeService.update(employees);
    }
}
