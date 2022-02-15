package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductSkusVo {
    //    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
//    private List<ProductSkus> productSkusList;
    private String productName;
    private String title;
    private String avatar;
    private String description;
    private Integer stock;
    private Timestamp createdAt;
}
