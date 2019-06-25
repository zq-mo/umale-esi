/**
 * Project Name:umale-discipline
 * File Name:NodePunishimpartServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/20 9:44
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.bo.writ.PunishBeforeInfoBO;
import com.citycloud.umale.cases.service.writ.PunishBeforeInfoService;
import com.citycloud.umale.cases.vo.writ.PunishBeforeInfoVO;
import com.citycloud.umale.commons.util.StringUtils;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.NodePunishimpart;
import com.citycloud.umale.esi.service.province.FdsNodePunishimpartV2Service;
import com.citycloud.umale.esi.service.wrap.data.NodeHearingnotesService;
import com.citycloud.umale.esi.service.wrap.data.NodePunishimpartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className NodePunishimpartServiceImpl
 * @description TODO
 * @date 2019/5/20 9:44
 * @since JDK 1.8
 */
@Service(interfaceClass = NodePunishimpartService.class)
@Slf4j
public class NodePunishimpartServiceImpl implements NodePunishimpartService {
   @Reference
   PunishBeforeInfoService punishBeforeInfoService;
   @Autowired
    FdsNodePunishimpartV2Service fdsNodePunishimpartV2Service;
    @Override
    public int insert(List<String> caseNums) {

        List<PunishBeforeInfoVO> punishDecisionVOS = punishBeforeInfoService.getListByCaseNums(caseNums);
        if(punishDecisionVOS.size()==0){
            return 0;
        }
        return fdsNodePunishimpartV2Service.insertList(assemablefdsNodePunishimpart(punishDecisionVOS));

    }

    /**
     * 封装数据
     * @param punishDecisionVOS
     * @return
     */
    List<NodePunishimpart> assemablefdsNodePunishimpart(List<PunishBeforeInfoVO> punishDecisionVOS){

        List<NodePunishimpart>  nodePunishimparts = new ArrayList<>();
        for(PunishBeforeInfoVO punishBeforeInfoVO :punishDecisionVOS){

            NodePunishimpart nodePunishimpart = new NodePunishimpart();

            nodePunishimpart.setSourcekey(punishBeforeInfoVO.getId().toString());
            if(StringUtils.isEmpty(punishBeforeInfoVO.getCaseCode())){
                nodePunishimpart.setCaseid("undefine");
            }else{
                nodePunishimpart.setCaseid(punishBeforeInfoVO.getCaseCode());
            }
            if(StringUtils.isEmpty(punishBeforeInfoVO.getWritNum())){
                nodePunishimpart.setWritnumber("undefine");
            }else{
                nodePunishimpart.setWritnumber(punishBeforeInfoVO.getWritNum());
            }
            if(StringUtils.isEmpty(punishBeforeInfoVO.getLitigantName())){
                nodePunishimpart.setPartyname("undefine");
            }else{
                nodePunishimpart.setPartyname(punishBeforeInfoVO.getLitigantName());
            }

            nodePunishimpart.setApprizetime(punishBeforeInfoVO.getWritCreateTime());
            nodePunishimpart.setOprationtime(punishBeforeInfoVO.getCreateTime());
            if(StringUtils.isEmpty(punishBeforeInfoVO.getContact())){
                nodePunishimpart.setLxrdh("undefine");
            }else{
                nodePunishimpart.setLxrdh(punishBeforeInfoVO.getContactPhone());
            }
            if(StringUtils.isEmpty(punishBeforeInfoVO.getContact())){
                nodePunishimpart.setLxrxm("undefine");
            }else{
                nodePunishimpart.setLxrxm(punishBeforeInfoVO.getContact());
            }


            if(punishBeforeInfoVO.getWritCreateTime()==null){
                nodePunishimpart.setApprizetime(new Date());
            }else{
                nodePunishimpart.setApprizetime(punishBeforeInfoVO.getWritCreateTime());
            }

            nodePunishimpart.setCasedeptkey("undefine");

            nodePunishimpart.setCasedeptname(CaseV2.casedeptname);
            nodePunishimpart.setAreacode(CaseV2.areacode);
            nodePunishimpart.setFlag(CaseV2.flag);
            nodePunishimpart.setDatavervison(CaseV2.datavervison);
            nodePunishimpart.setBelongtosystem(CaseV2.belongtosystem);
            nodePunishimpart.setSync_status(CaseV2.sync_status);
            nodePunishimpart.setCf_sjly(CaseV2.cf_sjly);
            nodePunishimpart.setCf_sjlydm(CaseV2.cf_sjlydm);
            nodePunishimparts.add(nodePunishimpart);

        }
        return  nodePunishimparts;
    }
}
