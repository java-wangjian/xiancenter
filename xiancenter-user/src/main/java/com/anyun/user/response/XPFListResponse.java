/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:19
 * 列表页的返回值
 */
public class XPFListResponse extends XPFBaseResponse {
    /**
     * 构建列表页的返回值
     * @param objects 列表页的数据
     * @param offset 结果开始的位移，从0开始
     * @param total 数据的总数量
     */
    public XPFListResponse(List<?> objects, int offset, int total) {
        super(true);
        objects = (objects == null) ? new ArrayList<>() : objects;
        super.put("offset", offset);
        super.put("total", total);
        super.put("count", objects.size());
        super.put("list", objects);
    }
}
