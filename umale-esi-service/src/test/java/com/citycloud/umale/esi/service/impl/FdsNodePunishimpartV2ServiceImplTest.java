/**
 * Project Name:umale
 * File Name:FdsNodePunishimpartV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/16 20:38
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;/**
 * @author zq
 * @date 2019/5/16
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.NodePunishimpart;
import com.citycloud.umale.esi.service.impl.province.FdsNodePunishimpartV2ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodePunishimpartV2ServiceImplTest
 * @description
 * @date 2019/5/16 20:38
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsNodePunishimpartV2ServiceImplTest {

    private static final String jsonString ="{\n" +
            "\t\t\"SOURCEKEY\": \"100\",\n" +
            "\t\t\"CASEID\": \"330103551812249000010\",\n" +
            "\t\t\"WRITNUMBER\": \"下城法罚告字[2018]第02554号\",\n" +
            "\t\t\"PARTYNAME\": \"邵明辉\",\n" +
            "\t\t\"APPRIZETIME\": \"2018-12-26 00:00:00\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"OPRATIONTIME\": \"2018-12-26 11:10:21\",\n" +
            "\t\t\"LXRXM\": \"\",\n" +
            "\t\t\"LXRDH\": \"\",\n" +
            "\t\t\"CASEDEPTKEY\": \"001008001023018\",\n" +
            "\t\t\"CASEDEPTNAME\": \"下城区城管执法局\",\n" +
            "\t\t\"AREACODE\": \"330103\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
            "\t\t\"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "\t\t\"SYNC_STATUS\": \"I\",\n" +
            "\t\t\"CF_SJLY\": \"001008001023018\",\n" +
            "\t\t\"CF_SJLYDM\": \"下城区城管执法局\",\n" +
            "\t\t\"EXTEND_1\": \"\",\n" +
            "\t\t\"EXTEND_2\": \"\",\n" +
            "\t\t\"EXTEND_3\": \"\",\n" +
            "\t\t\"EXTEND_4\": \"\",\n" +
            "\t\t\"EXTEND_5\": \"\",\n" +
            "\t\t\"OP\": \"\",\n" +
            "\t\t\"TONG_TIME\": \"2018-12-26 11:58:32\"\n" +
            "\t}";
    private static final String jsonArray = "[{\n" +
            "\t\t\"SOURCEKEY\": \"101\",\n" +
            "\t\t\"CASEID\": \"330103551812249000010\",\n" +
            "\t\t\"WRITNUMBER\": \"下城法罚告字[2018]第02554号\",\n" +
            "\t\t\"PARTYNAME\": \"邵明辉\",\n" +
            "\t\t\"APPRIZETIME\": \"2018-12-26 00:00:00\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"OPRATIONTIME\": \"2018-12-26 11:10:21\",\n" +
            "\t\t\"LXRXM\": \"\",\n" +
            "\t\t\"LXRDH\": \"\",\n" +
            "\t\t\"CASEDEPTKEY\": \"001008001023018\",\n" +
            "\t\t\"CASEDEPTNAME\": \"下城区城管执法局\",\n" +
            "\t\t\"AREACODE\": \"330103\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
            "\t\t\"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "\t\t\"SYNC_STATUS\": \"I\",\n" +
            "\t\t\"CF_SJLY\": \"001008001023018\",\n" +
            "\t\t\"CF_SJLYDM\": \"下城区城管执法局\",\n" +
            "\t\t\"EXTEND_1\": \"\",\n" +
            "\t\t\"EXTEND_2\": \"\",\n" +
            "\t\t\"EXTEND_3\": \"\",\n" +
            "\t\t\"EXTEND_4\": \"\",\n" +
            "\t\t\"EXTEND_5\": \"\",\n" +
            "\t\t\"OP\": \"\",\n" +
            "\t\t\"TONG_TIME\": \"2018-12-26 11:58:32\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"SOURCEKEY\": \"102\",\n" +
            "\t\t\"CASEID\": \"330106551812039000008\",\n" +
            "\t\t\"WRITNUMBER\": \"西城法罚告字[2018]第03800号\",\n" +
            "\t\t\"PARTYNAME\": \"潘秀玲（杭州市西湖区百果惠水果店）\",\n" +
            "\t\t\"APPRIZETIME\": \"2018-12-25 00:00:00\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"OPRATIONTIME\": \"2018-12-26 11:11:36\",\n" +
            "\t\t\"LXRXM\": \"\",\n" +
            "\t\t\"LXRDH\": \"\",\n" +
            "\t\t\"CASEDEPTKEY\": \"001008001024013\",\n" +
            "\t\t\"CASEDEPTNAME\": \"西湖区城管执法局\",\n" +
            "\t\t\"AREACODE\": \"330106\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
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
            "\t\t\"TONG_TIME\": \"2018-12-26 11:58:36\"\n" +
            "\t}\n" +
            "]";

    @Autowired
    private FdsNodePunishimpartV2ServiceImpl fdsNodePunishimpartV2Service;

    @Test
    public void insert(){
        NodePunishimpart po = JSON.parseObject(jsonString,new TypeReference<NodePunishimpart>(){});
        int count = fdsNodePunishimpartV2Service.insert(po);
        System.out.println(count);
    }

//    @Test
//    public void insertList(){
//        List<NodePunishimpart> poList = JSON.parseObject(jsonArray,new TypeReference<List<NodePunishimpart>>(){});
//        int count = fdsNodePunishimpartV2Service.insertList(poList);
//        System.out.println(count);
//    }




}
