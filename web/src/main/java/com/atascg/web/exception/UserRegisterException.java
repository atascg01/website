package com.atascg.web.exception;

public class UserRegisterException extends Exception{

    String message;

    public UserRegisterException(String message) {
        super();
        this.message = message;
    }
}
