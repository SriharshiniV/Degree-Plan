package com.dpa.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.DegreePlanDao;
import com.dpa.model.Course;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;

@Service
public class DegreePlanServiceImpl implements DegreePlanService{
	@Autowired
	DegreePlanDao degreePlanDao;
	
	//filter the group A courses from the course list
	@Override
	public List<Course> getGroupACourses(String major) {
		if(major.equals("computerScience")) {
			major = "CS";
		}else {
			major = "CE";
		}
		List<Course> courses = degreePlanDao.getCoreCourses();
		Iterator course = courses.iterator();  
		while(course.hasNext()) {
			Course crse = (Course) course.next();
			if((crse.getGroupId()).equals("B") || (crse.getGroupId()).equals("D") || (crse.getGroupId()).equals("C") || (! major.equals(crse.getMajor()))){
				course.remove();
			}
		}
		return courses;
	}

	@Override
	public List<Course> getGroupBCourses(String major) {
		if(major.equals("computerScience")) {
			major = "CE";
		}else {
			major = "CS";
		}
		List<Course> courses = degreePlanDao.getCoreCourses();
		Iterator course = courses.iterator();  
		while(course.hasNext()) {
			Course crse = (Course) course.next();
			if((crse.getGroupId()).equals("A") || (crse.getGroupId()).equals("D") || (crse.getGroupId()).equals("C") || (major.equals(crse.getMajor()))){
				course.remove();
			}
		}
		return courses;
	}

	@Override
	public List<Course> getGroupCCourses(String major) {
		if(major.equals("computerScience")) {
			major = "CS";
		}else {
			major = "CE";
		}
		List<Course> courses = degreePlanDao.getCoreCourses();
		Iterator course = courses.iterator();  
		while(course.hasNext()) {
			Course crse = (Course) course.next();
			if((crse.getGroupId()).equals("B") || (crse.getGroupId()).equals("D") || (crse.getGroupId()).equals("A") || (! major.equals(crse.getMajor()))){
				course.remove();
			}
		}
		return courses;
	}

	@Override
	public List<Course> getGroupDCourses(String major) {
		if(major.equals("computerScience")) {
			major = "CS";
		}else {
			major = "CE";
		}
		List<Course> courses = degreePlanDao.getCoreCourses();
		Iterator course = courses.iterator();  
		while(course.hasNext()) {
			Course crse = (Course) course.next();
			if((crse.getGroupId()).equals("B") || (crse.getGroupId()).equals("A") || (crse.getGroupId()).equals("C") || (! major.equals(crse.getMajor()))){
				course.remove();
			}
		}
		return courses;
	}

	@Override
	public List<String> getOptionalCourses() {
		List<String> optionalCourses = degreePlanDao.getOptionalCourses();
		return optionalCourses;
	}

	@Override
	public int submitDegreePlan(DegreePlan degreePlan, String userName) {
		int result = degreePlanDao.submitDegreePlan(degreePlan, userName);
		return result;
	}
	
//calls viewDegreePlan() of DegreePlanDao to get degree plan information of a particular student
	@Override
	public DegreePlan viewDegreePlan(String sName, String userName) {
		// TODO Auto-generated method stub
		DegreePlan dp = degreePlanDao.getDegreePlan(sName, userName);
		return dp;
	}

	@Override
	public GRE getGREScores(String sName) {
		GRE gre = degreePlanDao.getGREScores(sName);
		return gre;
	}

	@Override
	public List<Courses> getCourses(String sName) {
		List<Courses> courses = new ArrayList<Courses>();
		courses = degreePlanDao.getCourses(sName);
		return courses;
	}

}
