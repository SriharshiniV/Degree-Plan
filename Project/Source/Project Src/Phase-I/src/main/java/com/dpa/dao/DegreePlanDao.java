package com.dpa.dao;

import java.util.List;

import com.dpa.model.Course;

public interface DegreePlanDao {

	List<Course> getCoreCourses();

	List<String> getOptionalCourses();

}
