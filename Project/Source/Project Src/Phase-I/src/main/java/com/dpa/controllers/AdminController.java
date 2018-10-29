package com.dpa.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpa.model.Register;
import com.dpa.service.RegisterService;
import com.dpa.service.RetrieveUsersService;

@Controller
public class AdminController {
	@Autowired
	RegisterService registerService;
	
//directs user to adminhome	
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public String login() {
		return "adminhome";
	}
//returns add user page
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String manageChair(HttpServletRequest request, HttpServletResponse response, @RequestParam String add, Model model) {
		model.addAttribute("user", add);
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String) session.getAttribute("userName");
		} 
		return "adduser";
	}
//calls insertUser() of registerService class to add chair, associate chair and admin specialist to the database	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute Register register, ModelMap model) {
		int result = registerService.insertUser(register);

		if (result == 1) {
			model.put("success", "User registered successfully");
			return "adduser";
		} else {
			model.put("error", "Username already existing");
			return "adduser";
		}
	}
}
