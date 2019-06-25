/**
 * Project Name:umale-maintenance
 * File Name:ExternalXXLJobConfig
 * Package Name:com.citycloud.umale.esi.config
 * Date: 2019/5/7 下午5:20
 * Copyright (c) 2018, Neoglory-umale All Rights Reserved.
 */
package com.citycloud.umale.esi.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ExternalXXLJobConfig
 * @Description TODO
 * @Author xuhaowei
 * @Date 2019/5/7 下午5:20
 * @Version 1.0.0
 * @since JDK 1.8
 */
@Configuration
@ComponentScan(basePackages = "com.citycloud.umale.esi")
public class ExternalXXLJobConfig {

    private Logger logger = LoggerFactory.getLogger(ExternalXXLJobConfig.class);

    @Value("${umale.supervision.job.admin.addresses}")
    private String adminAddresses;

    @Value("${umale.supervision.job.executor.appname}")
    private String appName;

    @Value("${umale.supervision.job.executor.ip}")
    private String ip;

    @Value("${umale.supervision.job.executor.port}")
    private int port;

    @Value("${umale.supervision.job.accessToken}")
    private String accessToken;

    @Value("${umale.supervision.job.executor.logpath}")
    private String logPath;

    @Value("${umale.supervision.job.executor.logretentiondays}")
    private int logRetentionDays;


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppName(appName);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);

        return xxlJobSpringExecutor;
    }
}