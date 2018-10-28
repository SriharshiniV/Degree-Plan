package com.dpa.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.DegreePlanDao;
import com.dpa.model.Course;

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

}
