/**
 * Project Name:umale
 * File Name:NormalResult
 * Package Name:com.citycloud.esi.event.vo
 * Date: 2019/4/26 10:01
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bridge
 * @version
 * @className NormalResult
 * @description
 * @date 2019/4/26 10:01
 * @since JDK 1.8
 */
@Data
public class NormalResult implements Serializable {

    private static final long serialVersionUID = 4642944583229997914L;

    private Integer type;//接口事件类型,必填,固定取值，{'type':1},表示反馈处理结果
    private Integer bussId;//业务id,必填,热线系统业务id，热线系统派单时会传送该字段，综合执法系统反馈时带上该字段
    private String workOrderNo;//工单编号,必填,热线系统业务id，热线系统派单时会传送该字段，综合执法系统反馈时带上该字段
    private String arriveTime;//到达现场时间,格式如："2019-03-18 17:01:01"

    private String endTime;//处理完成时间,格式如："2019-03-18 17:01:01"
    private Integer liAn;//是否立案 0:未立案；1：立案
    private String liAnNum;//立案编号
    private String responsibilityBook;//责改书编号

    private String singleNum;//暂扣单编号
    private String answerBook;//接调书编号
    private String dealUser1 ;//处理人1,可以有多个，用逗号间隔
    private String dealUser2;//处理人2,可以有多个，用逗号间隔

    private String processingResults;//处理内容,必填
    private String teamPhone;//中队联系电话
    private String wsdlSysId;// 综合执法系统业务id
}
