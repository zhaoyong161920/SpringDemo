package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("userQuery")
    public User selectById(@RequestParam("id") int id){
        return userService.getById(id);
    }

    @RequestMapping("userPage")
    public Page<User> userPageQuery(@RequestParam("currentPage") int current,
                                    @RequestParam("size") int size){
        Page<User> userPage = new Page<>(current,size);
        Page<User> page = userService.page(userPage);
        return page;
    }
}
