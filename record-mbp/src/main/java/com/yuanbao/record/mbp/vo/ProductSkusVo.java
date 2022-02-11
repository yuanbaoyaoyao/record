package com.yuanbao.record.mbp.vo;

import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import lombok.Data;

import java.util.List;

@Data
public class ProductSkusVo {
    private Integer pageSize;
    private Integer pageNum;
    private Long pageTotal;
    private List<ProductSkus> productSkusList;
}
