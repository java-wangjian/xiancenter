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
 * Time: 下午4:35
 */
public class XPFTooManyRequestsException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.TOO_MANY_REQUESTS;

    public XPFTooManyRequestsException(String errorHuman) {
        super(buildErrorCode(STATUS), combineErrorHuman(errorHuman, "请求数量过多"));
    }

    public XPFTooManyRequestsException() {
        this(null);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
