package com.yuanbao.record.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.entity.AdminUser;
import com.yuanbao.record.mbp.entity.User;
import com.yuanbao.record.mbp.mapper.AdminUserMapper;
import com.yuanbao.record.mbp.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RecordAdminApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserService adminUserService;

    @Test
    public void testSelect(){
        List<User> userList =userMapper.selectList(null);
        Assert.assertEquals(2,userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testAdminUserList(){
        List<AdminUser> adminUsers = adminUserMapper.selectList(null);
        Assert.assertEquals(5,adminUsers.size());
        adminUsers.forEach((System.out::println));
    }

    @Test
    public void testAdminUserRole1(){
        Page page = new Page<>(1,5);
//        List<AdminUser> adminUsers =adminUserService.selectAdminList(page);
        IPage<AdminUser> adminUserIPage = adminUserMapper.selectPage(page,null);
        Assertions.assertSame(adminUserIPage,page);
        System.out.println(adminUserIPage.getRecords());
        //        adminUsers.forEach((System.out::println));

    }

//    @Test
//    public void testAdminUserRole2(){
//        Page page = new Page<>(1,5);
//        IPage<AdminUser> adminUserIPage = adminUserService.selectAdminList(page);
//        Assertions.assertSame(adminUserIPage,page);
//        System.out.println(adminUserIPage.getRecords());
//    }

    @Test
    public void testAdminUserXml(){
        IPage<AdminUser> page = new Page<AdminUser>(1,5);
        List<AdminUser> adminUserList = adminUserService.selectAdminList(page);
        adminUserList.forEach(System.out::println);
    }

    @Test
    public void testAdminUserXml2(){
        List<AdminUser> adminUserList = new ArrayList<AdminUser>();
        System.out.println(adminUserService.selectAdminAll(adminUserList));
    }

    @Test
    public void testAdminUserXml3(){
        List<AdminUser> adminUserList = new ArrayList<AdminUser>();
        System.out.println(adminUserMapper.selectAdminAll(adminUserList));
    }

}
