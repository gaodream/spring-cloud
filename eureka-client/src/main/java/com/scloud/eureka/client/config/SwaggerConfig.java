package com.scloud.eureka.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
// 不要继承extends WebMvcConfigurationSupport，特殊情况下继承非boot
public class SwaggerConfig {

	@Value("${swagger.ui.enable:false}") 
	private boolean externallyConfiguredFlag;// 该配置项在配置中心管理

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.scloud.eureka.client")).paths(PathSelectors.any())
				.build().enable(externallyConfiguredFlag);
	}

	private ApiInfo apiInfo() {  
	        return new ApiInfoBuilder()  
	                .title("scloud 接口")  
	                .termsOfServiceUrl("XZIT官网 http://blog.scloud.com/")  
	                .description("更多问题，请关注 : http://blog.scloud.com/")
	                .license("scloud 1.2.RELEASE")
	                .contact(new Contact("Dgao","", "gaogao@asiainfo.com"))
	                .version("1.2.RELEASE")
	                .build();  
	    }
}
