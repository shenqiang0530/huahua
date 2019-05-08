package com.huahua.friend.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Lenovo
 * \* Date: 2019/4/26
 * \* Time: 14:57
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {
    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtFilter).addPathPatterns("/**")
                .excludePathPatterns("/**/login");
    }
}
