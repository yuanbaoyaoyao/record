package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.ProductSkusMapper;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import com.yuanbao.record.mbp.vomapper.ProductSkusVoMapper;
import com.yuanbao.record.web.service.ProductSkusClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSkusClientServiceImpl extends ServiceImpl<ProductSkusMapper, ProductSkus> implements ProductSkusClientService {

    @Autowired
    private ProductSkusMapper productSkusMapper;

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
    public IPage<ProductSkusVo> selectProductSkusListByProductTypeIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, Integer type) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<ProductSkusVo> voPage = new Page<>();
        List<ProductSkusVo> productSkusVoList = new ArrayList<>();
        IPage<ProductSkus> productSkusIPage = productSkusMapper.selectProductSkusListByProductTypeIPage(pageNum, pageSize, page, type);

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
    public List<ProductSkusVo> selectProductSkusListSearch(String title, Long id, Long productId, String productSkusName) {
        return productSkusMapper.selectProductSkusListSearch(title, id, productId, productSkusName);
    }

    @Override
    public IPage<ProductSkusVo> selectProductSkusListCountByProductIdAndTypeIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, Long productId, Integer type, Long userId) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<ProductSkusVo> voPage = new Page<>();
        List<ProductSkusVo> productSkusVoList = new ArrayList<>();
        IPage<ProductSkus> productSkusIPage = productSkusMapper.selectProductSkusListCountByProductIdAndTypeIPage(pageNum, pageSize, page, productId, type, userId);
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
    public List<ProductSkusVo> selectProductSkusListLimit() {
        return productSkusMapper.selectProductSkusListLimit();
    }

    @Override
    public List<ProductSkusVo> selectProductSkusListLimitNumber(Integer number) {
        List<ProductSkus> productSkusList = productSkusMapper.selectProductSkusListLimitNumber(number);
        List<ProductSkusVo> productSkusVoList = new ArrayList<>();
        for (ProductSkus productSkus : productSkusList) {
            ProductSkusVo productSkusVo = ProductSkusVoMapper.productskusvomapper.Trans(productSkus);
            productSkusVoList.add(productSkusVo);
        }
        return productSkusVoList;
    }

    @Override
    public int updateByPrimaryKey(ProductSkus productSkus) {
        return productSkusMapper.updateByPrimaryKey(productSkus);
    }
}
