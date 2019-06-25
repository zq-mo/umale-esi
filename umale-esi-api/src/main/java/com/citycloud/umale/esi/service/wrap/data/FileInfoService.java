/**
 * Project Name:umale
 * File Name:FileInfoService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/17 18:05
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;/**
 * @author zq
 * @date 2019/5/17
 */

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FileInfoService
 * @description
 * @date 2019/5/17 18:05
 * @since JDK 1.8
 */
public interface FileInfoService {
    //该编号为case的uuid
    int insertList(List<String> caseCode);
}
