package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.bo.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SqlTestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ClientService clientService;

    @GetMapping("/count")
    public String queryFromDb(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from client", Integer.class);
        return count.toString();
    }

    @RequestMapping("/client")
    public Client getClient(@RequestParam("id") int id){
        QueryWrapper<Client> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", id);
        return clientService.getOne(wrapper);
    }


    @RequestMapping("/clients")
    public List<Client> getClients(){
        QueryWrapper<Client> wrapper = new QueryWrapper<>();
        wrapper.ge("cid",10).like("email", "%126.com");
        return clientService.list(wrapper);
    }


    @RequestMapping("/updateEmail")
    public void update(@RequestParam("id") int id,
                       @RequestParam("email") String email){
        UpdateWrapper<Client> wrapper = new UpdateWrapper<>();
        wrapper.eq("cid",id).set("email",email);
        clientService.update(wrapper);
    }

    @PostMapping("insertClient")
    public Client insert(Client c){
        clientService.save(c);
        return c;
    }
}
