package com.dpa.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpa.service.DegreePlanService;

@Controller
public class AdminSpecialistController {
	@Autowired
	DegreePlanService degreePlanService;
	
	//It redirects all the admin specialist to adminspecialist home page
		@RequestMapping(value = "/adminspecialisthome", method = RequestMethod.GET)
		public String adminHome(Model model) {
			model.addAttribute("degreePlans", degreePlanService.getDegreePlans());
			return "adminspecialisthome";
		}
		
		//It gets the Degree Plan Information
		@RequestMapping(value = "/viewDPI", method = RequestMethod.POST)
		public String getDPI(HttpServletRequest request, HttpServletResponse response, Model model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("dpi", degreePlanService.getDPI());
				model.addAttribute("interestareas", degreePlanService.getInterestAreas());
			}
			return "dpi";
		}
		
		//It gets Interest Area Courses
		@RequestMapping(value = "/getInterestCourses", method = RequestMethod.POST)
		public String getInterestCourses(@RequestBody String major, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			HttpSession session = request.getSession(false);
			String[] mjor = major.split("=");
			String[] m1 = mjor[1].split("&");
			String m = m1[0];
			String interest1 = mjor[2];
			String interest = interest1.replaceAll("\\+", " ");
			model.put("interest", interest);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
				model.addAttribute("groupACourses", degreePlanService.getGroupACourses(m));
				model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses(m));
				model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses(m));
				model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses(m));
				model.addAttribute("optionalCourses", optionalCourses);
				model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
			}
			return "dpi_courses";
		}
		
		//It redirects all the admin specialist to adminspecialist home page
		@RequestMapping(value = "/updateDPI", method = RequestMethod.GET)
		public String updateDPI(HttpServletRequest request, HttpServletResponse response, Model model) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userName = (String) session.getAttribute("userName");
				model.addAttribute("dpi", degreePlanService.getDPI());
				List<Integer> optionalCourses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
				model.addAttribute("groupACourses", degreePlanService.getGroupACourses("CS"));
				model.addAttribute("groupBCourses", degreePlanService.getGroupBCourses("CS"));
				model.addAttribute("groupCCourses", degreePlanService.getGroupCCourses("CS"));
				model.addAttribute("groupDCourses", degreePlanService.getGroupDCourses("CS"));
				model.addAttribute("groupACoursesCE", degreePlanService.getGroupACourses("CE"));
				model.addAttribute("groupBCoursesCE", degreePlanService.getGroupBCourses("CE"));
				model.addAttribute("groupCCoursesCE", degreePlanService.getGroupCCourses("CE"));
				model.addAttribute("groupDCoursesCE", degreePlanService.getGroupDCourses("CE"));
				model.addAttribute("optionalCourses", optionalCourses);
				model.addAttribute("optionalCourseLists", degreePlanService.getOptionalCourses());
				return "updatedpi";	
			}else {
			return "login";	
			}
		}
		
}
