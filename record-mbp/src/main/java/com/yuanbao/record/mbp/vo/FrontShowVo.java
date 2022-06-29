package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FrontShowVo {
    private Long id;
    private Long productSkusId;
    private String productSkusName;
    private String productName;
    private String avatar;
    private Integer stock;
    private Boolean showRotation;
    private Boolean showOld;
    private Boolean showNew;
    private String description;
    private LocalDateTime createdAt;
}
