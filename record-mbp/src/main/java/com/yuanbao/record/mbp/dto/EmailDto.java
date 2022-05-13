package com.yuanbao.record.mbp.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmailDto {
    private List<String> tos;

    private String subject;

    private String content;
}
