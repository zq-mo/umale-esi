package com.citycloud.umale.esi;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@EnableDubbo
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableJms
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.citycloud.umale.esi"})
public class UmaleEsiFacadeApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmaleEsiFacadeApplication.class, args);
    }
}
