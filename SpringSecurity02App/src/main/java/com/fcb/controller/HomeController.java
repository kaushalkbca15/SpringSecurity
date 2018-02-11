package com.fcb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest req){
		System.out.println(req.getMethod());
		return "home";
	}
	@RequestMapping(value="/userlogin",method=RequestMethod.GET)
	public String showLoginPage(HttpServletRequest req){
		System.out.println(req.getMethod());
		return "loginpage";
	}
}
