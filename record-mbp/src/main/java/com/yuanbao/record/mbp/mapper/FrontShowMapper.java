package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.FrontShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FrontShowMapper extends BaseMapper<FrontShow> {

    List<FrontShow> selectByShowRotation();

    List<FrontShow> selectByShowOld();

    List<FrontShow> selectByShowNew();

    int insert(FrontShow frontShow);

    int updateByPrimaryKey(FrontShow frontShow);

    int updateByShowNew();

}
