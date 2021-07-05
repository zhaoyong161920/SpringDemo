package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller // @RestController无法返回页面
public class FileUploadTestController {

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestPart("file") MultipartFile file,
                         @RequestPart("multiFile") MultipartFile[] files){
        log.info("email: {}", email);
        log.info("单个文件文件名称：{} ； 文件大小：{}",file.getName(),file.getSize());
        log.info("多个文件文件数量：{}",files.length);
        return "success";
    }
}
