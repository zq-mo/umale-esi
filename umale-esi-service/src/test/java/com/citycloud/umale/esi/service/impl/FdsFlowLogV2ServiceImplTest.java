/**
 * Project Name:umale
 * File Name:FdsFlowLogV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/16 16:52
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.FlowLog;
import com.citycloud.umale.esi.service.impl.province.FdsFlowLogV2ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author bridge
 * @className FdsFlowLogV2ServiceImplTest
 * @description
 * @date 2019/5/16 16:52
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsFlowLogV2ServiceImplTest {

    private static final String jsonString = "{\n" +
            "            \"SOURCEKEY\": \"1000\",\n" +
            "            \"CASEID\": \"111\",\n" +
            "            \"NODENAME\": \"11\",\n" +
            "            \"NODECODE\": \"1\",\n" +
            "            \"OPINION\": \"11\",\n" +
            "            \"CASEDEPTKEY\": \"11\",\n" +
            "            \"CASEDEPTNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11\",\n" +
            "            \"FLAG\": \"1\",\n" +
            "            \"DATAVERVISON\": \"1\",\n" +
            "            \"BELONGTOSYSTEM\": \"1\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"1\",\n" +
            "            \"CF_SJLYDM\": \"1\",\n" +
            "            \"EXTEND_1\": \"\",\n" +
            "            \"EXTEND_2\": \"\",\n" +
            "            \"EXTEND_3\": \"\",\n" +
            "            \"EXTEND_4\": \"\",\n" +
            "            \"EXTEND_5\": \"\",\n" +
            "            \"OP\": \"\",\n" +
            "            \"TONG_TIME\": \"2019-5-16 16:59:28\"\n" +
            "        }";
    private static final String jsonArray = "[\n" +
            "        {\n" +
            "            \"SOURCEKEY\": \"100001\",\n" +
            "            \"CASEID\": \"111\",\n" +
            "            \"NODENAME\": \"11\",\n" +
            "            \"NODECODE\": \"1\",\n" +
            "            \"OPINION\": \"11\",\n" +
            "            \"CASEDEPTKEY\": \"11\",\n" +
            "            \"CASEDEPTNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11\",\n" +
            "            \"FLAG\": \"1\",\n" +
            "            \"DATAVERVISON\": \"1\",\n" +
            "            \"BELONGTOSYSTEM\": \"1\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"1\",\n" +
            "            \"CF_SJLYDM\": \"1\",\n" +
            "            \"EXTEND_1\": \"\",\n" +
            "            \"EXTEND_2\": \"\",\n" +
            "            \"EXTEND_3\": \"\",\n" +
            "            \"EXTEND_4\": \"\",\n" +
            "            \"EXTEND_5\": \"\",\n" +
            "            \"OP\": \"\",\n" +
            "            \"TONG_TIME\": \"2019-5-16 16:59:28\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"SOURCEKEY\": \"4\",\n" +
            "            \"CASEID\": \"111\",\n" +
            "            \"NODENAME\": \"11\",\n" +
            "            \"NODECODE\": \"4\",\n" +
            "            \"OPINION\": \"11\",\n" +
            "            \"CASEDEPTKEY\": \"11\",\n" +
            "            \"CASEDEPTNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11\",\n" +
            "            \"FLAG\": \"1\",\n" +
            "            \"DATAVERVISON\": \"1\",\n" +
            "            \"BELONGTOSYSTEM\": \"1\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"1\",\n" +
            "            \"CF_SJLYDM\": \"1\",\n" +
            "            \"EXTEND_1\": \"\",\n" +
            "            \"EXTEND_2\": \"\",\n" +
            "            \"EXTEND_3\": \"\",\n" +
            "            \"EXTEND_4\": \"\",\n" +
            "            \"EXTEND_5\": \"\",\n" +
            "            \"OP\": \"\",\n" +
            "            \"TONG_TIME\": \"2019-5-16 16:59:28\"\n" +
            "        }\n" +
            "    ]";

    @Autowired
    private FdsFlowLogV2ServiceImpl fdsFlowLogV2Service;

//    @Test
//    public void insertTest(){
//        FlowLog po = JSON.parseObject(jsonString,new TypeReference<FlowLog>(){});
//        int count = fdsFlowLogV2Service.insert(po);
//        System.out.println(count);
//
//    }
    @Test
    public void insertList(){
        List<FlowLog> poList = JSON.parseObject(jsonArray,new TypeReference<List<FlowLog>>(){});
        int count = fdsFlowLogV2Service.insertList(poList);
        System.out.println(count);
    }
}
