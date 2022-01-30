package com.atascg.web.rest;

import com.atascg.web.exception.UserRegisterException;
import com.atascg.web.model.User;
import com.atascg.web.service.UserValidationService;
import com.atascg.web.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserValidationService userValidationService;

    @PostMapping(value = "/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        try {
            userValidationService.validateUser(user);
        } catch (UserRegisterException e) {
            return ResponseEntity.badRequest().body(null);
        }
        userServiceImpl.save(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        return ResponseEntity.of(Optional.ofNullable(userServiceImpl.getByEmail(email)));
    }

}
