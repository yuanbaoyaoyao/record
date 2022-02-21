package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.mapper.AdminUserMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import com.yuanbao.record.mbp.vomapper.AdminUserVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public IPage<AdminUserVo> selectAdminListSearch(Integer pageNum, Integer pageSize, IPage<AdminUser> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<AdminUserVo> voPage = new Page<>();
        List<AdminUserVo> adminUserVoList = new ArrayList<>();
        IPage<AdminUser> adminUserIPage = adminUserMapper.selectAdminListSearch(pageNum, pageSize, page, keyword);
        List<AdminUser> adminUserList = adminUserIPage.getRecords();
        for (AdminUser adminUser : adminUserList) {
            AdminUserVo adminUserVo = AdminUserVoMapper.adminuservomapper.Trans(adminUser);
            adminUserVoList.add(adminUserVo);
        }
        voPage.setRecords(adminUserVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(adminUserIPage.getTotal());
        return voPage;
    }

    @Override
    public AdminUser selectAdminListByName(String adminUserName) {
        return adminUserMapper.selectAdminListByName(adminUserName);
    }

//    @Override
//    public List<AdminUser> selectAdminListSearch(List<AdminUser> adminUserList, String keyword) {
//        return adminUserMapper.selectAdminListSearch(adminUserList, keyword);
//    }

    @Override
    public int insert(AdminUser adminUser) {
        int id = adminUserMapper.insert(adminUser);
        return id;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return adminUserMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(AdminUser adminUser) {
        return adminUserMapper.updateByPrimaryKey(adminUser);
    }


}