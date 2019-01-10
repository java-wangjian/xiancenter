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
 * Time: 下午4:23
 *
 * 业务异常
 */
public class BusinessException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public BusinessException(String message){
        super(buildErrorCode(STATUS), message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
