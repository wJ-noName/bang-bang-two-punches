package com.perfect.cx.sourceSpring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.perfect.cx.sourceSpring.aop")
public class AopConfig {
    public AopConfig() {
        System.out.println("---------AopConfig---------");
    }

    @Bean
    public ServiceInterface getService() {
        return new Service();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

}
