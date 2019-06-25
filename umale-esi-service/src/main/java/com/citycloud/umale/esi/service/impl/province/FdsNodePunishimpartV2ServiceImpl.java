/**
 * Project Name:umale
 * File Name:FdsNodePunishimpartV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/16 20:32
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.NodePunishimpartDao;
import com.citycloud.umale.esi.po.NodePunishimpart;
import com.citycloud.umale.esi.service.province.FdsNodePunishimpartV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodePunishimpartV2ServiceImpl
 * @description
 * @date 2019/5/16 20:32
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsNodePunishimpartV2Service.class)
@Slf4j
public class FdsNodePunishimpartV2ServiceImpl implements FdsNodePunishimpartV2Service {

    @Autowired
    private NodePunishimpartDao nodePunishimpartDao;

    @Override
    public int insert(NodePunishimpart po) {
        return nodePunishimpartDao.insertSelective(po);

    }

    @Override
    public int insertList(List<NodePunishimpart> poList) {
        return nodePunishimpartDao.insertList(poList);
    }
}
