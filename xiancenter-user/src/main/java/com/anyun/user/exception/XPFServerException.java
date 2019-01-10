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
public class XPFServerException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;


    public XPFServerException(String errorHuman) {
        super(buildErrorCode(STATUS), errorHuman);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
