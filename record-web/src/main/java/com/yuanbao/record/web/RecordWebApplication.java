package com.yuanbao.record.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yuanbao.**")
@MapperScan(basePackages = {"com.yuanbao.record.mbp.mapper"})
public class RecordWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordWebApplication.class, args);
    }

}
