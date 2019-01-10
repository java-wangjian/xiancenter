/*
 * ==============================================================
 * Copyright (c) 2012 ~ 2018. anyuncloud.com All rights reserved.
 *                                           Created by wangjian
 * ==============================================================
 */

package com.anyun.api.controller;
import com.anyun.user.models.PageDo;
import com.anyun.user.models.User;
import com.anyun.user.service.SpecialManagement;
import com.anyun.user.util.UUIDUtil;
import com.anyun.user.exception.XPFBadRequestException;
import com.anyun.user.response.XPFSingleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by wangjian
 * Date: 18-12-26
 * Time: 下午4:50
 */

@Api(description = "专项管理接口")
@CrossOrigin
@RestController
public class SpecialManagementController {
    @Resource
    private SpecialManagement specialManagement;

    @ApiOperation(value = "专项管理", notes = "notes", httpMethod = "GET")
    @GetMapping(value = "/specialManagements")
    @ResponseBody
    public Object query(Integer limit, Integer offset) throws XPFBadRequestException {
        PageDo pageDo = new PageDo(limit, offset);
        specialManagement.findDataGrid(pageDo);
        return pageDo;
    }


    /**
     * 该方法测试通过，前端 http://localhost:7500/zeus/specialManagementsById
     * @param id
     * @return
     * @throws XPFBadRequestException
     */
    @ApiOperation(value = "专项管理(单个，用于编辑页面的查询)")
    @GetMapping(value = "/specialManagementsById")
    @ResponseBody
    public Object getById(String id) throws XPFBadRequestException {
        User user =  specialManagement.queryById(id);
        return user;
    }
    /**
     * 该方法测试无法通过，前端 http://localhost:7500/zeus/speciGETalManagements/247897A0A4154509A41A152DF2437DFF 请求无法过来
     * @param id
     * @return
     * @throws XPFBadRequestException
     */
    @ApiOperation(value = "获取实体")
    @GetMapping(value = "/specialManagements/{id}")
    @ResponseBody
    public Object queryById(@PathVariable(value = "id") String id) throws XPFBadRequestException {
        User zcdcZx =  specialManagement.queryById(id);
        return zcdcZx;
    }

    @ApiOperation(value = "删除专项")
    @DeleteMapping(value = "/specialManagements")
    public Object delete(String idSelections) {
        if (StringUtils.isNotBlank(idSelections)) {
            List<String> idList = Arrays.asList(StringUtils.split(idSelections,","));
            if(specialManagement.deleteByIdList(idList) > 0){
                return new XPFSingleResponse("专项删除成功");
            }
        }
        return new XPFBadRequestException("专项删除失败");
    }

    @ApiOperation(value = "专项结束")
    @PatchMapping(value = "/specialManagements/stop")
    @ResponseBody
    public Object stop(String idSelections) {
        if (StringUtils.isNotBlank(idSelections)) {
            List<String> idList = Arrays.asList(StringUtils.split(idSelections,","));
            if(specialManagement.stopZX(idList) > 0){
                return new XPFSingleResponse("专项结束成功");
            }
        }
        return new XPFBadRequestException("专项结束失败");
    }


    @ApiOperation(value = "获取专项新增的编号")
    @GetMapping(value = "/specialManagements/zxCode")
    @ResponseBody
    public Object queryZxCode() throws XPFBadRequestException {
        return new XPFSingleResponse(specialManagement.createZxCode());
    }

    @ApiOperation(value = "新增专项")
    @PostMapping(value = "/specialManagements")
    @ResponseBody
    public Object add( @RequestBody User user) throws XPFBadRequestException {
        if (user != null) {
            user.setStatus("1");
            if(StringUtils.isBlank(user.getUserName())){
                return new XPFBadRequestException("专项新增失败,名称不可为空");
            }
            if(!user.getCode().equals(specialManagement.createZxCode())){
                return new XPFBadRequestException("专项新增失败,当前专项编号不是最新的，请刷新页面后重试");
            }
            if((user.getStartTime() != null) && (user.getEndTime() != null) && (user.getEndTime().getTime() < user.getStartTime().getTime())){
                return new XPFBadRequestException("专项新增失败,结束时间小于开始时间");
            }
            user.setUuid(UUIDUtil.getUUID());
            user.setCreateTime(new Date());
            if(specialManagement.insert(user) > 0){
                return new XPFSingleResponse("专项新增成功");
            }
        }
        return new XPFBadRequestException("专项新增失败");
    }


    @ApiOperation(value = "编辑专项")
    @PatchMapping(value = "/specialManagements")
    @ResponseBody
    public Object edit( @RequestBody User user) throws XPFBadRequestException {
        if (user != null) {
            user.setUpdateTime(new Date());
            if(specialManagement.update(user) > 0){
                return new XPFSingleResponse("专项编辑成功");
            }
        }
        return new XPFBadRequestException("专项编辑失败");
    }
}
