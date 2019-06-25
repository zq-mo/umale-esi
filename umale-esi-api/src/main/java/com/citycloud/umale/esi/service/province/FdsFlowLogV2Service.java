/**
 * Project Name:umale
 * File Name:FdsFlowLogV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/16 16:45
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;

import com.citycloud.umale.esi.po.FlowLog;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsFlowLogV2Service
 * @description
 * @date 2019/5/16 16:45
 * @since JDK 1.8
 */
public interface FdsFlowLogV2Service {
    int insert(FlowLog po);
    int insertList(List<FlowLog> poList);
}
