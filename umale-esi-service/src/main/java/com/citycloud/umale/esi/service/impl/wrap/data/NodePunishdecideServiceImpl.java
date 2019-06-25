/**
 * Project Name:umale-discipline
 * File Name:NodePunishdecideServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl
 * Date: 2019/5/17 17:00
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.bo.writ.PunishBeforeInfoBO;
import com.citycloud.umale.cases.bo.writ.PunishDecisionBO;
import com.citycloud.umale.cases.service.writ.PunishBeforeInfoService;
import com.citycloud.umale.cases.service.writ.PunishDecisionService;
import com.citycloud.umale.cases.vo.writ.PunishBeforeInfoVO;
import com.citycloud.umale.cases.vo.writ.PunishDecisionVO;
import com.citycloud.umale.commons.util.StringUtils;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.NodePunishdecide;
import com.citycloud.umale.esi.service.province.FdsNodePunishdecideV2Service;
import com.citycloud.umale.esi.service.wrap.data.NodeHearingnotesService;
import com.citycloud.umale.esi.service.wrap.data.NodePunishdecideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className NodePunishdecideServiceImpl
 * @description TODO
 * @date 2019/5/17 17:00
 * @since JDK 1.8
 */
@Service(interfaceClass = NodePunishdecideService.class)
@Slf4j
public class NodePunishdecideServiceImpl implements NodePunishdecideService {

    @Reference
    PunishDecisionService punishDecisionService;

    @Autowired
    FdsNodePunishdecideV2Service fdsNodePunishdecideV2Service;

    @Override
    public int insert(List<String> caseNums) {
        /**
         * 获取List
         */
        List<PunishDecisionVO >punishDecisionVOS = punishDecisionService.getListByCaseNums(caseNums);
        if(punishDecisionVOS.size()==0){
            return 0;
        }
        return fdsNodePunishdecideV2Service.insertList(assemablefdsNodePunishDecide(punishDecisionVOS));
    }

    /**
     * 封装数据
     * @return
     */
    List<NodePunishdecide> assemablefdsNodePunishDecide(List<PunishDecisionVO> punishDecisionVOS){

        List<NodePunishdecide> nodePunishdecideList = new ArrayList<>();
        for(PunishDecisionVO punishDecisionVO :punishDecisionVOS){
            NodePunishdecide nodePunishdecide = new NodePunishdecide();
            nodePunishdecide.setSourcekey(punishDecisionVO.getId().toString());

            if (StringUtils.isEmpty(punishDecisionVO.getCaseCode())) {
                nodePunishdecide.setCaseid("undefine");
            }else{
                nodePunishdecide.setCaseid(punishDecisionVO.getCaseCode());
            }
            if(StringUtils.isEmpty(punishDecisionVO.getWritNum())){

                nodePunishdecide.setWritnumber("undefine");
            }else{
                nodePunishdecide.setWritnumber(punishDecisionVO.getWritNum());
            }
            if(StringUtils.isEmpty(punishDecisionVO.getLitigantName())){
                nodePunishdecide.setPartyname("undefine");
            }else{
                nodePunishdecide.setPartyname(punishDecisionVO.getLitigantName());
            }
            if(punishDecisionVO.getPunishMoney()==null){

                nodePunishdecide.setPunishmoney(0d);
            }else{
                nodePunishdecide.setPunishmoney(Double.valueOf(punishDecisionVO.getPunishMoney()));
            }
            if(StringUtils.isEmpty(punishDecisionVO.getLaw())){
                nodePunishdecide.setPunishcontent("undefine");
            }else{
                nodePunishdecide.setPunishcontent(punishDecisionVO.getLaw());
            }

            nodePunishdecide.setPunishdecidetime(punishDecisionVO.getPunishDecisionTime());
            if(StringUtils.isEmpty(punishDecisionVO.getPunishBasis())){
                nodePunishdecide.setLawbasis("undefine");
            }else{
                nodePunishdecide.setLawbasis(punishDecisionVO.getPunishBasis());
            }
            if(StringUtils.isEmpty(punishDecisionVO.getArguedOrgan())){

                nodePunishdecide.setFydz("undefine");
            }else{
                nodePunishdecide.setFydz(punishDecisionVO.getArguedOrgan());
            }
            if(StringUtils.isEmpty(punishDecisionVO.getBack())){
                nodePunishdecide.setJkdz("undefine");
            }else{
                nodePunishdecide.setJkdz(punishDecisionVO.getBack());
            }
            if(StringUtils.isEmpty(punishDecisionVO.getOrganCode())){

                nodePunishdecide.setJkzh("undefine");
            }else{
                nodePunishdecide.setJkzh(punishDecisionVO.getOrganCode());
            }

            nodePunishdecide.setOprationtime(punishDecisionVO.getCreateTime());

            nodePunishdecide.setNodename("undefine");
            nodePunishdecide.setPunishvaliddate("undefine");
            nodePunishdecide.setPublicdeadline("undefine");
            nodePunishdecide.setDiscretionid("undefine");
            nodePunishdecide.setDiscretionsn("undefine");
            nodePunishdecide.setCasedeptkey("undefine");


            nodePunishdecide.setCasedeptname(CaseV2.casedeptname);
            nodePunishdecide.setAreacode(CaseV2.areacode);
            nodePunishdecide.setFlag(CaseV2.flag);
            nodePunishdecide.setDatavervison(CaseV2.datavervison);
            nodePunishdecide.setBelongtosystem(CaseV2.belongtosystem);
            nodePunishdecide.setSync_status(CaseV2.sync_status);
            nodePunishdecide.setCf_sjly(CaseV2.cf_sjly);
            nodePunishdecide.setCf_sjlydm(CaseV2.cf_sjlydm);
            nodePunishdecideList.add(nodePunishdecide);
         }
         return nodePunishdecideList;
    }
}
