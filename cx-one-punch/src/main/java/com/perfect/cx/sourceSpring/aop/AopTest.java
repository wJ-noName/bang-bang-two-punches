package com.perfect.cx.sourceSpring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        Service service = applicationContext.getBean(Service.class);
        System.out.println(service.doService(1));
    }
}
