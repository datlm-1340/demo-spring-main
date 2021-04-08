package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = {"/loginPage" }, method = RequestMethod.GET)
    public String loginPage(Model model) {		
		return "loginPage";
	}
	
	@RequestMapping(value = {"/loginSuccess" }, method = RequestMethod.GET)
    public String loginSuccess(Model model) {		
		return "loginSuccess";
	}
	
	
	@RequestMapping(value = {"/403" }, method = RequestMethod.GET)
    public String page403(Model model) {		
		return "403";
	}
	
}
