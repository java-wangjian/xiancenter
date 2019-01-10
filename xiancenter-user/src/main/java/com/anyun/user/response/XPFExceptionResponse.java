/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.response;

import java.util.Date;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:18
 */
public class XPFExceptionResponse extends XPFBaseResponse {
    public XPFExceptionResponse(String errorCode, String errorHuman, Object reason) {
        super(false);
        super.put("errorCode", errorCode);
        super.put("errorHuman", errorHuman);
        super.put("time", new Date());
        if(reason != null) {
            super.put("reason", reason);
        }
    }
}
