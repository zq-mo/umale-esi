/**
 * Project Name:umale
 * File Name:NodeCaseServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/20 13:47
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.citycloud.umale.cases.po.audit.Audit;
import com.citycloud.umale.cases.service.audit.AuditService;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.NodeCase;
import com.citycloud.umale.esi.service.impl.commons.ListSplitUtil;
import com.citycloud.umale.esi.service.province.FdsNodeCaseV2Service;
import com.citycloud.umale.esi.service.wrap.data.NodeCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bridge
 * @className NodeCaseServiceImpl
 * @description
 * @date 2019/5/20 13:47
 * @since JDK 1.8
 */
@Service(interfaceClass = NodeCaseService.class)
@Slf4j
public class NodeCaseServiceImpl implements NodeCaseService {
    private final int n = 10;

    @Reference
    private AuditService auditService;
    @Autowired
    private FdsNodeCaseV2Service fdsNodeCaseV2Service;


    @Override
    public int insertList(List<String> caseNums) {


        int count = 0;
        List<NodeCase> nodeCaseList = getNodeCase(caseNums);
        int size = nodeCaseList.size();

        if (size == 0) {
            return 0;
        }
        if (size > n) {
            List<List<NodeCase>> splitList = ListSplitUtil.averageAssign(nodeCaseList, n);
            for (List<NodeCase> item : splitList) {
                int count1 = fdsNodeCaseV2Service.insertList(item);
                count = count + count1;
            }
        } else {
            String json= JSON.toJSONString(nodeCaseList);
            System.out.println(json);
            count = fdsNodeCaseV2Service.insertList(nodeCaseList);
        }
        return count;

    }

    private List<NodeCase> getNodeCase(List<String> caseNums) {

        List<Audit> audits = auditService.getAuditListByCaseNums(caseNums);
        List<NodeCase> nodeCaseList = new ArrayList<>();

        for (Audit item : audits) {
            NodeCase temp = new NodeCase();
            wrapData(temp, item);
            nodeCaseList.add(temp);
        }

        return nodeCaseList;

    }

    private void wrapData(NodeCase vo, Audit po) {

        vo.setCaseid(po.getCaseNum());
        if (po.getCaseReason() == null) {
            vo.setNodename("undefine");
        } else {
            vo.setNodename(po.getStage());
        }
        if (po.getAuditNum() == null) {
            vo.setWritnumber("undefine");
        } else {
            vo.setWritnumber(po.getAuditNum());
        }
        if (po.getApprovalContent() == null) {
            vo.setHandleopinion("undefine");
        } else {
            vo.setHandleopinion(po.getApprovalContent());
        }
        if (po.getHandlerName() == null) {
            vo.setHandlepersons("undefine");
        } else {
            vo.setHandlepersons(po.getHandlerName());
        }
        if (po.getHandlerId() == null) {
            vo.setHandlepersonids("undefine");
        } else {
            vo.setHandlepersonids(po.getHandlerId());
        }

        vo.setCacetime(po.getUpdateTime());
        vo.setOprationtime(po.getCreateTime());

        vo.setCasename("undefine");

        vo.setCasedeptkey(CaseV2.casedeptkey);
        vo.setCasedeptname(CaseV2.casedeptname);


        vo.setFlag(CaseV2.flag);
        vo.setAreacode(CaseV2.areacode);
        vo.setDatavervison(CaseV2.datavervison);
        vo.setBelongtosystem(CaseV2.belongtosystem);
        vo.setSync_status(CaseV2.sync_status);
        vo.setCf_sjly(CaseV2.cf_sjly);
        vo.setCf_sjlydm(CaseV2.cf_sjlydm);
    }

}
