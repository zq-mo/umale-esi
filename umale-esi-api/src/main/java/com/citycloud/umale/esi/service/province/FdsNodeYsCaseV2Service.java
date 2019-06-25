/**
 * Project Name:umale
 * File Name:FdsNodeYsCaseV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/17 16:17
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;

import com.citycloud.umale.esi.po.NodeYscase;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsNodeYsCaseV2Service
 * @description
 * @date 2019/5/17 16:17
 * @since JDK 1.8
 */
public interface FdsNodeYsCaseV2Service {

    int insertList(List<NodeYscase> po);
}
