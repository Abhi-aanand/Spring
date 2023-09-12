package com.spring.jpa_crud.dao;

import com.spring.jpa_crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define fields for entity manager
    private EntityManager entityManager;
    //inject em using constructor injection


    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //implement save method

    @Override
    @Transactional
    public void save(Student student) {

        //The EntityManager is a core component of JPA and is used to manage the lifecycle of entities,
        // which are Java objects that represent records in a database table.

        //persist() Method: The persist() method is one of the methods provided by the EntityManager.
        // It's used to make a transient (newly created) entity persistent, meaning it will be saved
        // to the database

        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {

        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
      //create query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);

      // return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student theStudent=entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);
    }
}
