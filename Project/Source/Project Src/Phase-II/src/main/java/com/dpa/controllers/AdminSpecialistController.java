package com.dpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminSpecialistController {
	//It redirects all the admin specialist to adminspecialist home page
		@RequestMapping(value = "/adminspecialisthome", method = RequestMethod.GET)
		public String login() {
			return "adminspecialisthome";
		}
}
