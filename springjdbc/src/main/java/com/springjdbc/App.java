package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDaoImpl;
import com.model.Student;

/**
 * Main class to call various spring jdbc methods
 *
 */
public class App {
	public static void main(String[] args) {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("com/springjdbc/Config.xml"); // This is for XML based dependency injection
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class); // This is for Java class based dependency injection

		StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl", StudentDaoImpl.class);

		// Adding new student data
		Student s1 = new Student(7, "Meenu", "Banglore");

		int insertedRows = studentDaoImpl.addStudent(s1);
		System.out.println("Number of rows inserted are :" + insertedRows);

		// Modifying existing student data
		Student s2 = new Student(1, "Sachin Mankotia", "Kangra");

		int updatedRows = studentDaoImpl.updateStudent(s2);
		System.out.println("Number of rows updated are :" + updatedRows);

		// Deleting existing student data

		int deletedRows = studentDaoImpl.deleteStudent(4);
		System.out.println("Number of rows deleted are :" + deletedRows);

		// Fetching existing student data
		Student fetchedStudent = studentDaoImpl.getStudent(5);
		System.out.println("Fetched student data is :" + fetchedStudent.toString());

		// Fetching all students data
		List<Student> allFetchedStudents = studentDaoImpl.getStudents();
		for (Student student : allFetchedStudents) {
			System.out.println(student.toString());
		}

	}
}
