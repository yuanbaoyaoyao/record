package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.util.List;

@Data
public class PermVo {
    private String id;
    private String label;
    private String api;
    private List<PermVo> children;
}
