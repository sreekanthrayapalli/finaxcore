package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.JWTAuthResponse;
import com.example.demo.pojo.User;
import com.example.demo.service.AuthService;

@RestController
public class MyRestController {
	
	@Autowired
	private AuthService authService;

	@RequestMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@RequestMapping("/ok")
	public String getInfo(HttpServletRequest request) {
		return "done";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<JWTAuthResponse> getLoginSuccess(@RequestBody User user) {
		 String token = authService.login(user);

	        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
	        jwtAuthResponse.setAccessToken(token);

	        return ResponseEntity.ok(jwtAuthResponse);
	}
	
	
}