package cim.scloud.archaius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSwagger2
public class ArchaiusApp {
    public static void main( String[] args ){
    	 SpringApplication sa = new SpringApplication(ArchaiusApp.class);
    	 sa.addInitializers(new ConsulPropertySourceBootstrapInitializer());//读取配置文件
    	 sa.addListeners(new ConsulRegisterListener());//consul服务注册
    	 sa.run(args);
    }
}
