/**
 * Project Name:umale
 * File Name:SZCGEventServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/6/18 13:55
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;/**
 * @author zq
 * @date 2019/6/18
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.citycloud.umale.acceptance.po.AcceptanceEvent;
import com.citycloud.umale.acceptance.service.accptance.AcceptanceEventService;
import com.citycloud.umale.esi.service.SZCGEventService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bridge
 * @className SZCGEventServiceImpl
 * @description
 * @date 2019/6/18 13:55
 * @since JDK 1.8
 */

@Service(interfaceClass = SZCGEventService.class)
@Slf4j
public class SZCGEventServiceImpl implements SZCGEventService {

    @Reference
    private AcceptanceEventService eventService;

    public List<Integer> getEventCode() {

        //获取任务执行时，一天内的结案数据
        Date endDate = new Date();
        Date startDate = new Date(endDate.getTime() - 1 * 5 * 60 * 60 * 1000);
        List<AcceptanceEvent> acceptanceEventList = eventService.szcgEventList(startDate, endDate);
        log.info("数字城管事件列表：{}", JSON.toJSONString(acceptanceEventList));
        List<Integer> ids = new ArrayList<>();
        for (AcceptanceEvent item : acceptanceEventList) {
            ids.add(item.getId());
        }
        return ids;
    }
}
