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

    private User user = new User("test", "test@test.com", "000000000");

    @BeforeEach
    public void setUp(){
        Mockito.when(userServiceImpl.getUserRepository()).thenReturn(userRepository);
    }

    @Test
    public void userIsSaved(){
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        User savedUser = userServiceImpl.save(user);
        assertEquals("test", savedUser.getName());
    }

    @Test
    public void userIsRetrievedByEmail(){
        Mockito.when(userRepository.findByEmail("test@test.com")).thenReturn(user);
        assertEquals(userServiceImpl.getByEmail("test@test.com"), user);
    }

    @Test
    public void userIsNotFoundByEmail(){
        Mockito.when(userRepository.findByEmail(Mockito.any())).thenReturn(null);
        assertNull(userServiceImpl.getByEmail("different@different.com"));
    }

}