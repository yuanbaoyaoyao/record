package com.yuanbao.record.search.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.search.mapper.EsProductSkusMapper;
import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import com.yuanbao.record.search.repository.EsProductSkusRepository;
import com.yuanbao.record.search.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public IPage<EsProductSkus> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, IPage<EsProductSkus> page, String title, String productName) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return esProductSkusRepository.findByTitleOrProductName(pageNum, pageSize, page, title,productName);
    }
}
