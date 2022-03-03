package com.yuanbao.record.shiro.util;

import com.yuanbao.record.shiro.annotation.RequiresPermissionsDesc;
import lombok.Data;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@Data
public class Permission {
    private RequiresPermissions requiresPermissions;
    private RequiresPermissionsDesc requiresPermissionsDesc;
    private String api;
}
