/**
 * Project Name:umale
 * File Name:FdsCaseV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/14 16:33
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.CaseDao;
import com.citycloud.umale.esi.po.Case;
import com.citycloud.umale.esi.service.province.FdsCaseV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className FdsCaseV2ServiceImpl
 * @description
 * @date 2019/5/14 16:33
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsCaseV2Service.class)
@Slf4j
public class FdsCaseV2ServiceImpl implements FdsCaseV2Service {

    @Autowired
    private CaseDao caseDao;

    public int insert(Case po) {
        return caseDao.insertSelective(po);
    }

    public int insertList(List<Case> cases) {
        return caseDao.insertList(cases);
    }
}
