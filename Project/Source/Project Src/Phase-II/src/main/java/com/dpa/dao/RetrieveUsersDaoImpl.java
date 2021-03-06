package com.dpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.jdbc.MyAdvisorRowMapper;
import com.dpa.jdbc.MyStudentRowMapper;
import com.dpa.jdbc.ProfessorRowMapper;
import com.dpa.model.Register;
import com.dpa.model.Request;

//This class is gets the advisors students and students major professor 
@Service
public class RetrieveUsersDaoImpl implements RetrieveUsersDao{
	@Autowired 
	DataSource dataSource;

	public List<Request> getMyStudents(String uName) {
		List<Request> myStudents = new ArrayList<Request>();
		String sql = "select email from register where userName='" + uName + "'" ;
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		String email = jdbctem.queryForObject(sql, String.class);
		String sql1 = "select * from majorprofessor where professorEmail='" + email + "'";
		JdbcTemplate jdbctem1 = new JdbcTemplate(dataSource);
		myStudents = jdbctem1.query(sql1, new MyStudentRowMapper());
		return myStudents;
	}

	public List<Request> getMyAdvisors(String userName) {
		List<Request> myAdvisors = new ArrayList<Request>();
		String sql1 = "select professorName, professorEmail from majorprofessor where studentName='" + userName + "'";
		JdbcTemplate jdbctem1 = new JdbcTemplate(dataSource);
		myAdvisors = jdbctem1.query(sql1, new MyAdvisorRowMapper());
		return myAdvisors;
	}

	public List<Register> getStudentList() {
		// TODO Auto-generated method stub
		List<Register> studentList = new ArrayList<Register>();
		String role = "student";
		String sql = "select name, email from register where role='" + role + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		studentList = jdbctem.query(sql, new ProfessorRowMapper());
		return studentList;	
	}

}
