/**
 * Project Name:umale
 * File Name:SaveDataService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/17 11:32
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
 * @className SaveDataService
 * @description
 * @date 2019/5/17 11:32
 * @since JDK 1.8
 */
public interface SaveDataService {
    void saveData(List<String> caseCodeNums,List<String> caseCodeList);
}
