/**
 * Project Name:umale
 * File Name:EventBO
 * Package Name:com.citycloud.esi.event.bo
 * Date: 2019/4/19 14:18
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bridge
 * @version
 * @className EventBO
 * @description 接收96130热线消息的实体
 * @date 2019/4/19 14:18
 * @since JDK 1.8
 */
@Data
public class EventBO implements Serializable {

    private static final long serialVersionUID = -2811263037847813321L;

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
