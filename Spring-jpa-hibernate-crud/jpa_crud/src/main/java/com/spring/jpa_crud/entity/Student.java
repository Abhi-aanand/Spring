package com.spring.jpa_crud.entity;


import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String LastName;

    @Column(name="email")
    private String email;



    //define constructors

    public Student(){

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
    }
    //define getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //define toString() method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
