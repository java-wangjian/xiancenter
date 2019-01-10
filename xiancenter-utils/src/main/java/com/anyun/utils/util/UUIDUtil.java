/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.util;

import java.util.UUID;

/**
 * @author wangjian
 */
public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		// return UUID.randomUUID().toString().toUpperCase();
	}
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(getUUID());
		}
		
	}
}