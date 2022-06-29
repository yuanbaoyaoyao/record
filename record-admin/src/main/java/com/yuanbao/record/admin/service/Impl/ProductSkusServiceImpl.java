package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.ProductSkusService;
import com.yuanbao.record.mbp.mapper.ProductMapper;
import com.yuanbao.record.mbp.mapper.ProductSkusMapper;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import com.yuanbao.record.mbp.vomapper.ProductSkusVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductSkusServiceImpl extends ServiceImpl<ProductSkusMapper, ProductSkus> implements ProductSkusService {
    @Autowired
    private ProductSkusMapper productSkusMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<ProductSkusVo> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, String productName, Long id, String productSkusName) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<ProductSkusVo> voPage = new Page<>();
        List<ProductSkusVo> productSkusVoList = new ArrayList<>();
        IPage<ProductSkus> productSkusIPage = productSkusMapper.selectProductSkusListSearchIPage(pageNum, pageSize, page, productName, id, productSkusName);
        List<ProductSkus> productSkusList = productSkusIPage.getRecords();
        for (ProductSkus productSkus : productSkusList) {
            ProductSkusVo productSkusVo = ProductSkusVoMapper.productskusvomapper.Trans(productSkus);
            productSkusVoList.add(productSkusVo);
        }
        voPage.setRecords(productSkusVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(productSkusIPage.getTotal());
        return voPage;
    }

    @Override
    public List<ProductSkusVo> selectProductSkusList() {
        return productSkusMapper.selectProductSkusList();
    }

    @Override
    public Map<String, Object> selectProductSkusChildrenLikeList() {
        Map<String, Object> data = new HashMap<>();
        List<Product> productList = productMapper.selectProductListSearchAll("", null);
        for (Product product : productList) {
            List<ProductSkusVo> productSkusVoList = productSkusMapper.selectProductSkusListSearch("", null, product.getId(), null);
            if (productSkusVoList.size() != 0) {
                data.put(product.getTitle(), productSkusVoList);
            }
        }
        return data;
    }

    @Override
    public int insert(ProductSkus productSkus) {
        return productSkusMapper.insert(productSkus);
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
