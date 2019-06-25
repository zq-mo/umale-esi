/**
 * Project Name:umale
 * File Name:ReceiveEntity
 * Package Name:com.citycloud.umale.esi.bo.szcg
 * Date: 2019/6/14 19:58
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.bo.szcg;/**
 * @author zq
 * @date 2019/6/14
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author bridge
 * @version
 * @className ReceiveEntity
 * @description
 * @date 2019/6/14 19:58
 * @since JDK 1.8
 */
@Data
public class ReceiveEntity implements Serializable {


    private static final long serialVersionUID = 1051937582357658160L;

    private String interfaceType;//接口事件类型
    private String itemCode;//工单编号
    private String eventDesc;//事件描述
    private String reportPerson;//上报人
    private String reportPhone;//上报人联系电话

    private String eventAddress;//事件地址
    private String longitude;//地址经度
    private String latitude;//地址维度
    private String eventType;//事件类型
    private String eventTime;//事件时间

    private String eventLevel;//事件等级
    private String deadLineTime;//截止时间
    private String squadron;//派遣中队
    private List<String> attachments;//附件

}
