package com.example.demo.bo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("client")
public class Client {
    int cid;
    String cname;
    String password;
    String phone;
    String email;
}
