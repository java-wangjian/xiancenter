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
public class XPFJsonTransformException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public XPFJsonTransformException(String errorHuman) {
        super(buildErrorCode(STATUS), combineErrorHuman(errorHuman, "JSON转换错误"));
    }

    public XPFJsonTransformException() {
        this(null);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
