/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:33
 */
public class XPFOtherException extends XPFBaseException {
    private HttpStatus status;

    public XPFOtherException(HttpStatus status, String errorHuman) {
        super(buildErrorCode(status), errorHuman);
        this.status = status;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }
}
