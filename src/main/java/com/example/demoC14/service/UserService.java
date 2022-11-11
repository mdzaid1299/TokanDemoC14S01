package com.example.demoC14.service;

import com.example.demoC14.domain.User;
import com.example.demoC14.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public User findByUserNameAndPassword(String userName, String password) throws UserNotFoundException;
    List<User> getAllUser();
}
