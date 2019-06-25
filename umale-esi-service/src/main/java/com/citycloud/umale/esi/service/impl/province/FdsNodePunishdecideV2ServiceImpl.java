/**
 * Project Name:umale
 * File Name:FdsNodePunishdecideV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/16 19:21
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.NodePunishdecideDao;
import com.citycloud.umale.esi.po.NodePunishdecide;
import com.citycloud.umale.esi.service.province.FdsNodePunishdecideV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodePunishdecideV2ServiceImpl
 * @description
 * @date 2019/5/16 19:21
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsNodePunishdecideV2Service.class)
@Slf4j
public class FdsNodePunishdecideV2ServiceImpl implements FdsNodePunishdecideV2Service {


    @Autowired
    private NodePunishdecideDao nodePunishdecideDao;

    @Override
    public int insert(NodePunishdecide po){
        return nodePunishdecideDao.insertSelective(po);
    }

    @Override
    public  int insertList(List<NodePunishdecide> poList){
        return nodePunishdecideDao.insertList(poList);
    }

}
