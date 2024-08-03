package com.ms.user.service.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ms.user.service.entities.User;

public interface UserService {

    //create user

    User saveUser(User user);

    //get all user
    List<User> getUsers();

    //get specific user
    User getUser(String userId);

    //Delete user
    ResponseEntity<HttpStatus> deleteUser(String userID);

    //Update User
    ResponseEntity<HttpStatus> updateUser(User user);

    
}
