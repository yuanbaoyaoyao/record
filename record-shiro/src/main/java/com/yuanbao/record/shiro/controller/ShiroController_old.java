//package com.yuanbao.record.shiro.controller;
//
//import com.yuanbao.record.admin.service.AdminPermissionService;
//import com.yuanbao.record.admin.service.AdminRoleService;
//import com.yuanbao.record.admin.service.AdminUserService;
//import com.yuanbao.record.common.api.CommonResult;
//import com.yuanbao.record.common.api.util.IpUtil;
//import com.yuanbao.record.common.api.util.JacksonUtil;
//import com.yuanbao.record.common.api.util.JwtUtil;
//import com.yuanbao.record.mbp.mapper.entity.AdminUser;
//import com.yuanbao.record.mbp.mapper.entity.User;
//import com.yuanbao.record.shiro.auth.JwtToken;
//import com.yuanbao.record.shiro.service.ShiroService;
//import com.yuanbao.record.shiro.util.Permission;
//import com.yuanbao.record.shiro.util.PermissionUtil;
//import com.yuanbao.record.web.service.UserClientService;
//import org.apache.commons.lang.StringUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.LockedAccountException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.annotation.RequiresAuthentication;
//import org.apache.shiro.crypto.hash.Md5Hash;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.time.LocalDateTime;
//import java.util.*;
//
//
//@RestController
//@CrossOrigin
//@RequestMapping("/auth")
//public class ShiroController_old {
//
//    @Autowired
//    private AdminUserService adminUserService;
//
//    @Autowired
//    private UserClientService userClientService;
//
//    @Autowired
//    private AdminRoleService adminRoleService;
//
//    @Autowired
//    private AdminPermissionService adminPermissionService;
//
//    @Autowired
//    private ShiroService shiroService;
//
//    @PostMapping(value = "/login")
//    public CommonResult login(@RequestBody String body, HttpServletRequest request) {
//        String username = JacksonUtil.parseString(body, "username");
//        String password = JacksonUtil.parseString(body, "password");
//
//        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//            return CommonResult.validateFailed();
//        }
//
//        Subject currentUser = SecurityUtils.getSubject();
//        try {
//            currentUser.login(new UsernamePasswordToken(username, password));
//        } catch (UnknownAccountException uae) {
//            return CommonResult.failed("用户账号或密码不正确");
//        } catch (LockedAccountException lae) {
//            return CommonResult.failed("用户已锁定");
//        } catch (AuthenticationException ae) {
//            return CommonResult.failed("认证失败");
//        }
//
//        currentUser = SecurityUtils.getSubject();
//        AdminUser adminUser = (AdminUser) currentUser.getPrincipal();
//
//        adminUser.setLastLoginIp(adminUser.getNowLoginIp());
//        adminUser.setLastLoginTime(adminUser.getNowLoginTime());
//        adminUser.setNowLoginIp(IpUtil.getIpAddr(request));
//        adminUser.setNowLoginTime(LocalDateTime.now());
//        adminUserService.updateByPrimaryKey(adminUser);
//
//        //userInfo
//        Map<String, Object> adminInfo = new HashMap<String, Object>();
//        adminInfo.put("nickName", adminUser.getName());
//        adminInfo.put("avatar", adminUser.getAvatar());
//        adminInfo.put("adminUserId", adminUser.getId());
//        adminInfo.put("adminRoleId", adminUser.getRoleId());
//        adminInfo.put("lastLoginIp", adminUser.getLastLoginIp());
//        adminInfo.put("lastLoginTime", adminUser.getLastLoginTime());
//
//        System.out.println("adminInfooooo:" + adminInfo);
//        Map<Object, Object> result = new HashMap<Object, Object>();
////        result.put("token", currentUser.getSession().getId());
////        result.put("token", token);
//        result.put("adminInfo", adminInfo);
//        return CommonResult.success(result);
//    }
//
//
//    @PostMapping(value = "/client/login")
//    public CommonResult clientLogin(@RequestBody String body, HttpServletRequest request) {
//        String username = JacksonUtil.parseString(body, "username");
//        String password = JacksonUtil.parseString(body, "password");
//        System.out.println("输入的用户名为：" + username);
//        System.out.println("输入的用户密码为：" + password);
//
//        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//            return CommonResult.validateFailed();
//        }
//        User user = userClientService.selectUserListByName(username);
//        System.out.println("user:" + user);
//
//        if (user == null) {
//            return CommonResult.failed("用户不存在");
//        }
//        Md5Hash md5Hash = new Md5Hash(password);
//
//        String token = JwtUtil.createToken(username, md5Hash.toHex());
//        JwtToken jwtToken = new JwtToken(token);
//
//        Subject currentUser = SecurityUtils.getSubject();
//        try {
//            currentUser.login(jwtToken);
//            System.out.println("认证成功");
//        } catch (UnknownAccountException uae) {
//            return CommonResult.failed("用户账号或密码不正确");
//        } catch (LockedAccountException lae) {
//            return CommonResult.failed("用户已锁定");
//        } catch (AuthenticationException ae) {
//            return CommonResult.failed("认证失败");
//        }
//
//        //userInfo
//        Map<String, Object> userInfo = new HashMap<>();
//        userInfo.put("nickName", user.getName());
//        userInfo.put("avatar", user.getAvatar());
//        userInfo.put(("userId"), user.getId());
//
//
//        Map<Object, Object> result = new HashMap<>();
//        result.put("token", token);
//        result.put("userInfo", userInfo);
//        return CommonResult.success(result);
//    }
//
//    @PostMapping("/client/sendEmailCode")
//    public CommonResult sendEmailCode(@RequestParam String email) {
//        System.out.println("email:" + email);
//        shiroService.sendMailCode(email);
//        return CommonResult.success("已发送");
//    }
//
//    @RequiresAuthentication
//    @PostMapping("/logout")
//    public CommonResult logout() {
//        Subject currentUser = SecurityUtils.getSubject();
//
//        currentUser.logout();
//        return CommonResult.success("退出");
//    }
//
//    @RequiresAuthentication
//    @PostMapping("/client/logout")
//    public CommonResult clientLogout() {
//        System.out.println("已退出");
//        Subject currentUser = SecurityUtils.getSubject();
//
////        logHelper.logAuthSucceed("退出");
//        currentUser.logout();
//        return CommonResult.success("退出");
//    }
//
//    @RequiresAuthentication
//    @GetMapping("/info")
//    public CommonResult info() {
//        Subject currentUser = SecurityUtils.getSubject();
//        AdminUser adminUser = (AdminUser) currentUser.getPrincipal();
//        Map<String, Object> data = new HashMap<>();
//        Long roleId = adminUser.getRoleId();
//        System.out.println("roleId:" + roleId);
//        String role = adminRoleService.selectNameById(roleId);
//        List<String> permissions = adminPermissionService.selectPermissionByRoleId(roleId);
//        System.out.println("permissions:" + permissions);
//        data.put("name", adminUser.getName());
//        data.put("avatar", adminUser.getAvatar());
//        data.put("adminUserId", adminUser.getId());
//        data.put("lastLoginIp", adminUser.getLastLoginIp());
//        data.put("lastLoginTime", adminUser.getLastLoginTime());
//        data.put("role", role);
//        data.put("perms", toApi(permissions));
//        System.out.println("toApi(permissions):" + toApi(permissions));
//        return CommonResult.success(data);
//    }
//
//    @RequiresAuthentication
//    @GetMapping("/client/info")
//    public CommonResult clientInfo() {
//        Subject currentUser = SecurityUtils.getSubject();
//        System.out.println("currentUser:" + currentUser);
//        User user = (User) currentUser.getPrincipal();
//        System.out.println("user:" + user);
//        Map<String, Object> data = new HashMap<>();
//        Long id = user.getId();
//        System.out.println("id:" + id);
//        data.put("name", user.getName());
//        data.put("avatar", user.getAvatar());
//        data.put("id", user.getId());
//        return CommonResult.success(data);
//    }
//
////    @RequiresAuthentication
////    @GetMapping("/client/info")
////    public CommonResult clientInfo() {
////        Subject currentUser = SecurityUtils.getSubject();
////        System.out.println("currentUser:" + currentUser);
////        User user = (User) currentUser.getPrincipal();
////        System.out.println("user:" + user);
////        Map<String, Object> data = new HashMap<>();
////        Long roleId = user.getRoleId();
////        System.out.println("roleId:" + roleId);
////        String role = adminRoleService.selectNameById(roleId);
////        List<String> permissions = adminPermissionService.selectPermissionByRoleId(roleId);
////        System.out.println("permissions:" + permissions);
////        data.put("name", adminUser.getName());
////        data.put("avatar", adminUser.getAvatar());
////        data.put("role", role);
////        data.put("perms", toApi(permissions));
////        System.out.println("toApi(permissions):" + toApi(permissions));
////        return CommonResult.success(data);
////    }
//
//    @Autowired
//    private ApplicationContext context;
//    private HashMap<String, String> systemPermissionsMap = null;
//
//    private Collection<String> toApi(List<String> permissions) {
//        if (systemPermissionsMap == null) {
//            systemPermissionsMap = new HashMap<>();
//            final String basicPackage = "com.yuanbao.record.admin.controller";
//            List<Permission> systemPermissions = PermissionUtil.listPermission(context, basicPackage);
//            System.out.println("systemPermissions:" + systemPermissions);
//            for (Permission permission : systemPermissions) {
//                String perm = permission.getRequiresPermissions().value()[0];
//                String api = permission.getApi();
//                systemPermissionsMap.put(perm, api);
//            }
//        }
//        Collection<String> apis = new HashSet<>();
//        for (String perm : permissions) {
//            String api = systemPermissionsMap.get(perm);
//            apis.add(api);
//
//            if (perm.equals("*")) {
//                apis.clear();
//                apis.add("*");
//                return apis;
//            }
//        }
//        return apis;
//    }
//}
