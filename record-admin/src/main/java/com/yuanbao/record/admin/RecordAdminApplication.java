package com.yuanbao.record.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yuanbao.**")
@MapperScan(basePackages = {"com.yuanbao.**.mapper"})
public class RecordAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordAdminApplication.class, args);
    }

}
