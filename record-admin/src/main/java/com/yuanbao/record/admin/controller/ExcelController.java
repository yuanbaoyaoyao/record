package com.yuanbao.record.admin.controller;

import com.yuanbao.record.admin.service.ProductSkusService;
import com.yuanbao.record.admin.service.UserOrderService;
import com.yuanbao.record.common.api.util.ExportExcelUtils;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/excel")
public class ExcelController {
    @Autowired
    private ProductSkusService productSkusService;

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping(value = "/productSkus")
    public void ExportProductSkusListInfo(HttpServletResponse response) {
        List<ProductSkusVo> productSkusVoList = productSkusService.selectProductSkusList();
        System.out.println(productSkusVoList);
        String excelName = "耗材列表";

        String[] headers = {"编号", "类别", "型号", "描述", "库存", "创建时间"};

        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("id", "编号");
        fieldMap.put("productName", "类别");
        fieldMap.put("title", "型号");
        fieldMap.put("description", "描述");
        fieldMap.put("stock", "库存");
        fieldMap.put("createdAt", "创建时间");


        new ExportExcelUtils().export(excelName, productSkusVoList, fieldMap, headers, response);
    }

    @GetMapping(value = "/userStatistics")
    public void ExportUserStatisticsListInfo(HttpServletResponse response) {
        List<UserOrderVo> userOrderVoList = userOrderService.selectOrderListDateSearchAllList(null,null,null,"","");
        System.out.println(userOrderVoList);
        String excelName = "用户统计表";

        String[] headers = {"领用人", "订单总数", "申请耗材总数", "最多申请耗材型号", "时间范围"};

        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("receiver", "领用人");
        fieldMap.put("countOrderNumber", "订单总数");
        fieldMap.put("sumProductNumber", "申请耗材总数");
        fieldMap.put("maxNumSkuName", "最多申请耗材型号");
        fieldMap.put("timeFrame", "时间范围");


        new ExportExcelUtils().export(excelName, userOrderVoList, fieldMap, headers, response);
    }


}
