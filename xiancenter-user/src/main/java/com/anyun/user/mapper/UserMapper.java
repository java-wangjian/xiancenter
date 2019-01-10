/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.mapper;
import com.anyun.user.models.PageDo;
import com.anyun.user.models.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午3:50
 */

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String zxUuid);

    int deleteByPrimaryKeyList(List<String> zxUuid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String zxUuid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<Object> findPageDo(PageDo pageDo);

    int findPageDoCount(PageDo pageDo);

    /**
     * 获取最大的zxCode
     * @return
     */
    String queryMaxZxCode();

    int updateStatusu2Stop(@Param(value = "list") List<String> idList);
}
