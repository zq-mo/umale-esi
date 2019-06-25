/**
 * Project Name:umale
 * File Name:FdsFlowLogV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/16 16:47
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.FlowLogDao;
import com.citycloud.umale.esi.po.FlowLog;
import com.citycloud.umale.esi.service.province.FdsCaseV2Service;
import com.citycloud.umale.esi.service.province.FdsFlowLogV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsFlowLogV2ServiceImpl
 * @description
 * @date 2019/5/16 16:47
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsFlowLogV2Service.class)
@Slf4j
public class FdsFlowLogV2ServiceImpl implements FdsFlowLogV2Service {

    @Autowired
    private FlowLogDao flowLogDao;

    public int insert(FlowLog po){
        return flowLogDao.insertSelective(po);
    }

    public int insertList(List<FlowLog> poList){
        return flowLogDao.insertList(poList);
    }
}
