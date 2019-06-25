/**
 * Project Name:umale
 * File Name:NodeHearingnotesServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/23 11:22
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;/**
 * @author zq
 * @date 2019/5/23
 */

import com.citycloud.umale.esi.service.wrap.data.NodeCaseService;
import com.citycloud.umale.esi.service.wrap.data.NodeHearingnotesService;
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
 * @className NodeHearingnotesServiceImplTest
 * @description
 * @date 2019/5/23 11:22
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class NodeHearingnotesServiceImplTest {

    private final List<String> list = asList("2e2993c3bbc34d3c9cf0e72abfa2bc42", "4fa39f22aa4740ee9fbce7456ccc19bb");

    @Autowired
    private NodeHearingnotesService caseWrapService;

    @Test
    public void saveDataTest() {
        int count = caseWrapService.insert(list);
        System.out.println(count);
    }
}
