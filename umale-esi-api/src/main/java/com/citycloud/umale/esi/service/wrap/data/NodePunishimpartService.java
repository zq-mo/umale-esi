/**
 * Project Name:umale-discipline
 * File Name:NodePunishimpartService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/20 9:41
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className NodePunishimpartService
 * @description 处罚告知
 * @date 2019/5/20 9:41
 * @since JDK 1.8
 */
public interface NodePunishimpartService {
    /**
     * 插入
     */
    int insert(List<String> caseNums);
}
