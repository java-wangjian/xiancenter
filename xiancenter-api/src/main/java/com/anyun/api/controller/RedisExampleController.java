/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.api.controller;
import com.anyun.user.exception.XPFBadRequestException;
import com.anyun.user.response.XPFSingleResponse;
import com.anyun.user.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午3:24
 */

@Api(description = "redis测试接口")
@RestController
@RequestMapping("/redis")
public class RedisExampleController {

    @Autowired
    private RedisService redisService;


    @ApiOperation(value = "redis赋值")
    @GetMapping("/set")
    public Object redisSet(@RequestParam("value")String value){
        boolean isOk = redisService.setString("name", value);
        if(isOk){
            return new XPFSingleResponse("redis新增成功");
        }else{
            return new XPFBadRequestException("redis新增失败");
        }
    }


    @ApiOperation(value = "取值")
    @GetMapping("/get")
    public Object redisGet(){
        String value = redisService.getString("xidada");
        return new XPFSingleResponse("redis获取key为name的：" + value);
    }
}