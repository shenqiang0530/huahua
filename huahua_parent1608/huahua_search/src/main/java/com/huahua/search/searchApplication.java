package com.huahua.search;

import huahua.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class searchApplication {
    public static void main(String[] args) {
        SpringApplication.run(searchApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
