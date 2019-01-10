/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjian
 * Date: 18-12-27
 * Time: 下午1:33
 */

@Controller
//@RequestMapping(value = "/index")
public class Indexcontroller {

    @ResponseBody
    @RequestMapping(value = "/test")
    public String test(){
        System.out.println("=================");
        return "hello world!";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/product-list")
    public String indexindex() {
        return "product-list";
    }

    @RequestMapping("/product-category")
    public String productCategory() {
        return "product-category";
    }

    @RequestMapping(value = "/ajaxtest")
    @ResponseBody
    public  Map<String, Object> ajaxtest() {
        System.out.println("---------------------------");
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("name", "zhou");
        userMap.put("age", "23");
        userMap.put("id", "111");
        userMap.put("address", "上海");
        return userMap;
    }
}
