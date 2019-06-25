/**
 * Project Name:umale-discipline
 * File Name:NodeTakeevidenceService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/20 15:29
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className NodeTakeevidenceService
 * @description 调查取证接口
 * @date 2019/5/20 15:29
 * @since JDK 1.8
 */
public interface NodeTakeevidenceService {
    /**
     * 插入
     */
    int insert(List<String> caseNums);

}
