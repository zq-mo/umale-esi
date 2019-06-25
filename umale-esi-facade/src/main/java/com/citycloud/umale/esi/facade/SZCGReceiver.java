/**
 * Project Name:umale
 * File Name:SZCGReceiver
 * Package Name:com.citycloud.umale.esi.facade
 * Date: 2019/6/15 00:13
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.facade;/**
 * @author zq
 * @date 2019/6/15
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.acceptance.dto.ExternalEventDTO;
import com.citycloud.umale.acceptance.service.accptance.EventService;
import com.citycloud.umale.esi.bo.szcg.Attachment;
import com.citycloud.umale.esi.bo.szcg.ExternalEvent;
import com.citycloud.umale.esi.bo.szcg.ReceiveEntity;
import com.citycloud.umale.esi.constant.EventSourceEnum;
import com.citycloud.umale.esi.constant.SZCGConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author bridge
 * @className SZCGReceiver
 * @description
 * @date 2019/6/15 00:13
 * @since JDK 1.8
 */

@Component
@Slf4j
public class SZCGReceiver {

    @Reference
    private EventService eventService;

    @JmsListener(destination = "${szcg.activemq.topic.name}", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text) {
        log.info("消息内容：{}", text);
        ReceiveEntity bo = JSON.parseObject(text, new TypeReference<ReceiveEntity>() {
        });
        String type = bo.getInterfaceType();
        //注意，这里需要判断派单、办结告知、审核不通过，各个处理逻辑不同
        if (type.equals(SZCGConstant.TYPE_RECEIVE_PD)) {
            ExternalEvent externalEvent = new ExternalEvent();
            BeanUtils.copyProperties(bo, externalEvent);
            if (!StringUtils.isEmpty(bo.getLatitude())) {
                externalEvent.setEventLatitude(Double.parseDouble(bo.getLatitude()));
            }
            if (!StringUtils.isEmpty(bo.getLongitude())) {
                externalEvent.setEventLongitude(Double.parseDouble(bo.getLongitude()));
            }
            try {
                ExternalEventDTO dto = getDTO(externalEvent);
                log.info("调用受理系统接口插入数字城管的事件，参数:{}", JSON.toJSONString(dto));
                int result = eventService.inserEvent(dto);
                if (result == 999) {
                    log.info("该事件接收失败，中队不存在，事件参数：{}", JSON.toJSONString(dto));
                }
            } catch (Exception e) {
                log.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        }
    }

    private ExternalEventDTO getDTO(ExternalEvent bo) throws ParseException {

        ExternalEventDTO dto = new ExternalEventDTO();

        dto.setEventInterfaceType(Integer.parseInt(bo.getInterfaceType()));
        dto.setExternalEventType(bo.getEventType());
        dto.setWorkNo(bo.getItemCode());
        dto.setEventDesc(bo.getEventDesc());

        dto.setEventReportName(bo.getReportPerson());
        dto.setEventReportPhone(bo.getReportPhone());
        dto.setEventAddress(bo.getEventAddress());
        dto.setEventLongitude(bo.getEventLongitude());
        dto.setEventLatitude(bo.getEventLatitude());

        if (!CollectionUtils.isEmpty(bo.getAttachments())) {
            dto.setUrls(getAttachments(bo.getAttachments()));
        }

        dto.setEventTime(getDate(bo.getEventTime()));
        dto.setEventLevel(2);
        dto.setEndTime(getDate(bo.getDeadLineTime()));
        dto.setEventSourceName(EventSourceEnum.SZCG.getMsg());
        dto.setEventSourceNum(bo.getItemCode());
        dto.setEventSource(Integer.parseInt(EventSourceEnum.SZCG.getCode()));
        dto.setLawSquadronName(bo.getSquadron());

        return dto;
    }

    private String getAttachments(List<String> items) {
        List<Attachment> attachmentList = new ArrayList<>();
        for (String item : items) {
            Attachment temp = new Attachment();
            temp.setName(generateCode());
            temp.setUrl(item);
            attachmentList.add(temp);
        }
        return JSON.toJSONString(attachmentList);
    }

    private String generateCode() {
        String str = UUID.randomUUID().toString().replace("-", "");
        return str;
    }

    private Date getDate(String date) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(date);
    }
}
