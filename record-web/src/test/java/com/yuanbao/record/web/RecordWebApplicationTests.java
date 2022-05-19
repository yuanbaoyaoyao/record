package com.yuanbao.record.web;

import com.yuanbao.record.web.service.UserClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecordWebApplicationTests {

    @Autowired
    private UserClientService userClientService;

    @Test
    void contextLoads() {
       Boolean isExist = userClientService.isExistEmail("32432@ii.com");
        System.out.println("isExist:"+isExist);
    }

}
