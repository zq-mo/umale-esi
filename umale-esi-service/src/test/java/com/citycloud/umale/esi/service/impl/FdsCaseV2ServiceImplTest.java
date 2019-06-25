/**
 * Project Name:umale
 * File Name:FdsCaseV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/15 14:40
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.Case;
import com.citycloud.umale.esi.service.impl.province.FdsCaseV2ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bridge
 * @className FdsCaseV2ServiceImplTest
 * @description
 * @date 2019/5/15 14:40
 * @since JDK 1.8
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsCaseV2ServiceImplTest {
    private static final String jsonString = "{\n" +
            "            \"CASEID\": \"330104551812259000008221\",\n" +
            "            \"TYPE\": \"2\",\n" +
            "            \"PASSWORD\": \"1340843\",\n" +
            "            \"CASEDEPTKEY\": \"001008001022021\",\n" +
            "            \"CASEDEPTNAME\": \"zhaoqiaotest\",\n" +
            "            \"PUBLICSTYLE\": \"0\",\n" +
            "            \"NOPUBLICINFO\": \"\",\n" +
            "            \"CASEHAPPENSOURCE\": \"在监督检查中发现\",\n" +
            "            \"CASENAME\": \"淮矿安徽物业服务有限责任公司杭州分公司未按要求设置生活垃圾收集容器案\",\n" +
//            "            \"CASEFINDTIME\": \"9/12/2018 15:10:00\",\n" +
            "            \"CASECONTENT\": \"2018年12月09日15时10分本机关执法人员查到，当事人淮矿安徽物业服务有限责任公司杭州分公司在东祥元府1幢旁设置三只黄色垃圾桶，上面没有分类垃圾标识，仅有一个投放垃圾的标识，不符合生活垃圾标识图案设置的规定。当事人作为生活垃圾分类投放管理负责人，未按要求设置生活垃圾收集容器。\",\n" +
            "            \"CASEMONEY\": \"0\",\n" +
            "            \"CASEOCCURADDR\": \"东祥元府1幢旁\",\n" +
//            "            \"CASEOCCURTIME\": \"9/12/2018 15:10:00\",\n" +
            "            \"HANDLEPEOPLENAMES\": \"谢国琴,陈强,傅婧,金敏华\",\n" +
            "            \"HANDLEPEOPLEUNIDS\": \"0103090339,300690,01030913120017,010390329\",\n" +
            "            \"CASEREGPEOPLE\": \"\",\n" +
//            "            \"CASEREGTIME\": \"20/12/2018 14:37:31\",\n" +
            "            \"POWERID\": \"c547222c-a2e8-42a5-8fd3-f55e10ab413d\",\n" +
            "            \"IS_SEND\": \"否\",\n" +
            "            \"CASE_TYPE\": \"\",\n" +
            "            \"INDUSTRY\": \"\",\n" +
            "            \"CASE_GUILTY\": \"\",\n" +
            "            \"FLAG\": \"0\",\n" +
            "            \"DATAVERVISON\": \"50\",\n" +
            "            \"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "            \"SYNC_STATUS\": \"I\",\n" +
            "            \"IS_LIANBAN\": \"否\",\n" +
            "            \"AREACODE\": \"330104\",\n" +
            "            \"CF_SJLY\": \"001008001022021\",\n" +
            "            \"CF_SJLYDM\": \"江干区城管执法局\",\n" +
            "            \"EXTEND_1\": \"\",\n" +
            "            \"EXTEND_2\": \"\",\n" +
            "            \"EXTEND_3\": \"\",\n" +
            "            \"EXTEND_4\": \"\",\n" +
            "            \"EXTEND_5\": \"\",\n" +
            "            \"OP\": \"\"\n" +
            "        }";
    private static final String jsonList = "[{\n" +
            "\t\"CASEID\": \"160\",\n" +
            "\t\"TYPE\": \"2\",\n" +
            "\t\"PASSWORD\": \"1340843\",\n" +
            "\t\"CASEDEPTKEY\": \"001008001022021\",\n" +
            "\t\"CASEDEPTNAME\": \"江干区城管执法局\",\n" +
            "\t\"PUBLICSTYLE\": \"0\",\n" +
            "\t\"NOPUBLICINFO\": \"\",\n" +
            "\t\"CASEHAPPENSOURCE\": \"在监督检查中发现\",\n" +
            "\t\"CASENAME\": \"淮矿安徽物业服务有限责任公司杭州分公司未按要求设置生活垃圾收集容器案\",\n" +
            "\t\"CASEFINDTIME\": \"2018-12-09 15:10:00\",\n" +
            "\t\"CASECONTENT\": \"2018年12月09日15时10分本机关执法人员查到，当事人淮矿安徽物业服务有限责任公司杭州分公司在东祥元府1幢旁设置三只黄色垃圾桶，上面没有分类垃圾标识，仅有一个投放垃圾的标识，不符合生活垃圾标识图案设置的规定。当事人作为生活垃圾分类投放管理负责人，未按要求设置生活垃圾收集容器。\",\n" +
            "\t\"CASEMONEY\": \"0\",\n" +
            "\t\"CASEOCCURADDR\": \"东祥元府1幢旁\",\n" +
            "\t\"CASEOCCURTIME\": \"2018-12-09 15:10:00\",\n" +
            "\t\"HANDLEPEOPLENAMES\": \"谢国琴,陈强,傅婧,金敏华\",\n" +
            "\t\"HANDLEPEOPLEUNIDS\": \"0103090339,300690,01030913120017,010390329\",\n" +
            "\t\"CASEREGPEOPLE\": \"\",\n" +
            "\t\"CASEREGTIME\": \"2018-12-20 14:37:31\",\n" +
            "\t\"POWERID\": \"c547222c-a2e8-42a5-8fd3-f55e10ab413d\",\n" +
            "\t\"IS_SEND\": \"否\",\n" +
            "\t\"CASE_TYPE\": \"\",\n" +
            "\t\"INDUSTRY\": \"\",\n" +
            "\t\"CASE_GUILTY\": \"\",\n" +
            "\t\"FLAG\": \"0\",\n" +
            "\t\"DATAVERVISON\": \"50\",\n" +
            "\t\"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "\t\"SYNC_STATUS\": \"I\",\n" +
            "\t\"IS_LIANBAN\": \"否\",\n" +
            "\t\"AREACODE\": \"330104\",\n" +
            "\t\"CF_SJLY\": \"001008001022021\",\n" +
            "\t\"CF_SJLYDM\": \"江干区城管执法局\",\n" +
            "\t\"EXTEND_1\": \"\",\n" +
            "\t\"EXTEND_2\": \"\",\n" +
            "\t\"EXTEND_3\": \"\",\n" +
            "\t\"EXTEND_4\": \"\",\n" +
            "\t\"EXTEND_5\": \"\",\n" +
            "\t\"OP\": \"\",\n" +
            "\t\"TONG_TIME\": \"2018-12-25 15:57:44\"\n" +
            "}, {\n" +
            "\t\"CASEID\": \"161\",\n" +
            "\t\"TYPE\": \"2\",\n" +
            "\t\"PASSWORD\": \"1340875\",\n" +
            "\t\"CASEDEPTKEY\": \"001008001022021\",\n" +
            "\t\"CASEDEPTNAME\": \"江干区城管执法局\",\n" +
            "\t\"PUBLICSTYLE\": \"0\",\n" +
            "\t\"NOPUBLICINFO\": \"\",\n" +
            "\t\"CASEHAPPENSOURCE\": \"在监督检查中发现\",\n" +
            "\t\"CASENAME\": \"袁同金运输工程渣土与准运证要求不符案\",\n" +
            "\t\"CASEFINDTIME\": \"2018-12-19 21:36:00\",\n" +
            "\t\"CASECONTENT\": \"2018年12月19日21时36分，我局江干直属中队执法人员通过在监督检查中发现，当事人袁同金在江干区钱江路与塘工局路交叉口路段运输工程渣土（建筑垃圾），经现场检查：现场有车牌号为浙A96376号的重型自卸货车壹辆，沿着江干区钱江路由东向西行驶，车上装有工程渣土（建筑垃圾），车厢用篷布覆盖，现场未造成抛洒泄漏。当事人现场出示了《杭州市工程渣土准运证》（编号：杭城管运〔2018〕江干00387），无法出示《杭州市建设工程渣土处置证》，根据《杭州市工程渣土准运证》持证须知第1条：本证随车携带，与处置证配套使用。当事人未能出示相配套的《杭州市建设工程渣土处置证》，运输工程渣土与准运证要求不符。\",\n" +
            "\t\"CASEMONEY\": \"0\",\n" +
            "\t\"CASEOCCURADDR\": \"江干区钱江路与塘工局路交叉口路段\",\n" +
            "\t\"CASEOCCURTIME\": \"2018-12-19 21:36:00\",\n" +
            "\t\"HANDLEPEOPLENAMES\": \"傅志敏,钱硕硕,沈丽,朱伟\",\n" +
            "\t\"HANDLEPEOPLEUNIDS\": \"0103090335,01030913120027,01030913120032,0103090415\",\n" +
            "\t\"CASEREGPEOPLE\": \"\",\n" +
            "\t\"CASEREGTIME\": \"2018-12-20 15:40:22\",\n" +
            "\t\"POWERID\": \"7eee6867-0e53-4454-b182-151afda24bd6\",\n" +
            "\t\"IS_SEND\": \"否\",\n" +
            "\t\"CASE_TYPE\": \"\",\n" +
            "\t\"INDUSTRY\": \"\",\n" +
            "\t\"CASE_GUILTY\": \"\",\n" +
            "\t\"FLAG\": \"0\",\n" +
            "\t\"DATAVERVISON\": \"50\",\n" +
            "\t\"BELONGTOSYSTEM\": \"33010153901\",\n" +
            "\t\"SYNC_STATUS\": \"I\",\n" +
            "\t\"IS_LIANBAN\": \"否\",\n" +
            "\t\"AREACODE\": \"330104\",\n" +
            "\t\"CF_SJLY\": \"001008001022021\",\n" +
            "\t\"CF_SJLYDM\": \"江干区城管执法局\",\n" +
            "\t\"EXTEND_1\": \"\",\n" +
            "\t\"EXTEND_2\": \"\",\n" +
            "\t\"EXTEND_3\": \"\",\n" +
            "\t\"EXTEND_4\": \"\",\n" +
            "\t\"EXTEND_5\": \"\",\n" +
            "\t\"OP\": \"\",\n" +
            "\t\"TONG_TIME\": \"2018-12-25 15:57:44\"\n" +
            "}]";
    @Autowired
    private FdsCaseV2ServiceImpl fdsCaseV2Service;

//    @Test
//    public void insertTest() {
//
//        Case po = JSON.parseObject(jsonString, new TypeReference<Case>() {
//        });
//        po.setCaseregtime(new Date());
//        po.setCasefindtime(new Date());
//        po.setCaseoccurtime(new Date());
//        int count = fdsCaseV2Service.insert(po);
//        System.out.println(count);
//    }

    @Test
    public void insertListTest() {

        List<Case> caseList = JSON.parseObject(jsonList, new TypeReference<ArrayList<Case>>() {
        });
        int count = fdsCaseV2Service.insertList(caseList);
        System.out.println(count);
    }
}
