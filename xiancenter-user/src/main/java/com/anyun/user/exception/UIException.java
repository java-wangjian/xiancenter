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
 * Time: 下午4:27
 */
public class UIException extends XPFBaseException{
    private final static HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public UIException(String message){
        super(buildErrorCode(STATUS),message);
    }

    public UIException(Throwable cause){
        super(buildErrorCode(STATUS), "UI异常", cause);
    }

    public UIException(String message, Throwable cause){
        super(buildErrorCode(STATUS), message,cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
