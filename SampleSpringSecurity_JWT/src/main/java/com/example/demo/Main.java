package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

	public static void main(String[] args) {
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		String pwd  = "user123";
		String result = en.encode(pwd);
		System.out.println(result);

	}

}
