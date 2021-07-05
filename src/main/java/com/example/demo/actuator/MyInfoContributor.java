package com.example.demo.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MyInfoContributor implements InfoContributor {
    // 自定义 info
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("MyInfo", "myInfo");
    }
}
