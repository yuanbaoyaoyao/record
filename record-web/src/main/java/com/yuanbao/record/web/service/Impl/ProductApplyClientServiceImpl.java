//package com.yuanbao.record.web.service.Impl;
//
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.yuanbao.record.mbp.mapper.ProductApplyMapper;
//import com.yuanbao.record.mbp.mapper.entity.ProductApply;
//import com.yuanbao.record.mbp.vo.ProductApplyClientVo;
//import com.yuanbao.record.mbp.vomapper.ProductApplyClientVoMapper;
//import com.yuanbao.record.web.service.ProductApplyClientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ProductApplyClientServiceImpl extends ServiceImpl<ProductApplyMapper, ProductApply> implements ProductApplyClientService {
//
//    @Autowired
//    private ProductApplyMapper productApplyMapper;
//
//    @Override
//    public IPage<ProductApplyClientVo> selectApplyListSearch(Integer pageNum, Integer pageSize, IPage<ProductApply> page, Integer userId, String productTitle, String productSkusTitle) {
//        page.setCurrent(pageNum);
//        page.setSize(pageSize);
//        IPage<ProductApplyClientVo> voPage = new Page<>();
//        List<ProductApplyClientVo> productApplyClientVoList = new ArrayList<>();
//        IPage<ProductApply> productApplyIPage = productApplyMapper.selectApplyListSearch(pageNum, pageSize, page, userId,productTitle,productSkusTitle);
//        List<ProductApply> productApplyList = productApplyIPage.getRecords();
//        for (ProductApply productApply : productApplyList) {
//            ProductApplyClientVo productApplyClientVo = ProductApplyClientVoMapper.productapplyclientvomapper.Trans(productApply);
//            productApplyClientVoList.add(productApplyClientVo);
//        }
//        voPage.setRecords(productApplyClientVoList);
//        voPage.setCurrent(pageNum);
//        voPage.setSize(pageSize);
//        voPage.setTotal(productApplyIPage.getTotal());
//        return voPage;
//    }
//
//    @Override
//    public int insert(ProductApply productApply) {
//        int id = productApplyMapper.insert(productApply);
//        return id;
//    }
//
//    @Override
//    public int deleteByPrimaryKey(Long id) {
//        return productApplyMapper.deleteById(id);
//    }
//}
