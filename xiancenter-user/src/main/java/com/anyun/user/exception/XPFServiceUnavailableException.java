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
 * Time: 下午4:34
 */
public class XPFServiceUnavailableException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.SERVICE_UNAVAILABLE;

    public XPFServiceUnavailableException(String errorHuman) {
        super(buildErrorCode(STATUS), combineErrorHuman(errorHuman, "服务器资源暂时不可用"));
    }

    public XPFServiceUnavailableException() {
        this(null);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
