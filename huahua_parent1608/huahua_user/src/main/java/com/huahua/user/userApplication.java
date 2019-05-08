package com.huahua.user;
import huahua.common.utils.IdWorker;
import huahua.common.utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
public class userApplication {

	public static void main(String[] args) {
		SpringApplication.run(userApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

	@Bean
	public BCryptPasswordEncoder bc(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtUtil jwtUtil(){
		return new JwtUtil();
	}
}
