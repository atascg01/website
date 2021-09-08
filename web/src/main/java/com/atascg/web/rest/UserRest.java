package com.atascg.web.rest;

import com.atascg.web.model.User;
import com.atascg.web.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(value = "/register")
    public ResponseEntity<User> registerUser(@RequestParam String name){
        User newUser = new User();
        newUser.setName(name);
        User user = userServiceImpl.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
