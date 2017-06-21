package com.scloud.hystrix;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class HystrixService {
	
	private Random random = new Random();
	
	
    /**
     * fallbackMethod 降级方法
	 * commandProperties 普通配置属性，可以配置HystrixCommand对应属性，例如采用线程池还是信号量隔离、熔断器熔断规则等等
	 * ignoreExceptions 忽略的异常，默认HystrixBadRequestException不计入失败
     * groupKey() 组名称，默认使用类名称
     * commandKey 命令名称，默认使用方法名
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String getInfo(){
        int randomInt= random.nextInt(10) ;
        if(randomInt<8){  //模拟调用失败情况
            throw new RuntimeException("call dependency service fail.");
        }else{
            return "Hystrix:"+randomInt;
        }
    }

    public String fallback(){
        return "some exception occur call fallback method.";
    }

}
