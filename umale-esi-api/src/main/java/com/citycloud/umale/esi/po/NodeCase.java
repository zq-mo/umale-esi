/**
 * Project Name:umale
 * File Name:NodeCase
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/11 15:07
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bridge
 * @version
 * @className NodeCase
 * @description 立案审批（冯博）
 * @date 2019/5/11 15:07
 * @since JDK 1.8
 */
@Data
public class NodeCase{

    private String caseid;//案件编号
    private String casename;//案由名称
    private String nodename;//所属环节名称
    private String writnumber;//立案文书编号

    private String handleopinion;//承办意见
    private String handlepersons;//承办人姓名（执法人员姓名）
    private String handlepersonids;//承办人编号（执法人员证号）
    private Date cacetime;//立案批准时间

    private String remark;//备注
    private Date oprationtime;//数据录入时间
    private String xzhandleperson;//协助承办人姓名（执法人员姓名）
    private String xzhandlepersonid;//协助承办人证件号（执法人员证号）

    private String casedeptkey;//执法部门的唯一标识
    private String casedeptname;//执法部门的名称

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
