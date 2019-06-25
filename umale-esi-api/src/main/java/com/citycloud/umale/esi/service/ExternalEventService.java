/**
 * Project Name:umale
 * File Name:ExternalEventService
 * Package Name:com.citycloud.esi.event.service
 * Date: 2019/5/5 13:46
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service;

import java.text.ParseException;

/**
 * @author bridge
 * @version
 * @className ExternalEventService
 * @description
 * @date 2019/5/5 13:46
 * @since JDK 1.8
 */
public interface ExternalEventService {

    public int saveEvent(String jsonString) throws ParseException;
}
