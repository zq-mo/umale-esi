/**
 * Project Name:umale-discipline
 * File Name:EndCaseNoHandler
 * Package Name:com.citycloud.umale.esi.handler
 * Date: 2019/5/17 10:20
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.handler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.citycloud.umale.cases.dto.CaseNoAndNumStateEndDTO;
import com.citycloud.umale.cases.service.cases.CaseSummaryService;
import com.citycloud.umale.esi.service.wrap.data.SaveDataService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author li-jc
 * @version 1.0.0
 * @className EndCaseNoHandler
 * @description 结案处理
 * @date 2019/5/17 10:20
 * @since JDK 1.8
 */
@JobHandler(value = "endCaseNoHandler")
@Component
@Slf4j
public class EndCaseNoHandler extends IJobHandler {
    @Reference
    CaseSummaryService caseSummaryService;
    @Autowired
    SaveDataService saveDataService;

    @Override
    public ReturnT<String> execute(String s) throws Exception {

        //获取任务执行时，一天内的结案数据
        Date endDate = new Date();
        Date startDate = new Date(endDate.getTime() - 24 * 60 * 1000);


        List<CaseNoAndNumStateEndDTO> caseNoAndNumStateEndDTOS = caseSummaryService.getAllCaseCodeByStateEnd(startDate,endDate);
        List<String> caseNums = new ArrayList<>();
        List<String> caseCodes = new ArrayList<>();
        for (CaseNoAndNumStateEndDTO caseNoAndNumStateEndDTO : caseNoAndNumStateEndDTOS) {
            caseNums.add(caseNoAndNumStateEndDTO.getCaseNum());
            caseCodes.add(caseNoAndNumStateEndDTO.getCaseCode());
        }
        log.info("[caseNums = {}]", JSON.toJSONString(caseNums));
        log.info("[caseCodes:{}]", JSON.toJSONString(caseCodes));
        saveDataService.saveData(caseNums, caseCodes);
        return new ReturnT<>(String.valueOf(caseNoAndNumStateEndDTOS.size()));
    }
}
