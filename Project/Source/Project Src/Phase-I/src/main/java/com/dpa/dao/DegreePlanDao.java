package com.dpa.dao;

import java.util.List;

import com.dpa.model.Course;
import com.dpa.model.DegreePlan;

public interface DegreePlanDao {

	List<Course> getCoreCourses();

	List<String> getOptionalCourses();

	int submitDegreePlan(DegreePlan degreePlan, String userName);

}
