package com.dpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfessorController {
	@RequestMapping(value = "/professorhome", method = RequestMethod.GET)
	public String login() {
		return "professorhome";
	}
}
