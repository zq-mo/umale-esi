/**
 * Project Name:umale-maintenance
 * File Name:EndExternalJobHandler
 * Package Name:com.citycloud.umale.esi.handler
 * Date: 2019/5/7 上午11:22
 * Copyright (c) 2018, Neoglory-umale All Rights Reserved.
 */
package com.citycloud.umale.esi.handler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.citycloud.umale.acceptance.commons.BeanUtil;
import com.citycloud.umale.acceptance.service.accptance.AcceptanceEventService;
import com.citycloud.umale.acceptance.vo.accptance.NormalResultVO;
import com.citycloud.umale.esi.service.ExecuteExternalEndEventService;
import com.citycloud.umale.esi.service.SendMsgService;
import com.citycloud.umale.esi.vo.NormalResult;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName EndExternalJobHandler
 * @Description TODO
 * @Author xuhaowei
 * @Date 2019/5/7 上午11:22
 * @Version 1.0.0
 * @since JDK 1.8
 */


@JobHandler(value = "endExternalJobHandler")
@Component
@Slf4j
public class JLSYLJobHandler extends IJobHandler {

    @Autowired
    ExecuteExternalEndEventService executeExternalEndEventService;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        try {
            executeExternalEndEventService.findEndExternalEventService();
            return  ReturnT.SUCCESS;
        }catch (Exception e){
            return ReturnT.FAIL;
        }
    }

}