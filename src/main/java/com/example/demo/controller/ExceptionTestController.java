package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTestController {

    @RequestMapping("/exception")
    public User exception(@RequestParam("uid") int uid){
        if (uid != 1) {
            throw new UserNotFoundException("用户不存在");
        }

        return new User(1,"zhangsan");
    }
}
