/**
 * Project Name:umale
 * File Name:FdsPartyV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/17 16:37
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;

import com.citycloud.umale.esi.po.Party;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsPartyV2Service
 * @description
 * @date 2019/5/17 16:37
 * @since JDK 1.8
 */
public interface FdsPartyV2Service {
    int insertList(List<Party> po);
}
