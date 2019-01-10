/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.exception;
import com.anyun.user.response.XPFExceptionResponse;
import org.springframework.http.HttpStatus;
/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:25
 */
public abstract class XPFBaseException extends Exception {
    protected String errorCode;

    protected String errorHuman;

    protected Object reason;

    public XPFBaseException(String errorCode, String errorHuman) {
        this(errorCode, errorHuman, null);
    }

    public XPFBaseException(String errorCode, String errorHuman, Throwable cause) {
        super(errorCode + " " + errorHuman, cause);
        this.errorCode = errorCode;
        this.errorHuman = errorHuman;
    }

    public abstract HttpStatus getHttpStatus();

    /**
     * 转换成错误的回复机制
     */
    public XPFExceptionResponse toExceptionResponse() {
        return new XPFExceptionResponse(this.errorCode, this.errorHuman, this.reason);
    }

    public static String combineErrorHuman(String errorHuman, String defaultVal) {
        return (errorHuman == null) ? defaultVal : errorHuman;
    }

    public static String buildErrorCode(HttpStatus status) {
        return status.getReasonPhrase().toLowerCase().replace(' ', '_');
    }
}
