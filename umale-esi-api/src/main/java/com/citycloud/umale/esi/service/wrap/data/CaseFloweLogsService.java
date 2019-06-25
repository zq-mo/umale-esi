/**
 * Project Name:umale-discipline
 * File Name:CaseFloweLogsService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/17 14:32
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import com.citycloud.umale.esi.po.FlowLog;
import java.util.List;
/**
 * @author li-jc
 * @version 1.0.0
 * @className CaseFloweLogsService
 * @description 案卷流程节点数据
 * @date 2019/5/17 14:32
 * @since JDK 1.8
 */
public interface CaseFloweLogsService {
    /**
     * 插入
     */
    int insert(List<String> caseNums);
}
