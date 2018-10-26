<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/professorheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="toReplace1">
<div class="container" id="myStudents">
	<table class="table table-striped" id="requestTable">
		<h4 align="center">My Students</h4>
		<thead>
			<tr>
				<th>Name</th>
				<th>Department</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${myStudents}" var="myStudent" varStatus="theCount">
				<tr>
					<td>${myStudent.userName}</td>
					<td>${myStudent.department}</td>
					<td><input type="button" class="btn btn-primary sendMessage" value = "Send Message" id="${theCount.count}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
<%@ include file="../common/footer.jspf"%>