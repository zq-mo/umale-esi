/**
 * Project Name:umale
 * File Name:FileInfo
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/11 14:27
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bridge
 * @version
 * @className FileInfo
 * @description 案件附件信息（赵桥）
 * @date 2019/5/11 14:27
 * @since JDK 1.8
 */
@Data
public class FileInfo{

    private String fileinfoid;//唯一标识
    private String nodecode;//大环节编码
    private String caseid;//案件编号
    private String nodename;//环节名称

    private String name;//附件名称
    private String filepath;//附件的访问路径
    private Date createtime;//数据录入时间
    private String operatorid;//上传者编号

    private String operatorname;//上传者名称

    //公共字段
    private String areacode;//行政区划编码
    private String flag;//数据状态
    private Integer datavervison;//数据版本

    private String belongtosystem;//所属系统
    private String sync_status;//同步状态
    private String cf_sjly;//数据来源单位
    private String cf_sjlydm;//数据来源单位统一社会信用代码

    private String extend_1;//备用字段1
    private String extend_2;//备用字段2
    private String extend_3;//备用字段3
    private String extend_4;//备用字段4

    private String extend_5;//备用字段5
    private String op;//
    private Date tong_time;//
   }
