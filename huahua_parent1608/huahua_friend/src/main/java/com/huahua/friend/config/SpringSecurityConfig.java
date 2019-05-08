package com.huahua.friend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    /*
    * authorizeRequests 所有 security全注解配置实现的开始，表示开始说明需要的权限
    * antMatchers拦截路径 permitAll任何权限都可以访问，直接放行
    * anyRequest 所有的请求 authenticated 认证后才能访问
    * .and().csrf().disable();固定写法，表示使csrf 拦截失效
    * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }

}
