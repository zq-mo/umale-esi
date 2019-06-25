/**
 * Project Name:umale
 * File Name:FdsNodeTakeevidenceV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/17 15:24
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;/**
 * @author zq
 * @date 2019/5/17
 */

import com.citycloud.umale.esi.po.NodeTakeevidence;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsNodeTakeevidenceV2Service
 * @description
 * @date 2019/5/17 15:24
 * @since JDK 1.8
 */
public interface FdsNodeTakeevidenceV2Service {

    int insertList(List<NodeTakeevidence> po);
}
