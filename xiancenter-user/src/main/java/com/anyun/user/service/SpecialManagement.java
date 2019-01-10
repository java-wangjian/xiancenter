/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.service;
import com.anyun.user.models.User;
import com.anyun.user.models.PageDo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午3:54
 */

@Transactional
public interface SpecialManagement {

    /**
     * 插入一个专项
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 更新一个专项
     * @param user
     * @return
     */
    int update(User user);

    int deleteByIdList(List<String> idList);

    User queryById(String id);

    void findDataGrid(PageDo pageDo);

    /**
     * 生成编号，eg:20170922-001,默认三位，最高999，超过则从1000后往后累加
     * @return
     */
    String createZxCode();

    /**
     * 结束专项
     * @param idList
     * @return
     */
    int stopZX(List<String> idList);

    /**
     * 测试事物
     */
    void testTransactionManagement();
}
