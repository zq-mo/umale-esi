/**
 * Project Name:umale
 * File Name:SendController
 * Package Name:com.citycloud.umale.esi.facade
 * Date: 2019/6/17 16:09
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.facade;/**
 * @author zq
 * @date 2019/6/17
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;

/**
 * @author bridge
 * @className SendController
 * @description
 * @date 2019/6/17 16:09
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/jms")
public class SZCGController {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Topic topic;
    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    public void sendMsg(String message) {
        jmsTemplate.convertAndSend(topic, message);
        System.out.println("done!");
    }
}
