package com.yuanbao.record.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yuanbao.**")
@MapperScan(basePackages = {"com.yuanbao.record.mbp.mapper"})
public class RecordShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordShiroApplication.class, args);
    }

}
