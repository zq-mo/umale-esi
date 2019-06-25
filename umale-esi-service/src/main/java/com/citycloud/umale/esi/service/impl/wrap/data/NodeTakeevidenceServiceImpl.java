/**
 * Project Name:umale-discipline
 * File Name:NodeTakeevidenceServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/20 15:31
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.service.writ.FinalSurveyReportService;
import com.citycloud.umale.cases.vo.writ.FinalSurveyReportVO;
import com.citycloud.umale.cases.vo.writ.PunishBeforeInfoVO;
import com.citycloud.umale.commons.util.StringUtils;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.NodeTakeevidence;
import com.citycloud.umale.esi.service.province.FdsNodeTakeevidenceV2Service;
import com.citycloud.umale.esi.service.wrap.data.NodeTakeevidenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className NodeTakeevidenceServiceImpl
 * @description TODO
 * @date 2019/5/20 15:31
 * @since JDK 1.8
 */
@Service(interfaceClass = NodeTakeevidenceService.class)
@Slf4j
public class NodeTakeevidenceServiceImpl implements NodeTakeevidenceService {

    @Reference
    FinalSurveyReportService finalSurveyReportService;
    @Autowired
    FdsNodeTakeevidenceV2Service fdsNodeTakeevidenceV2Service;

    @Override
    public int insert(List<String> caseNums) {

        List<FinalSurveyReportVO> finalSurveyReportVOS = finalSurveyReportService.getListByCaseNums(caseNums);
        if(finalSurveyReportVOS.size()==0){
            return 0;
        }
        return fdsNodeTakeevidenceV2Service.insertList(assemablefdsNodeTakeevidenc(finalSurveyReportVOS));


    }
    List<NodeTakeevidence> assemablefdsNodeTakeevidenc(List<FinalSurveyReportVO> finalSurveyReportVOS ){
        List<NodeTakeevidence> nodeTakeevidences = new ArrayList<>();
        for(FinalSurveyReportVO finalSurveyReportVO : finalSurveyReportVOS){
            NodeTakeevidence nodeTakeevidence = new NodeTakeevidence();
            nodeTakeevidence.setSourcekey(finalSurveyReportVO.getId().toString());


            if(StringUtils.isEmpty(finalSurveyReportVO.getCaseCode())){

                nodeTakeevidence.setCaseid("undefine");
            }else{
                nodeTakeevidence.setCaseid(finalSurveyReportVO.getCaseCode());
            }

            if(StringUtils.isEmpty(finalSurveyReportVO.getReason())){
                nodeTakeevidence.setCasename("undefine");
            }else{
                nodeTakeevidence.setCasename(finalSurveyReportVO.getReason());
            }

           //目前不确定
            nodeTakeevidence.setNodename("undefine");
            if(StringUtils.isEmpty(finalSurveyReportVO.getLitigantName())){
                nodeTakeevidence.setPartynames("undefine");
            }else{
                nodeTakeevidence.setPartynames(finalSurveyReportVO.getLitigantName());
            }
            if(StringUtils.isEmpty(finalSurveyReportVO.getHandlerNames())){
                nodeTakeevidence.setSurveypersonname("undefine");
            }else{
                nodeTakeevidence.setSurveypersonname(finalSurveyReportVO.getHandlerNames());
            }
            if(StringUtils.isEmpty(finalSurveyReportVO.getSurveyProcess())){
                nodeTakeevidence.setSurveypass("undefine");
            }else{
                nodeTakeevidence.setSurveypass(finalSurveyReportVO.getSurveyProcess());
            }
            if(StringUtils.isEmpty(finalSurveyReportVO.getInfringeFact())){
                nodeTakeevidence.setFact("undefine");
            }else{
                nodeTakeevidence.setFact(finalSurveyReportVO.getInfringeFact());
            }
            if(StringUtils.isEmpty(finalSurveyReportVO.getPunishSuggest())){

                nodeTakeevidence.setPunishopinion("undefine");
            }else{
                nodeTakeevidence.setPunishopinion(finalSurveyReportVO.getPunishSuggest());
            }

            nodeTakeevidence.setCasedeptkey("undefine");


            nodeTakeevidence.setOprationtime(finalSurveyReportVO.getCreateTime());
            nodeTakeevidence.setCasedeptname(CaseV2.casedeptname);
            nodeTakeevidence.setAreacode(CaseV2.areacode);
            nodeTakeevidence.setFlag(CaseV2.flag);
            nodeTakeevidence.setDatavervison(CaseV2.datavervison);
            nodeTakeevidence.setBelongtosystem(CaseV2.belongtosystem);
            nodeTakeevidence.setSync_status(CaseV2.sync_status);
            nodeTakeevidence.setCf_sjly(CaseV2.cf_sjly);
            nodeTakeevidence.setCf_sjlydm(CaseV2.cf_sjlydm);
            nodeTakeevidences.add(nodeTakeevidence);
        }
        return nodeTakeevidences;
    }
}
