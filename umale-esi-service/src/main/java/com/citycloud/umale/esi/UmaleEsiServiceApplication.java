package com.citycloud.umale.esi;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.citycloud.umale.esi"})

@MapperScan("com.citycloud.umale.esi.dao")

public class UmaleEsiServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmaleEsiServiceApplication.class, args);
    }
}
