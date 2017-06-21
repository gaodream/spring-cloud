package com.scloud.sleuth;

import org.springframework.boot.SpringApplication;

/**
 * Spring Cloud Sleuth 主要功能就是在分布式系统中提供追踪解决方案，并且兼容支持了 zipkin，你只需要在pom文件中引入相应的依赖即可。
 *
 */
public class SleuthApp {  
    public static void main(String[] args) {  
        SpringApplication.run(SleuthApp.class, args);  
    }  
} 

