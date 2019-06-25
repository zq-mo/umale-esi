/**
 * Project Name:umale
 * File Name:FdsFileInfoV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/16 15:31
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.FileInfo;
import com.citycloud.umale.esi.service.impl.province.FdsFileInfoV2ServiceImpl;
import com.citycloud.umale.esi.service.province.FdsFileInfoV2Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsFileInfoV2ServiceImplTest
 * @description
 * @date 2019/5/16 15:31
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsFileInfoV2ServiceImplTest {

    private  static final String jsonString ="{\n" +
            "            \"FILEINFOID\": \"11122\",\n" +
            "            \"NODECODE\": \"1\",\n" +
            "            \"CASEID\": \"11\",\n" +
            "            \"NODENAME\": \"11\",\n" +
            "            \"NAME\": \"11\",\n" +
            "            \"FILEPATH\": \"11\",\n" +
            "            \"CREATETIME\": \"2019-5-14 17:33:39\",\n" +
            "            \"OPERATORID\": \"11\",\n" +
            "            \"OPERATORNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11\",\n" +
            "            \"FLAG\": \"1\",\n" +
            "            \"DATAVERVISON\": \"11\",\n" +
            "            \"BELONGTOSYSTEM\": \"11\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"11\",\n" +
            "            \"CF_SJLYDM\": \"11\",\n" +
            "            \"EXTEND_1\": \"11\",\n" +
            "            \"EXTEND_2\": \"11\",\n" +
            "            \"EXTEND_3\": \"11\",\n" +
            "            \"EXTEND_4\": \"11\",\n" +
            "            \"EXTEND_5\": \"1\",\n" +
            "            \"OP\": \"1\",\n" +
            "            \"TONG_TIME\": \"2019-5-14 17:32:26\"\n" +
            "        }";
    private  static final  String jsonArray="[\n" +
            "        {\n" +
            "            \"FILEINFOID\": \"100\",\n" +
            "            \"NODECODE\": \"1\",\n" +
            "            \"CASEID\": \"11\",\n" +
            "            \"NODENAME\": \"11\",\n" +
            "            \"NAME\": \"11\",\n" +
            "            \"FILEPATH\": \"11\",\n" +
            "            \"CREATETIME\": \"2019-5-14 17:33:39\",\n" +
            "            \"OPERATORID\": \"11\",\n" +
            "            \"OPERATORNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11\",\n" +
            "            \"FLAG\": \"1\",\n" +
            "            \"DATAVERVISON\": \"11\",\n" +
            "            \"BELONGTOSYSTEM\": \"11\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"11\",\n" +
            "            \"CF_SJLYDM\": \"11\",\n" +
            "            \"EXTEND_1\": \"11\",\n" +
            "            \"EXTEND_2\": \"11\",\n" +
            "            \"EXTEND_3\": \"11\",\n" +
            "            \"EXTEND_4\": \"11\",\n" +
            "            \"EXTEND_5\": \"1\",\n" +
            "            \"OP\": \"1\",\n" +
            "            \"TONG_TIME\": \"2019-5-14 17:32:26\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"FILEINFOID\": \"101\",\n" +
            "            \"NODECODE\": \"1\",\n" +
            "            \"CASEID\": \"11\",\n" +
            "            \"NODENAME\": \"11\",\n" +
            "            \"NAME\": \"11\",\n" +
            "            \"FILEPATH\": \"11\",\n" +
            "            \"CREATETIME\": \"2019-5-14 17:33:39\",\n" +
            "            \"OPERATORID\": \"11\",\n" +
            "            \"OPERATORNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11\",\n" +
            "            \"FLAG\": \"1\",\n" +
            "            \"DATAVERVISON\": \"11\",\n" +
            "            \"BELONGTOSYSTEM\": \"11\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"11\",\n" +
            "            \"CF_SJLYDM\": \"11\",\n" +
            "            \"EXTEND_1\": \"11\",\n" +
            "            \"EXTEND_2\": \"11\",\n" +
            "            \"EXTEND_3\": \"11\",\n" +
            "            \"EXTEND_4\": \"11\",\n" +
            "            \"EXTEND_5\": \"1\",\n" +
            "            \"OP\": \"1\",\n" +
            "            \"TONG_TIME\": \"2019-5-14 17:32:26\"\n" +
            "        }\n" +
            "    ]";

    @Autowired
    private FdsFileInfoV2Service fdsFileInfoV2Service;

//    @Test
//    public void insertTest(){
//        FileInfo po = JSON.parseObject(jsonString,new TypeReference<FileInfo>(){});
//        int count = fdsFileInfoV2Service.insert(po);
//        System.out.println(count);
//    }

    @Test
    public void insertListTest(){

        List<FileInfo> fileInfoList = JSON.parseObject(jsonArray,new TypeReference<List<FileInfo>>(){});
        int count = fdsFileInfoV2Service.insertList(fileInfoList);
        System.out.println(count);
    }
}
