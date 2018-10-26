<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/studentheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="toReplace">
	<div class="container" id="myAdvisor">
		<table class="table table-striped" id="requestTable">
			<h4 align="center">My Advisor</h4>
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${myAdvisors}" var="myAdvisor" varStatus="theCount">
					<tr>
						<td>${myAdvisor.professorName}</td>
						<td>${myAdvisor.professorEmail}</td>
						<td><input type="button" class="btn btn-primary sendMessage" value = "Send Message" id="${theCount.count}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../common/footer.jspf"%>