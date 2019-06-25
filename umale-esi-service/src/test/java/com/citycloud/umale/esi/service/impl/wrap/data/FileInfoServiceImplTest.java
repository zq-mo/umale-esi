/**
 * Project Name:umale
 * File Name:FileInfoServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/21 18:11
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;/**
 * @author zq
 * @date 2019/5/21
 */

import com.citycloud.umale.esi.service.wrap.data.FileInfoService;
import com.citycloud.umale.esi.service.wrap.data.NodeCaseService;
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
 * @className FileInfoServiceImplTest
 * @description
 * @date 2019/5/21 18:11
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FileInfoServiceImplTest {

    private final List<String> list = asList("c9e9b1e73a524c5db42becdd794e66a6","4fa39f22aa4740ee9fbce7456ccc19bb");

    @Autowired
    private FileInfoService fileInfoService;

    @Test
    public void saveDataTest(){
        fileInfoService.insertList(list);
    }
}
