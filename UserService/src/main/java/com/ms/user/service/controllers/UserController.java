package com.ms.user.service.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ms.user.service.entities.User;
import com.ms.user.service.services.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    //create user
    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
         User savedUser = this.userService.saveUser(user);
         if (savedUser != null) {
            return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
         } else {
            return new ResponseEntity<>(savedUser,HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    //get Single user
    @GetMapping("/get-user/{userId}")
    public User getUser(@PathVariable String userId) {
        return this.userService.getUser(userId);
    }

    //get all users
    @GetMapping("/get-users")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }
}
