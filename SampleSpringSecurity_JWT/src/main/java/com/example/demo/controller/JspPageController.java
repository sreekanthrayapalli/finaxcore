package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JspPageController {

	
	@RequestMapping(value="/ok", method = RequestMethod.POST)
	public String getLoginOk() {
		return "ok";
	}
}
