/**
 * Project Name:umale
 * File Name:FdsFileInfoV2ServiceImpl
 * Package Name:com.citycloud.umale.esi.service.impl.province
 * Date: 2019/5/16 15:28
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.province;

import com.alibaba.dubbo.config.annotation.Service;
import com.citycloud.umale.esi.dao.province.FileInfoDao;
import com.citycloud.umale.esi.po.FileInfo;
import com.citycloud.umale.esi.service.province.FdsFileInfoV2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author bridge
 * @className FdsFileInfoV2ServiceImpl
 * @description
 * @date 2019/5/16 15:28
 * @since JDK 1.8
 */
@Service(interfaceClass = FdsFileInfoV2Service.class)
@Slf4j
public class FdsFileInfoV2ServiceImpl implements FdsFileInfoV2Service {

    @Autowired
    private FileInfoDao fileInfoDao;

    public int insert(FileInfo po) {
        return fileInfoDao.insertSelective(po);
    }

    public int insertList(List<FileInfo> fileInfoList) {

        return fileInfoDao.insertList(fileInfoList);

    }
}
