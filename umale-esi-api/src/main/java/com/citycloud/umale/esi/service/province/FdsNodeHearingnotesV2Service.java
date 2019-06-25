/**
 * Project Name:umale
 * File Name:FdsNodeHearingnotesV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/17 14:55
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;/**
 * @author zq
 * @date 2019/5/17
 */

import com.citycloud.umale.esi.po.NodeHearingnotes;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsNodeHearingnotesV2Service
 * @description
 * @date 2019/5/17 14:55
 * @since JDK 1.8
 */
public interface FdsNodeHearingnotesV2Service {

    int insert(NodeHearingnotes po);
    int insertList(List<NodeHearingnotes> poList);
}
