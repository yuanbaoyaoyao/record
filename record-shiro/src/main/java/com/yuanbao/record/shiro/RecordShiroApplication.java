package com.yuanbao.record.shiro;

import org.apache.shiro.spring.boot.autoconfigure.ShiroAnnotationProcessorAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yuanbao.**", exclude = {ShiroAnnotationProcessorAutoConfiguration.class})
@MapperScan(basePackages = {"com.yuanbao.record.mbp.mapper"})
//@ComponentScan(nameGenerator = UniqueNameGenerator.class)

public class RecordShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordShiroApplication.class, args);
    }

}
