/**
 * Project Name:umale
 * File Name:ExternalEvent
 * Package Name:com.citycloud.umale.esi.bo
 * Date: 2019/6/19 15:36
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.bo;/**
 * @author zq
 * @date 2019/6/19
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author bridge
 * @version
 * @className ExternalEvent
 * @description
 * @date 2019/6/19 15:36
 * @since JDK 1.8
 */
@Data
public class ExternalEvent implements Serializable {

    private static final long serialVersionUID = -4613564939237052903L;
    private Integer type;//接口事件类型,固定取值，{'type':1},表示派单
    private Integer bussId;//热线系统业务id，热线系统派单时会传送该字段，综合执法系统反馈时带上该字段
    private String workOrderNo;//工单编号，热线系统派单时会传送该字段，综合执法系统反馈时带上该字段
    private String sjms;//事件描述

    private String sbr;//上报人
    private String sbrlxdh;//上报人联系电话
    private String sjdz;//事件地址
    private String sjlx;//事件类型

    private String sjxxlx;//事件详细类型
    private String sjsj;//事件时间
    private String sjdj;//事件等级
    private String jzsj;//截止时间
    private String teamName;//中队名称
}
