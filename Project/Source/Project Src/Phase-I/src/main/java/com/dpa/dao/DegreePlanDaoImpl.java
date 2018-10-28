package com.dpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.jdbc.CourseRowMapper;
import com.dpa.jdbc.OptionalCourseRowMapper;
import com.dpa.model.Course;

@Service
public class DegreePlanDaoImpl implements DegreePlanDao{
	@Autowired 
	DataSource dataSource;
	
	
	//Get the course list from the database
	@Override
	public List<Course> getCoreCourses() {
		List<Course> courseList = new ArrayList<Course>();
		String sql = "select * from mandatorycourses";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		courseList = jdbctem.query(sql, new CourseRowMapper());
		return courseList;
	}

	//return all CSCE Department courses
	@Override
	public List<String> getOptionalCourses() {
		List<String> optionalCourses = new ArrayList<String>();
		String sql = "select * from courses";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		optionalCourses = jdbctem.query(sql, new OptionalCourseRowMapper());
		return optionalCourses;
	}

}
