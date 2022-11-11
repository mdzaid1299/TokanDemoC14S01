package com.example.demoC14.service;

import com.example.demoC14.domain.User;
import com.example.demoC14.exception.UserNotFoundException;
import com.example.demoC14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    @Autowired
    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) throws UserNotFoundException {
        User user = userRepository.findByUserNameAndPassword(userName,password);
        if(user==null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }
}
