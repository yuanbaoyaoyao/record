package com.yuanbao.record.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Setter
@Getter
public class AdminRole implements Serializable {
    static final Long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer state;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
