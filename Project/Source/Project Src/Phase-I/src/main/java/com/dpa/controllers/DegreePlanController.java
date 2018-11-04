package com.dpa.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.dpa.service.DegreePlanService;

//handles the view, submit, save and all other degree plan action requests
@Controller
public class DegreePlanController {
	@Autowired
	DegreePlanService degreePlanService;
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
		System.out.println(degreePlan);
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
}


