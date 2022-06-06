package com.yuanbao.record.shiro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.Map;

@SpringBootTest
public class RecordShiroApplicationTests {
    @Autowired
    private ApplicationContext context;

    @Test
    public void test1() {
        listPermission(context);
    }

    public static void listPermission(ApplicationContext context) {
        System.out.println("context:"+context);
        Map<String, Object> map = context.getBeansWithAnnotation(Controller.class);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object bean = entry.getValue();
            System.out.println(bean);
        }
    }
}
