package com.dpa.model;

public class Courses {
	private String course;
	private String semesterTaken;
	private int cHrs;
	private String grade;
	@Override
	public String toString() {
		return "Courses [course=" + course + ", semesterTaken=" + semesterTaken + ", cHrs=" + cHrs + ", grade=" + grade
				+ "]";
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSemesterTaken() {
		return semesterTaken;
	}
	public void setSemesterTaken(String semesterTaken) {
		this.semesterTaken = semesterTaken;
	}
	public int getcHrs() {
		return cHrs;
	}
	public void setcHrs(int cHrs) {
		this.cHrs = cHrs;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
