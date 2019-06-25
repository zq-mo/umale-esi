/**
 * Project Name:umale-discipline
 * File Name:NodeHearingnotesServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/17 16:16
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.bo.writ.HearInfoBO;
import com.citycloud.umale.cases.service.writ.HearInfoService;
import com.citycloud.umale.cases.vo.writ.HearInfoVO;
import com.citycloud.umale.commons.util.StringUtils;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.NodeHearingnotes;
import com.citycloud.umale.esi.service.province.FdsNodeHearingnotesV2Service;
import com.citycloud.umale.esi.service.wrap.data.CaseFloweLogsService;
import com.citycloud.umale.esi.service.wrap.data.NodeHearingnotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className NodeHearingnotesServiceImpl
 * @description TODO
 * @date 2019/5/17 16:16
 * @since JDK 1.8
 */
@Service(interfaceClass = NodeHearingnotesService.class)
@Slf4j
public class NodeHearingnotesServiceImpl implements NodeHearingnotesService{
    @Reference
    HearInfoService hearInfoService;
    @Autowired
    FdsNodeHearingnotesV2Service fdsNodeHearingnotesV2Service;
    @Override
    public int insert(List<String> caseNums) {

        /**
         * 拿到相关
         */
        List<HearInfoVO> list = hearInfoService.getListByCaseNums(caseNums);
        if(list.size()==0){
            return 0;
        }
        return fdsNodeHearingnotesV2Service.insertList(assemableNodeHearingNotes(list));
    }
    List<NodeHearingnotes>  assemableNodeHearingNotes( List<HearInfoVO> hearInfoVOS){
        List<NodeHearingnotes> nodeHearingnotesList = new ArrayList<>();
        for(HearInfoVO hearInfoVO : hearInfoVOS){

            NodeHearingnotes nodeHearingnotes = new NodeHearingnotes();

            nodeHearingnotes.setSourcekey(hearInfoVO.getId().toString());
            if(StringUtils.isEmpty(hearInfoVO.getCaseNum())){
                nodeHearingnotes.setCaseid("undefine");
            }else{
                nodeHearingnotes.setCaseid(hearInfoVO.getCaseNum());
            }
            if(StringUtils.isEmpty(hearInfoVO.getWritNum())){
                nodeHearingnotes.setWritnumber("undefine");
            }else{
                nodeHearingnotes.setWritnumber(hearInfoVO.getWritNum());
            }
            if(StringUtils.isEmpty(hearInfoVO.getLitigantName())){

                nodeHearingnotes.setPartyname(hearInfoVO.getLitigantName());
            }else{
                nodeHearingnotes.setPartyname(hearInfoVO.getLitigantName());
            }
            if(StringUtils.isEmpty(hearInfoVO.getReason())){
                nodeHearingnotes.setCasename("undefine");
            }else{
                nodeHearingnotes.setCasename(hearInfoVO.getReason());
            }
            nodeHearingnotes.setTime(hearInfoVO.getHearTime());
            if(StringUtils.isEmpty(hearInfoVO.getHearAddress())){
                nodeHearingnotes.setAddress("undefine");
            }else{
                nodeHearingnotes.setAddress(hearInfoVO.getHearAddress());
            }
            if(StringUtils.isEmpty(hearInfoVO.getHearWay())){

                //未定义
                nodeHearingnotes.setIspublic("1");
            }else{
                nodeHearingnotes.setIspublic(hearInfoVO.getHearWay().substring(0,1));
            }


            if(StringUtils.isEmpty(hearInfoVO.getHearPeople())){
                nodeHearingnotes.setEmcee("undefine");
            }else{
                nodeHearingnotes.setEmcee(hearInfoVO.getHearPeople());
            }
            if(StringUtils.isEmpty(hearInfoVO.getHearPeople())){

                nodeHearingnotes.setOfficer("undefine");
            }else{
                nodeHearingnotes.setOfficer(hearInfoVO.getHearPeople());
            }
            nodeHearingnotes.setOprationtime(hearInfoVO.getCreateTime());
            if(StringUtils.isEmpty(hearInfoVO.getContact())){
                nodeHearingnotes.setLxrdh("undefine");
            }else{
                nodeHearingnotes.setLxrdh(hearInfoVO.getContact());
            }
            if(StringUtils.isEmpty(hearInfoVO.getContactPhone())){
                nodeHearingnotes.setLxrxm("undefine");
            }else{
                nodeHearingnotes.setLxrxm(hearInfoVO.getContactPhone());
            }

            nodeHearingnotes.setCasedeptkey("");
            if(StringUtils.isEmpty(hearInfoVO.getReason())){
                nodeHearingnotes.setReason("undefine");
            }else{
                nodeHearingnotes.setReason(hearInfoVO.getReason());
            }

            nodeHearingnotes.setEmceeduty("undefine");
            nodeHearingnotes.setOfficerduty("undefine");
            nodeHearingnotes.setClerk("undefine");
            nodeHearingnotes.setZfjgdz("undefine");
            nodeHearingnotes.setCasedeptkey("undefine");

            nodeHearingnotes.setCasedeptname(CaseV2.casedeptname);
            nodeHearingnotes.setAreacode(CaseV2.areacode);
            nodeHearingnotes.setFlag(CaseV2.flag);
            nodeHearingnotes.setDatavervison(CaseV2.datavervison);
            nodeHearingnotes.setBelongtosystem(CaseV2.belongtosystem);
            nodeHearingnotes.setSync_status(CaseV2.sync_status);
            nodeHearingnotes.setCf_sjly(CaseV2.cf_sjly);
            nodeHearingnotes.setCf_sjlydm(CaseV2.cf_sjlydm);

            nodeHearingnotesList.add(nodeHearingnotes);
        }
        return  nodeHearingnotesList;

    }
}
