package com.yuanbao.record.shiro.util;

import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private RequiresPermissions requiresPermissions;
    private RequiresPermissionsDesc requiresPermissionsDesc;
    private String api;
}