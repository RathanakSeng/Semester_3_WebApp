package com.testing.reststudent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
	
	@RequestMapping("/home")
	public String index()
	{
	    return "index";
	}
}