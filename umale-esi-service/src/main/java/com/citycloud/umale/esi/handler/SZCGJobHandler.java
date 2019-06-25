/**
 * Project Name:umale
 * File Name:SZCGJobHandler
 * Package Name:com.citycloud.umale.esi.handler
 * Date: 2019/6/4 09:45
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.handler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.citycloud.umale.acceptance.service.accptance.EventService;
import com.citycloud.umale.esi.service.SZCGEventService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.List;

/**
 * @author bridge
 * @className SZCGJobHandler
 * @description
 * @date 2019/6/4 09:45
 * @since JDK 1.8
 */
@JobHandler(value = "SZCGJobHandler")
@Component
@Slf4j
public class SZCGJobHandler extends IJobHandler {

    @Reference
    private EventService eventService;

    @Autowired
    private SZCGEventService szcgEventService;

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private  Topic topic;

    @Override
    public ReturnT<String> execute(String s) throws  Exception {
        try {
            //获取eventIds
            List<Integer> ids = szcgEventService.getEventCode();
            log.info("ids:{}",ids);
            //获取封装列表
            List<String> resultList = eventService.getResultJson(ids);
            log.info("发送数据:{}",resultList);
            //发送
            for(String item :resultList){
                jmsTemplate.convertAndSend(topic,item);
            }
            return ReturnT.SUCCESS;
        } catch (Exception e) {
            return ReturnT.FAIL;
        }
    }
}
