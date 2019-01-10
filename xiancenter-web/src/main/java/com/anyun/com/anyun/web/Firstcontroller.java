/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.com.anyun.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangjian
 * Date: 18-12-27
 * Time: 下午1:33
 */

@Controller
//@RequestMapping(value = "/index")
public class Firstcontroller {

    @RequestMapping(value = "/test1")
    public String test1(){
        System.out.println("=================");
        return "hello world!";
    }


    @RequestMapping("/index1")
    public String index1() {
        return "index";
    }
}
