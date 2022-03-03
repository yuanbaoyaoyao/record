package com.yuanbao.record.shiro.util;

import com.yuanbao.record.mbp.vo.PermVo;
import com.yuanbao.record.shiro.annotation.RequiresPermissionsDesc;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.*;

public class PermissionUtil {
    public static List<PermVo> permVoList(List<Permission> permissions) {
        List<PermVo> root = new ArrayList<>();
        for (Permission permission : permissions) {
            RequiresPermissions requiresPermissions = permission.getRequiresPermissions();
            RequiresPermissionsDesc requiresPermissionsDesc = permission.getRequiresPermissionsDesc();
            String api = permission.getApi();

            String[] menus = requiresPermissionsDesc.menu();
            if (menus.length != 2) {
                throw new RuntimeException("目前只支持两级菜单");
            }
            String menu1 = menus[0];
            PermVo perm1 = null;
            for (PermVo permVo : root) {
                if (permVo.getLabel().equals(menu1)) {
                    perm1 = permVo;
                    break;
                }
            }
            if (perm1 == null) {
                perm1 = new PermVo();
                perm1.setId(menu1);
                perm1.setLabel(menu1);
                perm1.setChildren(new ArrayList<>());
                root.add(perm1);
            }
            String menu2 = menus[1];
            PermVo perm2 = null;
            for (PermVo permVo : perm1.getChildren()) {
                if (permVo.getLabel().equals(menu2)) {
                    perm2 = permVo;
                    break;
                }
            }
            if (perm2 == null) {
                perm2 = new PermVo();
                perm2.setId(menu2);
                perm2.setLabel(menu2);
                perm2.setChildren(new ArrayList<>());
                perm1.getChildren().add(perm2);
            }

            String button = requiresPermissionsDesc.button();
            PermVo leftPerm = null;
            for (PermVo permVo : perm2.getChildren()) {
                if (permVo.getLabel().equals(button)) {
                    leftPerm = permVo;
                    break;
                }
            }
            if (leftPerm == null) {
                leftPerm = new PermVo();
                leftPerm.setId(requiresPermissions.value()[0]);
                leftPerm.setLabel(requiresPermissionsDesc.button());
                leftPerm.setApi(api);
                perm2.getChildren().add(leftPerm);
            } else {
                throw new RuntimeException("权限已经存在，不能添加新权限");
            }
        }
        return root;
    }

    public static List<Permission> listPermission(ApplicationContext context, String basicPackage) {
        Map<String, Object> map = context.getBeansWithAnnotation(Controller.class);
        List<Permission> permissions = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object bean = entry.getValue();
            if (!StringUtils.contains(ClassUtils.getPackageName(bean.getClass()), basicPackage)) {
                continue;
            }

            Class<?> clz = bean.getClass();
            Class controllerClz = clz.getSuperclass();
//            System.out.println("clz:" + clz);
//            System.out.println("controllerClz:" + controllerClz);
            RequestMapping clazzRequestMapping = AnnotationUtils.findAnnotation(controllerClz, RequestMapping.class);
//            System.out.println("controllerClz:" + controllerClz);
//            System.out.println("RequestMapping.class:" + RequestMapping.class);
//            System.out.println("clazzRequestMapping:" + clazzRequestMapping);
            List<Method> methods = MethodUtils.getMethodsListWithAnnotation(controllerClz, RequiresPermissions.class);
//            System.out.println("methods:"+methods);
            for (Method method : methods) {
                RequiresPermissions requiresPermissions = AnnotationUtils.getAnnotation(method,
                        RequiresPermissions.class);
                RequiresPermissionsDesc requiresPermissionsDesc = AnnotationUtils.getAnnotation(method,
                        RequiresPermissionsDesc.class);
//                System.out.println("requiresPermissions:"+requiresPermissions);
//                System.out.println("requiresPermissionsDesc:"+requiresPermissionsDesc);
                if (requiresPermissions == null && requiresPermissionsDesc == null) {
//                    System.out.println(i++);
                    continue;
                }

                String api = "";
                if (clazzRequestMapping != null) {
                    api = clazzRequestMapping.value()[0];
                }

                PostMapping postMapping = AnnotationUtils.getAnnotation(method, PostMapping.class);
//                System.out.println("postMapping:"+postMapping);
                if (postMapping != null) {
                    System.out.println("api1:" + api);
                    System.out.println("getMapping.value()[0]:"+postMapping.value()[0]);
                    api = "POST " + api + postMapping.value()[0];
                    System.out.println("api" + api);

                    Permission permission = new Permission();
                    permission.setRequiresPermissions(requiresPermissions);
                    permission.setRequiresPermissionsDesc(requiresPermissionsDesc);
                    permission.setApi(api);
                    permissions.add(permission);
                    continue;
                }
                GetMapping getMapping = AnnotationUtils.getAnnotation(method, GetMapping.class);
//                System.out.println("GetMapping:"+getMapping);
                if (getMapping != null) {
                    System.out.println("api1:" + api);
                    System.out.println("getMapping.value()[0]:"+getMapping.value()[0]);
                    api = "GET " + api + getMapping.value()[0];
                    System.out.println("api2:" + api);

                    Permission permission = new Permission();
                    permission.setRequiresPermissions(requiresPermissions);
                    permission.setRequiresPermissionsDesc(requiresPermissionsDesc);
                    permission.setApi(api);
                    permissions.add(permission);
                    continue;
                }
                PutMapping putMapping = AnnotationUtils.getAnnotation(method, PutMapping.class);
                if (putMapping != null) {
                    System.out.println("api1:" + api);
                    System.out.println("getMapping.value()[0]:"+putMapping.value()[0]);
                    api = "PUT " + api + putMapping.value()[0];
                    System.out.println("api" + api);

                    Permission permission = new Permission();
                    permission.setRequiresPermissions(requiresPermissions);
                    permission.setRequiresPermissionsDesc(requiresPermissionsDesc);
                    permission.setApi(api);
                    permissions.add(permission);
                    continue;
                }
                DeleteMapping deleteMapping = AnnotationUtils.getAnnotation(method, DeleteMapping.class);
                if (deleteMapping != null) {
                    System.out.println("api1:" + api);
                    System.out.println("getMapping.value()[0]:"+deleteMapping.value()[0]);
                    api = "DELETE " + api + deleteMapping.value()[0];
                    System.out.println("api" + api);
                    Permission permission = new Permission();
                    permission.setRequiresPermissions(requiresPermissions);
                    permission.setRequiresPermissionsDesc(requiresPermissionsDesc);
                    permission.setApi(api);
                    permissions.add(permission);
                    continue;
                }
                throw new RuntimeException("目前权限管理应该在method的前面使用GetMapping注解或者PostMapping注解或者PutMapping注解或者DeleteMapping注解");
            }
        }
//        System.out.println("permissions:" + permissions);
        return permissions;
    }

    public static Set<String> listPermissionString(List<Permission> permissions) {
        Set<String> permissionsString = new HashSet<>();
        for (Permission permission : permissions) {
            permissionsString.add(permission.getRequiresPermissions().value()[0]);
        }
        return permissionsString;
    }
}
