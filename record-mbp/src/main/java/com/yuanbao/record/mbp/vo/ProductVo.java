package com.yuanbao.record.mbp.vo;

import com.yuanbao.record.mbp.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo {
    private Integer pageSize;
    private Integer pageNum;
    private Long pageTotal;
    private List<Product> productList;
}
