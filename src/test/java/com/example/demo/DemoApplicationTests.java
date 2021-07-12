package com.example.demo;

import com.example.demo.bean.UserA;
import com.example.demo.bean.UserB;
import com.example.demo.bo.Client;
import com.example.demo.dao.ClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataSource dataSource;


    @Test
    void contextLoads(){
        log.info("数据源：{}",dataSource.getClass());
    }

    @Test
    void testCopy(){
        UserB userB = new UserB("lisi", "123");
        UserA userA = new UserA(1,"zhangsan","basketball");
        log.info(userA.toString());
        log.info(userB.toString());
        log.info("----------");
        BeanUtils.copyProperties(userB, userA); // 复制共有属性
        log.info(userA.toString());
        log.info(userB.toString());
    }

}
