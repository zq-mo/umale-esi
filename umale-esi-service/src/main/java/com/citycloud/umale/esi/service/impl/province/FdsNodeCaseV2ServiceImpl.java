/**
 * Project Name:umale
 * File Name:FdsNodeCaseV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/16 17:18
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.NodeCaseDao;
import com.citycloud.umale.esi.po.NodeCase;
import com.citycloud.umale.esi.service.province.FdsNodeCaseV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodeCaseV2ServiceImpl
 * @description
 * @date 2019/5/16 17:18
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsNodeCaseV2Service.class)
@Slf4j
public class FdsNodeCaseV2ServiceImpl implements FdsNodeCaseV2Service {

    @Autowired
    private NodeCaseDao nodeCaseDao;

    public  int insert(NodeCase po){
        return nodeCaseDao.insertSelective(po);
    }
    public  int insertList(List<NodeCase> poList){

        return nodeCaseDao.insertList(poList);
    }
}
