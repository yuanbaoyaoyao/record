package com.yuanbao.record.admin;

import com.yuanbao.record.mbp.entity.User;
import com.yuanbao.record.mbp.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RecordAdminApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        List<User> userList =userMapper.selectList(null);
        Assert.assertEquals(2,userList.size());
        userList.forEach(System.out::println);
    }
}
