/**
 * Project Name:umale
 * File Name:FdsNodePunishdecideV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/16 19:20
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;

import com.citycloud.umale.esi.po.NodePunishdecide;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsNodePunishdecideV2Service
 * @description
 * @date 2019/5/16 19:20
 * @since JDK 1.8
 */
public interface FdsNodePunishdecideV2Service {
    int insert(NodePunishdecide po);
    int insertList(List<NodePunishdecide> poList);
}
