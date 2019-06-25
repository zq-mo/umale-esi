/**
 * Project Name:umale
 * File Name:BackResult
 * Package Name:com.citycloud.esi.event.vo
 * Date: 2019/4/26 10:26
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bridge
 * @version
 * @className BackResult
 * @description
 * @date 2019/4/26 10:26
 * @since JDK 1.8
 */
@Data
public class BackResult implements Serializable {

    private static final long serialVersionUID = -3769900370984560841L;

    private Integer type;//接口事件类型,必填,固定取值，{'type':2},表示退办
    private Integer bussId;//业务id,必填,热线系统业务id，热线系统派单时会传送该字段，综合执法系统反馈时带上该字段
    private String workOrderNo;//工单编号,14,必填,工单编号，热线系统派单时会传送该字段，综合执法系统反馈时带上该字段
    private String returnBackComment;//回退原因,必填
}
