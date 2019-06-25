/**
 * Project Name:umale-discipline
 * File Name:NodePunishdecideService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/17 17:00
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className NodePunishdecideService
 * @description TODO
 * @date 2019/5/17 17:00
 * @since JDK 1.8
 */
public interface NodePunishdecideService {
    /**
     * 插入
     */
    int insert(List<String> caseNums);
}
