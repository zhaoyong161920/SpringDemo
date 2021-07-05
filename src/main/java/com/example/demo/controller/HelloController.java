package com.example.demo.controller;

import com.example.demo.bean.Interest;
import com.example.demo.bean.User;
import com.example.demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String handle(){
        log.info("/hello请求。。。");
        return helloService.handle();
    }

    @ResponseBody
    @RequestMapping(value = "/user")
    public User getUser(){
        User user = new User();
        user.setUid(1);
        user.setUname("zhangsan");
        List<Interest> interestList = new ArrayList<>();
        interestList.add(new Interest(1,"game"));
        interestList.add(new Interest(2,"basketball"));
        user.setInterests(interestList);
        return user;
    }




//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public String saveUser(){
//        return "SAVE-张三";
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
//    public String putUser(){
//        return "PUT-张三";
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
//    public String deleteUser(){
//        return "DELETE-张三";
//    }
}
