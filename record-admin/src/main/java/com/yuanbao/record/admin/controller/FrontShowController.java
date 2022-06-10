package com.yuanbao.record.admin.controller;

import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.FrontShowService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.FrontShowMapper;
import com.yuanbao.record.mbp.mapper.ProductSkusMapper;
import com.yuanbao.record.mbp.mapper.entity.FrontShow;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.FrontShowVo;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/frontShow")
public class FrontShowController {
    @Autowired
    private FrontShowService frontShowService;
    @Autowired
    private ProductSkusMapper productSkusMapper;
    @Autowired
    private FrontShowMapper frontShowMapper;

    @RequiresPermissionsDesc(menu = {"页面管理", "前端展示"}, button = "查询")
    @OperationLog(menu = {"页面管理", "前端展示"}, action = "查询")
    @RequiresPermissions("frontShow:list")
    @GetMapping(value = "/listRotation")
    public CommonResult<List<FrontShowVo>> getRotation() {
        List<FrontShowVo> frontShowVoList = frontShowService.selectByShowRotation();
        return CommonResult.success(frontShowVoList);
    }

    @RequiresPermissionsDesc(menu = {"页面管理", "前端展示"}, button = "查询")
    @OperationLog(menu = {"页面管理", "前端展示"}, action = "查询")
    @RequiresPermissions("frontShow:list")
    @GetMapping(value = "/listOld")
    public CommonResult<List<FrontShowVo>> getOld() {
        List<FrontShowVo> frontShowVoList = frontShowService.selectByShowOld();
        return CommonResult.success(frontShowVoList);
    }

    @RequiresPermissionsDesc(menu = {"页面管理", "前端展示"}, button = "查询")
    @OperationLog(menu = {"页面管理", "前端展示"}, action = "查询")
    @RequiresPermissions("frontShow:list")
    @GetMapping(value = "/listNew")
    public CommonResult<List<FrontShowVo>> getNew() {
        List<FrontShowVo> frontShowVoList = frontShowService.selectByShowNew();
        return CommonResult.success(frontShowVoList);
    }

    @RequiresPermissionsDesc(menu = {"页面管理", "前端展示"}, button = "创建")
    @OperationLog(menu = {"页面管理", "前端展示"}, action = "创建")
    @RequiresPermissions("frontShow:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody FrontShow frontShow) {
        int newId = frontShowService.insert(frontShow);
        List<ProductSkusVo> productSkusVoList = productSkusMapper.selectProductSkusListSearch("", frontShow.getProductSkusId(), null, null);
        if (newId > 0) {
            return CommonResult.success(productSkusVoList);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"页面管理", "前端展示"}, button = "创建")
    @OperationLog(menu = {"页面管理", "前端展示"}, action = "创建")
    @RequiresPermissions("frontShow:create")
    @GetMapping(value = "/createLimitNumber")
    public CommonResult createLimitNumber(@RequestParam(value = "number") Integer number) {
        System.out.println("number:" + number);
        List<ProductSkus> productSkusList = productSkusMapper.selectProductSkusListLimitNumber(number);
        System.out.println("productSkusVoList" + productSkusList);
        for (ProductSkus productSkus : productSkusList) {
            FrontShow frontShow = new FrontShow();
            frontShow.setProductSkusId(productSkus.getProductId());
            frontShow.setProductSkusName(productSkus.getTitle());
            frontShow.setProductName(productSkus.getProductName());
            frontShow.setShowNew(true);
            frontShowService.insert(frontShow);
        }
        return CommonResult.success(productSkusList);
    }

    @RequiresPermissionsDesc(menu = {"页面管理", "前端展示"}, button = "删除")
    @OperationLog(menu = {"页面管理", "前端展示"}, action = "删除")
    @RequiresPermissions("frontShow:delete")
    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody FrontShow frontShow) {
        long tempId = frontShow.getId();
        int count = frontShowService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

//    @RequiresPermissionsDesc(menu = {"页面管理", "前端展示"}, button = "修改")
//    @OperationLog(menu = {"页面管理", "前端展示"}, action = "修改")
//    @RequiresPermissions("frontShow:update")
//    @PutMapping(value = "/update")
//    public CommonResult update(@RequestBody FrontShow frontShow) {
//        int count = frontShowService.updateByPrimaryKey(frontShow);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
}
