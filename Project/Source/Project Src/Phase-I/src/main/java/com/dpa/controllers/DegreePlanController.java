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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpa.model.Course;
import com.dpa.model.DegreePlan;
import com.dpa.service.DegreePlanService;

@Controller
public class DegreePlanController {
	@Autowired
	DegreePlanService degreePlanService;
	
	@RequestMapping(value = "/degreeplan", method = RequestMethod.POST)
	public String openDegreePlan(@RequestParam String selectPlan, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		model.put("major", selectPlan);
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
	
	@RequestMapping(value = "/degreeplanform", method = RequestMethod.POST)
	public String submitDegreePlan(@RequestParam DegreePlan degreePlan, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		System.out.println(degreePlan);
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			return "studenthome";
		} else {
			return "login";
		}
	}

}
