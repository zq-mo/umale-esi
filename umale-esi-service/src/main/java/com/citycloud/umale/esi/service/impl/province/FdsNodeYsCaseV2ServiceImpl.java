/**
 * Project Name:umale
 * File Name:FdsNodeYsCaseV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/17 16:23
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.NodeYscaseDao;
import com.citycloud.umale.esi.po.NodeYscase;
import com.citycloud.umale.esi.service.province.FdsNodeYsCaseV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className FdsNodeYsCaseV2ServiceImpl
 * @description
 * @date 2019/5/17 16:23
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsNodeYsCaseV2Service.class)
@Slf4j
public class FdsNodeYsCaseV2ServiceImpl implements FdsNodeYsCaseV2Service {

    @Autowired
    private NodeYscaseDao nodeYscaseDao;

    @Override
    public int insertList(List<NodeYscase> poList) {
        return nodeYscaseDao.insertList(poList);
    }
}
