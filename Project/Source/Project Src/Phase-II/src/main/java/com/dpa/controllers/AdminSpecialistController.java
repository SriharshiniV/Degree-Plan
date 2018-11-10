package com.dpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
