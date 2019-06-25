/**
 * Project Name:umale
 * File Name:FdsPartyV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/17 16:38
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.PartyDao;
import com.citycloud.umale.esi.po.Party;
import com.citycloud.umale.esi.service.province.FdsPartyV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className FdsPartyV2ServiceImpl
 * @description
 * @date 2019/5/17 16:38
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsPartyV2Service.class)
@Slf4j
public class FdsPartyV2ServiceImpl implements FdsPartyV2Service {

    @Autowired
    private PartyDao partyDao;

    @Override
    public int insertList(List<Party> poList) {

        return partyDao.insertList(poList);

    }
}
