package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public static PasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserDetailsService service;
	
	/*@Bean
	public UserDetailsService userDetails() {
		
		UserDetails user1 = User.builder().username("abc").password(password().encode("abc")).
				build();
		UserDetails user2 = User.builder().username("xyz").password(password().encode("xyz")).build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	}
	*/
	
	@Bean
	public DaoAuthenticationProvider getDao() {
		DaoAuthenticationProvider p = new DaoAuthenticationProvider(service);
		p.setPasswordEncoder(password());
		return p;
	}
	
	public static void main(String[] args) {
		String a = "user123";
		String encry = password().encode(a);
		System.out.println(encry);
	}
}
