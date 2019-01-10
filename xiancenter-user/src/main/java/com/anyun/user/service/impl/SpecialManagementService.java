/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.user.service.impl;
import com.anyun.user.mapper.UserMapper;
import com.anyun.user.models.PageDo;
import com.anyun.user.models.User;
import com.anyun.user.service.SpecialManagement;
import com.anyun.user.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:03
 */
@Service
public class SpecialManagementService implements SpecialManagement {
    private final Logger LOG = Logger.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteByIdList(List<String> idList) {
        return userMapper.deleteByPrimaryKeyList(idList);
    }

    @Override
    public User queryById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void findDataGrid(PageDo pageDo) {
        pageDo.setRows(userMapper.findPageDo(pageDo));
        pageDo.setTotal(userMapper.findPageDoCount(pageDo));
    }

    @Override
    public String createZxCode() {
        String zxCode = userMapper.queryMaxZxCode();
        if(StringUtils.isBlank(zxCode)){
            zxCode = DateUtil.getTime4yyyyMMdd() + "-001";
        }else{
            String dateStr = zxCode.substring(0,zxCode.indexOf("-"));
            if(DateUtil.getTime4yyyyMMdd().equals(dateStr)){
                String tempStr = zxCode.substring(zxCode.indexOf("-")+1,zxCode.length());
                Integer temp = Integer.parseInt(tempStr);
                temp++;
                String code = temp < 999 ? (temp < 10 ? ("00" + temp) : (temp < 100 ? "0" + temp : "" + temp)) : temp+"";
                zxCode = DateUtil.getTime4yyyyMMdd() + "-" + code;
            }else {
                zxCode = DateUtil.getTime4yyyyMMdd() + "-001";
            }
        }
        return zxCode;
    }

    @Override
    public int stopZX(List<String> idList) {
        return userMapper.updateStatusu2Stop(idList);
    }

    @Override
    public void testTransactionManagement() {
        User user = new User();
        user.setUuid("A");
        insert(user);
        if(true){
            throw new RuntimeException();
        }
        user.setUuid("B");
        insert(user);
    }
}
