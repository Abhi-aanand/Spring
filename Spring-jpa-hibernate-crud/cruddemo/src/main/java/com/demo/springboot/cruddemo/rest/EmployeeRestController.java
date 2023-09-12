package com.demo.springboot.cruddemo.rest;

import com.demo.springboot.cruddemo.dao.EmployeeDAO;
import com.demo.springboot.cruddemo.entity.Employee;
import com.demo.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    //inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findEmployees(){
        return employeeService.findAll();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getemployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee==null){
            throw  new RuntimeException("Employee id not found---"+employeeId);
        }
        return theEmployee;
    }

    //add mapping for POST /employees -- adding new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case they pass an id in JSOn set id to '0'
        //this is to force a save of new item ,  instead of update
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for put/ employee and the existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for DELETE/employees/{employee id}- delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee=employeeService.findById(employeeId);

        //throw exception if null is found

        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found ---"+employeeId);
        }

        employeeService.deleteById(employeeId);
        return "deleted employee id ="+employeeId;
    }


}
