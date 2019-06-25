/**
 * Project Name:umale
 * File Name:SZCGReceiverConfig
 * Package Name:com.citycloud.umale.esi.config
 * Date: 2019/6/15 00:23
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.config;/**
 * @author zq
 * @date 2019/6/15
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Topic;

/**
 * @author bridge
 * @className SZCGReceiverConfig
 * @description
 * @date 2019/6/15 00:23
 * @since JDK 1.8
 */

@Configuration
@ComponentScan(basePackages = "com.citycloud.umale.esi")
@EnableJms
@Slf4j
public class SZCGActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${szcg.activemq.topic.name}")
    private String topicName;

    @Value("${szcg.activemq.topic.clientid}")
    private String clientID;

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(topicName);
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(brokerUrl);
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //设置为发布订阅方式, 默认情况下使用的生产消费者方式
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }


}

