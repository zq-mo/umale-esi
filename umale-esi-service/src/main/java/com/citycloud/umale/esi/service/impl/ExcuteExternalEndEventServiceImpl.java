/**
 * Project Name:umale-maintenance
 * File Name:ExcuteExternalEndEventServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/6 上午10:44
 * Copyright (c) 2018, Neoglory-umale All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.citycloud.umale.acceptance.po.AcceptanceEvent;
import com.citycloud.umale.acceptance.service.accptance.AcceptanceEventService;
import com.citycloud.umale.acceptance.service.accptance.EventService;
import com.citycloud.umale.esi.service.ExecuteExternalEndEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Topic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ExcuteExternalEndEventServiceImpl
 * @Description TODO
 * @Author xuhaowei
 * @Date 2019/5/6 上午10:44
 * @Version 1.0.0
 * @since JDK 1.8
 */

@Service(interfaceClass = ExecuteExternalEndEventService.class)
@Slf4j
public class ExcuteExternalEndEventServiceImpl implements ExecuteExternalEndEventService {


    @Autowired
    private JmsMessagingTemplate jmsTemplate;
    @Reference
    private AcceptanceEventService acceptanceEventService;

    @Reference
    private EventService eventService;

    @Autowired
    private Topic jlsylTopic;

    @Override
    public void findEndExternalEventService() {
        try {
            Date end = new Date();
            Date start = new Date(end.getTime() - 1 * 24 * 60 * 60 * 1000);
            List<AcceptanceEvent> acceptanceEventList = acceptanceEventService.jlsylEventList(start, end);

            List<Integer> ids = new ArrayList<>();
            for (AcceptanceEvent item : acceptanceEventList) {
                ids.add(item.getId());
            }
            log.info("96310 ids={}", JSON.toJSONString(ids));

            List<String> resultList = eventService.getResultJson(ids);
            for (String item : resultList) {
                jmsTemplate.convertAndSend(jlsylTopic, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}