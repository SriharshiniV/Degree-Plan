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
import com.dpa.model.InterestArea;

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
		List<Courses> modifiedCourseList = new ArrayList<Courses>();
		courses = degreePlanDao.getCourses(sName);
		Iterator courseA = courses.iterator();
		while(courseA.hasNext()) {
			Courses mand1 = (Courses) courseA.next();
			if((mand1.getCourseCatergory()).equals("courseA")){
				modifiedCourseList.add(mand1);
			}
		}
		Iterator courseB = courses.iterator();
		while(courseB.hasNext()) {
			Courses mand2 = (Courses) courseB.next();
			if((mand2.getCourseCatergory()).equals("courseB")){
				modifiedCourseList.add(mand2);
			}
		}
		Iterator courseC = courses.iterator();
		while(courseC.hasNext()) {
			Courses mand3 = (Courses) courseC.next();
			if((mand3.getCourseCatergory()).equals("courseC")){
				modifiedCourseList.add(mand3);
			}
		}
		Iterator courseD = courses.iterator();
		while(courseD.hasNext()) {
			Courses mand4 = (Courses) courseD.next();
			if((mand4.getCourseCatergory()).equals("courseD")){
				modifiedCourseList.add(mand4);
			}
		}
		Iterator opt = courses.iterator();
		while(opt.hasNext()) {
			Courses optional = (Courses) opt.next();
			if((optional.getCourseCatergory()).equals("optional")){
				modifiedCourseList.add(optional);
			}
		}
		return modifiedCourseList;
	}

	@Override
	public int submitToAdminSpecialist(String userName, String sName, String sign) {
		int result = degreePlanDao.submitDPToAdminSpecialist(userName, sName, sign);
		return result;
	}

	@Override
	public int dPProfessorreject(String userName, String studentName, String comments) {
		int result = degreePlanDao.dPProfessorReject(userName, studentName, comments);
		return result;
	}

	@Override
	public String getDPStatus(String userName, String majorProfessor) {
		String status = degreePlanDao.getDPStatus(userName, majorProfessor);
		return status;
	}

	@Override
	public String getComments(String userName, String majorProfessor) {
		String comments = degreePlanDao.getComments(userName, majorProfessor);
		return comments;
	}

	@Override
	public DegreePlan getDegreePlan(String userName) {
		DegreePlan dp = degreePlanDao.getDegreePlanData(userName);
		return dp;
	}

	@Override
	public int updateDegreePlan(DegreePlan degreePlan, String userName) {
		int result = degreePlanDao.updateDegreePlan(degreePlan, userName);
		return result;
	}

	@Override
	public List<DegreePlan> getDegreePlans() {
		List<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
		degreePlans = degreePlanDao.getDegreePlans();
		return degreePlans;
	}

	@Override
	public DegreePlan getReceivedDP(String sName, String sId) {
		DegreePlan dp = degreePlanDao.getReceivedDegreePlan(sName, sId);
		return dp;
	}

	@Override
	public int submitToAssociateChair(int studentId, String sName) {
		int result = degreePlanDao.submitDPToAssociateChair(studentId, sName);
		return result;
	}

	@Override
	public List<DegreePlan> getReceivedDegreePlansLevel2(String userName) {
		List<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
		degreePlans = degreePlanDao.receivedDegreePlansLevel2(userName);
		return degreePlans;
	}

	@Override
	public int submitToASL2(String userName, String sName, String sign) {
		int result = degreePlanDao.submitDPToASL2(userName, sName, sign);
		return result;
	}

	@Override
	public int submitToChair(int studentId, String sName) {
		int result = degreePlanDao.submitDPToChair(studentId, sName);
		return result;
	}

	@Override
	public List<DegreePlan> getReceivedDegreePlansLevel3(String userName) {
		List<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
		degreePlans = degreePlanDao.receivedDegreePlansLevel3(userName);
		return degreePlans;
	}

	@Override
	public int submitToASL3(String userName, String sName, String sign) {
		int result = degreePlanDao.submitDPToASL3(userName, sName, sign);
		return result;
	}

	@Override
	public int sendApprovaltoStudent(int studentId, String sName) {
		int result = degreePlanDao.sendApprovaltoStudent(studentId, sName);
		return result;
	}
//gets degree plan information
	@Override
	public String getDPI() {
		String result = degreePlanDao.getDPI();
		return result;
	}

	@Override
	public List<InterestArea> getInterestAreas() {
		List<InterestArea> interestAreas1 = new ArrayList<InterestArea>();
		List<InterestArea> interestAreas = degreePlanDao.getInterestAreas();
		Iterator interestArea = interestAreas.iterator();
		while(interestArea.hasNext()) {
			InterestArea mand1 = (InterestArea) interestArea.next();
			if(((mand1.getMajor()).equals("CS")) || ((mand1.getMajor()).equals("CSCE"))){
				interestAreas1.add(mand1);
			}
		}
		Iterator interestArea1 = interestAreas.iterator();
		while(interestArea1.hasNext()) {
			InterestArea mand2 = (InterestArea) interestArea1.next();
			if(((mand2.getMajor()).equals("CE")) || ((mand2.getMajor()).equals("CSCE"))){
				interestAreas1.add(mand2);
			}
		}
		return interestAreas1;
	}

}
