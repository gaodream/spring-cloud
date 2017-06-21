package com.scloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul功能：认证、压力测试、金丝雀测试、动态路由、负载削减、安全、静态响应处理、主动/主动交换管理
 * @author gaogao
 *
 */
@EnableZuulProxy  
@SpringBootApplication
public class ZuulApp {  
	
    public static void main(String[] args) {  
        SpringApplication.run(ZuulApp.class, args);  
    }  
} 
