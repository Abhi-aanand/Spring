package com.demo.springboot.cruddemo.dao;

import com.demo.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{


    //define field for entityManager
    private EntityManager entityManager;
    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);


        //execute a query and get result list

        List<Employee> employees=theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee= entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employeeDb=entityManager.merge(theEmployee);
        return employeeDb;
    }

    @Override
    public void deleteById(int id) {
        Employee employeeDelete=entityManager.find(Employee.class,id);
         entityManager.remove(employeeDelete);

    }
}
