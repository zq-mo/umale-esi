/**
 * Project Name:umale
 * File Name:NodePunishdecide
 * Package Name:com.citycloud.umale.esi.po
 * Date: 2019/5/11 15:29
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.po;

import lombok.Data;

import java.util.Date;

/**
 * @author bridge
 * @version
 * @className NodePunishdecide
 * @description 处罚决定（高翔）
 * @date 2019/5/11 15:29
 * @since JDK 1.8
 */
@Data
public class NodePunishdecide {

    private String sourcekey;//唯一主键
    private String caseid;//案件编号
    private String xzcfws_name;//处罚结果公开案由
    private String nodename;//所属环节名称

    private String writnumber;//处罚决定书编号
    private String partyname;//当事人
    private Double punishmoney;//罚款金额
    private Double illegalitymoney;//没收违法所得没收非法财物的金额


    private String revokelicense;//暂扣或吊销证照名称
    private String revokecode;//暂扣或吊销证照编号
    private String punishcontent;//对外公开的处罚决定书全文或摘要
    private Date punishdecidetime;//处罚决定时间

    private String punishvaliddate;//处罚有效期
    private String publicdeadline;//公示截止期
    private String lawbasis;//执法依据
    private String discretionid;//自由裁量基准

    private String discretionsn;//自由裁量基准版本号
    private String fydz;//复议地址
    private String jkdz;//缴款地址
    private String jkzh;//缴款账号

    private String standard_punish_id;//裁量规则标识
    private String standard_punish_version;//裁量规则版本号
    private String remark;//备注
    private Date oprationtime;//数据录入时间

    private String casedeptkey;//执法部门的唯一标识
    private String casedeptname;//执法部门的名称

    //公共字段

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
