/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.exception;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:29
 *
 * POST/PUT/PATCH 参数错误, 构造参数可以附带详细的字段
 */
public class XPFBadRequestException extends XPFBaseException {
    private final static HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    @Data
    public static class FieldError {

        private String field;

        private String errorCode;

        private String errorHuman;
    }

    public XPFBadRequestException(String errorHuman, List<FieldError> fields, Throwable cause) {
        super(buildErrorCode(STATUS), combineErrorHuman(
                errorHuman,"请求的参数不正确"), cause);
        reason = fields;
    }

    public XPFBadRequestException(String errorHuman, List<FieldError> fields) {
        this(errorHuman, fields, null);
    }

    public XPFBadRequestException(String errorHuman) {
        this(errorHuman, null, null);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return STATUS;
    }
}
