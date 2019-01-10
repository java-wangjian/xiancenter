/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication(scanBasePackages = {"com.anyun.api","com.anyun.user.service","com.anyun.user.config"})
@MapperScan("com.anyun.uesr.mapper")
public class XiancenterWebApplication extends WebMvcConfigurationSupport {
    public static void main(String[] args) {
        SpringApplication.run(XiancenterWebApplication.class, args);
    }
}



