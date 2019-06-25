/**
 * Project Name:umale
 * File Name:FdsNodePunishdecideV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/16 19:24
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.NodePunishdecide;
import com.citycloud.umale.esi.service.impl.province.FdsNodePunishdecideV2ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodePunishdecideV2ServiceImplTest
 * @description
 * @date 2019/5/16 19:24
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@WebAppConfiguration
public class FdsNodePunishdecideV2ServiceImplTest {

    private static final String jsonString = " {\n" +
            "            \"SOURCEKEY\": \"107\",\n" +
            "            \"CASEID\": \"1\",\n" +
            "            \"XZCFWS_NAME\": \"11\",\n" +
            "            \"NODENAME\": \"11\",\n" +
            "            \"WRITNUMBER\": \"11\",\n" +
            "            \"PARTYNAME\": \"11\",\n" +
            "            \"PUNISHMONEY\": \"111\",\n" +
            "            \"ILLEGALITYMONEY\": \"0\",\n" +
            "            \"REVOKELICENSE\": \"\",\n" +
            "            \"REVOKECODE\": \"\",\n" +
            "            \"PUNISHCONTENT\": \"1234455\",\n" +
            "            \"PUNISHDECIDETIME\": \"2019-5-16 19:31:27\",\n" +
            "            \"PUNISHVALIDDATE\": \"111\",\n" +
            "            \"PUBLICDEADLINE\": \"111\",\n" +
            "            \"LAWBASIS\": \"111\",\n" +
            "            \"DISCRETIONID\": \"111\",\n" +
            "            \"DISCRETIONSN\": \"11\",\n" +
            "            \"FYDZ\": \"1111\",\n" +
            "            \"JKDZ\": \"\",\n" +
            "            \"JKZH\": \"\",\n" +
            "            \"STANDARD_PUNISH_ID\": \"\",\n" +
            "            \"STANDARD_PUNISH_VERSION\": \"1\",\n" +
            "            \"REMARK\": \"\",\n" +
            "            \"OPRATIONTIME\": \"2019-5-16 19:32:29\",\n" +
            "            \"CASEDEPTKEY\": \"111\",\n" +
            "            \"AREACODE\": \"111\",\n" +
            "            \"CASEDEPTNAME\": \"111\",\n" +
            "            \"FLAG\": \"0\",\n" +
            "            \"DATAVERVISON\": \"50\",\n" +
            "            \"BELONGTOSYSTEM\": \"1111\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"1111\",\n" +
            "            \"CF_SJLYDM\": \"111\",\n" +
            "            \"EXTEND_1\": \"\",\n" +
            "            \"EXTEND_2\": \"\",\n" +
            "            \"EXTEND_3\": \"\",\n" +
            "            \"EXTEND_4\": \"\",\n" +
            "            \"EXTEND_5\": \"\",\n" +
            "            \"OP\": \"\",\n" +
            "            \"TONG_TIME\": \"2019-5-16 19:33:18\"\n" +
            "        }";
    private static final String jsonArray = "[{\n" +
            "\t\t\"SOURCEKEY\": \"108\",\n" +
            "\t\t\"CASEID\": \"1\",\n" +
            "\t\t\"XZCFWS_NAME\": \"11\",\n" +
            "\t\t\"NODENAME\": \"11\",\n" +
            "\t\t\"WRITNUMBER\": \"11\",\n" +
            "\t\t\"PARTYNAME\": \"11\",\n" +
            "\t\t\"PUNISHMONEY\": \"111\",\n" +
            "\t\t\"ILLEGALITYMONEY\": \"0\",\n" +
            "\t\t\"REVOKELICENSE\": \"\",\n" +
            "\t\t\"REVOKECODE\": \"\",\n" +
            "\t\t\"PUNISHCONTENT\": \"1234455\",\n" +
            "\t\t\"PUNISHDECIDETIME\": \"2019-5-16 19:31:27\",\n" +
            "\t\t\"PUNISHVALIDDATE\": \"111\",\n" +
            "\t\t\"PUBLICDEADLINE\": \"111\",\n" +
            "\t\t\"LAWBASIS\": \"111\",\n" +
            "\t\t\"DISCRETIONID\": \"111\",\n" +
            "\t\t\"DISCRETIONSN\": \"11\",\n" +
            "\t\t\"FYDZ\": \"1111\",\n" +
            "\t\t\"JKDZ\": \"\",\n" +
            "\t\t\"JKZH\": \"\",\n" +
            "\t\t\"STANDARD_PUNISH_ID\": \"\",\n" +
            "\t\t\"STANDARD_PUNISH_VERSION\": \"1\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"OPRATIONTIME\": \"2019-5-16 19:32:29\",\n" +
            "\t\t\"CASEDEPTKEY\": \"111\",\n" +
            "\t\t\"AREACODE\": \"111\",\n" +
            "\t\t\"CASEDEPTNAME\": \"111\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
            "\t\t\"BELONGTOSYSTEM\": \"1111\",\n" +
            "\t\t\"SYNC_STATUS\": \"1\",\n" +
            "\t\t\"CF_SJLY\": \"1111\",\n" +
            "\t\t\"CF_SJLYDM\": \"111\",\n" +
            "\t\t\"EXTEND_1\": \"\",\n" +
            "\t\t\"EXTEND_2\": \"\",\n" +
            "\t\t\"EXTEND_3\": \"\",\n" +
            "\t\t\"EXTEND_4\": \"\",\n" +
            "\t\t\"EXTEND_5\": \"\",\n" +
            "\t\t\"OP\": \"\",\n" +
            "\t\t\"TONG_TIME\": \"2019-5-16 19:33:18\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"SOURCEKEY\": \"104\",\n" +
            "\t\t\"CASEID\": \"1\",\n" +
            "\t\t\"XZCFWS_NAME\": \"11\",\n" +
            "\t\t\"NODENAME\": \"11\",\n" +
            "\t\t\"WRITNUMBER\": \"11\",\n" +
            "\t\t\"PARTYNAME\": \"11\",\n" +
            "\t\t\"PUNISHMONEY\": \"111\",\n" +
            "\t\t\"ILLEGALITYMONEY\": \"0\",\n" +
            "\t\t\"REVOKELICENSE\": \"\",\n" +
            "\t\t\"REVOKECODE\": \"\",\n" +
            "\t\t\"PUNISHCONTENT\": \"1234455\",\n" +
            "\t\t\"PUNISHDECIDETIME\": \"2019-5-16 19:31:27\",\n" +
            "\t\t\"PUNISHVALIDDATE\": \"111\",\n" +
            "\t\t\"PUBLICDEADLINE\": \"111\",\n" +
            "\t\t\"LAWBASIS\": \"111\",\n" +
            "\t\t\"DISCRETIONID\": \"111\",\n" +
            "\t\t\"DISCRETIONSN\": \"11\",\n" +
            "\t\t\"FYDZ\": \"1111\",\n" +
            "\t\t\"JKDZ\": \"\",\n" +
            "\t\t\"JKZH\": \"\",\n" +
            "\t\t\"STANDARD_PUNISH_ID\": \"\",\n" +
            "\t\t\"STANDARD_PUNISH_VERSION\": \"1\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"OPRATIONTIME\": \"2019-5-16 19:32:29\",\n" +
            "\t\t\"CASEDEPTKEY\": \"111\",\n" +
            "\t\t\"AREACODE\": \"111\",\n" +
            "\t\t\"CASEDEPTNAME\": \"111\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
            "\t\t\"BELONGTOSYSTEM\": \"1111\",\n" +
            "\t\t\"SYNC_STATUS\": \"1\",\n" +
            "\t\t\"CF_SJLY\": \"1111\",\n" +
            "\t\t\"CF_SJLYDM\": \"111\",\n" +
            "\t\t\"EXTEND_1\": \"\",\n" +
            "\t\t\"EXTEND_2\": \"\",\n" +
            "\t\t\"EXTEND_3\": \"\",\n" +
            "\t\t\"EXTEND_4\": \"\",\n" +
            "\t\t\"EXTEND_5\": \"\",\n" +
            "\t\t\"OP\": \"\",\n" +
            "\t\t\"TONG_TIME\": \"2019-5-16 19:33:18\"\n" +
            "\t}\n" +
            "]";

    @Autowired
    private FdsNodePunishdecideV2ServiceImpl fdsNodePunishdecideV2Service;


    @Test
    public void insert() {

        NodePunishdecide po = JSON.parseObject(jsonString, new TypeReference<NodePunishdecide>() {
        });
        int count = fdsNodePunishdecideV2Service.insert(po);
        System.out.println(count);

    }

    @Test
    public void insertList() {
        List<NodePunishdecide> poList = JSON.parseObject(jsonArray, new TypeReference<List<NodePunishdecide>>() {
        });
        int count = fdsNodePunishdecideV2Service.insertList(poList);
        System.out.println(count);

    }
}
