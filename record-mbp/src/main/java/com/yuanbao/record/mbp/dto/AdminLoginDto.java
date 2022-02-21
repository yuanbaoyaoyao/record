package com.yuanbao.record.mbp.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AdminLoginDto {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
