package com.spring.jpa_crud.dao;

import com.spring.jpa_crud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    void update(Student theStudent);

    void delete(Integer id);
}
