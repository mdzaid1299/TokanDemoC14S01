package com.example.demoC14.controller;

import com.example.demoC14.domain.User;
import com.example.demoC14.exception.UserNotFoundException;
import com.example.demoC14.service.SecurityTokenGenerate;
import com.example.demoC14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class UserController {
    private UserService userService;
    private SecurityTokenGenerate securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerate securityTokenGenerator)
    {
        this.userService= userService;
        this.securityTokenGenerator= securityTokenGenerator;

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map= null;

        try
        {
            User user1 = userService.findByUserNameAndPassword(user.getUserName(),user.getPassword());
            if(user1.getUserName().equals(user.getUserName()))
            {
                map= securityTokenGenerator.generateToken(user);

            }

            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
        catch (Exception se)
        {
            se.printStackTrace();
            return new ResponseEntity<>("Other exception", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        User createUser = userService.addUser(user);
        return new ResponseEntity(createUser, HttpStatus.CREATED);
    }
    @GetMapping("/userdata/v1/fetchusers")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> userList = userService.getAllUser();
        return  new ResponseEntity<>(userList,HttpStatus.OK);
    }
}
