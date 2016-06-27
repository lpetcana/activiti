package com.xvitcoder.springmvcangularjs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ComponentScan(basePackages = {"com.xvitcoder.springmvcangularjs"}, lazyInit = true)
@ImportResource("classpath:activiti.cfg.xml")
public class AppConfig {
}
