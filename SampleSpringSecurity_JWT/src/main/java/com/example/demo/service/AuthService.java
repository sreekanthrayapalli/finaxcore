package com.example.demo.service;

import com.example.demo.pojo.User;

public interface AuthService {
    String login(User loginDto);
}