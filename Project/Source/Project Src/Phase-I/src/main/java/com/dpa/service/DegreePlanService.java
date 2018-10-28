package com.dpa.service;

import java.util.List;

import com.dpa.model.Course;

public interface DegreePlanService {

	List<Course> getGroupACourses(String major);

	List<Course> getGroupBCourses(String major);
	
	List<Course> getGroupCCourses(String major);
	
	List<Course> getGroupDCourses(String major);

	List<String> getOptionalCourses();

}
