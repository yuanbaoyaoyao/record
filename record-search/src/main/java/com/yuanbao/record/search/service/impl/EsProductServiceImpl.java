package com.yuanbao.record.search.service.impl;

import com.yuanbao.record.search.mapper.EsProductSkusMapper;
import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import com.yuanbao.record.search.repository.EsProductSkusRepository;
import com.yuanbao.record.search.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsProductServiceImpl implements EsProductService {

    @Autowired
    private EsProductSkusMapper esProductSkusMapper;
    @Autowired
    private EsProductSkusRepository esProductSkusRepository;

    @Override
    public Boolean importAllInfo() {
        List<EsProductSkus> esProductSkusList = esProductSkusMapper.selectEsProductSkusList();
        esProductSkusRepository.saveAll(esProductSkusList);
        return true;
    }

    @Override
    public Page<EsProductSkus> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, String title, String productName) {
        Pageable page = PageRequest.of(pageNum - 1, pageSize);
        System.out.println("findByTitleOrProductName:" + esProductSkusRepository.findByTitleOrProductNameContaining(page, title, productName));
        return esProductSkusRepository.findByTitleOrProductNameContaining(page, title, productName);
    }

    @Override
    public Page<EsProductSkus> selectProductSkusListOrderByStockSearchIPage(Integer pageNum, Integer pageSize, String title, String productName) {
        Pageable page = PageRequest.of(pageNum - 1, pageSize);
        System.out.println("findByTitleOrProductName:" + esProductSkusRepository.findByTitleOrProductNameContainingOrderByStockDesc(page, title, productName));
        return esProductSkusRepository.findByTitleOrProductNameContainingOrderByStockDesc(page, title, productName);
    }
}
