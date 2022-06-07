package com.yuanbao.record.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yuanbao.**")
public class RecordSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecordSearchApplication.class, args);
    }
}
