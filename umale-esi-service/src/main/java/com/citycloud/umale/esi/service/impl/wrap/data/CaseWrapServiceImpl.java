/**
 * Project Name:umale
 * File Name:CaseWrapServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/17 10:16
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.cases.service.cases.CaseOnLineService;
import com.citycloud.umale.cases.vo.CaseOnLineDetailVO;
import com.citycloud.umale.esi.constant.CaseV2;
import com.citycloud.umale.esi.po.Case;
import com.citycloud.umale.esi.service.impl.commons.ListSplitUtil;
import com.citycloud.umale.esi.service.province.FdsCaseV2Service;
import com.citycloud.umale.esi.service.wrap.data.CaseWrapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bridge
 * @className CaseWrapServiceImpl
 * @description
 * @date 2019/5/17 10:16
 * @since JDK 1.8
 */
@Service(interfaceClass = CaseWrapService.class)
@Slf4j
public class CaseWrapServiceImpl implements CaseWrapService {

    private final int n = 10;


    @Reference
    private CaseOnLineService caseOnLineService;

    @Autowired
    private FdsCaseV2Service fdsCaseV2Service;

    @Override
    public List<Case> getCaseWrapList(List<String> caseCodeList) {

        List<Case> caseList = new ArrayList<>();
        List<CaseOnLineDetailVO> caseOnLineDetailVOList = caseOnLineService.getListByCaseCode(caseCodeList);

        for (CaseOnLineDetailVO item : caseOnLineDetailVOList) {
            Case caseWrap = new Case();
            wrapDate(caseWrap, item);
            caseList.add(caseWrap);
        }
        return caseList;
    }

    @Override
    public int saveData(List<String> caseCodeList) {
        int count = 0;
        List<Case> caseList = getCaseWrapList(caseCodeList);
        int size = caseList.size();
        if(size==0){
            return 0;
        }
        if (size > n) {
            List<List<Case>> splitList = ListSplitUtil.averageAssign(caseList, n);
            for (List<Case> item : splitList) {
                int count1 = fdsCaseV2Service.insertList(item);
                count = count + count1;
            }
        } else {
            count = fdsCaseV2Service.insertList(caseList);
        }
        return count;
    }

    //封装数据
    private void wrapDate(Case vo, CaseOnLineDetailVO po) {

        vo.setPassword("");
        vo.setNopublicinfo("");
        vo.setCasefindtime(po.getCaseTime());
        vo.setCaseid(po.getCaseNum());
        vo.setType(CaseV2.type);
        if(po.getOrgSquadronPids()==null){
            vo.setCasedeptkey("undefine");
        }else{
            vo.setCasedeptkey(po.getOrgSquadronPids());
        }
        if(po.getHandleSquadronNames()==null){
            vo.setCasedeptname("undefine");
        }else{
            vo.setCasedeptname(po.getHandleSquadronNames());
        }


        vo.setPublicstyle(CaseV2.publicstyle);
        vo.setCasehappensource(po.getSourceName() + po.getSubSourceName());
        vo.setCasename(po.getBehaviorFourName());//第四级违法行为+拼接
        if(po.getCaseDesc()==null){
            vo.setCasecontent("undefine");
        }else{
            vo.setCasecontent(po.getCaseDesc());
        }



        if(po.getMoney()==null){
            vo.setCasemoney(0d);
        }else{
            vo.setCasemoney(po.getMoney());
        }

        if(po.getAddress()==null){
            vo.setCaseoccuraddr("undefine");
        }else{
            vo.setCaseoccuraddr(po.getAddress());
        }
        if(po.getCaseTime()==null){
            vo.setCaseoccurtime(new Date());
        }else{
            vo.setCaseoccurtime(po.getCaseTime());
        }

        if(po.getHandlerNames()==null){
            vo.setHandlepeoplenames("undefine");
        }else{
            vo.setHandlepeoplenames(po.getHandlerNames());
        }
        if(po.getHandlerIds()==null){
            vo.setHandlepeopleunids("undefine");
        }else{
            vo.setHandlepeopleunids(po.getHandlerIds());
        }


        vo.setCaseregpeople(CaseV2.caseregpeople);
        vo.setPowerid(CaseV2.powerid);
        vo.setCaseregtime(po.getCreateTime());

        vo.setIs_send(CaseV2.is_send);
        vo.setFlag(CaseV2.flag);
        vo.setIs_lianban(CaseV2.is_lianban);
        vo.setAreacode(CaseV2.areacode);

        vo.setDatavervison(CaseV2.datavervison);
        vo.setBelongtosystem(CaseV2.belongtosystem);
        vo.setSync_status(CaseV2.sync_status);
        vo.setCf_sjly(CaseV2.cf_sjly);

        vo.setCf_sjlydm(CaseV2.cf_sjlydm);

        vo.setCase_type("");
        vo.setIndustry("");
        vo.setCase_guilty("");

    }


}
