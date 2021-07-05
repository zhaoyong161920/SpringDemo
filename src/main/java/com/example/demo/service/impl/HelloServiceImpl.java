package com.example.demo.service.impl;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Value("${allowedCode}")
    private Integer allowedCode;

    @Value("${person.name}")
    private String name;


    public String handle() {
        return "AllowCode: " + allowedCode
                + "\n" + "Name: " + name;
    }
}
