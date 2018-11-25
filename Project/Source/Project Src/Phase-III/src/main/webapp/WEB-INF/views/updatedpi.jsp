<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/adminspecialistheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<h4 align="center"><strong>Update Degree Plan Information</strong></h4>
	<div class="col-sm-10">
		<textarea name="message" class="form-control field" id="dpi" cols="40" rows="5">${dpi}</textarea>
	</div>
	<div class="col-sm-2">
		<input type="submit" value="Update" class="btn btn-primary" />
	</div>
	<div class="col-sm-12">
	<h4 align="center"><strong>Update Computer Engineering Core Courses</strong></h4>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group A</i></u></strong></h5>
	<c:forEach items="${groupACourses}" var="groupACourse" varStatus="theCount">
	<input type="text" class="form-control field" id="theCount.count"
						name="'ceCoreA' + theCount.index" value="${groupACourse.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group B</i></u></strong></h5>
	<c:forEach items="${groupBCourses}" var="groupBCourse" varStatus="theCount">
	<input type="text" class="form-control field" id="theCount.count"
						name="'ceCoreB' + theCount.index" value="${groupBCourse.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group C</i></u></strong></h5>
	<c:forEach items="${groupCCourses}" var="groupCCourse" varStatus="theCount">
	<input type="text" class="form-control field" id="theCount.count"
						name="'ceCoreC' + theCount.index" value="${groupCCourse.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group D</i></u></strong></h5>
	<c:forEach items="${groupDCourses}" var="groupDCourse" varStatus="theCount">
	<input type="text" class="form-control field" id="theCount.count"
						name="'ceCoreD' + theCount.index" value="${groupDCourse.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-12">
	<h4 align="center"><strong>Update Computer Science Core Courses</strong></h4>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group A</i></u></strong></h5>
	<c:forEach items="${groupACoursesCE}" var="groupACourseCE" varStatus="theCount">
	<input type="text" class="form-control field" id="theCount.count"
						name="'csCoreA' + theCount.index" value="${groupACourseCE.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group B</i></u></strong></h5>
	<c:forEach items="${groupBCoursesCE}" var="groupBCourseCE" varStatus="theCount">
	<input type="text" class="form-control field" id="theCount.count"
						name="'csCoreB' + theCount.index" value="${groupBCourseCE.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group C</i></u></strong></h5>
	<c:forEach items="${groupCCoursesCE}" var="groupCCourseCE" varStatus="theCount">
	<input type="text" class="form-control field" id="theCount.count"
						name="'csCoreC' + theCount.index" value="${groupCCourseCE.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-6">
	<h5><strong><u><i>Group D</i></u></strong></h5>
	<c:forEach items="${groupDCoursesCE}" var="groupDCourseCE" varStatus="theCount">
	<input type="text" class="form-control field" id="theCount.count"
						name="'csCoreD' + theCount.index" value="${groupDCourseCE.courseName}">
	</c:forEach>
	</div>
	<div class="col-sm-offset-5 col-sm-2">
	<h5><strong><u><i></i></u></strong></h5>
		<input type="submit" value="Update" class="btn btn-primary" />
	</div>
	<div class="col-sm-12">
	<h4 align="center"><strong>Update Optional Courses</strong></h4></div>
	<c:forEach items="${optionalCourseLists}" var="optionalCourseList" varStatus="theCount">
	<div class="col-sm-10">
	<input type="text" class="form-control field" id="theCount.count"
					name="'optionalCourse' + theCount.index" value="${optionalCourseList}">
	</div>
	<div class="col-sm-2">
	<input type="submit" value="Delete" class="btn btn-primary" /></div>
	</c:forEach>
	<div>
		<div class="col-sm-12">
	<h4 align="center"><strong></strong></h4></div>
	<div class="col-sm-10">
	<input type="text" class="form-control field" id="addOp"
					name="newOpCourse" placeholder="Please enter the course number and name" style="visibility:hidden">
	</div>
	<div class="col-sm-2">
	<input type="submit" value="Add" class="btn btn-primary" id="add" style="visibility:hidden"/>
	</div>
	</div>
	<div class="col-sm-offset-5 col-sm-2">
	<h5><strong><u><i></i></u></strong></h5>
		<input type="submit" value="Update" class="btn btn-primary" />
	</div>
	<div class="col-sm-4">
	<h5><strong><u><i></i></u></strong></h5>
		<input type="submit" value="Add a Optional Course" id = "addOpCourse" onclick="addOpCourse()" class="btn btn-primary" />
	</div>
</div><br>

<div class="footer">
	<div class="container-fluid footer1"><h5 style = "text-align:center;">&#169; 2018 SHAN CSCE UNT</h5></div>
	<div class="container-fluid footer2"><h5 style = "text-align:center;">Contact Us: +1 xxx-xxx-xxxx</h5></div>
</div>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	function addOpCourse(){
		document.getElementById("add").style.visibility="visible";
		document.getElementById("addOp").style.visibility="visible";
	}
</script>
</body>
</html>