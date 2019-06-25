/**
 * Project Name:umale
 * File Name:EventService
 * Package Name:com.citycloud.umale.esi.service
 * Date: 2019/4/28 16:01
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citycloud.umale.acceptance.dto.ExternalEventDTO;
import com.citycloud.umale.acceptance.service.accptance.EventService;
import com.citycloud.umale.esi.bo.EventBO;
import com.citycloud.umale.esi.bo.ExternalEvent;
import com.citycloud.umale.esi.constant.EventSourceEnum;
import com.citycloud.umale.esi.service.ExternalEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bridge
 * @className EventService
 * @description
 * @date 2019/4/28 16:01
 * @since JDK 1.8
 */
@Service(interfaceClass = ExternalEventService.class)
@Slf4j
public class ExternalEventServiceImpl implements ExternalEventService {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    @Reference
    private EventService eventService;

    public int saveEvent(String jsonString) throws ParseException {

        System.out.println(jsonString);
        EventBO bo = JSON.parseObject(jsonString, new TypeReference<EventBO>() {
        });
        //注意，这里需要判断派单、办结告知、审核不通过，各个处理逻辑不同
        if (bo.getType() == 1) {

            ExternalEvent externalEvent = new ExternalEvent();
            BeanUtils.copyProperties(bo, externalEvent);
            ExternalEventDTO dto = new ExternalEventDTO();

            setExternalEventDto(externalEvent, dto);
            System.out.println(dto.toString());
            log.info("调用受理系统保存96310过来的时间，入参:{}", JSON.toJSONString(dto));
            return eventService.inserEvent(dto);

        }
        return 0;

    }

    private void setExternalEventDto(ExternalEvent bo, ExternalEventDTO dto) throws ParseException {

        dto.setEventInterfaceType(bo.getType());
        dto.setBusinessId(bo.getBussId());
        dto.setWorkNo(bo.getWorkOrderNo());
        dto.setEventSourceNum(bo.getWorkOrderNo());
        dto.setEventDesc(bo.getSjms());

        dto.setEventReportName(bo.getSbr());
        dto.setEventReportPhone(bo.getSbrlxdh());
        dto.setEventAddress(bo.getSjdz());
        dto.setEventTime(getDate(bo.getSjsj(), pattern));

        dto.setEventLevel(getEventLevel(bo.getSjdj()));
        dto.setEndTime(getDate(bo.getJzsj(), pattern));
        dto.setExternalEventType(transform(bo.getSjlx(), bo.getSjxxlx()));

        dto.setEventSource(Integer.parseInt(EventSourceEnum.JLSYL.getCode()));
        dto.setEventSourceName(EventSourceEnum.JLSYL.getMsg());
        dto.setLawSquadronName(bo.getTeamName());

    }

    //todo 完成转换逻辑。
    private Integer getEventLevel(String level) {
        return Integer.parseInt(level);
    }

    private Date getDate(String date, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(date);
    }

    private String transform(String str1, String str2) {
        return str1 + ";" + str2;
    }
}
