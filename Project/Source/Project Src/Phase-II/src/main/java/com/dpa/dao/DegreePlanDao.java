package com.dpa.dao;

import java.util.List;

import com.dpa.model.Course;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;

public interface DegreePlanDao {

	List<Course> getCoreCourses();

	List<String> getOptionalCourses();

	int submitDegreePlan(DegreePlan degreePlan, String userName);

	DegreePlan getDegreePlan(String sName, String userName);

	GRE getGREScores(String sName);

	List<Courses> getCourses(String sName);

	int submitDPToAdminSpecialist(String userName, String sName, String sign);

	int dPProfessorReject(String userName, String studentName, String comments);

	String getDPStatus(String userName, String majorProfessor);

	String getComments(String userName, String majorProfessor);

	DegreePlan getDegreePlanData(String userName);

	int updateDegreePlan(DegreePlan degreePlan, String userName);

	int getDegreePlans();


}
