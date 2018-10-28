package com.dpa.model;
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
	private Courses courseA;
	private Courses courseB;
	private Courses courseC;
	private Courses courseD;
	private Courses opCourse1;
	private Courses opCourse2;
	private Courses opCourse3;
	private Courses opCourse4;
	private Courses opCourse5;
	private Courses opCourse6;
	private Courses opCourse7;
	private Courses opCourse8;
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
				+ ", gre=" + gre + ", courseA=" + courseA + ", courseB=" + courseB + ", courseC=" + courseC
				+ ", courseD=" + courseD + ", opCourse1=" + opCourse1 + ", opCourse2=" + opCourse2 + ", opCourse3="
				+ opCourse3 + ", opCourse4=" + opCourse4 + ", opCourse5=" + opCourse5 + ", opCourse6=" + opCourse6
				+ ", opCourse7=" + opCourse7 + ", opCourse8=" + opCourse8 + ", totalCreditHours=" + totalCreditHours
				+ "]";
	}
	public String getName() {
		return name;
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
	public Courses getCourseA() {
		return courseA;
	}
	public void setCourseA(Courses courseA) {
		this.courseA = courseA;
	}
	public Courses getCourseB() {
		return courseB;
	}
	public void setCourseB(Courses courseB) {
		this.courseB = courseB;
	}
	public Courses getCourseC() {
		return courseC;
	}
	public void setCourseC(Courses courseC) {
		this.courseC = courseC;
	}
	public Courses getCourseD() {
		return courseD;
	}
	public void setCourseD(Courses courseD) {
		this.courseD = courseD;
	}
	public Courses getOpCourse1() {
		return opCourse1;
	}
	public void setOpCourse1(Courses opCourse1) {
		this.opCourse1 = opCourse1;
	}
	public Courses getOpCourse2() {
		return opCourse2;
	}
	public void setOpCourse2(Courses opCourse2) {
		this.opCourse2 = opCourse2;
	}
	public Courses getOpCourse3() {
		return opCourse3;
	}
	public void setOpCourse3(Courses opCourse3) {
		this.opCourse3 = opCourse3;
	}
	public Courses getOpCourse4() {
		return opCourse4;
	}
	public void setOpCourse4(Courses opCourse4) {
		this.opCourse4 = opCourse4;
	}
	public Courses getOpCourse5() {
		return opCourse5;
	}
	public void setOpCourse5(Courses opCourse5) {
		this.opCourse5 = opCourse5;
	}
	public Courses getOpCourse6() {
		return opCourse6;
	}
	public void setOpCourse6(Courses opCourse6) {
		this.opCourse6 = opCourse6;
	}
	public Courses getOpCourse7() {
		return opCourse7;
	}
	public void setOpCourse7(Courses opCourse7) {
		this.opCourse7 = opCourse7;
	}
	public Courses getOpCourse8() {
		return opCourse8;
	}
	public void setOpCourse8(Courses opCourse8) {
		this.opCourse8 = opCourse8;
	}
	public int getTotalCreditHours() {
		return totalCreditHours;
	}
	public void setTotalCreditHours(int totalCreditHours) {
		this.totalCreditHours = totalCreditHours;
	}
	

}
