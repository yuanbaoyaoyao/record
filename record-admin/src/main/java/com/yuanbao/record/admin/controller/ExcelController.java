package com.yuanbao.record.admin.controller;

import com.yuanbao.record.admin.service.ProductSkusService;
import com.yuanbao.record.common.api.util.ExportExcelUtils;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
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

    @GetMapping(value = "/productSkus")
    public void ExportBankCkeckInfo(HttpServletResponse response) {
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

}
