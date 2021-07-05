package com.example.demo.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.sql.DataSourceDefinition;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor // 全参构造器
@NoArgsConstructor  // 无参构造器
@EqualsAndHashCode
public class User {
    int uid;
    String uname;
    List<Interest> interests;

    public User(int uid, String uname){
        this.uid = uid;
        this.uname = uname;
    }
}
