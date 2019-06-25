/**
 * Project Name:umale
 * File Name:FdsNodeTakeevidenceV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/17 15:25
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.NodeTakeevidenceDao;
import com.citycloud.umale.esi.po.NodeTakeevidence;
import com.citycloud.umale.esi.service.province.FdsNodeTakeevidenceV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodeTakeevidenceV2ServiceImpl
 * @description
 * @date 2019/5/17 15:25
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsNodeTakeevidenceV2Service.class)
@Slf4j
public class FdsNodeTakeevidenceV2ServiceImpl implements FdsNodeTakeevidenceV2Service {

    @Autowired
    private NodeTakeevidenceDao nodeTakeevidenceDao;

    @Override
    public int insertList(List<NodeTakeevidence> poList) {
        return nodeTakeevidenceDao.insertList(poList);
    }
}
