package org.luv2code.springboot.employeecrud.dao;

import jakarta.persistence.EntityManager;
import org.luv2code.springboot.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee e", Employee.class).getResultList();
    }

    @Override
    public void save(List<Employee> employees) {
        if (employees != null) {
            for (Employee employee : employees) {
                entityManager.persist(employee);
            }
        }
    }

    @Override
    public List<Employee> update(List<Employee> employees) {
        if (employees != null && !employees.isEmpty()) {
            for (Employee employee : employees) {
                entityManager.merge(employee);
            }
        }
        return employees;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("delete from Employee e").executeUpdate();
    }
}
