/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.response;
import com.alibaba.fastjson.JSONObject;
/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:20
 *
 * 单个操作对象的返回值
 */
public class XPFSingleResponse extends XPFBaseResponse {
    public XPFSingleResponse(JSONObject data) {
        super(true);
        for(Entry<String, Object> e : data.entrySet()) {
            super.put(e.getKey(), e.getValue());
        }
    }

    public XPFSingleResponse(Object data) {
        super(true);
        super.put("data", data);
    }

    public XPFSingleResponse() {
        super(true);
    }

    public XPFSingleResponse add(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
