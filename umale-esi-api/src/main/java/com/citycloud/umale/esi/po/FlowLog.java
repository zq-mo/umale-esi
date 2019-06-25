/**
 * Project Name:umale
 * File Name:FlowLog
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/11 14:40
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bridge
 * @version
 * @className FlowLog
 * @description 案件环节办理信息（李俊超）
 * @date 2019/5/11 14:40
 * @since JDK 1.8
 */
@Data
public class FlowLog {



    private String sourcekey;//唯一标识
    private String caseid;//案件编号
    private String nodename;//所属环节名称
    private String nodecode;//所属大环节编码

    private String opinion;//意见
    private String casedeptkey;//执法部门的唯一标识
    private String casedeptname;//执法部门的名称

    //公共服务

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
