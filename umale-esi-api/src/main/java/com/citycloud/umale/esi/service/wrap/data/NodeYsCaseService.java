/**
 * Project Name:umale
 * File Name:NodeYsCaseService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/20 15:20
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className NodeYsCaseService
 * @description
 * @date 2019/5/20 15:20
 * @since JDK 1.8
 */
public interface NodeYsCaseService {

    //注意，该参数为uuid，不是案件编号
    int insertList(List<String> caseNums);
}
