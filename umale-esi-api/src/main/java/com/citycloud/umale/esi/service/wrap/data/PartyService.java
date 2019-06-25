/**
 * Project Name:umale
 * File Name:PartyService
 * Package Name:com.citycloud.umale.esi.service.wrap.data
 * Date: 2019/5/20 16:32
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.wrap.data;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className PartyService
 * @description
 * @date 2019/5/20 16:32
 * @since JDK 1.8
 */
public interface PartyService {

    //注意，接受的值时案卷编号，不是uuid
    int insertList(List<String> caseCodes);
}
