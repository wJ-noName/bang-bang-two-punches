package com.perfect.cx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CxLoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(CxLoveApplication.class, args);
    }

}
