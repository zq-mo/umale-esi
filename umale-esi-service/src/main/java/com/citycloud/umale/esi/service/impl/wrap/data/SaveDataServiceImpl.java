/**
 * Project Name:umale
 * File Name:SaveDataServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.wrap.data
 * Date: 2019/5/17 11:33
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.wrap.data;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.service.wrap.data.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className SaveDataServiceImpl
 * @description
 * @date 2019/5/17 11:33
 * @since JDK 1.8
 */
@Service(interfaceClass = SaveDataService.class)
@Slf4j
public class SaveDataServiceImpl implements SaveDataService {

    @Autowired
    private CaseWrapService caseWrapService;
    @Autowired
    private FileInfoService fileInfoService;
    @Autowired
    private CaseFloweLogsService caseFloweLogsService;
    @Autowired
    private NodeHearingnotesService nodeHearingnotesService;
    @Autowired
    private NodePunishimpartService nodePunishimpartService;
    @Autowired
    private NodePunishdecideService nodePunishdecideService;
    @Autowired
    private NodeTakeevidenceService nodeTakeevidenceService;
    @Autowired
    private NodeCaseService nodeCaseService;

    @Autowired
    private NodeYsCaseService nodeYsCaseService;
    @Autowired
    private PartyService partyService;

    @Override
    public void saveData(List<String> caseCodeNums, List<String> caseCodeList) {
        //1.发送案卷数据
        try {
            int count1 = caseWrapService.saveData(caseCodeList);
            log.info("发送案卷数据[count1={}]", count1);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //2.发送附件数据
        try {
            int count2 = fileInfoService.insertList(caseCodeNums);
            log.info("发送附件数据[count2={}]", count2);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //3.发送环节办理数据
        try {
            int count3 = caseFloweLogsService.insert(caseCodeNums);
            log.info("发送环节办理数据[count3={}]", count3);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //4.发送立案审批数据
        try {
            int count4 = nodeCaseService.insertList(caseCodeNums);
            log.info("发送立案审批数据[count4={}]", count4);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //5.发送听证通知数据
        try {
            int count5 = nodeHearingnotesService.insert(caseCodeNums);
            log.info("发送听证通知数据[count5={}]", count5);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //6.发送处罚决定数据
        try {
            int count6 = nodePunishdecideService.insert(caseCodeNums);
            log.info("发送处罚决定数据[count6={}]", count6);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //7.发送处罚告知数据
        try {
            int count7 = nodePunishimpartService.insert(caseCodeNums);
            log.info("发送附件数据[count7={}]", count7);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //8.发送调查取证数据
        try {
            int count8 = nodeTakeevidenceService.insert(caseCodeNums);
            log.info("发送附件数据[count8={}]", count8);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //9.发送案件结案数据
        try {
            int count9 = nodeYsCaseService.insertList(caseCodeNums);
            log.info("发送附件数据[count9={}]", count9);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

        //10.发送当事人信息数据
        try {
            int count10 = partyService.insertList(caseCodeList);
            log.info("发送附件数据[count10={}]", count10);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
        }

    }
}
