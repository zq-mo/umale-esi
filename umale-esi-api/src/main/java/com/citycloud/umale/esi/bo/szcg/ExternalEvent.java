/**
 * Project Name:umale
 * File Name:ExternalEvent
 * Package Name:com.citycloud.umale.esi.bo.szcg
 * Date: 2019/6/14 20:07
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
 * @className ExternalEvent
 * @description
 * @date 2019/6/14 20:07
 * @since JDK 1.8
 */
@Data
public class ExternalEvent implements Serializable{


    private static final long serialVersionUID = 5238146554717959073L;
    private String interfaceType;//接口事件类型
    private String itemCode;//工单编号
    private String eventDesc;//事件描述
    private String reportPerson;//上报人
    private String reportPhone;//上报人联系电话
    private String eventAddress;//事件地址
    private String eventType;//事件类型
    private String eventTime;//事件时间

    private String eventLevel;//事件等级
    private String deadLineTime;//截止时间
    private String squadron;//派遣中队
    private List<String> attachments;//附件

    private Double eventLongitude;//经度
    private Double eventLatitude;//纬度

    private String urls;//附件

}
