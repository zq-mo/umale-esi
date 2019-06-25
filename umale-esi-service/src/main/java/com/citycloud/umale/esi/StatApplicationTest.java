/**
 * Project Name:umale-maintenance
 * File Name:StatApplicationTest
 * Package Name:com.citycloud.umale.esi
 * Date: 2019/5/9 12:32
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi;

import com.alibaba.dubbo.config.annotation.Reference;
import com.citycloud.umale.esi.service.ExecuteExternalEndEventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yanLu
 * @version 1.0.0
 * @className StatApplicationTest
 * @description TODO
 * @date 2019/5/9 12:32
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UmaleEsiServiceApplication.class)
public class StatApplicationTest {
    @Reference
    ExecuteExternalEndEventService executeExternalEndEventService;
    @Test
    public void  test(){

        System.out.println("+++"+executeExternalEndEventService);
    }

}