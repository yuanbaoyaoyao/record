package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductVo {
    //    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
//    private List<Product> productList;
    private String title;
    private String description;
    private LocalDateTime createdAt;
}
