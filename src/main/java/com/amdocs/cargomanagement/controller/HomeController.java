package com.amdocs.cargomanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String loadForm()
	{
		return "home";
	}
	
}
