/**
 * Project Name:umale
 * File Name:Case
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/11 13:29
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bridge
 * @version
 * @className Case
 * @description 案件登记信息(赵桥)
 * @date 2019/5/11 13:29
 * @since JDK 1.8
 */
@Data
public class Case{

    private String caseid;//案件编号
    private String type;//案件类别
    private String password;//
    private String casedeptkey;//执法部门的唯一标识

    private String casedeptname;//执法部门的名称
    private String publicstyle;//是否公开
    private String nopublicinfo;//不公开依据
    private String casehappensource;//案件来源

    private String casename;//案由(案件名称)，第四季违法行为+拼接
    private Date casefindtime;//线索发现时间
    private String casecontent;//案情描述
    private Double casemoney;//涉案金额

    private String caseoccuraddr;//案发地点
    private Date caseoccurtime;//案发时间
    private String handlepeoplenames;//承办人员名称（执法人员姓名）
    private String handlepeopleunids;//承办人员编号（执法人员证号）

    private String caseregpeople;//登记人标识
    private String powerid;//所属权力编码
    private Date caseregtime;//数据录入时间
    private String is_send;//是否移送

    private String case_type;//案件类型
    private String industry;//所属行业
    private String case_guilty;//涉案件罪名
    private String is_lianban;//是否联办



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
