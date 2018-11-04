<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/studentheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<form name="viewDegreePlan"  action="#" class="form-horizontal" onsubmit="" method="POST">
		<div class="form-group">
			<h4 style="text-align:center;">
			<strong>Master's Degree Plan</strong><br>
			<strong>Department of Computer Science And Engineering </strong>		
			</h4>
		</div>
		<table class="table table-striped" id="viewDPTable">
		<tbody>
				<tr>
					<td colspan="2">Name: ${degreePlan.name}</td>
					<td colspan="2">Student ID: ${degreePlan.studentId}</td>
				</tr>
				<tr>
					<td colspan="4">Local Address: ${degreePlan.localAddress}</td>
				</tr>
				<tr>
					<td colspan="4">E Mail Address: ${degreePlan.email}</td>
				</tr>
				<tr>
					<td colspan="2">Degree To Be Earned: ${degreePlan.degree}</td>
					<td colspan="2">Major: ${degreePlan.major}</td>
				</tr>
				<tr>
					<td colspan="2">Minor: ${degreePlan.minor}</td>
					<td colspan="2">Interest Area: ${degreePlan.interestArea}</td>
				</tr>
				<tr>
					<td colspan="2">Major Professor (Must be a CSE faculty): ${degreePlan.majorProfessor}</td>
					<td colspan="2">Co-Major Professor: ${degreePlan.coMajorProfessor}</td>
				</tr>
				<tr>
					<td>Most recent GRE scores: Verbal: ${gre.verbal}</td>
					<td>Quantitative: ${gre.quantitative}</td>
					<td>Analytical: ${gre.analytical}</td>
					<td>Date Taken: ${gre.dateTaken}</td>
				</tr>
		</tbody>
	</table>		
	<div class="form-group">
		<h4 style="text-align:center;">
		<strong>Core Courses (Must make an A or B)</strong><br>
		</h4>
	</div>	
	<table class="table table-striped" id="viewCoreCourses">
	<thead>
		<tr>
			<th>Course Prefix, Number and Title</th>
			<th>Semester Taken</th>
			<th>C. Hrs</th>
			<th>Grade</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${courses}" begin="0" end="3" var="course">
			<tr>
				<td class = "col-sm-6">${course.course}</td>
				<td>${course.semesterTaken}</td>
				<td>${course.cHrs}</td>
				<td>${course.grade}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<div class="form-group">
		<h4 style="text-align:center;">
		<strong>Supporting Courses</strong><br>
		</h4>
	</div>	
	<table class="table table-striped" id="viewOptionalCourses">
		<thead>
			<tr>
				<th>Course Prefix, Number and Title</th>
				<th>Semester Taken</th>
				<th>C. Hrs</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${courses}" begin="4" end="11" var="course">
				<tr>
					<td class = "col-sm-6">${course.course}</td>
					<td>${course.semesterTaken}</td>
					<td>${course.cHrs}</td>
					<td>${course.grade}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table class="table table-striped" id="viewDPTable">
		<tbody>
			<tr>
				<td colspan="2">Admission to candidacy is recommended: </td>
				<td colspan="2">Total Semester Hours Requires: ${degreePlan.totalCreditHours}</td>
			</tr>
		</tbody>
	</table
	</form>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-4">
			<input type="accept" value="login" class="btn btn-default" />
		</div>
	</div>
</div>
<div class="footer">
	<div class="container-fluid footer1"><h5 style = "text-align:center;">&#169; 2018 SHAN CSCE UNT</h5></div>
	<div class="container-fluid footer2"><h5 style = "text-align:center;">Contact Us: +1 xxx-xxx-xxxx</h5></div>
</div>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>