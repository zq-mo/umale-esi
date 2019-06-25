/**
 * Project Name:umale
 * File Name:FdsPartyV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/17 16:49
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;/**
 * @author zq
 * @date 2019/5/17
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.Party;
import com.citycloud.umale.esi.service.province.FdsPartyV2Service;
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
 * @className FdsPartyV2ServiceImplTest
 * @description
 * @date 2019/5/17 16:49
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsPartyV2ServiceImplTest {

    private final String jsonArray="[{\n" +
            "\t\t\"SOURCEKEY\": \"100\",\n" +
            "\t\t\"CASEID\": \"330110551812269000011\",\n" +
            "\t\t\"USERTYPE\": \"1\",\n" +
            "\t\t\"JOB\": \"\",\n" +
            "\t\t\"USERNAME\": \"冯银根\",\n" +
            "\t\t\"USERSEX\": \"男\",\n" +
            "\t\t\"USERCARDTYPE\": \"31\",\n" +
            "\t\t\"USERCODE\": \"330125195911165431\",\n" +
            "\t\t\"OTHERCARDTYPE\": \"\",\n" +
            "\t\t\"OTHERCODE\": \"\",\n" +
            "\t\t\"DUTYPEOPLEPERSON\": \"\",\n" +
            "\t\t\"FDIDNUMBER\": \"330125195911165431\",\n" +
            "\t\t\"UNIT_PROPERTY\": \"\",\n" +
            "\t\t\"USERPHONE\": \"\",\n" +
            "\t\t\"USERADDRESS\": \"\",\n" +
            "\t\t\"PUBLICSTYLE\": \"0\",\n" +
            "\t\t\"NOPUBLICINFO\": \"\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
            "\t\t\"AREACODE\": \"330110\",\n" +
            "\t\t\"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "\t\t\"SYNC_STATUS\": \"I\",\n" +
            "\t\t\"CF_SJLY\": \"001008001008026\",\n" +
            "\t\t\"CF_SJLYDM\": \"余杭区城管执法局\",\n" +
            "\t\t\"EXTEND_1\": \"\",\n" +
            "\t\t\"EXTEND_2\": \"\",\n" +
            "\t\t\"EXTEND_3\": \"\",\n" +
            "\t\t\"EXTEND_4\": \"\",\n" +
            "\t\t\"EXTEND_5\": \"\",\n" +
            "\t\t\"OP\": \"\",\n" +
            "\t\t\"TONG_TIME\": \"2018-12-26 11:57:42\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"SOURCEKEY\": \"101\",\n" +
            "\t\t\"CASEID\": \"330106551812269000001\",\n" +
            "\t\t\"USERTYPE\": \"1\",\n" +
            "\t\t\"JOB\": \"\",\n" +
            "\t\t\"USERNAME\": \"刘子龙\",\n" +
            "\t\t\"USERSEX\": \"男\",\n" +
            "\t\t\"USERCARDTYPE\": \"31\",\n" +
            "\t\t\"USERCODE\": \"342127197307280818\",\n" +
            "\t\t\"OTHERCARDTYPE\": \"\",\n" +
            "\t\t\"OTHERCODE\": \"\",\n" +
            "\t\t\"DUTYPEOPLEPERSON\": \"\",\n" +
            "\t\t\"FDIDNUMBER\": \"342127197307280818\",\n" +
            "\t\t\"UNIT_PROPERTY\": \"\",\n" +
            "\t\t\"USERPHONE\": \"\",\n" +
            "\t\t\"USERADDRESS\": \"\",\n" +
            "\t\t\"PUBLICSTYLE\": \"0\",\n" +
            "\t\t\"NOPUBLICINFO\": \"\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
            "\t\t\"AREACODE\": \"330106\",\n" +
            "\t\t\"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "\t\t\"SYNC_STATUS\": \"I\",\n" +
            "\t\t\"CF_SJLY\": \"001008001024013\",\n" +
            "\t\t\"CF_SJLYDM\": \"西湖区城管执法局\",\n" +
            "\t\t\"EXTEND_1\": \"\",\n" +
            "\t\t\"EXTEND_2\": \"\",\n" +
            "\t\t\"EXTEND_3\": \"\",\n" +
            "\t\t\"EXTEND_4\": \"\",\n" +
            "\t\t\"EXTEND_5\": \"\",\n" +
            "\t\t\"OP\": \"\",\n" +
            "\t\t\"TONG_TIME\": \"2018-12-26 11:57:42\"\n" +
            "\t}\n" +
            "]";


    @Autowired
    private FdsPartyV2Service fdsPartyV2Service;

    @Test
    public void insertList(){

        List<Party> poList = JSON.parseObject(jsonArray,new TypeReference<List<Party>>(){});

        int count = fdsPartyV2Service.insertList(poList);
        System.out.println(count);

    }


}
