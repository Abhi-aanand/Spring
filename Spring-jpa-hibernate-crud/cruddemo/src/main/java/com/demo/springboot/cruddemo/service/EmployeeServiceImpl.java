package com.demo.springboot.cruddemo.service;

import com.demo.springboot.cruddemo.dao.EmployeeDAO;
import com.demo.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }


    @Override
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {

        employeeDAO.deleteById(id);
    }
}
