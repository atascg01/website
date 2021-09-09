package com.atascg.web.service;

import com.atascg.web.exception.UserRegisterException;
import com.atascg.web.model.User;

public interface UserValidationService {

    void validateUser(User user) throws UserRegisterException;

}
