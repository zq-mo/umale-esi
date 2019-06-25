/**
 * Project Name:umale
 * File Name:FdsNodeTakeevidenceV2ServiceImplTest
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/17 15:27
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;/**
 * @author zq
 * @date 2019/5/17
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.esi.po.NodeTakeevidence;
import com.citycloud.umale.esi.service.province.FdsNodeTakeevidenceV2Service;
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
 * @className FdsNodeTakeevidenceV2ServiceImplTest
 * @description
 * @date 2019/5/17 15:27
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FdsNodeTakeevidenceV2ServiceImplTest {

    private final String jsonArray="[{\n" +
            "\t\t\"SOURCEKEY\": \"100\",\n" +
            "\t\t\"CASEID\": \"330104551812249000006\",\n" +
            "\t\t\"CASENAME\": \"胡中海运输工程渣土与准运证要求不符案\",\n" +
            "\t\t\"NODENAME\": \"调查取证\",\n" +
            "\t\t\"PARTYNAMES\": \"胡中海\",\n" +
            "\t\t\"STARTTIME\": \"2018-12-25 10:33:29\",\n" +
            "\t\t\"ENDTIME\": \"2018-12-25 10:31:05\",\n" +
            "\t\t\"SURVEYPERSONNAME\": \",刘建军,袁卿恬\",\n" +
            "\t\t\"SURVEYPERSONID\": \",0103090395,010309171\",\n" +
            "\t\t\"SURVEYPASS\": \"本案在监督检查中发现，于2018年12月24日立案，由袁卿恬、刘建军承办，经现场检查和调查询问，现案件调查终结。\",\n" +
            "\t\t\"FACT\": \"2018年12月13日10:30，我局江干丁桥中队执法人员在监督检查中发现，当事人胡中海在丁兰街道长睦路白马庄街西侧运输工程渣土，经现场检查：现场有车牌号为浙A3S692的绿色重型自卸货车壹辆，车上装有工程渣土，车厢用篷布覆盖，现场未造成抛洒泄漏。当事人现场出示了《杭州市工程渣土准运证》（编号：杭城管运〔2018〕江干00271），无法出示《杭州市建筑工程渣土处置证》，根据《杭州市工程渣土准运证》持证须知第1条：本证随车携带，与处置证配套使用。当事人未能出示相配套的《杭州市建筑工程渣土处置证》，运输工程渣土与准运证要求不符。认定本案事实的证据有取证照片2张，《现场笔录》1份，《调查询问笔录》1份，身份证复印件1份，车辆挂靠协议书1份，车辆行驶证1份，《杭州市工程渣土准运证》1份。\",\n" +
            "\t\t\"PUNISHOPINION\": \"责令改正，处2千至2万元罚款\",\n" +
            "\t\t\"OPRATIONTIME\": \"2018-12-25 10:31:05\",\n" +
            "\t\t\"XZHANDLEPERSON\": \"\",\n" +
            "\t\t\"XZHANDLEPERSONID\": \"\",\n" +
            "\t\t\"CASEDEPTKEY\": \"001008001022021\",\n" +
            "\t\t\"CASEDEPTNAME\": \"江干区城管执法局\",\n" +
            "\t\t\"AREACODE\": \"330104\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
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
            "\t\t\"TONG_TIME\": \"2018-12-25 11:59:18\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"SOURCEKEY\": \"101\",\n" +
            "\t\t\"CASEID\": \"330104551812259000004\",\n" +
            "\t\t\"CASENAME\": \"熊闪未取得营业执照从事经营活动案\",\n" +
            "\t\t\"NODENAME\": \"调查取证\",\n" +
            "\t\t\"PARTYNAMES\": \"熊闪\",\n" +
            "\t\t\"STARTTIME\": \"2018-12-25 11:10:18\",\n" +
            "\t\t\"ENDTIME\": \"2018-12-25 10:33:47\",\n" +
            "\t\t\"SURVEYPERSONNAME\": \",潘刘进,周晨静,方晓\",\n" +
            "\t\t\"SURVEYPERSONID\": \",01030913120021,01030913120005,0103090425\",\n" +
            "\t\t\"SURVEYPASS\": \"本案在 在监督检查中发现 于 2018年12月25日 立案，由 周晨静、潘刘进、方晓 承办，经调查取证，现案件调查终结。\",\n" +
            "\t\t\"FACT\": \"2018年12月13日18时30分我局江干笕桥中队执法队员通过在监督检查中发现，当事人熊闪在同协路笕新社区旁从事经营铁板烧烤活动。经查，现场有经营工具电动三轮车一辆、铁板烧烤具一套、煤气瓶一只，经营物品为羊肉串、鸡肉串、蔬菜串等，当事人未办理相关审批手续。当事人的行为违反了《无证无照经营查处办法》第二条的规定。认定本案事实的证据有取证照片1 张，《现场笔录》1份，《调查询问笔录》1份，当事人身份证复印件1份。\",\n" +
            "\t\t\"PUNISHOPINION\": \"责令改正，警告，没收违法所得，可没收无照经营物品，处违法经营额20%以下或5万元以下罚款；有屡教不改等严重情节的，可没收用于无照经营的工具、设备\",\n" +
            "\t\t\"OPRATIONTIME\": \"2018-12-25 10:33:47\",\n" +
            "\t\t\"XZHANDLEPERSON\": \"\",\n" +
            "\t\t\"XZHANDLEPERSONID\": \"\",\n" +
            "\t\t\"CASEDEPTKEY\": \"001008001022021\",\n" +
            "\t\t\"CASEDEPTNAME\": \"江干区城管执法局\",\n" +
            "\t\t\"AREACODE\": \"330104\",\n" +
            "\t\t\"REMARK\": \"\",\n" +
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
            "\t\t\"TONG_TIME\": \"2018-12-25 11:59:26\"\n" +
            "\t}\n" +
            "]";


    @Autowired
    private FdsNodeTakeevidenceV2Service fdsNodeTakeevidenceV2Service;

    @Test
    public void insertListTest(){
     List<NodeTakeevidence > poList = JSON.parseObject(jsonArray,new TypeReference<List<NodeTakeevidence>>(){});

     int count = fdsNodeTakeevidenceV2Service.insertList(poList);
     System.out.println(count);
    }


}
