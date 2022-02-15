package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.AdminOperationLog;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminOperationLogMapper extends BaseMapper<AdminOperationLog> {
    IPage<AdminOperationLog> selectAdminOperationLogListSearch(Integer pageNum, Integer pageSize, IPage<AdminOperationLog> page, String keyword);

    int insert(AdminOperationLogVo adminOperationLogVo);

    int deleteByPrimaryKey(Long id);

}
