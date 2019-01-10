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
 * Time: 下午4:31
 */
public class XPFForbiddenException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.FORBIDDEN;

    public XPFForbiddenException() {
        this(null);
    }

    public XPFForbiddenException(String errorHuman) {
        super(buildErrorCode(STATUS), combineErrorHuman(errorHuman, "没有权限访问"));
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
