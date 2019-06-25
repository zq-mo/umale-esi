/**
 * Project Name:umale-discipline
 * File Name:CaseFloweLogsServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/17 14:37
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.po.activiti.CaseFlowtimeEnd;
import com.citycloud.umale.cases.service.activiti.CaseFlowtimeEndService;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.FlowLog;
import com.citycloud.umale.esi.service.impl.commons.ListSplitUtil;
import com.citycloud.umale.esi.service.province.FdsFlowLogV2Service;
import com.citycloud.umale.esi.service.wrap.data.CaseFloweLogsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className CaseFloweLogsServiceImpl
 * @description 案卷流转记录
 * @date 2019/5/17 14:37
 * @since JDK 1.8
 */
@Service(interfaceClass = CaseFloweLogsService.class)
@Slf4j
public class CaseFloweLogsServiceImpl implements CaseFloweLogsService {
    /**
     * 定义切片
     */
    private final int n = 10;

    @Autowired
    FdsFlowLogV2Service fdsFlowLogV2Service;
    @Reference
    CaseFlowtimeEndService caseFlowtimeEndService;

    @Override
    public int insert(List<String> caseNums) {
        int count = 0;
        /**
         * 调取服务获取已经结案的流程
         */
        List<CaseFlowtimeEnd> caseFlowtimeEndList = caseFlowtimeEndService.getCaseFLowTimeEndByCaseNums(caseNums);
        /**
         * 封装数据
         */
        List<FlowLog> flowLogs = assemableFlowLog(caseFlowtimeEndList);
        /**
         * 保存到数据库中
         */
        int size = flowLogs.size();
        if (size == 0) {
            return 0;
        }
        if (size > n) {
            List<List<FlowLog>> splitList = ListSplitUtil.averageAssign(flowLogs, n);
            for (List<FlowLog> item : splitList) {
                int count1 = fdsFlowLogV2Service.insertList(item);
                count = count + count1;
            }
        } else {
            count = fdsFlowLogV2Service.insertList(flowLogs);
        }
        return count;
    }

    /**
     * 封装相关的操作流程日志
     *
     * @param caseFlowtimeEndList
     * @return
     */
    List<FlowLog> assemableFlowLog(List<CaseFlowtimeEnd> caseFlowtimeEndList) {
        List<FlowLog> flowLogs = new ArrayList<>();
        for (CaseFlowtimeEnd caseFlowtimeEnd : caseFlowtimeEndList) {
            FlowLog flowLog = new FlowLog();
            if(caseFlowtimeEnd.getId()==null){
                flowLog.setSourcekey("undefine");
            }else{
                flowLog.setSourcekey(caseFlowtimeEnd.getId().toString());
            }

            if(caseFlowtimeEnd.getCaseNum()==null){
                flowLog.setCaseid("undefine");
            }else{
                flowLog.setCaseid(caseFlowtimeEnd.getCaseNum());
            }
            if(caseFlowtimeEnd.getNodeId()==null){
                //表示未定义
                flowLog.setNodecode("1");
            }else{
                //nodecode最大值是1
                flowLog.setNodecode(caseFlowtimeEnd.getNodeId().substring(0,1));
            }

            if(caseFlowtimeEnd.getNodeName()==null){
                flowLog.setNodename("undefine");
            }else{
                flowLog.setNodename(caseFlowtimeEnd.getNodeName());
            }


            flowLog.setOpinion(CaseV2.opinion);
            if(caseFlowtimeEnd.getRoleId()==null){
                flowLog.setCasedeptkey("undefine");
            }else{
                flowLog.setCasedeptkey(caseFlowtimeEnd.getRoleId());
            }

            flowLog.setCasedeptname(CaseV2.casedeptname);
            flowLog.setAreacode(CaseV2.areacode);
            flowLog.setFlag(CaseV2.flag);
            flowLog.setDatavervison(CaseV2.datavervison);
            flowLog.setBelongtosystem(CaseV2.belongtosystem);
            flowLog.setSync_status(CaseV2.sync_status);
            flowLog.setCf_sjly(CaseV2.cf_sjly);
            flowLog.setCf_sjlydm(CaseV2.cf_sjlydm);
            flowLogs.add(flowLog);

        }
        return flowLogs;

    }
}
