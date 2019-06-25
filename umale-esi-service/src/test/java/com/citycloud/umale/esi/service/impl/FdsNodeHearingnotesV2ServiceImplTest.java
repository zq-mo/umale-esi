/**
 * Project Name:umale
 * File Name:FdsNodeHearingnotesV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/17 15:00
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.NodeHearingnotes;
import com.citycloud.umale.esi.service.impl.province.FdsNodeHearingnotesV2ServiceImpl;
import com.citycloud.umale.esi.service.province.FdsNodeHearingnotesV2Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodeHearingnotesV2ServiceImplTest
 * @description
 * @date 2019/5/17 15:00
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsNodeHearingnotesV2ServiceImplTest {

    private final String jsonString = "";
    private final String jsonArray = " [\n" +
            "        {\n" +
            "            \"SOURCEKEY\": \"107\",\n" +
            "            \"CASEID\": \"11\",\n" +
            "            \"WRITNUMBER\": \"111\",\n" +
            "            \"PARTYNAME\": \"111\",\n" +
            "            \"CASENAME\": \"11\",\n" +
            "            \"TIME\": \"2019-5-17 15:04:46\",\n" +
            "            \"ADDRESS\": \"11\",\n" +
            "            \"ISPUBLIC\": \"1\",\n" +
            "            \"REASON\": \"111\",\n" +
            "            \"EMCEE\": \"11\",\n" +
            "            \"EMCEEDUTY\": \"111\",\n" +
            "            \"OFFICER\": \"11\",\n" +
            "            \"OFFICERDUTY\": \"11\",\n" +
            "            \"CLERK\": \"11\",\n" +
            "            \"CLERKDUTY\": \"111\",\n" +
            "            \"REMARK\": \"11\",\n" +
            "            \"OPRATIONTIME\": \"2019-5-17 15:05:22\",\n" +
            "            \"ZFJGDZ\": \"11\",\n" +
            "            \"LXRXM\": \"11\",\n" +
            "            \"LXRDH\": \"11\",\n" +
            "            \"YZBM\": \"11\",\n" +
            "            \"CASEDEPTKEY\": \"11\",\n" +
            "            \"CASEDEPTNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11\",\n" +
            "            \"FLAG\": \"1\",\n" +
            "            \"DATAVERVISON\": \"11\",\n" +
            "            \"BELONGTOSYSTEM\": \"11\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"11\",\n" +
            "            \"CF_SJLYDM\": \"11\",\n" +
            "            \"EXTEND_1\": \"1\",\n" +
            "            \"EXTEND_2\": \"1\",\n" +
            "            \"EXTEND_3\": \"1\",\n" +
            "            \"EXTEND_4\": \"1\",\n" +
            "            \"EXTEND_5\": \"1\",\n" +
            "            \"OP\": \"11\",\n" +
            "            \"TONG_TIME\": \"2019-5-17 15:06:11\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"SOURCEKEY\": \"108\",\n" +
            "            \"CASEID\": \"11\",\n" +
            "            \"WRITNUMBER\": \"111\",\n" +
            "            \"PARTYNAME\": \"111\",\n" +
            "            \"CASENAME\": \"11\",\n" +
            "            \"TIME\": \"2019-5-17 15:04:46\",\n" +
            "            \"ADDRESS\": \"11\",\n" +
            "            \"ISPUBLIC\": \"1\",\n" +
            "            \"REASON\": \"111\",\n" +
            "            \"EMCEE\": \"11\",\n" +
            "            \"EMCEEDUTY\": \"111\",\n" +
            "            \"OFFICER\": \"11\",\n" +
            "            \"OFFICERDUTY\": \"11\",\n" +
            "            \"CLERK\": \"11\",\n" +
            "            \"CLERKDUTY\": \"111\",\n" +
            "            \"REMARK\": \"11\",\n" +
            "            \"OPRATIONTIME\": \"2019-5-17 15:05:22\",\n" +
            "            \"ZFJGDZ\": \"11\",\n" +
            "            \"LXRXM\": \"11\",\n" +
            "            \"LXRDH\": \"11\",\n" +
            "            \"YZBM\": \"11\",\n" +
            "            \"CASEDEPTKEY\": \"11\",\n" +
            "            \"CASEDEPTNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11\",\n" +
            "            \"FLAG\": \"1\",\n" +
            "            \"DATAVERVISON\": \"11\",\n" +
            "            \"BELONGTOSYSTEM\": \"11\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"11\",\n" +
            "            \"CF_SJLYDM\": \"11\",\n" +
            "            \"EXTEND_1\": \"1\",\n" +
            "            \"EXTEND_2\": \"1\",\n" +
            "            \"EXTEND_3\": \"1\",\n" +
            "            \"EXTEND_4\": \"1\",\n" +
            "            \"EXTEND_5\": \"1\",\n" +
            "            \"OP\": \"11\",\n" +
            "            \"TONG_TIME\": \"2019-5-17 15:06:11\"\n" +
            "        }\n" +
            "    ]";
    @Autowired
    private FdsNodeHearingnotesV2Service fdsNodeHearingnotesV2Service;

    @Test
    public void insertListTest() {
        List<NodeHearingnotes> po = JSON.parseObject(jsonArray, new TypeReference<List<NodeHearingnotes>>() {
        });
        int count = fdsNodeHearingnotesV2Service.insertList(po);
        System.out.println(count);
    }
}
