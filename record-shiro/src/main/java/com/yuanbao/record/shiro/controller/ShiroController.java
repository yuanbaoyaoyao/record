package com.yuanbao.record.shiro.controller;

import cn.hutool.crypto.SecureUtil;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.common.aop.LogInfoAspect;
import com.yuanbao.record.common.util.JacksonUtil;
import com.yuanbao.record.common.util.JwtUtil;
import com.yuanbao.record.mbp.mapper.entity.AdminPermission;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.mbp.mapper.entity.JwtUser;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.PermVo;
import com.yuanbao.record.shiro.service.ShiroAdminPermissionService;
import com.yuanbao.record.shiro.service.ShiroAdminRoleService;
import com.yuanbao.record.shiro.service.ShiroAdminUserService;
import com.yuanbao.record.shiro.service.ShiroUserClientService;
import com.yuanbao.record.shiro.util.Permission;
import com.yuanbao.record.shiro.util.PermissionUtil;
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
    private ShiroAdminUserService shiroAdminUserService;


    @Autowired
    private ShiroUserClientService shiroUserClientService;


    @Autowired
    private ShiroAdminRoleService shiroAdminRoleService;


    @Autowired
    private ShiroAdminPermissionService shiroAdminPermissionService;

    @OperationLog(menu = {"客户端登录操作"}, action = "客户端登录")
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
        User user;
        if (usernameInput.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
            user = shiroUserClientService.selectUserByEmail(usernameInput);
        } else {
            user = shiroUserClientService.selectUserListByName(usernameInput);
        }
        if (user == null) {
            return CommonResult.failed("用户不存在");
        }
//        通过用户输入密码和数据库中密码比对是否一致，一致就登录成功（密码注册的时候注意加密）
//        注册加密后修改
        String password = user.getPassword();
        String salt = user.getSalt();
        String passwordEncryption = SecureUtil.md5(passwordInput + salt);
        System.out.println("passwordEncryption:" + passwordEncryption);
        System.out.println("password:" + password);
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
        LogInfoAspect.getTempToken(token);
        return CommonResult.success(result);
    }

    @OperationLog(menu = {"管理员登录操作"}, action = "管理员登录")
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
        AdminUser adminUser = shiroAdminUserService.selectAdminListByName(usernameInput);
        if (adminUser == null) {
            return CommonResult.failed("用户不存在");
        }
//        通过用户输入密码和数据库中密码比对是否一致，一致就登录成功（密码注册的时候注意加密）
//        注册加密后修改
        String password = adminUser.getPassword();
        String salt = adminUser.getSalt();
        String passwordEncryption = SecureUtil.md5(passwordInput + salt);
        System.out.println("passwordEncryption:" + passwordEncryption);
        System.out.println("password:" + password);
        if (!Objects.equals(password, passwordEncryption)) {
            System.out.println("正在对比");
            return CommonResult.failed("密码错误");
        }
        System.out.println("_________________");
        Map<String, Object> adminInfo = new HashMap<>();
        adminInfo.put("nickName", adminUser.getName());
        adminInfo.put("avatar", adminUser.getAvatar());
        adminInfo.put("adminUserId", adminUser.getId());
        adminInfo.put("adminRoleId", adminUser.getRoleId());
        adminInfo.put("lastLoginIp", adminUser.getLastLoginIp());
        adminInfo.put("lastLoginTime", adminUser.getLastLoginTime());
        String role = shiroAdminRoleService.selectNameById(adminUser.getRoleId());
        List<String> permissions = shiroAdminPermissionService.selectPermissionByRoleId(adminUser.getRoleId());
        adminInfo.put("role", role);
        adminInfo.put("perms", toApi(permissions));

        Map<Object, Object> result = new HashMap<>();
        JwtUser jwtUser = new JwtUser(usernameInput, adminUser.getRoleId());
        String token = JwtUtil.createJwtTokenByUser(jwtUser);
        System.out.println("loginAdminUser");
        System.out.println("token:" + token);
        result.put("token", token);
        result.put("adminInfo", adminInfo);
        System.out.println("adminInfo" + adminInfo);
        System.out.println("22222222222");
        LogInfoAspect.getTempToken(token);
        return CommonResult.success(result);
    }

    @OperationLog(menu = {"管理員端登出操作"}, action = "管理员登出")
    @PostMapping("/logout")
    public CommonResult logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return CommonResult.success("退出");
    }

    @OperationLog(menu = {"客户端登录登出"}, action = "客户端登出")
    @PostMapping("/client/logout")
    public CommonResult clientLogout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return CommonResult.success("退出");
    }


    @RequiresAuthentication
    @GetMapping("/info")
    public CommonResult info() {
        JwtUser jwtUser = (JwtUser) SecurityUtils.getSubject().getPrincipal();
        Map<String, Object> data = new HashMap<>();
        AdminUser adminUser = shiroAdminUserService.selectAdminListByName(jwtUser.getUsername());
        Long roleId = adminUser.getRoleId();
        String role = shiroAdminRoleService.selectNameById(roleId);
        List<String> permissions = shiroAdminPermissionService.selectPermissionByRoleId(roleId);
        data.put("name", adminUser.getName());
        data.put("avatar", adminUser.getAvatar());
        data.put("adminUserId", adminUser.getId());
        data.put("lastLoginIp", adminUser.getLastLoginIp());
        data.put("lastLoginTime", adminUser.getLastLoginTime());
        data.put("role", role);
        data.put("perms", toApi(permissions));
        return CommonResult.success(data);
    }

    @RequiresAuthentication
    @GetMapping("/client/info")
    public CommonResult clientInfo() {
        JwtUser jwtUser = (JwtUser) SecurityUtils.getSubject().getPrincipal();
        Map<String, Object> data = new HashMap<>();
        User user = shiroUserClientService.selectUserListByName(jwtUser.getUsername());
        data.put("name", user.getName());
        data.put("avatar", user.getAvatar());
        data.put("id", user.getId());
        return CommonResult.success(data);
    }

    @GetMapping(value = "/getPermissions")
    public CommonResult getPermissions(@RequestParam(value = "roleId") Long roleId) {
        List<PermVo> permVoList = getPermVoList();
        List<String> assignedPermissions = getAssignedPermissions(roleId);
        Map<String, Object> data = new HashMap<>();
        data.put("allPermissions", permVoList);
        data.put("assignedPermissions", assignedPermissions);
        return CommonResult.success(data);
    }

    @PostMapping("/updatePermissions")
    public CommonResult updatePermissions(@RequestBody String body) {
        System.out.println("调用了updatePermissions");
        System.out.println("body:" + body);

        Long roleId = Long.valueOf(Objects.requireNonNull(JacksonUtil.parseString(body, "roleId")));
        List<String> permissions = JacksonUtil.parseStringList(body, "permissions");
        if (permissions == null) {
            return CommonResult.failed();
        }

        if (shiroAdminPermissionService.checkSuperPermission(roleId)) {
            return CommonResult.failed("当前角色的超级权限不能变更");
        }

        shiroAdminPermissionService.deleteByRoleId(roleId);
        for (String permission : permissions) {
            AdminPermission adminPermission = new AdminPermission();
            adminPermission.setRoleId(roleId);
            adminPermission.setPermission(permission);
            shiroAdminPermissionService.insert(adminPermission);
        }
        return CommonResult.success("success");
    }

    @Autowired
    private ApplicationContext context;
    private HashMap<String, String> systemPermissionsMap = null;
    private List<PermVo> permVoList = null;
    private Set<String> permissionsString = null;

    private List<PermVo> getPermVoList() {
        final String basicPackage = "com.yuanbao.record.admin";
        if (permVoList == null) {
            List<Permission> permissions = PermissionUtil.listPermission(context, basicPackage);
            permVoList = PermissionUtil.permVoList(permissions);
            permissionsString = PermissionUtil.listPermissionString(permissions);
        }
        return permVoList;
    }

    private List<String> getAssignedPermissions(Long roleId) {
        return shiroAdminPermissionService.selectPermissionByRoleId(roleId);
    }

    private Collection<String> toApi(List<String> permissions) {
        if (systemPermissionsMap == null) {
            systemPermissionsMap = new HashMap<>();
            final String basicPackage = "com.yuanbao.record.admin";
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
