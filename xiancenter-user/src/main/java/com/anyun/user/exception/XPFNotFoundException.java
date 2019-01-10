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
 * Time: 下午4:32
 */
public class XPFNotFoundException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public XPFNotFoundException(String errorHuman) {
        super(buildErrorCode(STATUS), combineErrorHuman(errorHuman, "资源不存在"));
    }

    public XPFNotFoundException() {
        this(null);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
