package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao {
	int addStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int studentId);
	Student getStudent(int studentId);
	List<Student> getStudents();

}
