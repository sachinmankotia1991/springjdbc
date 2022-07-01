package com.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StudentDaoImpl() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Actual methods implementation
	public int addStudent(Student student) {
		String insertQuery = "insert into student_jdbc(id,name,city) values(?,?,?)";
		int result = jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int updateStudent(Student student) {
		String updateQuery = "update student_jdbc set name=?,city=? where id=?";
		int result = jdbcTemplate.update(updateQuery, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int deleteStudent(int studentId) {
		String deleteQuery = "delete from student_jdbc where id=?";
		int result = jdbcTemplate.update(deleteQuery, 4);
		return result;
	}

	public Student getStudent(int studentId) {
		String fetchQuery = "select * from student_jdbc where id=?";
		RowMapper<Student> rowmapper = new RowMapperImpl();
		Student student = jdbcTemplate.queryForObject(fetchQuery, rowmapper, studentId);
		return student;
	}

	public List<Student> getStudents() {
		String fetchQuery = "select * from student_jdbc";
		RowMapper<Student> rowmapper = new RowMapperImpl();
		List<Student> listStudent = jdbcTemplate.query(fetchQuery, rowmapper);
		return listStudent;
	}

}
