package com.dpa.model;

import java.util.List;

public class DegreePlan {
	
	private String name;
	private int studentId;
	private String localAddress;
	private String email;
	private String degree;
	private String major;
	private String minor;
	private String interestArea;
	private String majorProfessor;
	private String coMajorProfessor;
	private GRE gre;
	private List<Courses> courses;
	private int totalCreditHours;
	public DegreePlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DegreePlan [name=" + name + ", studentId=" + studentId + ", localAddress=" + localAddress + ", email="
				+ email + ", degree=" + degree + ", major=" + major + ", minor=" + minor + ", interestArea="
				+ interestArea + ", majorProfessor=" + majorProfessor + ", coMajorProfessor=" + coMajorProfessor
				+ ", gre=" + gre + ", courses=" + courses + ", totalCreditHours=" + totalCreditHours + "]";
	}
	public String getName() {
		return name;
	}
	public DegreePlan(String name, int studentId, String localAddress, String email, String degree, String major,
			String minor, String interestArea, String majorProfessor, String coMajorProfessor, GRE gre,
			List<Courses> courses, int totalCreditHours) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.localAddress = localAddress;
		this.email = email;
		this.degree = degree;
		this.major = major;
		this.minor = minor;
		this.interestArea = interestArea;
		this.majorProfessor = majorProfessor;
		this.coMajorProfessor = coMajorProfessor;
		this.gre = gre;
		this.courses = courses;
		this.totalCreditHours = totalCreditHours;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public String getInterestArea() {
		return interestArea;
	}
	public void setInterestArea(String interestArea) {
		this.interestArea = interestArea;
	}
	public String getMajorProfessor() {
		return majorProfessor;
	}
	public void setMajorProfessor(String majorProfessor) {
		this.majorProfessor = majorProfessor;
	}
	public String getCoMajorProfessor() {
		return coMajorProfessor;
	}
	public void setCoMajorProfessor(String coMajorProfessor) {
		this.coMajorProfessor = coMajorProfessor;
	}
	public GRE getGre() {
		return gre;
	}
	public void setGre(GRE gre) {
		this.gre = gre;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	public int getTotalCreditHours() {
		return totalCreditHours;
	}
	public void setTotalCreditHours(int totalCreditHours) {
		this.totalCreditHours = totalCreditHours;
	}
	

}
