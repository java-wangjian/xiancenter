/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午3:53
 */

@Transactional
public interface RedisService {
    boolean setString(String key, String value);

    String getString(String key);

    boolean expire(String key, long expire);
}
