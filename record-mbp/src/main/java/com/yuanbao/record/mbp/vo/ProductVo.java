package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductVo {
    //    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
//    private List<Product> productList;
    private String title;
    private String description;
    private Timestamp createdAt;
}
