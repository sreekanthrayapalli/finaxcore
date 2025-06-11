package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@RequestMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@RequestMapping("/ok")
	public String getInfo(HttpServletRequest request) {
		return "done";
	}
	
	
	@RequestMapping("/userdetails")
	public String dashboard(Model model, OAuth2AuthenticationToken authentication) {
	    Map<String, Object> attributes = authentication.getPrincipal().getAttributes();
	    model.addAttribute("name", attributes.get("name"));
	    model.addAttribute("email", attributes.get("email"));
	    return "dashboard"; 
	}
}
