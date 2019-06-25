/**
 * Project Name:umale-discipline
 * File Name:NodeHearingnotesService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/17 16:15
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className NodeHearingnotesService
 * @description TODO
 * @date 2019/5/17 16:15
 * @since JDK 1.8
 */
public interface NodeHearingnotesService {
    /**
     * 插入
     */
    int insert(List<String> caseNums);
}
