package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局异常处理（所有Controller）
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    // 处理算数异常
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class,UserNotFoundException.class})
    public String handlerArithException(Exception e){
        log.error("异常是：{}", e.getMessage());
//        return "forward:/";
//        return "redirect:/";
        return "success";
    }
}
