/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.exception;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:29
 *
 * 数据校验异常
 */
public class ValidateException extends BusinessException {
    public ValidateException(String message) {
        super(message);
    }
}
