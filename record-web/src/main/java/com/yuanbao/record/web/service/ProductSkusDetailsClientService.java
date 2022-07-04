package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusDetails;
import com.yuanbao.record.mbp.vo.ProductSkusDetailsVo;

import java.util.List;

public interface ProductSkusDetailsClientService extends IService<ProductSkusDetails> {
    List<ProductSkusDetailsVo> selectList(Long productSkusId);
}
