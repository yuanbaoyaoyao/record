//package com.yuanbao.record.mbp;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//
//public class Generator{
//
//    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
//            .Builder("jdbc:mysql://localhost:3306/record?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai",
//            "root","")
//            .dbQuery(new MySqlQuery());
//
//    public static void main(String[] args) {
//        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
//                .globalConfig(builder -> {
//                    builder.author("yuanbao")
//                            .enableSwagger()
//                            .fileOverride()
//                            .dateType(DateType.TIME_PACK)
//                            .commentDate("yyyy-MM-dd");
//
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.yuanbao.record.admin");
//                })
//                .templateConfig(builder -> {
//                    builder.service("/templates/service.java");
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("user")
//                            .controllerBuilder();
//                });
//    }
//
//}