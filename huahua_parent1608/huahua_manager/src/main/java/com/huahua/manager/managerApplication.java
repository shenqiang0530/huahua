package com.huahua.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class managerApplication {
    public static void main(String[] args) {
        SpringApplication.run(managerApplication.class,args);
    }
}
