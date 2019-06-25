/**
 * Project Name:umale
 * File Name:BaseEntity
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/11 15:00
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bridge
 * @version
 * @className BaseEntity
 * @description
 * @date 2019/5/11 15:00
 * @since JDK 1.8
 */
@Data
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 6311046717183525325L;

    private String AREACODE;//行政区划编码
    private String FLAG;//数据状态
    private Integer DATAVERVISON;//数据版本

    private String BELONGTOSYSTEM;//所属系统
    private String SYNC_STATUS;//同步状态
    private String CF_SJLY;//数据来源单位
    private String CF_SJLYDM;//数据来源单位统一社会信用代码

    private String EXTEND_1;//备用字段1
    private String EXTEND_2;//备用字段2
    private String EXTEND_3;//备用字段3
    private String EXTEND_4;//备用字段4

    private String EXTEND_5;//备用字段5
    private String op;//
    private Date tong_time;//
}
