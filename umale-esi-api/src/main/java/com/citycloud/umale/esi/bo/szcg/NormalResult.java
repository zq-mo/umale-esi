/**
 * Project Name:umale
 * File Name:NormalResult
 * Package Name:com.citycloud.umale.esi.bo.szcg
 * Date: 2019/6/18 10:51
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
 * @className NormalResult
 * @description
 * @date 2019/6/18 10:51
 * @since JDK 1.8
 */
@Data
public class NormalResult implements Serializable {

    private static final long serialVersionUID = 8052927072935454398L;

    private String interfaceType;//接口事件类型,固定取值,2-表示反馈处理结果
    private String itemCode;//工单编号，派单时会传送该字段，综合执法系统反馈时带上该字段
    private String completeTime;//处理完成时间,格式如："2019-03-18 17:01:01"
    private String handlePerson;//处理人,可以有多个，用逗号间隔
    private String handleContent;//处理内容
}
