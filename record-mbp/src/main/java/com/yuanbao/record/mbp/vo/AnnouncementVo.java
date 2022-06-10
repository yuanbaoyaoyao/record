package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementVo {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
