package com.yuanbao.record.shiro.controller;

import cn.hutool.crypto.SecureUtil;
import com.yuanbao.record.admin.service.AdminPermissionService;
import com.yuanbao.record.admin.service.AdminRoleService;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.common.api.util.JacksonUtil;
import com.yuanbao.record.common.api.util.JwtUtil;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.mbp.mapper.entity.JwtUser;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.shiro.util.Permission;
import com.yuanbao.record.shiro.util.PermissionUtil;
import com.yuanbao.record.web.service.UserClientService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class ShiroController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private UserClientService userClientService;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private AdminPermissionService adminPermissionService;

    @PostMapping(value = "/client/login")
    public CommonResult clientLogin(@RequestBody String body) {
        System.out.println("loginuser");
        String usernameInput = JacksonUtil.parseString(body, "username");
        String passwordInput = JacksonUtil.parseString(body, "password");
        System.out.println("username:" + usernameInput);
        System.out.println("password:" + passwordInput);
        if (StringUtils.isEmpty(usernameInput) || StringUtils.isEmpty(passwordInput)) {
            return CommonResult.validateFailed();
        }
        User user = userClientService.selectUserListByName(usernameInput);
        if (user == null) {
            return CommonResult.failed("用户不存在");
        }
//        通过用户输入密码和数据库中密码比对是否一致，一致就登录成功（密码注册的时候注意加密）
//        注册加密后修改
        String password = user.getPassword();
        String salt = user.getSalt();
        String passwordEncryption = SecureUtil.md5(passwordInput + salt);
        if (!Objects.equals(password, passwordEncryption)) {
            return CommonResult.failed("密码错误");
        }
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("nickName", user.getName());
        userInfo.put("avatar", user.getAvatar());
        userInfo.put(("userId"), user.getId());

        Map<Object, Object> result = new HashMap<>();
        JwtUser jwtUser = new JwtUser(usernameInput, null);
        String token = JwtUtil.createJwtTokenByUser(jwtUser);
        System.out.println("token:" + token);
        result.put("token", token);
        result.put("userInfo", userInfo);
        return CommonResult.success(result);
    }

    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody String body) {
        System.out.println("loginAdminUser");
        String usernameInput = JacksonUtil.parseString(body, "username");
        String passwordInput = JacksonUtil.parseString(body, "password");
        System.out.println("username:" + usernameInput);
        System.out.println("password:" + passwordInput);
        if (StringUtils.isEmpty(usernameInput) || StringUtils.isEmpty(passwordInput)) {
            return CommonResult.validateFailed();
        }
        AdminUser adminUser = adminUserService.selectAdminListByName(usernameInput);
        if (adminUser == null) {
            return CommonResult.failed("用户不存在");
        }
//        通过用户输入密码和数据库中密码比对是否一致，一致就登录成功（密码注册的时候注意加密）
//        注册加密后修改
        String password = adminUser.getPassword();
        String salt = adminUser.getSalt();
        String passwordEncryption = SecureUtil.md5(passwordInput + salt);
        if (!Objects.equals(password, passwordEncryption)) {
            return CommonResult.failed("密码错误");
        }
        Map<String, Object> adminInfo = new HashMap<>();
        adminInfo.put("nickName", adminUser.getName());
        adminInfo.put("avatar", adminUser.getAvatar());
        adminInfo.put("adminUserId", adminUser.getId());
        adminInfo.put("adminRoleId", adminUser.getRoleId());
        adminInfo.put("lastLoginIp", adminUser.getLastLoginIp());
        adminInfo.put("lastLoginTime", adminUser.getLastLoginTime());
        String role = adminRoleService.selectNameById(adminUser.getRoleId());
        List<String> permissions = adminPermissionService.selectPermissionByRoleId(adminUser.getRoleId());
        adminInfo.put("role", role);
        adminInfo.put("perms", toApi(permissions));

        Map<Object, Object> result = new HashMap<>();
        JwtUser jwtUser = new JwtUser(usernameInput, adminUser.getRoleId());
        String token = JwtUtil.createJwtTokenByUser(jwtUser);
        System.out.println("token:" + token);
        result.put("token", token);
        result.put("adminInfo", adminInfo);
        System.out.println("adminInfo" + adminInfo);
        return CommonResult.success(result);
    }

    @PostMapping("/logout")
    public CommonResult logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return CommonResult.success("退出");
    }

    @PostMapping("/client/logout")
    public CommonResult clientLogout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return CommonResult.success("退出");
    }


    @RequiresAuthentication
    @GetMapping("/info")
    public CommonResult info() {
        System.out.println("使用了admin info");
        JwtUser jwtUser = (JwtUser) SecurityUtils.getSubject().getPrincipal();
        System.out.println("adminUser:" + jwtUser);
        Map<String, Object> data = new HashMap<>();
        AdminUser adminUser = adminUserService.selectAdminListByName(jwtUser.getUsername());
        Long roleId = adminUser.getRoleId();
        System.out.println("roleId:" + roleId);
        String role = adminRoleService.selectNameById(roleId);
        List<String> permissions = adminPermissionService.selectPermissionByRoleId(roleId);
        System.out.println("permissions:" + permissions);
        data.put("name", adminUser.getName());
        data.put("avatar", adminUser.getAvatar());
        data.put("adminUserId", adminUser.getId());
        data.put("lastLoginIp", adminUser.getLastLoginIp());
        data.put("lastLoginTime", adminUser.getLastLoginTime());
        data.put("role", role);
        data.put("perms", toApi(permissions));
        System.out.println("toApi(permissions):" + toApi(permissions));
        return CommonResult.success(data);
    }

    @RequiresAuthentication
    @GetMapping("/client/info")
    public CommonResult clientInfo() {
        System.out.println("使用了user info");
        JwtUser jwtUser = (JwtUser) SecurityUtils.getSubject().getPrincipal();
        System.out.println("user:" + jwtUser);
        Map<String, Object> data = new HashMap<>();
        User user = userClientService.selectUserListByName(jwtUser.getUsername());
        Long id = user.getId();
        System.out.println("id:" + id);
        data.put("name", user.getName());
        data.put("avatar", user.getAvatar());
        data.put("id", user.getId());
        return CommonResult.success(data);
    }

    @Autowired
    private ApplicationContext context;
    private HashMap<String, String> systemPermissionsMap = null;

    private Collection<String> toApi(List<String> permissions) {
        if (systemPermissionsMap == null) {
            systemPermissionsMap = new HashMap<>();
            final String basicPackage = "com.yuanbao.record.admin.controller";
            List<Permission> systemPermissions = PermissionUtil.listPermission(context, basicPackage);
            System.out.println("systemPermissions:" + systemPermissions);
            for (Permission permission : systemPermissions) {
                String perm = permission.getRequiresPermissions().value()[0];
                String api = permission.getApi();
                systemPermissionsMap.put(perm, api);
            }
        }
        Collection<String> apis = new HashSet<>();
        for (String perm : permissions) {
            String api = systemPermissionsMap.get(perm);
            apis.add(api);

            if (perm.equals("*")) {
                apis.clear();
                apis.add("*");
                return apis;
            }
        }
        return apis;
    }
}
