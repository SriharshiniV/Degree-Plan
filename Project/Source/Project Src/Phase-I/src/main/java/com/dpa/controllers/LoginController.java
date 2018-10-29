package com.dpa.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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

import com.dpa.model.Login;
import com.dpa.model.Request;
import com.dpa.security.Hashing;
import com.dpa.service.LoginService;
import com.dpa.service.RetrieveUsersService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	RetrieveUsersService retrieveUsersService;

//It redirects all the users to the login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
//This method is called upon hitting login button and validates user
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String userName, @RequestParam String password,
			@RequestParam String role, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		List<Login> result = new ArrayList<Login>();
		Hashing hashing = new Hashing();
		String pwd = hashing.hashString(password, "MD5");
		result = loginService.checkCredentials(userName, pwd, role);
		if (result.isEmpty() == true) {
			model.put("errorMsg", "Invalid Credentials");
			return "login";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userName",userName); 
			if (role.equals("admin")) {
				return "adminhome";
			} else if(role.equals("student")) {
				List<Request> myAdvisors = retrieveUsersService.getMyAdvisors(userName);
				model.addAttribute("myAdvisors", myAdvisors);
				return "studenthome";
			} else if(role.equals("professor") || role.equals("chair") || role.equals("associateChair")) {
				model.addAttribute("myStudents", retrieveUsersService.getMyStudents(userName));
				return "professorhome";
			}else {
				return "temp";
			}
		}
	}
}
