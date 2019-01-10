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
public class XPFUnauthorizedException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.UNAUTHORIZED;

    public XPFUnauthorizedException(String errorHuman) {
        super(buildErrorCode(STATUS), combineErrorHuman(errorHuman, "需要认证才能访问"));
    }

    public XPFUnauthorizedException() {
        this(null);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
