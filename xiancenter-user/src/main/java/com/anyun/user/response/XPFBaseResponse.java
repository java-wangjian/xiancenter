/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.response;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:17
 * 统一基础的回复格式
 */
public class XPFBaseResponse extends HashMap<String, Object> {

    protected XPFBaseResponse(boolean success) {
        super.put("success", success);
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
