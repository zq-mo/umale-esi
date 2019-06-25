///**
// * Project Name:umale
// * File Name:Receiver
// * Package Name:com.citycloud.umale.esi.facade
// * Date: 2019/4/19 14:33
// * Copyright (c) 2018, CCI All Rights Reserved.
// */
//package com.citycloud.umale.esi.facade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.citycloud.umale.esi.service.ExternalEventService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.jms.*;
//
///**
// * @author bridge
// * @className Receiver
// * @description 接受96130热线发送的消息。
// * @date 2019/4/19 14:33
// * @since JDK 1.8
// */
//@Slf4j
//@Component
//@Order(value = 3)
//public class Receiver implements ApplicationRunner {
//
//
//    @Value("${umale.esi.facade.activemq.url}")
//    private String url;
//    @Value("${umale.esi.facade.activemq.topic.name}")
//    private String topicName;
//    @Value("${umale.esi.facade.activemq.clientid}")
//    private String clientID;
//
//    @Reference
//    private ExternalEventService externalEventService;
//
//    /**
//     * 从消息队列获取消息。
//     *
//     * @throws JMSException
//     */
//    @Override
//    public void run(ApplicationArguments var) {
//
//        try {
//            log.info("建立连接[]");
//
//            //1.创建连接工厂
//            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
//
//            //2.创建连接
//            Connection connection = factory.createConnection();
//            connection.setClientID(clientID);
//            //3.开启连接
//            connection.start();
//            //4.创建session对象
//            final Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
//
//            //5.创建目的地Destination
//            Topic topic = session.createTopic(topicName);
//
//            //6.创建消费者
//            MessageConsumer consumer = session.createDurableSubscriber(topic, topicName);
//
//            //7.接收消息
//            log.info("开始监听[]");
//            consumer.setMessageListener(new MessageListener() {
//                public void onMessage(Message message) {
//                    TextMessage textMessage = (TextMessage) message;
//                    //获取信息并打印
//                    try {
//                        String text = textMessage.getText();
//                        log.info("从消息队列中获取的消息内容：{}", text);
//                        System.out.println(text);
//                        externalEventService.saveEvent(text);
//                        message.acknowledge();
//
//                    } catch (JMSException e) {
//                        log.info("jmx异常：{}", ExceptionUtils.getFullStackTrace(e));
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        log.info("保存事件异常：{}", ExceptionUtils.getFullStackTrace(e));
//                        e.printStackTrace();
//                    }
//                }
//            });
//            while (true) {
//                try {
//                    Thread.sleep(10 * 1000);
//                } catch (InterruptedException e) {
//                    log.error("监听中止，{}", ExceptionUtils.getFullStackTrace(e));
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (Exception e) {
//            log.error("连接异常,中止监听消息队列,异常信息[{}]",ExceptionUtils.getFullStackTrace(e));
//        }
//
//
//    }
//}