package com.dpa.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dpa.model.Register;
import com.dpa.security.Hashing;
import com.dpa.service.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String login() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleLoginRequest(@ModelAttribute Register register, ModelMap model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String uPwd = register.getPassword();
		Hashing hashing = new Hashing();
		String pwd = hashing.hashString(uPwd, "MD5");
		register.setPassword(pwd);
		int result = registerService.insertUser(register);
		if (result == 1) {
			model.put("succ", "Registered Sucessfully, Please Login");
			return "login";
		} else {
			model.put("error", "Username already existing");
			return "register";
		}
	}

}
