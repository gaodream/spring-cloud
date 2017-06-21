package com.scloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Spring Cloud Bus：事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。
 * 依次启动eureka-server、confg-cserver,启动两个config-client，端口为：8881、8882。
 * 访问http://localhost:8881/hi 或者http://localhost:8882/hi 浏览器显示：
 * 这时我们去代码仓库将foo的值改为“foo version 4”，即改变配置文件foo的值。如果是传统的做法，可以需要重启服务，才能达到配置文件的更新。
 * 此时，我们只需要用post请求：http://localhost:8881/bus/refresh：
 * 另外，/bus/refresh接口可以指定服务，即使用”destination”参数，
 * 比如 “/bus/refresh?destination=customers:**” 即刷新服务名为customers的所有服务，不管ip。
 *
 */
@RefreshScope 
@SpringBootApplication
public class BusApp {
    public static void main( String[] args ){
    	 SpringApplication.run(BusApp.class,args);     
    }
}
