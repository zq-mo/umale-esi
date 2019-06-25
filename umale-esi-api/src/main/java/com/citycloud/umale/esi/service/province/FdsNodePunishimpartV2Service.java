/**
 * Project Name:umale
 * File Name:FdsNodePunishimpartV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/16 20:33
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;

import com.citycloud.umale.esi.po.NodePunishimpart;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsNodePunishimpartV2Service
 * @description
 * @date 2019/5/16 20:33
 * @since JDK 1.8
 */
public interface FdsNodePunishimpartV2Service {

    int insert(NodePunishimpart po);
    int insertList(List<NodePunishimpart> poList);
}
