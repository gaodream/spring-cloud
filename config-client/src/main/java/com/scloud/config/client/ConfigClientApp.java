package com.scloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApp {
	
	@Value("${spring.cloud.remote.env.value:none}")
    private String value;
	
	
    @GetMapping(value = "/remote")
    public String hi(){
        return value;
    }
	
    public static void main( String[] args ){
    	 SpringApplication.run(ConfigClientApp.class, args);
    }
}
