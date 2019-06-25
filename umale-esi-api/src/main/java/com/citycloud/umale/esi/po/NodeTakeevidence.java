/**
 * Project Name:umale
 * File Name:NodeTakeevidence
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/13 14:16
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.util.Date;

/**
 * @author bridge
 * @version
 * @className NodeTakeevidence
 * @description 调查取证（高翔）
 * @date 2019/5/13 14:16
 * @since JDK 1.8
 */
@Data
public class NodeTakeevidence {
    private String sourcekey;//唯一主键
    private String caseid;//案件编号
    private String casename;//案由名称
    private String nodename;//环节名称

    private String partynames;//当事人
    private Date starttime;//调查时间起
    private Date endtime;//调查时间止
    private String surveypersonname;//调查人姓名

    private String surveypersonid;//调查人证件号
    private String surveypass;//调查经过
    private String fact;//案件事实
    private String punishopinion;//初步处罚建议

    private Date oprationtime;//数据录入时间
    private String xzhandleperson;//协助承办人姓名(执法人员姓名)
    private String xzhandlepersonid;//协助承办人证件号（执法人员证件号）
    private String casedeptkey;//执法部门的唯一标识

    private String casedeptname;//执法部门的名称
    private String remark;//备注

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
