package com.abhi.restDemo.rest;

import com.abhi.restDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> student;

    //@postConstruct
    @PostConstruct
    public void loadData(){
        student=new ArrayList<>();
        student.add(new Student("Abhi","Anand"));
        student.add(new Student("sabuja","pattnaik"));
        student.add(new Student("arpit","shukla"));
    }




    @GetMapping("/students")
    public List<Student> studentLists(){

        return student;
    }
    //define endpoint or "/students/{studentId}" =return single student
    @GetMapping("/students/{studentId}")
    public Student studentList(@PathVariable int studentId){

        //just index into the list...keep it simple

        //check the studentId again in the list size
        if((studentId>=student.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id is not found-"+studentId);
        }
        return student.get(studentId);
    }
    //add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //create a studentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    //If we want to handle all the exception
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//        //create a studentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        //return ResponseEntity
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//
//    }
}
