/**
 * Project Name:umale
 * File Name:CaseFloweLogsServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/23 10:51
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;/**
 * @author zq
 * @date 2019/5/23
 */

import com.citycloud.umale.esi.service.wrap.data.CaseFloweLogsService;
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
 * @className CaseFloweLogsServiceImplTest
 * @description
 * @date 2019/5/23 10:51
 * @since JDK 1.8
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CaseFloweLogsServiceImplTest {

    private final List<String> list = asList("abc81532aee94c53a2c790cdc56b50e3","b5bac61efce144838e9ff109127e6490");

    @Autowired
    private CaseFloweLogsService caseWrapService;

    @Test
    public void saveDataTest(){
        caseWrapService.insert(list);
    }
}
