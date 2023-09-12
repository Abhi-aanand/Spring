package com.spring.jpa_crud;

import com.spring.jpa_crud.dao.StudentDAO;
import com.spring.jpa_crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.util.List;

@SpringBootApplication
public class JpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudApplication.class, args);
	}


	//A CommandLineRunner is an interface in Spring Boot that allows you to execute code
	// when the application starts up. It's typically used for performing tasks like data
	// initialization, data migration, or any other custom logic that needs to run when
	// your Spring Boot application is launched.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			// createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("deleting student id:" + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on id
		int studId=1;
		System.out.println("getting student with Id:-"+studId);
		Student myStud=studentDAO.findById(studId);

		//change first name
		System.out.println("Updating....");
		myStud.setFirstName("Scooby");

		//update
		studentDAO.update(myStud);

		//display the student
		System.out.println(myStud);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents=studentDAO.findAll();

		//display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("creating a new student...");
		Student std=new Student("atul","kumar","atul@gmail.com");

		//save the student
		System.out.println("saving the student");
		studentDAO.save(std);

		//display id of the student
		System.out.println("Saved student. Generated id:" + std.getId());

		//retrieve the student
		System.out.println("retrieving the students...");
		Student stdd=studentDAO.findById(std.getId());

		//display student
		System.out.println("found the student" + stdd);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//creating multiple objects
		System.out.println("creating 3 students objects");
		Student student1=new Student("abhi","anand","abhi@gmail.com");
		Student student2=new Student("sabuja","pattnaik","sabuja@gmail.com");
		Student student3=new Student("arpit","shukla","arpit@gmail.com");

		//save the student objects
		System.out.println("saving the objects");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//CREATE THE STUDENT OBJECT
		System.out.println("creating the students.....");
		Student tempStudent=new Student("Paul","DOe","paul@gmail.com");

		//save the student object
		System.out.println("saving  objects");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("saved student. Generated id: " + tempStudent.getId());

	}

}
