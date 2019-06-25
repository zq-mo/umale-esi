/**
 * Project Name:umale
 * File Name:FdsFileInfoV2Service
 * Package Name:com.citycloud.umale.esi.service.province
 * Date: 2019/5/16 15:26
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.province;

import com.citycloud.umale.esi.po.FileInfo;

import java.util.List;

/**
 * @author bridge
 * @version
 * @className FdsFileInfoV2Service
 * @description
 * @date 2019/5/16 15:26
 * @since JDK 1.8
 */
public interface FdsFileInfoV2Service {
    int insert(FileInfo po);
    int insertList(List<FileInfo> fileInfoList);
}
