<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/studentheader.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="toChange">
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
					<tr>
						<td id="profName">${myAdvisors.professorName}</td>
						<td>${myAdvisors.professorEmail}</td>
					</tr>
			</tbody>
		</table>
	</div>
	<div class="container"><h4>My Degree Plan</h4></div><br>
	<div class = "container">
		<div class="col-sm-12">
			<input type="submit" value="Start New Degree Plan" style = "background-color:#e6ffb3" class="btn btn-default col-sm-5" onclick="selectForm();" />
			<div class="col-sm-5">
				<form action="/dpa/degreeplan" method = "POST">
					<div class="degreePlan" id="degreePlan" style="visibility:hidden;">
					<select class="form-control field selectPlan" id ="selectDegreePlan"  name="selectPlan" style = "background-color:#e6ffb3" onchange="this.form.submit()">
					  <option value="Select">Select</option>
					  <option value="computerScience">Computer Science</option>
					  <option value="computerEngineering">Computer Engineering</option>
					</select>
					</div>
					<input type="text" class="form-control field" name="majorProfessor" value="${myAdvisors.professorName}" style="visibility:hidden;">
				</form>
			</div>
		</div>
		<div class="col-sm-12">
				<form action="/dpa/viewDPStatus" method = "POST">
					<input type="submit" value="Degree Plan Status" style = "background-color:#e6ffb3" class="btn btn-default col-sm-5"/>
					<p class = "col-sm-offset-1 col-sm-3" id="degreePStatus">${degreePlanStatus}</p>
					<p class = "col-sm-2" id="viewComments">${rejectComments} 
					<input type="text" class="form-control field" name="majProfessor" value="${myAdvisors.professorName}" style="visibility:hidden;">
				</form>
			<div class="col-sm-2">
				<form id="updateDP" action="/dpa/updateDegreePlan" method="POST"><a href="#" onclick="document.getElementById('updateDP').submit();">${resubmitDP}</a>
				</form>
			</div>
		</div>
	</div>
	<div class="col-sm-offset-6 col-sm-4">
		<form id="downloadDP" action="/dpa/viewApprovedDP" method="POST"><a href="#" onclick="document.getElementById('downloadDP').submit();">${downloadDP}</a>
			</form>
	</div>
	</div>
</div>

<script>
	function selectForm(){
		$("#degreePlan").css("visibility", "visible");
	}
	function viewdpStatus(){
		$("#degreePStatus").css("visibility", "visible");
	}
</script>

<%@ include file="../common/footer.jspf"%>