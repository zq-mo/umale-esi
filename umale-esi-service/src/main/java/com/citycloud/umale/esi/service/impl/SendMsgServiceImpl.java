/**
 * Project Name:umale
 * File Name:SendMsgServiceImpl
 * Package Name:com.citycloud.umale.esi.service
 * Date: 2019/5/5 17:22
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.service.SendMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author bridge
 * @className SendMsgServiceImpl
 * @description
 * @date 2019/5/5 17:22
 * @since JDK 1.8
 */
@Service(interfaceClass = SendMsgService.class)
@Slf4j
public class SendMsgServiceImpl implements SendMsgService {

//    private static final String url = "tcp://127.0.0.1:61616";
//    private static final String topicName = "96130-event-back";

    private static final String url = "tcp://10.12.102.114:9416";
    private static final String topicName = "zftorx__9763d85b7a6efdaceddb33c9ceaa4126aa1f6487317eb8edb574ac8a8f75bac5";

    public void resultMsg(String vo) throws JMSException {

        //1.创建连接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //2.创建连接
        Connection connection = factory.createConnection();
        //3.开启连接
        connection.start();
        //4.创建session对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建目的地Destination，该模式创建的是Topic
        Topic topic = session.createTopic(topicName);
        //6.创建生产者
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //7.创建消息
        TextMessage message = session.createTextMessage(vo);

        log.info("发送消息到消息队列，消息内容{}",vo);
        //8.发送消息
        producer.send(message);
        log.info("消息发送成功！");
        //9.关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}




