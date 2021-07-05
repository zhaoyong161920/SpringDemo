package com.example.demo.controller;

import com.example.demo.bean.Interest;
import com.example.demo.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONStringer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ParameterTestController {

    // 测试 @PathVariable
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", name);
        map.put("pv", pv);
        return map;
    }

    // 测试 @RequestHeader
    @RequestMapping("/header")
    public Map<String, Object> getHeader(@RequestHeader("User-Agent") String userAgent,
                                         @RequestHeader Map<String, String> pv){
        Map<String, Object> map = new HashMap<>();
        map.put("user-agent", userAgent);
        map.put("pv", pv);
        return map;
    }

    // 测试 @RequestParam
    @RequestMapping("/parameter")
    public Map<String, Object> getParameter(@RequestParam("age") String age,
                                            @RequestParam("interest") List<String> interest,
                                            @RequestParam Map<String, String> pv){
        Map<String, Object> map = new HashMap<>();
        map.put("age", age);
        map.put("interest", interest);
        map.put("pv", pv);

        return map;
    }

    // 测试 @RequestBody
    @RequestMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("body", content);
        return map;
    }

    // 测试封装对象 前端Post请求传递json数据需要用 @RequestBody  application/json
    @RequestMapping("testObject")
    public User getUser(@RequestBody User user){
        return user;
    }

    // 测试 application/json map接收方式
    // 该方法不适合接收数组类型数据
    @RequestMapping("testObject2")
    public User getUser2(@RequestBody Map<String, Object> map) {
        User user = new User();
        user.setUid((Integer) map.get("uid"));
        user.setUname((String) map.get("uname"));
        log.info(map.get("interests").toString());//[{id=1, iname=basketball}]
        return user;
    }

}
