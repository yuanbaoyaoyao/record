package com.yuanbao.record.mbp.mapper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtUser {

    String username;

    //    private List<String> roles;//用一对多映射查询，联u,u-r,r三表，集合里只放role的name
    private Long roleId;

    public JwtUser() {
    }
}
