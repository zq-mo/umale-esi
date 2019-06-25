/**
 * Project Name:umale
 * File Name:BackResult
 * Package Name:com.citycloud.umale.esi.bo.szcg
 * Date: 2019/6/18 10:55
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.bo.szcg;/**
 * @author zq
 * @date 2019/6/18
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author bridge
 * @version
 * @className BackResult
 * @description
 * @date 2019/6/18 10:55
 * @since JDK 1.8
 */
@Data
public class BackResult implements Serializable {
    private static final long serialVersionUID = -4480080753714869409L;
    private String interfaceType;//接口事件类型,必填,固定取值，3-表示退办
    private String itemCode;//工单编号,必填，热线系统派单时会传送该字段，综合执法系统反馈时带上该字段
    private String backReason;//回退原因,必填
}
