/**
 * Project Name:umale
 * File Name:JLSYLReceiver
 * Package Name:com.citycloud.umale.esi.facade
 * Date: 2019/6/19 15:14
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.facade;/**
 * @author zq
 * @date 2019/6/19
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.citycloud.umale.esi.service.ExternalEventService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author bridge
 * @className JLSYLReceiver
 * @description
 * @date 2019/6/19 15:14
 * @since JDK 1.8
 */
@Component
@Slf4j
public class JLSYLReceiver {

    @Reference
    private ExternalEventService externalEventService;

    @JmsListener(destination = "${jlsyl.activemq.topic.name}", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text) {
        log.info("消息内容：{}", text);
        try {
            externalEventService.saveEvent(text);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(ExceptionUtils.getFullStackTrace(e));
        }
    }
}
