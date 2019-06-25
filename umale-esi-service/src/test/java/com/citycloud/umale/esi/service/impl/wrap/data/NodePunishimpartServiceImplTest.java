/**
 * Project Name:umale
 * File Name:NodePunishimpartServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/23 14:13
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;/**
 * @author zq
 * @date 2019/5/23
 */

import com.citycloud.umale.esi.service.wrap.data.NodePunishdecideService;
import com.citycloud.umale.esi.service.wrap.data.NodePunishimpartService;
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
 * @className NodePunishimpartServiceImplTest
 * @description
 * @date 2019/5/23 14:13
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class NodePunishimpartServiceImplTest {

    private final List<String> list = asList("b5bac61efce144838e9ff109127e6490", "c787f29896884ed49dd57c70d7feb6c9");

    @Autowired
    private NodePunishimpartService caseWrapService;

    @Test
    public void saveDataTest() {
        int count = caseWrapService.insert(list);
        System.out.println(count);
    }
}
