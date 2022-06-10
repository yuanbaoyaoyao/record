//package com.yuanbao.record.admin.service.Impl;
//
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.yuanbao.record.admin.service.AdminTokenService;
//import com.yuanbao.record.mbp.mapper.AdminTokenMapper;
//import com.yuanbao.record.mbp.mapper.entity.AdminToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminTokenServiceImpl extends ServiceImpl<AdminTokenMapper, AdminToken> implements AdminTokenService {
//
//    @Autowired
//    private AdminTokenMapper adminTokenMapper;
//
//    @Override
//    public AdminToken selectByToken(String token) {
//        return adminTokenMapper.selectByToken(token);
//    }
//
//    @Override
//    public AdminToken selectByUserId(Long userId) {
//        return adminTokenMapper.selectByUserId(userId);
//    }
//
//    @Override
//    public int insert(AdminToken adminToken) {
//        return adminTokenMapper.insert(adminToken);
//    }
//
//    @Override
//    public int updateByPrimaryKey(AdminToken adminToken) {
//        return adminTokenMapper.updateByPrimaryKey(adminToken);
//    }
//}
