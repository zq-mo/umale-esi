/**
 * Project Name:umale
 * File Name:Party
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/13 14:31
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.util.Date;

/**
 * @author bridge
 * @version
 * @className Party
 * @description 案件当事人信息（赵桥）
 * @date 2019/5/13 14:31
 * @since JDK 1.8
 */
@Data
public class Party {

    private String sourcekey;//唯一标识
    private String caseid;//案件编号
    private String usertype;//类型
    private String job;//职务

    private String username;//名称
    private String usersex;//性别
    private String usercardtype;//主证件类型
    private String usercode;//主证件号码

    private String othercardtype;//相关证件类型
    private String othercode;//相关证件号码
    private String dutypeopleperson;//法定代表人姓名
    private String fdidnumber;//法定代表人身份证号码

    private String unit_property;//单位性质
    private String userphone;//联系电话
    private String useraddress;//联系地址
    private String publicstyle;//是否公开

    private String nopublicinfo;//不公开依据
    private String remark;//REMARK

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
