package com.atascg.web.service.impl;

import com.atascg.web.model.User;
import com.atascg.web.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        Mockito.when(userServiceImpl.getUserRepository()).thenReturn(userRepository);
    }

    @Test
    public void saveUser(){
        User user = new User("test", "test@test.com", "000000000");
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        User savedUser = userServiceImpl.save(user);
        assertEquals("test", savedUser.getName());
    }

}