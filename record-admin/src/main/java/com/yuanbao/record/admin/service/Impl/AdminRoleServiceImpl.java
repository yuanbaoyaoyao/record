package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminRoleService;
import com.yuanbao.record.mbp.mapper.AdminRoleMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminRole;
import com.yuanbao.record.mbp.vo.AdminRoleVo;
import com.yuanbao.record.mbp.vomapper.AdminRoleVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public IPage<AdminRoleVo> selectRoleList(Integer pageNum, Integer pageSize, IPage<AdminRole> page, String keyword,Long id) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<AdminRoleVo> voPage = new Page<>();
        List<AdminRoleVo> adminRoleVoList = new ArrayList<>();
        IPage<AdminRole> adminRoleIPage = adminRoleMapper.selectRoleList(pageNum, pageSize, page, keyword,id);
        List<AdminRole> adminRoleList = adminRoleIPage.getRecords();
        for (AdminRole adminRole : adminRoleList) {
            AdminRoleVo adminRoleVo = AdminRoleVoMapper.adminrolevomapper.Trans(adminRole);
            adminRoleVoList.add(adminRoleVo);
        }
        voPage.setRecords(adminRoleVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(adminRoleIPage.getTotal());
        return voPage;
    }

    @Override
    public String selectNameById(Long id) {
        System.out.println("正在使用selectNameById");
        System.out.println("id" + id);
        System.out.println("adminRoleMapper.selectById(id):" + adminRoleMapper.selectById(id));
        return adminRoleMapper.selectById(id).getName();
    }

    @Override
    public int insert(AdminRole adminRole) {
        int id = adminRoleMapper.insert(adminRole);
        return id;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return adminRoleMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(AdminRole adminRole) {
        return adminRoleMapper.updateByPrimaryKey(adminRole);
    }
}
