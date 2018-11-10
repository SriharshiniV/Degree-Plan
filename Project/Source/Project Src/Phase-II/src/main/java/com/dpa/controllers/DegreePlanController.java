package com.dpa.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpa.model.DegreePlan;
import com.dpa.model.Request;
import com.dpa.service.DegreePlanService;
import com.dpa.service.RetrieveUsersService;

//handles the view, submit, save and all other degree plan action requests
@Controller
public class DegreePlanController {
	@Autowired
	DegreePlanService degreePlanService;
	@Autowired
	RetrieveUsersService retrieveUsersService;
	
//gets mandatory and optional courses form the database and makes them available to the view degreepla.jsp
	@RequestMapping(value = "/degreeplan", method = RequestMethod.POST)
	public String openDegreePlan(@RequestParam String selectPlan,@RequestParam String majProfessor, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		model.put("major", selectPlan);
		model.put("majorProfessor", majProfessor);
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
			model.addAttribute("groupACourses", degreePlanService.getGroupACourses(selectPlan));
			model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses(selectPlan));
			model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses(selectPlan));
			model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses(selectPlan));
			model.addAttribute("optionalCourses", optionalCourses);
			model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
			return "degreeplan";
		} else {
			return "login";
		}
	}
//redirects user to the degree plan page with the success message upon success else to the degree plan with error message
	@RequestMapping(value = "/degreeplanform", method = RequestMethod.POST)
	public String submitDegreePlan(@ModelAttribute DegreePlan degreePlan, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			int result = degreePlanService.submitDegreePlan(degreePlan, userName);
			model.put("success", "Degree Plan Submitted Successfully");
			return "degreeplan";
		} else {
			model.put("error", "Submission Failed");
			return "degreeplan";
		}
	}
	
	//method that returns a vieDegreePlan page with the model data of the page
		@RequestMapping(value = "/viewdegreeplan", method = RequestMethod.GET)
		public String viewPlan(@RequestParam(value = "uName", required = false) String uName, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("degreePlan", degreePlanService.viewDegreePlan(uName, userName));
				model.addAttribute("gre", degreePlanService.getGREScores(uName));
				model.addAttribute("courses", degreePlanService.getCourses(uName));
				return "viewdegreeplan";
			} else {
				return "login";
			}
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/submitToAdminSpecialist", method = RequestMethod.POST)
		public String submitToAdminSpecialist(@RequestParam String sign, @RequestParam String sName, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("degreePlan", degreePlanService.viewDegreePlan(sName, userName));
				model.addAttribute("gre", degreePlanService.getGREScores(sName));
				model.addAttribute("courses", degreePlanService.getCourses(sName));
				int result = degreePlanService.submitToAdminSpecialist(userName, sName, sign);
				if(result != 0) {
					model.put("success", "Degree Plan Successfully submitted to Admin Specialist");
				return "viewdegreeplan";
				}else {
					model.put("error", "Submission Failed, try again");
					return "viewdegreeplan";	
				}
			} else {
				return "login";
			}
		}
		
		//It redirects professor to add reject comments page
		@RequestMapping(value = "/rejectDP", method = RequestMethod.GET)
		public String rejectComments(@RequestParam(value = "sName", required = false) String sName, ModelMap model) {
			model.put("studentName", sName);
			return "rejectcomments";
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/professorReject", method = RequestMethod.POST)
		public String dPProfessorReject(@RequestParam String studentName, @RequestParam String comments, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.dPProfessorreject(userName, studentName, comments);
				if(result != 0) {
					model.addAttribute("myStudents", retrieveUsersService.getMyStudents(userName));
					return "professorhome";
				}else {
					model.addAttribute("degreePlan", degreePlanService.viewDegreePlan(studentName, userName));
					model.addAttribute("gre", degreePlanService.getGREScores(studentName));
					model.addAttribute("courses", degreePlanService.getCourses(studentName));
					return "viewdegreeplan";
				}
			} else {
				return "login";
			}
		}
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/viewDPStatus", method = RequestMethod.POST)
		public String viewDPStatus(@RequestParam String majorProfessor, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				String dpStatus = degreePlanService.getDPStatus(userName, majorProfessor);
				if(dpStatus.equals("submitted")) {
					dpStatus = "With Professor";
				}
				model.put("degreePlanStatus", dpStatus);
				List<Request> myAdvisors = retrieveUsersService.getMyAdvisors(userName);
				model.addAttribute("myAdvisors", myAdvisors);
				if(dpStatus.equals("Professor Rejected")) {
					String rejectComments = degreePlanService.getComments(userName, majorProfessor);
					model.put("rejectComments", rejectComments);
					model.put("resubmitDP", "Update and resubmit the Degree Plan");
				}
				return "studenthome";
			} else {
				return "login";
			}
		}
		
		//This method submits the degree plan to the administrative specialist
		@RequestMapping(value = "/updateDegreePlan", method = RequestMethod.POST)
		public String updateDegreePlan(HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("degreePlan", degreePlanService.getDegreePlan(userName));
				model.addAttribute("gre", degreePlanService.getGREScores(userName));
				model.addAttribute("courses", degreePlanService.getCourses(userName));
				List<Request> myAdvisors = retrieveUsersService.getMyAdvisors(userName);
				model.addAttribute("myAdvisors", myAdvisors);
				return "updatedegreeplan";
			} else {
				return "login";
			}
		}
		
		//updates and resubmits degree plan
		@RequestMapping(value = "/updatedegreeplan", method = RequestMethod.POST)
		public String updatetDegreePlan(@ModelAttribute DegreePlan degreePlan, HttpServletRequest request, HttpServletResponse response, ModelMap model){
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				int result = degreePlanService.updateDegreePlan(degreePlan, userName);
				model.put("success", "Degree Plan Submitted Successfully");
				return "degreeplan";
			} else {
				model.put("error", "Submission Failed");
				return "degreeplan";
			}
		}
}

