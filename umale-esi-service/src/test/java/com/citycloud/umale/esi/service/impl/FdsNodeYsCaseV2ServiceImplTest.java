/**
 * Project Name:umale
 * File Name:FdsNodeYsCaseV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/21 14:51
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.NodeYscase;
import com.citycloud.umale.esi.po.Party;
import com.citycloud.umale.esi.service.province.FdsNodeYsCaseV2Service;
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
 * @className FdsNodeYsCaseV2ServiceImplTest
 * @description
 * @date 2019/5/21 14:51
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsNodeYsCaseV2ServiceImplTest {

    private final String jsonArray="[{\n" +
            "\t\t\"CASEID\": \"100\",\n" +
            "\t\t\"TYPE\": \"01\",\n" +
            "\t\t\"REPEALREASON\": \"当事人陈晏明到江干四季青中队接受了关于本案的《行政处罚决定书》。并于2018年10月30日 到指定银行缴纳了罚款。罚款收据号为：1515468127.当事人已改正违法行为。\",\n" +
            "\t\t\"NODENAME\": \"结案归档\",\n" +
            "\t\t\"WRITNUMBER\": \"\",\n" +
            "\t\t\"SYSDEPT\": \"\",\n" +
            "\t\t\"CASEINTRO\": \"\",\n" +
            "\t\t\"LEGALBASIS\": \"\",\n" +
            "\t\t\"EVIDENCEDATA\": \"\",\n" +
            "\t\t\"ENDTIME\": \"2018-12-25 16:24:08\",\n" +
            "\t\t\"CASEDEPTKEY\": \"001008001022021\",\n" +
            "\t\t\"CASEDEPTNAME\": \"江干区城管执法局\",\n" +
            "\t\t\"AREACODE\": \"330104\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"OPRATIONTIME\": \"2018-12-25 16:49:04\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
            "\t\t\"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "\t\t\"SYNC_STATUS\": \"I\",\n" +
            "\t\t\"CF_SJLY\": \"001008001022021\",\n" +
            "\t\t\"CF_SJLYDM\": \"江干区城管执法局\",\n" +
            "\t\t\"EXTEND_1\": \"\",\n" +
            "\t\t\"EXTEND_2\": \"\",\n" +
            "\t\t\"EXTEND_3\": \"\",\n" +
            "\t\t\"EXTEND_4\": \"\",\n" +
            "\t\t\"EXTEND_5\": \"\",\n" +
            "\t\t\"OP\": \"\",\n" +
            "\t\t\"TONG_TIME\": \"2018-12-25 17:38:03\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"CASEID\": \"101\",\n" +
            "\t\t\"TYPE\": \"01\",\n" +
            "\t\t\"REPEALREASON\": \"当事人曾功旺到江干四季青中队接受了关于本案的《行政处罚决定书》。并于2018年10月30日 到指定银行缴纳了罚款。罚款收据号为：1515440634.当事人已改正违法行为。\",\n" +
            "\t\t\"NODENAME\": \"结案归档\",\n" +
            "\t\t\"WRITNUMBER\": \"\",\n" +
            "\t\t\"SYSDEPT\": \"\",\n" +
            "\t\t\"CASEINTRO\": \"\",\n" +
            "\t\t\"LEGALBASIS\": \"\",\n" +
            "\t\t\"EVIDENCEDATA\": \"\",\n" +
            "\t\t\"ENDTIME\": \"2018-12-25 16:20:09\",\n" +
            "\t\t\"CASEDEPTKEY\": \"001008001022021\",\n" +
            "\t\t\"CASEDEPTNAME\": \"江干区城管执法局\",\n" +
            "\t\t\"AREACODE\": \"330104\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
            "\t\t\"OPRATIONTIME\": \"2018-12-25 16:49:21\",\n" +
            "\t\t\"FLAG\": \"0\",\n" +
            "\t\t\"DATAVERVISON\": \"50\",\n" +
            "\t\t\"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "\t\t\"SYNC_STATUS\": \"I\",\n" +
            "\t\t\"CF_SJLY\": \"001008001022021\",\n" +
            "\t\t\"CF_SJLYDM\": \"江干区城管执法局\",\n" +
            "\t\t\"EXTEND_1\": \"\",\n" +
            "\t\t\"EXTEND_2\": \"\",\n" +
            "\t\t\"EXTEND_3\": \"\",\n" +
            "\t\t\"EXTEND_4\": \"\",\n" +
            "\t\t\"EXTEND_5\": \"\",\n" +
            "\t\t\"OP\": \"\",\n" +
            "\t\t\"TONG_TIME\": \"2018-12-25 17:38:03\"\n" +
            "\t}\n" +
            "]";

    @Autowired
    private FdsNodeYsCaseV2Service fdsNodeYsCaseV2Service;

    @Test
    public  void insertListTest(){
        List<NodeYscase> poList = JSON.parseObject(jsonArray,new TypeReference<List<NodeYscase>>(){});

        int count = fdsNodeYsCaseV2Service.insertList(poList);
        System.out.println(count);

    }
}
