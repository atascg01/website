package com.atascg.web.service.impl;

import com.atascg.web.exception.UserRegisterException;
import com.atascg.web.model.User;
import com.atascg.web.service.UserValidationService;
import org.springframework.stereotype.Service;

@Service
public class UserValidationServiceImpl implements UserValidationService {

    @Override
    public void validateUser(User user) throws UserRegisterException {
        validateEmail(user.getEmail());
        validatePhone(user.getPhone());
    }

    private void validateEmail(String email) throws UserRegisterException {
        if(!email.contains("@")){
            throw new UserRegisterException("[USER REGISTER] Email is not valid");
        }
    }

    private void validatePhone(String phone) throws UserRegisterException {
        if(phone.length() != 9){
            throw new UserRegisterException("[USER REGISTER] Phone is not valid");
        }
    }

}
