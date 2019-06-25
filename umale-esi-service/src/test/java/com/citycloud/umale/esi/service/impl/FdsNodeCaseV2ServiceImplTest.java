/**
 * Project Name:umale
 * File Name:FdsNodeCaseV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/16 17:20
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.NodeCase;
import com.citycloud.umale.esi.service.impl.province.FdsNodeCaseV2ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodeCaseV2ServiceImplTest
 * @description
 * @date 2019/5/16 17:20
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsNodeCaseV2ServiceImplTest {

    private static final String jsonString = "{\n" +
            "            \"CASEID\": \"101\",\n" +
            "            \"CASENAME\": \"111\",\n" +
            "            \"NODENAME\": \"11\",\n" +
            "            \"WRITNUMBER\": \"11\",\n" +
            "            \"HANDLEOPINION\": \"111\",\n" +
            "            \"HANDLEPERSONS\": \"11\",\n" +
            "            \"HANDLEPERSONIDS\": \"11\",\n" +
            "            \"CACETIME\": \"2019-5-16 17:27:38\",\n" +
            "            \"REMARK\": \"11\",\n" +
            "            \"OPRATIONTIME\": \"2019-5-16 17:27:49\",\n" +
            "            \"XZHANDLEPERSON\": \"11\",\n" +
            "            \"XZHANDLEPERSONID\": \"11\",\n" +
            "            \"CASEDEPTKEY\": \"11\",\n" +
            "            \"CASEDEPTNAME\": \"11\",\n" +
            "            \"AREACODE\": \"11111\",\n" +
            "            \"FLAG\": \"0\",\n" +
            "            \"DATAVERVISON\": \"12\",\n" +
            "            \"BELONGTOSYSTEM\": \"111\",\n" +
            "            \"SYNC_STATUS\": \"1\",\n" +
            "            \"CF_SJLY\": \"11\",\n" +
            "            \"CF_SJLYDM\": \"11\",\n" +
            "            \"EXTEND_1\": \"\",\n" +
            "            \"EXTEND_2\": \"\",\n" +
            "            \"EXTEND_3\": \"\",\n" +
            "            \"EXTEND_4\": \"\",\n" +
            "            \"EXTEND_5\": \"\",\n" +
            "            \"OP\": \"\",\n" +
            "            \"TONG_TIME\": \"2019-5-16 17:28:49\"\n" +
            "        }";
    private static final String jsonArray = "[{\n" +
            "\t\"areacode\": \"undefine\",\n" +
            "\t\"belongtosystem\": \"undefine\",\n" +
            "\t\"cacetime\": 1557324396000,\n" +
            "\t\"casedeptkey\": \"undefine\",\n" +
            "\t\"casedeptname\": \"undefine\",\n" +
            "\t\"caseid\": \"8934df90b15f4f13a2941e82e8547110\",\n" +
            "\t\"casename\": \"undefine\",\n" +
            "\t\"cf_sjly\": \"undefine\",\n" +
            "\t\"cf_sjlydm\": \"undefine\",\n" +
            "\t\"datavervison\": 1,\n" +
            "\t\"flag\": \"1\",\n" +
            "\t\"handleopinion\": \"undefine\",\n" +
            "\t\"handlepersonids\": \"88,78399763,35488,15056135,5505\",\n" +
            "\t\"handlepersons\": \"宋胜华,杨文俊,夏利成,中队人员yan4(执法队员),yantest(内勤)\",\n" +
            "\t\"nodename\": \"over\",\n" +
            "\t\"oprationtime\": 1554367701000,\n" +
            "\t\"sync_status\": \"1\",\n" +
            "\t\"writnumber\": \"DOCH01\"\n" +
            "}, {\n" +
            "\t\"areacode\": \"undefine\",\n" +
            "\t\"belongtosystem\": \"undefine\",\n" +
            "\t\"cacetime\": 1557324396000,\n" +
            "\t\"casedeptkey\": \"undefine\",\n" +
            "\t\"casedeptname\": \"undefine\",\n" +
            "\t\"caseid\": \"87a8347200de4e9b87449749d1c122eb\",\n" +
            "\t\"casename\": \"undefine\",\n" +
            "\t\"cf_sjly\": \"undefine\",\n" +
            "\t\"cf_sjlydm\": \"undefine\",\n" +
            "\t\"datavervison\": 1,\n" +
            "\t\"flag\": \"1\",\n" +
            "\t\"handleopinion\": \"undefine\",\n" +
            "\t\"handlepersonids\": \"88,5505\",\n" +
            "\t\"handlepersons\": \"中队人员yan4(执法队员),yantest(内勤)\",\n" +
            "\t\"nodename\": \"over\",\n" +
            "\t\"oprationtime\": 1554690787000,\n" +
            "\t\"sync_status\": \"1\",\n" +
            "\t\"writnumber\": \"DOCH01\"\n" +
            "}]";
    @Autowired
    private FdsNodeCaseV2ServiceImpl fdsNodeCaseV2Service;

//    @Test
//    public void insetTest(){
//        NodeCase po = JSON.parseObject(jsonString,new TypeReference<NodeCase>(){});
//        int count = fdsNodeCaseV2Service.insert(po);
//        System.out.println(count);
//    }
    @Test
    public void insertListTest(){
        List<NodeCase> poList = JSON.parseObject(jsonArray,new TypeReference<List<NodeCase>>(){});
        int count = fdsNodeCaseV2Service.insertList(poList);
        System.out.println(count);
    }
}
