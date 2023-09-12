package com.demo.springboot.cruddemo.dao;

import com.demo.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface EmployeeDAO {

    List<Employee> findAll();

    //EmployeeDAO methods

    Employee findById(int id);

    Employee save(Employee theEmployee);
    void deleteById(int id);
}
