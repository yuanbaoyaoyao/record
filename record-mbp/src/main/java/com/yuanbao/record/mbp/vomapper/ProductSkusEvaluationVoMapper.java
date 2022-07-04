package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.ProductSkusEvaluation;
import com.yuanbao.record.mbp.vo.ProductSkusEvaluationVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductSkusEvaluationVoMapper {
    ProductSkusEvaluationVoMapper productskusevaluationvomapper = Mappers.getMapper(ProductSkusEvaluationVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "productSkusEvaluation.id"),
            @Mapping(target = "orderProductId", source = "productSkusEvaluation.orderProductId"),
            @Mapping(target = "productSkusEvaluation", source = "productSkusEvaluation.productSkusEvaluation"),
            @Mapping(target = "additionalEvaluation", source = "productSkusEvaluation.additionalEvaluation"),
            @Mapping(target = "orderSn", source = "productSkusEvaluation.orderSn"),
            @Mapping(target = "productSkusId", source = "productSkusEvaluation.productSkusId"),
            @Mapping(target = "productTitle", source = "productSkusEvaluation.productTitle"),
            @Mapping(target = "productSkusTitle", source = "productSkusEvaluation.productSkusTitle"),
            @Mapping(target = "number", source = "productSkusEvaluation.number"),
            @Mapping(target = "receiver", source = "productSkusEvaluation.receiver"),
            @Mapping(target = "avatar", source = "productSkusEvaluation.avatar"),
            @Mapping(target = "createdAt", source = "productSkusEvaluation.createdAt"),
    })
    ProductSkusEvaluationVo Trans(ProductSkusEvaluation productSkusEvaluation);
}
