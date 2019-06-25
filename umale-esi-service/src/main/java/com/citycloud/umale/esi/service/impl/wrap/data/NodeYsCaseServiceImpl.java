/**
 * Project Name:umale
 * File Name:NodeYsCaseServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/20 15:21
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.po.audit.AuditApproval;
import com.citycloud.umale.cases.service.audit.AuditService;
import com.citycloud.umale.commons.util.StringUtils;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.NodeYscase;
import com.citycloud.umale.esi.service.impl.commons.ListSplitUtil;
import com.citycloud.umale.esi.service.province.FdsNodeYsCaseV2Service;
import com.citycloud.umale.esi.service.wrap.data.NodeYsCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author bridge
 * @className NodeYsCaseServiceImpl
 * @description
 * @date 2019/5/20 15:21
 * @since JDK 1.8
 */
@Service(interfaceClass = NodeYsCaseService.class)
@Slf4j
public class NodeYsCaseServiceImpl implements NodeYsCaseService {

    private final int n = 10;
    @Reference
    private AuditService auditService;
    @Autowired
    private FdsNodeYsCaseV2Service fdsNodeYsCaseV2Service;

    public static List<AuditApproval> removeRepeat(List<AuditApproval> list) {
        List<AuditApproval> unique = list.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(AuditApproval::getCaseNum))), ArrayList::new)
        );
        return unique;
    }

    @Override
    public int insertList(List<String> caseNums) {

        int count = 0;
        List<NodeYscase> nodeYscaseList = getNodeCase(caseNums);
        int size = nodeYscaseList.size();
        if (size == 0) {
            return 0;
        }
        if (size > n) {
            List<List<NodeYscase>> splitList = ListSplitUtil.averageAssign(nodeYscaseList, n);
            for (List<NodeYscase> item : splitList) {
                int count1 = fdsNodeYsCaseV2Service.insertList(item);
                count = count + count1;
            }
        } else {
            count = fdsNodeYsCaseV2Service.insertList(nodeYscaseList);
        }
        return count;
    }

    private List<NodeYscase> getNodeCase(List<String> caseNums) {

        List<AuditApproval> audits1 = auditService.getAuditListByCaseNums2(caseNums);
        List <AuditApproval> audits = removeRepeat(audits1);
        List<NodeYscase> nodeYscaseList = new ArrayList<>();

        for (AuditApproval item : audits) {
            NodeYscase temp = new NodeYscase();
            wrapData(temp, item);
            nodeYscaseList.add(temp);
        }

        return nodeYscaseList;

    }

    private void wrapData(NodeYscase vo, AuditApproval po) {

        if (StringUtils.isEmpty(po.getCaseNum())) {
            vo.setCaseid("undefine");
        } else {
            vo.setCaseid(po.getCaseNum());
        }

        vo.setType(CaseV2.type);
        if (StringUtils.isEmpty(po.getStage())) {
            vo.setNodename("undefine");
        } else {
            vo.setNodename(po.getStage());
        }
        if (StringUtils.isEmpty(po.getAuditNum())) {
            vo.setWritnumber("undefine");
        } else {
            vo.setWritnumber(po.getAuditNum());
        }

        if (StringUtils.isEmpty(po.getOther())) {
            vo.setSysdept("undefine");
        } else {
            vo.setSysdept(po.getOther());
        }

        if (StringUtils.isEmpty(po.getCaseDescribe())) {
            vo.setCaseintro("undefine");
        } else {
            vo.setCaseintro(po.getCaseDescribe());
        }

        if (StringUtils.isEmpty(po.getEvidence())) {
            vo.setLegalbasis("undefine");
        } else {
            vo.setLegalbasis(po.getEvidence());
        }

        vo.setEndtime(po.getUpdateTime());

        vo.setOprationtime(po.getCreateTime());
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
