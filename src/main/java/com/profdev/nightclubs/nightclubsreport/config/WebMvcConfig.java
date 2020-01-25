package com.profdev.nightclubs.nightclubsreport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableJpaRepositories
@ComponentScan(basePackages = "com.profdev.nightclubs.nightclubsreport")
public class WebMvcConfig implements WebMvcConfigurer {
}
