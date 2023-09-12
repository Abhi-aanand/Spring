package com.demo.springboot.cruddemo.dao;

import com.demo.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //no need to write code here
}
