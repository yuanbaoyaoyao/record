package com.yuanbao.record.search.mapper.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Document(indexName = "productskus")
public class EsProductSkus implements Serializable {
    static final Long serialVersionUID = 1L;
    @Id
    @Field(type = FieldType.Long)
    private Long id;
    @Field(type = FieldType.Long)
    private Long productId;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String productName;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String avatar;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Integer)
    private Integer stock;
//    @Field(type = FieldType.Date)
//    private LocalDateTime createdAt;
//    @Field(type = FieldType.Long)
//    private LocalDateTime Date;
//    @Field(type = FieldType.Boolean)
//    private Boolean deleted;
}
