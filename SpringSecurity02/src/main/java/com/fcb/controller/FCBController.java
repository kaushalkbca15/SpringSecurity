package com.fcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FCBController {
	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public String homePage(){
		return "home";
	}
	
	@RequestMapping(value="fcblogin",method=RequestMethod.GET)
	public String loginPage(){
		return "fcblogin";
	}
	
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	public String userPage(){
		return "user";
	}
	
	@RequestMapping(value="admin",method=RequestMethod.GET)
	public String adminPage(){
		return "admin";
	}
}
