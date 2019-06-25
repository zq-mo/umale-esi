/**
 * Project Name:umale
 * File Name:SendMsgService
 * Package Name:com.citycloud.esi.event.service
 * Date: 2019/5/5 17:17
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service;

import javax.jms.JMSException;

/**
 * @author bridge
 * @className SendMsgService
 * @description
 * @date 2019/5/5 17:17
 * @since JDK 1.8
 */
public interface SendMsgService {

    public void resultMsg(String vo) throws JMSException;
}
