package com.example.demoC14.service;

import com.example.demoC14.domain.User;

import java.util.Map;

public interface SecurityTokenGenerate {
   Map<String,String> generateToken(User user);
}
