package com.atascg.web.service.impl;

import com.atascg.web.model.User;
import com.atascg.web.repository.UserRepository;
import com.atascg.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository(){
        return userRepository;
    }

    public User save(User user) {
        return getUserRepository().save(user);
    }

    public User getByEmail(String email) {
        return getUserRepository().findByEmail(email);
    }

}
