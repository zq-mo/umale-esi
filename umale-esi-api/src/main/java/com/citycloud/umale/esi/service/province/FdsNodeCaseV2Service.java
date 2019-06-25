/**
 * Project Name:umale
 * File Name:FdsNodeCaseV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/16 17:16
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;

import com.citycloud.umale.esi.po.NodeCase;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsNodeCaseV2Service
 * @description
 * @date 2019/5/16 17:16
 * @since JDK 1.8
 */
public interface FdsNodeCaseV2Service {

    int insert(NodeCase po);
    int insertList(List<NodeCase> poList);
}
