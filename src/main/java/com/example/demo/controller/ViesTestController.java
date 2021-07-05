package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViesTestController {

    @GetMapping("/page1")
    public String pageJump(Model model) {
        // Model中的数据会被自动放到请求域中 request.setAttribute()
        model.addAttribute("msg", "你好 thymleaf");
        model.addAttribute("link","www.baidu.com");
        return "success";
    }
}
