package com.yuanbao.record.admin;

import com.yuanbao.record.common.util.SaltUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecordAdminApplicationTests {
//    单表
    @Test
    public void test() {
        String s = SaltUtil.generateSalt(20);
        System.out.println(s);
    }



}
