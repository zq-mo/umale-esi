/**
 * Project Name:umale
 * File Name:NodeYscase
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/13 14:23
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.util.Date;

/**
 * @author bridge
 * @version
 * @className NodeYscase
 * @description 案件结案（冯博）
 * @date 2019/5/13 14:23
 * @since JDK 1.8
 */
@Data
public class NodeYscase {
    private String caseid;//案件编号
    private String type;//案件结案状态类
    private String repealreason;//结案理由
    private String nodename;//结案所属环节

    private String writnumber;//移送文书编号
    private String sysdept;//受移送机关
    private String caseintro;//移送案情简介
    private String legalbasis;//移送法律依据

    private String evidencedata;//相关证据材料
    private Date endtime;//结案时间
    private String casedeptkey;//执法部门的唯一标识
    private String casedeptname;//执法部门的名称

    private String remark;//备注
    private Date oprationtime;//数据录入时间

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
