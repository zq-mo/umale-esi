/**
 * Project Name:umale
 * File Name:CaseWrapServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/21 15:21
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;/**
 * @author zq
 * @date 2019/5/21
 */

import com.citycloud.umale.esi.service.wrap.data.CaseWrapService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author bridge
 * @version
 * @className CaseWrapServiceImplTest
 * @description
 * @date 2019/5/21 15:21
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CaseWrapServiceImplTest {

    private final List<String> list = asList("2019052300276","123");

    @Autowired
    private CaseWrapService caseWrapService;

    @Test
    public void saveDataTest(){
        caseWrapService.saveData(list);
    }

}
