package com.atascg.web.service.impl;

import com.atascg.web.exception.UserRegisterException;
import com.atascg.web.model.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class UserValidationServiceImplTest {

    @InjectMocks
    private UserValidationServiceImpl userValidationServiceImpl;

    @Test
    public void wrongEmail(){
        User user = new User("Test", "", "");
        assertThrows(UserRegisterException.class, () -> userValidationServiceImpl.validateUser(user));
    }

    @Test
    public void wrongPhone(){
        User user = new User("Test", "test@test.com", "");
        assertThrows(UserRegisterException.class, () -> userValidationServiceImpl.validateUser(user));
    }
}