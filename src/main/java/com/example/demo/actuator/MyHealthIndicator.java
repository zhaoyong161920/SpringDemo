package com.example.demo.actuator;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {
    @Autowired
    DataSource dataSource;

    // 自定义健康检查
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        if (dataSource.getClass().getName().contains("Druid")) {
            builder.up();
        } else {
            builder.down();
        }

        builder.withDetail("DataSource", dataSource.getClass());
    }
}
