/**
 * Project Name:umale
 * File Name:CaseWrapService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/17 10:17
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import com.citycloud.umale.esi.po.Case;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className CaseWrapService
 * @description
 * @date 2019/5/17 10:17
 * @since JDK 1.8
 */
public interface CaseWrapService {
    //根据案卷编号，返回发送到省政务中心的数据
    List<Case> getCaseWrapList(List<String> caseCodeList);

    int saveData(List<String> caseCodeList);//写入数据

}
