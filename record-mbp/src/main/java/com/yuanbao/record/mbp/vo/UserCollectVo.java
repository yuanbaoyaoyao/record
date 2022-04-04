package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCollectVo {
    private Long id;
    private Long userId;
    private Long productSkusId;
    private LocalDateTime createdAt;
}
