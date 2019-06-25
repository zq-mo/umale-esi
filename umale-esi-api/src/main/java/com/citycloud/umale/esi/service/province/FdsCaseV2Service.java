/**
 * Project Name:umale
 * File Name:FdsCaseV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/14 16:28
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;

import com.citycloud.umale.esi.po.Case;

import java.util.List;

/**
 * @author bridge
 * @className FdsCaseV2Service
 * @description
 * @date 2019/5/14 16:28
 * @since JDK 1.8
 */
public interface FdsCaseV2Service {

    int insert(Case po);//插入单个
    int insertList(List<Case> cases);//批量插入
}
