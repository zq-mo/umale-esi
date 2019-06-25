/**
 * Project Name:umale
 * File Name:NodeYsCaseServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/23 10:07
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;/**
 * @author zq
 * @date 2019/5/23
 */

import com.citycloud.umale.esi.service.wrap.data.NodeYsCaseService;
import com.citycloud.umale.esi.service.wrap.data.PartyService;
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
 * @className NodeYsCaseServiceImplTest
 * @description
 * @date 2019/5/23 10:07
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class NodeYsCaseServiceImplTest {


    private final List<String> list = asList("84a4b35a35174182b4bf95a052347700", "cbe9616c7c6a41b0a58ab58751ccdc51");

    @Autowired
    private NodeYsCaseService caseWrapService;

    @Test
    public void saveDataTest() {
        int count = caseWrapService.insertList(list);
        System.out.println(count);
    }
}
