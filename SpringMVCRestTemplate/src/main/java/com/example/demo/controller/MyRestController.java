package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyRestController {
	
	@Value("${rest.url}")
	private String url;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@RequestMapping("/getempdata")
	public Object getEmployeeData() {
		Object result = restTemplate.getForObject("http://localhost:8080/employeeservice", Object.class);
		return result;
	}
	
	@RequestMapping(value = "/postempdata", method=RequestMethod.POST)
	public String saveEmployeeData(@RequestBody Employee emp) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Employee> request = new HttpEntity<>(emp, headers);
		ResponseEntity<String> result = restTemplate.exchange(url+"/employeeservice", HttpMethod.POST, request, String.class);
		return result.getBody();
	}
}
