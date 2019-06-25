/**
 * Project Name:umale
 * File Name:CaseV2
 * Package Name:com.citycloud.umale.esi.constant
 * Date: 2019/5/17 10:51
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.constant;

/**
 * @author bridge
 * @version
 * @className CaseV2
 * @description
 * @date 2019/5/17 10:51
 * @since JDK 1.8
 */
public interface CaseV2 {

    String type="1";//案件类别,1表示未定义
    String publicstyle="1";//是否公开,1表示未定义
    String caseregpeople="undefine";//登记人标识
    String powerid="undefine";//所属权利编码

    String is_send="1";//是否移送，1表示未定义
    String flag="1";//数据状态，1表示未定义
    String is_lianban="1";//是否联办，1表示未定义
    String  areacode="undefine";//行政区划编码

    Integer datavervison =1;//数据版本
    String belongtosystem ="undefine";//所属系统
    String sync_status ="1";//同步状态，1标识未定义
    String cf_sjly="undefine";//数据来源单位

    String cf_sjlydm="undefine";//数据来源单位统一社会信用代码
    String opinion = "undefine";//意见
    String casedeptname = "undefine";//执法部门的名称
    String casedeptkey="undefine";//执法部门的唯一标识
}
