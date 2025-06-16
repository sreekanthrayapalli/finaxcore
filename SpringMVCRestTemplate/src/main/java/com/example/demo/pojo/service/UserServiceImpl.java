package com.example.demo.pojo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.UserDetailsImpl;
import com.example.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findById(username).get();
		return new UserDetailsImpl(user);
	}

}
