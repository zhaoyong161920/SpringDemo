package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户不存在")
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){

    }

    public UserNotFoundException(String message){
        super(message);
    }
}
