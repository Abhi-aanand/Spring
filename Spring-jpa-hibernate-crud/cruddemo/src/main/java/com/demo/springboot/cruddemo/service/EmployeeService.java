package com.demo.springboot.cruddemo.service;

import com.demo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);
    void deleteById(int id);
}
