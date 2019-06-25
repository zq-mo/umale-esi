/**
 * Project Name:umale
 * File Name:FdsNodeHearingnotesV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/17 14:56
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.NodeHearingnotesDao;
import com.citycloud.umale.esi.po.NodeHearingnotes;
import com.citycloud.umale.esi.service.province.FdsNodeCaseV2Service;
import com.citycloud.umale.esi.service.province.FdsNodeHearingnotesV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsNodeHearingnotesV2ServiceImpl
 * @description
 * @date 2019/5/17 14:56
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsNodeHearingnotesV2Service.class)
@Slf4j
public class FdsNodeHearingnotesV2ServiceImpl implements FdsNodeHearingnotesV2Service {

    @Autowired
    private NodeHearingnotesDao nodeHearingnotesDao;

    @Override
    public  int insert(NodeHearingnotes po){
        return nodeHearingnotesDao.insertSelective(po);
    }

    @Override
    public int insertList(List<NodeHearingnotes> poList ){
        return nodeHearingnotesDao.insertList(poList);
    }
}
