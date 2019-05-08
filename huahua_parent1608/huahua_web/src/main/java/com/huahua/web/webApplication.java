package com.huahua.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class webApplication {
    public static void main(String[] args) {
        SpringApplication.run(webApplication.class,args  );
    }
}
