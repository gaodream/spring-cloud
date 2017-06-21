package com.scloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableEurekaClient
@ComponentScan(value={"com.scloud.eureka.client"})//组件扫描  
public class EurekaClientApp {
	
	@Value("${words}") 
	private String words;
	
	@RequestMapping("/")
    public String getWord() {
        String[] wordArray = words.split(",");
        int i = (int)Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
	
	
    public static void main( String[] args ){
    	 SpringApplication.run(EurekaClientApp.class, args);
    }
}
