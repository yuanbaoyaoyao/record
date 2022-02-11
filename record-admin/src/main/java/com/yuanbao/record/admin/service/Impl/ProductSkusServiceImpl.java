package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.ProductSkusService;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.mapper.ProductSkusMapper;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSkusServiceImpl extends ServiceImpl<ProductSkusMapper, ProductSkus> implements ProductSkusService {
    @Autowired
    private ProductSkusMapper productSkusMapper;

    @Override
    public IPage<ProductSkusVo> selectProductSkusListSearch(Integer pageNum, Integer pageSize, IPage<ProductSkusVo> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return productSkusMapper.selectProductSkusListSearch(pageNum, pageSize, page, keyword);
    }

    @Override
    public List<ProductSkusVo> selectProductSkusList() {
        return productSkusMapper.selectProductSkusList();
    }

    @Override
    public int insert(ProductSkus productSkus) {
        int id = productSkusMapper.insert(productSkus);
        return id;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productSkusMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(ProductSkus productSkus) {
        return productSkusMapper.updateByPrimaryKey(productSkus);
    }
}
