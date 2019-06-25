/**
 * Project Name:umale
 * File Name:PartyServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/20 16:33
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.service.cases.CaseOnLineService;
import com.citycloud.umale.cases.vo.CaseOnLineDetailVO;
import com.citycloud.umale.commons.util.StringUtils;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.Party;
import com.citycloud.umale.esi.service.impl.commons.ListSplitUtil;
import com.citycloud.umale.esi.service.province.FdsPartyV2Service;
import com.citycloud.umale.esi.service.wrap.data.PartyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bridge
 * @className PartyServiceImpl
 * @description
 * @date 2019/5/20 16:33
 * @since JDK 1.8
 */
@Service(interfaceClass = PartyService.class)
@Slf4j
public class PartyServiceImpl implements PartyService {


    private final int n = 10;
    @Reference
    private CaseOnLineService caseOnLineService;
    @Autowired
    private FdsPartyV2Service fdsPartyV2Service;

    @Override
    public int insertList(List<String> caseCodeList) {

        int count = 0;
        List<Party> partyList = getNodeCase(caseCodeList);
        int size = partyList.size();
        if(size==0){
            return 0;
        }
        if (size > n) {
            List<List<Party>> splitList = ListSplitUtil.averageAssign(partyList, n);
            for (List<Party> item : splitList) {
                int count1 = fdsPartyV2Service.insertList(item);
                count = count + count1;
            }
        } else {
            count = fdsPartyV2Service.insertList(partyList);
        }
        return count;
    }

    private List<Party> getNodeCase(List<String> caseNums) {

        List<CaseOnLineDetailVO> caseOnLineDetailVOList = caseOnLineService.getListByCaseCode(caseNums);
        List<Party> partyList = new ArrayList<>();

        for (CaseOnLineDetailVO item : caseOnLineDetailVOList) {
            Party temp = new Party();
            wrapData(temp, item);
            partyList.add(temp);
        }

        return partyList;

    }

    private void wrapData(Party vo, CaseOnLineDetailVO po) {

        vo.setSourcekey(po.getId().toString());
        vo.setCaseid(po.getCaseNum());
        vo.setUsertype(po.getLitigantType().toString());
        if(StringUtils.isEmpty(po.getPosition())){

            vo.setJob("undefine");
        }else{
            vo.setJob(po.getPosition());
        }
        if(StringUtils.isEmpty(po.getLitigantName())){
            vo.setUsername("undefine");
        }else{
            vo.setUsername(po.getLitigantName());
        }

        if(po.getSex()==0||po.getSex()==null){
            vo.setUsersex("0");
        }else {
            vo.setUsersex(po.getSex().toString());
        }
        if(po.getCardType()==null){
            vo.setUsercardtype("undefine");
        }else{
            vo.setUsercardtype(po.getCardType().toString());
        }

        if(StringUtils.isEmpty(po.getLitigantCode())){
            vo.setUsercode("undefine");
        }else {
            vo.setUsercode(po.getLitigantCode());
        }

        if(StringUtils.isEmpty(po.getLegalPersonName())){
            vo.setDutypeopleperson("undefine");
        }else{
            vo.setDutypeopleperson(po.getLegalPersonName());
        }


        if(StringUtils.isEmpty(po.getLitigantCode())){
            vo.setFdidnumber("undefine");
        }else {
            vo.setFdidnumber(po.getLitigantCode());
        }

        if(StringUtils.isEmpty(po.getPhone())){
            vo.setUserphone("undefine");
        }else{
            vo.setUserphone(po.getPhone());
        }

        if(StringUtils.isEmpty(po.getAddress())){
            vo.setUseraddress("undefine");
        }else{
            vo.setUseraddress(po.getAddress());
        }


        vo.setPublicstyle(CaseV2.publicstyle);

        vo.setFlag(CaseV2.flag);
        vo.setAreacode(CaseV2.areacode);
        vo.setDatavervison(CaseV2.datavervison);
        vo.setBelongtosystem(CaseV2.belongtosystem);
        vo.setSync_status(CaseV2.sync_status);
        vo.setCf_sjly(CaseV2.cf_sjly);
        vo.setCf_sjlydm(CaseV2.cf_sjlydm);
    }

}
