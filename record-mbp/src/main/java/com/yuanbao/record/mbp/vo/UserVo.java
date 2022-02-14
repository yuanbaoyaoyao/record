package com.yuanbao.record.mbp.vo;

import com.yuanbao.record.mbp.mapper.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private Integer pageSize;
    private Integer pageNum;
    private Long pageTotal;
    private List<User> userList;
}
