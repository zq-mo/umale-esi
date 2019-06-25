/**
 * Project Name:umale
 * File Name:NodeHearingnotes
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/11 15:19
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bridge
 * @version
 * @className NodeHearingnotes
 * @description 听证通知（高翔）
 * @date 2019/5/11 15:19
 * @since JDK 1.8
 */
@Data
public class NodeHearingnotes {

    private String sourcekey;//唯一标识
    private String caseid;//案件编号
    private String writnumber;//文书编号
    private String partyname;//当事人

    private String casename;//案由名称
    private Date time;//听证时间
    private String address;//听证地点
    private String ispublic;//是否公开

    private String reason;//不公开原因
    private String emcee;//听证主持人
    private String emceeduty;//主持人职务
    private String officer;//听证员

    private String officerduty;//听证员职务
    private String clerk;//书记员
    private String clerkduty;//书记员职务
    private String remark;//备注

    private Date oprationtime;//数据录入时间
    private String zfjgdz;//执法机构地址
    private String lxrxm;//联系人姓名
    private String lxrdh;//联系人电话

    private String yzbm;//邮政编码
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
