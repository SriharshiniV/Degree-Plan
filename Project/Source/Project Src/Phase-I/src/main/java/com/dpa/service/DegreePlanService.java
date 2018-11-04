package com.dpa.service;

import java.util.List;

import com.dpa.model.Course;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;

public interface DegreePlanService {

	List<Course> getGroupACourses(String major);

	List<Course> getGroupBCourses(String major);
	
	List<Course> getGroupCCourses(String major);
	
	List<Course> getGroupDCourses(String major);

	List<String> getOptionalCourses();

	int submitDegreePlan(DegreePlan degreePlan, String userName);

	DegreePlan viewDegreePlan(String sName, String userName);

	GRE getGREScores(String sName);

	List<Courses> getCourses(String sName);

}
