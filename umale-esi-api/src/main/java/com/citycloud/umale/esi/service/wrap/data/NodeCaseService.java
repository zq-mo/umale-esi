/**
 * Project Name:umale
 * File Name:NodeCaseService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/20 13:46
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import com.citycloud.umale.esi.po.NodeCase;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className NodeCaseService
 * @description
 * @date 2019/5/20 13:46
 * @since JDK 1.8
 */
public interface NodeCaseService {

    int insertList(List<String> caseNums);
}
